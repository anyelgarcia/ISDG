package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.ArrayList;

import DIedrAl_Project.negocio.administracion.Terapeuta;

public interface DAOTerapeuta {
	
	public void crearTerapeuta(Terapeuta t)  throws IOException;
	
	public void eliminarTerapeuta(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarTerapeuta(Terapeuta t)  throws IOException, ClassNotFoundException;
	
	public ArrayList<Terapeuta> listarTerapeutas()  throws IOException, ClassNotFoundException;
	
	public boolean existeTerapeuta(String id)  throws IOException, ClassNotFoundException;
}
