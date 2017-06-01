package DIedrAl_Project.presentacion.secciones;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.calendario.SesionProgramada;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.recursos.ArraySesionesProgramadas;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.ColorPanel;
import DIedrAl_Project.presentacion.auxiliar.Confirm.confirmListener;
import DIedrAl_Project.presentacion.auxiliar.Confirm;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.presentacion.auxiliar.ImageButton;
import DIedrAl_Project.presentacion.auxiliar.Modo;



public class Calendario extends ColorPanel{

	
	private static final long serialVersionUID = 197254297067260869L;
	public final static String[] MESES = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};	
	public final static String[] DIAS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public final static String[] AÑOS = {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000"};



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

			new PantallaCalendario(true);
			
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(25,15,0,0);
		c.ipady = 0;
		add(modificar, c);



		ImageButton consultar = new ImageButton("Consultar", "images/greenbutton.png", "images/greenbutton2.png", this);
		consultar.addActionListener((ae) -> {

			new PantallaCalendario(false);

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
	public class PantallaCalendario extends JFrame implements confirmListener{

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
		private ArraySesionesProgramadas sesiones;
		String filtroPac;
		String filtroTer;


		public PantallaCalendario(boolean modo) {
			this.modo = modo;
			sesiones = new ArraySesionesProgramadas();
			filtroTer = "";
			filtroPac = "";
	        initGUI();
	    }
		
		public PantallaCalendario(boolean modo, String nifpac, String nifter) {
			this.modo = modo;
			sesiones = new ArraySesionesProgramadas();
			filtroPac = nifpac;
			filtroTer = nifter;
			System.out.println("pac" +nifpac + "ter" + nifter);
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

	        jButton5.setFont(new java.awt.Font("SansSerif", 1, 14)); 
	        jButton5.setText("Seleccionar");

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
	        
	        if(modo){
	        	jButton6.setVisible(false);
		        jButton6.setEnabled(false);
	        }else{
	        	jButton2.setVisible(false);
		        jButton2.setEnabled(false);
		        jButton3.setVisible(false);
		        jButton3.setEnabled(false);
		        jButton4.setVisible(false);
		        jButton4.setEnabled(false);
	        }

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
			DateFormat df = new SimpleDateFormat("dd/MMMMMMMMMMMM/yyyy");
			String[] fecha = df.format(selectedDate).split("/");
			sesiones = Controlador.getSesionesProgramadas(new Fecha(Integer.valueOf(fecha[0]), fecha[1], Integer.valueOf(fecha[2]), 0));
		
			if(!filtroPac.equals("")){
				ArraySesionesProgramadas aux = sesiones.filtrarNifPaciente(filtroPac);
				sesiones = aux;
			}
			
			if(!filtroTer.equals("")){
				ArraySesionesProgramadas aux = sesiones.filtrarNifTerapeuta(filtroTer);
				sesiones = aux;
			}
			
			String[] aux = new String[sesiones.size()]; int i = 0;
			for(SesionProgramada a : sesiones){
				aux[i] = a.toString();
				++i;
			}
			
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				private static final long serialVersionUID = 1L;
	            public int getSize() { return aux.length; }
	            public String getElementAt(int i) { return aux[i]; }
	        });
	    }  
	    
	    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	new PantallaFiltrarCalendario(modo);
	    	dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    }                                        

	    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        new MenuCalendario();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    } 
	    
	    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {  
	    	int i = jList1.getSelectedIndex();
	    	if(i!=-1){
		    	Confirm c = new Confirm();
				c.setMensaje("La sesión programada se eliminará del sistema.");
		    	c.setVisible(true);
		    	c.addListener(this);
	    	}else new Error("Selecciona una sesión");
	    }                                        

	    private void editarActionPerformed(java.awt.event.ActionEvent evt) {
	    	int i = jList1.getSelectedIndex();
	    	if(i!=-1){
	    		SesionProgramada a = getSelectedSesionProgramada(i, sesiones);
				new PantallaSesionProgramada(a, Modo.EDITAR);
				dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}else new Error("Selecciona una sesión");
	    	
	    } 
	    
	    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	int i = jList1.getSelectedIndex();
	    	if(i!=-1){
				SesionProgramada a = getSelectedSesionProgramada(i, sesiones);
				new PantallaSesionProgramada(a, Modo.VISTA);
				dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    	}else{new Error("Selecciona una sesión");}
	    }

	    @Override
		public void delete() {
			int i = jList1.getSelectedIndex();
			SesionProgramada a = getSelectedSesionProgramada(i, sesiones);
			Controlador.deleteSesionProgramada(a);
			this.dispose();
		}                                        

		private SesionProgramada getSelectedSesionProgramada(int i, ArraySesionesProgramadas sesiones){
			int j = 0;
			for(SesionProgramada a : sesiones){
				if(i == j){
					return a;
				}
				else ++j;
			}
			return null;
		}
	}                                        

	
	public class MenuCalendario extends javax.swing.JFrame {

		private static final long serialVersionUID = -5549824550280136895L;
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    
	    
	    public MenuCalendario() {
	        initGUI();
	    }
	    
	    private void initGUI() {

	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); 
	        jButton1.setText("Usar Plantilla de Sesión");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					antiguaActionPerformed(evt);
				}
			});

	        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14));
	        jButton2.setText("Crear desde cero");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					nuevaActionPerformed(evt);
				}
			});

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(98, 98, 98)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton1))
	                .addContainerGap(105, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(30, 30, 30)
	                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(29, Short.MAX_VALUE))
	        );

	        getContentPane().setBackground(new Color(255, 111, 105));
	        pack();
	        setVisible(true);
	    }
	    


		private void antiguaActionPerformed(ActionEvent evt) {
			new PantallaSesionBuscar(Modo.RETURN);
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		


		private void nuevaActionPerformed(ActionEvent evt) {
			new PantallaSesion(null, Modo.RETURN);
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			
		}
	}
	
	/**
     * Pantalla usada para filtrar las sesiones del calendario por un terapeuta y/o un paciente.
     * @author Diedral_Group
     *
     */
	private class PantallaFiltrarCalendario extends JFrame{
		
		private static final long serialVersionUID = 1704152667941046690L;
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JList<String> jList1;
	    private javax.swing.JList<String> jList2;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    private javax.swing.JTextField jTextField4;
	    private javax.swing.JTextField jTextField5;
	    private javax.swing.JTextField jTextField6;
	    private javax.swing.JTextField jTextField7;
	    private javax.swing.JTextField jTextField8;
	    private Paciente pacientes[];
	    private Usuario terapeutas[];
	    private boolean modo;
	    private String filtroPac;
	    private String filtroTer;
	    
	    public PantallaFiltrarCalendario(boolean modo){
	    	this.modo = modo;
	    	filtroPac = "";
	    	filtroTer = "";
	    	initGUI();
	    }
	    
	    private void initGUI() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jList2 = new javax.swing.JList<>();
	        jButton1 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jTextField2 = new javax.swing.JTextField();
	        jTextField3 = new javax.swing.JTextField();
	        jTextField4 = new javax.swing.JTextField();
	        jLabel7 = new javax.swing.JLabel();
	        jTextField5 = new javax.swing.JTextField();
	        jTextField6 = new javax.swing.JTextField();
	        jTextField7 = new javax.swing.JTextField();
	        jTextField8 = new javax.swing.JTextField();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel9 = new javax.swing.JLabel();
	        jLabel10 = new javax.swing.JLabel();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Filtrar Calendario");
	        
	        Hints hints1[] = {Hints.PACIENTE};
			String valores[] = {"comodín"};
			pacientes = Controlador.buscarPaciente(hints1, valores);
			Hints hints2[] = {Hints.USUARIO};
			terapeutas = Controlador.buscarUsuario(hints2, valores);

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
				private static final long serialVersionUID = 1L;
	            public int getSize() { return terapeutas!= null ? terapeutas.length : 0; }
	            public String getElementAt(int i) { return (terapeutas[i]).toString(); }
	        });
	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane1.setViewportView(jList1);

	        jList2.setModel(new javax.swing.AbstractListModel<String>() {
				private static final long serialVersionUID = 1L;
	            public int getSize() { return pacientes!= null ? pacientes.length : 0; }
	            public String getElementAt(int i) { return (pacientes[i]).toString(); }
	        });
	        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane2.setViewportView(jList2);

	        jButton1.setFont(new java.awt.Font("Rockwell", 1, 12)); 
	        jButton1.setText("Aplicar Filtro");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        
	        jButton4.setFont(new java.awt.Font("Rockwell", 1, 12)); 
	        jButton4.setText("Aplicar Filtro");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
	            }
	        });
	        
	        jButton6.setFont(new java.awt.Font("Rockwell", 1, 12)); 
	        jButton6.setText("Volver");
	        jButton6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton6ActionPerformed(evt);
	            }
	        });

	        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jLabel1.setText("Nombre:");

	        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jLabel2.setText("Primer Apellido:");

	        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jLabel3.setText("Segundo Apellido:");

	        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jLabel4.setText("DNI:");

	        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 14)); 
	        jLabel5.setText("Terapeutas");

	        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 14)); 
	        jLabel6.setText("Pacientes");

	        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jLabel7.setText("DNI:");

	        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jLabel8.setText("Nombre:");

	        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jLabel9.setText("Primer Apellido:");

	        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jLabel10.setText("Segundo Apellido:");

	        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jButton2.setText("Buscar");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jButton3.setText("Buscar");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jButton2)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGap(88, 88, 88)
	                .addComponent(jButton1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton6)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton4)
	                .addGap(200, 200, 200))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGap(0, 0, Short.MAX_VALUE)))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jLabel5)
	                        .addGap(25, 25, 25)))
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(58, 58, 58)
	                        .addComponent(jLabel6)
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(jButton3))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(33, 33, 33)
	                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                        .addGap(15, 15, 15))))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(13, 13, 13)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel5)
	                    .addComponent(jLabel6))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(13, 13, 13)
	                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(5, 5, 5)
	                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(13, 13, 13)
	                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(5, 5, 5)
	                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(18, 18, 18)
	                        .addComponent(jButton1))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(18, 18, 18)
	                        .addComponent(jButton4))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(5, 5, 5)
	                        .addComponent(jButton2))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(5, 5, 5)
	                        .addComponent(jButton3))
	                    .addGroup(layout.createSequentialGroup()
	                       	 .addGap(18, 18, 18)
	    	                 .addComponent(jButton6)))
	                    
	                .addContainerGap(28, Short.MAX_VALUE))
	        );
	        getContentPane().setBackground(new Color(255, 111, 105));
	        pack();
	        setVisible(true);
	    }

	    protected void jButton6ActionPerformed(ActionEvent evt) {
	    	new PantallaCalendario(modo, filtroPac, filtroTer);
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	    
		/**

	     * Función que se ejecuta al pulsar aplicar filtro bajo la lista de terapeutas.
	     * 
	     * @param evt
	     */
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 

	    	int i = jList1.getSelectedIndex();
	    	if(i!=(-1)){
		    	Usuario ter = terapeutas[i];
		    	filtroTer = ter.getNif();
		    	return;
	    	}
	    	new Error("Ha de elegirse un terapeuta");
	    }  
	    

		/**
	     * Función que se ejecuta al pulsar aplicar filtro bajo la lista de pacientes.
	     * 
	     * @param evt
	     */
	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) { 

	    	int j = jList2.getSelectedIndex();
	    	if(j!=(-1)){
		    	Paciente pac = pacientes[j];
		    	filtroPac = pac.getNif();
		    	return;
	    	}
	    	new Error("Ha de elegirse un paciente");
	    }  

	    /**
	     * Función que se ejecuta al buscar terapeutas, se comprueba el contenido de 
	     * cada campo, se seleccionan los filtros y se pasa el control al controlador.
	     * @param evt
	     */
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	String nombre = jTextField1.getText();
			String apellido1 = jTextField2.getText();
			String apellido2 = jTextField3.getText();
			String DNI = jTextField4.getText();

			ArrayList<String> campos = new ArrayList<String>();
			ArrayList<Hints> hints = new ArrayList<Hints>();

			if(nombre!=null && nombre.length()>0){
				campos.add(nombre);
				hints.add(Hints.NOMBRE);
			}

			if(apellido1!=null && apellido1.length()>0){
				campos.add(apellido1);
				hints.add(Hints.APELLIDO1);
			}

			if(apellido2!=null && apellido2.length()>0){
				campos.add(apellido2);
				hints.add(Hints.APELLIDO2);
			}

			if(DNI!=null && DNI.length()>0){
				campos.add(DNI);
				hints.add(Hints.NIF);
			}

			
			Hints [] claves = hints.toArray(new Hints[hints.size()]);
			String [] valores = campos.toArray(new String[campos.size()]);

			terapeutas = Controlador.buscarUsuario(claves, valores);
			
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				private static final long serialVersionUID = 1L;
	            public int getSize() { return terapeutas!= null ? terapeutas.length : 0; }
	            public String getElementAt(int i) { return (terapeutas[i]).toString(); }
	        });
	    }                                        

	    /**
	     * Función que se ejecuta al buscar pacientes. Funciona de forma parecida a la anterior, pero
	     * con diferentes textfields y buscando solo pacientes.
	     * @param evt
	     */
	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	String nombre = jTextField5.getText();
			String apellido1 = jTextField6.getText();
			String apellido2 = jTextField7.getText();
			String DNI = jTextField8.getText();

			ArrayList<String> campos = new ArrayList<String>();
			ArrayList<Hints> hints = new ArrayList<Hints>();

			if(nombre!=null && nombre.length()>0){
				campos.add(nombre);
				hints.add(Hints.NOMBRE);
			}

			if(apellido1!=null && apellido1.length()>0){
				campos.add(apellido1);
				hints.add(Hints.APELLIDO1);
			}

			if(apellido2!=null && apellido2.length()>0){
				campos.add(apellido2);
				hints.add(Hints.APELLIDO2);
			}

			if(DNI!=null && DNI.length()>0){
				campos.add(DNI);
				hints.add(Hints.NIF);
			}


			Hints [] claves = hints.toArray(new Hints[hints.size()]);
			String [] valores = campos.toArray(new String[campos.size()]);

			pacientes = Controlador.buscarPaciente(claves, valores);
			
			jList2.setModel(new javax.swing.AbstractListModel<String>() {
				private static final long serialVersionUID = 1L;
	            public int getSize() { return pacientes!= null ? pacientes.length : 0; }
	            public String getElementAt(int i) { return (pacientes[i]).toString(); }
	        });
	    }     
	}    
}
