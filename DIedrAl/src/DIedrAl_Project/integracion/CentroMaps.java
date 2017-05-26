package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.*;

import DIedrAl_Project.negocio.Relacion;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class CentroMaps {

	private DAOFactory factory;
	
	private String file_t;

	private String file_p;

	private HashMap<String, Paciente> pacients;

	private HashMap<String, Usuario> users;

	public CentroMaps(String t, String p) {
		file_t = t;
		file_p = p;
		factory = SimpleFileDAOFactory.getInstance();
	}

	private void cargarInfo() throws ClassNotFoundException, IOException {
		DAOUsuario daous = factory.getDAOUsuario();
		DAORelacionable daoter = factory.getDAORelacion(file_t);
		users = new HashMap<>();
		HashSet<Relacion> relaciones_u = daoter.listarRelaciones();
		relaciones_u.forEach((relacion) -> {
			try {
				users.put(relacion.getId(), daous.consultarUsuario(relacion.getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		DAOPaciente daopac = factory.getDAOPaciente();
		DAORelacionable daore = factory.getDAORelacion(file_p);
		this.pacients = new HashMap<>();
		HashSet<Relacion> relaciones_p = daore.listarRelaciones();
		relaciones_p.forEach((relacion) -> {
			try {
				pacients.put(relacion.getId(), daopac.consultarPaciente(relacion.getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private void mapear(Map<String, Persona> personas, Map<Paciente, Set<Usuario>> pacientes,
			Map<Usuario, Set<Paciente>> usuarios) throws ClassNotFoundException, IOException {
		
		DAORelacionable daore = factory.getDAORelacion(file_p);
		HashSet<Relacion> relaciones_p = daore.listarRelaciones();
		HashSet<Usuario> user = new HashSet<>();

		relaciones_p.forEach((rel)->{
			personas.put(rel.getId(), pacients.get(rel.getId()));
			for(String str: rel.getRelacionados()){
				user.add(users.get(str));
			}
			pacientes.put(pacients.get(rel.getId()), user);
			user.clear();
		});
		
		DAORelacionable daorel = factory.getDAORelacion(file_t);
		HashSet<Relacion> relaciones_t = daorel.listarRelaciones();
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
	
	public void cargarCentro(Map<String, Persona> personas, Map<Paciente, Set<Usuario>> pacientes,
			Map<Usuario, Set<Paciente>> usuarios) throws ClassNotFoundException, IOException{
		cargarInfo();
		mapear(personas,pacientes, usuarios);
	}

}