package DIedrAl_Project.negocio.administracion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Organizacion {
    //private final Banco banco;
	
	private static Organizacion instancia = null;
	
	private Set<String> centros;

	public static Organizacion getInstancia() {

		if (instancia == null)
			instancia = new Organizacion();

		return instancia;
	}
	protected Organizacion(){
		centros = new HashSet<String>();
	}

	public Set<String> getCentros() {
		return centros;
	}
	public void setCentros(Set<String> centros) {
		this.centros = centros;
	}

    
}
