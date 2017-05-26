package DIedrAl_Project.presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Main {
	
	public static void run(){
		JFrame pantalla = new JFrame();
		pantalla.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1000;
		c.weighty=1000;
		
		c.gridx=0;
		c.gridy=0;
		
		
		pantalla.add(new Pacientes(150, 206, 180),c);
		
		c.gridx=1;
		c.gridy=0;
		
		pantalla.add(new Calendario(255, 111, 105),c);
		
		c.gridx=2;
		c.gridy=0;
		
		pantalla.add(new Recursos(255, 204, 92),c);
		
		c.gridx=0;
		c.gridy=1;
		
		pantalla.add(new ColorPanel(255, 204, 92) ,c);
		
		c.gridx=1;
		c.gridy=1;
		
		pantalla.add(new Perfil(255, 238, 173),c);
		
		c.gridx=2;
		c.gridy=1;
		
		pantalla.add(new ColorPanel(150, 206, 180),c);
		
		c.gridx=0;
		c.gridy=2;
		
		pantalla.add(new Sesiones(255, 111, 105),c);
		
		c.gridx=1;
		c.gridy=2;
		
		pantalla.add(new Usuarios(150, 206, 180),c);
		
		c.gridx=2;
		c.gridy=2;
		
		
		pantalla.add(new Actividades(255, 238, 173),c);
		
		
		pantalla.setSize(1200, 800);
		pantalla.setVisible(true);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Login().init();
	}
}
