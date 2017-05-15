package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class ColorPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 690793639249179522L;
	private Color color;
    protected Font font = new Font("Rockwell", Font.BOLD, 20);
    protected ArrayList<Component> componentes;

    public ColorPanel(int r, int g, int b) {
        componentes = new ArrayList<Component>();
        color = new Color(r, g, b);
        setOpaque(true);
        setBackground(color);  
        setLayout(new GridBagLayout());
    }
    
    public static void addTextField(JFrame pantalla,  GridBagConstraints c, String nombre ){
    	pantalla.add(new JLabel(nombre), c);
    	pantalla.add(new JTextField(nombre), c);
    }
    public static void addTextField(JFrame pantalla, String nombre){
    	pantalla.add(new JLabel(nombre));
    	pantalla.add(new JTextField(nombre));
    }
    
    
    public static void addComboBox(JFrame pantalla, String nombre, String ... valores){
    	pantalla.add(new JLabel(nombre));
    	pantalla.add(new JComboBox<String>(valores));
    }
    public static void addComboBox(JFrame pantalla, GridBagConstraints c,  String nombre, String ... valores){
    	pantalla.add(new JLabel(nombre), c);
    	pantalla.add(new JComboBox<String>(valores), c);
    }
}
