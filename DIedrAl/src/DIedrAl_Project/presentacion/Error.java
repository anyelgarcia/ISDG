package DIedrAl_Project.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;


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
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

}
