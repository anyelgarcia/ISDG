package DIedrAl_Project.presentacion;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.calendario.SesionProgramada;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.ArrayActividades;
import DIedrAl_Project.negocio.recursos.ArrayRecursos;
import DIedrAl_Project.negocio.recursos.ArraySesiones;
import DIedrAl_Project.negocio.recursos.ArraySesionesProgramadas;
import DIedrAl_Project.negocio.recursos.Dificultad;
import DIedrAl_Project.negocio.recursos.Etiquetable;
import DIedrAl_Project.negocio.recursos.Programable;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.presentacion.auxiliar.Error;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAOrganizacion;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAPacientes;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SARecursos;

/**
 * 
 * @author Diedral_Group
 *
 */
public class Controlador {
	
	private static final Logger log = Logger.getLogger(Controlador.class.getName());
	
	private static Usuario usuario;
	
	public static void setUsuario(Usuario user){
		usuario = user;
	}
	
	public static Usuario getUsuario(){
		return usuario;
	}
	
	public static void addPaciente(Paciente p){
		SAPacientes saPacientes;
		try {
			saPacientes = SAFactory.getInstancia().newSAPacientes(usuario.getCentro());
			saPacientes.addPaciente(p);
		} catch (AlreadyBoundException e){
			new Error("El paciente ya está en el sistema");
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
	}
	
	public static void addRecurso(Recurso p){
		
		
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos();
		try {
			saRecursos.addRecurso(p);
		} catch (AccessException | IOException e) {
			new Error(e.getMessage());
		}
		
	}
	
	public static void addActividad(Actividad p){
		
		
		SARecursos saActividades = SAFactory.getInstancia().newSARecursos();
		try {
			saActividades.addActividad(p);
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
	}
	
	public static void addSesion(Sesion p){
		
		SARecursos saSesiones = SAFactory.getInstancia().newSARecursos();
		try {
			saSesiones.addSesion(p);
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
		
	}
	
	public static void addSesionProgramada(SesionProgramada sp){
		
		SARecursos saSesiones = SAFactory.getInstancia().newSARecursos();
		try {
			saSesiones.addSesionProgramada(sp);
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
		
	}
	
	public static void addUsuario(Usuario p){

		SAPacientes saUsuarios;
		try {
			saUsuarios = SAFactory.getInstancia().newSAPacientes(usuario.getCentro());
			saUsuarios.addUsuario(p);
		} catch (AccessException | AlreadyBoundException e) {
			new Error(e.getMessage());
		}
	}
	
	public static void deleteActividad(Actividad a){
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos();
		try {
			saRecursos.removeActividad(a);
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
	}
	
	public static void deletePaciente(Paciente resultado){
		SAPacientes saPacientes;
		try {
			saPacientes = SAFactory.getInstancia().newSAPacientes(usuario.getCentro());
			saPacientes.erasePaciente(resultado);
		} catch (NotBoundException | AccessException e) {
			new Error(e.getMessage());
		}
	}
	
	public static void deleteUsuario(Usuario resultado) {
		SAPacientes saUsuarios;
		try {
			saUsuarios = SAFactory.getInstancia().newSAPacientes(usuario.getCentro());
			saUsuarios.eraseUsuario(resultado);
		} catch (NotBoundException | AccessException e) {
			new Error(e.getMessage());
		}
		
	}
	
	public static void deleteRecurso(Recurso r){
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos();
		try {
			saRecursos.removeRecurso(r);
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
	}
	
	public static void deleteSesion(Sesion s){
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos();
		try {
			saRecursos.removeSesion(s);
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
	}
	
	public static void deleteSesionProgramada(SesionProgramada sp) {
		SARecursos saRecursos = SAFactory.getInstancia().newSARecursos();
		try {
			saRecursos.removeSesionProgramada(sp);
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
		
	}
	
	public static Paciente[] buscarPaciente(Hints[]hints, String [] values){
		
		SAPacientes saPacientes = null;
		
		try {
			saPacientes = SAFactory.getInstancia().newSAPacientes(usuario.getCentro());
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
		
		ArrayList<Persona> pacientes = new ArrayList<Persona>();
		Hints[] valUsuarios = {Hints.PACIENTE};
		pacientes.addAll(saPacientes.filtrarPersonas(hints, values, valUsuarios));
		
		Paciente[] resultado = new Paciente[pacientes.size()];
		int i = 0;
		for(Persona p: pacientes){
			resultado[i] = (Paciente)p;
			i++;
		}
		if(i!=0) return resultado;
		else return null;
	}
	
	public static Usuario[] buscarUsuario(Hints[]hints, String [] values){
		
		SAPacientes saPacientes = null;
		
		try {
			saPacientes = SAFactory.getInstancia().newSAPacientes(usuario.getCentro());
		} catch (AccessException e) {
			new Error(e.getMessage());
		}
		
		ArrayList<Persona> usuarios = new ArrayList<Persona>();
		Hints[] valUsuarios = {Hints.USUARIO};
		usuarios.addAll(saPacientes.filtrarPersonas(hints, values, valUsuarios));
		
		Usuario[] resultado = new Usuario[usuarios .size()];
		int i = 0;
		for(Persona p: usuarios ){
			resultado[i] = (Usuario)p;
			i++;
		}
		if(i!=0) return resultado;
		else return null;
	}
	
	public static ArraySesiones filtrarSesiones(String nombre, Set<String> filtros, Integer min, Integer max, Set<String> destinatarios){
		ArraySesiones salida = SAFactory.getInstancia().newSARecursos().getSesiones();
		if(!nombre.equals("") && salida != null) salida = (ArraySesiones) salida.filtrarNombre(nombre);
		if(filtros.size() > 0 && salida != null) salida = (ArraySesiones) salida.filtrarEtiqueta(filtros);
		if(min != null && salida != null) salida = (ArraySesiones) salida.filtrarDesde(min);
		if(max != null && salida != null) salida = (ArraySesiones) salida.filtrarHasta(max);
		if(destinatarios.size() > 0 && salida != null) salida = (ArraySesiones) salida.filtrarDestinatarios(destinatarios);
		
		return salida;
	}
	
	public static ArrayActividades filtrarActividades(String nombre, Set<String> filtros, Integer min, Integer max, Set<String> destinatarios, 
			Dificultad minimo, Dificultad maximo){
		ArrayActividades salida = SAFactory.getInstancia().newSARecursos().getActividades();
		if(!nombre.equals("") && salida != null) salida = (ArrayActividades) salida.filtrarNombre(nombre);
		if(filtros.size() > 0 && salida != null) salida = (ArrayActividades) salida.filtrarEtiqueta(filtros);
		if(min != null && salida != null) salida = (ArrayActividades) salida.filtrarDesde(min);
		if(max != null && salida != null) salida = (ArrayActividades) salida.filtrarHasta(max);
		if(destinatarios.size() > 0 && salida != null)  salida = (ArrayActividades) salida.filtrarDestinatarios(destinatarios);
		if(minimo != null && salida != null) salida = salida.filtrarDesde(minimo);
		if(maximo != null && salida != null) salida = salida.filtrarHasta(maximo);
		
		return salida;
	}
	
	public static ArrayRecursos filtrarRecursos(String nombre, Set<String> filtros){
		ArrayRecursos salida = SAFactory.getInstancia().newSARecursos().getRecursos();
		if(!nombre.equals("") && salida != null) salida = (ArrayRecursos) salida.filtrarNombre(nombre);
		if(filtros.size() > 0 && salida != null) salida = (ArrayRecursos) salida.filtrarEtiqueta(filtros);
		return salida;
	}

	public static String [] getPacientesAsociados(Usuario u){
		ArrayList<String> salida = new ArrayList<String>();
		Set<Paciente> pacientes = null;
		try {
			pacientes = SAFactory.getInstancia().newSAPacientes(usuario.getCentro()).getPacientesAsociados(u);
		} catch (NotBoundException | AccessException e) {
			new Error(e.getMessage());
			return null;
		}
		if(pacientes != null){
			for(Paciente p : pacientes){
				salida.add(p.toString());
			}
		}
		return salida.toArray(new String[salida.size()]);
	}
	
	public static String getPacienteTipo(Actividad a){
		ArrayList<String> destinatarios = new ArrayList<>();
    	for(String s : a.getDestinatarios()){
    		destinatarios.add(s);
    	}
    	return destinatarios.get(0);
	}
	
	public static ArrayList<String> getRecursosAsociados(Programable a){
		ArrayList<String> salida = new ArrayList<>();
		Set<Etiquetable> total = a.getAsociados();
    	for(Etiquetable eti : total){
    		if(eti instanceof Recurso) salida.add(eti.getNombre());
    	}
    	return salida;
	}
	
	public static ArrayList<String> getActividadesAsociadas(Programable a){
		ArrayList<String> salida = new ArrayList<>();
		Set<Etiquetable> total = a.getAsociados();
    	for(Etiquetable eti : total){
    		if(eti instanceof Actividad) salida.add(eti.getNombre());
    	}
    	return salida;
	}
  
	public static void modificaEtiquetable(Etiquetable antiguo, Etiquetable nuevo){
		antiguo.igualarCampos(nuevo);
		if(nuevo instanceof Recurso){
			try {
				SAFactory.getInstancia().newSARecursos().updateRecurso((Recurso)nuevo);
			} catch (AccessException e) {
				new Error("No se ha podido modificar el recurso");
			}
		}
		else if(nuevo instanceof Actividad){
			try {
				SAFactory.getInstancia().newSARecursos().updateActividad((Actividad)nuevo);
			} catch (AccessException e) {
				new Error("No se ha podido modificar la actividad");
			}
		}
		else if(nuevo instanceof Sesion){
			try {
				SAFactory.getInstancia().newSARecursos().updateSesion((Sesion)nuevo);
			} catch (AccessException e) {
				new Error("No se ha podido modificar la sesion");
			}
		}
	}

	public static void modificaPaciente(Paciente antiguo, Paciente nuevo){
		antiguo.igualarCampos(nuevo);
		try {
			SAFactory.getInstancia().newSAPacientes(usuario.getCentro()).updatePaciente(nuevo);
		} catch (AccessException e) {
			new Error("No se ha podido modificar el paciente");
		}
	}

	public static String[] getCentros(){
		ArrayList<String> centros = new ArrayList<String>();
    	try {
			centros = SAFactory.getInstancia().newSAOrganizacion().getCentros();
		} catch (AccessException e) {
			log.severe(e.getMessage());
			new Error(e.getMessage());
			return null;
		}
    	
    	return centros.toArray(new String[centros.size()]);
	}
	
	public static void deleteCentro(String name){
		 SAOrganizacion saOrg = SAFactory.getInstancia().newSAOrganizacion();
		 try {
			saOrg.eliminarCentro(name);
		} catch (NotBoundException | AccessException e) {
			log.severe(e.getMessage());
			new Error(e.getMessage());
			
		}
	}
	
	public static boolean existeCentro(String name){
		 SAOrganizacion saOrg = SAFactory.getInstancia().newSAOrganizacion();
		 try {
			if(!saOrg.existeCentro(name)){
				return false; 
			}
		} catch (AccessException e) {
			log.severe(e.getMessage());
			new Error(e.getMessage());
		}
		 return true;
	}
	
	public static void createCentro(String nameCentro, String password){
		SAOrganizacion saOrg = SAFactory.getInstancia().newSAOrganizacion();
		 try {
			saOrg.addCentro(nameCentro, password);
		} catch (AccessException | AlreadyBoundException e) {
			log.severe(e.getMessage());
			new Error(e.getMessage());
		}
		 
	}

	public static String tratarAficiones(ArrayList<String> aficiones) {
		if(aficiones.isEmpty()) return "";
		
		String str = aficiones.get(0);
		aficiones.remove(0);
		
		for(String af: aficiones){
			str += ", " + af;
		}
		return str;
	}

	public static boolean usuarioCorrecto(String nombreuser, String clave) {
		SAOrganizacion saOrg = SAFactory.getInstancia().newSAOrganizacion();
		Usuario intento = null;
		try {
			intento = saOrg.getUsuario(nombreuser);
		} catch (NotBoundException | AccessException e) {
			new Error("No se ha encontrado al usuario en el sistema");
			return false;
		}
		
		if(!intento.inputPassword(clave)){
			new Error("Contraseña equivocada");
			return false;
		}
		
		Controlador.setUsuario(intento);
		
		return true;
	}

	public static boolean ligar(Usuario usr, Paciente pac) {
		try {
			SAPacientes saUsu = SAFactory.getInstancia().newSAPacientes(usuario.getCentro());
			saUsu.ligarPaciente(pac, usr);
		} catch (AccessException | NotBoundException | AlreadyBoundException e) {

			new Error(e.getMessage());
			return false;
		}
		return true;
	}
	
	public static boolean desligar(Usuario usr, Paciente pac) {
		try {
			SAPacientes saUsu = SAFactory.getInstancia().newSAPacientes(usuario.getCentro());
			saUsu.desligarPaciente(pac, usr);
		} catch (AccessException | NotBoundException | AlreadyBoundException e) {

			new Error(e.getMessage());
			return false;
		}
		return true;
	}

	public static void modificaUsuario(Usuario info) {
		usuario.igualarCampos(info);
		try {
			SAFactory.getInstancia().newSAPacientes(usuario.getCentro()).updateUsuario(usuario);
		} catch (AccessException e) {
			new Error("No se ha podido actualizar el paciente");
		}
	}
	
	public static Usuario getUsuarioConNif(String nif){
		try {
			return 	SAFactory.getInstancia().newSAPacientes(usuario.getCentro()).getUsuarioConNIF(nif);
		} catch (AccessException | NotBoundException e) {
				new Error(e.getMessage());
		}
		return null;

	}
	
	public static Paciente getPacienteConNif(String nif){
		try {
			return 	SAFactory.getInstancia().newSAPacientes(usuario.getCentro()).getPacienteConNIF(nif);	
		} catch (AccessException | NotBoundException e) {
				new Error(e.getMessage());
		}
		return null;

	}

	public static ArraySesionesProgramadas getSesionesProgramadas(Fecha fecha) {
		return SAFactory.getInstancia().newSARecursos().getSesionesProgramadas(fecha);
	}

	


}
