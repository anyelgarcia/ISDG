package DIedrAl_Project.integracion.DAOinterfaces;

import java.util.*;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.Relacion;

/**
 * DAO que con los métodos CRUD necesarios para los objetos de relaciones
 * @author Diedral_Group
 */
public interface DAORelacionable {
	
	public void crearRelacion(Relacion r)  throws AccessException;
	
	public void eliminarRelacion(String id)  throws AccessException;
	
	public void modificarRelacion(Relacion r)  throws AccessException;
	
	/**
	 * Devuelve las relaciones del centro indicado
	 * @param id centro del que devolvemos las relaciones
	 */
	public HashSet<Relacion> listarRelaciones(String id)  throws AccessException;
	
	public boolean existeRelacion(String id)  throws AccessException;
	
	/**
	 * Dado el id del centro, elimino todas las Relaciones de un centro dado
	 * @param id del centro a borrar
	 */
	public void eliminarRelacionesCentro(String id) throws AccessException;
	
}
