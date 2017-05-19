package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.negocio.recursos.Sesion;

public class SARecursosImpl implements SARecursos{
	private Banco bank;
	
	public SARecursosImpl(Banco b){
		bank=b;
	}

	@Override
	public void addRecurso(Recurso rec) {
		bank.addRecurso(rec);
	}

	@Override
	public void removeRecurso(Recurso rec) {
		bank.removeRecurso(rec);
		
	}

	@Override
	public void addActividad(Actividad act) {
		bank.addActividad(act);
		
	}

	@Override
	public void removeActividad(Actividad act) {
		bank.removeActividad(act);
		
	}

	@Override
	public void addSesion(Sesion ses) {
		bank.addSesion(ses);
		
	}

	@Override
	public void removeSesion(Sesion ses) {
		bank.removeSesion(ses);
		
	}

}
