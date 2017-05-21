package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.recursos.Actividad;

public interface DAOActividad {
	
	public void crearActividad(Actividad a)  throws IOException;
	
	public void eliminarActividad(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarActividad(Actividad r)  throws IOException, ClassNotFoundException;
	
	public HashSet<Actividad> listarActividades()  throws IOException, ClassNotFoundException;
	
	public boolean existeActividad(String id)  throws IOException, ClassNotFoundException;
}
