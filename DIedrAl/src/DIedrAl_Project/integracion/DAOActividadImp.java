package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.recursos.Actividad;

/**
 * Clase que implementa la interfaz DAOActividad. Obtiene los datos
 * del fichero "actividad.txt". Solo se crea una instancia de este DAO (singleton)
 * @author Diedral_Group
 */
public class DAOActividadImp implements DAOActividad {

	private static DAOActividadImp instancia = null;
	
	private DAObasico<Actividad> op;
	private final String file = "actividad.txt";
	
	public static DAOActividadImp getInstance(){
		if(instancia == null) instancia = new DAOActividadImp();
		return instancia;
	}

	
	private DAOActividadImp(){
		op = new DAObasico<>();
	}
	
	
	@Override
	public void crearActividad(Actividad a) throws AccessException {
		try {
			op.guardar(a, file);
		} catch (IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarActividad(String id) throws AccessException  {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarActividad(Actividad r) throws AccessException  {
		try {
			op.modificar(r, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public HashSet<Actividad> listarActividades() throws AccessException {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public boolean existeActividad(String id) throws AccessException {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

}
