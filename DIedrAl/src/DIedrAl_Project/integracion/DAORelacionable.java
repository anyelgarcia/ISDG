package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.*;

import DIedrAl_Project.negocio.Relacion;

/**
 * DAO que con los métodos CRUD necesarios para los objetos de relaciones
 * @author Diedral_Group
 */
public interface DAORelacionable {
	
public void crearRelacion(Relacion r)  throws IOException;
	
	public void eliminarRelacion(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarRelacion(Relacion r)  throws IOException, ClassNotFoundException;
	
	public HashSet<Relacion> listarRelaciones()  throws IOException, ClassNotFoundException;
	
	public boolean existeRelacion(String id)  throws IOException, ClassNotFoundException;
	
	
}
