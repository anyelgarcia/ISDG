package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.pacientes.Paciente;

/**
 * DAO que con los métodos CRUD necesarios para los objetos Paciente
 * @author Diedral_Group
 */
public interface DAOPaciente {
	
	public void crearPaciente(Paciente p)  throws AccessException;
	
	public void eliminarPaciente(String id)  throws AccessException;
	
	public void modificarPaciente(Paciente p)  throws AccessException;
	
	public HashSet<Paciente> listarPacientes()  throws AccessException;
	
	public boolean existePaciente(String id)  throws AccessException;
	
	public Paciente consultarPaciente(String id) throws AccessException;
}
