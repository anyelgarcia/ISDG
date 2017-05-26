package DIedrAl_Project.negocio.administracion;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Organizacion {
	
	private static Organizacion instancia = null;
	
	private final Map<String, Centro> centros;
	

	public static Organizacion getInstancia() {

		if (instancia == null)
			instancia = new Organizacion();

		return instancia;
	}
	
	protected Organizacion(){
		centros = new HashMap<String, Centro>();
		
	}

	//APAÑO PARA PODER TRABAJAR
	public Centro getCentro(String name) throws NotBoundException {
		if(!centros.containsKey(name)){
			throw new NotBoundException("Centro ya introducido");
		}
		else return centros.get(name);
		
	}
	public void addCentro(String name) throws AlreadyBoundException{
		if(centros.containsKey(name)){
			throw new AlreadyBoundException("Centro ya introducido");
		}
		else{
			centros.put(name, new Centro(name));
		}
	}
	
	public void removeCentro(String name) throws NotBoundException{
		if(!centros.containsKey(name)){
			throw new NotBoundException("Centro ya introducido");
		}
		else{
			centros.remove(name);
		}
	}

    
}
