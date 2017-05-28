package DIedrAl_Project.integracion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.negocio.recursos.Sesion;



public class DAOSesionImpSQL implements DAOSesion{
	
	public static DAOSesionImpSQL instancia = null;
	
	public static Connection conexion = null;

	public static DAOSesionImpSQL getInstance(Connection conexion){
		if(instancia == null){
			instancia = new DAOSesionImpSQL(conexion);
		}
		return instancia;
	}

	public DAOSesionImpSQL(Connection conexion) {
		DAOPacienteImpSQL.conexion = conexion;
	}
	
	@Override
	public void crearSesion(Sesion se) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("INSERT INSERT INTO");
		} catch(SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarSesion(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("DELETE FROM ");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarSesion(Sesion se) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("UPDATE FROM ");
		} catch (SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public HashSet<Sesion> listarSesiones()  {
		
	}

	@Override
	public boolean existeSesion(String id) {
		ResultSet rs;
		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery("SELECT * ");
		} catch (SQLException e) {
			throw new AccessException();
		}
		return (rs == null);
	}


	
}