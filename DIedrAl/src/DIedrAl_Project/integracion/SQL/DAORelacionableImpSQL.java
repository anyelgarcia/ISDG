package DIedrAl_Project.integracion.SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;

import DIedrAl_Project.integracion.BasicClasses.tRelacion;
import DIedrAl_Project.integracion.DAOinterfaces.DAORelacionable;

import DIedrAl_Project.negocio.Relacion;


public class DAORelacionableImpSQL implements DAORelacionable {
	
	private static DAORelacionableImpSQL dao_user = null;

	private static DAORelacionableImpSQL dao_pac = null;
	
	public static Connection conexion = null;

	public static DAORelacionableImpSQL getInstance(tRelacion rel, Connection conexion) {
		switch (rel) {
		case usuario:
			if (dao_user == null) {
				dao_user = new DAORelacionableImpSQL(conexion);
			}
			return dao_user;
		case paciente:
			if (dao_pac == null) {
				dao_pac = new DAORelacionableImpSQL(conexion);
			}
			return dao_pac;
		}
		return null;
	}

	private DAORelacionableImpSQL(Connection conexion) {
		DAORelacionableImpSQL.conexion = conexion;
	}

	@Override
	public void crearRelacion(Relacion r) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeUpdate("INSERT INTO Relaciones VALUES ('" + r.getId() + "','" + r.getNombreCentro() + "','" + r.getIdAgente() + "')");
		} catch(SQLException e) {
			throw new AccessException();
		}

	}

	@Override
	public void eliminarRelacion(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("DELETE FROM Relaciones WHERE ID = '" + id + "'");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarRelacion(Relacion r) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("UPDATE Relaciones SET NOMBRECENTRO = '" + r.getNombreCentro() + "', IDAGENTE = '" + 
			r.getIdAgente() + "')");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public HashSet<Relacion> listarRelaciones(String id) throws AccessException {
		ResultSet rs;
		HashSet<Relacion> hs = new HashSet<Relacion>();;
		try {
				Statement s = conexion.createStatement();
				rs = s.executeQuery("SELECT * FROM Relaciones");
			
			while(rs.next()){
				Relacion r = new Relacion(rs.getString("IDAGENTE"), rs.getString("NOMBRECENTRO"));
				
				hs.add(r);
			}
		} catch (SQLException e) {
			throw new AccessException();
		}
		return hs;
	}

	@Override
	public boolean existeRelacion(String id) throws AccessException {
		ResultSet rs;
		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM Relaciones WHERE ID = '" + id + "')");
			return rs.next();
		} catch (SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public void eliminarRelacionesCentro(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeUpdate("DELETE FROM Relaciones WHERE NOMBRECENTRO = '" + id + "'");
		} catch (SQLException e) {
			throw new AccessException();
		}

	}


}
