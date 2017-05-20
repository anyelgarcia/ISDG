package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.recursos.Banco;

public abstract class SAFactory {

	static SAFactory  instancia; 
	static public SAFactory getInstancia() {
		
		if (instancia == null)
			instancia =  new SAFactoryImpl();
		return instancia;
	}
	public abstract SARecursos newSARecursos(Banco bank);
	
	public abstract SAPacientes newSAPacientes(Centro centro);
}
