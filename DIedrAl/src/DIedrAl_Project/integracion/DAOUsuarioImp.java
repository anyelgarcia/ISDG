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
		if(instancia == null) return new DAOUsuarioImp();
		else return instancia;
	}

	
	private DAOUsuarioImp(){
		op = new DAObasico<>();
	}


	@Override
	public void crearUsuario(Usuario u) throws IOException {
		op.guardar(u, file);
	}


	@Override
	public void eliminarUsuario(String id) throws IOException, ClassNotFoundException {
		op.borrar(id, file);
	}


	@Override
	public void modificarUsuario(Usuario u) throws IOException, ClassNotFoundException {
		op.modificar(u, file);
	}


	@Override
	public HashSet<Usuario> listarUsuarios() throws IOException, ClassNotFoundException {
		return op.obtenerDatosSet(file);
	}


	@Override
	public boolean existeUsuario(String id) throws IOException, ClassNotFoundException {
		return op.exists(id, file);
	}
}
