package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import DIedrAl_Project.negocio.administracion.Usuario;

public interface DAOTerapeuta {
	
	public void crearTerapeuta(Usuario t)  throws IOException;
	
	public void eliminarTerapeuta(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarTerapeuta(Usuario t)  throws IOException, ClassNotFoundException;
	
  public HashSet<Terapeuta> listarTerapeutas()  throws IOException, ClassNotFoundException;

	public boolean existeTerapeuta(String id)  throws IOException, ClassNotFoundException;
}
