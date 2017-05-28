package DIedrAl_Project.integracion;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;



/**
 * Factoría de objetos DAO (utiliza el patrón 
 * Singleton para tener una única instancia)
 * @author Diedral_Group
 */
public class SQLDAOFactory implements DAOFactory {
	
	private static SQLDAOFactory instancia = null;
	
	private static Connection conexion = null;
	
	
	public static SQLDAOFactory getInstance(){
		if(instancia == null)
			instancia = new SQLDAOFactory();
		return instancia;
	}
	
	private SQLDAOFactory() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://92.222.93.238/centromedico",
				"centro_admin", "Supercentromedico1*");
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
	public DAORelacionable getDAORelacion(String file) {
		return new DAORelacionableImpSQL(file);
	}

	@Override
	public DAOCentro getDAOCentro() {
		return DAOCentroImpSQL.getInstance(conexion);
	}
	
	

}
