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


}
