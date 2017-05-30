package DIedrAl_Project.integracion.SQL;

import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.BasicClasses.tRelacion;
import DIedrAl_Project.integracion.DAOinterfaces.DAORelacionable;
import DIedrAl_Project.negocio.Relacion;

public class DAORelacionableImpSQL implements DAORelacionable {

	public DAORelacionableImpSQL(tRelacion rel) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crearRelacion(Relacion r) throws AccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarRelacion(String id) throws AccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarRelacion(Relacion r) throws AccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public HashSet<Relacion> listarRelaciones(String id) throws AccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeRelacion(String id) throws AccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminarRelacionesCentro(String id) throws AccessException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
