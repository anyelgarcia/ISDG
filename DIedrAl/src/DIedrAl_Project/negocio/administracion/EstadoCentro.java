package DIedrAl_Project.negocio.administracion;

import java.io.Serializable;

import DIedrAl_Project.negocio.ObjetoAlmacenable;

public class EstadoCentro implements ObjetoAlmacenable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6509819416130998125L;
	private String nombre;
	
	public EstadoCentro(String n){
		nombre = n;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public String getId() {
		return nombre;
	}
	
}
