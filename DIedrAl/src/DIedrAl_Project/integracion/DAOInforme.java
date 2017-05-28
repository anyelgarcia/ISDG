package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.negocio.pacientes.Informe;

/**
 * DAO que con los métodos CRUD necesarios para los objetos Informe
 * @author Diedral_Group
 */
public interface DAOInforme {

	public void crearInforme(Informe i)  throws AccessException;
	
	public void eliminarInforme(String id)  throws AccessException;
	
	public void modificarInforme(Informe f)  throws AccessException;
	
	public HashSet<Informe> listarInformes()  throws AccessException;
	
	public boolean existeInformes(String id)  throws AccessException;
}
