package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.Relacion;

/**
 * Clase que implementa la interfaz DAORelacionable. Es el unico DAO que recibe el
 * argumento del que buscar, y no es un Singleton (cada centro tiene sus propios
 * archivos de relaciones)
 * @author Diedral_Group
 */
public class DAORelacionableImp implements DAORelacionable{
	
	private DAObasico<Relacion> op;
	
	private String file;
	
	public DAORelacionableImp(String file){
		this.file = file;
	}
	
	@Override
	public void crearRelacion(Relacion r) throws IOException {
		op.guardar(r, file);
	}

	@Override
	public void eliminarRelacion(String id) throws IOException, ClassNotFoundException {
		op.borrar(id, file);
	}

	@Override
	public void modificarRelacion(Relacion r) throws IOException, ClassNotFoundException {
		op.modificar(r, file);
	}

	@Override
	public HashSet<Relacion> listarRelaciones() throws IOException, ClassNotFoundException {
		return op.obtenerDatosSet(file);
	}

	@Override
	public boolean existeRelacion(String id) throws IOException, ClassNotFoundException {
		return op.exists(id, file);
	}

}
