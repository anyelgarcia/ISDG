package DIedrAl_Project.negocio.administracion;


public final class Organizacion {

	private static Organizacion instancia = null;

	private String password;

	//private final Map<String, Centro> centros;

	public static Organizacion getInstancia() {

		if (instancia == null)
			instancia = new Organizacion();

		return instancia;
	}

	protected Organizacion() {
	//	centros = new HashMap<String, Centro>();

	}

	/*// APAÑO PARA PODER TRABAJAR
	public Centro getCentro(String name) throws NotBoundException {
		if (!centros.containsKey(name)) {
			throw new NotBoundException("Centro ya introducido");
		} else
			return centros.get(name);

	}

	public void addCentro(String name) throws AlreadyBoundException {
		if (centros.containsKey(name)) {
			throw new AlreadyBoundException("Centro ya introducido");
		} else {
			centros.put(name, new Centro(name));
		}
	}

	public void removeCentro(String name) throws NotBoundException {
		if (!centros.containsKey(name)) {
			throw new NotBoundException("Centro ya introducido");
		} else {
			centros.remove(name);
		}
	}*/

	/**
	 * Dada una cadena de caracteres, comprueba si coincide con la contraseña de
	 * la organización
	 * 
	 * @return true si la contraseña suministrada coincide con la de la
	 *         organización
	 */
	public boolean inputPassword(String trial) {
		return password.equals(trial);
	}

	/**
	 * Cambia la contraseña actual de la organización por la contraseña proporcionada
	 * @param password nueva contraseña
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
