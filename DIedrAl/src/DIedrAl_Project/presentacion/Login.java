package DIedrAl_Project.presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;






import javax.swing.*;


public class Login extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6242725919201324689L;

	
	public static void main(String[] args) throws InterruptedException{
		
		
		JFrame pantalla = new JFrame();
		GridBagConstraints c = new GridBagConstraints();
		ImagePanel panel= new ImagePanel("images/bb.jpg");
		panel.setPreferredSize(new Dimension(1000, 760));
		pantalla.add(panel);


		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 450);
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Helvetica", Font.BOLD, 20));
		panel.add(username,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 0, 0, 450);
		JTextField usernameText = new JTextField();
		usernameText.setPreferredSize(new Dimension (100, 20));
		panel.add(usernameText,c);
		

		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(25, 0, 0, 450);
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Helvetica", Font.BOLD, 20));
		panel.add(password,c);
		
		
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(5, 0, 0, 450);
		JTextField passwordText = new JTextField();
		passwordText.setPreferredSize(new Dimension (100, 20));
		panel.add(passwordText,c);
		
		
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(30, 0, 0, 450);
		ImageButton acceder = new ImageButton("Acceder", "images/whitebutton.png", "images/whitebutton2.png", panel);
		acceder.setForeground(Color.GRAY);
		panel.add(acceder,c);
		acceder.addActionListener((ae) -> {
			String nombreuser = usernameText.getText();
			String contrase�a = passwordText.getText();
			
			//consultar si la persona est� en la base de datos y obtener el rol;
			//SAUusarios sausuarios = ...
			
			//Controlador.setUsuario();...
			
			
		});
		
		
		pantalla.setVisible(true);
		pantalla.setSize(1000, 760);
		pantalla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		TimeUnit.SECONDS.sleep(5);
		pantalla.dispatchEvent(new WindowEvent(pantalla, WindowEvent.WINDOW_CLOSING));
		entrar();
	}
	

	public static void entrar(){
		Main.run();
	}
	
}

