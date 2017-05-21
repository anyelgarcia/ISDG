package DIedrAl_Project.negocio.recursos;



public class Sesion extends Programable {
   
	public Sesion(String name){
		super(name);
	}
	
	public Sesion(String name, String... etiquetas) {
		super(name, etiquetas);
	}
	
	public Sesion(String name, int duracion, String descripcion, String desarrollo, String variaciones, String... etiquetas) {
		super(name, duracion, descripcion, desarrollo, variaciones, etiquetas);
	}

}
