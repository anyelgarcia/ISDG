package DIedrAl_Project.presentacion.secciones;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.calendario.SesionProgramada;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.presentacion.Controlador;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.presentacion.auxiliar.Modo;

public class PantallaSesionProgramada extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360052013258980696L;
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;  
    private Sesion sesion;
    private Modo modo;
    private Paciente pacientes[];
    private Usuario terapeutas[];
    private Paciente pacientesSesion[];
    private Usuario terapeutasSesion[];
    
    public PantallaSesionProgramada(Sesion sesion, Modo modo) {
    	this.sesion = sesion;
    	this.modo = modo;
    	pacientes = new Paciente[0];
        terapeutas = new Usuario[0];
        pacientesSesion = new Paciente[0];
        terapeutasSesion = new Usuario[0];
        initGUI();
    }
    
    private void initGUI() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();

        
        switch(modo){
        	case ADD: setTitle("Añadir Sesión Programada"); break;
        	case EDITAR: setTitle("Editar Sesión Programada"); break;
        	case VISTA: setTitle("Consultar Sesión Programada"); break;
        	default: new Error("Error raro modo Sesión Programada");
        }
        

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(Calendario.DIAS));
		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(Calendario.MESES));
		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(Calendario.AÑOS));
		
        if(sesion!=null){
        	
        	jTextField1.setText(sesion.getNombre());
        	jTextField2.setText(String.valueOf(sesion.getDuracion()));
        	jTextArea1.setText(sesion.getDescripcion());
        	
        	StringBuilder etiq= new StringBuilder();
        	int i=1;
        	for(String str: sesion.getEtiquetas()){
        		etiq.append(str);
	        	if(i<sesion.getEtiquetas().size()){
	        		etiq.append(", ");
	        	}
	        	++i;
        	} 
        	
			jTextArea2.setText(etiq.toString());
        	jTextArea3.setText(sesion.getDesarrollo());
        	jTextArea4.setText(sesion.getVariaciones());
        	
        	if(sesion instanceof SesionProgramada){
        		
        		Fecha fecha = ((SesionProgramada) sesion).getFecha();
        		
        		if(fecha!=null){
					jComboBox1.setSelectedIndex(fecha.getDia()-1);
					jComboBox2.setSelectedIndex(fecha.getMesIndex());
					jComboBox3.setSelectedIndex(2017-fecha.getAño());
				}
        		
        		Set<String> nifsPac = ((SesionProgramada) sesion).getPacientes();
        		i=0;
        		pacientesSesion = new Paciente[nifsPac.size()];
        		for(String nif: nifsPac){
        			pacientesSesion[i] = Controlador.getPacienteConNif(nif);
        			i++;
        		}
        		Set<String> nifsTer = ((SesionProgramada) sesion).getTerapeutas();
        		i=0;
        		terapeutasSesion = new Usuario[nifsTer.size()];
        		for(String nif: nifsTer){
        			terapeutasSesion[i] = Controlador.getUsuarioConNif(nif);
        			i++;
        		}
        		
        		jList4.setModel(new javax.swing.AbstractListModel<String>() {
        			private static final long serialVersionUID = 1L;
                    public int getSize() { return terapeutasSesion.length; }
                    public String getElementAt(int j) { return (terapeutasSesion[j]).toString(); }
                });

                jList5.setModel(new javax.swing.AbstractListModel<String>() {
        			private static final long serialVersionUID = 1L;
                    public int getSize() { return pacientesSesion.length; }
                    public String getElementAt(int j) { return (pacientesSesion[j]).toString(); }
                });
        		
        	}
        }
        if(pacientesSesion==null && terapeutasSesion==null){
        	jList4.setModel(new javax.swing.AbstractListModel<String>() {
    			private static final long serialVersionUID = 1L;
    			String strings[] = {};
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });

            jList5.setModel(new javax.swing.AbstractListModel<String>() {
    			private static final long serialVersionUID = 1L;
    			String strings[] = {};
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
        }

        jScrollPane8.setViewportView(jList4);
        jScrollPane9.setViewportView(jList5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel1.setText("Nombre:");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel2.setText("Duración:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel3.setText("Descripción:");
        jLabel3.setToolTipText("");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel4.setText("Etiquetas:");
        jLabel4.setToolTipText("");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel5.setText("Desarrollo de la Sesión");
        jLabel5.setToolTipText("");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel6.setText("Posibles Variaciones");
        jLabel6.setToolTipText("");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jList1); 
        jList1.getAccessibleContext().setAccessibleParent(null);

        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jList2);
        jList2.getAccessibleContext().setAccessibleParent(null);

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel7.setText("minutos");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel8.setText("Recursos Empleados");
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel9.setText("Actividades Empleadas");
        jLabel9.setToolTipText("");

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


				
        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel10.setText("Fecha:");

        
        Hints hints1[] = {Hints.PACIENTE};
		String valores[] = {"comodín"};
		pacientes = Controlador.buscarPaciente(hints1, valores);
		Hints hints2[] = {Hints.USUARIO};
		terapeutas = Controlador.buscarUsuario(hints2, valores);        
		
		jList6.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
            public int getSize() { return terapeutas!= null ? terapeutas.length : 0; }
            public String getElementAt(int i) { return (terapeutas[i]).toString(); }
        });
        jScrollPane10.setViewportView(jList6);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
            public int getSize() { return pacientes!= null ? pacientes.length : 0; }
            public String getElementAt(int i) { return (pacientes[i]).toString(); }
        });
        jScrollPane7.setViewportView(jList3);
        
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel11.setText("Pacientes:");
        jLabel11.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel12.setText("Terapeutas:");
        jLabel12.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel13.setText("Búsqueda (pacientes):");
        jLabel13.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel14.setText("Búsqueda (terapeutas):");
        jLabel14.setToolTipText("");

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12));
        jButton2.setText("Quitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jButton3.setText("Quitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jButton5.setText("Añadir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jButton6.setText("Añadir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        
        jButton7.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jButton7.setText(" Buscar ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        
        jButton8.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jButton8.setText(" Buscar ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel15.setText("Nombre:");
        jLabel15.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel16.setText("Primer Apellido:");
        jLabel16.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel17.setText("Segundo Apellido:");
        jLabel17.setToolTipText("");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel18.setText("DNI:");
        jLabel18.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel19.setText("Nombre:");
        jLabel19.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel20.setText("Primer Apellido:");
        jLabel20.setToolTipText("");

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel21.setText("Segundo Apellido:");
        jLabel21.setToolTipText("");

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 12)); 
        jLabel22.setText("DNI:");
        jLabel22.setToolTipText("");
        
        if(!modo.equals(Modo.ADD)){
        	jTextField1.setEditable(false);
        	if(modo.equals(Modo.VISTA)){
        		jButton1.setVisible(false);
    			jButton1.setEnabled(false);
        	}
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(22, 22, 22)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, 166, 166, 166)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel8)))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, 166, 166, 166)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel4))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jButton2)
                                .addGap(105, 105, 105)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(jLabel11)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(29, 29, 29))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel12)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel14)))))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)  
                                    .addComponent(jLabel18)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(480, 480, 480)
                        .addComponent(jButton3)
                        .addGap(95, 95, 95)
                        .addComponent(jButton6)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton5)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                ))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, 166, 166, 166)
                            .addComponent(jScrollPane6, 166, 166, 166))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        ))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton3))
                        .addContainerGap(13, Short.MAX_VALUE))))
        );

        getContentPane().setBackground(new Color(255, 111, 105));
        setVisible(true);
        pack();
    }                                          

    /**
     * Función que permite guardar y editar una sesión programada. Recoge los campos de la pantalla y 
     * rellena una plantilla de sesión programada. Según el modo, la guarda como sesión nueva
     * o actualiza una sesión anterior.
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	String etiquetasSinFormato = jTextArea2.getText();
		String etiquetas[] = etiquetasSinFormato.split(",");
		String nombre = jTextField1.getText();
		Fecha fecha = new Fecha(Integer.valueOf(String.valueOf(jComboBox1.getSelectedItem())), String.valueOf(jComboBox2.getSelectedItem()), Integer.parseInt(String.valueOf(jComboBox3.getSelectedItem())), 0);
		int duracion = 0;
		try{
			duracion = Integer.valueOf(String.valueOf((jTextField2.getText())));
		}catch(NumberFormatException e){
			new Error("La duración ha de ser un número entero mayor que cero.");
			return;
		}
		if(nombre.equals("") || (fecha.getAño()==2007 && fecha.getMes().equals("enero")&&fecha.getDia()==1))
			new Error("Hay que rellenar nombre y fecha");
		else{
			SesionProgramada info = new SesionProgramada(String.valueOf(jTextField1.getText()), fecha, etiquetas);
			info.setDuracion(duracion);
			info.setDescripcion(String.valueOf(jTextArea1.getText()));
			info.setDesarrollo(String.valueOf(jTextArea4.getText()));
			info.setVariaciones(String.valueOf(jTextArea3.getText()));
			for (Paciente p : pacientesSesion) {
				info.addPaciente(p.getNif());
			}
			for (Usuario t : terapeutasSesion) {
				info.addTerapeuta(t.getNif());
			}
			if(modo.equals(Modo.ADD)) Controlador.addSesionProgramada(info);
			else if(modo.equals(Modo.EDITAR)) Controlador.modificaSesionProg(sesion, info);
			else new Error("Error modo añadir sesión programada");
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
    }                                        

    /**
     * Se quita al paciente seleccionado y se reconstruye el modelo
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	int i = jList5.getSelectedIndex();
		if(i!=-1){
			ArrayList<Paciente> aux = new ArrayList<Paciente>();
			int n =pacientesSesion.length;
			for(int j=0; j<n; j++){
				if(i!=j)aux.add(pacientesSesion[j]);
			}
			pacientesSesion = new Paciente[aux.size()];
			i=0;
    		for(Paciente p: aux){
    			pacientesSesion[i] = p;
    			i++;
    		}

            jList5.setModel(new javax.swing.AbstractListModel<String>() {
    			private static final long serialVersionUID = 1L;
                public int getSize() { return pacientesSesion.length; }
                public String getElementAt(int i) { return (pacientesSesion[i]).toString(); }
            });
		}
		else new Error("Has de seleccionar al menos un paciente.");
    }                                        

    /**
     * Se añade al paciente seleccionado (si no está repetido) y se reconstruye el modelo
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	int i = jList3.getSelectedIndex();
		if(i!=-1){
			ArrayList<Paciente> aux = new ArrayList<Paciente>();
			int n=pacientesSesion.length;
			for(int j=0; j<n; j++){
				if(!((pacientesSesion[j].getNif()).equals(pacientes[i].getNif())))
					aux.add(pacientesSesion[j]);
			}
			aux.add(pacientes[i]);
			pacientesSesion = new Paciente[aux.size()];
			i=0;
    		for(Paciente u: aux){
    			pacientesSesion[i] = u;
    			i++;
    		}

    		jList5.setModel(new javax.swing.AbstractListModel<String>() {
    			private static final long serialVersionUID = 1L;
                public int getSize() { return pacientesSesion.length; }
                public String getElementAt(int h) { return (pacientesSesion[h]).toString(); }
            });
		}
		else new Error("Has de seleccionar al menos un Paciente.");
    	
    }                                        

    /**
     * Se quita al usuario seleccionado y se reconstruye el modelo
     * @param evt
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	int i = jList4.getSelectedIndex();
		if(i!=-1){
			ArrayList<Usuario> aux = new ArrayList<Usuario>();
			int n =terapeutasSesion.length;
			for(int j=0; j<n; j++){
				if(i!=j)aux.add(terapeutasSesion[j]);
			}
			terapeutasSesion= new Usuario[aux.size()];
			i=0;
    		for(Usuario u: aux){
    			terapeutasSesion[i] = u;
    			i++;
    		}

    		jList4.setModel(new javax.swing.AbstractListModel<String>() {
    			private static final long serialVersionUID = 1L;
                public int getSize() { return terapeutasSesion.length; }
                public String getElementAt(int i) { return (terapeutasSesion[i]).toString(); }
            });
		}
		else new Error("Has de seleccionar al menos un usuario.");
    }                                        

    /**
     * Se añade al usuario seleccionado (si no está repetido) y se reconstruye el modelo
     * @param evt
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {   
    	int i = jList6.getSelectedIndex();
		if(i!=-1){
			ArrayList<Usuario> aux = new ArrayList<Usuario>();
			int n =terapeutasSesion.length;
			for(int j=0; j<n; j++){
				if(!((terapeutasSesion[j].getNif()).equals(terapeutas[i].getNif())))
					aux.add(terapeutasSesion[j]);
			}
			aux.add(terapeutas[i]);
			terapeutasSesion= new Usuario[aux.size()];
			i=0;
    		for(Usuario u: aux){
    			terapeutasSesion[i] = u;
    			i++;
    		}

    		jList4.setModel(new javax.swing.AbstractListModel<String>() {
    			private static final long serialVersionUID = 1L;
                public int getSize() { return terapeutasSesion.length; }
                public String getElementAt(int i) { return (terapeutasSesion[i]).toString(); }
            });
		}
		else new Error("Has de seleccionar al menos un usuario.");
    	
    }   
    
    /**
     * Función que recoge los campos de búsqueda de pacientes y realiza la búsqueda,
     * actualizando la lista de pacientes.
     * @param evt
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	String nombre = jTextField3.getText();
		String apellido1 = jTextField4.getText();
		String apellido2 = jTextField5.getText();
		String DNI = jTextField6.getText();

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

		pacientes = Controlador.buscarPaciente(claves, valores);
		
		jList3.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
            public int getSize() { return pacientes!= null ? pacientes.length : 0; }
            public String getElementAt(int i) { return (pacientes[i]).toString(); }
        });
    }    
    
    /**
     * Función que recoge los campos de búsqueda de terapeutas y realiza la búsqueda,
     * actualizando la lista de terapeutas.
     * @param evt
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	String nombre = jTextField7.getText();
		String apellido1 = jTextField8.getText();
		String apellido2 = jTextField9.getText();
		String DNI = jTextField10.getText();

		ArrayList<String> campos = new ArrayList<String>();
		ArrayList<Hints> hints = new ArrayList<Hints>();
		Hints [] usuarios = null;

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

		usuarios = new Hints[1];
		usuarios[0] = Hints.USUARIO;
		
		Hints [] claves = hints.toArray(new Hints[hints.size()]);
		String [] valores = campos.toArray(new String[campos.size()]);

		terapeutas = Controlador.buscarUsuario(claves, valores);
		
		jList6.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
            public int getSize() { return terapeutas!= null ? terapeutas.length : 0; }
            public String getElementAt(int i) { return (terapeutas[i]).toString(); }
        });
    }    
    
    
     
}



