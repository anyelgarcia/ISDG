package DIedrAl_Project.presentacion;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Set;

import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Organizacion;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.ArrayActividades;
import DIedrAl_Project.negocio.recursos.ArrayRecursos;
import DIedrAl_Project.negocio.recursos.ArraySesiones;
import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Dificultad;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAPacientes;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SARecursos;

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
		SAPacientes saPacientes;
		try {
			saPacientes = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
			saPacientes.addPaciente(p);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
	
	public static void changeProfile(Usuario p){
		
	}
	
	public static void addUsuario(Usuario p){
		
		SAPacientes saUsuarios;
		try {
			saUsuarios = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*System.out.println(p.getNombre());
		System.out.println(p.getRol());
		System.out.println(p.getEmail());
		System.out.println(p.getTelefono());
		System.out.println(p.getDescripcion());
		for(String s : p.getPacientes()) System.out.println(s);
		System.out.println(p.getInfo());*/
	}
	
	public static void deleteActividad(Actividad a){
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		saRecursos.removeActividad(a);
	
	}
	
	public static void deletePaciente(String s){
		
	}
	
	public static void deleteRecurso(Recurso r){
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		saRecursos.removeRecurso(r);
	}
	
	public static void deleteSesion(Sesion s){
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos(Banco.getInstancia());
		saRecursos.removeSesion(s);
	}
	
	public static String[] buscarPaciente(Hints[]hints, String [] values, Hints[] valUsuarios){
		
		SAPacientes saPacientes = null;
		try {
			saPacientes = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<Persona> pacientes = saPacientes.filtrarPersonas(hints, values, valUsuarios);
		
		int length = pacientes.size();
		int i=0;
		String resultados[] = new String[length];
		for(Persona persona: pacientes){
			resultados[i] = persona.toString();
			i++;
		}
		
		return resultados;
	}
	
	public static String [] buscarUsuarios(Hints[]hints, String [] values, Hints[] valUsuarios){
		
		SAPacientes saUsuarios = null;
		try {
			saUsuarios = SAFactory.getInstancia().newSAPacientes(Organizacion.getInstancia().getCentro("Nombre del centro"));
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<Persona> usuarios = saUsuarios.filtrarPersonas(hints, values, valUsuarios);
		
		int length = usuarios.size();
		int i=0;
		String resultados[] = new String[length];
		for(Persona persona: usuarios){
			resultados[i] = persona.toString();
			i++;
		}
		
		return resultados;
	}
	
	public static ArraySesiones filtrarSesiones(String nombre, Set<String> filtros, Integer min, Integer max, Set<String> destinatarios){
		ArraySesiones salida = Banco.getInstancia().getSesiones();
		if(nombre != null && nombre != "") salida.filtrarNombre(nombre);
		if(filtros.size() > 0) salida.filtrarEtiqueta(filtros);
		if(min != null) salida.filtrarDesde(min);
		if(max != null) salida.filtrarHasta(max);
		if(destinatarios.size() > 0) salida.filtrarDestinatarios(destinatarios);
		
		return salida;
	}
	
	public static ArrayActividades filtrarActividades(String nombre, Set<String> filtros, Integer min, Integer max, Set<String> destinatarios, 
			Dificultad minimo, Dificultad maximo){
		ArrayActividades salida = Banco.getInstancia().getActividades();
		if(nombre != null && nombre != "") salida.filtrarNombre(nombre);
		if(filtros.size() > 0) salida.filtrarEtiqueta(filtros);
		if(min != null) salida.filtrarDesde(min);
		if(max != null) salida.filtrarHasta(max);
		if(destinatarios.size() > 0) salida.filtrarDestinatarios(destinatarios);
		if(minimo != null) salida.filtrarDesde(minimo);
		if(maximo != null) salida.filtrarHasta(maximo);
		
		return salida;
	}
	
	public static ArrayRecursos filtrarRecursos(String nombre, Set<String> filtros){
		ArrayRecursos salida = Banco.getInstancia().getRecursos();
		if(nombre != null && nombre != "") salida.filtrarNombre(nombre);
		if(filtros.size() > 0) salida.filtrarEtiqueta(filtros);
		return salida;
	}

	public static ArrayList<String> getPacientesAsociados(Usuario u){
		try {
			ArrayList<String> salida = new ArrayList<String>();
			Set<Paciente> pacientes = Organizacion.getInstancia().getCentro("Nombre del centro").getPacientesAsociados(u);
			for(Paciente p : pacientes){
				salida.add(p.toString());
			}
			return salida;
		} catch (NotBoundException e) {
			return null;
		}
	}
}
