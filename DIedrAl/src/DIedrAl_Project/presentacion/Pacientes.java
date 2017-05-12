package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pacientes extends ImagePanel{

	public Pacientes(String img){
		super(img);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 3;
		c.gridy = 0;
		JLabel title = new JLabel("Pacientes");
		title.setFont(new Font("Helvetica", Font.BOLD, 20));
		title.setForeground(Color.WHITE);
		add(title, c);
		
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 0;
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


		
		JButton anadir = new JButton("Añadir");
		anadir.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			panel.setLayout(new GridLayout(8,2,1,1));
			addTextField(panel, "Nombre");
			addComboBox(panel, "Fecha de nacimiento", "a", "b", "c");
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 4;
		c.gridy = 1;
		add(anadir, c);
		
		
		JButton editar = new JButton("Editar");
		editar.addActionListener((ae) -> {
			JFrame panel = new JFrame();
			
			panel.setSize(300, 400);
			panel.setVisible(true);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		});
		c.gridx = 6;
		c.gridy = 1;
		c.insets = new Insets(0,5,0,0);
		add(editar, c);
		
	}

	
	
	
	
	
	
}
