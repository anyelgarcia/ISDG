package DIedrAl_Project.presentacion.secciones;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DIedrAl_Project.presentacion.auxiliar.ColorPanel;
import DIedrAl_Project.presentacion.auxiliar.ImageButton;



public class Calendario extends ColorPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 197254297067260869L;
	public final static String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};	
	public final static String[] DIAS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public final static String[] ANOS = {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000"};



	public Calendario(int r, int g, int b){
		super(r, g, b);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Calendario");
		title.setFont(font);
		title.setForeground(Color.WHITE);
		add(title, c);


		ImageButton modificar = new ImageButton("Modificar", "images/bluebutton.png", "images/bluebutton2.png", this);
		modificar.addActionListener((ae) -> {

			PantallaModificar panel = new PantallaModificar();
			panel.setVisible(true);
			
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(25,15,0,0);
		c.ipady = 0;
		add(modificar, c);



		ImageButton consultar = new ImageButton("Consultar", "images/greenbutton.png", "images/greenbutton2.png", this);
		consultar.addActionListener((ae) -> {

			PantallaConsulta panel = new PantallaConsulta();
			panel.setVisible(true);

		});
		c.gridx = 1;
		c.gridy = 1;
		add(consultar, c);
	}

	@SuppressWarnings("serial")
	private class DateLabelFormatter extends AbstractFormatter {

		private String datePattern = "dd-MM-yyyy";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}


	/**
	 * Clase que se utiliza para consultar los datos de las sesiones planificadas.
	 * @author Diedral_Group
	 *
	 */
	@SuppressWarnings("serial")
	public class PantallaConsulta extends JFrame{

		                  
		private javax.swing.JButton jButton1;
		private javax.swing.JButton jButton3;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JList<String> jList2;
		private javax.swing.JScrollPane jScrollPane2;
		private javax.swing.JSeparator jSeparator2;
		private JDatePickerImpl datePicker; 
		private JDatePanelImpl jPanel2;


		public PantallaConsulta() {
	        initGUI();
	    }
	                            
	    private void initGUI() {

	        jScrollPane2 = new javax.swing.JScrollPane();
	        jList2 = new javax.swing.JList<>();
	        jSeparator2 = new javax.swing.JSeparator();
	        jLabel2 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();

	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setTitle("Consultar Calendario");

	        
	        UtilDateModel model = new UtilDateModel();
			GregorianCalendar fecha = new GregorianCalendar();

			model.setDate(Integer.parseInt(new SimpleDateFormat("yyyy").format(fecha.getTime())), 
					Integer.parseInt(new SimpleDateFormat("MM").format(fecha.getTime())) - 1, 
					Integer.parseInt(new SimpleDateFormat("dd").format(fecha.getTime())));

			Properties p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");

			jPanel2 = new JDatePanelImpl(model, p);
			datePicker = new JDatePickerImpl(jPanel2, new DateLabelFormatter());
			datePicker.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jDateActionPerformed(evt);
				}
			});

	        jList2.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { };
	            public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane2.setViewportView(jList2);

	        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

	        jLabel2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
	        jLabel2.setText("Sesiones del día:");
	        jLabel2.setForeground(Color.white);

	        jButton1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
	        jButton1.setText("Filtrar Calendario");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
	        jButton3.setText("Seleccionar");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(71, 71, 71)
	                        .addComponent(jButton1)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel2)
	                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(81, 81, 81)
	                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(22, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jSeparator2)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jLabel2)
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(30, 30, 30)
	                .addComponent(jButton3)
	                .addGap(32, 32, 32))
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addGap(30, 30, 30))
	        );
	        
	        getContentPane().setBackground(getColor());
	        pack(); 
	    }                       

	    private void jDateActionPerformed(java.awt.event.ActionEvent evt) {                                         
			Date selectedDate = (Date) datePicker.getModel().getValue();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(df.format(selectedDate));
		}  
	    
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    } 
	}

	/**
	 * Pantala que se utiliza para añadir, eliminar y editar las sesiones del calendario.
	 * @author Diedral_Group
	 *
	 */
	@SuppressWarnings("serial")
	public class PantallaModificar extends JFrame{

		                    
		private javax.swing.JButton jButton1;
		private javax.swing.JButton jButton3;
		private javax.swing.JButton jButton4;
		private javax.swing.JButton jButton5;
		private javax.swing.JButton jButton6;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JList<String> jList2;
		private javax.swing.JScrollPane jScrollPane2;
		private javax.swing.JSeparator jSeparator2;
		private JDatePickerImpl datePicker; 
		private JDatePanelImpl jPanel2;
		
		public PantallaModificar() {
			initGUI();
		}

		                       
		private void initGUI() {
			
			jScrollPane2 = new javax.swing.JScrollPane();
			jList2 = new javax.swing.JList<>();
			jSeparator2 = new javax.swing.JSeparator();
			jLabel2 = new javax.swing.JLabel();
			jButton1 = new javax.swing.JButton();
			jButton3 = new javax.swing.JButton();
			jButton4 = new javax.swing.JButton();
			jButton5 = new javax.swing.JButton();
			jButton6 = new javax.swing.JButton();

			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Modificar Calendario");

			
			UtilDateModel model = new UtilDateModel();
			GregorianCalendar fecha = new GregorianCalendar();

			model.setDate(Integer.parseInt(new SimpleDateFormat("yyyy").format(fecha.getTime())), 
					Integer.parseInt(new SimpleDateFormat("MM").format(fecha.getTime())) - 1, 
					Integer.parseInt(new SimpleDateFormat("dd").format(fecha.getTime())));

			Properties p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");

			jPanel2 = new JDatePanelImpl(model, p);
			datePicker = new JDatePickerImpl(jPanel2, new DateLabelFormatter());
			datePicker.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jDateActionPerformed(evt);
				}
			});
			

			jList2.setModel(new javax.swing.AbstractListModel<String>() {
				
				private static final long serialVersionUID = 1L;
				String[] strings = { };
				public int getSize() { return strings!= null ? strings.length : 0; }
				public String getElementAt(int i) { return strings[i]; }
			});
			jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
			jScrollPane2.setViewportView(jList2);

			jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

			jLabel2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
			jLabel2.setText("Sesiones del día:");

			jButton1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
			jButton1.setText("Filtrar Calendario");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButtonFiltrarActionPerformed(evt);
				}
			});

			jButton3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
			jButton3.setText("Consultar Selección");
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButtonConsultarActionPerformed(evt);
				}
			});

			jButton4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
			jButton4.setText("Eliminar Selección");
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButtonEliminarActionPerformed(evt);
				}
			});

			jButton5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
			jButton5.setText("Editar Selección");
			jButton5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButtonEditarActionPerformed(evt);
				}
			});

			jButton6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
			jButton6.setText("Añadir Sesión");
			jButton6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButtonAñadirActionPerformed(evt);
				}
			});

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
									.addGroup(layout.createSequentialGroup()
											.addContainerGap()
											.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
											.addGroup(layout.createSequentialGroup()
													.addGap(6, 6, 6)
													.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
													.addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
													.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
													.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
													.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(layout.createSequentialGroup()
																	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																			.addComponent(jLabel2)
																			.addGroup(layout.createSequentialGroup()
																					.addComponent(jButton5)
																					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																					.addComponent(jButton4))))
																					.addGroup(layout.createSequentialGroup()
																							.addGap(58, 58, 58)
																							.addComponent(jButton3))
																							.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																									.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
																									.addContainerGap(22, Short.MAX_VALUE))
					);
			layout.setVerticalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jSeparator2)
					.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
							.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jLabel2)
							.addGap(18, 18, 18)
							.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(jButton4)
									.addComponent(jButton5))
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(jButton3)
									.addGap(17, 17, 17))
									.addGroup(layout.createSequentialGroup()
											.addContainerGap()
											.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(jButton1)
													.addComponent(jButton6))
													.addGap(30, 30, 30))
					);

			getContentPane().setBackground(getColor());
			pack(); 
		}                    

		
		private void jDateActionPerformed(java.awt.event.ActionEvent evt) {                                         
			Date selectedDate = (Date) datePicker.getModel().getValue();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(df.format(selectedDate));
		}  
		
		private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
			
		}                                        

		private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {                                         
			
		}                                        

		private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                         
			
		}                                        

		private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {                                         
			
		}                                        

		private void jButtonAñadirActionPerformed(java.awt.event.ActionEvent evt) {                                         
			
		}         
	}
}

