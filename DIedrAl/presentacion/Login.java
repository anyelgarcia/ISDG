package presentacion;

import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Login extends JPanel{
	
	
	public static void entrar(JFrame pantalla){
		Main.run(pantalla);
	}
	
	public static void main(String ... args) throws InterruptedException{
		JFrame pantalla = new JFrame();
		pantalla.setLayout(new GridLayout(1, 2, 1, 1));
		pantalla.add(new JTextField("username"));
		pantalla.add(new JTextField("password"));
		
		pantalla.setVisible(true);
		pantalla.setSize(600, 800);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TimeUnit.SECONDS.sleep(1);
		entrar(pantalla);
	}
	
}
