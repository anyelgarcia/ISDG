package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.administracion.EstadoCentro;

public interface DAOCentro {
	
	public void guardarCentro(EstadoCentro c)  throws IOException;
	
	public void eliminarCentro(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarCentro(EstadoCentro c)  throws IOException, ClassNotFoundException;
	
	public HashSet<EstadoCentro> listarCentros()  throws IOException, ClassNotFoundException;
	
	public boolean existeCentro(String id)  throws IOException, ClassNotFoundException;
	
	public EstadoCentro consultarCentro(String id) throws ClassNotFoundException, IOException;
}
