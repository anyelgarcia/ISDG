package DIedrAl_Project.integracion.DAOinterfaces;

import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.calendario.SesionProgramada;

/**
 * DAO que con los métodos CRUD necesarios para los objetos SesionProgramada
 * @author Diedral_Group
 */
public interface DAOSesionProgramada {
	
	public void crearSesionProgramada(SesionProgramada a)  throws AccessException;
	
	public void eliminarSesionProgramada(String id)  throws AccessException;
	
	public void modificarSesionProgramada(SesionProgramada r)  throws AccessException;
	
	public HashSet<SesionProgramada> listarSesionesProgramadas()  throws AccessException;
	
	public boolean existeSesionProgramada(String id)  throws AccessException;
}
