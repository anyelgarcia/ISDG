package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

public interface SAOrganizacion {
	/**
	 * Devuelve los nombres de los centros asociados a la organizaci�n
	 * 
	 * @return arrayList que contiene los nombres solicitados
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<String> getCentros() throws ClassNotFoundException, IOException;

	/**
	 * A�ade a la organizaci�n un centro con el nombre name, y genera un usuario
	 * administrador contrase�a dada (el nif y nombre del admin son nombre del
	 * centro + "_ADMIN"; no tiene apellidos)
	 * 
	 * @param name
	 *            nombre del nuevo centro
	 * @param passAdmin
	 *            contrase�a del administrador
	 * @throws AlreadyBoundException
	 *             , si ya hab�a un centro con ese nombre
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void addCentro(String name, String passAdmin)
			throws AlreadyBoundException, ClassNotFoundException, IOException;

	/**
	 * Dado un nombre de centro, lo borra del sistema
	 * 
	 * @param name
	 *            nombre del centro aborrar
	 * @throws NotBoundException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void eliminarCentro(String name) throws NotBoundException, ClassNotFoundException, IOException;

	/**
	 * Comprueba si existe un centro con el nombre dado en el sistema
	 * 
	 * @param name
	 *            nombre del centro a buscar
	 * @return true si existe, false en caso contrario
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean existeCentro(String name) throws ClassNotFoundException, IOException;

	/**
	 * Comprueba si el string dado coincide con la contrase�a de administrador
	 * de la aplicaci�n
	 * 
	 * @param pass
	 *            string a comprobar
	 * @return true si coincide
	 */
	public boolean inputPasswordGod(String pass);

	/**
	 * Comprueba si existe un usuario con el nif dado en el sistema
	 * 
	 * @param nif
	 *            nif a buscar
	 * @return true si existe, false en caso contrario
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean existeUsuario(String nif) throws ClassNotFoundException, IOException;
}
