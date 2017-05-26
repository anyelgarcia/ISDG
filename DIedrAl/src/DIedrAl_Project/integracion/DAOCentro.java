package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.administracion.CentroAlmacenable;

public interface DAOCentro {
	
	public void guardarCentro(CentroAlmacenable c)  throws IOException;
	
	public void eliminarCentro(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarCentro(CentroAlmacenable c)  throws IOException, ClassNotFoundException;
	
	public HashSet<CentroAlmacenable> listarCentros()  throws IOException, ClassNotFoundException;
	
	public boolean existeCentro(String id)  throws IOException, ClassNotFoundException;
}
