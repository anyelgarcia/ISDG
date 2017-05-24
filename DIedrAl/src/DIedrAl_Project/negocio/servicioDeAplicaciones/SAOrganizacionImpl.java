package DIedrAl_Project.negocio.servicioDeAplicaciones;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.Organizacion;

public class SAOrganizacionImpl implements SAOrganizacion {
	
	private Organizacion org;

	public SAOrganizacionImpl(Organizacion org) {
		this.org=org;
	}

	@Override
	public Centro getCentro(String name) throws NotBoundException {
		return org.getCentro(name);
	}

	@Override
	public void addCentro(String name) throws AlreadyBoundException {
		org.addCentro(name);
		
	}

	@Override
	public void eraseCentro(String name) throws NotBoundException {
		org.removeCentro(name);
	}
}
