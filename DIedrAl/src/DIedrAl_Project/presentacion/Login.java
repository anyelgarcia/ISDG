package DIedrAl_Project.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.*;
import DIedrAl_Project.presentacion.Confirm.confirmListener;


public class Login extends JFrame{
	
	
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private ImagePanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    
    public void initComponents() {
    	
    	jPanel1 = new ImagePanel("images/bb.jpg");
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.add(jPanel1);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jLabel2.setText("Contraseña");

        jButton1.setFont(new java.awt.Font("Rockwell", 1, 20)); 
        jButton1.setText("Acceder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        jButton2.setFont(new java.awt.Font("SansSerif", 1, 11));
        jButton2.setText("Menú Administrador");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(72, 72, 72)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(82, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        this.setVisible(true);
        pack();              
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
    	
    	String nombreuser = jTextField1.getText();
		String clave = String.copyValueOf(jPasswordField1.getPassword());
		/*
		 * Usuario user = existeUsuario(nombreuser);
		SAPacientes saUsuarios = null;
		try {
			saUsuarios = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Usuario intento;
		try {
			intento = saUsuarios.getUsuarioConNIF(nombreuser);
		} catch (Exception e) {
			JFrame mensaje = new JFrame();
			JLabel jlabel = new JLabel("Usuario no registrado");
			mensaje.add(jlabel);
			mensaje.setVisible(true);
			mensaje.setSize(200, 100);
			mensaje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			return;
		}
		
		if(!intento.inputPassword(clave)){
			//mensaje de contraseña equivocada
			JFrame mensaje = new JFrame();
			JLabel jlabel = new JLabel("Contraseña equivocada");
			mensaje.add(jlabel);
			mensaje.setVisible(true);
			mensaje.setSize(200, 100);
			mensaje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			return;
		}

		Controlador.setUsuario(intento);*/
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		Main.run();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { 
    	JFrame minimenu = new PasswordFrame();
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    } 
    

	private class PasswordFrame extends javax.swing.JFrame {

		private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JPasswordField jPasswordField1;
	    
	    private PasswordFrame() {
	        init();
	    }
	    
	    private void init() {

	        jLabel1 = new javax.swing.JLabel();
	        jPasswordField1 = new javax.swing.JPasswordField();
	        jButton1 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 20)); 
	        jLabel1.setText("Introduzca la contraseña de administrador");

	        jPasswordField1.setText("jPasswordField1");

	        jButton1.setFont(new java.awt.Font("SansSerif", 1, 10));  
	        jButton1.setText("Aceptar");
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
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(31, 31, 31)
	                        .addComponent(jLabel1))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(82, 82, 82)
	                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(67, 67, 67)
	                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(31, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(53, 53, 53)
	                .addComponent(jLabel1)
	                .addGap(11, 11, 11)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(62, Short.MAX_VALUE))
	        );
	        
	        setVisible(true);
	        pack();
	    }

		private void jButton1ActionPerformed(ActionEvent evt) {
			
			String password = jPasswordField1.getPassword().toString();
			// Comprobar Contraseña es correcta
			JFrame minimenu = new CentroWindow();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}     
=======
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(25, 0, 0, 450);
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Helvetica", Font.BOLD, 20));
		panel.add(password,c);
		
		
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(5, 0, 0, 450);
		JPasswordField passwordText = new JPasswordField();
		passwordText.setPreferredSize(new Dimension (100, 20));
		panel.add(passwordText,c);
		
		
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(30, 0, 0, 450);
		ImageButton acceder = new ImageButton("Acceder", "images/whitebutton.png", "images/whitebutton2.png", panel);
		acceder.setForeground(Color.GRAY);
		panel.add(acceder,c);
		acceder.addActionListener((ae) -> {
			String nombreuser = usernameText.getText();
			String clave = String.copyValueOf(passwordText.getPassword());
			
			SAPacientes saUsuarios = null;
			try {
				saUsuarios = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Usuario intento;
			try {
				intento = saUsuarios.getUsuarioConNIF(nombreuser);
			} catch (Exception e) {
				JFrame mensaje = new JFrame();
				JLabel jlabel = new JLabel("Usuario no registrado");
				mensaje.add(jlabel);
				mensaje.setVisible(true);
				mensaje.setSize(200, 100);
				mensaje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				return;
			}
			
			if(!intento.inputPassword(clave)){
				//mensaje de contraseña equivocada
				JFrame mensaje = new JFrame();
				JLabel jlabel = new JLabel("Contraseña equivocada");
				mensaje.add(jlabel);
				mensaje.setVisible(true);
				mensaje.setSize(200, 100);
				mensaje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				return;
			}

			Controlador.setUsuario(intento);
			pantalla.dispatchEvent(new WindowEvent(pantalla, WindowEvent.WINDOW_CLOSING));
			entrar();
			
		});
		
		
		pantalla.setVisible(true);
		pantalla.setSize(1000, 760);
		pantalla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//TimeUnit.SECONDS.sleep(5);
		//pantalla.dispatchEvent(new WindowEvent(pantalla, WindowEvent.WINDOW_CLOSING));
		//entrar();
	}
	
	private class CentroWindow extends javax.swing.JFrame implements confirmListener{

		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JList<String> jList1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JSeparator jSeparator1;
	    
	    public CentroWindow() {
	        init();
	    }
	                         
	    private void init() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jSeparator1 = new javax.swing.JSeparator();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
	        	//Lista de centros
	            String[] strings = {  };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane1.setViewportView(jList1);

	        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jButton1.setText("Añadir Nuevo Centro");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });


	        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jButton2.setText("Eliminar Centro Seleccionado");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });


	        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(11, 11, 11)
	                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(14, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 0, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(79, 79, 79)
	                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(52, 52, 52)
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(29, 29, 29)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        setVisible(true);
	        pack();
	    }        
	    
		private void jButton1ActionPerformed(ActionEvent evt) {
			JFrame minimenu = new CentroAdd();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}

		private void jButton2ActionPerformed(ActionEvent evt) {
			if(jList1.getSelectedValue()!=null){
				Confirm c = new Confirm();
				c.setMensaje("El centro se eliminará definitivamente.");
		    	c.setVisible(true);
		    	c.addListener(this);
			}
		}

		@Override
		public void delete() {
			// Eliminar jList1.getSelectedValue();
		}        
	}
	
	private class CentroAdd extends javax.swing.JFrame {

		private javax.swing.JButton jButton1;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JPasswordField jPasswordField1;
		private javax.swing.JTextField jTextField1;
		private javax.swing.JTextField jTextField2;
		   
	   public CentroAdd() {
	       init();
	   }
	                       
	   private void init() {

	       jLabel1 = new javax.swing.JLabel();
	       jLabel2 = new javax.swing.JLabel();
	       jLabel3 = new javax.swing.JLabel();
	       jTextField1 = new javax.swing.JTextField();
	       jTextField2 = new javax.swing.JTextField();
	       jPasswordField1 = new javax.swing.JPasswordField();
	       jButton1 = new javax.swing.JButton();

	       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	       jLabel1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
	       jLabel1.setText("Nombre Nuevo Centro:");

	       jLabel2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
	       jLabel2.setText("NIF Administrador:");

	       jLabel3.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
	       jLabel3.setText("Contraseña Administrador:");

	       jButton1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
	       jButton1.setText("Validar");
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
	               .addGap(24, 24, 24)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
	                   .addGroup(layout.createSequentialGroup()
	                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                           .addComponent(jLabel1)
	                           .addComponent(jLabel2)
	                           .addComponent(jLabel3))
	                       .addGap(33, 33, 33)
	                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                           .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
	                           .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
	                           .addComponent(jTextField1))))
	               .addContainerGap(32, Short.MAX_VALUE))
	       );
	       layout.setVerticalGroup(
	           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(layout.createSequentialGroup()
	               .addGap(23, 23, 23)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(jLabel1)
	                   .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	               .addGap(36, 36, 36)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(jLabel2)
	                   .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	               .addGap(36, 36, 36)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(jLabel3)
	                   .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	               .addGap(27, 27, 27)
	               .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
	               .addContainerGap(24, Short.MAX_VALUE))
	       );

	       setVisible(true);
	       pack();
	   }  
	   
	   private void jButton1ActionPerformed(ActionEvent evt) {
		   
		   String nameCenter = jTextField1.getText();
		   String nifAdmin = jTextField2.getText();
		   String password = jPasswordField1.getPassword().toString();
		   
		   if(nameCenter!=null && nifAdmin!=null && password!=null){
			   
			   //buscar centro con ese nombre
			   
			   //si hay uno igual, mostramos mensaje mierda por pantalla
			   
			   //si no, lo creamos y volvemos a la pantalla anterior
			   
			   Login minimenu = new Login();
			   dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		   }
	   }
	}
	
}

