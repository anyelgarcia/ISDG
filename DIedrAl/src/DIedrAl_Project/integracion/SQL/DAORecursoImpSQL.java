package DIedrAl_Project.integracion.SQL;
import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.DAORecurso;

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
		DAOPacienteImpSQL.conexion = conexion;
	}
	
	@Override
	public void crearRecurso(Recurso r) throws AccessException {
		Statement s;
		try {
			s = conexion.createStatement();
			s.executeUpdate ("INSERT INTO Usuarios VALUES '" + r.getId() + "','" + r.getEtiquetas() + "','" +
				r.getNombre() + "','" + r.getDescripcion() + "','" + (r.isFich() ? 
						1 + "','" + r.getPath() :0 + "','" + r.getURI()) + "')");
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarRecurso(String id) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("DELETE FROM Sesiones WHERE ID = " + id);
		} catch (SQLException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarRecurso(Recurso r) throws AccessException {
		try {
			Statement s = conexion.createStatement();
			s.executeQuery("UPDATE Sesiones SET ETIQUETAS = '" + r.getEtiquetas() + "', Nombre = '" + 
			r.getNombre() + "', DESCRIPCION = '" + r.getDescripcion() +  "', FOD = " + 
			(r.isFich() ? 1 + ", FILEURI = " + r.getPath() : 0 + ", FILEURI = " + r.getURI()) 
			+ " WHERE ID = " + r.getId() + ")");
			} catch (SQLException e) {
			throw new AccessException();
		}
		
	}

	@Override
	public HashSet<Recurso> listarRecursos() throws AccessException  {
		ResultSet rs;
		HashSet<Recurso> hs = new HashSet<Recurso>();;
		try {
				Statement s = conexion.createStatement();
				rs = s.executeQuery("SELECT * FROM Recursos");
			
			while(rs.next()){
				String[] et = rs.getString("ETIQUETAS").split(" ");
				boolean f = rs.getBoolean("FOD");
				Recurso r;
				if(et == null)
					if(f)
						r = new Recurso(rs.getString("NOMBRE"), new File(rs.getString("FILEURI")));
					else
						r = new Recurso(rs.getString("NOMBRE"), rs.getString("FILEURI"));		
				else 
					if(f)
						r = new Recurso(rs.getString("NOMBRE"), new File(rs.getString("FILEURI")), et);
					else
						r = new Recurso(rs.getString("NOMBRE"), rs.getString("FILEURI"), et);
				
				hs.add(r);
			}
		} catch (URISyntaxException | SQLException e) {
			throw new AccessException();
		}
		return hs;
	}

	@Override
	public boolean existeRecurso(String id) throws AccessException {
		ResultSet rs;
		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery("SELECT * FROM Recursos WHERE ID = " + id);
		} catch (SQLException e) {
			throw new AccessException();
		}
		return (rs == null);
	}


	
}


