package DIedrAl_Project.presentacion.secciones;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import DIedrAl_Project.presentacion.auxiliar.ColorPanel;
import DIedrAl_Project.presentacion.auxiliar.ImageButton;
import DIedrAl_Project.presentacion.auxiliar.Modo;


/**
 * Esta clase lleva la gestión de las vistas de las sesiones. En el constructor se dibuja la sección de Sesiones del Menú Principal y se pone a la espera para 
 * añadir, eliminar, editar o buscar sesiones.
 * @author Diedral_Group
 *
 */

public class Sesiones extends ColorPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7805554218246174830L;


	public Sesiones(int r, int g, int b){
		super(r, g, b);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.ipady= 20;
		c.insets = new Insets(0,15,0,0);
		JLabel title = new JLabel("Sesiones");
		title.setFont(font);
		title.setForeground(Color.WHITE);
		add(title, c);



		ImageButton nuevo = new ImageButton("  Crear  ", "images/greenbutton.png", "images/greenbutton2.png", this);
		nuevo.addActionListener((ae) -> {
			JFrame pantalla = new PantallaSesion(null, Modo.ADD);
			pantalla.setVisible(true);
		});
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(25,15,0,0);
		c.ipady = 0;
		add(nuevo, c);



		ImageButton buscar = new ImageButton(" Buscar  ", "images/bluebutton.png", "images/bluebutton2.png", this);
		buscar.addActionListener((ae) -> {
			JFrame pantalla = new PantallaSesionBuscar(Modo.BUSCAR);
			pantalla.setVisible(true);
		});
		c.gridx = 1;
		c.gridy = 1;
		add(buscar, c);



		ImageButton eliminar = new ImageButton("Eliminar", "images/blackbutton.png", "images/blackbutton2.png", this);
		eliminar.addActionListener((ae) -> {
			JFrame pantalla = new PantallaSesionBuscar(Modo.ELIMINAR);
			pantalla.setVisible(true);
		});
		c.gridx = 1;
		c.gridy = 2;
		add(eliminar, c);

		ImageButton editar = new ImageButton("Editar", "images/tanbutton.png", "images/tanbutton2.png", this);
		componentes.add(editar);
		editar.addActionListener((ae) -> {
			JFrame panel = new PantallaSesionBuscar(Modo.EDITAR);
			panel.setVisible(true);

		});
		c.gridx = 0;
		c.gridy = 2;
		add(editar, c);

		setVisible(true);
	}
}


