package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.ArrayActividades;
import DIedrAl_Project.negocio.recursos.Dificultad;
import DIedrAl_Project.presentacion.Confirm.confirmListener;

/**
 * Esta clase lleva la gestión de las vistas de las actividades. En el constructor se dibuja la sección de Actividades del Menú Principal y se pone a la espera para 
 * añadir, eliminar, editar o buscar actividades.
 * 
 * @author Diedral_Group
 *
 */
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
			JFrame pantalla = new PantallaBuscar(Modo.BUSCAR);
			pantalla.setVisible(true);
		});
		c.gridx = 1;
		c.gridy = 1;
		add(buscar, c);
		
		ImageButton editar = new ImageButton("Editar", "images/orangebutton.png", "images/orangebutton2.png", this);
		componentes.add(editar);
		editar.addActionListener((ae) -> {
			JFrame panel = new PantallaBuscar(Modo.EDITAR);
			panel.setVisible(true);
			
		});
		c.gridx = 0;
		c.gridy = 2;
		add(editar, c);
		
		ImageButton eliminar = new ImageButton("Eliminar", "images/tanbutton.png", "images/tanbutton2.png", this);
		componentes.add(eliminar);
		eliminar.addActionListener((ae) -> {
			JFrame panel = new PantallaBuscar(Modo.ELIMINAR);
			panel.setVisible(true);
		});
		c.gridx = 1;
		c.gridy = 2;
		add(eliminar, c);
		setVisible(true);
	}
	 
	
	/**
	 * Clase que gestiona la ventana que aparece al darle al botón -Añadir- en la sección -Actividades- del Ménú Principal
	 * @author Diedral_Group
	 * 
	 */
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
	    private javax.swing.JTextField jTextField3;
	    
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
	        jLabel11 = new javax.swing.JLabel();
	        jScrollPane6 = new javax.swing.JScrollPane();
	        jTextArea5 = new javax.swing.JTextArea();
	        

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Crear Actividad");
	        setName("Crear Actividad"); // NOI18N

	        jLabel1.setText("Nombre: ");

	        jLabel2.setText("Dificultad:");

	        jLabel3.setText("Duración:");

	        jButton1.setText("Guardar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MUY_FACIL", "FACIL",  "MEDIO", "DIFICIL", "MUY_DIFICIL" }));

	        jLabel4.setText("minutos");

	        jLabel5.setText("Descripción: ");

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
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	        	                .addGap(32, 32, 32)
	        	                .addComponent(jLabel5)
	        	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
	        	                .addComponent(jLabel11)
	        	                .addGap(45, 45, 45)))
	                .addGap(0, 0, Short.MAX_VALUE))
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
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel5)
		                    .addComponent(jLabel11))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
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
	        
	        getContentPane().setBackground(getColor());
	        pack();
		}
		
		/**
		 * Función que se ejecuta al darle a guardar en la ventana de añadir actividades. Se rellena un objeto actividad y es pasado al controlador.
		 * */
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
			
			String etiquetasSinFormato = jTextArea5.getText();
			String etiquetas[] = etiquetasSinFormato.split(",");
			Actividad info = new Actividad(String.valueOf(jTextField1.getText()), etiquetas);
			
			String duracion = String.valueOf(jTextField2.getText());

			//Esta excepción hay que capturarla
			if(duracion.length()>0 ){
				info.setDuracion(Integer.valueOf(duracion));
			}
			
			info.setDificultad(Dificultad.valueOf(String.valueOf(jComboBox1.getSelectedItem())));
			info.setDescripcion(String.valueOf(jTextArea1.getText()));
			info.addDestinatario(String.valueOf(jTextField3.getText()));
			info.setVariaciones(String.valueOf(jTextArea3.getText()));
			info.setDesarrollo(String.valueOf(jTextArea4.getText()));
			
			Controlador.addActividad(info);
		} 
	}
	
	
	/**
	 * 
	 * Ventana que sale al pulsar el botón eliminar en la sección Actividades en el menú principal.
	 * @author Diedral_Group
	 *
	 */

	private class PantallaBuscar extends JFrame implements confirmListener{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -5500263054256196980L;
		
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JComboBox<String> jComboBox1;
	    private javax.swing.JComboBox<String> jComboBox2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JList<String> jList1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JScrollPane jScrollPane3;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextArea jTextArea2;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    private Modo modo;
	    private ArrayActividades filtrados;
	    
	    public PantallaBuscar(Modo m){
	    	modo = m;
	    	initComponents();
	    }
		
		private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jLabel2 = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        jTextField2 = new javax.swing.JTextField();
	        jLabel7 = new javax.swing.JLabel();
	        jTextField3 = new javax.swing.JTextField();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel9 = new javax.swing.JLabel();
	        jComboBox1 = new javax.swing.JComboBox<>();
	        jLabel10 = new javax.swing.JLabel();
	        jComboBox2 = new javax.swing.JComboBox<>();
	        jLabel4 = new javax.swing.JLabel();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jTextArea2 = new javax.swing.JTextArea();
	        jSeparator1 = new javax.swing.JSeparator();
	        jButton1 = new javax.swing.JButton();
	        jScrollPane3 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        jButton2 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        switch(modo){
			case ELIMINAR:
				setTitle("Eliminar Actividad");
		    	break;
			case EDITAR:
				setTitle("Editar Actividad");
				break;
			case BUSCAR:
				setTitle("Buscar Actividad");
				break;
			}

	        jLabel1.setText("Nombre");

	        jLabel2.setText("Etiquetas (Separadas por comas) ");

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        jLabel3.setText("Duración:");

	        jLabel6.setText("Desde");

	        jLabel7.setText("Hasta");

	        jLabel8.setText("Dificultad:");

	        jLabel9.setText("Desde");

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	        jLabel10.setText("Hasta");

	        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

	        jLabel4.setText("Destinatarios (Separados por comas)");

	        jTextArea2.setColumns(20);
	        jTextArea2.setRows(5);
	        jScrollPane2.setViewportView(jTextArea2);

	        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

	        jButton1.setText("Buscar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
	            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				
				String[] strings = {  };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane3.setViewportView(jList1);

	        jButton2.setText("Confirmar");
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
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel6)
	                        .addGap(10, 10, 10)
	                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel7)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jLabel3)
	                    .addComponent(jLabel8)
	                    .addComponent(jLabel4)
	                    .addComponent(jLabel2)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                            .addComponent(jLabel1)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jTextField1))
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jButton1)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel9)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jLabel10)))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jScrollPane3)
	                        .addContainerGap())
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(52, 52, 52)
	                        .addComponent(jButton2)
	                        .addContainerGap(60, Short.MAX_VALUE))))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jSeparator1)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(11, 11, 11)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel1)
	                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jLabel2)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(14, 14, 14)
	                        .addComponent(jLabel4)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel3)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel6)
	                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel7)
	                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jLabel8)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel9)
	                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel10)
	                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
	                        .addComponent(jButton1))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jButton2)))
	                .addContainerGap())
	        );
	        getContentPane().setBackground(getColor());
	        pack();
	    }// </editor-fold>                        

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	String nombre = jTextField1.getText();
			Set<String> setEtiquetas = new HashSet<String>(Arrays.asList(jTextArea1.getText().split(",")));
			Set<String> setDestinatarios = new HashSet<String>(Arrays.asList(jTextArea2.getText().split(",")));
			Integer ini = null, end = null;
			if(!jTextField2.getText().equals("")) 
				ini = Integer.parseInt(jTextField2.getText());
			if(!jTextField3.getText().equals("")) 
				end = Integer.parseInt(jTextField3.getText());
			Dificultad min = null, max = null;
			/*if(jComboBox1.getSelectedIndex() != 0){
				min = jComboBox1.getSelectedItem();
			}
			if(jComboBox2.getSelectedIndex() != 0){
				max = jComboBox2.getSelectedItem();
			}*/
		
			filtrados = Controlador.filtrarActividades(nombre, setEtiquetas, ini, end, setDestinatarios, min, max);
			
			/*jList1.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] strings = ;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return salida.; }
			});*/
			
			
	    }                                        

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	switch(modo){
			case ELIMINAR:
				Confirm c = new Confirm();
		    	c.setVisible(true);
		    	c.addListener(this);
		    	break;
			case EDITAR:
				break;
			case BUSCAR:
				break;
			}
	    }

		@Override
		public void delete() {
			String name = jList1.getSelectedValue();
			for(Actividad a : filtrados){
				if(a.getNombre().equals(name)){
					System.out.println(name);
					Controlador.deleteActividad(a);
			    	this.dispose();
				}
			}
		}                                        

	}
}
