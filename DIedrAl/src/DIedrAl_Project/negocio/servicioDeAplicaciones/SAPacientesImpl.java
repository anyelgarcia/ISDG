package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.rmi.*;
import java.util.*;

import DIedrAl_Project.integracion.BasicClasses.*;
import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.*;
import DIedrAl_Project.integracion.simplefileImp.*;
import DIedrAl_Project.integracion.SQL.*;
import DIedrAl_Project.negocio.Relacion;
import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.pacientes.*;

public class SAPacientesImpl implements SAPacientes {

	private Centro centro;
	private DAOPaciente daopac;
	private DAOUsuario daousu;
	private DAOCentro daocen;
	private DAORelacionable daorelPac;
	private DAORelacionable daorelUsu;

	public SAPacientesImpl(String nombreCentro) throws AccessException{
		DAOFactory factoria = SimpleFileDAOFactory.getInstance();
		daocen = factoria.getDAOCentro();
		daopac = factoria.getDAOPaciente();
		daousu = factoria.getDAOUsuario();
		daorelPac = factoria.getDAORelacion(tRelacion.paciente);
		daorelUsu = factoria.getDAORelacion(tRelacion.usuario);

		EstadoCentro centrotrans = daocen.consultarCentro(nombreCentro);
		CentroMaps mapeador = new CentroMaps();
		centro = mapeador.generarCentro(centrotrans);
		centro.setOrganizacion(Organizacion.getInstancia());
	}

	/**
	 * A�ade el paciente especificado al centro y actualiza la base de datos
	 * para incluir la nueva informaciÓn
	 * 
	 * @param pac
	 *            paciente a aÑadir al centro
	 * @throws AlreadyBoundException
	 *             , si el paciente ya estaba en el centro
	 */
	@Override
	public void addPaciente(Paciente pac) throws AlreadyBoundException, AccessException {
		
		/*
		 * Se intenta añadir el paciente. Si se puede, se crea una relacion con agente
		 * el nuevo paciente y con centro asociado el centro actual.
		 * Ademas, se guarda en la base de datos.
		 */
		if(!daopac.existePaciente(pac.getId())){
			pac.setCentro(centro.getNombre());
			centro.addPaciente(pac);
			daopac.crearPaciente(pac);
			daorelPac.crearRelacion(new Relacion(pac.getId(), centro.getNombre()));
		}
		else throw new AlreadyBoundException("El paciente ya se encuentra registrado");
	}

	/**
	 * Elimina el paciente especificado del centro y actualiza la base de datos
	 * correspondientemente
	 * 
	 * @param pac
	 *            paciente a eliminar del centro
	 * @throws NotBoundException,
	 *             si el paciente no se encuentra en el centro
	 * @throws AccessException 
	 */
	@Override
	public void erasePaciente(Paciente pac) throws NotBoundException, AccessException {

		//Se intenta borrar el paciente del centro.
		centro.erasePaciente(pac);
		//Si se ha conseguido, cargamos las relaciones asociadas a pacientes del centro
		//cuestion.
		Set<Relacion> setrel = daorelPac.listarRelaciones(centro.getNombre());
		Relacion aEliminar = null;
		for (Relacion r : setrel) {
			//Si el paciente es el agente de la relacion, la marcamos para eliminarla luego
			if (r.getIdAgente() == pac.getId()) {
				aEliminar = r;
			} 
			// Si el paciente esta en alguna relacion con otro paciente, lo eliminamos del los
			// relacionados.
			
			//NOTA: ESTO NO DEBERIA ACTIVARSE NUNCA
			else if (r.getRelacionados().contains(pac.getId())) {
				r.getRelacionados().remove(pac.getId());
				daorelPac.modificarRelacion(r);
			}
		}
		//Si se ha conseguido, cargamos las relaciones asociadas a usuarios del centro
		//cuestion.
		setrel = daorelUsu.listarRelaciones(centro.getNombre());
		for (Relacion r : setrel) {
			// Si el paciente esta en alguna relacion con un usuario, lo eliminamos del los
			// relacionados.
			if (r.getRelacionados().contains(pac.getId())) {
				r.getRelacionados().remove(pac.getId());
				daorelUsu.modificarRelacion(r);
			}
		}
		//Luego, la relacion a eliminar, en la que es agente, la eliminamos.
		if (aEliminar != null) {
			daorelPac.eliminarRelacion(aEliminar.getId());
		}
		//Y eliminamos el paciente
		if (daopac.existePaciente(pac.getId())) {
			daopac.eliminarPaciente(pac.getId());
		} else
			//No debería entrar por aquí en estos momentos de la película.
			throw new NotBoundException(pac + "no se encuentra registrado en la base de datos");
	}

	/**
	 * AÃ±ade el usuario especificado al centro y actualiza la base de datos para
	 * incluir la nueva informaci�n
	 * 
	 * @param usu
	 *            usuario a a�adir al centro
	 * @throws AlreadyBoundException
	 *             , si el usuario ya estaba en el centro
	 */
	@Override
	public void addUsuario(Usuario usu) throws AlreadyBoundException, AccessException {
		
		/*
		 * Se intenta añadir el usuario. Si se puede, se crea una relacion con agente
		 * el nuevo usuario y con centro asociado el centro actual.
		 * Ademas, se guarda en la base de datos.
		 */
		if(!daousu.existeUsuario(usu.getId())){
			usu.setCentro(centro.getNombre());
			centro.addUsuario(usu);
			daousu.crearUsuario(usu);
			daorelUsu.crearRelacion(new Relacion(usu.getId(), centro.getNombre()));
		}
		else throw new AlreadyBoundException("El usuario ya se encuentra registrado");

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
	public void eraseUsuario(Usuario usu) throws NotBoundException, AccessException {

		//Se intenta borrar el usuario del centro.
		centro.eraseUsuario(usu);
		//Si se ha conseguido, cargamos las relaciones asociadas a pacientes del centro
		//cuestion.
		Set<Relacion> setrel = daorelPac.listarRelaciones(centro.getNombre());
		Relacion aEliminar = null;
		for (Relacion r : setrel) {
			// Si el paciente esta en alguna relacion con un usuario, lo eliminamos del los
			// relacionados.
			if (r.getRelacionados().contains(usu.getId())) {
				r.getRelacionados().remove(usu.getId());
				daorelPac.modificarRelacion(r);
			}
		}
		
		//Si se ha conseguido, cargamos las relaciones asociadas a usuarios del centro
		//cuestion.
		setrel = daorelUsu.listarRelaciones(centro.getNombre());
		for (Relacion r : setrel) {
			//Si el usuario es el agente de la relacion, la marcamos para eliminarla luego
			if (r.getIdAgente() == usu.getId()) {
				aEliminar = r;
			} 
			// Si el usuario esta en alguna relacion con otro usuario, lo eliminamos del los
			// relacionados.
			
			//NOTA: ESTO NO DEBER�A ACTIVARSE NUNCA
			else if (r.getRelacionados().contains(usu.getId())) {
				r.getRelacionados().remove(usu.getId());
				daorelUsu.modificarRelacion(r);
			}
		}
		//Luego, la relacion a eliminar, en la que es agente, la eliminamos.
		if (aEliminar != null) {
			daorelUsu.eliminarRelacion(aEliminar.getId());
		}
		//Y eliminamos el usuario
		if (daousu.existeUsuario(usu.getId())) {
			daousu.eliminarUsuario(usu.getId());
		} else
			//No deber�a entrar por aqu� en estos momentos de la pel�cula.
			throw new NotBoundException(usu + "no se encuentra registrado en la base de datos");
	}

	@Override
	public void ligarPaciente(Paciente pac, Usuario usu)
			throws NotBoundException, AlreadyBoundException, AccessException {
		//Ligamos en el centro el paciente y el usuario.
		centro.ligarPaciente(pac, usu);
		//Cargamos la lista de relaciones de usuarios del centro
		Set<Relacion> setrel = daorelUsu.listarRelaciones(centro.getNombre());
		Relacion usuToPac = null;
		for (Relacion r : setrel) {
			//Si hay una relacion en la que el usuario sea el agente, la guardamos
			if (r.getIdAgente().equals(usu.getId())) {
				usuToPac = r;
				break;
			}
		}
		//Si no hay relacion en la que el usuario sea el agente, la creamos.
		if (usuToPac == null) {
			usuToPac = new Relacion(usu.getId(), centro.getNombre());
			daorelUsu.crearRelacion(usuToPac);
		}
		//Añadimos el nuevo relacionado.
		usuToPac.getRelacionados().add(pac.getId());
		daorelUsu.modificarRelacion(usuToPac);
		//Hacemos lo mismo con el otro sentido de la relacion.
		setrel = daorelPac.listarRelaciones(centro.getNombre());
		Relacion pacToUsu = null;
		for (Relacion r : setrel) {
			if (r.getIdAgente().equals(pac.getId())) {
				pacToUsu = r;
				break;
			}
		}
		if (pacToUsu == null) {
			pacToUsu = new Relacion(pac.getId(), centro.getNombre());
			daorelPac.crearRelacion(pacToUsu);
		}
		pacToUsu.getRelacionados().add(usu.getId());
		daorelPac.modificarRelacion(pacToUsu);

	}

	@Override
	public void desligarPaciente(Paciente pac, Usuario usu)
			throws NotBoundException, AlreadyBoundException, AccessException {
		centro.desligarPaciente(pac, usu);
		//Cargamos el conjunto de relaciones de pacientes del centro
		Set<Relacion> setrel = daorelPac.listarRelaciones(centro.getNombre());

		for (Relacion r : setrel) {
			//Si en alguno es el agente de la relaci�n, eliminamos de relacionado el
			//usuario
			if (r.getIdAgente().equals(pac.getId())) {
				r.getRelacionados().remove(usu.getId());
				daorelPac.modificarRelacion(r);
				break;
			}
		}
		//Hacemos lo mismo pero con usuarios.
		setrel = daorelUsu.listarRelaciones(centro.getNombre());
		for (Relacion r : setrel) {
			if (r.getIdAgente().equals(usu.getId())) {
				r.getRelacionados().remove(pac.getId());
				daorelUsu.modificarRelacion(r);
				break;
			}
		}
	}

	@Override
	public Set<Paciente> getPacientesAsociados(Usuario usu) throws NotBoundException {
		return centro.getPacientesAsociados(usu);
	}

	@Override
	public Set<Usuario> getUsuariosAsociados(Paciente pac) throws NotBoundException {
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
	public Set<Persona> filtrarPersonas(Hints[] hints, String[] values, Hints[] tipos) {
		return centro.getPersonas(hints, values, tipos);
	}

	@Override
	public void updateUsuario(Usuario usu) throws AccessException {
		this.daousu.modificarUsuario(usu);
	}

	@Override
	public void updatePaciente(Paciente pac) throws AccessException {
		this.daopac.modificarPaciente(pac);
		
	}

}
