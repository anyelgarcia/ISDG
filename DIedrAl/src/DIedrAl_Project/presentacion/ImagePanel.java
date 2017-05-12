package DIedrAl_Project.presentacion;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;


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
}
