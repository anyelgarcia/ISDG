package DIedrAl_Project.integracion.DAOinterfaces;

import DIedrAl_Project.integracion.BasicClasses.tRelacion;

/**
 * Interfaz para crear una factor�a con todos los métodos DAO necesarios
 * en el programa (patrón AbstractFactoryMethod)
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

	public DAOSesionProgramada getDAOSesionProgramada();
}
