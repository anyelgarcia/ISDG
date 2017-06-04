package DIedrAl_Project.integracion.SQL;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.DAOUsuario;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.pacientes.Direccion;



public class DAOUsuarioImpSQL implements DAOUsuario{
	
	public static DAOUsuarioImpSQL instancia = null;
	
	public static Connection conexion;

	public static DAOUsuarioImpSQL getInstance(Connection conexion){
		if(instancia == null){
			instancia = new DAOUsuarioImpSQL(conexion);
		}
		return instancia;
	}

	public DAOUsuarioImpSQL(Connection conexion) {
		System.out.println(conexion);
		System.out.println(this.conexion);
		DAOUsuarioImpSQL.conexion = conexion;
		System.out.println(conexion);
		System.out.println(this.conexion);
		
	}
	
	@Override
	public void crearUsuario(Usuario u) throws AccessException {
		Statement s;
		try {
			s = conexion.createStatement();
			s.executeUpdate ("INSERT INTO `Usuarios` VALUES '" + u.getId() + "','" + u.getNif() + "','" +
				u.getName() + "','" + u.getFirstSurname() + "','" + u.getSecondSurname() + "'," +
				u.getBirthday() + "," + u.getAddress().getLocalidad() + "','" 
				+ "','" + u.getAddress().getProvincia() + "','" + u.getAddress().getCalle()
				+ "','" + u.getAddress().getPiso() + "','" + u.getAddress().getPortal() 
				+ "','" + u.getAddress().getPuerta() + "','" + u.getAddress().getCodigopostal() 
				+ "','" + u.getEmail() + "','" + u.getTfo() + "','" + u.getCentro()
				+ "','" + u.getPerfil() + "'," + u.isAdmin()  + ",'" + u.getInfor()
				+ "','" + u.getPassword() +"')");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarUsuario(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("DELETE FROM Usuarios WHERE ID = " + id);
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarUsuario(Usuario u) throws AccessException{
			Statement s;
			try {
				s = conexion.createStatement();
				s.executeQuery("UPDATE Usuarios SET NIF = '" + u.getNif() 
					+ "', NOMBRE = '" + u.getName() + "', APELLIDO1 = '" + u.getFirstSurname()
					+ "', APELLIDO2 = '" + u.getSecondSurname() + "', FECHANACIMIENTO = " + u.getBirthday()
					+ ", LOCALIDAD = " + u.getAddress().getLocalidad()
					+ "', PROVINCIA = '" + u.getAddress().getProvincia() + "', CALLE = '" + u.getAddress().getCalle()
					+ "', PISO = '" + u.getAddress().getPiso() + "', PORTAL = '" + u.getAddress().getPortal() 
					+ "', PUERTA = '" + u.getAddress().getPuerta() + "', CODIGOPOSTAL = " + u.getAddress().getCodigopostal() 
					+ "', EMAIL = '" + u.getEmail() + "', TFO = '" + u.getTfo() + "', CENTRO = '" + u.getCentro()
					+ "', PERFIL = '" + u.getPerfil() + "', ADMINISTRADOR = " + u.isAdmin()  + ", INFOR = '" + u.getInfor() 
					+ "', PASSWORD = " + u.getPassword() + "')");
			} catch (SQLException e) {
				throw new AccessException();
			}
	}

	@Override
	public HashSet<Usuario> listarUsuarios() throws AccessException  {
		ResultSet rs;
		HashSet<Usuario> hs = new HashSet<Usuario>();;
		try {
				Statement s = conexion.createStatement();
				rs = s.executeQuery("SELECT * FROM `Usuarios`");
			
			while(rs.next()){
				Usuario u = new Usuario(rs.getString("NOMBRE"), rs.getString("APELLIDO1"),
						rs.getString("APELLIDO2"), rs.getString("NIF"));
				String[] fecha = rs.getString("FECHADENACIMIENTO").split("-");
				u.setBirthday(new Fecha((int) Integer.parseInt(fecha[0]), fecha[1], 
						(int) Integer.parseInt(fecha[2]), (int) Integer.parseInt(fecha[3])));
				Direccion dir = new Direccion();
				dir.setLocalidad(rs.getString("LOCALIDAD")); dir.setProvincia(rs.getString("PROVINCIA"));
				dir.setCalle(rs.getString("CALLE")); dir.setPiso(rs.getInt("PISO"));
				dir.setPortal(rs.getInt("PORTAL")); dir.setPuerta(rs.getInt("PUERTA"));
				dir.setCodigopostal(rs.getInt("CODIGOPOSTAL"));
				
				u.setAddress(dir);
				u.setEmail(rs.getString("EMAIL"));
				u.setTfo(rs.getString("TFO"));
				u.setPerfil(rs.getString("PERFIL"));
				u.setCentro(rs.getString("CENTRO"));
				if(rs.getInt("ADMINISTRADOR") == 1) u.setAdmin();
				u.setInfor(rs.getString("INFOR"));
				u.setPassword(rs.getString("PASSWORD"));
				
				hs.add(u);
			}
		} catch (SQLException e) {
			throw new AccessException();
		}
		return hs;
	}

	@Override
	public boolean existeUsuario(String id) throws AccessException {
		ResultSet rs;
		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM Usuarios WHERE ID = " + id);
		} catch (SQLException e) {
			throw new AccessException();
		}
		return (rs == null);
	}

	@Override
	public Usuario consultarUsuario(String id) throws AccessException {
		ResultSet rs;
		Usuario u = null;
		try {
			System.out.println("Primero");
			System.out.println(conexion);
			System.out.println("Sefundo");
			Statement s = conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM Usuarios WHERE ID = " + id);
			u = new Usuario(rs.getString("NOMBRE"), rs.getString("APELLIDO1"),
					rs.getString("APELLIDO2"), rs.getString("NIF"));
			String[] fecha = rs.getString("FECHADENACIMIENTO").split("-");
			u.setBirthday(new Fecha((int) Integer.parseInt(fecha[0]), fecha[1], 
					(int) Integer.parseInt(fecha[2]), (int) Integer.parseInt(fecha[3])));
			
			Direccion dir = new Direccion();
			dir.setLocalidad(rs.getString("LOCALIDAD")); dir.setProvincia(rs.getString("PROVINCIA"));
			dir.setCalle(rs.getString("CALLE")); dir.setPiso(rs.getInt("PISO"));
			dir.setPortal(rs.getInt("PORTAL")); dir.setPuerta(rs.getInt("PUERTA"));
			dir.setCodigopostal(rs.getInt("CODIGOPOSTAL"));
			
			u.setAddress(dir);
			u.setEmail(rs.getString("EMAIL"));
			u.setTfo(rs.getString("TFO"));
			u.setPerfil(rs.getString("PERFIL"));
			u.setCentro(rs.getString("CENTRO"));
			if(rs.getInt("ADMINISTRADOR") == 1) u.setAdmin();
			u.setInfor(rs.getString("INFOR"));
			u.setPassword(rs.getString("PASSWORD"));
		} catch (SQLException e) {
			throw new AccessException();
		}
		return u ;
	}


	
}