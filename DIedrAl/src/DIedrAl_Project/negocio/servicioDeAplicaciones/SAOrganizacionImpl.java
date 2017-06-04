package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.*;
import DIedrAl_Project.integracion.DAOinterfaces.*;
import DIedrAl_Project.integracion.SQL.SQLDAOFactory;
import DIedrAl_Project.integracion.simplefileImp.*;
import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class SAOrganizacionImpl implements SAOrganizacion {

	private Organizacion organizacion;
	
	private DAOUsuario daousu;

	private SQLDAOFactory factoria;

	private static SAOrganizacionImpl instancia = null;

	public static SAOrganizacionImpl getInstancia() {

		if (instancia == null) {
			instancia = new SAOrganizacionImpl();
		}

		return instancia;
	}

	private SAOrganizacionImpl() {
		this.organizacion = Organizacion.getInstancia();
		try {
			factoria = SQLDAOFactory.getInstance();
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daousu=factoria.getDAOUsuario();
	}

	@Override
	public ArrayList<String> getCentros() throws AccessException {
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
			throws AlreadyBoundException, AccessException{
		
		DAOCentro daocen = factoria.getDAOCentro();
		if (daocen.existeCentro(name)){
			throw new AlreadyBoundException(
					"El centro solicitado ya se encuentra registrado en el sistema");
		}
		
		EstadoCentro centrotrans = new EstadoCentro(name);
		daocen.guardarCentro(centrotrans);

		Usuario u = new Usuario(name + "_ADMIN", "", "", name
				+ "_ADMIN");
		u.setCentro(name);
		u.setPassword(passAdmin);
		u.setAdmin();
		
		SAPacientes sap = SAFactory.getInstancia().newSAPacientes(name);
		sap.addUsuario(u);
		
		
	}

	@Override
	public void eliminarCentro(String name) throws NotBoundException,
			AccessException {

		// Borrar del sistema todos aquellos usuarios cuyo centro sea el borrado
		HashSet<Usuario> usuarios = daousu.listarUsuarios();
		for (Usuario user : usuarios) {
			if (user.getCentro().equals(name)) {
				try {
					daousu.eliminarUsuario(user.getId());
				} catch (AccessException e) {
					throw new AccessException(e.getMessage()
							+ "\nProblema en el daoUsuario");
				}

			}
		}

		// Borrar del sistema todos aquellos pacientes cuyo centro sea el
		// borrado
		DAOPaciente daopac = factoria.getDAOPaciente();
		HashSet<Paciente> pacientes = daopac.listarPacientes();
		for (Paciente paciente : pacientes) {
			if (paciente.getCentro().equals(name)) {
				try {
					daopac.eliminarPaciente(paciente.getId());
				} catch (AccessException e) {
					throw new AccessException(e.getMessage()
							+ "\nProblema en el daoPaciente");
				}
			}

		}

		DAORelacionable daoter = factoria.getDAORelacion(tRelacion.usuario);
		daoter.eliminarRelacionesCentro(name);

		DAORelacionable daopaci = factoria.getDAORelacion(tRelacion.paciente);
		daopaci.eliminarRelacionesCentro(name);

		DAOCentro daocen = factoria.getDAOCentro();

		// Borrar el centro del sistema
		if (!daocen.existeCentro(name))
			throw new NotBoundException(
					"El centro solicitado no se encuentra registrado en el sistema");

		daocen.eliminarCentro(name);

	}

	@Override
	public boolean existeCentro(String name) throws AccessException {
		DAOCentro daocen = factoria.getDAOCentro();
		return daocen.existeCentro(name);
	}

	@Override
	public boolean inputPasswordGod(String pass) {
		return this.organizacion.inputPassword(pass);
	}

	@Override
	public Usuario getUsuario(String nif) throws AccessException, NotBoundException {
		Usuario usu = daousu.consultarUsuario(nif);
		if(usu==null){
			throw new NotBoundException("Usuario no encontrado");
		}
		return usu;
	}

}
