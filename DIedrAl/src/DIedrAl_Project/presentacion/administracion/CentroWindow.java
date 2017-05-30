package DIedrAl_Project.presentacion.administracion;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.Confirm;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.presentacion.auxiliar.Modo;
import DIedrAl_Project.presentacion.auxiliar.Confirm.confirmListener;

/**
 * Pantalla para trabajar con los centros. Muestra una lista con todos los centros del sistema, permite
 * añadir nuevos centros y eliminar centros existentes. El modo ADD permite eliminar y crear centros. El modo BUSCAR
 * se utiliza por la clase UsuarioWindow para seleccionar el centro con cuyos usuarios se va a trabajar.
 * @author Diedral_Group
 *
 */
public class CentroWindow extends javax.swing.JFrame implements confirmListener{

	
	private static final long serialVersionUID = 2988221819930414226L;
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private Modo modo;
    
    CentroWindow(Modo modo) {
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
            
			private static final long serialVersionUID = 1L;
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
        
        //El modo Buscar solo permite seleccionar un centro.
        if(modo.equals(Modo.BUSCAR)){
        	jButton1.setVisible(false);
	        jButton1.setEnabled(false);
	        jButton2.setVisible(false);
	        jButton2.setEnabled(false);
        }
        //El modo Add permite añadir y eliminar centros.
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

    /**
     * Se delega añadir un centro en otra ventana.
     * @param evt
     */
	private void jButton1ActionPerformed(ActionEvent evt) {
		new CentroAdd();
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	/**
	 * Se pide confirmación para eliminar (Ver función delete)
	 * @param evt
	 */
	private void jButton2ActionPerformed(ActionEvent evt) {
		
		if(jList1.getSelectedIndex()!= -1){
			Confirm c = new Confirm();
			c.setMensaje("El centro se eliminará definitivamente.");
	    	c.setVisible(true);
	    	c.addListener(this);
	    	
		}
	}
	
	/**
	 * Para seleccionar un centro. Una vez elegido se abre la pantalla de gestión de
	 * usuarios.
	 * @param evt
	 */
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

    /**
     * Una vez confirmado, se elimina el centro.
     */
	@Override
	public void delete() {
		Controlador.deleteCentro(jList1.getSelectedValue());
		jList1.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] strings = Controlador.getCentros();
            public int getSize() { return strings!= null ? strings.length : 0; }
            public String getElementAt(int i) { return strings[i]; }
        });
	} 
	
	
	/**
	 * Clase que contiene la pantalla que se utiliza para añadir un centro nuevo. Se introducen el 
	 * nombre del centro y la contraseña del administrador.
	 * @author Diedral_Group
	 *
	 */
	private class CentroAdd extends javax.swing.JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2197428728727796142L;
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
}