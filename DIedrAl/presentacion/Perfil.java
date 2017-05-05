package presentacion;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Perfil extends JPanel{
	
	public Perfil(){
		setBorder(BorderFactory.createLineBorder(Color.black));
		add(new JButton("Ver perfil"));
		add(new JButton("Editar"));
	}
}

