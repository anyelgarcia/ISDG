package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;
import DIedrAl_Project.negocio.recursos.Sesion;

public interface DAOSesion {
	
	public void crearSesion(Sesion a)  throws IOException;
	
	public void eliminarSesion(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarSesion(Sesion r)  throws IOException, ClassNotFoundException;
	
	public HashSet<Sesion> listarSesiones()  throws IOException, ClassNotFoundException;
	
	public boolean existeSesion(String id)  throws IOException, ClassNotFoundException;
}
