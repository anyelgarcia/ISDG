package DIedrAl_Project.integracion.SQL;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
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
 * Factor�a de objetos DAO (utiliza el patr�n 
 * Singleton para tener una �nica instancia)
 * @author Diedral_Group
 */
public class SQLDAOFactory implements DAOFactory {
	
	private static SQLDAOFactory instancia = null;
	
	private static Connection conexion;
	
	
	public static SQLDAOFactory getInstance() throws AccessException{
		if(instancia == null)
			instancia = new SQLDAOFactory();
		return instancia;
	}
	
	private SQLDAOFactory() throws AccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://92.222.93.238/centromedico", "centro_admin",
					"Supercentromedico1*");
		} catch (SQLException | ClassNotFoundException e) {
			throw new AccessException();
		}
	
	}
	
	@Override
	public DAORecurso getDAORecurso() {
		return DAORecursoImpSQL.getInstance(conexion);
	}

	@Override
	public DAOActividad getDAOActividad() {
		return DAOActividadImpSQL.getInstance(conexion);
	}

	@Override
	public DAOInforme getDAOInforme() {
		return DAOInformeImpSQL.getInstance(conexion);
	}

	@Override
	public DAOPaciente getDAOPaciente() {
		return DAOPacienteImpSQL.getInstance(conexion);
	}

	@Override
	public DAOSesion getDAOSesion() {
		return DAOSesionImpSQL.getInstance(conexion);
	}

	@Override
	public DAOUsuario getDAOUsuario() {
		System.out.println(conexion);
		return DAOUsuarioImpSQL.getInstance(conexion);
	}

	@Override
	public DAORelacionable getDAORelacion(tRelacion rel) {
		return new DAORelacionableImpSQL(rel);
	}

	@Override
	public DAOCentro getDAOCentro() {
		return DAOCentroImpSQL.getInstance(conexion);
	}

	@Override
	public DAOSesionProgramada getDAOSesionProgramada() {
		return null;
		//return DAOSesionImpSQL.getInstance(conexion);
	}
	
	

}
