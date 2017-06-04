package DIedrAl_Project.integracion.SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.DAOPaciente;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.pacientes.Direccion;
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
		Statement s;
		try {
			s = conexion.createStatement();
			s.executeUpdate ("INSERT INTO `Pacientes` VALUES '" + p.getId() + "','" + p.getNif() + "','" +
				p.getName() + "','" + p.getFirstSurname() + "','" + p.getSecondSurname() + "'," +
				p.getBirthday() + "," + p.getAddress() + "','" + p.getEmail() + "','" +
				p.getTfo() + "','" + p.getPerfil() + "','" + p.getCentro()  + "','" + p.getDatos().getEstadocivil() +"','" +
				p.getDatos().getDatosfamiliares() + "','" + p.getDatos().getLesion() + "','" + 
				p.getDatos().getLesion() + "','" + p.getDatos().getAficiones() +"')");
		} catch (SQLException e) {
			throw new AccessException("Error al crear un Paciente");
		}
	}

	@Override
	public void eliminarPaciente(String id) throws AccessException  {
		try{
			Statement s = conexion.createStatement();
			s.executeQuery ("DELETE FROM `Pacientes` WHERE `ID` = '" + id + "'");
		} catch(SQLException e) {
			throw new AccessException("Error al eliminar un Paciente");
		}
	}

	@Override
	public void modificarPaciente(Paciente p) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("UPDATE FROM `Pacientes` SET `NIF` = " + p.getNif() + ",`NOMBRE`= " + p.getName() + ",`APELLIDO1`="
					+ p.getFirstSurname() + ",`APELLIDO2`= " + p.getSecondSurname() + "`FECHANACIMIENTO`= " + p.getBirthday()
					+ ",`DIRECCION`=" + p.getAddress() + ",`EMAIL`= " + p.getEmail() + ",`TFO`=" 
					+ p.getTfo() + ",`PERFIL`=" + p.getPerfil() + ",`CENTRO`=" + p.getCentro() +
					",`ESTADOCIVIL`=" + p.getDatos().getEstadocivil() +
					",`DATOSFAMILIARES`=" + p.getDatos().getDatosfamiliares() +
					",`LESION`=" + p.getDatos().getLesion() + 
					",`FECHALESION`=" + p.getDatos().getFechalesion() +
					",`AFICIONES`=" + p.getDatos().getAficiones().toString() +
					" WHERE `ID` = '" + p.getId() + "'");
		} catch (SQLException e) {
			throw new AccessException("Error al modificar un Paciente");
		}
	}

	@Override
	public HashSet<Paciente> listarPacientes() throws AccessException  {
		HashSet<Paciente> hs = new HashSet<Paciente>();;
		try {
				Statement s = conexion.createStatement();
				ResultSet rs = s.executeQuery("SELECT * FROM `Pacientes`");
			
			while(rs.next()){
				Paciente p = new Paciente(rs.getString("NOMBRE"), rs.getString("APELLIDO1"),
						rs.getString("APELLIDO2"), rs.getString("NIF"));
				String[] fecha = rs.getString("FECHADENACIMIENTO").split("-");
				p.setBirthday(new Fecha((int) Integer.parseInt(fecha[0]), fecha[1], 
						(int) Integer.parseInt(fecha[2]), (int) Integer.parseInt(fecha[3])));
				Direccion dir = new Direccion();
				dir.setLocalidad(rs.getString("LOCALIDAD")); dir.setProvincia(rs.getString("PROVINCIA"));
				dir.setCalle(rs.getString("CALLE")); dir.setPiso(rs.getInt("PISO"));
				dir.setPortal(rs.getInt("PORTAL")); dir.setPuerta(rs.getInt("PUERTA"));
				dir.setCodigopostal(rs.getInt("CODIGOPOSTAL"));
				
				p.setAddress(dir);
				
				p.setEmail(rs.getString("EMAIL"));
				p.setTfo(rs.getString("TFO"));
				p.setPerfil(rs.getString("PERFIL"));
				p.setCentro(rs.getString("CENTRO"));
				
				
				hs.add(p);
			}
		} catch (SQLException e) {
			throw new AccessException("Error al listar Pacientes");
		}
		return hs;
	}

	@Override
	public boolean existePaciente(String id) throws AccessException {
		ResultSet rs;
		try{
			Statement s = conexion.createStatement();
			rs = s.executeQuery ("SELECT * FROM Pacients WHERE ID = '" + id + "'");
		} catch(SQLException e) {
			throw new AccessException("Error al comprobar si un paciente existe");
		}
		return (rs == null);
	}

	@Override
	public Paciente consultarPaciente(String id) throws AccessException {
		Paciente p = null;
		try{
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Pacientes WHERE ID = '" + id + "'");
			p = new Paciente(rs.getString("NOMBRE"), rs.getString("APELLIDO1"), rs.getString("APELLIDO2"),
					rs.getString("NIF"));
			String[] fecha = rs.getString("FECHADENACIMIENTO").split("-");
			p.setBirthday(new Fecha((int) Integer.parseInt(fecha[0]), fecha[1], (int) Integer.parseInt(fecha[2]),
					(int) Integer.parseInt(fecha[3])));
			
			Direccion dir = new Direccion();
			dir.setLocalidad(rs.getString("LOCALIDAD")); dir.setProvincia(rs.getString("PROVINCIA"));
			dir.setCalle(rs.getString("CALLE")); dir.setPiso(rs.getInt("PISO"));
			dir.setPortal(rs.getInt("PORTAL")); dir.setPuerta(rs.getInt("PUERTA"));
			dir.setCodigopostal(rs.getInt("CODIGOPOSTAL"));
			
			p.setAddress(dir);
			
			
			p.setEmail(rs.getString("EMAIL"));
			p.setTfo(rs.getString("TFO"));
			p.setPerfil(rs.getString("PERFIL"));
			p.setCentro(rs.getString("CENTRO"));

		} catch(SQLException e) {
			throw new AccessException("Error al consultar un Paciente");
		}
		return p;
	}

	
}
