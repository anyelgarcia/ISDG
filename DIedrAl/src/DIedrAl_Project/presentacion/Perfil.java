package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.negocio.administracion.Usuario;


public class Perfil extends ColorPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1443115839427152482L;
	
	
	public Perfil(int r, int g, int b){
		super(r, g, b);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Mi Perfil");
		title.setFont(font);
		title.setForeground(Color.BLACK);
		add(title, c);
		
		ImageButton perfil = new ImageButton("Ver Perfil", "images/blackbutton.png", "images/blackbutton2.png", this);
		perfil.addActionListener((ae) -> {
			JFrame pantalla = new PantallaPerfil(false, Controlador.getUsuario());
			pantalla.setVisible(true);
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(25,15,0,0);
		c.ipady = 0;
		add(perfil, c);
		
		
		ImageButton editar = new ImageButton(" Editar  ", "images/orangebutton.png", "images/orangebutton2.png", this);
		editar.addActionListener((ae) -> {
			JFrame pantalla = new PantallaPerfil(true, Controlador.getUsuario());
			pantalla.setVisible(true);
		});
		c.gridx = 1;
		c.gridy = 1;
		add(editar, c);
	}
	
	private class PantallaPerfil extends JFrame{
		
		 /**
		 * 
		 */
		private static final long serialVersionUID = 8585905813285568257L;
		
		// Variables declaration - do not modify                     
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
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
	    private boolean editable;
	    private Usuario user;
	    // End of variables declaration  
	    
		public PantallaPerfil(boolean b, Usuario s){
			editable = b;
			user = s;
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

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
	        	/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				
				ArrayList<String> aux = Controlador.getPacientesAsociados(user);
				String[] strings = aux.toArray(new String[aux.size()]);
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jList1.setToolTipText("");
	        jScrollPane1.setViewportView(jList1);

	        jTextArea1.setEditable(editable);
	        jTextArea1.setColumns(20);
	        jTextArea1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
	        jTextArea1.setRows(5);
	        jScrollPane2.setViewportView(jTextArea1);

	        jTextArea2.setEditable(editable);
	        jTextArea2.setColumns(20);
	        jTextArea2.setRows(5);
	        jScrollPane3.setViewportView(jTextArea2);

	        jLabel1.setText("Despacho, horarios y otra información: ");

	        jLabel2.setText("Pacientes Asociados: ");

	        jLabel3.setText("Nombre y Apellidos: ");

	        jLabel4.setText("Rol: ");

	        jLabel5.setText("Email: ");

	        jLabel6.setText("Teléfono: ");

	        jTextField1.setEditable(false);
	        jTextField1.setText(user.getName() +" " + user.getFirstSurname() + " " + user.getSecondSurname());

	        jTextField2.setEditable(editable);
	        jTextField2.setText(user.isAdmin() ? "Administrador" : "Terapeuta");
	        
	        jTextField3.setEditable(editable);
	        jTextField3.setText(user.getEmail());
	        
	        jTextField4.setEditable(editable);
	        jTextField4.setText(user.getTfo());
	        
	        jTextArea1.setText(user.getPerfil());
      
	        jTextArea1.setEditable(editable);
	        
	        jTextArea2.setText(user.getInfor());
	        jTextArea2.setEditable(editable);
	  

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
	                                    .addComponent(jLabel4)
	                                    .addComponent(jLabel5)
	                                    .addComponent(jLabel6))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
	                                        .addComponent(jTextField2)
	                                        .addComponent(jTextField1)))))))
	                .addContainerGap())
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
	                    .addComponent(jScrollPane2)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
	                .addGap(21, 21, 21))
	        );
	        
	        getContentPane().setBackground(getColor());
	        pack();
	        setVisible(true);
		}
	}
	
}

