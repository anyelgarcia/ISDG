package DIedrAl_Project.negocio.recursos;

public class Banco {
	private ArrayActividades arrayActividades;

	private ArraySesiones arraySesiones;

	private ArrayRecursos arrayRecursos;

	private long idSiguiente;

	private static Banco instancia = null;

	public static Banco getInstancia() {

		if (instancia == null)
			instancia = new Banco();
		
		return instancia;
	}

	private Banco() {

	}

	public void addRecurso(Recurso rec) {

	}

	public void removeRecurso(Recurso rec) {
	}

	public void addSesion(Sesion ses) {
	}

	public void removeSesion(Sesion ses) {
	}

	public void addActividad(Actividad act) {
	}

	public void removeActividad(Actividad act) {
	}

	public ArrayRecursos getArrayRecursos() {
		return arrayRecursos;
	}

	public void setArrayRecursos(ArrayRecursos value) {
		arrayRecursos = value;
	}

}
