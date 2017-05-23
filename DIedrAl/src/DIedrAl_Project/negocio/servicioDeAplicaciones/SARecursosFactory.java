package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.negocio.recursos.Banco;

public abstract class SARecursosFactory {

	static SARecursosFactory  instancia; 
	static public SARecursosFactory getInstancia() {
		
		if (instancia == null)
			instancia =  new SARecursosFactoryImpl();
		return instancia;
	}
	public abstract SARecursos newSARecursos(Banco bank);
}
