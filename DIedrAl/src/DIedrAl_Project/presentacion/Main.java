package DIedrAl_Project.presentacion;

import java.awt.GridLayout;

import javax.swing.*;

public class Main {
	
	public static void run(JFrame pantalla){
		pantalla = new JFrame();
		pantalla.setLayout(new GridLayout(3, 3, 1, 1));
		pantalla.add(new Calendario("images/diedral00.png"));
		pantalla.add(new Pacientes());
		pantalla.add(new Perfil());
		pantalla.add(new Recursos("images/diedral01.png"));
		pantalla.add(new Sesiones());
		pantalla.add(new Usuarios());
		pantalla.add(new Actividades("images/diedral22.png"));
		
		pantalla.setSize(1200, 800);
		pantalla.setVisible(true);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String ... args){
		JFrame pantalla = new JFrame();
		pantalla.setLayout(new GridLayout(3, 3, 1, 1));
		pantalla.add(new Calendario("images/diedral00.png"));
		pantalla.add(new Pacientes());
		pantalla.add(new Perfil());
		pantalla.add(new Recursos("images/diedral01.png"));
		pantalla.add(new Sesiones());
		pantalla.add(new Usuarios());
		pantalla.add(new Actividades("images/diedral22.png"));
		pantalla.setSize(1200, 800);
		pantalla.setVisible(true);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
