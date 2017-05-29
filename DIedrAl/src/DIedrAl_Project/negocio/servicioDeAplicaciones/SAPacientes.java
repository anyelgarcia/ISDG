package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.Set;

import DIedrAl_Project.integracion.AccessException;
import DIedrAl_Project.negocio.administracion.Hints;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;

public interface SAPacientes {
	public void addPaciente(Paciente pac) throws AlreadyBoundException, AccessException;

	public void erasePaciente(Paciente pac) throws NotBoundException,AccessException;

	public void addUsuario(Usuario usu) throws AlreadyBoundException, NotBoundException, AccessException;

	public void eraseUsuario(Usuario usu) throws NotBoundException, AccessException;

	public void ligarPaciente(Paciente pac, Usuario usu) throws NotBoundException, AlreadyBoundException, AccessException;

	public void desligarPaciente(Paciente pac, Usuario usu) throws NotBoundException, AlreadyBoundException, AccessException;
	
	public Set<Paciente> getPacientesAsociados(Usuario usu) throws NotBoundException;
	
	public Paciente getPacienteConNIF(String nif) throws NotBoundException;
	
	public Usuario getUsuarioConNIF(String nif) throws NotBoundException;
	
	public Set<Persona> filtrarPersonas(Hints[] hints, String[] values, Hints[] tipos) throws IllegalArgumentException;

	public Set<Usuario> getUsuariosAsociados(Paciente pac) throws NotBoundException;
}
