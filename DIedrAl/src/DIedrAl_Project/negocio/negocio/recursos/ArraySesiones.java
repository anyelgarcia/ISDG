package DIedrAl_Project.negocio.recursos;



public class ArraySesiones extends ArrayProgramables<Sesion> {
	
	ArraySesiones(){
		super();
	}

	@Override
	protected ArrayProgramables<Sesion> createNew() {
		return new ArraySesiones();
	}
	

}
