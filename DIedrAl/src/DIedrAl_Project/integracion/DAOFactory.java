package DIedrAl_Project.integracion;

public interface DAOFactory {
	public DAOTerapeuta getDAOTerapeuta();
	
	public DAORecurso getDAORecurso();
	
	public DAOActividad getDAOActividad();
	
	public DAOInforme getDAOInforme();
	
	public DAOPaciente getDAOPaciente();
	
	public DAOSesion getDAOSesion();
}
