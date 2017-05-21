package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.pacientes.Informe;

/**
 * DAO que con los métodos CRUD necesarios para los objetos Informe
 * @author Diedral_Group
 */
public interface DAOInforme {

	public void crearInforme(Informe i)  throws IOException;
	
	public void eliminarInforme(String id)  throws IOException, ClassNotFoundException;
	
	public void modificarInforme(Informe f)  throws IOException, ClassNotFoundException;
	
	public HashSet<Informe> listarInformes()  throws IOException, ClassNotFoundException;
	
	public boolean existeInformes(String id)  throws IOException, ClassNotFoundException;
}
