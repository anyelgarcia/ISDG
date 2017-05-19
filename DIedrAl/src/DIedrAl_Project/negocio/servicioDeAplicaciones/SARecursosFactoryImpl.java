package DIedrAl_Project.negocio.servicioDeAplicaciones;

public class SARecursosFactoryImpl extends SARecursosFactory{

	@Override
	public SARecursos newSARecursos() {
		return new SARecursosImpl();
	}

}
