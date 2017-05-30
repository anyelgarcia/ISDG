package DIedrAl_Project.presentacion;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Error extends JFrame{
	
	private String mensaje;
	
	public Error(String mensaje){
		this.mensaje = mensaje;
		JLabel jlabel = new JLabel("  " + mensaje);
		add(jlabel);
		setVisible(true);
		setSize(200, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
