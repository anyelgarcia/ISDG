package DIedrAl_Project.integracion.SQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.DAOCentro;
import DIedrAl_Project.negocio.administracion.EstadoCentro;


public class DAOCentroImpSQL implements DAOCentro{
	
	public static DAOCentroImpSQL instancia = null;
	
	public static Connection conexion = null;

	public static DAOCentroImpSQL getInstance(Connection conexion){
		if(instancia == null){
			instancia = new DAOCentroImpSQL(conexion);
		}
		return instancia;
	}

	public DAOCentroImpSQL(Connection conexion) {
		DAOCentroImpSQL.conexion = conexion;
	}
	
	@Override
	public void guardarCentro(EstadoCentro c) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("INSERT INSERT INTO");
		} catch(SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarCentro(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("DELETE FROM ");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarCentro(EstadoCentro c) throws AccessException  {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("UPDATE FROM ");
		} catch(SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public HashSet<EstadoCentro> listarCentros()  {
		
	}

	@Override
	public EstadoCentro consultarCentro(String id) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery ("SELECT * ");
		} catch(SQLException e) {
			throw new AccessException();
		}
		return null;
		
	}

	@Override
	public boolean existeCentro(String id) throws AccessException {
		ResultSet rs;
		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery("SELECT * ");
		} catch (SQLException e) {
			throw new AccessException();
		}
		return rs == null;
	}

	
}

