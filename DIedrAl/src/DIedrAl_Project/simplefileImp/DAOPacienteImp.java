package DIedrAl_Project.integracion.simplefileImp;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.integracion.DAOinterfaces.DAOPaciente;
import DIedrAl_Project.negocio.pacientes.Paciente;

/**
 * Clase que implementa la interfaz DAOPaciente. Obtiene los datos
 * del fichero "actividad.txt". Solo se crea una instancia de este DAO (singleton)
 * @author Diedral_Group
 */
public class DAOPacienteImp implements DAOPaciente {

	private static DAOPacienteImp instancia = null;
	
	private DAObasico<Paciente> op;
	private final String file = "pacientes.txt";
	
	public static DAOPacienteImp getInstance(){
		if(instancia == null) instancia = new DAOPacienteImp();
		return instancia;
	}

	
	private DAOPacienteImp(){
		op = new DAObasico<>();
	}


	@Override
	public void crearPaciente(Paciente p) throws AccessException {
		try {
			op.guardar(p, file);
		} catch (IOException e) {
			throw new AccessException("No se pudo guardar el paciente");
		}
	}


	@Override
	public void eliminarPaciente(String id) throws AccessException {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo eliminar el paciente");
		}
	}


	@Override
	public void modificarPaciente(Paciente p) throws AccessException {
		try {
			op.modificar(p, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo modificar el paciente");
		}
	}


	@Override
	public HashSet<Paciente> listarPacientes() throws AccessException {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo acceder a los pacientes");
		}
	}


	@Override
	public boolean existePaciente(String id) throws AccessException  {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo acceder al paciente");
		}
	}


	@Override
	public Paciente consultarPaciente(String id) throws AccessException  {
		try {
			return op.consultar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo consultar el paciente");
		}
	}

}
