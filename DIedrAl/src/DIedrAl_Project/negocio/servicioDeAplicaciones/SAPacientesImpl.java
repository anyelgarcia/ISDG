package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import DIedrAl_Project.integracion.DAOPaciente;
import DIedrAl_Project.integracion.DAORelacionable;
import DIedrAl_Project.integracion.DAOUsuario;
import DIedrAl_Project.integracion.SimpleFileDAOFactory;
import DIedrAl_Project.negocio.Relacion;
import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.pacientes.*;

public class SAPacientesImpl implements SAPacientes {

	private Centro centro;
	private SimpleFileDAOFactory factoria;

	public SAPacientesImpl(Centro centro) {
		this.centro = centro;
		factoria = SimpleFileDAOFactory.getInstance();
	}

	/**
	 * Añade el paciente especificado al centro y actualiza la base de datos
	 * para incluir la nueva información
	 * 
	 * @param pac
	 *            paciente a añadir al centro
	 * @throws AlreadyBoundException
	 *             , si el paciente ya estaba en el centro
	 */
	@Override
	public void addPaciente(Paciente pac) throws AlreadyBoundException,
			IOException {

		centro.addPaciente(pac);

		String fichPac = centro.comoAlmacenable().getFilePacientes();
		DAORelacionable daorel = factoria.getDAORelacion(fichPac);
		daorel.crearRelacion(new Relacion(pac.getId()));

		DAOPaciente daopac = factoria.getDAOPaciente();
		daopac.crearPaciente(pac);

	}

	/**
	 * Elimina el paciente especificado del centro y actualiza la base de datos
	 * correspondientemente
	 * 
	 * @param pac
	 *            paciente a eliminar del centro
	 * @throws NotBoundException
	 *             , si el paciente no se encuentra en el centro
	 */
	@Override
	public void erasePaciente(Paciente pac) throws NotBoundException,
			ClassNotFoundException, IOException {

		// Borrar el paciente del centro con todas sus relaciones a terapueutas
		// y usuarios
		centro.erasePaciente(pac);

		// Obtener el nombre del fichero en el que se guardan las relaciones de
		// los pacientes del centro con sus usuarios asociados
		String fichPac = centro.comoAlmacenable().getFilePacientes();

		// Obtener el dao de relación para modificar las relaciones en archivo
		DAORelacionable daorel = factoria.getDAORelacion(fichPac);

		// eliminar todas las relaciones del paciente en el archivo anterior
		daorel.eliminarRelacion(pac.getId());

		// Obtener el nombre del fichero en el que se guardan las relaciones de
		// los usuarios del centro con sus pacientes asociados
		String fichUsu = centro.comoAlmacenable().getFileUsuarios();

		DAORelacionable daorel2 = factoria.getDAORelacion(fichUsu);

		// recorrer los usuarios asociados al paciente eliminando en archivo las
		// relaciones con dichgo paciente
		HashSet<Relacion> listadoRelaciones = daorel2.listarRelaciones();
		listadoRelaciones.forEach((relacion) -> {
			ArrayList<String> relacionados = relacion.getRelacionados();
			relacionados.removeIf((aux) -> {
				return aux.equals(pac.getId());
			});

			// Modifica la relación en archivo
				try {
					daorel2.modificarRelacion(relacion);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

		DAOPaciente daopac = factoria.getDAOPaciente();
		if (daopac.existePaciente(pac.getId())) {
			daopac.eliminarPaciente(pac.getId());
		} else
			throw new NotBoundException(pac
					+ "no se encuentra registrado en la base de datos");
	}

	/**
	 * Añade el usuario especificado al centro y actualiza la base de datos para
	 * incluir la nueva información
	 * 
	 * @param usu
	 *            usuario a añadir al centro
	 * @throws AlreadyBoundException
	 *             , si el usuario ya estaba en el centro
	 */
	@Override
	public void addUsuario(Usuario usu) throws AlreadyBoundException,
			ClassNotFoundException, IOException {

		centro.addUsuario(usu);

		String fichUsu = centro.comoAlmacenable().getFileUsuarios();
		DAORelacionable daorel = factoria.getDAORelacion(fichUsu);
		daorel.crearRelacion(new Relacion(usu.getId()));

		DAOUsuario daousu = factoria.getDAOUsuario();
		daousu.crearUsuario(usu);
	}

	/**
	 * Elimina el usuario especificado del centro y actualiza la base de datos
	 * correspondientemente
	 * 
	 * @param usu
	 *            usuario a eliminar del centro
	 * @throws NotBoundException
	 *             , si el usuario no se encuentra en el centro
	 */
	@Override
	public void eraseUsuario(Usuario usu) throws NotBoundException,
			ClassNotFoundException, IOException {

		// Borrar el usuario del centro con todas sus relaciones a pacientes
		centro.eraseUsuario(usu);

		// Obtener el nombre del fichero en el que se guardan las relaciones de
		// los usuarios del centro con sus pacientes asociados
		String fichUsu = centro.comoAlmacenable().getFileUsuarios();

		// Obtener el dao de relación para modificar las relaciones en archivo
		DAORelacionable daorel = factoria.getDAORelacion(fichUsu);

		// eliminar todas las relaciones del usuario en el archivo anterior
		daorel.eliminarRelacion(usu.getId());

		// Obtener el nombre del fichero en el que se guardan las relaciones de
		// los pacientes del centro con sus pacientes asociados
		String fichPac = centro.comoAlmacenable().getFilePacientes();

		DAORelacionable daorel2 = factoria.getDAORelacion(fichUsu);

		// recorrer los pacientes asociados al usuario eliminando en archivo las
		// relaciones con dicho usuario
		HashSet<Relacion> listadoRelaciones = daorel2.listarRelaciones();
		listadoRelaciones.forEach((relacion) -> {
			ArrayList<String> relacionados = relacion.getRelacionados();
			relacionados.removeIf((aux) -> {
				return aux.equals(usu.getId());
			});

			// Modifica la relación en archivo
				try {
					daorel2.modificarRelacion(relacion);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

		DAOUsuario daousu = factoria.getDAOUsuario();
		if (daousu.existeUsuario(usu.getId())) {
			daousu.eliminarUsuario(usu.getId());
		} else
			throw new NotBoundException(usu
					+ "no se encuentra registrado en la base de datos");
	}

	@Override
	public void ligarPaciente(Paciente pac, Usuario usu)
			throws NotBoundException, AlreadyBoundException, IOException,
			ClassNotFoundException {
		centro.ligarPaciente(pac, usu);

		DAORelacionable daorel = factoria.getDAORelacion(centro
				.comoAlmacenable().getFilePacientes());

		DAORelacionable daorel2 = factoria.getDAORelacion(centro
				.comoAlmacenable().getFileUsuarios());

		// Relacionar en archivo paciente con usuario
		Relacion relPacUsu = new Relacion(pac.getId());
		relPacUsu.getRelacionados().add(usu.getId());
		daorel.modificarRelacion(relPacUsu);

		// Relacionar en archivo usuario con paciente
		Relacion relUsuPac = new Relacion(usu.getId());
		relUsuPac.getRelacionados().add(pac.getId());
		daorel.modificarRelacion(relUsuPac);
	}

	@Override
	public void desligarPaciente(Paciente pac, Usuario usu)
			throws NotBoundException, AlreadyBoundException,
			ClassNotFoundException, IOException {
		centro.desligarPaciente(pac, usu);

		DAORelacionable daorel = factoria.getDAORelacion(centro
				.comoAlmacenable().getFilePacientes());

		DAORelacionable daorel2 = factoria.getDAORelacion(centro
				.comoAlmacenable().getFileUsuarios());

		// Obtener conjunto de relaciones de pacientes con usuarios
		HashSet<Relacion> PacUsu = daorel.listarRelaciones();

		// Recorrer el conjunto buscando la relación que parte de pac y contiene a usu
		Iterator<Relacion> it = PacUsu.iterator();
		boolean found = false;
		Relacion buscada = null;
		
		while(!found && it.hasNext()){
			buscada = it.next();
			found = buscada.getId().equals(pac.getId());
		}
		
		// al encontrarla, borra al usuario de los asociados al paciente
		if(found){
			buscada.getRelacionados().remove(usu);
			daorel.modificarRelacion(buscada);
		}
		
		// Obtener conjunto de relaciones de usuarios con pacientes
		HashSet<Relacion> UsuPac = daorel2.listarRelaciones();

		// Recorrer el conjunto buscando la relación que parte de usu y contiene a pac
		Iterator<Relacion> it2 = UsuPac.iterator();
		boolean found2 = false;
		Relacion buscada2 = null;
		
		while(!found2 && it2.hasNext()){
			buscada2 = it2.next();
			found2 = buscada2.getId().equals(usu.getId());
		}
		
		// al encontrarla, borra al paciente de los asociados al usuario
		if(found2){
			buscada2.getRelacionados().remove(pac);
			daorel2.modificarRelacion(buscada2);
		}
	}

	@Override
	public Set<Paciente> getPacientesAsociados(Usuario usu)
			throws NotBoundException {
		return centro.getPacientesAsociados(usu);
	}

	@Override
	public Set<Usuario> getUsuariosAsociados(Paciente pac)
			throws NotBoundException {
		return centro.getUsuariosAsociados(pac);
	}

	@Override
	public Paciente getPacienteConNIF(String nif) throws NotBoundException {
		return centro.getPacienteConNIF(nif);
	}

	@Override
	public Usuario getUsuarioConNIF(String nif) throws NotBoundException {
		return centro.getUsuarioConNIF(nif);
	}

	@Override
	public Set<Persona> filtrarPersonas(Hints[] hints, String[] values,
			Hints[] tipos) {
		return centro.getPersonas(hints, values, tipos);
	}

}
