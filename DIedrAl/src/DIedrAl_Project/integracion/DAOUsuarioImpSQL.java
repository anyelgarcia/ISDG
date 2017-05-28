package DIedrAl_Project.integracion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.negocio.administracion.Usuario;


public class DAOUsuarioImpSQL implements DAOUsuario{
	
	public static DAOUsuarioImpSQL instancia = null;
	
	public static Connection conexion = null;

	public static DAOUsuarioImpSQL getInstance(Connection conexion){
		if(instancia == null){
			instancia = new DAOUsuarioImpSQL(conexion);
		}
		return instancia;
	}

	public DAOUsuarioImpSQL(Connection conexion) {
		DAOPacienteImpSQL.conexion = conexion;
	}
	
	@Override
	public void crearUsuario(Usuario u) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("INSERT INSERT INTO");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarUsuario(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("DELETE FROM ");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarUsuario(Usuario u) throws IOException, ClassNotFoundException, SQLException {
		Statement s = conexion.createStatement();
		s.executeQuery ("UPDATE FROM ");
		
	}

	@Override
	public HashSet<Usuario> listarUsuarios()  {
		
	}

	@Override
	public boolean existeUsuario(String id) {
		Statement s = conexion.createStatement();
		ResultSet rs = s.executeQuery ("SELECT * ");
		return (rs == null);
	}

	@Override
	public Usuario consultarUsuario(String id) throws ClassNotFoundException, IOException {
		return null;
	}


	
}