package DIedrAl_Project.integracion;

import java.util.HashSet;

import DIedrAl_Project.negocio.calendario.Calendario;

public interface DAOCalendario {
	
	public void crearCalendario(Calendario c)  throws AccessException;
	
	public void eliminarCalendario(String id)  throws AccessException;
	
	public void modificarActividad(Calendario r)  throws AccessException;
	
	public HashSet<Calendario> listarCalendario()  throws AccessException;
	
	public boolean existeCalendario(String id)  throws AccessException;
}
