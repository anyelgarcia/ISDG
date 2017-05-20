package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.recursos.Banco;

public class SAFactoryImpl extends SAFactory{

	@Override
	public SARecursos newSARecursos(Banco bank) {
		return new SARecursosImpl(bank);
	}

	@Override
	public SAPacientes newSAPacientes(Centro centro) {
		return new SAPacientesImpl(centro);
	}
	


}
