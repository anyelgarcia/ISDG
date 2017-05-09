package presentacion;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Usuarios extends JPanel{
	
	public Usuarios(){
		setBorder(BorderFactory.createLineBorder(Color.black));
		add(new JButton("Añadir"));
		add(new JButton("Buscar"));
	}
}
