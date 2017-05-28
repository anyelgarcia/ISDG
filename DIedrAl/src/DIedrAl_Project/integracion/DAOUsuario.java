package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.administracion.Usuario;

/**
 * DAO que con los m�todos CRUD necesarios para los objetos Usuario
 * @author Diedral_Group
 */
public interface DAOUsuario {
	
	public void crearUsuario(Usuario u)  throws AccessException;
	
	public void eliminarUsuario(String id)  throws AccessException;
	
	public void modificarUsuario(Usuario u)  throws AccessException;
	
	public HashSet<Usuario> listarUsuarios()  throws AccessException;
	
	public boolean existeUsuario(String id)  throws AccessException;
	
	public Usuario consultarUsuario(String id) throws AccessException;
}
