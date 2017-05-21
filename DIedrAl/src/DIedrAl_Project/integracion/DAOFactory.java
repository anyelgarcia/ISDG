package DIedrAl_Project.integracion;

/**
 * Interfaz para crear una factoría con todos los métodos DAO necesarios
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
	
	public DAORelacionable getDAORelacion(String file);
}
