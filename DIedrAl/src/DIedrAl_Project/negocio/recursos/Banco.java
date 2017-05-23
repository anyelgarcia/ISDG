package DIedrAl_Project.negocio.recursos;

public class Banco {
	private ArrayActividades actividades;

	private ArraySesiones sesiones;

	private ArrayRecursos recursos;

	private long idSiguiente;

	private static Banco instancia = null;

	public static Banco getInstancia() {

		if (instancia == null)
			instancia = new Banco();

		return instancia;
	}

	private Banco() {
		recursos = new ArrayRecursos();
		actividades = new ArrayActividades();
		sesiones = new ArraySesiones();
	}

	public ArrayActividades getActividades() {
		return actividades;
	}

	public void setActividades(ArrayActividades actividades) {
		this.actividades = actividades;
	}

	public ArraySesiones getSesiones() {
		return sesiones;
	}

	public void setSesiones(ArraySesiones sesiones) {
		this.sesiones = sesiones;
	}

	public void addRecurso(Recurso rec) {
		recursos.add(rec);
	}

	public void removeRecurso(Recurso rec) {
		recursos.erase(rec);
	}

	public void addSesion(Sesion ses) {
		sesiones.add(ses);
	}

	public void removeSesion(Sesion ses) {
		sesiones.erase(ses);
	}

	public void addActividad(Actividad act) {
		actividades.add(act);
	}

	public void removeActividad(Actividad act) {
		actividades.erase(act);
	}

	public ArrayRecursos getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayRecursos value) {
		recursos = value;
	}

}
