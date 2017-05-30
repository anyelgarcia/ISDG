package DIedrAl_Project.presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import DIedrAl_Project.presentacion.auxiliar.ColorPanel;
import DIedrAl_Project.presentacion.secciones.Actividades;
import DIedrAl_Project.presentacion.secciones.Calendario;
import DIedrAl_Project.presentacion.secciones.Pacientes;
import DIedrAl_Project.presentacion.secciones.Perfil;
import DIedrAl_Project.presentacion.secciones.Recursos;
import DIedrAl_Project.presentacion.secciones.Sesiones;
import DIedrAl_Project.presentacion.secciones.Usuarios;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	public MainFrame(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill=GridBagConstraints.BOTH;
		c.weightx=1000;
		c.weighty=1000;
		
		c.gridx=0;
		c.gridy=0;
		
		
		add(new Pacientes(150, 206, 180),c);
		
		c.gridx=1;
		c.gridy=0;
		
		add(new Calendario(255, 111, 105),c);
		
		c.gridx=2;
		c.gridy=0;
		
		add(new Recursos(255, 204, 92),c);
		
		c.gridx=0;
		c.gridy=1;
		
		add(new ColorPanel(255, 204, 92) ,c);
		
		c.gridx=1;
		c.gridy=1;
		
		add(new Perfil(255, 238, 173),c);
		
		c.gridx=2;
		c.gridy=1;
		
		add(new ColorPanel(150, 206, 180),c);
		
		c.gridx=0;
		c.gridy=2;
		
		add(new Sesiones(255, 111, 105),c);
		
		c.gridx=1;
		c.gridy=2;
		
		add(new Usuarios(150, 206, 180),c);
		
		c.gridx=2;
		c.gridy=2;
		
		
		add(new Actividades(255, 238, 173),c);
		
		
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String ... args){
		JFrame pantalla = new MainFrame();
		pantalla.setVisible(true);
	}
}