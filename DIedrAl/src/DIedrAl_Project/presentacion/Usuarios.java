package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Usuarios extends ColorPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5881613145077329549L;


	public Usuarios(int r, int g, int b){
		super(r, g, b);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Usuarios");
		title.setFont(font);
		title.setForeground(Color.WHITE);
		add(title, c);
		
		
		ImageButton nuevo = new ImageButton("Añadir", "images/bluebutton.png", "images/bluebutton2.png", this);
		nuevo.addActionListener((ae) -> {
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
		add(nuevo, c);
		
		
		
		ImageButton buscar = new ImageButton("Buscar", "images/orangebutton.png", "images/orangebutton2.png", this);
		buscar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 1;
		c.gridy = 1;
		add(buscar, c);
	}
}
