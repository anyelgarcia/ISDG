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
	public void crearActividad(Actividad a) throws IOException {
		op.guardar(a, file);
	}

	@Override
	public void eliminarActividad(String id) throws IOException,
			ClassNotFoundException {
		op.borrar(id, file);
	}

	@Override
	public void modificarActividad(Actividad r) throws IOException,
			ClassNotFoundException {
		op.modificar(r, file);
	}

	@Override
	public HashSet<Actividad> listarActividades() throws IOException,
			ClassNotFoundException {
		return op.obtenerDatosSet(file);
	}

	@Override
	public boolean existeActividad(String id) throws IOException,
			ClassNotFoundException {
		return op.exists(id, file);
	}

}
