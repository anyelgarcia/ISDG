package DIedrAl_Project.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import DIedrAl_Project.integracion.AccessException;
import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAOrganizacion;
import DIedrAl_Project.presentacion.Confirm.confirmListener;


@SuppressWarnings("serial")
public class Login extends JFrame{
	
	
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
		
		if(!Controlador.usuarioCorrecto(nombreuser, clave)){
			return;
		}
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		MainFrame.main();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { 
    	new PasswordFrame();
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

	        jPasswordField1.setText("");

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
			
			String password = String.valueOf(jPasswordField1.getPassword());
			SAOrganizacion saOrg = SAFactory.getInstancia().newSAOrganizacion();
			if(!saOrg.inputPasswordGod(password)){
				Error msg = new Error("Contraseña Equivocada");
				msg.run();
				return;
			}
			new MenuCentroUsuarios();
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

	    	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	    	jButton1.setFont(new java.awt.Font("SansSerif", 1, 20)); 
	    	jButton1.setText("Menu Centros");
	    	jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	    	
	    	jButton2.setFont(new java.awt.Font("SansSerif", 1, 20)); 
	        jButton2.setText("Menu Usuarios");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
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
	                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(37, 37, 37)
	                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(27, Short.MAX_VALUE))
	        );
	        setVisible(true);
	        pack();
	    }
	    
	    private void jButton1ActionPerformed(ActionEvent evt) {
			new CentroWindow();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}    
	    
	    private void jButton2ActionPerformed(ActionEvent evt) {
			new UsuarioWindow();
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
			new CentroAdd();
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

	       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
				   nombreadmin.run();
				   new MenuCentroUsuarios();
				   dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			   }
		   }else{
			   Error msg = new Error("Han de rellenarse todos los campos");
			   msg.run();
		   }
	   }
	}
	
	private class UsuarioWindow extends javax.swing.JFrame {

		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    
	    public UsuarioWindow() {
	        initGUI();
	    }
                      
	    private void initGUI() {

	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jButton1.setFont(new java.awt.Font("Rockwell", 1, 14)); 
	        jButton1.setText("Añadir Usuario");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setFont(new java.awt.Font("Rockwell", 1, 14)); 
	        jButton2.setText("Eliminar Usuario");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setFont(new java.awt.Font("Rockwell", 1, 14)); 
	        jButton3.setText("Ligar Pacientes/Terapeutas");
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
	                .addGap(53, 53, 53)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jButton1)
	                        .addGap(53, 53, 53)
	                        .addComponent(jButton2)))
	                .addContainerGap(41, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(41, 41, 41)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton1)
	                    .addComponent(jButton2))
	                .addGap(28, 28, 28)
	                .addComponent(jButton3)
	                .addContainerGap(40, Short.MAX_VALUE))
	        );

	        setVisible(true);
	        pack();
	    }

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	//new UsuarioBusqueda(); añadir
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    }  
	    
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	//new UsuarioLigarDesligar(); eliminar
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    }  
	    
	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	new UsuarioLigarDesligar();
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    }  
                  
	}
	
	
	private class UsuarioLigarDesligar extends JFrame{
		
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
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
	    
	    public UsuarioLigarDesligar(){
	    	initGUI();
	    }
	    
	    private void initGUI() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jList2 = new javax.swing.JList<>();
	        jButton1 = new javax.swing.JButton();
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

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
	        	Hints hints[] = {Hints.USUARIO};
	            String[] strings = Controlador.buscarPaciente(new Hints[0], new String[0], hints);
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane1.setViewportView(jList1);

	        jList2.setModel(new javax.swing.AbstractListModel<String>() {
	        	Hints hints[] = {Hints.PACIENTE};
	            String[] strings = Controlador.buscarPaciente(new Hints[0], new String[0], hints);
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane2.setViewportView(jList2);

	        jButton1.setFont(new java.awt.Font("Rockwell", 1, 12)); 
	        jButton1.setText("Validar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
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
	        jLabel5.setText("TERAPEUTAS");

	        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 14)); 
	        jLabel6.setText("PACIENTES");

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
	                .addComponent(jButton1)
	                .addGap(260, 260, 260))
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
	                        .addGap(3, 3, 3)
	                        .addComponent(jButton2))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(5, 5, 5)
	                        .addComponent(jButton3)))
	                .addContainerGap(28, Short.MAX_VALUE))
	        );

	        setVisible(true);
	        pack();
	    }

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
	    	//Validar
	    }  

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // Buscar terap
	    }                                        

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        // Buscar pac
	    }                                        

	       
	}
}

