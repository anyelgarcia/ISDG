package DIedrAl_Project.presentacion;

import DIedrAl_Project.presentacion.Pacientes.PacienteTransfer;
import DIedrAl_Project.presentacion.Recursos.RecursoTransfer;
import DIedrAl_Project.presentacion.Sesiones.SesionTransfer;

public class Controlador {
	public static void addPaciente(PacienteTransfer p){
		/* Prueba 1: Satisfactoria :D
		 System.out.println(p.getNombre());
		 System.out.println(p.getApellido1());
		 System.out.println(p.getApellido2());
		 System.out.println(p.getFechanacimiento().getAño() + " " + p.getFechanacimiento().getMes() + " " + p.getFechanacimiento().getDia());
		 for(String str : p.getAficiones()){
			 System.out.println(str);
		 }
		 System.out.println( p.getDescripcion());
		 System.out.println( p.getEstadocivil());
		 System.out.println(p.getLesion());
		 System.out.println(p.getFechalesion().getAño() + " " + p.getFechalesion().getMes() + " " + p.getFechalesion().getDia());*/
	}
	
	public static void addRecurso(RecursoTransfer p){
		/*System.out.println(p.getNombre());
		 System.out.println(p.getRuta());
		 for(String str : p.getEtiquetas()){
			 System.out.println(str);
		 }
		 System.out.println( p.getDescripcion());*/
	}
	
	public static void addSesion(SesionTransfer p){
		 System.out.println(p.getNombre());
		 System.out.println(p.getMinutos());
		 for(String str : p.getPosiblesVariaciones()){
			 System.out.println(str);
		 }
		 for(String str : p.getDesarrollo()){
			 System.out.println(str);
		 }
		 System.out.println( p.getDescripcion());
		
	}
}
