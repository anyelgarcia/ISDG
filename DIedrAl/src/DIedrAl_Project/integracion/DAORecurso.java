package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.recursos.Recurso;

/**
 * DAO que con los métodos CRUD necesarios para los objetos Recurso
 * @author Diedral_Group
 */
public interface DAORecurso {
	
	public void crearRecurso(Recurso r)  throws IOException;
	
	public void eliminarRecurso(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarRecurso(Recurso r)  throws IOException, ClassNotFoundException;
	
	public HashSet<Recurso> listarRecursos()  throws IOException, ClassNotFoundException;
	
	public boolean existeRecurso(String id)  throws IOException, ClassNotFoundException;
}
