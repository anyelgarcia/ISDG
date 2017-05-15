package DIedrAl_Project.negocio.recursos;

import java.util.Set;

public class Actividad extends Programable {

    public Actividad(String name) {
		super(name);
	}

	private Dificultad dificultad;

    
    public Dificultad getDificultad(){
    	return this.dificultad;
    }
    

}
