package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
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
		
		
		
		JButton modificar = new JButton("Modificar");
		modificar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 0;
		c.gridy = 1;
		add(modificar, c);
		
		
		
		JButton consultar = new JButton("Consultar");
		consultar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 2;
		c.gridy = 1;
		add(consultar, c);
	}
}
