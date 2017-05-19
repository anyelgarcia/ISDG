package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.presentacion.Recursos.RecursoTransfer;


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
				JFrame panel = new JFrame();
				
				panel.setSize(300, 400);
				panel.setVisible(true);
				panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			});
			c.gridx = 0;
			c.gridy = 2;
			add(eliminar, c);
			setVisible(true);
		}
		
		
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
		    private javax.swing.JList<String> jList1;
		    private javax.swing.JList<String> jList2;
		    private javax.swing.JScrollPane jScrollPane1;
		    private javax.swing.JScrollPane jScrollPane2;
		    private javax.swing.JScrollPane jScrollPane3;
		    private javax.swing.JScrollPane jScrollPane4;
		    private javax.swing.JScrollPane jScrollPane5;
		    private javax.swing.JTextArea jTextArea1;
		    private javax.swing.JTextArea jTextArea3;
		    private javax.swing.JTextArea jTextArea4;
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

		        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		        setTitle("Crear Sesión");
		        setName("Crear Actividad"); // NOI18N

		        jLabel1.setText("Nombre: ");

		        jLabel3.setText("Duración:");

		        jButton1.setText("Guardar");
		        jButton1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });

		        jLabel4.setText("minutos");

		        jLabel5.setText("Descripción: ");

		        jTextArea1.setColumns(20);
		        jTextArea1.setRows(5);
		        jScrollPane1.setViewportView(jTextArea1);

		        jLabel6.setText("Desarrollo de la Sesión");

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
		                    .addComponent(jScrollPane1)
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
		                    .addComponent(jLabel5))
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
		                .addComponent(jLabel5)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                    .addGroup(layout.createSequentialGroup()
		                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
			private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
				
				String desarroll = jTextArea3.getText();
				String desarrollo[] = desarroll.split("\n");
				String variacione = jTextArea4.getText();
				String variaciones[] = variacione.split("\n");
				Controlador.addSesion(new SesionTransfer(String.valueOf(jTextField1.getText()), Integer.parseInt(String.valueOf(jTextField2.getText())), String.valueOf(jTextArea1.getText()), desarrollo, variaciones));
			} 
		}
		
		public class SesionTransfer{
			
			private String nombre;
			private int minutos;
			private String descripcion;
			private String [] desarrollo;
			private String [] posiblesVariaciones;
			

			public SesionTransfer(String nombre, int minutos,
					String descripcion, String [] desarrollo,
					String [] posiblesVariaciones) {
				
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

			public String[] getDesarrollo() {
				return desarrollo;
			}

			public String[] getPosiblesVariaciones() {
				return posiblesVariaciones;
			}
			
		}
}
