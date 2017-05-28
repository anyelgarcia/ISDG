package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;

public class SAFactoryImpl extends SAFactory{

	@Override
	public SARecursos newSARecursos() {
		return SARecursosImpl.getInstancia();
	}

	@Override
	public SAPacientes newSAPacientes(String centro) throws ClassNotFoundException, IOException {
		return new SAPacientesImpl(centro);
	}

	@Override
	public SAOrganizacion newSAOrganizacion() {
		return SAOrganizacionImpl.getInstancia();
	}
	


}
