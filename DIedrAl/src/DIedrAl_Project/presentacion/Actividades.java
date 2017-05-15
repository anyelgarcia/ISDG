package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Actividades extends ColorPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6517855682994096031L;

	public Actividades(int r, int g, int b){
		super(r,g,b);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 20);
		JLabel title = new JLabel("Actividades");
		title.setFont(font);
		title.setForeground(Color.BLACK);
		add(title, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		
		
		
		JButton nuevo = new JButton("Crear Nuevo");
		componentes.add(nuevo);
		nuevo.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		add(nuevo, c);
		
		
		
		JButton buscar = new JButton("Buscar");
		componentes.add(buscar);
		buscar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 1;
		c.gridy = 1;
		add(buscar, c);
		
		
		
		
		JButton eliminar = new JButton("Eliminar");
		componentes.add(eliminar);
		eliminar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 2;
		c.gridy = 1;
		add(eliminar, c);
		setVisible(true);
	}
}
