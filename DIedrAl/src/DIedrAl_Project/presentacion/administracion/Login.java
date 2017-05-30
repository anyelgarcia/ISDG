package DIedrAl_Project.presentacion.administracion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAOrganizacion;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.MainFrame;
import DIedrAl_Project.presentacion.auxiliar.Confirm;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.presentacion.auxiliar.ImagePanel;
import DIedrAl_Project.presentacion.auxiliar.Modo;
import DIedrAl_Project.presentacion.auxiliar.Confirm.confirmListener;


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
        setTitle("Login");
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
		/*
		if(!Controlador.usuarioCorrecto(nombreuser, clave)){
			return;
		}
		*/
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
	        setTitle("Contraseña Administrador");

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
				new Error("Contraseña Equivocada");
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
	    	setTitle("Menú Centros y Usuarios");

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
			new CentroWindow(Modo.ADD);
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}    
	    
	    private void jButton2ActionPerformed(ActionEvent evt) {
			new CentroWindow(Modo.BUSCAR);
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} 
	}

	
	private class CentroWindow extends javax.swing.JFrame implements confirmListener{

		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JList<String> jList1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JSeparator jSeparator1;
	    private Modo modo;
	    
	    public CentroWindow(Modo modo) {
	    	this.modo = modo;
	        init();
	    }
	                         
	    private void init() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jSeparator1 = new javax.swing.JSeparator();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        switch(modo){
			    case ADD: setTitle("Centros"); break;
			    case BUSCAR: setTitle("Elija un centro con el que trabajar"); break;
			    default: new Error("Error en modo en pantalla centros"); break;
	        }

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = Controlador.getCentros();
	            public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

	        jButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); 
	        jButton3.setText("Validar Selección");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });
	        
	        if(modo.equals(Modo.BUSCAR)){
	        	jButton1.setVisible(false);
		        jButton1.setEnabled(false);
		        jButton2.setVisible(false);
		        jButton2.setEnabled(false);
	        }
	        if(modo.equals(Modo.ADD)){
	        	jButton3.setVisible(false);
		        jButton3.setEnabled(false);
	        }

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
	                	.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
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
	                        .addGap(32, 32, 32)
	                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(32, 32, 32)
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
		
	    private void jButton3ActionPerformed(ActionEvent evt) {
	    	if(jList1.getSelectedIndex()!=-1){
				Usuario fantasma = new Usuario("", "", "", "");
				fantasma.setCentro(jList1.getSelectedValue());
				Controlador.setUsuario(fantasma);
				new UsuarioWindow();
				dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    	}else{
	    		new Error("Selecciona al menos un centro");
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
	       setTitle("Añadir Centro");

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
				   new Error("El identificador del administrador del nuevo centro es: " + nameCenter + "_ADMIN");
				   new MenuCentroUsuarios();
				   dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			   }
		   }else{
			   new Error("Han de rellenarse todos los campos");
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
	    	new PantallaBuscar(Modo.ADD);
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	    }  
	    
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	new PantallaBuscar(Modo.ELIMINAR);
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
	    private javax.swing.JButton jButton4;
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

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Ligar Pacientes y Terapeutas");

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
	        	Hints hints[] = {Hints.USUARIO};
	            String[] strings = Controlador.buscarPaciente(new Hints[0], new String[0], hints);
	            public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane1.setViewportView(jList1);

	        jList2.setModel(new javax.swing.AbstractListModel<String>() {
	        	Hints hints[] = {Hints.PACIENTE};
	            String[] strings = Controlador.buscarPaciente(new Hints[0], new String[0], hints);
	            public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane2.setViewportView(jList2);

	        jButton1.setFont(new java.awt.Font("Rockwell", 1, 12)); 
	        jButton1.setText("   Ligar  ");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        
	        jButton4.setFont(new java.awt.Font("Rockwell", 1, 12)); 
	        jButton4.setText("Desligar");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
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
	                .addGap(88, 88, 88)
	                .addComponent(jButton1)
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
	                        .addComponent(jButton3)))
	                .addContainerGap(28, Short.MAX_VALUE))
	        );
	        pack();
	        setVisible(true);
	    }

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
	    	int i = jList1.getSelectedIndex();
	    	int j = jList2.getSelectedIndex();
	    	if(i!=(-1) && j!=(-1)){
		    	Usuario usr = terapeutas[i];
		    	Paciente pac = pacientes[j];
		    	Controlador.ligar(usr, pac);
		    	return;
	    	}
	    	new Error("Han de elegirse un terapeuta y un paciente");
	    }  

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	String nombre = jTextField1.getText();
			String apellido1 = jTextField2.getText();
			String apellido2 = jTextField3.getText();
			String DNI = jTextField4.getText();

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

			usuarios = new Hints[1];
			usuarios[0] = Hints.USUARIO;
			

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
			terapeutas = new Usuario[res.size()];
			i=0;
			for(Persona p: res){
				cadenas[i] = res.toString();
				terapeutas[i] = (Usuario)p;
				i++;
			}
			
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				String[] strings = cadenas;
				public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
			});
	    }                                        

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	String nombre = jTextField5.getText();
			String apellido1 = jTextField6.getText();
			String apellido2 = jTextField7.getText();
			String DNI = jTextField8.getText();

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

			usuarios = new Hints[1];
			usuarios[0] = Hints.PACIENTE;

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
			pacientes = new Paciente[res.size()];
			i=0;
			for(Persona p: res){
				cadenas[i] = res.toString();
				pacientes[i] = (Paciente)p;
				i++;
			}
			
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				String[] strings = cadenas;
				public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
			});
	    }  
	    
	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) { 
	    	int i = jList1.getSelectedIndex();
	    	int j = jList2.getSelectedIndex();
	    	if(i!=(-1) && j!=(-1)){
		    	Usuario usr = terapeutas[i];
		    	Paciente pac = pacientes[j];
		    	Controlador.desligar(usr, pac);
		    	return;
	    	}
	    	new Error("Han de elegirse un terapeuta y un paciente");
	    }  

	       
	}
	
	/**
	 * Clase que gestiona la ventana que muestra los campos de un usuario. Se utiliza esta ventana tanto para
	 * añadir un usuario nuevo como para editar o consultar los datos de un usuario ya existente.
	 * @author Diedral_Group
	 * 
	 */  
	private class PantallaUsuario extends JFrame{
		
  
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
			jTextField3 = new javax.swing.JTextField("");
			jTextField4 = new javax.swing.JTextField("");

			jButton1 = new javax.swing.JButton();
			jLabel7 = new javax.swing.JLabel();
			jLabel8 = new javax.swing.JLabel();
			jLabel9 = new javax.swing.JLabel();
			jTextField7 = new javax.swing.JTextField("");
			jTextField8 = new javax.swing.JTextField("");
			jTextField9 = new javax.swing.JTextField("");

			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			switch(mode){
				case ADD: setTitle("Crear Usuario"); break;
			    case VISTA: setTitle("Usuario"); break;
			    case EDITAR: setTitle("Ligar/Desligar Pacientes"); break;
			    default: new Error("Error en el modo en pantalla Usuarios"); break;
			}

			jList1.setModel(new javax.swing.AbstractListModel<String>() {

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

		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   

			Usuario usuario = new Usuario(jTextField1.getText(), jTextField7.getText(), jTextField8.getText(), jTextField9.getText());

			usuario.setEmail(jTextField3.getText());
			usuario.setPerfil(jTextArea1.getText());
			usuario.setInfor(jTextArea2.getText());

			String tfo = jTextField4.getText();
			if(tfo.length()>0){
				usuario.setTfo(tfo);
			}
			
			Controlador.addUsuario(usuario);
		}     
	}
	
	public class PantallaBuscar extends JFrame implements confirmListener{
        
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
			setVisible(true);
			pack();
		}

		/**
		 * Función que se ejecuta al darle al botón buscar. Rellena un Usuario con los datos introducidos y 
		 * busca en el sistema a todos los que coincidan con él.
		 * @param evt
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

			if(admin.equals("Si")||  admin.equals("Sí") ||  admin.equals("SI") ||  admin.equals("Sí")){
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
				cadenas[i] = res.toString();
				resultados[i] = (Usuario)p;
				i++;
			}
			
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				
				String[] strings = cadenas;
				public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
			});
		}                                        

		/**
		 * Función que se ejecuta al seleccionar uno de los resultados de la búsqueda y pulsar el
		 * botón de validar. Según el modo se hace una cosa u otra. 
		 * Si el modo es eliminar, se muestra una pantalla de confirmación.
		 * Si el modo es Editar o buscar, se crea una pantalla Usuario y se le pasa el control.
		 * @param evt
		 */
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
			int i = jList1.getSelectedIndex();
			Usuario u = resultados[i];
			switch(modo){
				case ELIMINAR:
					Confirm c = new Confirm();
					c.setMensaje("El paciente se eliminará del sistema.");
			    	c.setVisible(true);
			    	c.addListener(this);
			    	break;
				case EDITAR:
					new PantallaUsuario(u, Modo.EDITAR);
					break;
				case BUSCAR:
					new PantallaUsuario(u, Modo.VISTA);
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


