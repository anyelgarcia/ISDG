package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
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
			throw new AccessException();
		}
	}


	@Override
	public void eliminarPaciente(String id) throws AccessException {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}


	@Override
	public void modificarPaciente(Paciente p) throws AccessException {
		try {
			op.modificar(p, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}


	@Override
	public HashSet<Paciente> listarPacientes() throws AccessException {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}


	@Override
	public boolean existePaciente(String id) throws AccessException  {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}


	@Override
	public Paciente consultarPaciente(String id) throws AccessException  {
		try {
			return op.consultar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

}
