package DIedrAl_Project.integracion.simplefileImp;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.integracion.DAOinterfaces.DAOSesionProgramada;
import DIedrAl_Project.negocio.calendario.SesionProgramada;

/**
 * Clase que implementa la interfaz DAOSesion. Obtiene los datos
 * del fichero "sesiones.txt". Solo se crea una instancia de este DAO (singleton)
 * @author Diedral_Group
 */
public class DAOSesionProgramadaImp implements DAOSesionProgramada {

	private static DAOSesionProgramadaImp instancia = null;
	
	private DAObasico<SesionProgramada> op;
	private String file = "sesionesProgramadas.txt";
	
	public static DAOSesionProgramadaImp getInstance(){
		if(instancia == null) instancia = new DAOSesionProgramadaImp();
		return instancia;
	}

	
	private DAOSesionProgramadaImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void crearSesionProgramada(SesionProgramada a) throws AccessException {
		try {
			op.guardar(a, file);
		} catch (IOException e) {
			throw new AccessException("No se pudo guardar la sesión programada");
		}
	}

	@Override
	public void eliminarSesionProgramada(String id) throws AccessException {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo eliminar la sesión programada");
		}
	}

	@Override
	public void modificarSesionProgramada(SesionProgramada r) throws AccessException  {
		try {
			op.modificar(r, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo modificar la sesión programada");
		}
	}

	@Override
	public HashSet<SesionProgramada> listarSesionesProgramadas() throws AccessException  {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo listar las sesiones programadas");
		}
	}

	@Override
	public boolean existeSesionProgramada(String id) throws AccessException {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo comprobar la existencia de la sesión programada");
		}
	}

}
