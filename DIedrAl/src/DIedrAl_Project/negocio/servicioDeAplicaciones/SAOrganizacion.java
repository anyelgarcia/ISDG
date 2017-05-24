package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.rmi.*;

import DIedrAl_Project.negocio.administracion.Centro;

public interface SAOrganizacion {
	public Centro getCentro(String name) throws NotBoundException;
	
	public void addCentro(String name) throws AlreadyBoundException;
	
	public void eraseCentro(String name) throws NotBoundException;
}
