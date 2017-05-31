package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.administracion.Usuario;

public interface SAOrganizacion {
	/**
	 * Devuelve los nombres de los centros asociados a la organizaciñn
	 * 
	 * @return arrayList que contiene los nombres solicitados
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws AccessException 
	 */
	public ArrayList<String> getCentros() throws AccessException;

	/**
	 * Añade a la organización un centro con el nombre name, y genera un usuario
	 * administrador contraseña dada (el nif y nombre del admin son nombre del
	 * centro + "_ADMIN"; no tiene apellidos)
	 * 
	 * @param name
	 *            nombre del nuevo centro
	 * @param passAdmin
	 *            contraseña del administrador
	 * @throws AlreadyBoundException
	 *             , si ya había un centro con ese nombre
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void addCentro(String name, String passAdmin)
			throws AlreadyBoundException, AccessException;

	/**
	 * Dado un nombre de centro, lo borra del sistema
	 * 
	 * @param name
	 *            nombre del centro aborrar
	 * @throws NotBoundException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void eliminarCentro(String name) throws NotBoundException, AccessException;

	/**
	 * Comprueba si existe un centro con el nombre dado en el sistema
	 * 
	 * @param name
	 *            nombre del centro a buscar
	 * @return true si existe, false en caso contrario
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean existeCentro(String name) throws AccessException;

	/**
	 * Comprueba si el string dado coincide con la contraseña de administrador
	 * de la aplicación
	 * 
	 * @param pass
	 *            string a comprobar
	 * @return true si coincide
	 */
	public boolean inputPasswordGod(String pass);

	/**
	 * Devuelve un usuario con el nif dado en el sistema
	 * 
	 * @param nif
	 *            nif a buscar
	 * @return el usuario con el nif
	 */
	public Usuario getUsuario(String nif) throws AccessException, NotBoundException;
}
