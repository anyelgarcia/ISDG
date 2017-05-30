package DIedrAl_Project.negocio.administracion;

import java.io.Serializable;

import DIedrAl_Project.negocio.ObjetoAlmacenable;

public class EstadoCentro implements ObjetoAlmacenable, Serializable {
	
	private String nombre;
	
	public EstadoCentro(String n){
		nombre = n;
	}
	
	@Override
	public String getId() {
		return nombre;
	}
}
