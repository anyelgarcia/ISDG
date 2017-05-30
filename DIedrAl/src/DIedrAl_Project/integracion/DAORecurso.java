package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.recursos.Recurso;

/**
 * DAO que con los métodos CRUD necesarios para los objetos Recurso
 * @author Diedral_Group
 */
public interface DAORecurso {
	
	public void crearRecurso(Recurso r)  throws AccessException;
	
	public void eliminarRecurso(String id)  throws AccessException;
	
	public void modificarRecurso(Recurso r)  throws AccessException;
	
	public HashSet<Recurso> listarRecursos()  throws AccessException;
	
	public boolean existeRecurso(String id)  throws AccessException;
}
