package DIedrAl_Project.presentacion.secciones;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.negocio.recursos.ArrayRecursos;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.ColorPanel;
import DIedrAl_Project.presentacion.auxiliar.Confirm;
import DIedrAl_Project.presentacion.auxiliar.Confirm.confirmListener;
import DIedrAl_Project.presentacion.auxiliar.ImageButton;
import DIedrAl_Project.presentacion.auxiliar.Modo;
import DIedrAl_Project.presentacion.auxiliar.Error;

/**
 * Esta clase lleva la gestión de las vistas de los recursos. En el constructor se dibuja la sección de Recursos 
 * del Menú Principal y se pone a la espera para añadir, eliminar, editar o buscar recursos.
 * @author Diedral_Group
 *
 */
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
		title.setForeground(Color.WHITE);
		add(title, c);
		
		
		
		ImageButton nuevo = new ImageButton("Crear ", "images/orangebutton.png", "images/orangebutton2.png", this);
		componentes.add(nuevo);
		nuevo.addActionListener((ae) -> {
			JFrame pantalla = new CrearRecurso();
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
			JFrame pantalla = new PantallaBuscar(Modo.BUSCAR);
			pantalla.setVisible(true);
		});
		
		c.gridx = 1;
		c.gridy = 1;
		add(buscar , c);
		
		
		ImageButton eliminar = new ImageButton("Eliminar", "images/bluebutton.png", "images/bluebutton2.png", this);
		componentes.add(eliminar);
		eliminar.addActionListener((ae) -> {
			JFrame panel = new PantallaBuscar(Modo.ELIMINAR);
			panel.setVisible(true);	
		});
		c.gridx = 1;
		c.gridy = 2;
		add(eliminar, c);
		
		
		
		ImageButton editar = new ImageButton("Editar", "images/blackbutton.png", "images/blackbutton2.png", this);
		componentes.add(editar);
		editar.addActionListener((ae) -> {
			JFrame panel = new PantallaBuscar(Modo.EDITAR);
			panel.setVisible(true);
			
		});
		c.gridx = 0;
		c.gridy = 2;
		add(editar, c);
		setVisible(true);
	}
        
	
	/**
	 * Clase que gestiona la ventana que aparece al darle al botón -Añadir- en la sección -Recursos- del Ménú Principal
	 * @author Diedral_Group
	 *
	 */
	private class PantallaRecurso extends JFrame{
		
		                   
	    /**
		 * 
		 */
		private static final long serialVersionUID = 4771327958790552537L;
		private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JScrollPane jScrollPane3;
	    private javax.swing.JTextArea jTextEtiquetas;
	    private javax.swing.JTextArea jTextAreaDescripcion;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private boolean editable;
	    private Recurso recurso;
	    private Modo mode;   
	    
		public PantallaRecurso(Recurso r, Modo m){
			mode = m;
			if(mode.equals(Modo.VISTA)) editable= false;
			else editable = true;

			recurso = r;
			initGUI();
		}
		
		private void initGUI(){
			jLabel1 = new javax.swing.JLabel();
		    jLabel2 = new javax.swing.JLabel();
		    jLabel3 = new javax.swing.JLabel();
		    jLabel4 = new javax.swing.JLabel();
		    jButton1 = new javax.swing.JButton();
		    jButton1.setVisible(editable);
	        jButton1.setEnabled(editable);
		    jTextField1 = new javax.swing.JTextField("");
		    jTextField1.setEditable(editable);
		    jTextField2 = new javax.swing.JTextField("");
		    jTextField2.setEditable(editable);
		    jScrollPane2 = new javax.swing.JScrollPane();
		    jTextEtiquetas = new javax.swing.JTextArea("");
		    jTextEtiquetas.setEditable(editable);
		    jScrollPane3 = new javax.swing.JScrollPane();
		    jTextAreaDescripcion = new javax.swing.JTextArea("");
		    jTextAreaDescripcion.setEditable(editable);

		    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		    switch(mode){
		    	case VISTA: setTitle("Recurso"); break;
		    	case EDITAR: setTitle("Editar Recurso"); break;
		    	default: new Error("Error en modo en pantalla recursos"); break;
		    }

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

		        jTextEtiquetas.setColumns(20);
		        jTextEtiquetas.setRows(5);
		        jScrollPane2.setViewportView(jTextEtiquetas);

		        jTextAreaDescripcion.setColumns(20);
		        jTextAreaDescripcion.setRows(5);
		        jScrollPane3.setViewportView(jTextAreaDescripcion);

		        
		        if(recurso != null){
		        	jTextField1.setText(recurso.getNombre());
		        	jTextField2.setText(recurso.getFileName());
		        	jTextAreaDescripcion.setText(recurso.getDescripcion());
		        	StringBuilder etiq= new StringBuilder();
		        	int i=1;
		        	for(String str: recurso.getEtiquetas()){
		        		etiq.append(str);
			        	if(i<recurso.getEtiquetas().size()){
			        		etiq.append(", ");
			        	}
			        	++i;
		        	}        	
		        	jTextEtiquetas.setText(etiq.toString());
		        }
		        
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
		                .addComponent(jLabel4)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(18, 18, 18)
		                .addComponent(jLabel3)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(29, 29, 29)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jButton1))
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );
		        
		        getContentPane().setBackground(getColor());
		        pack();
		}

		
		/**
		 * Función que se ejecuta al darle a guardar en la ventana de de recursos. Se rellena un objeto recurso y es pasado al controlador.
		 * */
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {     
			
			String etiquetas = jTextEtiquetas.getText();
			String etiqs[] = etiquetas.split(", ");
			String nombre = jTextField1.getText();
			if(nombre == null) new Error("Nombre vacio");
			else{
				Recurso info = new Recurso(nombre, (File)null, etiqs);
				info.setDescripcion(String.valueOf(jTextAreaDescripcion.getText()));
				Controlador.modificaEtiquetable(recurso, info);
				dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		}                                        

	}
	/**
	 * Crea una pantalla que nos permite buscar un recurso, para posteriormente eliminarlo
	 * editarlo, o consultarlo
	 *
	 */
	private class PantallaBuscar extends JFrame implements confirmListener{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -1959937229612958709L;
		private javax.swing.JButton jButton1;
		private javax.swing.JButton jButton2;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JList<String> jList1;
		private javax.swing.JScrollPane jScrollPane1;
		private javax.swing.JScrollPane jScrollPane2;
		private javax.swing.JSeparator jSeparator1;
		private javax.swing.JTextArea jTextArea1;
		private javax.swing.JTextField jTextField1;
		private Modo modo;
		private ArrayRecursos filtrados;
	    
		public PantallaBuscar(Modo m){
			modo = m;
			initComponents();
		}
		
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField("");
	        jLabel2 = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea("");
	        jSeparator1 = new javax.swing.JSeparator();
	        jButton1 = new javax.swing.JButton();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        jButton2 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        switch(modo){
				case ELIMINAR:
					setTitle("Eliminar Recurso");
			    	break;
				case EDITAR:
					setTitle("Editar Recurso");
					break;
				case BUSCAR:
					setTitle("Buscar Recurso");
					break;
				default:
					new Error("Error raro en modo de pantalla Recursos buscar");
			}

	        jLabel1.setText("Nombre");

	        jLabel2.setText("Etiquetas (separadas por comas)");

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

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
				public int getSize() { return strings!= null ? strings.length : 0; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	        jScrollPane2.setViewportView(jList1);

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
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel2)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel1)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(63, 63, 63)
	                        .addComponent(jButton1)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
	                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(71, 71, 71)
	                        .addComponent(jButton2)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jSeparator1)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel1)
	                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(18, 18, 18)
	                        .addComponent(jLabel2)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButton1))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButton2)))
	                .addContainerGap(17, Short.MAX_VALUE))
	        );
	        getContentPane().setBackground(getColor());
	        pack();
	    }                      
	    /**
	     * Funcion que se ejecuta al pulsar el boton de "buscar", 
	     * muestra las coincidencias en la lista
	     */
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	String nombre = jTextField1.getText();
	    	String etiq = jTextArea1.getText();
	    	Set<String> setEtiquetas = new HashSet<String>();
	    	if(!etiq.equals(""))
	    		setEtiquetas = new HashSet<String>(Arrays.asList(jTextArea1.getText().split(",")));
		
			filtrados = Controlador.filtrarRecursos(nombre, setEtiquetas);
			
			ArrayList<String> nombres = new ArrayList<>();
			for(Recurso r : filtrados){
				nombres.add(r.getNombre());
			}
			
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				
				private static final long serialVersionUID = 1L;
				public int getSize() { return nombres!= null ? nombres.size() : 0; }
	            public String getElementAt(int i) { return nombres.get(i); }
			});
			
	    }                                        
	    /**
	     * Funcion que se ejecuta cuando seleccionamos un archivo, y según se esté
	     * editando/eliminando/consultando realiza una acción.
	     */
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	int i; Recurso r; JFrame p;
	    	i = jList1.getSelectedIndex();
	    	if(i != -1){
		    	switch(modo){
				case ELIMINAR:
					Confirm c = new Confirm();
			    	c.setVisible(true);
			    	c.addListener(this);
			    	break;
				case EDITAR:
					i = jList1.getSelectedIndex();
					r = getSelectedRecurso(i, filtrados);
					p = new PantallaRecurso(r, Modo.EDITAR);
					p.setVisible(true);
					break;
				case BUSCAR:
					i = jList1.getSelectedIndex();
					r = getSelectedRecurso(i, filtrados);
					p = new PantallaRecurso(r, Modo.VISTA);
					p.setVisible(true);
					break;
				default:
					new Error("Error modo pantalla buscar recursos");
					break;
				}
	    	}
	    }

		@Override
		public void delete() {
			int i = jList1.getSelectedIndex();
			Recurso r = getSelectedRecurso(i, filtrados);
			Controlador.deleteRecurso(r);
	    	this.dispose();
		}  
		
		private Recurso getSelectedRecurso(int i, ArrayRecursos filtrados){
			int j = 0;
			for(Recurso r : filtrados){
				if(i == j){
					return r;
				}
				else ++j;
			}
			return null;
		}
	}

	/**
	 * Crea una pantalla que nos permite añadir un recurso al sistema
	 */
	private class CrearRecurso extends JFrame{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 219891999838326102L;
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JScrollPane jScrollPane3;
	    private javax.swing.JTextArea jTextEtiquetas;
	    private javax.swing.JTextArea jTextAreaDescripcion;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private JFileChooser fc;
	    private File file = null;
	    
		public CrearRecurso(){
			initComponents();
		}
		private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jTextField1 = new javax.swing.JTextField("");
	        jTextField2 = new javax.swing.JTextField("");
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jTextEtiquetas = new javax.swing.JTextArea("");
	        jScrollPane3 = new javax.swing.JScrollPane();
	        jTextAreaDescripcion = new javax.swing.JTextArea("");
	        jButton3 = new javax.swing.JButton();
	        fc = new JFileChooser();

	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setTitle("Crear Recurso");

	        jLabel1.setText("Nombre del recurso:");

	        jLabel2.setText("Archivo: ");

	        jLabel3.setText("Descripción: ");

	        jLabel4.setText("Etiquetas (Separadas por comas): ");

	        jButton1.setText("Guardar");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        JFrame aux = this;
	        jButton2.setText("Salir");
	        jButton2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	               aux.dispose();
	            }
	        });

	        jTextField2.setText("URL (Página web)");

	        jTextEtiquetas.setColumns(20);
	        jTextEtiquetas.setRows(5);
	        jScrollPane3.setViewportView(jTextEtiquetas);

	        jTextAreaDescripcion.setColumns(20);
	        jTextAreaDescripcion.setRows(5);
	        jScrollPane2.setViewportView(jTextAreaDescripcion);

	        jButton3.setText("Seleccionar Archivo");
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
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel2)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(jButton3))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel1)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(85, 85, 85)
	                        .addComponent(jButton1)
	                        .addGap(60, 60, 60)
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jLabel3))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jLabel4)))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jLabel2)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton3)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jLabel3)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel4)
	                .addGap(11, 11, 11)
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton1)
	                    .addComponent(jButton2))
	                .addContainerGap(13, Short.MAX_VALUE))
	        );
	        
	        getContentPane().setBackground(getColor());
	        pack();
	    } 
		/**
		 * Funcion que se ejecuta cuando se pide guardar el recurso
		 * @param evt
		 */
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
			 
			 String direction = jTextField2.getText(); 
		     String name = jTextField1.getText();
		     if(name.equals("")) new Error("Nombre Vacio");
		     else{
		    	 if(direction.equals("URL (Página web)") && file != null){
		    		 Recurso rec = new Recurso(name, file, jTextEtiquetas.getText().split(","));
		    		 rec.setDescripcion(this.jTextAreaDescripcion.getText());
		    		 Controlador.addRecurso(rec);
		    		 dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		    	 }
		    	 else if(!direction.equals("URL (Página web)") && file == null){
		    		 try {
		    			 Recurso rec = new Recurso(name, direction, this.jTextEtiquetas.getText().split(","));
		    			 rec.setDescripcion(jTextAreaDescripcion.getText());
		    			 Controlador.addRecurso(rec);
		    		 } catch (URISyntaxException e) {
		    			 new Error("Direccion incorrecta");
		    		 }
		    	 }
		    	 else new Error("Argumentos Incorrectos");   
		     }
		 }                                     
		 
		 /**
		  * Funcion que se ejecuta al pedir añadir un archivo manualmente
		  * @param evt
		  */
		 private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { 
				int returnVal = fc.showOpenDialog(new JFrame("Prueba"));
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
			    } 
		 }

	}

}