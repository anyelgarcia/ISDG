package DIedrAl_Project.integracion;

import java.util.*;

import DIedrAl_Project.negocio.administracion.Persona;

public interface DAORelacionable {
	public HashMap<Persona, Set<Persona>> obtenerRelaciones();
}
