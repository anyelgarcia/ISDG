package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.File;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.HashSet;

import DIedrAl_Project.integracion.DAOCentro;
import DIedrAl_Project.integracion.DAOPaciente;
import DIedrAl_Project.integracion.DAORelacionable;
import DIedrAl_Project.integracion.DAOUsuario;
import DIedrAl_Project.integracion.SimpleFileDAOFactory;
import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.CentroAlmacenable;
import DIedrAl_Project.negocio.administracion.Organizacion;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class SAOrganizacionImpl implements SAOrganizacion {

	private Organizacion organizacion;
	private SimpleFileDAOFactory factoria;

	public SAOrganizacionImpl(Organizacion org) {
		this.organizacion = org;
		factoria = SimpleFileDAOFactory.getInstance();
	}

	@Override
	public ArrayList<String> getCentros() throws ClassNotFoundException, IOException {
		DAOCentro daocen = factoria.getDAOCentro();
		HashSet<CentroAlmacenable> centros = daocen.listarCentros();

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

		daocen.guardarCentro(new CentroAlmacenable(name));

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

		// Eliminar del sistema los ficheros de relaciones del centro borrado
		DAOCentro daocen = factoria.getDAOCentro();
		CentroAlmacenable centro = daocen.consultarCentro(name);
		
		File fichRelPac = new File(centro.getFilePacientes());
		File fichRelUsu = new File(centro.getFileUsuarios());
		
		fichRelPac.delete();
		fichRelUsu.delete();
		

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
	public boolean existeUsuario(String nif) throws ClassNotFoundException, IOException {
		DAOUsuario daousu = factoria.getDAOUsuario();
		return daousu.existeUsuario(nif);
	}

}
