package DIedrAl_Project.integracion;

public class SimpleFileDAOFactory implements DAOFactory {


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
	
	

}
