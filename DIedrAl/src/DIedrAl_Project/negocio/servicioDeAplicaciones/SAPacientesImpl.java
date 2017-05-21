package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.rmi.*;
import java.util.Set;

import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.administracion.Centro.Hints;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class SAPacientesImpl implements SAPacientes {

	private Centro centro;

	public SAPacientesImpl(Centro centro) {
		this.centro = centro;
	}

	@Override
	public void addPaciente(Paciente pac) throws AlreadyBoundException {
		centro.addPaciente(pac);
	}

	@Override
	public void erasePaciente(Paciente pac) throws NotBoundException {
		centro.erasePaciente(pac);

	}

	@Override
	public void addUsuario(Usuario usu) throws AlreadyBoundException {
		centro.addUsuario(usu);
	}

	@Override
	public void eraseUsuario(Usuario usu) throws NotBoundException   {
		centro.eraseUsuario(usu);
	}

	@Override
	public void ligarPaciente(Paciente pac, Usuario usu) throws NotBoundException, AlreadyBoundException {
		centro.ligarPaciente(pac, usu);
	}

	@Override
	public void desligarPaciente(Paciente pac, Usuario usu) throws NotBoundException, AlreadyBoundException {
		centro.desligarPaciente(pac, usu);
	}

	@Override
	public Set<Paciente> getPacientesAsociados(Usuario usu) throws NotBoundException {
		return centro.getPacientesAsociados(usu);
	}

	@Override
	public Paciente pacienteConNIF(String nif) {
		return centro.getPacienteConNIF(nif);
	}

	@Override
	public Usuario usuarioConNIF(String nif) {
		return centro.getTerapeutaConNIF(nif);
	}

	@Override
	public Set<Persona> filtrarPersonas(Centro.Hints[] hints, String[] values) {
		return centro.getPersonas(hints, values);
	}
	

}
