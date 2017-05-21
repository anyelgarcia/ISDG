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
	public void crearRecurso(Recurso r) throws IOException {
		op.guardar(r, file);
	}

	@Override
	public void eliminarRecurso(String id) throws IOException, ClassNotFoundException {
		op.borrar(id, file);
	}

	@Override
	public void modificarRecurso(Recurso r) throws IOException, ClassNotFoundException {
		op.modificar(r, file);
	}

	@Override
	public HashSet<Recurso> listarRecursos() throws IOException, ClassNotFoundException {
		return op.obtenerDatosSet(file);
	}

	@Override
	public boolean existeRecurso(String id) throws IOException, ClassNotFoundException {
		return op.exists(id, file);
	}

}
