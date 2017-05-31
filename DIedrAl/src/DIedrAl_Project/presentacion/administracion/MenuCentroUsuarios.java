package DIedrAl_Project.presentacion.administracion;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import DIedrAl_Project.presentacion.auxiliar.Modo;

/**
 * Clase sencilla que muestra una pantalla en la que permite elegir entre dos opciones: Una
 * para trabajar con centros y la otra para usuarios.
 * @author Diedral_Group
 *
 */
public class MenuCentroUsuarios extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7519617227782866567L;
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
    	jButton1.setText("Menú Centros");
    	jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    	
    	jButton2.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jButton2.setText("Menú Usuarios");
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
    
    /**
     * Crea una pantalla para trabajar con centros.
     * @param evt
     */
    private void jButton1ActionPerformed(ActionEvent evt) {
		new CentroWindow(Modo.ADD);
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}    
    
    /**
     * Crea una pantalla para trabajar con usuarios.
     * @param evt
     */
    private void jButton2ActionPerformed(ActionEvent evt) {
		new CentroWindow(Modo.BUSCAR);
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	} 
}

