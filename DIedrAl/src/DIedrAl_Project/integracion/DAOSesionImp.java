package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.administracion.Terapeuta;
import DIedrAl_Project.negocio.pacientes.Informe;
import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.Sesion;

public class DAOSesionImp implements DAOSesion {

	private static DAOSesionImp instancia = null;
	
	private DAObasico<Sesion> op;
	private String file = "sesiones.txt";
	
	public static DAOSesionImp getInstance(){
		if(instancia == null) return new DAOSesionImp();
		else return instancia;
	}

	
	private DAOSesionImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void crearSesion(Sesion a) throws IOException {
		op.guardar(a, file);
	}

	@Override
	public void eliminarSesion(String id) throws IOException,
			ClassNotFoundException {
		op.borrar(id, file);
	}

	@Override
	public void modificarSesion(Sesion r) throws IOException,
			ClassNotFoundException {
		op.modificar(r, file);
	}

	@Override
	public HashSet<Sesion> listarSesiones() throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return op.obtenerDatosSet(file);
	}

	@Override
	public boolean existeSesion(String id) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return op.exists(id, file);
	}

}
