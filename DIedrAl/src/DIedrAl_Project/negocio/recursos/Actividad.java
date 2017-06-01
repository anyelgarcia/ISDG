package DIedrAl_Project.negocio.recursos;

public class Actividad extends Programable {
	private static final long serialVersionUID = 8515286333067141189L;
	private Dificultad dificultad;

	public Actividad(String name) {
		super(name);
	}

	public Actividad(String name, String... etiquetas) {
		super(name, etiquetas);
	}

	public Dificultad getDificultad() {
		return this.dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	public void igualarCampos(Actividad that){
		super.igualarCampos(that);
		this.dificultad = that.dificultad;
	}

}
