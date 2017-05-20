package DIedrAl_Project.negocio.administracion;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.List;

import DIedrAl_Project.negocio.calendario.Calendario;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class Centro {
	private String nombre;

	private Administrador administrador;

	private Calendario calendario;

	private List<Paciente> pacientes = new ArrayList<Paciente>();

	private List<Terapeuta> terapeutas = new ArrayList<Terapeuta>();

	private Organizacion organizacion;

	public void addTerapeuta(Terapeuta ter) throws AlreadyBoundException {
		if (!terapeutas.contains(ter)) {
			terapeutas.add(ter);
		} else
			throw new AlreadyBoundException(ter + " ya registrado");
	}

	public void addPaciente(Paciente pac) throws AlreadyBoundException {
		if (!pacientes.contains(pac)) {
			pacientes.add(pac);
		} else
			throw new AlreadyBoundException(pac + " ya registrado");
	}

	public void erasePaciente(Paciente pac) throws AlreadyBoundException {

		if (pacientes.contains(pac)) {
			pacientes.remove(pac);
		} else
			throw new AlreadyBoundException(pac + " no registrado");
	}

	public void eraseTerapeuta(String ter) {
	}

	public void modificarTerapeuta(String ter, Terapeuta nuevaInfo) {
	}

	public void ligarPaciente(Paciente pac, Terapeuta ter) {
	}

	public void desligarPaciente(Terapeuta ter, Paciente pac) {
	}

	public void mostrarTerapeutas() {
	}

	public void mostrarPacientes() {
	}

	public void modificarPaciente(Paciente nuevo, Paciente antiguo) {
	}

	String getNombre() {
		// Automatically generated method. Please delete this comment before
		// entering specific code.
		return this.nombre;
	}

	void setNombre(String value) {
		// Automatically generated method. Please delete this comment before
		// entering specific code.
		this.nombre = value;
	}

	Organizacion getOrganizacion() {
		// Automatically generated method. Please delete this comment before
		// entering specific code.
		return this.organizacion;
	}

	void setOrganizacion(Organizacion value) {
		// Automatically generated method. Please delete this comment before
		// entering specific code.
		this.organizacion = value;
	}

}
