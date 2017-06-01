package DIedrAl_Project.presentacion.secciones;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.presentacion.auxiliar.Modo;


/**
 * Clase que gestiona la ventana que aparece al darle al botón -Añadir- en la sección -Sesiones- del Menú Principal
 * @author Diedral_Group
 * 
 */
public class PantallaSesion extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1349374506624011557L;
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
	private boolean editable;
	private Sesion sesion;
	private Modo mode;      

	public PantallaSesion(Sesion s, Modo m){
		sesion = s;
		mode = m;
		if(mode.equals(Modo.VISTA)) editable= false;
		else editable = true;
		initGUI();
	}
	private void initGUI(){
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton1.setVisible(editable);
		jButton1.setEnabled(editable);
		jTextField1 = new javax.swing.JTextField("");
		jTextField1.setEditable(editable);
		jTextField2 = new javax.swing.JTextField("");
		jTextField2.setEditable(editable);
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea("");
		jTextArea1.setEditable(editable);
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextArea3 = new javax.swing.JTextArea("");
		jTextArea3.setEditable(editable);
		jScrollPane4 = new javax.swing.JScrollPane();
		jTextArea4 = new javax.swing.JTextArea("");
		jTextArea4.setEditable(editable);
		jScrollPane2 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<>();
		jScrollPane5 = new javax.swing.JScrollPane();
		jList2 = new javax.swing.JList<>();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jScrollPane6 = new javax.swing.JScrollPane();
		jTextArea5 = new javax.swing.JTextArea("");
		jTextArea5.setEditable(editable);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		switch(mode){
		case ADD: setTitle("Crear Sesion"); break;
		case VISTA: setTitle("Sesion"); break;
		case EDITAR: setTitle("Editar Sesion"); break;
		case RETURN: setTitle("Crear Plantilla de Sesion"); break;
		default: new Error("Error en modo en pantalla sesiones"); break;
		}


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

		jLabel11.setText("Etiquetas: ");

		jTextArea5.setColumns(20);
		jTextArea5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
		jTextArea5.setRows(5);
		jTextArea5.setAutoscrolls(false);
		jScrollPane6.setViewportView(jTextArea5);

		if(sesion != null){
			jTextField1.setText(sesion.getNombre());

			jTextField2.setText(String.valueOf(sesion.getDuracion()));

			jTextArea1.setText(sesion.getDescripcion());

			String etiquetas = sesion.getEtiquetas().toString();
			jTextArea3.setText(etiquetas);

			jTextArea4.setText(sesion.getDesarrollo());
			jTextArea5.setText(sesion.getVariaciones());

			jList1.setModel(new javax.swing.AbstractListModel<String>() {

				/**
				 * 
				 */
				 private static final long serialVersionUID = 1L;
				ArrayList<String> recursos = Controlador.getRecursosAsociados(sesion);
				String[] strings = recursos.toArray(new String[recursos.size()]);
				public int getSize() { return strings!= null ? strings.length : 0; }
				public String getElementAt(int i) { return strings[i]; }
			});
			jList2.setModel(new javax.swing.AbstractListModel<String>() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				ArrayList<String> actividades = Controlador.getActividadesAsociadas(sesion);
				String[] strings = actividades.toArray(new String[actividades.size()]);
				public int getSize() { return strings!= null ? strings.length : 0; }
				public String getElementAt(int i) { return strings[i]; }
			});
		}

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

		setVisible(true);
		getContentPane().setBackground(new Color(255, 111, 105));
		pack();
	}

	/**
	 * Función que se ejecuta al darle a guardar en la ventana de adición de sesiones.
	 *  Se rellena un objeto sesión y es pasado al controlador.
	 * */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 

		String etiquetasSinFormato = jTextArea5.getText();
		String etiquetas[] = etiquetasSinFormato.split(",");
		String nombre = jTextField1.getText();
		int duracion = 0;
		try{
			duracion = Integer.valueOf(String.valueOf((jTextField2.getText())));
		}catch(NumberFormatException e){
			new Error("La duración ha de ser un número entero mayor que cero.");
			return;
		}
		if(nombre.equals("")) new Error("Nombre vacio");
		else{
			Sesion info = new Sesion(String.valueOf(jTextField1.getText()), etiquetas);

			info.setDuracion(duracion);
			info.setDescripcion(String.valueOf(jTextArea1.getText()));
			info.setDesarrollo(String.valueOf(jTextArea4.getText()));
			info.setVariaciones(String.valueOf(jTextArea3.getText()));
			if(mode.equals(Modo.ADD)) Controlador.addSesion(info);
			else if(mode.equals(Modo.EDITAR)) Controlador.modificaEtiquetable(sesion, info);
			else if(mode.equals(Modo.RETURN)){
				Controlador.addSesion(info);
				new PantallaSesionProgramada(info);
			}
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	} 
}