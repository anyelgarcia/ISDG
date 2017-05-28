package DIedrAl_Project.integracion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.negocio.recursos.Actividad;



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
			s.executeQuery ("INSERT INTO `Actividades` VALUES '" + a.getEtiquetas().toString() + "','"
				+ a.getNombre() + "','" + a.getDescripcion() + "','" + a.getId() + "'," +
				a.getDuracion() + "," + a.getDestinatarios().toString() + "','" + a.getAsociados().toString() +
				a.getDesarrollo() + "','" + a.getVariaciones() + "')");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarActividad(String id) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("DELETE FROM `Actividades` WHERE `ID` = " + id);		
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
					+ ",`DESTINATARIOS`=" + a.getDestinatarios() + ",`ASOCIADOS`= " + a.getAsociados().toString()
					+ ",`DESARROLLO`=" + a.getDesarrollo() + ",`VARIACIONES`=" + a.getVariaciones() + " WHERE `ID` = "
					+ a.getId());
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public HashSet<Actividad> listarActividades()  {
		
	}

	@Override
	public boolean existeActividad(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM `Actividades` WHERE `ID` = " + id);
			return (rs == null);
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	
}

