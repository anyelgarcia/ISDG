package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import DIedrAl_Project.negocio.calendario.Fecha;


public class Pacientes extends ColorPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6246895766907491090L;      
    
	public Pacientes(int r, int g, int b){
		super(r,g,b);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 4;
		c.gridy = 2;
		JLabel title = new JLabel("Pacientes");
		title.setFont(font);
		title.setForeground(Color.WHITE);
		add(title, c);
		
		
		JButton buscar = new JButton("Buscar");
		componentes.add(buscar);
		buscar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 3;
		c.gridy = 0;
		add(buscar, c);
		
		
		JButton eliminar = new JButton("Eliminar");
		componentes.add(eliminar);
		eliminar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 5;
		c.gridy = 0;
		add(eliminar, c);


		
		JButton anadir = new JButton("Añadir");
		componentes.add(anadir);
		anadir.addActionListener((ae) -> {
			JFrame pantalla = new PantallaAdd();
			pantalla.setVisible(true);
		});
		c.gridx = 3;
		c.gridy = 4;
		add(anadir, c);
		
		
		JButton editar = new JButton("Editar");
		componentes.add(editar);
		editar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 5;
		c.gridy = 4;
		c.insets = new Insets(0,5,0,0);
		add(editar, c);
		
	}
	                                        
	private class PantallaAdd extends JFrame{
		
		 /**
		 * 
		 */
		private static final long serialVersionUID = -4023107552010703559L;
		
		// Variables declaration - do not modify                     
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
	    // End of variables declaration     
	    
		public PantallaAdd(){
			initGUI();
		}
		private void initGUI(){
			jLabel1 = new javax.swing.JLabel();
			jLabel2 = new javax.swing.JLabel();
			jLabel3 = new javax.swing.JLabel();
			jLabel4 = new javax.swing.JLabel();
			jTextField1 = new javax.swing.JTextField();
			jTextField2 = new javax.swing.JTextField();
			jTextField3 = new javax.swing.JTextField();
			jLabel5 = new javax.swing.JLabel();
			jComboBox1 = new javax.swing.JComboBox<>();
			jComboBox2 = new javax.swing.JComboBox<>();
			jComboBox3 = new javax.swing.JComboBox<>();
			jLabel6 = new javax.swing.JLabel();
			jComboBox4 = new javax.swing.JComboBox<>();
			jLabel7 = new javax.swing.JLabel();
			jTextField4 = new javax.swing.JTextField();
			jLabel8 = new javax.swing.JLabel();
			jComboBox5 = new javax.swing.JComboBox<>();
			jComboBox6 = new javax.swing.JComboBox<>();
			jComboBox7 = new javax.swing.JComboBox<>();
			jLabel9 = new javax.swing.JLabel();
			jScrollPane1 = new javax.swing.JScrollPane();
			jTextArea1 = new javax.swing.JTextArea();
			jLabel10 = new javax.swing.JLabel();
			jScrollPane2 = new javax.swing.JScrollPane();
			jTextArea2 = new javax.swing.JTextArea();
			jButton1 = new javax.swing.JButton();
			
			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			setTitle("Crear Paciente");
			setName("Crear Paciente"); // NOI18N
			
			jLabel1.setText("Datos Personales: ");
			
			jLabel2.setText("Nombre: ");
			
			jLabel3.setText("Primer Apellido:");
			
			jLabel4.setText("Segundo Apellido:");
			
			
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
			
			jLabel10.setText("Aficiones: ");
			
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
							                                    .addComponent(jLabel4))
							                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
							                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							                                    .addGroup(layout.createSequentialGroup()
							                                        .addGap(0, 0, Short.MAX_VALUE)
							                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							                                            .addComponent(jTextField1)
							                                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
							                                    .addComponent(jTextField3)))
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
					
							       pack();
		}
		
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
			 // TODO add your handling code here:
		} 
	}
						 

}
	
