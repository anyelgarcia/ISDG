package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.administracion.Usuario;

/**
 * Clase que implementa la interfaz DAOUsuario. Obtiene los datos
 * del fichero "usuarios.txt". Solo se crea una instancia de este DAO (singleton)
 * @author Diedral_Group
 */
public class DAOUsuarioImp implements DAOUsuario {
	
	private static DAOUsuarioImp instancia = null;
	
	private DAObasico<Usuario> op;
	private final String file = "usuarios.txt";
	
	public static DAOUsuarioImp getInstance(){
		if(instancia == null) instancia = new DAOUsuarioImp();
		return instancia;
	}

	
	private DAOUsuarioImp(){
		op = new DAObasico<>();
	}


	@Override
	public void crearUsuario(Usuario u) throws AccessException  {
		try {
			op.guardar(u, file);
		} catch (IOException e) {
			throw new AccessException("No se pudo guardar el usuario");
		}
	}


	@Override
	public void eliminarUsuario(String id) throws AccessException  {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo eliminar el usuario");
		}
	}


	@Override
	public void modificarUsuario(Usuario u) throws AccessException {
		try {
			op.modificar(u, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo modificar el usuario");
		}
	}


	@Override
	public HashSet<Usuario> listarUsuarios() throws AccessException {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo listar los usuarios");
		}
	}


	@Override
	public boolean existeUsuario(String id) throws AccessException {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo comprobar la existencia del usuario");
		}
	}


	@Override
	public Usuario consultarUsuario(String id) throws AccessException  {
		try {
			return op.consultar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo consultar el usuario");
		}
	}

}
