package DIedrAl_Project.presentacion;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.Set;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Organizacion;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAPacientes;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SARecursos;
import DIedrAl_Project.presentacion.Perfil.PerfilTransfer;

/**
 * 
 * @author Diedral_Group
 *
 */
public class Controlador {
	
	private static Usuario usuario;
	
	protected static void setUsuario(Usuario user){
		usuario = user;
	}
	
	protected static Usuario getUsuario(){
		return usuario;
	}
	
	public static void addPaciente(Paciente p) throws AlreadyBoundException{
		
		SAPacientes saPacientes = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		saPacientes.addPaciente(p);
		
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
		
		
		SARecursos saActividades = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		saActividades.addActividad(p);
		
		/*System.out.println(p.getNombre());
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
		 System.out.println( p.getDesarrollo());*/
	}
	
	
	public static void addSesion(Sesion p){
		
		SARecursos saSesiones = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		saSesiones.addSesion(p);
		
		/*System.out.println(p.getNombre());
		for(String str : p.getEtiquetas()){
			 System.out.println(str);
		 }
		 System.out.println(p.getDuracion());
		 System.out.println( p.getDescripcion());
		 System.out.println( p.getVariaciones());
		 System.out.println( p.getDesarrollo());*/
		
	}
	
	public static void changeProfile(PerfilTransfer p){
		System.out.println(p.getRol());
		System.out.println(p.getEmail());
		System.out.println(p.getTelefono());
		System.out.println(p.getDescripcion());
		for(String s : p.getPacientes()) System.out.println(s);
		System.out.println(p.getInfo());
	}
	
	public static void addUsuario(Usuario p) throws AlreadyBoundException{
		
		SAPacientes saUsuarios = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		saUsuarios.addUsuario(p);
		
		/*System.out.println(p.getNombre());
		System.out.println(p.getRol());
		System.out.println(p.getEmail());
		System.out.println(p.getTelefono());
		System.out.println(p.getDescripcion());
		for(String s : p.getPacientes()) System.out.println(s);
		System.out.println(p.getInfo());*/
	}
	
	public static void deleteActividad(String s){
		
		SARecursos saActividades = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		Set<Actividad> actividades = saActividades.filtrarActividadPorNombre(s);
				
		//System.out.println(s);
	}
	
	public static void deletePaciente(String s){
		
		SAPacientes saPacientes = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		//Set<Paciente> pacientes = saPacientes.filtrarPersonas(Hints.NOMBRE, s);
		
		//System.out.println(s);
	}
	
	public static void deleteRecurso(String s){
		
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		Set<Recurso> recursos = saRecursos.filtrarRecursosPorNombre(s);
		
		//System.out.println(s);
	}
	
	public static void deleteSesion(String s){
		
		SARecursos saSesiones = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		Set<Sesion> sesiones = saSesiones.filtrarSesionPorNombre(s);
		
		//System.out.println(s);
	}
	
	public static String[] buscarPaciente(ArrayList<Hints> hints, ArrayList<String> values){
		
		SAPacientes saPacientes = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		
		int i = 0;
		
		Hints [] claves = new Hints[hints.size()];
		for(Hints hint: hints){
			claves[i] = hint;
			i++;
		}
		
		i=0;
		String [] valores = new String[hints.size()];
		for(String str: values){
			valores[i] = str;
			i++;
		}
		Set<Persona> pacientes = saPacientes.filtrarPersonas(claves, valores);
		
		int length = pacientes.size();
		i=0;
		String resultados[] = new String[length];
		for(Persona persona: pacientes){
			resultados[i] = persona.toString();
			i++;
		}
		
		return resultados;
	}
	
	public static String [] buscarUsuarios(ArrayList<Hints> hints, ArrayList<String> values){
		
		SAPacientes saUsuarios = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		
		int i=0;
		Hints [] claves = new Hints[hints.size()];
		for(Hints hint: hints){
			claves[i] = hint;
			i++;
		}
		
		i=0;
		String [] valores = new String[hints.size()];
		for(String str: values){
			valores[i] = str;
			i++;
		}
		
		Set<Persona> usuarios = saUsuarios.filtrarPersonas(claves, valores);
		
		int length = usuarios.size();
		i=0;
		String resultados[] = new String[length];
		for(Persona persona: usuarios){
			resultados[i] = persona.toString();
			i++;
		}
		
		return resultados;
	}
}
