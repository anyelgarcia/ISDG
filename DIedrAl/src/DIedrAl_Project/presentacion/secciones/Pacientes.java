package DIedrAl_Project.presentacion.secciones;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DIedrAl_Project.negocio.administracion.EstadoCivil;
import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.ColorPanel;
import DIedrAl_Project.presentacion.auxiliar.Confirm;
import DIedrAl_Project.presentacion.auxiliar.Confirm.confirmListener;
import DIedrAl_Project.presentacion.auxiliar.ImageButton;
import DIedrAl_Project.presentacion.auxiliar.Modo;
import DIedrAl_Project.presentacion.auxiliar.Error;

/**
 * Esta clase lleva la gestión de las vistas de los pacientes. En el constructor se dibuja la sección de Pacientes del Menú Principal y se pone a la espera para 
 * añadir, eliminar, editar o buscar pacientes.
 * 
 * @author Diedral_Group
 *
 */

public class Pacientes extends ColorPanel{   
    
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1316669015671287170L;


	public Pacientes(int r, int g, int b){
		super(r, g, b);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Pacientes");
		title.setFont(font);
		title.setForeground(Color.BLACK);
		add(title, c);
		
		
		ImageButton buscar = new ImageButton("Buscar", "images/bluebutton.png", "images/bluebutton2.png", this);
		componentes.add(buscar);
		buscar.addActionListener((ae) -> {
			JFrame pantalla = new PantallaBuscar(Modo.BUSCAR);
			pantalla.setVisible(true);
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(25,15,0,0);
		c.ipady = 0;
		add(buscar, c);
		
		
		ImageButton eliminar = new ImageButton("Eliminar", "images/greenbutton.png", "images/greenbutton2.png", this);
		componentes.add(eliminar);
		eliminar.addActionListener((ae) -> {
			JFrame panel = new PantallaBuscar(Modo.ELIMINAR);
			panel.setVisible(true);
			
		});
		c.gridx = 1;
		c.gridy = 1;
		add(eliminar, c);


		
		ImageButton anadir = new ImageButton("Añadir", "images/tanbutton.png", "images/tanbutton2.png", this);
		componentes.add(anadir);
		anadir.addActionListener((ae) -> {
			JFrame pantalla = new PantallaPaciente(null, Modo.ADD);
			pantalla.setVisible(true);
		});
		c.gridx = 0;
		c.gridy = 2;
		add(anadir, c);
		
		
		ImageButton editar = new ImageButton("  Editar  ", "images/orangebutton.png", "images/orangebutton2.png", this);
		componentes.add(editar);
		editar.addActionListener((ae) -> {
			JFrame pantalla = new PantallaBuscar(Modo.EDITAR);
			pantalla.setVisible(true);
		});
		c.gridx = 1;
		c.gridy = 2;
		add(editar, c);
		
	}
	/**
	 * Clase que gestiona la ventana que muestra los campos de un paciente. Se utiliza esta ventana tanto para
	 * añadir un paciente nuevo como para editar o consultar los datos de un paciente ya existente.
	 * @author Diedral_Group
	 * 
	 */                    
	private class PantallaPaciente extends JFrame{
                 
	    /**
		 * 
		 */
		private static final long serialVersionUID = -6079618578451230833L;
		private javax.swing.JButton jButton1;
	    private javax.swing.JComboBox<String> jComboBox1;
	    private javax.swing.JComboBox<String> jComboBox2;
	    private javax.swing.JComboBox<String> jComboBox3;
	    private javax.swing.JComboBox<String> jComboBox4;
	    private javax.swing.JComboBox<String> jComboBox5;
	    private javax.swing.JComboBox<String> jComboBox6;
	    private javax.swing.JComboBox<String> jComboBox7;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextArea jTextArea2;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    private javax.swing.JTextField jTextField4;
	    private javax.swing.JTextField jTextField5;
	    private boolean editable;
	    private Paciente pac;
	    private Modo mode;    
	    
		public PantallaPaciente(Paciente p, Modo m){
			pac = p;
			mode = m;
			if(mode.equals(Modo.VISTA)) editable= false;
			else editable = true;

			initGUI();
		}
		
		private void initGUI(){
			jLabel1 = new javax.swing.JLabel();
			jLabel2 = new javax.swing.JLabel();
			jLabel3 = new javax.swing.JLabel();
			jLabel4 = new javax.swing.JLabel();
			jTextField1 = new javax.swing.JTextField("");
			jTextField2 = new javax.swing.JTextField("");
			jTextField3 = new javax.swing.JTextField("");
			jLabel5 = new javax.swing.JLabel();
			jComboBox1 = new javax.swing.JComboBox<>();
			jComboBox2 = new javax.swing.JComboBox<>();
			jComboBox3 = new javax.swing.JComboBox<>();
			jLabel6 = new javax.swing.JLabel();
			jComboBox4 = new javax.swing.JComboBox<>();
			jLabel7 = new javax.swing.JLabel();
			jTextField4 = new javax.swing.JTextField("");
			jLabel8 = new javax.swing.JLabel();
			jComboBox5 = new javax.swing.JComboBox<>();
			jComboBox6 = new javax.swing.JComboBox<>();
			jComboBox7 = new javax.swing.JComboBox<>();
			jLabel9 = new javax.swing.JLabel();
			jScrollPane1 = new javax.swing.JScrollPane();
			jTextArea1 = new javax.swing.JTextArea("");
			jLabel10 = new javax.swing.JLabel();
			jScrollPane2 = new javax.swing.JScrollPane();
			jTextArea2 = new javax.swing.JTextArea("");
			jButton1 = new javax.swing.JButton();
			jLabel11 = new javax.swing.JLabel();
			jTextField5 = new javax.swing.JTextField("");
			
			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			switch(mode){
				case ADD: setTitle("Crear Paciente"); break;
			    case VISTA: setTitle("Paciente"); break;
			    case EDITAR: setTitle("Editar Paciente"); break;
				default: new Error("Problema en el modo en pantalla pacientes."); break;
			}
			
			jLabel1.setText("Datos Personales: ");
			
			jLabel2.setText("Nombre: ");
			
			jLabel3.setText("Primer Apellido:");
			
			jLabel4.setText("Segundo Apellido:");
			
			jLabel11.setText("DNI:");
			
			jLabel5.setText("Fecha de Nacimiento: ");
			
			jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
			
			jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
			
			jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", " " }));
			
			jLabel6.setText("Estado Civil: ");
			
			jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado", "Soltero", "Divorciado", "Viudo" }));
			
			jLabel7.setText("Lesión: ");
			
			jLabel8.setText("Fecha de Lesión:");
			
			jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
			
			jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
			
			jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", " " }));
			
			jLabel9.setText("Perfil: ");
			
			jTextArea1.setColumns(20);
			jTextArea1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
			jTextArea1.setRows(5);
			jTextArea1.setText("Insertar aquí una descripción del paciente");
			jScrollPane1.setViewportView(jTextArea1);
			
			jLabel10.setText("Aficiones: (separadas por comas)");
			
			jTextArea2.setColumns(20);
			jTextArea2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
			jTextArea2.setRows(5);
			jScrollPane2.setViewportView(jTextArea2);
			
			jButton1.setText("Guardar");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
			
			if(pac!=null){
				jTextField1.setText(pac.getName());
				jTextField2.setText(pac.getFirstSurname());
				jTextField3.setText(pac.getSecondSurname());
				jTextField4.setText(pac.getDatos().getLesion());
				jTextField5.setText(pac.getNif());
				jTextArea1.setText(Controlador.tratarAficiones(pac.getDatos().getAficiones()));
				Fecha birthday = pac.getBirthday();
				if(birthday!=null){
					jComboBox1.setSelectedIndex(birthday.getDia()-1);
					jComboBox2.setSelectedIndex(birthday.getMesIndex());
					jComboBox3.setSelectedIndex(birthday.getAnyo()-1900);
				}
				Fecha lesionday = pac.getDatos().getFechalesion();
				if(lesionday!=null){
					jComboBox5.setSelectedIndex(lesionday.getDia()-1);
					jComboBox6.setSelectedIndex(lesionday.getMesIndex());
					jComboBox7.setSelectedIndex(lesionday.getAnyo()-1900);
				}
				EstadoCivil estadoCivil = pac.getEstadoCivil();
				if(estadoCivil!=null){
					for(int i=0; i<4; i++){
						if(EstadoCivil.values()[i].equals(estadoCivil))jComboBox4.setSelectedIndex(i);
					}
				}
				jTextArea2.setText(pac.getPerfil());
			}
			
			if(!editable){
				jTextField1.setEditable(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField5.setEditable(false);
				jComboBox1.setEnabled(false);
				jComboBox2.setEnabled(false);
				jButton1.setVisible(false);
		        jButton1.setEnabled(false);
				jComboBox3.setEnabled(false);
			}
						
			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
													.addComponent(jLabel5)
													.addComponent(jLabel6))
							                        	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							                            .addGroup(layout.createSequentialGroup()
							                            		.addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                                .addGap(0, 0, Short.MAX_VALUE))
							                            .addGroup(layout.createSequentialGroup()
							                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
							                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
							                            .addGroup(layout.createSequentialGroup()
							                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							                                    .addComponent(jLabel2)
							                                    .addComponent(jLabel1)
							                                    .addComponent(jLabel3)
							                                    .addComponent(jLabel4)
							                                    .addComponent(jLabel11))
							                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							                                    .addGroup(layout.createSequentialGroup()
							                                        .addGap(0, 0, Short.MAX_VALUE)
							                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							                                            .addComponent(jTextField1)
							                                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
							                                    .addComponent(jTextField3)
							                                    .addComponent(jTextField5)))
							                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
							                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							                                    .addComponent(jLabel7)
							                                    .addComponent(jLabel8))
							                                .addGap(17, 17, 17)
							                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							                                    .addGroup(layout.createSequentialGroup()
							                                        .addGap(10, 10, 10)
							                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                                        .addGap(0, 0, Short.MAX_VALUE))
							                                    .addComponent(jTextField4))))
							                        .addGap(31, 31, 31))
							                    .addGroup(layout.createSequentialGroup()
							                        .addComponent(jLabel10)
							                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							                    .addGroup(layout.createSequentialGroup()
							                        .addComponent(jLabel9)
							                        .addGap(0, 0, Short.MAX_VALUE))
							                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
							                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
							                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
							                            .addComponent(jScrollPane2))
							                        .addContainerGap())))
							            .addGroup(layout.createSequentialGroup()
							                .addGap(126, 126, 126)
							                .addComponent(jButton1)
							                .addGap(0, 0, Short.MAX_VALUE))
							        );
							        layout.setVerticalGroup(
							            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							            .addGroup(layout.createSequentialGroup()
							                .addContainerGap()
							                .addComponent(jLabel1)
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							                    .addComponent(jLabel2)
							                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							                    .addComponent(jLabel3)
							                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							                    .addComponent(jLabel4)
							                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							                    .addComponent(jLabel11)
							                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							                    .addComponent(jLabel5)
							                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							                    .addComponent(jLabel6)
							                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							                    .addComponent(jLabel7)
							                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							                    .addComponent(jLabel8)
							                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							                .addComponent(jLabel10)
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							                .addComponent(jLabel9)
							                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							                .addGap(18, 18, 18)
							                .addComponent(jButton1)
							                .addGap(18, 18, 18))
							        );
			getContentPane().setBackground(getColor());
			pack();
		}
		
		/**
		 * Función que se ejecuta al darle a guardar en la ventana de Paciente. Se rellena un objeto paciente
		 * y es pasado al controlador para que lo añada si estamos en modo añadir o para que sobreescriba
		 * a un paciente antiguo si estamos en modo editar.
		 * */
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
			
			System.out.println(Controlador.getUsuario());
			String aficionestodo = jTextArea2.getText();
			String aficiones[] = aficionestodo.split(",");
			
			Fecha nacimiento = new Fecha(Integer.valueOf(String.valueOf(jComboBox1.getSelectedItem())), String.valueOf(jComboBox2.getSelectedItem()), Integer.parseInt(String.valueOf(jComboBox3.getSelectedItem())), 0);
			Fecha fechaLesion = new Fecha(Integer.valueOf(String.valueOf(jComboBox5.getSelectedItem())), String.valueOf(jComboBox6.getSelectedItem()), Integer.parseInt(String.valueOf(jComboBox7.getSelectedItem())), 0);
			String nombre = jTextField1.getText();
			String DNI = jTextField5.getText();
			String lesion = jTextField4.getText();
			if(nombre.equals("") || DNI.equals("") || lesion.equals("") ) new Error("Han de rellenarse los campos de nombre, dni y lesion");
			else{
				Paciente info = new Paciente(nombre, jTextField2.getText(), jTextField3.getText(), jTextField5.getText());
				
				info.setEstadoCivil(String.valueOf(jComboBox4.getSelectedItem()));
				info.setBirthday(nacimiento);
				info.setPerfil(jTextArea2.getText());
				info.getDatos().setLesion(lesion);
				info.getDatos().setFechalesion(fechaLesion);
				
				for(String str: aficiones)
					info.getDatos().addAficion(str);
				
				if(mode.equals(Modo.ADD)) Controlador.addPaciente(info);
				else if(mode.equals(Modo.VISTA)) Controlador.modificaPaciente(pac, info);
				dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		} 
	}


	/**
	 * Clase que gestiona la ventana que permite buscar un paciente. Esta ventana es la que 
	 * aparece al seleccionar los botones -Buscar-, -Editar- y -Eliminar-.
	 * @author Diedral_Group
	 * 
	 */     
	private class PantallaBuscar extends JFrame implements confirmListener{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -5453880899658964801L;
		
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
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
	    private Modo modo;
		private Paciente[] resultados;   
	    
	    public PantallaBuscar(Modo modo) {
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

	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        
	        switch(modo){
				case ELIMINAR:
					setTitle("Eliminar Paciente");
			    	break;
				case EDITAR:
					setTitle("Editar Paciente");
					break;
				case BUSCAR:
					setTitle("Buscar Paciente");
					break;
				default:
					new Error("Error raro en pantalla de búsqueda de pacientes");
					break;
			}

	        jLabel1.setText("Nombre:");

	        jLabel2.setText("Primer Apellido:");

	        jLabel3.setText("Segundo Apellido:");

	        jLabel4.setText("DNI:");

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
	                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
	                                .addGap(30, 30, 30))
	                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                .addContainerGap()
	                                .addComponent(jLabel3)
	                                .addGap(18, 18, 18)))
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
	                    .addComponent(jButton2))
	                .addContainerGap(29, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(26, 26, 26)
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
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel4))
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addContainerGap(16, Short.MAX_VALUE)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jButton2)
	                            .addComponent(jButton1))))
	                .addGap(23, 23, 23))
	            .addComponent(jSeparator2)
	        );
	        
	        getContentPane().setBackground(getColor());
	        pack();
	    }
	    
		/**
		 * Función que se ejecuta al darle al botón buscar. Rellena un Paciente con los datos introducidos y 
		 * busca en el sistema a todos los que coincidan con él.
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
			
			resultados = Controlador.buscarPaciente(claves, valores);
			
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
		 * Si el modo es Editar o buscar, se crea una pantalla Paciente y se le pasa el control.
		 * @param evt
		 */
		private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {        
			int i = jList1.getSelectedIndex(); JFrame j; Paciente p = null;
			if(i != -1){
				switch(modo){
				case ELIMINAR:
					Confirm c = new Confirm();
					c.setMensaje("El paciente se eliminará del sistema.");
			    	c.setVisible(true);
			    	c.addListener(this);
			    	break;
				case EDITAR:
					i = jList1.getSelectedIndex();
					p = resultados[i];
					j = new PantallaPaciente(p, Modo.EDITAR);
					j.setVisible(true);
					break;
				case BUSCAR:
					i = jList1.getSelectedIndex();
					p = resultados[i];
					j = new PantallaPaciente(p, Modo.VISTA);
					j.setVisible(true);
					break;
				default:
					new Error("Error interno en la pantalla buscar pacientes.");
					break;
				}
			}
			
		}  
		
		/**
	     * Se llama a esta funci�n al pulsar el bot�n -S�- en confirmar. Le dice al controlador que elimine al paciente.
	     */
	    public void delete(){
	    	int i = jList1.getSelectedIndex();
	    	Controlador.deletePaciente(resultados[i]);
	    	this.dispose();
	    }
	}


}
	
