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

			PantallaCalendario panel = new PantallaCalendario(true);
			
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(25,15,0,0);
		c.ipady = 0;
		add(modificar, c);



		ImageButton consultar = new ImageButton("Consultar", "images/greenbutton.png", "images/greenbutton2.png", this);
		consultar.addActionListener((ae) -> {

			PantallaCalendario panel = new PantallaCalendario(false);

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
	 * /**
	 * Clase que se utiliza para añadir, eliminar, editar y consultar
	 * las sesiones del calendario. Permite filtrado.
	 * 
	 * @author Diedral_Group
	 *
	 */
	public class PantallaCalendario extends JFrame{

		private static final long serialVersionUID = 1273499668115421332L;
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JList<String> jList1;
	    private JDatePanelImpl jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
		private JDatePickerImpl datePicker; 
		private boolean modo;
		//private sesionesprogramdas;


		public PantallaCalendario(boolean modo) {
			this.modo = modo;
	        initGUI();
	    }
	                            
	    private void initGUI() {

	        jButton5 = new javax.swing.JButton();
	        jSeparator1 = new javax.swing.JSeparator();
	        jSeparator2 = new javax.swing.JSeparator();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setTitle("Calendario");

	        
	        UtilDateModel model = new UtilDateModel();
			GregorianCalendar fecha = new GregorianCalendar();

			model.setDate(Integer.parseInt(new SimpleDateFormat("yyyy").format(fecha.getTime())), 
					Integer.parseInt(new SimpleDateFormat("MM").format(fecha.getTime())) - 1, 
					Integer.parseInt(new SimpleDateFormat("dd").format(fecha.getTime())));

			Properties p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");

			jPanel1 = new JDatePanelImpl(model, p);
			datePicker = new JDatePickerImpl(jPanel1, new DateLabelFormatter());
			datePicker.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jDateActionPerformed(evt);
				}
			});

	        jButton5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
	        jButton5.setText("Seleccionar");

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

	        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

	        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14));
	        jButton1.setText("Filtrar Calendario");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					filtrarActionPerformed(evt);
				}
			});

	        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); 
	        jButton2.setText("Añadir Sesión");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					añadirActionPerformed(evt);
				}
			});

	        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); 
	        jButton3.setText("Eliminar Sesión");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					eliminarActionPerformed(evt);
				}
			});

	        jButton4.setFont(new java.awt.Font("SansSerif", 1, 14)); 
	        jButton4.setText("Editar Sesión");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					editarActionPerformed(evt);
				}
			});

	        jButton6.setFont(new java.awt.Font("SansSerif", 1, 14)); 
	        jButton6.setText("Seleccionar");
	        jButton6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					seleccionarActionPerformed(evt);
				}
			});

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
				private static final long serialVersionUID = 1L;
				String[] strings = { };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        
	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane1.setViewportView(jList1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(26, 26, 26)
	                        .addComponent(jButton1)))
	                .addGap(27, 27, 27)
	                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jSeparator1)
	            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(55, 55, 55)
	                .addComponent(jButton2)
	                .addGap(32, 32, 32)
	                .addComponent(jButton3)
	                .addGap(29, 29, 29)
	                .addComponent(jButton6)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton4)
	                .addGap(48, 48, 48))
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButton1))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(33, 33, 33)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        
	        getContentPane().setBackground(getColor());
	        pack(); 
	        setVisible(true);
	    }                       

	    private void jDateActionPerformed(java.awt.event.ActionEvent evt) {                                         
			Date selectedDate = (Date) datePicker.getModel().getValue();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(df.format(selectedDate));
		}  
	    
	    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    } 
	    
	    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void editarActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    } 
	    
	    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	}

	
	public class MenuCalendario extends javax.swing.JFrame {

		private static final long serialVersionUID = -5549824550280136895L;
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    
	    
	    public MenuCalendario() {
	        initGUI();
	    }
	    
	    private void initGUI() {

	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
	        jButton1.setText("Usar Plantilla de Sesión");

	        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
	        jButton2.setText("Crear desde cero");

	        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
	        jButton3.setText("Volver");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(98, 98, 98)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton1)
	                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addContainerGap(105, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(30, 30, 30)
	                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(29, Short.MAX_VALUE))
	        );

	        pack();
	        setVisible(true);
	    }
	}
	
	
	public class PantallaSesionProgramada extends javax.swing.JFrame {

		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JComboBox<String> jComboBox1;
	    private javax.swing.JComboBox<String> jComboBox2;
	    private javax.swing.JComboBox<String> jComboBox3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel12;
	    private javax.swing.JLabel jLabel13;
	    private javax.swing.JLabel jLabel14;
	    private javax.swing.JLabel jLabel15;
	    private javax.swing.JLabel jLabel16;
	    private javax.swing.JLabel jLabel17;
	    private javax.swing.JLabel jLabel18;
	    private javax.swing.JLabel jLabel19;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel20;
	    private javax.swing.JLabel jLabel21;
	    private javax.swing.JLabel jLabel22;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JList<String> jList1;
	    private javax.swing.JList<String> jList2;
	    private javax.swing.JList<String> jList3;
	    private javax.swing.JList<String> jList4;
	    private javax.swing.JList<String> jList5;
	    private javax.swing.JList<String> jList6;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane10;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JScrollPane jScrollPane3;
	    private javax.swing.JScrollPane jScrollPane4;
	    private javax.swing.JScrollPane jScrollPane5;
	    private javax.swing.JScrollPane jScrollPane6;
	    private javax.swing.JScrollPane jScrollPane7;
	    private javax.swing.JScrollPane jScrollPane8;
	    private javax.swing.JScrollPane jScrollPane9;
	    private javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextArea jTextArea2;
	    private javax.swing.JTextArea jTextArea3;
	    private javax.swing.JTextArea jTextArea4;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField10;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    private javax.swing.JTextField jTextField4;
	    private javax.swing.JTextField jTextField5;
	    private javax.swing.JTextField jTextField6;
	    private javax.swing.JTextField jTextField7;
	    private javax.swing.JTextField jTextField8;
	    private javax.swing.JTextField jTextField9;  
	    
	    public PantallaSesionProgramada() {
	        initGUI();
	    }
	    
	    private void initGUI() {

	        jButton4 = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jTextArea2 = new javax.swing.JTextArea();
	        jLabel4 = new javax.swing.JLabel();
	        jScrollPane3 = new javax.swing.JScrollPane();
	        jTextArea3 = new javax.swing.JTextArea();
	        jLabel5 = new javax.swing.JLabel();
	        jScrollPane4 = new javax.swing.JScrollPane();
	        jTextArea4 = new javax.swing.JTextArea();
	        jLabel6 = new javax.swing.JLabel();
	        jScrollPane5 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        jScrollPane6 = new javax.swing.JScrollPane();
	        jList2 = new javax.swing.JList<>();
	        jTextField1 = new javax.swing.JTextField();
	        jTextField2 = new javax.swing.JTextField();
	        jLabel7 = new javax.swing.JLabel();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel9 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jComboBox1 = new javax.swing.JComboBox<>();
	        jComboBox2 = new javax.swing.JComboBox<>();
	        jComboBox3 = new javax.swing.JComboBox<>();
	        jLabel10 = new javax.swing.JLabel();
	        jScrollPane7 = new javax.swing.JScrollPane();
	        jList3 = new javax.swing.JList<>();
	        jScrollPane8 = new javax.swing.JScrollPane();
	        jList4 = new javax.swing.JList<>();
	        jScrollPane9 = new javax.swing.JScrollPane();
	        jList5 = new javax.swing.JList<>();
	        jScrollPane10 = new javax.swing.JScrollPane();
	        jList6 = new javax.swing.JList<>();
	        jLabel11 = new javax.swing.JLabel();
	        jLabel12 = new javax.swing.JLabel();
	        jLabel13 = new javax.swing.JLabel();
	        jLabel14 = new javax.swing.JLabel();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton5 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();
	        jLabel15 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField();
	        jLabel16 = new javax.swing.JLabel();
	        jTextField4 = new javax.swing.JTextField();
	        jLabel17 = new javax.swing.JLabel();
	        jTextField5 = new javax.swing.JTextField();
	        jLabel18 = new javax.swing.JLabel();
	        jTextField6 = new javax.swing.JTextField();
	        jLabel19 = new javax.swing.JLabel();
	        jTextField7 = new javax.swing.JTextField();
	        jLabel20 = new javax.swing.JLabel();
	        jTextField8 = new javax.swing.JTextField();
	        jLabel21 = new javax.swing.JLabel();
	        jTextField9 = new javax.swing.JTextField();
	        jLabel22 = new javax.swing.JLabel();
	        jTextField10 = new javax.swing.JTextField();

	        jButton4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jButton4.setText("Quitar");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
	            }
	        });

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel1.setText("Nombre:");
	        jLabel1.setToolTipText("");

	        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel2.setText("Duración:");
	        jLabel2.setToolTipText("");

	        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel3.setText("Descripción:");
	        jLabel3.setToolTipText("");

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        jTextArea2.setColumns(20);
	        jTextArea2.setRows(5);
	        jScrollPane2.setViewportView(jTextArea2);

	        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel4.setText("Descripción:");
	        jLabel4.setToolTipText("");

	        jTextArea3.setColumns(20);
	        jTextArea3.setRows(5);
	        jScrollPane3.setViewportView(jTextArea3);

	        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel5.setText("Desarrollo de la Sesión");
	        jLabel5.setToolTipText("");

	        jTextArea4.setColumns(20);
	        jTextArea4.setRows(5);
	        jScrollPane4.setViewportView(jTextArea4);

	        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel6.setText("Posibles Variaciones");
	        jLabel6.setToolTipText("");

	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane5.setViewportView(jList1);

	        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane6.setViewportView(jList2);

	        jTextField1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextField1ActionPerformed(evt);
	            }
	        });

	        jTextField2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextField2ActionPerformed(evt);
	            }
	        });

	        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel7.setText("minutos");

	        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel8.setText("Recursos Empleados");
	        jLabel8.setToolTipText("");

	        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel9.setText("Actividadess Empleadas");
	        jLabel9.setToolTipText("");

	        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jButton1.setText("Guardar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel10.setText("Fecha:");

	        jList3.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane7.setViewportView(jList3);

	        jList4.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane8.setViewportView(jList4);

	        jList5.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane9.setViewportView(jList5);

	        jList6.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane10.setViewportView(jList6);

	        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel11.setText("Pacientes:");
	        jLabel11.setToolTipText("");

	        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel12.setText("Terapeutas:");
	        jLabel12.setToolTipText("");

	        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel13.setText("Búsqueda (pacientes):");
	        jLabel13.setToolTipText("");

	        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel14.setText("Búsqueda (terapeutas):");
	        jLabel14.setToolTipText("");

	        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jButton2.setText("Quitar");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jButton3.setText("Quitar");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        jButton5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jButton5.setText("Añadir");
	        jButton5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton5ActionPerformed(evt);
	            }
	        });

	        jButton6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jButton6.setText("Añadir");
	        jButton6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton6ActionPerformed(evt);
	            }
	        });

	        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel15.setText("Nombre:");
	        jLabel15.setToolTipText("");

	        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel16.setText("Primer Apellido:");
	        jLabel16.setToolTipText("");

	        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel17.setText("Segundo Apellido:");
	        jLabel17.setToolTipText("");

	        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel18.setText("DNI:");
	        jLabel18.setToolTipText("");

	        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel19.setText("Nombre:");
	        jLabel19.setToolTipText("");

	        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel20.setText("Primer Apellido:");
	        jLabel20.setToolTipText("");

	        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel21.setText("Segundo Apellido:");
	        jLabel21.setToolTipText("");

	        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
	        jLabel22.setText("DNI:");
	        jLabel22.setToolTipText("");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel1)
	                        .addGap(18, 18, 18)
	                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel2)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jLabel7))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel10)
	                        .addGap(22, 22, 22)
	                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(10, 10, 10)
	                                        .addComponent(jLabel8)))
	                                .addGap(18, 18, 18)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(10, 10, 10)
	                                        .addComponent(jLabel9))))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(45, 45, 45)
	                                        .addComponent(jLabel3))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(10, 10, 10)
	                                        .addComponent(jLabel5))
	                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGap(18, 18, 18)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(45, 45, 45)
	                                        .addComponent(jLabel4))))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(10, 10, 10)
	                                        .addComponent(jLabel6)))))
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(99, 99, 99)
	                                .addComponent(jButton2)
	                                .addGap(105, 105, 105)
	                                .addComponent(jButton5))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addGap(54, 54, 54)
	                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addGap(98, 98, 98)
	                                                .addComponent(jLabel11)))
	                                        .addGap(18, 18, 18)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                                .addComponent(jLabel13)
	                                                .addGap(29, 29, 29))))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(54, 54, 54)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addGap(35, 35, 35)
	                                                .addComponent(jLabel12)))
	                                        .addGap(18, 18, 18)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addGap(14, 14, 14)
	                                                .addComponent(jLabel14)))))
	                                .addGap(29, 29, 29)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel19)
	                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel15)
	                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel16)
	                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel17)
	                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel18)
	                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel20)
	                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel21)
	                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel22)
	                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jButton1)
	                        .addGap(370, 370, 370)
	                        .addComponent(jButton3)
	                        .addGap(95, 95, 95)
	                        .addComponent(jButton6)))
	                .addContainerGap(57, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel4)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel1)
	                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel2)
	                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel7))
	                        .addGap(15, 15, 15)
	                        .addComponent(jLabel3)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jLabel6)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(211, 211, 211)
	                        .addComponent(jLabel5)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel11)
	                            .addComponent(jLabel13)
	                            .addComponent(jLabel15))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGap(13, 13, 13)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(jButton2)
	                                    .addComponent(jButton5)))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jLabel16)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel17)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel18)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel8)
	                            .addComponent(jLabel9))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(jLabel10)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel12)
	                            .addComponent(jLabel14))
	                        .addGap(20, 20, 20)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel19)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel20)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel21)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel22)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jButton1)
	                        .addContainerGap())
	                    .addGroup(layout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jButton6)
	                            .addComponent(jButton3))
	                        .addContainerGap(13, Short.MAX_VALUE))))
	        );

	        setVisible(true);
	        pack();
	    }                      

	    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
	        // TODO add your handling code here:
	    }                                           

	    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
	        // TODO add your handling code here:
	    }                                           

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                        

	    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // TODO add your handling code here:
	    }                                                      
	     
	}
}

