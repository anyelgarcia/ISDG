package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.Organizacion;
import DIedrAl_Project.negocio.recursos.Banco;

public class SAFactoryImpl extends SAFactory{

	@Override
	public SARecursos newSARecursos() {
		return new SARecursosImpl();
	}

	@Override
	public SAPacientes newSAPacientes(String centro) throws ClassNotFoundException, IOException {
		return new SAPacientesImpl(centro);
	}

	@Override
	public SAOrganizacion newSAOrganizacion(Organizacion org) {
		return new SAOrganizacionImpl(org);
	}
	


}
