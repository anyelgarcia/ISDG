package DIedrAl_Project.presentacion.secciones;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;

import DIedrAl_Project.negocio.recursos.ArraySesiones;
import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.Confirm;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.presentacion.auxiliar.Modo;
import DIedrAl_Project.presentacion.auxiliar.Confirm.confirmListener;

public class PantallaSesionBuscar extends JFrame implements confirmListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4319141227935628654L;

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
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
	private ArraySesiones filtrados;

	public PantallaSesionBuscar(Modo m){
		modo = m;
		initComponents();
	}
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField("");
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea("");
		jLabel3 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField("");
		jLabel7 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField("");
		jLabel4 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea("");
		jSeparator1 = new javax.swing.JSeparator();
		jButton1 = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<>();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		switch(modo){
		case ELIMINAR:
			setTitle("Eliminar Sesion");
			break;
		case EDITAR:
			setTitle("Editar Sesion");
			break;
		case BUSCAR:
			setTitle("Buscar Sesion");
			break;
		case RETURN:
			setTitle("Buscar Plantilla de Sesión");
			break;
		default:
			new Error("Error modo sesiones buscar");
		}

		jLabel1.setText("Nombre");

		jLabel2.setText("Etiquetas (Separadas por comas) ");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel3.setText("Duración:");

		jLabel6.setText("Desde");

		jLabel7.setText("Hasta");

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
			 String[] strings = { };
			 public int getSize() { return strings!= null ? strings.length : 0; }
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
																.addGap(63, 63, 63)
																.addComponent(jButton1)))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createSequentialGroup()
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
																				.addContainerGap())
																				.addGroup(layout.createSequentialGroup()
																						.addGap(44, 44, 44)
																						.addComponent(jButton2)
																						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
														.addGap(18, 18, 18)
														.addComponent(jButton1))
														.addGroup(layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18)
																.addComponent(jButton2)))
																.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		setVisible(true);
		getContentPane().setBackground(new Color(255, 111, 105));
		pack();
	}

	/**
	 * Función que se ejecuta cuando pulsamos el boton buscar en la ventana, muestra las 
	 * coincidencias en la lista
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		String nombre = jTextField1.getText();
		Set<String> setEtiquetas = new HashSet<String>();
		Set<String> setDestinatarios = new HashSet<String>();
		if(!jTextArea1.getText().equals(""))
			setEtiquetas = new HashSet<String>(Arrays.asList(jTextArea1.getText().split(",")));
		if(!jTextArea2.getText().equals(""))
			setDestinatarios = new HashSet<String>(Arrays.asList(jTextArea2.getText().split(",")));
		Integer ini = null, end = null;
		if(!jTextField2.getText().equals("")) 
			ini = Integer.parseInt(jTextField2.getText());
		if(!jTextField3.getText().equals("")) 
			end = Integer.parseInt(jTextField3.getText());

		filtrados = Controlador.filtrarSesiones(nombre, setEtiquetas, ini, end, setDestinatarios);
		String[] aux = new String[filtrados.size()]; int i = 0;
		for(Sesion s : filtrados){
			aux[i] = s.toString();
			++i;
		}

		jList1.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] strings = aux;
			public int getSize() { return strings.length; }
			public String getElementAt(int i) { return strings[i]; }
		});	

	}                                        

	/**
	 * Funcion que se ejecuta cuando seleccionamos una sesion, y seg�n se est�
	 * editando/eliminando/consultando realiza una acción.
	 */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		int i = jList1.getSelectedIndex(); Sesion s;
		if(i != -1){
			switch(modo){
			case ELIMINAR:
				Confirm c = new Confirm();
				c.setVisible(true);
				c.addListener(this);
				break;
			case EDITAR:
				i = jList1.getSelectedIndex();
				s = getSelectedSesion(i, filtrados);
				new PantallaSesion(s, Modo.EDITAR);
				break;
			case BUSCAR:
				i = jList1.getSelectedIndex();
				s = getSelectedSesion(i, filtrados);
				new PantallaSesion(s, Modo.VISTA);
				break;
			case RETURN:
				i = jList1.getSelectedIndex();
				s = getSelectedSesion(i, filtrados);
				new PantallaSesionProgramada(s, Modo.ADD);
				break;
			default:
				new Error("Error modo pantalla sesiones buscar");
				break;
			}
		}
	}
	@Override
	public void delete() {
		int i = jList1.getSelectedIndex();
		Sesion s = getSelectedSesion(i, filtrados);
		Controlador.deleteSesion(s);
		dispose();
	}

	private Sesion getSelectedSesion(int i, ArraySesiones filtrados){
		int j = 0;
		for(Sesion s : filtrados){
			if(i == j){
				return s;
			}
			else ++j;
		}
		return null;
	}
}

