package DIedrAl_Project.negocio.recursos;

public class Actividad extends Programable {

	public Actividad(String name) {
		super(name);
	}

	public Actividad(String name, String... etiquetas) {
		super(name, etiquetas);
	}

	private Dificultad dificultad;

	public Dificultad getDificultad() {
		return this.dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

}
