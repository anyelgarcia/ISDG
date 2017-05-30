package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.integracion.BasicClasses.AccessException;

public class SAFactoryImpl extends SAFactory{

	@Override
	public SARecursos newSARecursos() {
		return SARecursosImpl.getInstancia();
	}

	@Override
	public SAPacientes newSAPacientes(String centro) throws AccessException  {
		return new SAPacientesImpl(centro);
	}

	@Override
	public SAOrganizacion newSAOrganizacion() {
		return SAOrganizacionImpl.getInstancia();
	}
	


}
