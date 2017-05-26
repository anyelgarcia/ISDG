package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;
import java.rmi.*;
import java.util.Set;

import DIedrAl_Project.integracion.DAOPaciente;
import DIedrAl_Project.integracion.DAOUsuario;
import DIedrAl_Project.integracion.SimpleFileDAOFactory;
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

		centro.erasePaciente(pac);

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
		centro.eraseUsuario(usu);

		DAOUsuario daousu = factoria.getDAOUsuario();
		if (daousu.existeUsuario(usu.getId())) {
			daousu.eliminarUsuario(usu.getId());
		} else
			throw new NotBoundException(usu
					+ "no se encuentra registrado en la base de datos");
	}

	@Override
	public void ligarPaciente(Paciente pac, Usuario usu)
			throws NotBoundException, AlreadyBoundException {
		centro.ligarPaciente(pac, usu);
	}

	@Override
	public void desligarPaciente(Paciente pac, Usuario usu)
			throws NotBoundException, AlreadyBoundException {
		centro.desligarPaciente(pac, usu);
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
