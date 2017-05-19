package DIedrAl_Project.negocio.servicioDeAplicaciones;

public abstract class SARecursosFactory {

	static SARecursosFactory  instancia; 
	static public SARecursosFactory getInstancia() {
		
		if (instancia == null)
			instancia =  new SARecursosFactoryImpl();
		return instancia;
	}
	public abstract SARecursos newSARecursos();
}
