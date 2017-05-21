package DIedrAl_Project.integracion;

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
	
	public DAORelacionable getDAORelacion(String file);
}
