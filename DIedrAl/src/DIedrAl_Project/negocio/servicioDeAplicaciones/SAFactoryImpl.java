package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.Organizacion;
import DIedrAl_Project.negocio.recursos.Banco;

public class SAFactoryImpl extends SAFactory{

	@Override
	public SARecursos newSARecursos() {
		return new SARecursosImpl();
	}

	@Override
	public SAPacientes newSAPacientes(Centro centro) {
		return new SAPacientesImpl(centro);
	}

	@Override
	public SAOrganizacion newSAOrganizacion(Organizacion org) {
		return new SAOrganizacionImpl(org);
	}
	


}
