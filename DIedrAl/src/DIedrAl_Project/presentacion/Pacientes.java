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
			
			JFrame panel = new JFrame();
			panel.setLayout(new GridLayout(8,2,2,2));
			addTextField(panel, "Nombre");
			panel.add(new JLabel("Fecha de Nacimiento"));
			panel.add(new JLabel(""));
			addComboBox(panel, "Día", Fecha.DIAS);
			addComboBox(panel, "Mes", Fecha.MESES);
			addComboBox(panel, "Año", Fecha.ANOS);
			panel.setSize(450, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
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

	
	
	
	
	
	
}
