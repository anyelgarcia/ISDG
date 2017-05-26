package DIedrAl_Project.integracion;

/**
 * Factoría de objetos DAO (utiliza el patrón 
 * Singleton para tener una única instancia)
 * @author Diedral_Group
 */
public class SimpleFileDAOFactory implements DAOFactory {
	
	private static SimpleFileDAOFactory instancia = null;
	
	
	public static SimpleFileDAOFactory getInstance(){
		if(instancia == null) return new SimpleFileDAOFactory();
		else return instancia;
	}
	
	private SimpleFileDAOFactory(){
		
	}
	
	@Override
	public DAORecurso getDAORecurso() {
		return DAORecursoImp.getInstance();
	}

	@Override
	public DAOActividad getDAOActividad() {
		return DAOActividadImp.getInstance();
	}

	@Override
	public DAOInforme getDAOInforme() {
		return DAOInformeImp.getInstance();
	}

	@Override
	public DAOPaciente getDAOPaciente() {
		return DAOPacienteImp.getInstance();
	}

	@Override
	public DAOSesion getDAOSesion() {
		return DAOSesionImp.getInstance();
	}

	@Override
	public DAOUsuario getDAOUsuario() {
		return DAOUsuarioImp.getInstance();
	}

	@Override
	public DAORelacionable getDAORelacion(String file) {
		return new DAORelacionableImp(file);
	}

	@Override
	public DAOCentro getDAOCentro() {
		return DAOCentroImp.getInstance();
	}
	
	

}
