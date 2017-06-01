package DIedrAl_Project.integracion.DAOinterfaces;

import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.recursos.Actividad;

/**
 * DAO que con los métodos CRUD necesarios para los objetos Actividad
 * @author Diedral_Group
 */
public interface DAOActividad {
	
	public void crearActividad(Actividad a)  throws AccessException;
	
	public void eliminarActividad(String id)  throws AccessException;
	
	public void modificarActividad(Actividad r)  throws AccessException;
	
	public HashSet<Actividad> listarActividades()  throws AccessException;
	
	public boolean existeActividad(String id)  throws AccessException;
}
