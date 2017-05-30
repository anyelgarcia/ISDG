package DIedrAl_Project.integracion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.negocio.pacientes.Informe;




public class DAOInformeImpSQL implements DAOInforme{
	
	public static DAOInformeImpSQL instancia = null;
	
	public static Connection conexion = null;

	public static DAOInformeImpSQL getInstance(Connection conexion){
		if(instancia == null){
			instancia = new DAOInformeImpSQL(conexion);
		}
		return instancia;
	}

	public DAOInformeImpSQL(Connection conexion) {
		DAOInformeImpSQL.conexion = conexion;
	}
	
	@Override
	public void crearInforme(Informe i) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("INSERT INSERT INTO");
		} catch(SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public void eliminarInforme(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("DELETE FROM ");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarInforme(Informe i) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("UPDATE FROM ");
		} catch (SQLException e) {
			throw new AccessException();
		}

	}

	@Override
	public HashSet<Informe> listarInformes()  {
		
	}

	@Override
	public boolean existeInformes(String id) throws AccessException {
		ResultSet rs;
		try{
			Statement s = conexion.createStatement();
			rs = s.executeQuery ("SELECT * ");
		} catch(SQLException e) {
			throw new AccessException();
		}
		return (rs == null);
	}

	
}

