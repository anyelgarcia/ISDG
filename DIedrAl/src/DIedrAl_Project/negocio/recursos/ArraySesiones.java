package DIedrAl_Project.negocio.recursos;

import java.util.Set;

public class ArraySesiones extends ArrayProgramables<Sesion> {
	
	public ArraySesiones(){
		super();
	}
	
	public ArraySesiones(Set<Sesion> ses) {
		super(ses);
	}
	@Override
	protected ArrayProgramables<Sesion> createNew() {
		return new ArraySesiones();
	}
	

}
