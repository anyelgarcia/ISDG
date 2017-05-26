package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

public interface SAOrganizacion {
	/**
	 * Devuelve los nombres de los centros asociados a la organización
	 * 
	 * @return arrayList que contiene los nombres solicitados
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<String> getCentros() throws ClassNotFoundException, IOException;

	/**
	 * Añade a la organización un centro con el nombre name, y genera un usuario
	 * administrador de nif y contraseña dados
	 * 
	 * @param name
	 *            nombre del nuevo centro
	 * @param idAdmin
	 *            nif del usuario administrador del nuevo centro
	 * @param passAdmin
	 *            contraseña del administrador
	 * @throws AlreadyBoundException
	 *             , si ya había un centro con ese nombre
	 */
	public void addCentro(String name, String idAdmin, String passAdmin)
			throws AlreadyBoundException;

	/**
	 * Dado un nombre de centro, lo borra del sistema
	 * 
	 * @param name
	 *            nombre del centro aborrar
	 * @throws NotBoundException
	 */
	public void eliminarCentro(String name) throws NotBoundException;

	/**
	 * Comprueba si existe un centro con el nombre dado en el sistema
	 * 
	 * @param name
	 *            nombre del centro a buscar
	 * @return true si existe, false en caso contrario
	 */
	public boolean existeCentro(String name);

	/**
	 * Comprueba si el string dado coincide con la contraseña de administrador
	 * de la aplicación
	 * 
	 * @param pass string a comprobar
	 * @return true si coincide
	 */
	public boolean inputPasswordGod(String pass);

	/**
	 * Comprueba si existe un usuario con el nif dado en el sistema
	 * @param nif nif a buscar
	 * @return true si existe, false en caso contrario
	 */
	public boolean existeUsuario(String nif);
}
