package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;
import java.rmi.*;
import java.util.Set;

import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.pacientes.*;

public interface SAPacientes {
	public void addPaciente(Paciente pac) throws AlreadyBoundException, IOException;

	public void erasePaciente(Paciente pac) throws NotBoundException, ClassNotFoundException, IOException;

	public void addUsuario(Usuario usu) throws AlreadyBoundException, ClassNotFoundException, IOException, NotBoundException;

	public void eraseUsuario(Usuario usu) throws NotBoundException, ClassNotFoundException, IOException;

	public void ligarPaciente(Paciente pac, Usuario usu) throws NotBoundException, AlreadyBoundException;

	public void desligarPaciente(Paciente pac, Usuario usu) throws NotBoundException, AlreadyBoundException;
	
	public Set<Paciente> getPacientesAsociados(Usuario usu) throws NotBoundException;
	
	public Paciente getPacienteConNIF(String nif) throws NotBoundException;
	
	public Usuario getUsuarioConNIF(String nif) throws NotBoundException;
	
	public Set<Persona> filtrarPersonas(Hints[] hints, String[] values, Hints[] tipos) throws IllegalArgumentException;

	public Set<Usuario> getUsuariosAsociados(Paciente pac) throws NotBoundException;
}
