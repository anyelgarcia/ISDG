package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.presentacion.Confirm.confirmListener;


/**
 * Esta clase lleva la gesti�n de las vistas de las sesiones. En el constructor se dibuja la secci�n de Sesiones del Men� Principal y se pone a la espera para 
 * a�adir, eliminar, editar o buscar sesiones.
 * @author Diedral_Group
 *
 */
public class Sesiones extends ColorPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7805554218246174830L;
  
	
	public Sesiones(int r, int g, int b){
			super(r, g, b);
			
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 3;
			c.ipady= 20;
			c.insets = new Insets(0,15,0,0);
			JLabel title = new JLabel("Sesiones");
			title.setFont(font);
			title.setForeground(Color.WHITE);
			add(title, c);
			
			
			
			ImageButton nuevo = new ImageButton("  Crear  ", "images/bluebutton.png", "images/bluebutton2.png", this);
			nuevo.addActionListener((ae) -> {
				JFrame pantalla = new PantallaAdd();
				pantalla.setVisible(true);
			});
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.insets = new Insets(25,15,0,0);
			c.ipady = 0;
			add(nuevo, c);
			
			
			
			ImageButton buscar = new ImageButton(" Buscar  ", "images/greenbutton.png", "images/greenbutton2.png", this);
			buscar.addActionListener((ae) -> {
				JFrame panel = new JFrame();
				
				panel.setSize(300, 400);
				panel.setVisible(true);
				panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			});
			c.gridx = 1;
			c.gridy = 1;
			add(buscar, c);
			
			
			
			ImageButton eliminar = new ImageButton("Eliminar", "images/tanbutton.png", "images/tanbutton2.png", this);
			eliminar.addActionListener((ae) -> {
				JFrame panel = new PantallaEliminar();
				panel.setVisible(true);
			});
			c.gridx = 0;
			c.gridy = 2;
			add(eliminar, c);
			setVisible(true);
		}
		
		
	
	/**
	 * Clase que gestiona la ventana que aparece al darle al bot�n -A�adir- en la secci�n -Sesiones- del M�n� Principal
	 * @author Diedral_Group
	 * 
	 */
		private class PantallaAdd extends JFrame{
			 /**
			 * 
			 */
			private static final long serialVersionUID = -4494007563168661421L;
			
			// Variables declaration - do not modify                     
		    private javax.swing.JButton jButton1;
		    private javax.swing.JLabel jLabel1;
		    private javax.swing.JLabel jLabel3;
		    private javax.swing.JLabel jLabel4;
		    private javax.swing.JLabel jLabel5;
		    private javax.swing.JLabel jLabel6;
		    private javax.swing.JLabel jLabel7;
		    private javax.swing.JLabel jLabel8;
		    private javax.swing.JLabel jLabel9;		 
		    private javax.swing.JLabel jLabel11;
		    private javax.swing.JList<String> jList1;
		    private javax.swing.JList<String> jList2;
		    private javax.swing.JScrollPane jScrollPane1;
		    private javax.swing.JScrollPane jScrollPane2;
		    private javax.swing.JScrollPane jScrollPane3;
		    private javax.swing.JScrollPane jScrollPane4;
		    private javax.swing.JScrollPane jScrollPane5; 
		    private javax.swing.JScrollPane jScrollPane6;
		    private javax.swing.JTextArea jTextArea1;
		    private javax.swing.JTextArea jTextArea3;
		    private javax.swing.JTextArea jTextArea4;
		    private javax.swing.JTextArea jTextArea5;
		    private javax.swing.JTextField jTextField1;
		    private javax.swing.JTextField jTextField2;
		    // End of variables declaration        
		    
			public PantallaAdd(){
				initGUI();
			}
			private void initGUI(){
				jLabel1 = new javax.swing.JLabel();
		        jLabel3 = new javax.swing.JLabel();
		        jButton1 = new javax.swing.JButton();
		        jTextField1 = new javax.swing.JTextField();
		        jTextField2 = new javax.swing.JTextField();
		        jLabel4 = new javax.swing.JLabel();
		        jLabel5 = new javax.swing.JLabel();
		        jScrollPane1 = new javax.swing.JScrollPane();
		        jTextArea1 = new javax.swing.JTextArea();
		        jLabel6 = new javax.swing.JLabel();
		        jLabel7 = new javax.swing.JLabel();
		        jScrollPane3 = new javax.swing.JScrollPane();
		        jTextArea3 = new javax.swing.JTextArea();
		        jScrollPane4 = new javax.swing.JScrollPane();
		        jTextArea4 = new javax.swing.JTextArea();
		        jScrollPane2 = new javax.swing.JScrollPane();
		        jList1 = new javax.swing.JList<>();
		        jScrollPane5 = new javax.swing.JScrollPane();
		        jList2 = new javax.swing.JList<>();
		        jLabel8 = new javax.swing.JLabel();
		        jLabel9 = new javax.swing.JLabel();
		        jLabel11 = new javax.swing.JLabel();
		        jScrollPane6 = new javax.swing.JScrollPane();
		        jTextArea5 = new javax.swing.JTextArea();

		        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		        setTitle("Crear Sesi�n");
		        setName("Crear Actividad"); // NOI18N

		        jLabel1.setText("Nombre: ");

		        jLabel3.setText("Duraci�n:");

		        jButton1.setText("Guardar");
		        jButton1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });

		        jLabel4.setText("minutos");

		        jLabel5.setText("Descripci�n: ");

		        jTextArea1.setColumns(20);
		        jTextArea1.setRows(5);
		        jScrollPane1.setViewportView(jTextArea1);

		        jLabel6.setText("Desarrollo de la Sesi�n");

		        jLabel7.setText("Posibles Variaciones");

		        jTextArea3.setColumns(20);
		        jTextArea3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
		        jTextArea3.setRows(5);
		        jTextArea3.setAutoscrolls(false);
		        jScrollPane3.setViewportView(jTextArea3);

		        jTextArea4.setColumns(20);
		        jTextArea4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
		        jTextArea4.setRows(5);
		        jTextArea4.setAutoscrolls(false);
		        jTextArea4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		        jScrollPane4.setViewportView(jTextArea4);
		        jTextArea4.getAccessibleContext().setAccessibleParent(jTextArea1);

		        jScrollPane2.setViewportView(jList1);

		        jScrollPane5.setViewportView(jList2);

		        jLabel8.setText("Recursos Empleados");

		        jLabel9.setText("Actividades Empleadas");
		        
		        jLabel11.setText("Etiquetas: ");
		        
		        jTextArea5.setColumns(20);
		        jTextArea5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
		        jTextArea5.setRows(5);
		        jTextArea5.setAutoscrolls(false);
		        jScrollPane6.setViewportView(jTextArea5);

		        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		        getContentPane().setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addGap(11, 11, 11)
		                .addComponent(jLabel1)
		                .addGap(18, 18, 18)
		                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(0, 10, Short.MAX_VALUE))
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                		.addGroup(layout.createSequentialGroup()
		    	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
		    	    	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		    	    	                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
		                    .addGroup(layout.createSequentialGroup()
		                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                .addContainerGap())
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
		                .addGap(10, 10, 10)
		                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addContainerGap())
		            .addGroup(layout.createSequentialGroup()
		                .addGap(42, 42, 42)
		                .addComponent(jLabel6)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(jLabel7)
		                .addGap(54, 54, 54))
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(layout.createSequentialGroup()
		                        .addComponent(jLabel3)
		                        .addGap(18, 18, 18)
		                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addComponent(jLabel4))
		                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
		        	                .addGap(32, 32, 32)
		        	                .addComponent(jLabel5)
		        	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
		        	                .addComponent(jLabel11)
		        	                .addGap(45, 45, 45)))
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		            .addGroup(layout.createSequentialGroup()
		                .addGap(48, 48, 48)
		                .addComponent(jLabel8)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(jLabel9)
		                .addGap(42, 42, 42))
		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(jButton1)
		                .addGap(152, 152, 152))
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel1)
		                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel3)
		                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jLabel4))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			                    .addComponent(jLabel5)
			                    .addComponent(jLabel11))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                    .addGroup(layout.createSequentialGroup()
		                    		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		    		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    		                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
		    		                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                            .addComponent(jLabel6)
		                            .addComponent(jLabel7))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
		                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel8)
		                    .addComponent(jLabel9))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(18, 18, 18)
		                .addComponent(jButton1)
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );

		        pack();
			}
			
			/**
			 * Funci�n que se ejecuta al darle a guardar en la ventana de adici�n de sesiones. Se rellena un objeto sesi�n y es pasado al controlador.
			 * */
			private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
				
				String etiquetasSinFormato = jTextArea5.getText();
				String etiquetas[] = etiquetasSinFormato.split(",");
				Sesion info = new Sesion(String.valueOf(jTextField1.getText()), etiquetas);
				
				String duracion = String.valueOf(jTextField2.getText());

				//Esta excepci�n hay que capturarla
				if(duracion.length()>0 ){
					info.setDuracion(Integer.valueOf(duracion));
				}
				
				info.setDescripcion(String.valueOf(jTextArea1.getText()));
				info.setDesarrollo(String.valueOf(jTextArea4.getText()));
				info.setVariaciones(String.valueOf(jTextArea3.getText()));
				Controlador.addSesion(info);
			} 
		}
		/*
		public class SesionTransfer{
			
			private String nombre;
			private int minutos;
			private String descripcion;
			private String desarrollo;
			private String posiblesVariaciones;
			

			public SesionTransfer(String nombre, int minutos,
					String descripcion, String desarrollo,
					String posiblesVariaciones) {
				
				this.nombre = nombre;
				this.minutos = minutos;
				this.descripcion = descripcion;
				this.desarrollo = desarrollo;
				this.posiblesVariaciones = posiblesVariaciones;
			}
			

			public String getNombre() {
				return nombre;
			}

			public int getMinutos() {
				return minutos;
			}

			public String getDescripcion() {
				return descripcion;
			}

			public String getDesarrollo() {
				return desarrollo;
			}

			public String getPosiblesVariaciones() {
				return posiblesVariaciones;
			}
			
		}*/

		/**
		 * 
		 * Ventana que sale al pulsar el bot�n eliminar en la secci�n Sesiones en el men� principal.
		 * @author Diedral_Group
		 *
		 */
		private class PantallaEliminar extends JFrame implements confirmListener{
			/**
			 * 
			 */
			private static final long serialVersionUID = -6239847431534738736L;
			// Variables declaration - do not modify                     
		    private javax.swing.JButton jButton1;
		    private javax.swing.JLabel jLabel1;
		    private javax.swing.JLabel jLabel2;
		    private javax.swing.JTextField jTextField1;
		    // End of variables declaration     
		    
		    public PantallaEliminar() {
		        initComponents();
		    }
		    /**
		     * This method is called from within the constructor to initialize the form.
		     * WARNING: Do NOT modify this code. The content of this method is always
		     * regenerated by the Form Editor.
		     */                        
		    private void initComponents() {

		        jLabel1 = new javax.swing.JLabel();
		        jTextField1 = new javax.swing.JTextField();
		        jButton1 = new javax.swing.JButton();
		        jLabel2 = new javax.swing.JLabel();

		        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		        setTitle("Eliminar Sesi�n");

		        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

		        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		        jButton1.setText("Eliminar");
		        jButton1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });

		        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		        jLabel2.setText("Introduzca el nombre de la sesi�n");

		        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		        getContentPane().setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(layout.createSequentialGroup()
		                        .addContainerGap()
		                        .addComponent(jLabel1))
		                    .addGroup(layout.createSequentialGroup()
		                        .addGap(151, 151, 151)
		                        .addComponent(jButton1)))
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
		                .addGap(0, 60, Short.MAX_VALUE)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
		                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addGap(57, 57, 57))
		                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
		                        .addComponent(jLabel2)
		                        .addGap(92, 92, 92))))
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addComponent(jLabel1)
		                .addGap(16, 16, 16)
		                .addComponent(jLabel2)
		                .addGap(18, 18, 18)
		                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(26, 26, 26)
		                .addComponent(jButton1)
		                .addContainerGap(31, Short.MAX_VALUE))
		        );

		        pack();
		    }                      

		    /**
		     * Se llama a esta funci�n al introducir un nombre de sesi�n para eliminar en la ventana de eliminaci�n de Sesiones. Pide confirmaci�n.
		     * @param evt
		     */
		    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		    	Confirm c = new Confirm();
		    	c.setVisible(true);
		    	c.addListener(this);
		    }  
		    
		    /**
		     * Se llama a esta funci�n al pulsar el bot�n -S�- en confirmar. Le dice al controlador que elimine la sesi�n.
		     */
		    public void delete(){
		    	Controlador.deleteSesion(jTextField1.getText());
		    	this.dispose();
		    }
		    
		}
}
