package DIedrAl_Project.presentacion.administracion;

import java.awt.Color;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.presentacion.auxiliar.Modo;


/**
 * Clase que gestiona la ventana que muestra los campos de un usuario. Se utiliza esta ventana tanto para
 * añadir un usuario nuevo como para consultar los datos de un usuario ya existente.
 * @author Diedral_Group
 * 
 */  
public class PantallaUsuario extends JFrame{
	 
	private static final long serialVersionUID = 2137978232214942058L;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabel10;
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
	private javax.swing.JPasswordField jPasswordField5;
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
		jTextField3 = new javax.swing.JTextField("");
		jTextField4 = new javax.swing.JTextField("");
		jPasswordField5 = new javax.swing.JPasswordField("");

		jButton1 = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField("");
		jTextField8 = new javax.swing.JTextField("");
		jTextField9 = new javax.swing.JTextField("");
		jLabel10 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		switch(mode){
			case ADD: setTitle("Crear Usuario"); break;
		    case VISTA: setTitle("Usuario"); break;
		    default: new Error("Error en el modo en pantalla Usuarios"); break;
		}

		if(mode.equals(Modo.ADD)){
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				private static final long serialVersionUID = 1L;
				String[] strings = {""};
				public int getSize() { return strings!= null ? strings.length : 0; }
				public String getElementAt(int i) { return strings[i]; }
			});
		}else{
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				private static final long serialVersionUID = 1L;
				String[] strings = Controlador.getPacientesAsociados(u);
				public int getSize() { return strings!= null ? strings.length : 0; }
				public String getElementAt(int i) { return strings[i]; }
			});
		}
		
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

		jLabel10.setFont(new java.awt.Font("Arial", 0, 10));
		jLabel10.setText("Contraseña: ");
		jLabel10.setForeground(Color.BLACK);
		
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
		
		if(!editable){
			jTextField1.setEditable(false);
			jTextField7.setEditable(false);
			jTextField8.setEditable(false);
			jTextField9.setEditable(false);
			jButton1.setVisible(false);
	        jButton1.setEnabled(false);
		}

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
																												.addComponent(jLabel10)
																												.addComponent(jLabel7)
																												.addComponent(jLabel8)
																												.addComponent(jLabel9)
																												.addComponent(jLabel5)
																												.addComponent(jLabel6))
																												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																														.addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
																														.addComponent(jPasswordField5, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
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
										.addComponent(jLabel10)
										.addComponent(jPasswordField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
	 * Función que se lanza al pulsar el botón de guardar. Se recoge el contenido de los
	 * campos de texto y se pasan al controlador para que cree el usuario.
	 * @param evt
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   

		
		if(!jTextField1.getText().equals("") && !jTextField9.getText().equals("") && !String.valueOf(jPasswordField5.getPassword()).equals("")){
			Usuario usuario = new Usuario(jTextField1.getText(), jTextField7.getText(), jTextField8.getText(), jTextField9.getText());
	
			usuario.setPassword(String.valueOf(jPasswordField5.getPassword()));
			usuario.setEmail(jTextField3.getText());
			usuario.setPerfil(jTextArea1.getText());
			usuario.setInfor(jTextArea2.getText());
	
			String tfo = jTextField4.getText();
			if(tfo.length()>0){
				usuario.setTfo(tfo);
			}
			Controlador.addUsuario(usuario);
			new Error("El nuevo usuario ha sido creado");
			new MenuCentroUsuarios();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}else{
			new Error("Han de llenarse los campos de nombre, contraseña y DNI");
		}
	} 
	
	
}