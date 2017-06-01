package DIedrAl_Project.integracion.DAOinterfaces;

import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.administracion.EstadoCentro;

public interface DAOCentro {
	
	public void guardarCentro(EstadoCentro c)  throws AccessException;
	
	public void eliminarCentro(String id)  throws AccessException;
	
	public void modificarCentro(EstadoCentro c)  throws AccessException;
	
	public HashSet<EstadoCentro> listarCentros()  throws AccessException;
	
	public boolean existeCentro(String id)  throws AccessException;
	
	public EstadoCentro consultarCentro(String id) throws AccessException;
}
