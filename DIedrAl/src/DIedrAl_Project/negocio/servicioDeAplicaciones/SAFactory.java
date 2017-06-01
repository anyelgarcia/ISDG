package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.integracion.BasicClasses.AccessException;


public abstract class SAFactory {

	private static SAFactory  instancia; 
	public static SAFactory getInstancia() {
		
		if (instancia == null)
			instancia =  new SAFactoryImpl();
		return instancia;
	}
	
	public abstract SARecursos newSARecursos();
	
	public abstract SAPacientes newSAPacientes(String centro) throws AccessException;
	
	public abstract SAOrganizacion newSAOrganizacion();
	
	public abstract SACalendario newSACalendario();

}
