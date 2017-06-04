package DIedrAl_Project.integracion.SQL;


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
			s.executeUpdate("INSERT INTO Centros VALUES ('" + c.getId() + "','" + c.getNombre() + "')");
		} catch(SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarCentro(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeUpdate("DELETE FROM Centros WHERE ID = '" + id + "'");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarCentro(EstadoCentro c) throws AccessException  {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("UPDATE FROM Centros SET NOMBRE = '" + c.getNombre() + "'");
		} catch(SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public HashSet<EstadoCentro> listarCentros() throws AccessException  {
		HashSet<EstadoCentro> hs = new HashSet<EstadoCentro>();
		try{
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery ("SELECT * FROM Centros");
			while(rs.next()){
				EstadoCentro c = new EstadoCentro(rs.getString("NOMBRE"));
				hs.add(c);
			}
		} catch(SQLException e) {
			throw new AccessException();
		}
		return hs;	
	}

	@Override
	public EstadoCentro consultarCentro(String id) throws AccessException {
		EstadoCentro es = null;
		try{
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery ("SELECT * FROM Centros WHERE ID = '" + id + "'");
			if(rs.next())
				es = new EstadoCentro(rs.getString("NOMBRE"));
		} catch(SQLException e) {
			throw new AccessException();
		}
		return es;
		
	}

	@Override
	public boolean existeCentro(String id) throws AccessException {
		ResultSet rs;
		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM Centros WHERE ID = '" + id + "'");
			return rs.next();
		} catch (SQLException e) {
			throw new AccessException();
		}
		
	}

	
}

