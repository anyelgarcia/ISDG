package DIedrAl_Project.presentacion;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Pacientes extends JPanel{

	public Pacientes(){
		setBorder(BorderFactory.createLineBorder(Color.black));
		add(new JButton("Buscar"));
		add(new JButton("Eliminar"));
		add(new JButton("Añadir"));
	}

}
