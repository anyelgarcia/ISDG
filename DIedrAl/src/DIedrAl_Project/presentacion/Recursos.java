package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Recursos extends ColorPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1366867660661296990L;   
	
	
	public Recursos(int r, int g, int b){
		super(r, g, b);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Recursos");
		title.setFont(this.font);
		title.setForeground(Color.GRAY);
		add(title, c);
		
		
		
		ImageButton nuevo = new ImageButton("Crear ", "images/orangebutton.png", "images/orangebutton2.png", this);
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
		
		
		
		ImageButton buscar = new ImageButton(" Buscar  ", "images/greenbutton.png", "images/greenbutton2.png", this);
		componentes.add(buscar);
		buscar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		});
		
		c.gridx = 1;
		c.gridy = 1;
		add(buscar , c);
		
		
		ImageButton eliminar = new ImageButton("Eliminar", "images/bluebutton.png", "images/bluebutton2.png", this);
		componentes.add(eliminar);
		eliminar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 1;
		c.gridy = 2;
		add(eliminar, c);
		
		
		
		ImageButton editar = new ImageButton("Editar", "images/tanbutton.png", "images/tanbutton2.png", this);
		componentes.add(editar);
		editar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 0;
		c.gridy = 2;
		add(editar, c);
		setVisible(true);
	}
        
	
	private class PantallaAdd extends JFrame{
		
		 /**
		 * 
		 */
		private static final long serialVersionUID = 8065001825557862697L;
		
		// Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JScrollPane jScrollPane3;
	    private javax.swing.JTextArea jTextArea2;
	    private javax.swing.JTextArea jTextArea3;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    // End of variables declaration    
	    
		public PantallaAdd(){
			initGUI();
		}
		private void initGUI(){
			jLabel1 = new javax.swing.JLabel();
		    jLabel2 = new javax.swing.JLabel();
		    jLabel3 = new javax.swing.JLabel();
		    jLabel4 = new javax.swing.JLabel();
		    jButton1 = new javax.swing.JButton();
		    jTextField1 = new javax.swing.JTextField();
		    jTextField2 = new javax.swing.JTextField();
		    jScrollPane2 = new javax.swing.JScrollPane();
		    jTextArea2 = new javax.swing.JTextArea();
		    jScrollPane3 = new javax.swing.JScrollPane();
		    jTextArea3 = new javax.swing.JTextArea();

		    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		    setTitle("Crear Recurso");

		        jLabel1.setText("Nombre del recurso:");

		        jLabel2.setText("Archivo: ");

		        jLabel3.setText("Descripción: ");

		        jLabel4.setText("Etiquetas: (separadas por comas)");

		        jButton1.setText("Guardar");
		        jButton1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });


		        jTextField2.setText("Ruta al archivo");

		        jTextArea2.setColumns(20);
		        jTextArea2.setRows(5);
		        jScrollPane2.setViewportView(jTextArea2);

		        jTextArea3.setColumns(20);
		        jTextArea3.setRows(5);
		        jScrollPane3.setViewportView(jTextArea3);

		        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		        getContentPane().setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addComponent(jScrollPane3)
		                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
		                    .addGroup(layout.createSequentialGroup()
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                            .addComponent(jLabel4)
		                            .addGroup(layout.createSequentialGroup()
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                    .addComponent(jLabel1)
		                                    .addComponent(jLabel2)
		                                    .addComponent(jLabel3))
		                                .addGap(18, 18, 18)
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
		                                    .addComponent(jTextField1))))
		                        .addGap(0, 0, Short.MAX_VALUE)))
		                .addContainerGap())
		            .addGroup(layout.createSequentialGroup()
		            		.addGap(126, 126, 126)
			                .addComponent(jButton1)
			                .addGap(0, 0, Short.MAX_VALUE))
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel1)
		                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel2)
		                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addComponent(jLabel3)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(18, 18, 18)
		                .addComponent(jLabel4)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(29, 29, 29)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jButton1))
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );

		        pack();
		}

		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {     
			
			String etiquetas = jTextArea2.getText();
			String etiqs[] = etiquetas.split(",");
			Controlador.addRecurso(new RecursoTransfer(String.valueOf(jTextField1.getText()), String.valueOf(jTextField2.getText()), String.valueOf(jTextArea3.getText()), etiqs));
		}                                        

	}
	
	public class RecursoTransfer{
		private String nombre;
		private String ruta;
		private String descripcion;
		private String[] etiquetas;
		
		public RecursoTransfer(String nombre, String ruta, String descripcion,
				String[] etiquetas) {
			this.nombre = nombre;
			this.ruta = ruta;
			this.descripcion = descripcion;
			this.etiquetas = etiquetas;
		}
		public String getNombre() {
			return nombre;
		}
		public String getRuta() {
			return ruta;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public String[] getEtiquetas() {
			return etiquetas;
		}
		
		
	}
}
