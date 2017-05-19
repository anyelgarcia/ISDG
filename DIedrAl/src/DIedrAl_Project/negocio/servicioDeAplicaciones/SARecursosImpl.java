package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Recurso;

public class SARecursosImpl implements SARecursos{
	private Banco bank;
	
	public SARecursosImpl(Banco b){
		bank=b;
	}

	@Override
	public void addRecurso(Recurso rec) {
		bank.addRecurso(rec);
	}

}
