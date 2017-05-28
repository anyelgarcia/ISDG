package DIedrAl_Project.integracion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.negocio.recursos.Recurso;

public class DAORecursoImpSQL implements DAORecurso{
	
	public static DAORecursoImpSQL instancia = null;
	
	public static Connection conexion = null;

	public static DAORecursoImpSQL getInstance(Connection conexion){
		if(instancia == null){
			instancia = new DAORecursoImpSQL(conexion);
		}
		return instancia;
	}

	public DAORecursoImpSQL(Connection conexion) {
		DAORecursoImpSQL.conexion = conexion;
	}
	
	@Override
	public void crearRecurso(Recurso r) throws AccessException  {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("INSERT INSERT INTO");
		} catch(SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarRecurso(String id) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("DELETE FROM ");	
		} catch(SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarRecurso(Recurso r) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("UPDATE FROM ");
		} catch(SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public HashSet<Recurso> listarRecursos()  {
		
	}

	@Override
	public boolean existeRecurso(String id) throws AccessException {
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


