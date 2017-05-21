package DIedrAl_Project.negocio.administracion;

import java.rmi.*;
import java.util.*;

import DIedrAl_Project.negocio.calendario.Calendario;
import DIedrAl_Project.negocio.pacientes.Paciente;

//Ejemplo del patrón mediator
public class Centro {
	private String nombre;
	// TODO: implementarlo primero
	private Calendario calendario;

	private Map<Paciente, Set<Usuario>> pacientes;

	private Map<Usuario, Set<Paciente>> usuarios;
	// TODO: implementarlo primero
	private Organizacion organizacion;
	
	public Centro(String name) {
		nombre = name;
		pacientes = new HashMap<Paciente, Set<Usuario>>();
		usuarios = new HashMap<Usuario, Set<Paciente>>();

	}

	public Centro(String name, Map<Paciente, Set<Usuario>> pacientes, Map<Usuario, Set<Paciente>> usuarios) {
		nombre = name;
		this.pacientes = pacientes;
		this.usuarios = usuarios;

	}

	public void addUsuario(Usuario usu) throws AlreadyBoundException {
		if (!usuarios.containsKey(usu)) {
			usuarios.put(usu, new HashSet<Paciente>());
		} else {
			throw new AlreadyBoundException(usu + " ya registrado");
		}
	}

	public void addPaciente(Paciente pac) throws AlreadyBoundException {
		if (!pacientes.containsKey(pac)) {
			pacientes.put(pac, new HashSet<Usuario>());
		} else {
			throw new AlreadyBoundException(pac + " ya registrado");
		}
	}

	public void eraseUsuario(Usuario usu) throws NotBoundException {

		if (!usuarios.containsKey(usu)) {
			pacientes.remove(usu);
		} else {
			throw new NotBoundException(usu + " no registrado");
		}
	}

	public void erasePaciente(Paciente pac) throws NotBoundException {

		if (!pacientes.containsKey(pac)) {
			pacientes.remove(pac);
		} else {
			throw new NotBoundException("Paciente " + pac + " no encontrado");
		}
	}

	public void ligarPaciente(Paciente pac, Usuario usu) throws NotBoundException, AlreadyBoundException {
		if (!usuarios.containsKey(usu)) {
			throw new NotBoundException("Usuario " + usu + " no encontrado");
		} else if (!pacientes.containsKey(pac)) {
			throw new NotBoundException("Paciente " + pac + " no encontrado");
		} else if (usuarios.get(usu).contains(pac)) {
			throw new AlreadyBoundException("Paciente ya ligado");
		} else {
			usuarios.get(usu).add(pac);
		}
	}

	public void desligarPaciente(Paciente pac, Usuario usu) throws NotBoundException, AlreadyBoundException {
		if (!usuarios.containsKey(usu)) {
			throw new NotBoundException("Usuario " + usu + " no encontrado");
		} else if (!pacientes.containsKey(pac)) {
			throw new NotBoundException("Paciente " + pac + " no encontrado");
		} else if (!usuarios.get(usu).contains(pac)) {
			throw new AlreadyBoundException("Paciente no ligado");
		} else {
			usuarios.get(usu).remove(pac);
		}
	}
	
	public Set<Paciente> getPacientesAsociados(Usuario usu) throws NotBoundException{
		if(!usuarios.containsKey(usu)){
			throw new NotBoundException("Usuario " + usu + " no encontrado");
		}
		else return usuarios.get(usu);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	public Map<Paciente, Set<Usuario>> getPacientes() {
		return pacientes;
	}

	public Map<Usuario, Set<Paciente>> getUsuarios() {
		return usuarios;
	}

}