package DIedrAl_Project.presentacion;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Main {
	
	public static void run(){
		JFrame pantalla = new JFrame();
		pantalla.setLayout(new GridLayout(3, 3, 1, 1));
		pantalla.add(new Calendario("images/diedral00.png"));
		pantalla.add(new Pacientes("images/diedral00.png"));
		pantalla.add(new Perfil("images/diedral00.png"));
		pantalla.add(new Recursos("images/diedral01.png"));
		pantalla.add(new Sesiones("images/diedralcolor.png"));
		pantalla.add(new Usuarios("images/diedral5.png"));
		pantalla.add(new Actividades("images/diedral22.png"));
		
		pantalla.setSize(1200, 800);
		pantalla.setVisible(true);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String ... args){
		JFrame pantalla = new JFrame();
		pantalla.setLayout(new GridLayout(3, 3, 1, 1));
		pantalla.add(new Calendario("images/diedral00.png"));
		pantalla.add(new Pacientes("images/diedral00.png"));
		pantalla.add(new Perfil("images/diedral00.png"));
		pantalla.add(new Recursos("images/diedral01.png"));
		pantalla.add(new Sesiones("images/diedral5.png"));
		pantalla.add(new Usuarios("images/diedral5.png"));
		pantalla.add(new Actividades("images/diedral22.png"));
		pantalla.setSize(1200, 800);
		pantalla.setVisible(true);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
