package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Perfil extends ColorPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1443115839427152482L;

	public Perfil(int r, int g, int b){
		super(r, g, b);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 0;
		JLabel title = new JLabel("Mi Perfil");
		title.setFont(font);
		title.setForeground(Color.BLACK);
		add(title, c);
		
		JButton perfil = new JButton("Ver Perfil");
		perfil.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 0;
		c.gridy = 1;
		add(perfil, c);
		
		
		JButton editar = new JButton("Editar");
		editar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 2;
		c.gridy = 1;
		add(editar, c);
	}
}

