package DIedrAl_Project.integracion.simplefileImp;

import DIedrAl_Project.integracion.BasicClasses.tRelacion;
import DIedrAl_Project.integracion.DAOinterfaces.DAOActividad;
import DIedrAl_Project.integracion.DAOinterfaces.DAOCentro;
import DIedrAl_Project.integracion.DAOinterfaces.DAOFactory;
import DIedrAl_Project.integracion.DAOinterfaces.DAOInforme;
import DIedrAl_Project.integracion.DAOinterfaces.DAOPaciente;
import DIedrAl_Project.integracion.DAOinterfaces.DAORecurso;
import DIedrAl_Project.integracion.DAOinterfaces.DAORelacionable;
import DIedrAl_Project.integracion.DAOinterfaces.DAOSesion;
import DIedrAl_Project.integracion.DAOinterfaces.DAOSesionProgramada;
import DIedrAl_Project.integracion.DAOinterfaces.DAOUsuario;

/**
 * Factoría de objetos DAO (utiliza el patrÓn 
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
	public DAOSesionProgramada getDAOSesionProgramada() {
		return DAOSesionProgramadaImp.getInstance();
	}

	@Override
	public DAOUsuario getDAOUsuario() {
		return DAOUsuarioImp.getInstance();
	}

	@Override
	public DAORelacionable getDAORelacion(tRelacion rel) {
		return DAORelacionableImp.getInstance(rel);
	}

	@Override
	public DAOCentro getDAOCentro() {
		return DAOCentroImp.getInstance();
	}
	
	

}
