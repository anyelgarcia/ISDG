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

	/*// APA�O PARA PODER TRABAJAR
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
	 * Dada una cadena de caracteres, comprueba si coincide con la contrase�a de
	 * la organizaci�n
	 * 
	 * @return true si la contrase�a suministrada coincide con la de la
	 *         organizaci�n
	 */
	public boolean inputPassword(String trial) {
		return password.equals(trial);
	}

	/**
	 * Cambia la contrase�a actual de la organizaci�n por la contrase�a proporcionada
	 * @param password nueva contrase�a
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
