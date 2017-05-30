package DIedrAl_Project.presentacion.auxiliar;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;


public class ImagePanel extends JPanel {


    /**
	 * 
	 */
	private static final long serialVersionUID = 5874533583261306673L;
	private Image img;
    protected Font font = new Font("Rockwell", Font.BOLD, 40);
    protected ArrayList<Component> componentes;

    public ImagePanel(String img) {
        this(Toolkit.getDefaultToolkit().createImage(img));
        componentes = new ArrayList<Component>();
    }

    public ImagePanel(Image img) {
        this.img = img;
        setLayout(new GridBagLayout());
    }
    
    public void paintComponent(Graphics g){
    	g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}