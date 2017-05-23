package DIedrAl_Project.negocio.administracion;

import java.util.HashSet;
import java.util.Set;

public class Organizacion {
	
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
	
	//APA�O PARA PODER TRABAJAR
	public Centro getCentro(String nombreCentro) {
		return new Centro(nombreCentro);
	}
	
	public void setCentros(Set<String> centros) {
		this.centros = centros;
	}

    
}
