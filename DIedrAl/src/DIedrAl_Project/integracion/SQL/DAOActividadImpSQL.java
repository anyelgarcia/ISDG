package DIedrAl_Project.integracion.SQL;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.DAOActividad;
import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.Dificultad;



public class DAOActividadImpSQL implements DAOActividad{
	
	public static DAOActividadImpSQL instancia = null;
	
	public static Connection conexion = null;

	public static DAOActividadImpSQL getInstance(Connection conexion){
		if(instancia == null){
			instancia = new DAOActividadImpSQL(conexion);
		}
		return instancia;
	}

	public DAOActividadImpSQL(Connection conexion) {
		DAOActividadImpSQL.conexion = conexion;
	}
	
	@Override
	public void crearActividad(Actividad a) throws AccessException {
		Statement s;
		try {
			s = conexion.createStatement();
			s.executeUpdate ("INSERT INTO `Actividades` VALUES '" + a.getEtiquetas().toString() + "','"
				+ a.getNombre() + "','" + a.getDescripcion() + "','" + a.getId() + "'," +
				a.getDuracion() + "," + a.getDificultad().getOrdinal() + "," +  a.getDestinatarios().toString() + "','" + a.getAsociados().toString() + "','" +
				a.getDesarrollo() + "','" + a.getVariaciones() + "')");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarActividad(String id) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("DELETE FROM `Actividades` WHERE ID = '" + id + "'");		
		} catch(SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarActividad(Actividad a) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("UPDATE FROM `Actividades` SET `ETIQUETAS`= " + a.getEtiquetas().toString() + ",`NOMBRE`="
					+ a.getNombre() + ",`DESCRIPCION`= " + a.getDescripcion() + "`DURACION`= " + a.getDuracion()
					+ ", `DIFICULTAD` = " + a.getDificultad().getOrdinal()
					+ ",`DESTINATARIOS`=" + a.getDestinatarios() + ",`ASOCIADOS`= " + a.getAsociados().toString()
					+ ",`DESARROLLO`=" + a.getDesarrollo() + ",`VARIACIONES`=" + a.getVariaciones() + " WHERE `ID` = '"
					+ a.getId() + "'");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public HashSet<Actividad> listarActividades() throws AccessException  {
		ResultSet rs;
		HashSet<Actividad> hs = new HashSet<Actividad>();;
		try {
				Statement s = conexion.createStatement();
				rs = s.executeQuery("SELECT * FROM `Actividades`");
			
			while(rs.next()){
				Actividad a = new Actividad(rs.getString("NOMBRE"), rs.getString("ETIQUETAS"));
				a.setDesarrollo(rs.getString("DESARROLLO"));
				a.setDescripcion(rs.getString("DESCRPCION"));
				a.setDificultad(Dificultad.values()[rs.getInt("DIFICULTAD")]);
				a.setDuracion(rs.getInt("DURACION"));
				a.setVariaciones(rs.getString("VARIACIONES"));
				a.addDestinatario(rs.getString("DESTINATARIO"));
				hs.add(a);
			}
		} catch (SQLException e) {
			throw new AccessException();
		}
		return hs;
	}


	@Override
	public boolean existeActividad(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM `Actividades` WHERE `ID` = '" + id + "'");
			return (rs == null);
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	
}

