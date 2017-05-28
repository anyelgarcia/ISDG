package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.calendario.Calendario;

public interface DAOCalendario {
	
	public void crearCalendario(Calendario c)  throws IOException;
	
	public void eliminarCalendario(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarActividad(Calendario r)  throws IOException, ClassNotFoundException;
	
	public HashSet<Calendario> listarCalendario()  throws IOException, ClassNotFoundException;
	
	public boolean existeCalendario(String id)  throws IOException, ClassNotFoundException;
}
