package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.presentacion.Confirm.confirmListener;


public class Actividades extends ColorPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6517855682994096031L;
	
	
	public Actividades(int r, int g, int b){
		super(r,g,b);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Actividades");
		title.setFont(font);
		title.setForeground(Color.BLACK);
		add(title, c);
		
		
		
		ImageButton nuevo = new ImageButton("  Crear  ", "images/bluebutton.png", "images/bluebutton2.png", this);
		componentes.add(nuevo);
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
		
		ImageButton buscar = new ImageButton("  Buscar ", "images/greenbutton.png", "images/greenbutton2.png", this);
		componentes.add(buscar);
		buscar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 1;
		c.gridy = 1;
		add(buscar, c);
		
		ImageButton eliminar = new ImageButton("Eliminar", "images/orangebutton.png", "images/orangebutton2.png", this);
		componentes.add(eliminar);
		eliminar.addActionListener((ae) -> {
			JFrame panel = new PantallaEliminar();
			panel.setVisible(true);
		});
		c.gridx = 1;
		c.gridy = 2;
		add(eliminar, c);
		setVisible(true);
	}
	 
	private class PantallaAdd extends JFrame{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 7199864481454444290L;
		
		// Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JComboBox<String> jComboBox1;
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
	    private javax.swing.JScrollPane jScrollPane3;
	    private javax.swing.JScrollPane jScrollPane4;
	    private javax.swing.JScrollPane jScrollPane5;
	    private javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextArea jTextArea3;
	    private javax.swing.JTextArea jTextArea4;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    // End of variables declaration    
		public PantallaAdd(){
			initGUI();
		}
		private void initGUI(){
			jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jTextField1 = new javax.swing.JTextField();
	        jComboBox1 = new javax.swing.JComboBox<>();
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
	        jLabel10 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Crear Actividad");
	        setName("Crear Actividad"); // NOI18N

	        jLabel1.setText("Nombre: ");

	        jLabel2.setText("Dificultad:");

	        jLabel3.setText("Duraci�n:");

	        jButton1.setText("Guardar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baja", "Media", "Alta" }));

	        jLabel4.setText("min");

	        jLabel5.setText("Descripci�n: ");

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        jLabel6.setText("Desarrollo de la Actividad");

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
	        jList1.getAccessibleContext().setAccessibleParent(null);

	        jScrollPane5.setViewportView(jList2);
	        jList2.getAccessibleContext().setAccessibleParent(null);

	        jLabel8.setText("Recursos Empleados");

	        jLabel9.setText("Actividades Empleadas");

	        jLabel10.setText("Paciente Tipo: ");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(7, 7, 7)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabel2)
	                            .addComponent(jLabel1)
	                            .addComponent(jLabel3))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                        .addComponent(jLabel4)
	                                        .addGap(0, 0, Short.MAX_VALUE))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(52, 52, 52)
	                                        .addComponent(jLabel10)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
	                            .addComponent(jTextField1)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(2, 2, 2)
	                        .addComponent(jLabel5)))
	                .addGap(0, 0, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(32, 32, 32)
	                .addComponent(jLabel6)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
	                .addComponent(jLabel7)
	                .addGap(45, 45, 45))
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	            .addGroup(layout.createSequentialGroup()
	                .addGap(43, 43, 43)
	                .addComponent(jLabel8)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jLabel9)
	                .addGap(39, 39, 39))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addGap(153, 153, 153))
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
	                    .addComponent(jLabel2)
	                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel10)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jLabel5)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel6)
	                    .addComponent(jLabel7))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(2, 2, 2)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel8)
	                    .addComponent(jLabel9))
	                .addGap(2, 2, 2)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
	                .addComponent(jButton1)
	                .addContainerGap())
	        );

	        pack();
		}
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		      //ActionInfo info = new ActionInfo(jTextField1.getText(), jComboBox1.getSelectedItem(),  jTextField)
		} 
	}
	
	public class ActionInfo{
		public String getNombre() {
			return nombre;
		}

		public String getDificultad() {
			return dificultad;
		}

		public String getPacienteTipo() {
			return pacienteTipo;
		}

		public int getDuracion() {
			return duracion;
		}


		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getDesarrollo() {
			return desarrollo;
		}

		public void setDesarrollo(String desarrollo) {
			this.desarrollo = desarrollo;
		}

		public String getVariaciones() {
			return variaciones;
		}

		public void setVariaciones(String variaciones) {
			this.variaciones = variaciones;
		}

		public String[] getRecursos() {
			return recursos;
		}

		public void setRecursos(String[] recursos) {
			this.recursos = recursos;
		}

		public String[] getActividades() {
			return actividades;
		}

		public void setActividades(String[] actividades) {
			this.actividades = actividades;
		}

		private String nombre;
		private String dificultad;
		private String pacienteTipo;
		private int duracion;
		private String descripcion;
		private String desarrollo;
		private String variaciones;
		private String[] recursos;
		private String[] actividades;
		
		public ActionInfo(String nombre, String dificultad, String pacienteTipo, int duracion,
				String descripcion, String desarrollo, String variaciones, String[] recursos, String[] actividades){
			this.nombre = nombre;
			this.dificultad = dificultad;
			this.pacienteTipo = pacienteTipo;
			this.duracion = duracion;
			this.descripcion = descripcion;
			this.desarrollo = desarrollo;
			this.variaciones = variaciones;
			this.actividades = actividades;
			this.recursos = recursos;
		}
	}

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
	        setTitle("Eliminar Actividad");

	        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

	        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
	        jButton1.setText("Eliminar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
	        jLabel2.setText("Introduzca el nombre de la actividad");

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

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	Confirm c = new Confirm();
	    	c.setVisible(true);
	    	c.addListener(this);
	    }  
	    
	    public void delete(){
	    	Controlador.deleteActividad(jTextField1.getText());
	    	this.dispose();
	    }
	    
	}
}
