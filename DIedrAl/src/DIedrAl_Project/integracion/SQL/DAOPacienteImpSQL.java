package DIedrAl_Project.integracion.SQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.DAOPaciente;
import DIedrAl_Project.negocio.pacientes.Paciente;




public class DAOPacienteImpSQL implements DAOPaciente{
	
	public static DAOPacienteImpSQL instancia = null;
	
	public static Connection conexion = null;

	public static DAOPacienteImpSQL getInstance(Connection conexion){
		if(instancia == null){
			instancia = new DAOPacienteImpSQL(conexion);
		}
		return instancia;
	}

	public DAOPacienteImpSQL(Connection conexion) {
		DAOPacienteImpSQL.conexion = conexion;
	}
	
	@Override
	public void crearPaciente(Paciente p) throws AccessException{
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("INSERT INSERT INTO");
		} catch(SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarPaciente(String id) throws AccessException  {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("DELETE FROM ");
		} catch(SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarPaciente(Paciente p) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("UPDATE FROM ");
		} catch(SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public HashSet<Paciente> listarPacientes()  {
		
	}

	@Override
	public boolean existePaciente(String id) throws AccessException {
		ResultSet rs;
		try{
			Statement s = conexion.createStatement();
			rs = s.executeQuery ("SELECT * ");
		} catch(SQLException e) {
			throw new AccessException();
		}
		return (rs == null);
	}

	@Override
	public Paciente consultarPaciente(String id) throws AccessException {
		try{
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery ("SELECT * ");
		} catch(SQLException e) {
			throw new AccessException();
		}
		return null;
	}

	
}
