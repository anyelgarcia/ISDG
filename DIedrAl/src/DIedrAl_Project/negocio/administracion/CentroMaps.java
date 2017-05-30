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

	public CentroMaps() {
		factory = SimpleFileDAOFactory.getInstance();
	}

	private void cargarInfo() throws AccessException {
		DAOUsuario daous = factory.getDAOUsuario();
		DAORelacionable daoter = factory.getDAORelacion(tRelacion.usuario);
		users = new HashMap<>();
		HashSet<Relacion> relaciones_u = daoter.listarRelaciones(nomb);
		for(Relacion r: relaciones_u){
			users.put(r.getId(), daous.consultarUsuario(r.getId()));
		}

		DAOPaciente daopac = factory.getDAOPaciente();
		DAORelacionable daore = factory.getDAORelacion(tRelacion.paciente);
		this.pacients = new HashMap<>();
		HashSet<Relacion> relaciones_p = daore.listarRelaciones(nomb);
		for(Relacion r: relaciones_p){
			pacients.put(r.getId(), daopac.consultarPaciente(r.getId()));
		}
		
	}

	private void mapear(HashMap<String, Persona> personas, HashMap<Paciente, HashSet<Usuario>> pacientes,
			HashMap<Usuario, HashSet<Paciente>> usuarios) throws AccessException {
		
		DAORelacionable daore = factory.getDAORelacion(tRelacion.paciente);
		HashSet<Relacion> relaciones_p = daore.listarRelaciones(nomb);
		HashSet<Usuario> user = new HashSet<>();

		relaciones_p.forEach((rel)->{
			personas.put(rel.getId(), pacients.get(rel.getId()));
			for(String str: rel.getRelacionados()){
				user.add(users.get(str));
			}
			pacientes.put(pacients.get(rel.getId()), user);
			user.clear();
		});
		
		DAORelacionable daorel = factory.getDAORelacion(tRelacion.usuario);
		HashSet<Relacion> relaciones_t = daorel.listarRelaciones(nomb);
		HashSet<Paciente> pacs = new HashSet<>();
		
		relaciones_t.forEach((rel)->{
			personas.put(rel.getId(), users.get(rel.getId()));
			for(String str: rel.getRelacionados()){
				pacs.add(pacients.get(str));
			}
			usuarios.put(users.get(rel.getId()), pacs);
			pacs.clear();
		});
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