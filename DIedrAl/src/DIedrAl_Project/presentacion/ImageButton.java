package DIedrAl_Project.presentacion;

import java.awt.*;
import java.awt.image.ImageObserver;

import javax.swing.*;
 
public class ImageButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6054970844911192932L;
	protected Font font = new Font("Rockwell", Font.BOLD, 15);
	private Image img1;
	private Image img2;
	private ImageObserver obs;
	
	public ImageButton(String label, String img, ImageObserver obs) {
        this(label, Toolkit.getDefaultToolkit().createImage(img), Toolkit.getDefaultToolkit().createImage(img), obs);
    }
	
	public ImageButton(String label, String img1, String img2, ImageObserver obs) {
        this(label, Toolkit.getDefaultToolkit().createImage(img1), Toolkit.getDefaultToolkit().createImage(img2), obs);
    }

    public ImageButton(String label, Image img1, Image img2, ImageObserver obs) {
    	super(label);
    	
        this.img1 = img1;
        this.img2 = img2;
        this.obs = obs;
        setContentAreaFilled(false);
        setMargin(new Insets(0, 0, 0, 0));
		setBorder(null);
		setBorder(BorderFactory.createEmptyBorder());
		setPreferredSize(new Dimension(100, 40));
		setFont(font);
		setForeground(Color.WHITE);
    }
    
    protected void paintComponent(Graphics g) {
    	
    	//Pulsado
	    if (getModel().isArmed()) g.drawImage(img2, 0, 0, getWidth(), getHeight() , obs);
	    else g.drawImage(img1, 0, 0, getWidth(), getHeight() , obs);
	 
	    super.paintComponent(g);
    }
 
}
