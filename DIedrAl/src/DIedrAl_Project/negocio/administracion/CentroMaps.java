package DIedrAl_Project.negocio.administracion;

import java.io.IOException;
import java.util.*;

import DIedrAl_Project.integracion.BasicClasses.*;
import DIedrAl_Project.integracion.DAOinterfaces.*;
import DIedrAl_Project.integracion.simplefileImp.*;
import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.Relacion;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class CentroMaps {
	
	private DAOFactory factory;

	private HashMap<String, Paciente> pacients;

	private HashMap<String, Usuario> users;
	
	private String nomb;

	public CentroMaps() throws AccessException {
		factory = SimpleFileDAOFactory.getInstance();
	}

	private void cargarInfo() throws AccessException {
		DAOUsuario daous = factory.getDAOUsuario();
		DAORelacionable daoter = factory.getDAORelacion(tRelacion.usuario);
		users = new HashMap<>();
		HashSet<Relacion> relaciones_u = daoter.listarRelaciones(nomb);
		for(Relacion r: relaciones_u){
			users.put(r.getIdAgente(), daous.consultarUsuario(r.getIdAgente()));
		}

		DAOPaciente daopac = factory.getDAOPaciente();
		DAORelacionable daore = factory.getDAORelacion(tRelacion.paciente);
		this.pacients = new HashMap<>();
		HashSet<Relacion> relaciones_p = daore.listarRelaciones(nomb);
		for(Relacion r: relaciones_p){
			pacients.put(r.getIdAgente(), daopac.consultarPaciente(r.getIdAgente()));
		}
		
	}

	private void mapear(HashMap<String, Persona> personas, HashMap<Paciente, HashSet<Usuario>> pacientes,
			HashMap<Usuario, HashSet<Paciente>> usuarios) throws AccessException {
		
		DAORelacionable daore = factory.getDAORelacion(tRelacion.paciente);
		HashSet<Relacion> relaciones_p = daore.listarRelaciones(nomb);
		
		
		for(Relacion rel: relaciones_p){
			HashSet<Usuario> user = new HashSet<Usuario>();
			personas.put(rel.getIdAgente(), pacients.get(rel.getIdAgente()));
			for(String str: rel.getRelacionados()){
				user.add(users.get(str));
			}
			pacientes.put(pacients.get(rel.getIdAgente()), user);			
		}
		
		DAORelacionable daorel = factory.getDAORelacion(tRelacion.usuario);
		HashSet<Relacion> relaciones_t = daorel.listarRelaciones(nomb);
		
		
		for(Relacion rel: relaciones_t){
			HashSet<Paciente> pacs = new HashSet<Paciente>();
			personas.put(rel.getIdAgente(), users.get(rel.getIdAgente()));
			for(String str: rel.getRelacionados()){
				pacs.add(pacients.get(str));
			}
			usuarios.put(users.get(rel.getIdAgente()), pacs);
		}
	}
	
	private void cargarCentro(HashMap<String, Persona> personas, HashMap<Paciente, HashSet<Usuario>> pacientes,
			HashMap<Usuario, HashSet<Paciente>> usuarios) throws AccessException{
		cargarInfo();
		mapear(personas,pacientes, usuarios);
	}
	
	/**
	 * Dado un nombre para el centro, genera un centro correctamente mapeado
	 * @param name nombre del centro 
	 * @return centro mapeado con la información de los ficheros usados en la construcción del mapeador
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws AccessException 
	 */
	public Centro generarCentro(EstadoCentro c) throws AccessException{
		// Mapas donde mapear la información del centro.
		nomb = c.getId();
		HashMap<String, Persona> personas = new HashMap<String, Persona>();
		HashMap<Paciente, HashSet<Usuario>> pacientes = new HashMap<Paciente, HashSet<Usuario>>();
		HashMap<Usuario, HashSet<Paciente>> usuarios = new HashMap<Usuario, HashSet<Paciente>>();
		cargarCentro(personas, pacientes, usuarios);
		return new Centro(c, pacientes, usuarios, personas);
	}

}