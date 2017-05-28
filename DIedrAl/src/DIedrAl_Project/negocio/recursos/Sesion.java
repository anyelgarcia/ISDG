package DIedrAl_Project.negocio.recursos;



public class Sesion extends Programable {
   
	private static final long serialVersionUID = 7973178557629392790L;

	public Sesion(String name){
		super(name);
	}
	
	public Sesion(String name, String... etiquetas) {
		super(name, etiquetas);
	}

}
