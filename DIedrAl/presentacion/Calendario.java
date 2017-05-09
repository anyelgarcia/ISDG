package presentacion;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Calendario extends JPanel{
	
	public Calendario(){
		setBorder(BorderFactory.createLineBorder(Color.black));
		add(new JButton("Modificar"));
		add(new JButton("Consultar"));
	}
}
