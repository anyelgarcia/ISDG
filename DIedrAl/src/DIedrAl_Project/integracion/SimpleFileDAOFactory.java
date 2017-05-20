package DIedrAl_Project.integracion;

public class SimpleFileDAOFactory implements DAOFactory {

	
	@Override
	public DAOTerapeuta getDAOTerapeuta() {
		return DAOTerapeutaImp.getInstance();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOPaciente getDAOPaciente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOSesion getDAOSesion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
