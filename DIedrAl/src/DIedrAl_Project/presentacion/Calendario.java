package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;*/



public class Calendario extends ColorPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 197254297067260869L;
	public final static String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};	
	public final static String[] DIAS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public final static String[] ANOS = {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000"};
	


	public Calendario(int r, int g, int b){
		super(r, g, b);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Calendario");
		title.setFont(font);
		title.setForeground(Color.WHITE);
		add(title, c);
	
		
		ImageButton modificar = new ImageButton("Modificar", "images/bluebutton.png", "images/bluebutton2.png", this);
		modificar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(25,15,0,0);
		c.ipady = 0;
		add(modificar, c);
		
		
		
		ImageButton consultar = new ImageButton("Consultar", "images/greenbutton.png", "images/greenbutton2.png", this);
		consultar.addActionListener((ae) -> {
			
			PantallaConsulta panel = new PantallaConsulta();
			panel.setVisible(true);
			
		});
		c.gridx = 1;
		c.gridy = 1;
		add(consultar, c);
	}

	private class DateLabelFormatter extends AbstractFormatter {
	
	    private String datePattern = "dd-MM-yyyy";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	
	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }
	
	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }
	
	        return "";
	    }
	
	}
	
	private class PantallaConsulta extends JFrame{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 8212605120246565172L;
		 private javax.swing.JButton jButton2;
		    private javax.swing.JLabel jLabel1;
		    private javax.swing.JList<String> jList1;
		    private javax.swing.JScrollPane jScrollPane1;
		    private javax.swing.JSeparator jSeparator1;
		    private javax.swing.JPanel jPanel1;
		    /*private JDatePickerImpl datePicker; 
		    private JDatePanelImpl jPanel2;*/
	    
	    public PantallaConsulta() {
	        initGUI();
	    }
        
	    private void initGUI() {

	    	jPanel1 = new javax.swing.JPanel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jList1 = new javax.swing.JList<>();
	        jSeparator1 = new javax.swing.JSeparator();
	        jButton2 = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();

	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	        
	       // UtilDateModel model = new UtilDateModel();
		    GregorianCalendar fecha = new GregorianCalendar();
	        
 	       // model.setDate(Integer.parseInt(new SimpleDateFormat("yyyy").format(fecha.getTime())), 
 	        //		Integer.parseInt(new SimpleDateFormat("MM").format(fecha.getTime())) - 1, 
 	        //		Integer.parseInt(new SimpleDateFormat("dd").format(fecha.getTime())));

	        Properties p = new Properties();
	        p.put("text.today", "Today");
	        p.put("text.month", "Month");
	        p.put("text.year", "Year");
	        
	        /*jPanel2 = new JDatePanelImpl(model, p);
	        datePicker = new JDatePickerImpl(jPanel2, new DateLabelFormatter());
	        datePicker.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jDateActionPerformed(evt);
	            }
	        });
	        jPanel1.add(datePicker);
	        
	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 213, Short.MAX_VALUE)
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );

	        jList1.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane1.setViewportView(jList1);

	        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

	        jButton2.setText("Seleccionar");

	        jLabel1.setText("Sesiones del día:");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jButton2)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel1))
	                .addContainerGap(29, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGap(20, 20, 20)
	                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGap(50, 50, 50)
	                .addContainerGap())
	            .addGroup(layout.createSequentialGroup()
	                .addGap(31, 31, 31)
	                .addComponent(jLabel1)
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jButton2)
	                .addContainerGap(37, Short.MAX_VALUE))
	            .addComponent(jSeparator1)
	        );

	        pack();
	        */
	    }
	    
	    private void jDateActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	//Date selectedDate = (Date) datePicker.getModel().getValue();
	        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        //System.out.println(df.format(selectedDate));
	    }  
	    
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {    
	    }  
	}
}

