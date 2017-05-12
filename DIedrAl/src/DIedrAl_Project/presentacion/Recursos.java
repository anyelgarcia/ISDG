package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Recursos extends ImagePanel{
	
	public Recursos(String img){
		super(img);
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 20);
		JLabel title = new JLabel("Recursos");
		title.setFont(new Font("Helvetica", Font.BOLD, 20));
		title.setForeground(Color.BLACK);
		add(title, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		add(new JButton("Crear Nuevo"), c);
		
		c.gridx = 1;
		c.gridy = 1;
		add(new JButton("Buscar"), c);
		
		c.gridx = 2;
		c.gridy = 1;
		add(new JButton("Eliminar"), c);
		setVisible(true);
	}

}
