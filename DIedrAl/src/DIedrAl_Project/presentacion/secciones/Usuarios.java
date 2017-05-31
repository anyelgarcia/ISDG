package DIedrAl_Project.presentacion.secciones;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.ColorPanel;
import DIedrAl_Project.presentacion.auxiliar.Confirm;
import DIedrAl_Project.presentacion.auxiliar.Confirm.confirmListener;
import DIedrAl_Project.presentacion.auxiliar.ImageButton;
import DIedrAl_Project.presentacion.auxiliar.Modo;


public class Usuarios extends ColorPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5881613145077329549L;


	public Usuarios(int r, int g, int b){
		super(r, g, b);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Usuarios");
		title.setFont(font);
		title.setForeground(Color.BLACK);
		add(title, c);


		ImageButton buscar = new ImageButton("Consultar", "images/orangebutton.png", "images/orangebutton2.png", this);
		buscar.addActionListener((ae) -> {
			JFrame pantalla = new PantallaBuscar(Modo.BUSCAR);
			pantalla.setVisible(true);
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(25,15,0,0);
		c.ipadx = 5;
		c.ipady = 0;
		add(buscar, c);
	}
	

	/**
	 * Clase que gestiona la ventana que muestra los campos de un usuario. Se utiliza esta ventana tanto para
	 * añadir un usuario nuevo como para editar o consultar los datos de un usuario ya existente.
	 * @author Diedral_Group
	 * 
	 */  
	private class PantallaUsuario extends JFrame{
		
  
		/**
		 * 
		 */
		private static final long serialVersionUID = 2568326513524514651L;
		private javax.swing.JButton jButton1;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JLabel jLabel5;
		private javax.swing.JLabel jLabel6;
		private javax.swing.JLabel jLabel7;
		private javax.swing.JLabel jLabel8;
		private javax.swing.JLabel jLabel9;
		private javax.swing.JList<String> jList1;
		private javax.swing.JScrollPane jScrollPane1;
		private javax.swing.JScrollPane jScrollPane2;
		private javax.swing.JScrollPane jScrollPane3;
		private javax.swing.JTextArea jTextArea1;
		private javax.swing.JTextArea jTextArea2;
		private javax.swing.JTextField jTextField1;
		private javax.swing.JTextField jTextField3;
		private javax.swing.JTextField jTextField4;
		private javax.swing.JTextField jTextField7;
		private javax.swing.JTextField jTextField8;
		private javax.swing.JTextField jTextField9;
		private boolean editable;
		private Usuario u;
	    private Modo mode;    

		public PantallaUsuario(Usuario u, Modo m){
			this.u = u;
			mode = m;
			if(mode.equals(Modo.VISTA)) editable= false;
			else editable = true;

			initGUI();
		}
		private void initGUI(){
			jScrollPane1 = new javax.swing.JScrollPane();
			jList1 = new javax.swing.JList<>();
			jScrollPane2 = new javax.swing.JScrollPane();
			jTextArea1 = new javax.swing.JTextArea("");
			jScrollPane3 = new javax.swing.JScrollPane();
			jTextArea2 = new javax.swing.JTextArea("");
			jLabel1 = new javax.swing.JLabel();
			jLabel2 = new javax.swing.JLabel();
			jLabel3 = new javax.swing.JLabel();
			jLabel5 = new javax.swing.JLabel();
			jLabel6 = new javax.swing.JLabel();
			jTextField1 = new javax.swing.JTextField("");
			jTextField1.setEditable(editable);
			jTextField3 = new javax.swing.JTextField("");
			jTextField3.setEditable(editable);
			jTextField4 = new javax.swing.JTextField("");
			jTextField4.setEditable(editable);

			jButton1 = new javax.swing.JButton();
			jLabel7 = new javax.swing.JLabel();
			jLabel8 = new javax.swing.JLabel();
			jLabel9 = new javax.swing.JLabel();
			jTextField7 = new javax.swing.JTextField("");
			jTextField7.setEditable(editable);
			jTextField8 = new javax.swing.JTextField("");
			jTextField8.setEditable(editable);
			jTextField9 = new javax.swing.JTextField("");
			jTextField9.setEditable(editable);

			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			switch(mode){
				case ADD: setTitle("Crear Usuario"); break;
			    case VISTA: setTitle("Usuario"); break;
			    case EDITAR: setTitle("Ligar/Desligar Pacientes"); break;
			    default: new Error("Error en el modo en pantalla Usuarios"); break;
			}

			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				String[] strings = Controlador.getPacientesAsociados(u);
				public int getSize() { return strings!= null ? strings.length : 0; }
				public String getElementAt(int i) { return strings[i]; }
			});
			jList1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jList1.setToolTipText("");
			jScrollPane1.setViewportView(jList1);

			jTextArea1.setColumns(20);
			jTextArea1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
			jTextArea1.setRows(5);
			jScrollPane2.setViewportView(jTextArea1);

			jTextArea2.setColumns(20);
			jTextArea2.setRows(5);
			jTextArea2.setText("Descripción");
			jScrollPane3.setViewportView(jTextArea2);

			jLabel1.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel1.setText("Despacho, horarios y otra información: ");
			jLabel1.setForeground(Color.BLACK);

			jLabel2.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel2.setText("Pacientes Asociados: ");
			jLabel2.setForeground(Color.BLACK);

			jLabel3.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel3.setText("Nombre: ");
			jLabel3.setForeground(Color.BLACK);

			jLabel7.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel7.setText("Primer Apellido: ");
			jLabel7.setForeground(Color.BLACK);

			jLabel8.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel8.setText("Segundo Apellido: ");
			jLabel8.setForeground(Color.BLACK);

			jLabel9.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel9.setText("DNI: ");
			jLabel9.setForeground(Color.BLACK);

			jLabel5.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel5.setText("Email: ");
			jLabel5.setForeground(Color.BLACK);

			jLabel6.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel6.setText("Teléfono: ");
			jLabel6.setForeground(Color.BLACK);

			jButton1.setText("Guardar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
			
			if(u!=null){
				jTextField1.setText(u.getName());
				jTextField3.setText(u.getEmail());
				jTextField4.setText(u.getTfo());
				jTextField7.setText(u.getFirstSurname());
				jTextField8.setText(u.getSecondSurname());
				jTextField9.setText(u.getNif());
				jTextArea2.setText(u.getInfor());
				jTextArea1.setText(u.getPerfil());
			}
			
			jButton1.setVisible(editable);
		    jButton1.setEnabled(editable);

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
													.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
															.addGap(58, 58, 58)
															.addComponent(jLabel2))
															.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
																	.addGap(18, 18, 18)
																	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																			.addGroup(layout.createSequentialGroup()
																					.addComponent(jLabel1)
																					.addGap(0, 116, Short.MAX_VALUE))
																					.addComponent(jScrollPane2)))
																					.addGroup(layout.createSequentialGroup()
																							.addContainerGap()
																							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																									.addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
																									.addGroup(layout.createSequentialGroup()
																											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																													.addComponent(jLabel3)
																													.addComponent(jLabel7)
																													.addComponent(jLabel8)
																													.addComponent(jLabel9)
																													.addComponent(jLabel5)
																													.addComponent(jLabel6))
																													.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																													.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																															.addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
																															.addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
																															.addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
																															.addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
																															.addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
																															.addComponent(jTextField1))))))
																															.addContainerGap())
																															.addGroup(layout.createSequentialGroup()
																																	.addGap(273, 273, 273)
																																	.addComponent(jButton1)
																																	.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
			layout.setVerticalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(jLabel3)
									.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jLabel7)
											.addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(jLabel8)
													.addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
													.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
															.addComponent(jLabel9)
															.addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
															.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																			.addComponent(jLabel5)
																			.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																					.addComponent(jLabel6)
																					.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																					.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(jLabel1)
																							.addComponent(jLabel2))
																							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																									.addComponent(jScrollPane1)
																									.addComponent(jScrollPane2))
																									.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																									.addComponent(jButton1)
																									.addGap(7, 7, 7))
					);

			setVisible(true);
			pack();
		}
		/**
		 * Funcion que se ejecuta cuando se selecciona el boton guardar en la pantalla de paciente
		 */
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
			String nombre = jTextField1.getText();
			if(nombre.equals("")) new Error("Nombre vacio");
			else{
				Usuario usuario = new Usuario(nombre, jTextField7.getText(), jTextField8.getText(), jTextField9.getText());
	
				usuario.setEmail(jTextField3.getText());
				usuario.setPerfil(jTextArea1.getText());
				usuario.setInfor(jTextArea2.getText());
	
				String tfo = jTextField4.getText();
				if(tfo.length()>0){
					usuario.setTfo(tfo);
				}
				Controlador.addUsuario(usuario);
				dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		}     
	}
	
	/**
	 * Crea una pantalla en la que se permite buscar un usuario, para poder consultarlo
	 */
	public class PantallaBuscar extends JFrame implements confirmListener{
            
		/**
		 * 
		 */
		private static final long serialVersionUID = -3035898821023713008L;
		private javax.swing.JButton jButton1;
		private javax.swing.JButton jButton2;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JLabel jLabel4;
		private javax.swing.JLabel jLabel5;
		private javax.swing.JList<String> jList1;
		private javax.swing.JScrollPane jScrollPane1;
		private javax.swing.JTextField jTextField1;
		private javax.swing.JTextField jTextField2;
		private javax.swing.JTextField jTextField3;
		private javax.swing.JTextField jTextField4;
		private javax.swing.JTextField jTextField5;
		private javax.swing.JSeparator jSeparator2;
		private Usuario[] resultados;
		private Modo modo; 

		public PantallaBuscar(Modo modo){
			this.modo = modo;
			initGUI();
		}


		private void initGUI() {

			jTextField1 = new javax.swing.JTextField("");
			jTextField2 = new javax.swing.JTextField("");
			jTextField3 = new javax.swing.JTextField("");
			jTextField4 = new javax.swing.JTextField("");
			jTextField5 = new javax.swing.JTextField("");
			jLabel1 = new javax.swing.JLabel();
			jLabel2 = new javax.swing.JLabel();
			jLabel3 = new javax.swing.JLabel();
			jLabel4 = new javax.swing.JLabel();
			jLabel5 = new javax.swing.JLabel();
			jButton1 = new javax.swing.JButton();
			jScrollPane1 = new javax.swing.JScrollPane();
			jList1 = new javax.swing.JList<>();
			jButton2 = new javax.swing.JButton();
			jSeparator2 = new javax.swing.JSeparator();


			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Buscar Usuario");

			jLabel1.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel1.setText("Nombre:");
			jLabel1.setForeground(Color.BLACK);

			jLabel2.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel2.setText("Primer Apellido:");
			jLabel2.setForeground(Color.BLACK);

			jLabel3.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel3.setText("Segundo Apellido:");
			jLabel3.setForeground(Color.BLACK);

			jLabel4.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel4.setText("DNI:");
			jLabel4.setForeground(Color.BLACK);

			jLabel5.setFont(new java.awt.Font("Arial", 0, 10));
			jLabel5.setText("Solo Administradores (SI o NO):");
			jLabel5.setForeground(Color.BLACK);

			jButton1.setText("Buscar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});

			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				 /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				String[] strings = {  };
				 public int getSize() { return strings!= null ? strings.length : 0; }
				 public String getElementAt(int i) { return strings[i]; }
			});
			jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
			jScrollPane1.setViewportView(jList1);

			jButton2.setText("Confirmar");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton2ActionPerformed(evt);
				}
			});

			jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
									.addGroup(layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
													.addGroup(layout.createSequentialGroup()
															.addGap(21, 21, 21)
															.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																	.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
																	.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
																	.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
																	.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
																	.addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
																	.addGap(30, 30, 30)))
																	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																			.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
																			.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
																			.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
																			.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)	                            
																			.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
																			.addComponent(jButton1))
																			.addGap(35, 35, 35)
																			.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
																			.addGap(16, 16, 16)
																			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																					.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
																					.addComponent(jButton2))
																					.addContainerGap(29, Short.MAX_VALUE))
					);
			layout.setVerticalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
											.addGap(10, 10, 10)
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
													.addComponent(jLabel1))
													.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
													.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
															.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
															.addComponent(jLabel2))
															.addGap(11, 11, 11)
															.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																	.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																	.addComponent(jLabel3))
																	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																	.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																			.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																			.addComponent(jLabel4))
																			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																					.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																					.addComponent(jLabel5))
																					.addGap(0, 0, Short.MAX_VALUE))
																					.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																							.addContainerGap(16, Short.MAX_VALUE)
																							.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addGap(18, 18, 18)
																							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																									.addComponent(jButton2)
																									.addComponent(jButton1))))
																									.addGap(10, 10, 10))
																									.addComponent(jSeparator2)
					);
			getContentPane().setBackground(getColor());
			pack();
		}

		/**
		 * Función que se ejecuta al darle al botón buscar. Rellena un Usuario con los datos introducidos y 
		 * busca en el sistema a todos los que coincidan con él
		 */
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

			String nombre = jTextField1.getText();
			String apellido1 = jTextField2.getText();
			String apellido2 = jTextField3.getText();
			String DNI = jTextField4.getText();
			String admin = jTextField5.getText();

			ArrayList<String> campos = new ArrayList<String>();
			ArrayList<Hints> hints = new ArrayList<Hints>();
			Hints [] usuarios = null;

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

			if(admin.equals("Si")||  admin.equals("Sí") ||  admin.equals("SI") ||  admin.equals("SÍ")){
				usuarios = new Hints[1];
				usuarios[0] = Hints.ADMINISTRADOR;
			}else{
				usuarios = new Hints[1];
				usuarios[0] = Hints.USUARIO;
			}

			int i=0;
			Hints [] claves = new Hints[hints.size()];
			for(Hints hint: hints){
				claves[i] = hint;
				i++;
			}

			i=0;
			String [] valores = new String[hints.size()];
			for(String str: campos){
				valores[i] = str;
				i++;
			}

			ArrayList<Persona> res = Controlador.buscarUsuarios(claves, valores, usuarios);
			String[] cadenas = new String[res.size()];
			resultados = new Usuario[res.size()];
			i=0;
			for(Persona p: res){
				cadenas[i] = p.toString();
				resultados[i] = (Usuario)p;
				i++;
			}
			
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				String[] strings = cadenas;
				public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
			});
		}                                        

		/**
		 * Función que se ejecuta al seleccionar uno de los resultados de la búsqueda y pulsar el
		 * botón de confirmar Según el modo se hace una cosa u otra. 
		 * Si el modo es eliminar, se muestra una pantalla de confirmación.
		 * Si el modo es Editar o buscar, se crea una pantalla Usuario y se le pasa el control.
		 */
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
			int i = jList1.getSelectedIndex();
			Usuario u = resultados[i];
			PantallaUsuario j;
			switch(modo){
				case ELIMINAR:
					Confirm c = new Confirm();
					c.setMensaje("El paciente se eliminará del sistema.");
			    	c.setVisible(true);
			    	c.addListener(this);
			    	break;
				case EDITAR:
					j = new PantallaUsuario(u, Modo.EDITAR);
					j.setVisible(true);
					break;
				case BUSCAR:
					j = new PantallaUsuario(u, Modo.VISTA);
					j.setVisible(true);
					break;
				default:
					new Error("Error raro en el modo en búsqueda de usuarios");
					break;
				}
		}


		@Override
		public void delete() {
			int i = jList1.getSelectedIndex();
	    	Controlador.deleteUsuario(resultados[i]);
	    	this.dispose();
		}  
	}
}
