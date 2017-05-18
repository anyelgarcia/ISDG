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
	
	

}
