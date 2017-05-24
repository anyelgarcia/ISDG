package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.Organizacion;
import DIedrAl_Project.negocio.recursos.Banco;

public abstract class SAFactory {

	private static SAFactory  instancia; 
	public static SAFactory getInstancia() {
		
		if (instancia == null)
			instancia =  new SAFactoryImpl();
		return instancia;
	}
	
	public abstract SARecursos newSARecursos(Banco bank);
	
	public abstract SAPacientes newSAPacientes(Centro centro);
	
	public abstract SAOrganizacion newSAOrganizacion(Organizacion org);
}
