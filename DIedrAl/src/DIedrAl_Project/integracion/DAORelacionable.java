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
	
	/**
	 * Devuelve las relaciones del centro indicado
	 * @param id centro del que devolvemos las relaciones
	 */
	public HashSet<Relacion> listarRelaciones(String id)  throws IOException, ClassNotFoundException;
	
	public boolean existeRelacion(String id)  throws IOException, ClassNotFoundException;
	
	/**
	 * Dado el id del centro, elimino todas las Relaciones de un centro dado
	 * @param id del centro a borrar
	 */
	public void eliminarRelacionesCentro(String id) throws IOException, ClassNotFoundException;
	
}
