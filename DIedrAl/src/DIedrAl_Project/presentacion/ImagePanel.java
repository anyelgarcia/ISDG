package DIedrAl_Project.presentacion;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(Toolkit.getDefaultToolkit().createImage(img));
    }

    public ImagePanel(Image img) {
        this.img = img;
        setLayout(new GridBagLayout());
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
    
    public static void addTextField(JFrame pantalla, String nombre){
    	pantalla.add(new JLabel(nombre));
    	pantalla.add(new JTextField(nombre));
    }
    public static void addComboBox(JFrame pantalla, String nombre, String ... valores){
    	pantalla.add(new JLabel(nombre));
    	pantalla.add(new JComboBox<String>(valores));
    }
}
