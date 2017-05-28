package DIedrAl_Project.integracion;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;



/**
 * Factoría de objetos DAO (utiliza el patrón 
 * Singleton para tener una única instancia)
 * @author Diedral_Group
 */
public class SQLDAOFactory implements DAOFactory {
	
	private static SQLDAOFactory instancia = null;
	
	private static Connection conexion = null;
	
	
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
	
	

}
