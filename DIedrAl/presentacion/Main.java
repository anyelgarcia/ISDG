package presentacion;

import java.awt.GridLayout;

import javax.swing.*;

public class Main {
	
	public static void run(JFrame pantalla){
		pantalla.setLayout(new GridLayout(3, 3, 1, 1));
		pantalla.add(new Calendario());
		pantalla.add(new Login());
		pantalla.add(new Pacientes());
		pantalla.add(new Perfil());
		pantalla.add(new Recursos());
		pantalla.add(new Sesiones());
		pantalla.add(new Usuarios());
		pantalla.add(new Actividades());
	}
	
	public static void main(String ... args){
		JFrame pantalla = new JFrame();
		run(pantalla);
		pantalla.setSize(600, 800);
		pantalla.setVisible(true);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
