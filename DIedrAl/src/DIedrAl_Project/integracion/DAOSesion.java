package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;
import DIedrAl_Project.negocio.recursos.Sesion;

/**
 * DAO que con los métodos CRUD necesarios para los objetos Sesion
 * @author Diedral_Group
 */
public interface DAOSesion {
	
	public void crearSesion(Sesion a)  throws AccessException;
	
	public void eliminarSesion(String id)  throws AccessException;
	
	public void modificarSesion(Sesion r)  throws AccessException;
	
	public HashSet<Sesion> listarSesiones()  throws AccessException;
	
	public boolean existeSesion(String id)  throws AccessException;
}
