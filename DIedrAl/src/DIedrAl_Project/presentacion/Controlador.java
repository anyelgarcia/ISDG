package DIedrAl_Project.presentacion;

import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SARecursos;
import DIedrAl_Project.presentacion.Perfil.PerfilTransfer;
import DIedrAl_Project.presentacion.Usuarios.UsuarioTransfer;

/**
 * 
 * @author Diedral_Group
 *
 */
public class Controlador {
	
	public static void addPaciente(Paciente p){
		
		//SAPacientes saPacientes = SAFactory.getInstancia().newSAPacientes(Banco.getInstancia());
		//saPacientes.addPaciente(p);
		
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
	
	public static void addRecurso(Recurso p){
		
		
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		saRecursos.addRecurso(p);
		
		/*Prueba 6 :D
		for(Recurso rec : Banco.getInstancia().getRecursos().filtrarNombre(p.getNombre())){
			 System.out.println("itworked!");
		 }*/
		
		
		/*Prueba 2 Satisfactoria :D
		 * System.out.println(p.getNombre());
		 System.out.println(p.getRuta());
		 for(String str : p.getEtiquetas()){
			 System.out.println(str);
		 }
		 System.out.println( p.getDescripcion());*/
	}
	

	public static void addActividad(Actividad p){
		
		
		//SAActividades saActividades = SAFactory.getInstancia().newSAActividades(banco.getInstancia());
		//saActividades.addActividad(p);
		
		System.out.println(p.getNombre());
		System.out.println(p.getDificultad());
		for(String str : p.getDestinatarios()){
			 System.out.println(str);
		 }
		for(String str : p.getEtiquetas()){
			 System.out.println(str);
		 }
		 System.out.println(p.getDuracion());
		 System.out.println( p.getDescripcion());
		 System.out.println( p.getVariaciones());
		 System.out.println( p.getDesarrollo());
	}
	
	
	public static void addSesion(Sesion p){
		
		//SASesiones saSesiones = SAFactory.getInstancia().newSASesiones(Banco.getInstancia());
		//saSesiones.addSesion(p);
		
		System.out.println(p.getNombre());
		for(String str : p.getEtiquetas()){
			 System.out.println(str);
		 }
		 System.out.println(p.getDuracion());
		 System.out.println( p.getDescripcion());
		 System.out.println( p.getVariaciones());
		 System.out.println( p.getDesarrollo());
		
	}
	
	public static void changeProfile(PerfilTransfer p){
		System.out.println(p.getRol());
		System.out.println(p.getEmail());
		System.out.println(p.getTelefono());
		System.out.println(p.getDescripcion());
		for(String s : p.getPacientes()) System.out.println(s);
		System.out.println(p.getInfo());
	}
	
	public static void addUsuario(UsuarioTransfer p){
		System.out.println(p.getNombre());
		System.out.println(p.getRol());
		System.out.println(p.getEmail());
		System.out.println(p.getTelefono());
		System.out.println(p.getDescripcion());
		for(String s : p.getPacientes()) System.out.println(s);
		System.out.println(p.getInfo());
	}
	
	public static void deleteActividad(String s){
		
		//SAActividades saActividades = SAFactory.getInstancia().newSAActividades(Banco.getInstancia());
		//saActividades.removeActividad(s);
				
		//System.out.println(s);
	}
	
	public static void deletePaciente(String s){
		
		//SAPacientes saPacientes = SAFactory.getInstancia().newSAPacientes(Banco.getInstancia());
		//saPacientes.removePaciente(s);
		
		//System.out.println(s);
	}
	
	public static void deleteRecurso(String s){
		
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		//saRecursos.removeRecurso(s);
		
		//System.out.println(s);
	}
	
	public static void deleteSesion(String s){
		
		//SASesiones saSesiones = SAFactory.getInstancia().newSASesiones(Banco.getInstancia());
		//saSesiones.removeSesione(s);
		
		//System.out.println(s);
	}
}
