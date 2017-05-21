package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.administracion.Centro;

interface DAOCentro {
	
	public void crearCentro(Centro c)  throws IOException;
	
	public void eliminarCentro(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarCentro(Centro c)  throws IOException, ClassNotFoundException;
	
	public HashSet<Centro> listarCentros()  throws IOException, ClassNotFoundException;
	
	public boolean existeCentro(String id)  throws IOException, ClassNotFoundException;
}
