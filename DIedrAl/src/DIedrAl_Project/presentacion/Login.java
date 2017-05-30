package DIedrAl_Project.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import DIedrAl_Project.integracion.AccessException;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAOrganizacion;
import DIedrAl_Project.presentacion.Confirm.confirmListener;


public class Login extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2735783534774038620L;
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private ImagePanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    
    public void init() {
    	
    	jPanel1 = new ImagePanel("images/bb.jpg");
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField("");
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.add(jPanel1);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jLabel1.setText("User  ");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jLabel2.setText("Password");

        jButton1.setFont(new java.awt.Font("Rockwell", 1, 20)); 
        jButton1.setText("Acceder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        jButton2.setFont(new java.awt.Font("SansSerif", 1, 11));
        jButton2.setText("Menu Administrador");
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
		
		SAOrganizacion saOrg = SAFactory.getInstancia().newSAOrganizacion();
		Usuario intento = null;
		try{
			intento = saOrg.existeUsuario(nombreuser);
		}catch(Exception e){
		} 
		
		if(intento==null){
			Error mensaje = new Error("No se ha encontrado al usuario en el sistema");
			return;
		}
		
		if(!intento.inputPassword(clave)){
			Error mensaje = new Error("Contrase�a equivocada");
			return;
		}

		Controlador.setUsuario(intento);
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		JFrame PantallaPrincipal = new MainFrame();
		PantallaPrincipal.setVisible(true);
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
	        jLabel1.setText("Introduzca el password de administrador");

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
			/*SAOrganizacion saOrg = SAFactory.getInstancia().newSAOrganizacion();
			if(!saOrg.inputPasswordGod(password)){
				Error msg = new Error("Contraseña Equivocada");
				msg.run();
				return;
			}*/
			JFrame minimenu = new MenuCentroUsuarios();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}     
	}
	
	private class MenuCentroUsuarios extends javax.swing.JFrame {
		
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
		
	    public MenuCentroUsuarios(){
	    	initGUI();
	    }

	    private void initGUI() {

	    	jButton1 = new javax.swing.JButton();
	    	jButton2 = new javax.swing.JButton();

	    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	    	jButton1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
	    	jButton1.setText("Menu Centros");
	    	jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	    	
	    	jButton2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
	        jButton2.setText("Menu Usuarios");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });
	
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(68, 68, 68)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
	                .addContainerGap(63, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(33, 33, 33)
	                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(37, 37, 37)
	                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(27, Short.MAX_VALUE))
	        );
	
	        pack();
	    }
	    
	    private void jButton1ActionPerformed(ActionEvent evt) {
			JFrame minimenu = new CentroWindow();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}    
	    
	    private void jButton2ActionPerformed(ActionEvent evt) {
			
			JFrame minimenu = new UsuarioWindow();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} 
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
	            //String[] strings = Controlador.getCentros();
	            String[] strings = {" "};
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane1.setViewportView(jList1);

	        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jButton1.setText("Crear Nuevo Centro");
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
			Controlador.deleteCentro(jList1.getSelectedValue());
		}        
	}
	
	private class CentroAdd extends javax.swing.JFrame {

		private javax.swing.JButton jButton1;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JPasswordField jPasswordField1;
		private javax.swing.JTextField jTextField1;
		   
	   public CentroAdd() {
	       init();
	   }
	                       
	   private void init() {

	       jLabel1 = new javax.swing.JLabel();
	       jLabel3 = new javax.swing.JLabel();
       
	       jTextField1 = new javax.swing.JTextField("");

	       jPasswordField1 = new javax.swing.JPasswordField();
	       jButton1 = new javax.swing.JButton();

	       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	       jLabel1.setFont(new java.awt.Font("Rockwell", 1, 14)); 
	       jLabel1.setText("Nombre Nuevo Centro:");

	       jLabel3.setFont(new java.awt.Font("Rockwell", 1, 14)); 
	       jLabel3.setText("Password Administrador:");

	       jButton1.setFont(new java.awt.Font("Rockwell", 0, 14)); 
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
	                           .addComponent(jLabel3))
	                       .addGap(33, 33, 33)
	                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                           .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
	                           .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
		   String password = jPasswordField1.getPassword().toString();
		   
		   if(nameCenter!=null && password!=null){
			   if(!Controlador.existeCentro(nameCenter)){
				   Controlador.createCentro(nameCenter, password);
				   Error nombreadmin = new Error("El identificador del administrador del nuevo centro es: " + nameCenter + "_ADMIN");
				   dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
				   new Login().init();
			   }else{
				   Error msg = new Error("Ya existe un centro con ese nombre");
			   }
		   }else{
			   Error msg = new Error("Han de rellenarse todos los campos");
		   }
	   }
	}
}

