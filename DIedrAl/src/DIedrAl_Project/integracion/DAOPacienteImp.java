package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class DAOPacienteImp implements DAOPaciente {

	private static DAOPacienteImp instancia;
	
	private DAObasico<Paciente> op;
	private final String file = "pacientes.txt";
	
	public static DAOPacienteImp getInstance(){
		if(instancia == null) return new DAOPacienteImp();
		else return instancia;
	}

	
	private DAOPacienteImp(){
		op = new DAObasico<>();
	}


	@Override
	public void crearPaciente(Paciente p) throws IOException {
		op.guardar(p, file);
	}


	@Override
	public void eliminarPaciente(String id) throws IOException, ClassNotFoundException {
		op.borrar(id, file);
	}


	@Override
	public void modificarPaciente(Paciente p) throws IOException, ClassNotFoundException {
		op.modificar(p, file);
	}


	@Override
	public HashSet<Paciente> listarPacientes() throws IOException, ClassNotFoundException {
		return op.obtenerDatosSet(file);
	}


	@Override
	public boolean existePaciente(String id) throws IOException, ClassNotFoundException {
		return op.exists(id, file);
	}

}
