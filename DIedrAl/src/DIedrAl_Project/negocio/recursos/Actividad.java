package DIedrAl_Project.negocio.recursos;

public class Actividad extends Programable {

    public Actividad(String name) {
		super(name);
	}

	private Dificultad dificultad;

    
    public Dificultad getDificultad(){
    	return this.dificultad;
    }
    

}
