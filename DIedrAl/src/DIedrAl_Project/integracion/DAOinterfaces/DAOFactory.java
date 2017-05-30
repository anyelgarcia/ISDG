package DIedrAl_Project.integracion.DAOinterfaces;

import DIedrAl_Project.integracion.BasicClasses.tRelacion;

/**
 * Interfaz para crear una factor�a con todos los m�todos DAO necesarios
 * en el programa (patr�n AbstractFactoryMethod)
 * @author Diedral_Group
 */
public interface DAOFactory {
	
	public DAOUsuario getDAOUsuario();
	
	public DAORecurso getDAORecurso();
	
	public DAOActividad getDAOActividad();
	
	public DAOInforme getDAOInforme();
	
	public DAOPaciente getDAOPaciente();
	
	public DAOSesion getDAOSesion();
	
	public DAORelacionable getDAORelacion(tRelacion rel);
	
	public DAOCentro getDAOCentro();
}
