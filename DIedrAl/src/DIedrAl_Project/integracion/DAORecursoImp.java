package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.recursos.Recurso;

/**
 * Clase que implementa la interfaz DAORecurso. Obtiene los datos
 * del fichero "recursos.txt". Solo se crea una instancia de este DAO (singleton)
 * @author Diedral_Group
 */
public class DAORecursoImp implements DAORecurso{
	
	private static DAORecursoImp instancia = null;
	
	private DAObasico<Recurso> op;
	private final String file = "recursos.txt";
	
	public static DAORecursoImp getInstance(){
		if(instancia == null){
			instancia = new DAORecursoImp();
		}
		return instancia;
	}

	
	private DAORecursoImp(){
		op = new DAObasico<>();
	}
	

	@Override
	public void crearRecurso(Recurso r) throws AccessException {
		try {
			op.guardar(r, file);
		} catch (IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarRecurso(String id) throws AccessException  {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarRecurso(Recurso r) throws AccessException {
		try {
			op.modificar(r, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public HashSet<Recurso> listarRecursos() throws AccessException {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public boolean existeRecurso(String id) throws AccessException  {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

}
