package DIedrAl_Project.presentacion.auxiliar;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Crea una ventana de error, con un mensaje. Utilizada para mostrar mensajes si se producen excepciones
 *
 */
public class Error extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2339935005104485121L;

	public Error(String mensaje){
		JLabel jlabel = new JLabel("  " + mensaje);
		jlabel.setFont(new java.awt.Font("SansSerif", 1, 13));
		add(jlabel);
		setVisible(true);
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
		Font font = new Font("Arial", Font.PLAIN, 12);
		int textwidth = (int)(font.getStringBounds(mensaje, frc).getWidth());
		setSize(textwidth + 200, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

}
