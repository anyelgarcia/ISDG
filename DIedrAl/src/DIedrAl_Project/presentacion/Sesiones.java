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

public class Sesiones extends ImagePanel{

		public Sesiones(String img){
			super(img);
			setBorder(BorderFactory.createLineBorder(Color.black));
			GridBagConstraints c = new GridBagConstraints();
			
			c.gridx = 1;
			c.gridy = 0;
			c.insets = new Insets(0, 0, 0, 20);
			JLabel title = new JLabel("Sesiones");
			title.setFont(new Font("Helvetica", Font.BOLD, 20));
			title.setForeground(Color.BLACK);
			add(title, c);
			
			
			
			JButton nuevo = new JButton("Crear Nuevo");
			nuevo.addActionListener((ae) -> {
				JFrame panel = new JFrame();
				
				panel.setSize(300, 400);
				panel.setVisible(true);
				panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			});
			c.gridx = 0;
			c.gridy = 1;
			c.insets = new Insets(0, 0, 0, 0);
			add(nuevo, c);
			
			
			
			JButton buscar = new JButton("Buscar");
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
