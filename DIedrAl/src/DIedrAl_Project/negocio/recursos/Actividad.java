package DIedrAl_Project.negocio.recursos;

public class Actividad extends Programable {

	private Dificultad dificultad;

	public Actividad(String name) {
		super(name);
	}

	public Actividad(String name, String... etiquetas) {
		super(name, etiquetas);
	}
	
	public Actividad(String name, String dificultad, int duracion, String tipoPaciente, String descripcion, String desarrollo, String variaciones, String... etiquetas) {
		super(name, duracion, descripcion, desarrollo, variaciones, etiquetas);
		this.addDestinatario(tipoPaciente);
		this.dificultad = Dificultad.valueOf(dificultad);
	}

	public Dificultad getDificultad() {
		return this.dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

}
