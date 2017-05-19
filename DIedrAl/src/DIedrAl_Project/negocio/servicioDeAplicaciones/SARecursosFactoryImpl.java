package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.negocio.recursos.Banco;

public class SARecursosFactoryImpl extends SARecursosFactory{

	@Override
	public SARecursos newSARecursos(Banco bank) {
		return new SARecursosImpl(bank);
	}


}
