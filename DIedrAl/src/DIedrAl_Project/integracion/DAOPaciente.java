package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.pacientes.Paciente;

public interface DAOPaciente {
	
	public void crearPaciente(Paciente p)  throws IOException;
	
	public void eliminarPaciente(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarPaciente(Paciente p)  throws IOException, ClassNotFoundException;
	
	public HashSet<Paciente> listarPacientes()  throws IOException, ClassNotFoundException;
	
	public boolean existePaciente(String id)  throws IOException, ClassNotFoundException;
}
