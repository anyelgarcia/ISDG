package presentacion;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Actividades extends JPanel{
	public Actividades(){
		setBorder(BorderFactory.createLineBorder(Color.black));
		add(new JButton("Crear Nuevo"));
		add(new JButton("Buscar"));
		add(new JButton("Eliminar"));
		setVisible(true);
	}
}
