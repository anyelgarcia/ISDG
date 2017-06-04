package DIedrAl_Project.integracion.SQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.DAOSesion;
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
		Statement s;
		try {
			s = conexion.createStatement();
			s.executeUpdate ("INSERT INTO Sesiones VALUES '" + se.getId() + "','" + se.getEtiquetas() + "','" +
				se.getNombre() + "','" + se.getDescripcion() + "','" + se.getDuracion() + "'," +
				se.getDestinatarios() + "','" + se.getAsociados() + "','" + se.getVariaciones() + "','" +
				se.getDesarrollo() + "','" + se.getVariaciones()  + "')");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarSesion(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("DELETE FROM Sesiones WHERE ID = " + id);
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarSesion(Sesion se) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("UPDATE Sesiones SET ID = '" + se.getId() + "','" + 
			se.getEtiquetas() + "','" + se.getNombre() +  "','" + 
			se.getDescripcion()  + "','" + se.getDuracion() + "','" + 
			se.getDestinatarios() + "','" + se.getAsociados() + "','" +
			se.getDesarrollo() + "','" + se.getVariaciones());
		} catch (SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public HashSet<Sesion> listarSesiones() throws AccessException  {
		ResultSet rs;
		HashSet<Sesion> hs = new HashSet<Sesion>();;
		try {
				Statement s = conexion.createStatement();
				rs = s.executeQuery("SELECT * FROM `Pacientes`");
			
			while(rs.next()){
				String[] et = rs.getString("ETIQUETAS").split(" ");
				Sesion se;
				if(et == null)
					se = new Sesion(rs.getString("NOMBRE"));
				else se = new Sesion(rs.getString("NOMBRE"), et);
				se.setDescripcion(rs.getString("DESCRIPCION"));
				se.setDuracion(rs.getInt("DURACION"));
				String[] de = rs.getString("DESTINATARIOS").split(" ");
				for(String d: de)
					se.addDestinatario(d);
				se.setDesarrollo(rs.getString("DESARROLLO"));
				se.setVariaciones(rs.getString("VARIACIONES"));
				
				hs.add(se);
			}
		} catch (SQLException e) {
			throw new AccessException();
		}
		return hs;
	}

	@Override
	public boolean existeSesion(String id) throws AccessException {
		ResultSet rs;
		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM Sesiones WHERE ID = " + id);
		} catch (SQLException e) {
			throw new AccessException();
		}
		return (rs == null);
	}


	
}