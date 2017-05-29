package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.*;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.HashSet;

import DIedrAl_Project.integracion.*;
import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class SAOrganizacionImpl implements SAOrganizacion {

	private Organizacion organizacion;

	private SimpleFileDAOFactory factoria;

	private static SAOrganizacionImpl instancia = null;

	public static SAOrganizacionImpl getInstancia() {

		if (instancia == null) {
			instancia = new SAOrganizacionImpl();
		}

		return instancia;
	}

	private SAOrganizacionImpl() {
		this.organizacion = Organizacion.getInstancia();
		factoria = SimpleFileDAOFactory.getInstance();
	}

	@Override
	public ArrayList<String> getCentros() throws ClassNotFoundException, IOException {
		DAOCentro daocen = factoria.getDAOCentro();
		HashSet<EstadoCentro> centros = daocen.listarCentros();

		ArrayList<String> centrosStrings = new ArrayList<String>();
		centros.forEach((centroTransfer) -> {
			centrosStrings.add(centroTransfer.getId());
		});

		return centrosStrings;
	}

	@Override
	public void addCentro(String name, String passAdmin)
			throws AlreadyBoundException, IOException, ClassNotFoundException {
		DAOCentro daocen = factoria.getDAOCentro();
		if (daocen.existeCentro(name))
			throw new AlreadyBoundException("El centro solicitado ya se encuentra registrado en el sistema");

		daocen.guardarCentro(new EstadoCentro(name));

		DAOUsuario daousu = factoria.getDAOUsuario();
		daousu.crearUsuario(new Usuario(name + "_ADMIN", "", "", name + "_ADMIN"));

	}

	@Override
	public void eliminarCentro(String name) throws NotBoundException, ClassNotFoundException, IOException {

		// Borrar del sistema todos aquellos usuarios cuyo centro sea el borrado
		DAOUsuario daousu = factoria.getDAOUsuario();
		HashSet<Usuario> usuarios = daousu.listarUsuarios();
		usuarios.forEach((user) -> {
			if (user.getCentro().equals(name))
				try {
					daousu.eliminarUsuario(user.getId());
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});

		// Borrar del sistema todos aquellos pacientes cuyo centro sea el
		// borrado
		DAOPaciente daopac = factoria.getDAOPaciente();
		HashSet<Paciente> pacientes = daopac.listarPacientes();
		pacientes.forEach((paciente) -> {
			if (paciente.getCentro().equals(name))
				try {
					daopac.eliminarPaciente(paciente.getId());
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});

		DAORelacionable daoter = factoria.getDAORelacion(tRelacion.usuario);
		daoter.eliminarRelacionesCentro(name);

		DAORelacionable daopaci = factoria.getDAORelacion(tRelacion.paciente);
		daopaci.eliminarRelacionesCentro(name);

		DAOCentro daocen = factoria.getDAOCentro();

		// Borrar el centro del sistema
		if (!daocen.existeCentro(name))
			throw new NotBoundException("El centro solicitado no se encuentra registrado en el sistema");

		daocen.eliminarCentro(name);

	}

	@Override
	public boolean existeCentro(String name) throws ClassNotFoundException, IOException {
		DAOCentro daocen = factoria.getDAOCentro();
		return daocen.existeCentro(name);
	}

	@Override
	public boolean inputPasswordGod(String pass) {
		return this.organizacion.inputPassword(pass);
	}

	@Override
	public String existeUsuario(String nif) throws ClassNotFoundException, IOException {
		DAOUsuario daousu = factoria.getDAOUsuario();
		return daousu.consultarUsuario(nif).getCentro();
	}

}
