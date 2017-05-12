package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calendario extends ImagePanel{
	
	public Calendario(String img){
		super(img);
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 0;
		JLabel title = new JLabel("Calendario");
		title.setFont(new Font("Helvetica", Font.BOLD, 20));
		title.setForeground(Color.WHITE);
		add(title, c);
		
		
		c.gridx = 0;
		c.gridy = 1;
		add(new JButton("Modificar"), c);
		
		c.gridx = 2;
		c.gridy = 1;
		add(new JButton("Consultar"), c);
	}
}
