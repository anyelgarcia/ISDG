package DIedrAl_Project.negocio.administracion;

import java.io.IOException;
import java.util.*;

import DIedrAl_Project.integracion.AccessException;
import DIedrAl_Project.integracion.DAOFactory;
import DIedrAl_Project.integracion.DAOPaciente;
import DIedrAl_Project.integracion.DAORelacionable;
import DIedrAl_Project.integracion.DAOUsuario;
import DIedrAl_Project.integracion.SimpleFileDAOFactory;
import DIedrAl_Project.integracion.tRelacion;
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

	private void mapear(Map<String, Persona> personas, Map<Paciente, Set<Usuario>> pacientes,
			Map<Usuario, Set<Paciente>> usuarios) throws AccessException {
		
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
	
	private void cargarCentro(Map<String, Persona> personas, Map<Paciente, Set<Usuario>> pacientes,
			Map<Usuario, Set<Paciente>> usuarios) throws AccessException{
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
		Map<String, Persona> personas = new HashMap<String, Persona>();
		Map<Paciente, Set<Usuario>> pacientes = new HashMap<Paciente, Set<Usuario>>();
		Map<Usuario, Set<Paciente>> usuarios = new HashMap<Usuario, Set<Paciente>>();
		cargarCentro(personas, pacientes, usuarios);
		return new Centro(c, pacientes, usuarios, personas);
	}

}