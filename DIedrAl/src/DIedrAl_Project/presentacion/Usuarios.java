package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.presentacion.Perfil.PerfilTransfer;


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
		title.setForeground(Color.WHITE);
		add(title, c);
		
		
		ImageButton nuevo = new ImageButton("A�adir", "images/bluebutton.png", "images/bluebutton2.png", this);
		nuevo.addActionListener((ae) -> {
			JFrame panel = new PantallaAdd();
			panel.setVisible(true);
			
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(25,15,0,0);
		c.ipady = 0;
		add(nuevo, c);
		
		
		
		ImageButton buscar = new ImageButton("Buscar", "images/orangebutton.png", "images/orangebutton2.png", this);
		buscar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 1;
		c.gridy = 1;
		add(buscar, c);
	}
	
	private class PantallaAdd extends JFrame{
		 /**
		 * 
		 */
		private static final long serialVersionUID = -945687595344304805L;
		
		// Variables declaration - do not modify    
	    private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
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
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    private javax.swing.JTextField jTextField4;
	    private javax.swing.JTextField jTextField7;
	    private javax.swing.JTextField jTextField8;
	    private javax.swing.JTextField jTextField9;
	    // End of variables declaration     
		public PantallaAdd(){
			initGUI();
		}
		private void initGUI(){
			 jScrollPane1 = new javax.swing.JScrollPane();
		        jList1 = new javax.swing.JList<>();
		        jScrollPane2 = new javax.swing.JScrollPane();
		        jTextArea1 = new javax.swing.JTextArea();
		        jScrollPane3 = new javax.swing.JScrollPane();
		        jTextArea2 = new javax.swing.JTextArea();
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
		        jButton1 = new javax.swing.JButton();
		        jLabel7 = new javax.swing.JLabel();
		        jLabel8 = new javax.swing.JLabel();
		        jLabel9 = new javax.swing.JLabel();
		        jTextField7 = new javax.swing.JTextField();
		        jTextField8 = new javax.swing.JTextField();
		        jTextField9 = new javax.swing.JTextField();

		        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		        setTitle("A�adir Usuario");

		        jList1.setModel(new javax.swing.AbstractListModel<String>() {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					
					String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
		            public int getSize() { return strings.length; }
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
		        jTextArea2.setText("Descripci�n");
		        jScrollPane3.setViewportView(jTextArea2);

		        jLabel1.setText("Despacho, horarios y otra informaci�n: ");

		        jLabel2.setText("Pacientes Asociados: ");

		        jLabel3.setText("Nombre: ");
		        
		        jLabel7.setText("Primer Apellido: ");
		        
		        jLabel8.setText("Segundo Apellido: ");
		        
		        jLabel9.setText("DNI: ");

		        jLabel4.setText("Rol: ");

		        jLabel5.setText("Email: ");

		        jLabel6.setText("Tel�fono: ");

		        jButton1.setText("Guardar");
		        jButton1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });

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
		                                    .addComponent(jLabel4)
		                                    .addComponent(jLabel5)
		                                    .addComponent(jLabel6))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
		                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
		                                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
		                                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
		                                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
		                                    .addComponent(jTextField2)
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
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel4)
		                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

		        pack();
		}
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
			
			//qu� hacemos con esto jList1.getSelectedValuesList()
			Usuario usuario = new Usuario(jTextField1.getText(), jTextField7.getText(), jTextField8.getText(), jTextField9.getText());
			
			usuario.setEmail(jTextField3.getText());
			usuario.setPerfil(jTextArea2.getText());
			usuario.setInfor(jTextArea1.getText());
			
			String tfo = jTextField4.getText();
			if(tfo.length()>0){
				usuario.setTfo(Integer.parseInt(tfo));
			}
			
			String rol = jTextField2.getText();
			if(rol.equals("admin") || rol.equals("Admin") || rol.equals("administrador") || rol.equals("Administrador") || rol.equals("ADMIN") || rol.equals("ADMINISTRADOR"))
				usuario.setAdmin();
		}     
	}
/*
	public class UsuarioTransfer{
		
		public UsuarioTransfer(String nombre, String rol, String email, String telefono,
				String descripcion, List<String> pacientes, String info) {
			this.nombre = nombre;
			this.rol = rol;
			this.email = email;
			this.telefono = telefono;
			this.descripcion = descripcion;
			this.pacientes = pacientes;
			this.info = info;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getRol() {
			return rol;
		}
		public void setRol(String rol) {
			this.rol = rol;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public List<String> getPacientes() {
			return pacientes;
		}
		public void setPacientes(List<String> pacientes) {
			this.pacientes = pacientes;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
		String nombre;
		String rol;
		String email;
		String telefono;
		String descripcion;
		List<String> pacientes;
		String info;
		
		
	}*/
}
