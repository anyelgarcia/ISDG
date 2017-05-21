package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.administracion.Usuario;

public interface DAOUsuario {
	
	public void crearUsuario(Usuario u)  throws IOException;
	
	public void eliminarUsuario(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarUsuario(Usuario u)  throws IOException, ClassNotFoundException;
	
	public HashSet<Usuario> listarUsuarios()  throws IOException, ClassNotFoundException;
	
	public boolean existeUsuario(String id)  throws IOException, ClassNotFoundException;
}
