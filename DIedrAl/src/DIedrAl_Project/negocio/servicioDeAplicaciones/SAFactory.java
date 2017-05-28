package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;

public abstract class SAFactory {

	private static SAFactory  instancia; 
	public static SAFactory getInstancia() {
		
		if (instancia == null)
			instancia =  new SAFactoryImpl();
		return instancia;
	}
	
	public abstract SARecursos newSARecursos();
	
	public abstract SAPacientes newSAPacientes(String centro) throws ClassNotFoundException, IOException;
	
	public abstract SAOrganizacion newSAOrganizacion();

}
