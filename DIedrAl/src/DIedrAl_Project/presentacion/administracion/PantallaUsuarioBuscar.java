package DIedrAl_Project.presentacion.administracion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.Confirm;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.presentacion.auxiliar.Modo;
import DIedrAl_Project.presentacion.auxiliar.Confirm.confirmListener;


/**
 * Pantalla usada para buscar un usuario antes de eliminarlo.
 * @author usuario_local
 *
 */
public class PantallaUsuarioBuscar extends JFrame implements confirmListener{
    
	private static final long serialVersionUID = 4732140844766292200L;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JList<String> jList1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JSeparator jSeparator2;
	private Usuario[] resultados;
	private boolean volver;
	private Modo modo;

	public PantallaUsuarioBuscar(Modo modo, boolean volvervisible){
		volver = volvervisible;
		this.modo = modo;
		initGUI();
	}


	private void initGUI() {

		jTextField1 = new javax.swing.JTextField("");
		jTextField2 = new javax.swing.JTextField("");
		jTextField3 = new javax.swing.JTextField("");
		jTextField4 = new javax.swing.JTextField("");
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<>();
		jButton2 = new javax.swing.JButton();
		jSeparator2 = new javax.swing.JSeparator();
		jButton3 = new javax.swing.JButton();


		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Buscar Usuario");

		jLabel1.setFont(new java.awt.Font("Arial", 0, 10));
		jLabel1.setText("Nombre:");
		jLabel1.setForeground(Color.BLACK);

		jLabel2.setFont(new java.awt.Font("Arial", 0, 10));
		jLabel2.setText("Primer Apellido:");
		jLabel2.setForeground(Color.BLACK);

		jLabel3.setFont(new java.awt.Font("Arial", 0, 10));
		jLabel3.setText("Segundo Apellido:");
		jLabel3.setForeground(Color.BLACK);

		jLabel4.setFont(new java.awt.Font("Arial", 0, 10));
		jLabel4.setText("DNI:");
		jLabel4.setForeground(Color.BLACK);

		jButton1.setText("Buscar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jList1.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			 public int getSize() { return resultados!= null ? resultados.length : 0; }
			 public String getElementAt(int i) { return (resultados[i]).toString(); }
		});
		jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setViewportView(jList1);

		jButton2.setText("Confirmar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		
		jButton3.setText("Volver");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jButton3.setVisible(volver);
		jButton3.setEnabled(volver);
		

		jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(21, 21, 21)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
																.addGap(30, 30, 30)))
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addComponent(jButton1))
																		.addGap(35, 35, 35)
																		.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(16, 16, 16)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jButton2)
																				)
																		.addComponent(jButton3)
																				.addContainerGap(29, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(10, 10, 10)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel2))
														.addGap(11, 11, 11)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel3))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(jLabel4))
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
																		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																						.addContainerGap(16, Short.MAX_VALUE)
																						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(18, 18, 18)
																						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(jButton2)
																								.addComponent(jButton1)
																								.addComponent(jButton3))))
																								.addGap(10, 10, 10))
																								.addComponent(jSeparator2)
				);
		setVisible(true);
		pack();
	}

	protected void jButton3ActionPerformed(ActionEvent evt) {
		new UsuarioWindow();
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}


	/**
	 * Función que se ejecuta al darle al botón buscar. Rellena un Usuario con los datos introducidos y 
	 * busca en el sistema a todos los que coincidan con él. Los guarda en resultados
   * @param evt
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

		String nombre = jTextField1.getText();
		String apellido1 = jTextField2.getText();
		String apellido2 = jTextField3.getText();
		String DNI = jTextField4.getText();

		ArrayList<String> campos = new ArrayList<String>();
		ArrayList<Hints> hints = new ArrayList<Hints>();

		if(nombre!=null && nombre.length()>0){
			campos.add(nombre);
			hints.add(Hints.NOMBRE);
		}

		if(apellido1!=null && apellido1.length()>0){
			campos.add(apellido1);
			hints.add(Hints.APELLIDO1);
		}

		if(apellido2!=null && apellido2.length()>0){
			campos.add(apellido2);
			hints.add(Hints.APELLIDO2);
		}

		if(DNI!=null && DNI.length()>0){
			campos.add(DNI);
			hints.add(Hints.NIF);
		}
		
		Hints [] claves = hints.toArray(new Hints[hints.size()]);
		String [] valores = campos.toArray(new String[campos.size()]);

		resultados = Controlador.buscarUsuario(claves, valores);
		
		jList1.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			public int getSize() { return resultados!= null ? resultados.length : 0; }
            public String getElementAt(int i) { return (resultados[i]).toString(); }
        });
	}                                        

	/**
	 * Función que se ejecuta al seleccionar uno de los resultados de la búsqueda y pulsar el
	 * botón de validar. Según el modo se hace una cosa u otra. 
	 * Si el modo es eliminar, se muestra una pantalla de confirmación.
	 * Si el modo es Editar o buscar, se crea una pantalla Usuario y se le pasa el control.
	 * @param evt
	 */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		int i = jList1.getSelectedIndex();
		if(i!=-1){
			Usuario u = resultados[i];
			switch(modo){
				case ELIMINAR:
					Confirm c = new Confirm();
					c.setMensaje("El paciente se eliminará del sistema.");
			    	c.setVisible(true);
			    	c.addListener(this);
			    	break;
				case BUSCAR:
					new PantallaUsuario(u, Modo.VISTA);
					break;
				default:
					new Error("Error raro en el modo en búsqueda de usuarios");
					break;
				}
		}
		else new Error("Has de seleccionar al menos un usuario.");
	}


	@Override
	public void delete() {
		int i = jList1.getSelectedIndex();
    	Controlador.deleteUsuario(resultados[i]);
    	new Error("Usuario eliminado del sistema.");
    	new MenuCentroUsuarios();
    	dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}  
}