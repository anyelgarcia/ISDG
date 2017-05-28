package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.recursos.Sesion;

/**
 * Clase que implementa la interfaz DAOSesion. Obtiene los datos
 * del fichero "sesiones.txt". Solo se crea una instancia de este DAO (singleton)
 * @author Diedral_Group
 */
public class DAOSesionImp implements DAOSesion {

	private static DAOSesionImp instancia = null;
	
	private DAObasico<Sesion> op;
	private String file = "sesiones.txt";
	
	public static DAOSesionImp getInstance(){
		if(instancia == null) instancia = new DAOSesionImp();
		return instancia;
	}

	
	private DAOSesionImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void crearSesion(Sesion a) throws AccessException {
		try {
			op.guardar(a, file);
		} catch (IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarSesion(String id) throws AccessException {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarSesion(Sesion r) throws AccessException  {
		try {
			op.modificar(r, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public HashSet<Sesion> listarSesiones() throws AccessException  {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public boolean existeSesion(String id) throws AccessException {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

}
