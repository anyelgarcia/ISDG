package DIedrAl_Project.integracion.simplefileImp;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.integracion.DAOinterfaces.DAOCalendario;
import DIedrAl_Project.negocio.calendario.Calendario;

public class DAOCalendarioImp implements DAOCalendario {
	
private static DAOCalendarioImp instancia = null;
	
	private DAObasico<Calendario> op;
	private final String file = "calendario.txt";
	
	public static DAOCalendarioImp getInstance(){
		if(instancia == null) instancia = new DAOCalendarioImp();
		return instancia;
	}

	
	private DAOCalendarioImp(){
		op = new DAObasico<>();
	}

	@Override
	public void crearCalendario(Calendario c) throws AccessException{
		try {
			op.guardar(c, file);
		} catch (IOException e) {
			throw new AccessException("No se ha podido crear el calendario");
		}
	}

	@Override
	public void eliminarCalendario(String id) throws AccessException {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			
			throw new AccessException("No se ha podido eliminar el calendario");
		}
	}

	@Override
	public void modificarActividad(Calendario r) throws AccessException {
		try {
			op.modificar(r, file);
		} catch (ClassNotFoundException | IOException e) {
			
			throw new AccessException("No se ha podido modificar el calendario");
		}
	}

	@Override
	public HashSet<Calendario> listarCalendario() throws AccessException {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			
			throw new AccessException("No se ha podido listar los calendarios");
		}
	}

	@Override
	public boolean existeCalendario(String id) throws AccessException {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			
			throw new AccessException("No se ha podido "
					+ "comprobar la existencia del calendario");
		}
	}

	
}
