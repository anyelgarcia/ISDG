package DIedrAl_Project.negocio.administracion;

import DIedrAl_Project.negocio.ObjetoAlmacenable;

public class EstadoCentro implements ObjetoAlmacenable {
	
	private String nombre;
	
	public EstadoCentro(String n){
		nombre = n;
	}
	
	@Override
	public String getId() {
		return nombre;
	}
}
