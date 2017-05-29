package DIedrAl_Project.negocio.administracion;


public final class Organizacion {

	private static Organizacion instancia = null;

	private String password = "12345678";

	public static Organizacion getInstancia() {

		if (instancia == null)
			instancia = new Organizacion();

		return instancia;
	}

	protected Organizacion() {
		
	}


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


}
