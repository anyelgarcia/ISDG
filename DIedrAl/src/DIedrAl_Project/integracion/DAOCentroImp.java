package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.administracion.EstadoCentro;

public class DAOCentroImp implements DAOCentro{
	
private static DAOCentroImp instancia = null;
	
	private DAObasico<EstadoCentro> op;
	private final String file = "organizacion.txt";
	
	public static DAOCentroImp getInstance(){
		if(instancia == null) instancia = new DAOCentroImp();
		return instancia;
	}

	
	private DAOCentroImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void guardarCentro(EstadoCentro c) throws AccessException{
		try {
			op.guardar(c, file);
		} catch (IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarCentro(String id) throws AccessException{
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarCentro(EstadoCentro c) throws AccessException {
		try {
			op.modificar(c, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public HashSet<EstadoCentro> listarCentros() throws AccessException {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public boolean existeCentro(String id) throws AccessException {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}


	@Override
	public EstadoCentro consultarCentro(String id) throws AccessException {
		try {
			return op.consultar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

}
