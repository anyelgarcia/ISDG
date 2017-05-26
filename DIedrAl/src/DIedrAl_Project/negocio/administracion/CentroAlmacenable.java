package DIedrAl_Project.negocio.administracion;

import java.util.UUID;

import DIedrAl_Project.negocio.ObjetoAlmacenable;

public class CentroAlmacenable implements ObjetoAlmacenable {

	
	private String id;
	
	private String nombre;
	
	private final String file;
	
	public CentroAlmacenable(String n){
		nombre = n;
		id = UUID.randomUUID().toString();
		file = id + "_relaciones.txt";
	}
	
	@Override
	public String getId() {
		return id;
	}

}
