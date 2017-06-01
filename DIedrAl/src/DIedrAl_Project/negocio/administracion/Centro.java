package DIedrAl_Project.negocio.administracion;

import java.rmi.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import DIedrAl_Project.negocio.calendario.Calendario;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class Centro {

	private EstadoCentro estado;
	// TODO: implementarlo primero
	private Calendario calendario;

	/**
	 * Diccionario que permite el acceso a un terapeuta o paciente del centro a
	 * trav�s de su dni.
	 */
	private HashMap<String, Persona> personasCentro;

	/**
	 * Pacientes del centro almacenados con un conjunto de usuarios asociados.
	 */
	private HashMap<Paciente, HashSet<Usuario>> pacientes;

	/**
	 * Terapeutas y usuarios del centro almacenados con sus pacientes asociados.
	 */
	private HashMap<Usuario, HashSet<Paciente>> usuarios;

	// TODO: implementarlo primero
	private Organizacion organizacion;

	/*
	 * protected Centro(String name) { nombre = name; pacientes = new
	 * HashMap<Paciente, Set<Usuario>>(); usuarios = new HashMap<Usuario,
	 * Set<Paciente>>(); personasCentro = new HashMap<String, Persona>();
	 * 
	 * }
	 */

	protected Centro(EstadoCentro c,
			HashMap<Paciente, HashSet<Usuario>> pacientes,
			HashMap<Usuario, HashSet<Paciente>> usuarios,
			HashMap<String, Persona> personas) {
		this.estado = c;
		this.pacientes = pacientes;
		this.usuarios = usuarios;
		this.personasCentro = personas;
	}

	public void addUsuario(Usuario usu) throws AlreadyBoundException {
		if (!usuarios.containsKey(usu)) {
			usuarios.put(usu, new HashSet<Paciente>());
			personasCentro.put(usu.getId(), usu);
		} else {
			throw new AlreadyBoundException(usu + " ya registrado");
		}
	}

	public void addPaciente(Paciente pac) throws AlreadyBoundException {
		if (!pacientes.containsKey(pac)) {
			pacientes.put(pac, new HashSet<Usuario>());
			personasCentro.put(pac.getId(), pac);
		} else {
			throw new AlreadyBoundException(pac + " ya registrado");
		}
	}

	public void eraseUsuario(Usuario usu) throws NotBoundException {

		if (usuarios.containsKey(usu)) {
			usuarios.remove(usu);
			// Suponemos coherencia de datos.
			personasCentro.remove(usu.getNif());
			// Borrar el usuario de todos los pacientes que lo tuvieran
			// asociado.
			pacientes.forEach((pac, set) -> {
				set.remove(usu);
			});
		} else {
			throw new NotBoundException(usu + " no registrado");
		}
	}

	@SuppressWarnings("unchecked")
	public void erasePaciente(Paciente pac) throws NotBoundException {

		if (pacientes.containsKey(pac)) {
			pacientes.remove(pac);
			// Suponemos coherencia de datos.
			personasCentro.remove(pac.getNif());
			// Borrar el paciente de todos los usuarios que lo tuvieran
			// asociado.
			usuarios.forEach((usu, set) -> {

				set.remove(pac);
			});
		} else {
			throw new NotBoundException("Paciente " + pac + " no encontrado");
		}
	}

	public void ligarPaciente(Paciente pac, Usuario usu)
			throws NotBoundException, AlreadyBoundException {
		
		if (!personasCentro.containsKey(usu.getNif())) {
			throw new NotBoundException("Usuario " + usu + " no encontrado");
		} else if (!personasCentro.containsKey(pac.getNif())) {
			throw new NotBoundException("Paciente " + pac + " no encontrado");
		} 
		else { 
			usu = (Usuario) personasCentro.get(usu.getNif());
			pac = (Paciente) personasCentro.get(pac.getNif());
			if (usuarios.get(usu).contains(pac)) {
				throw new AlreadyBoundException("Paciente ya ligado");
			} else {
				usuarios.get(usu).add(pac);
				pacientes.get(pac).add(usu);
			}
		}
	}

	public void desligarPaciente(Paciente pac, Usuario usu)
			throws NotBoundException, AlreadyBoundException {
		if (!personasCentro.containsKey(usu.getNif())) {
			throw new NotBoundException("Usuario " + usu + " no encontrado");
		} else if (!personasCentro.containsKey(pac.getNif())) {
			throw new NotBoundException("Paciente " + pac + " no encontrado");
		} else{ 
			usu = (Usuario) personasCentro.get(usu.getNif());
			pac = (Paciente) personasCentro.get(pac.getNif());
			if (!usuarios.get(usu).contains(pac)) {
				throw new AlreadyBoundException("Paciente no ligado");
			} else {
				usuarios.get(usu).remove(pac);
				pacientes.get(pac).remove(usu);
			}
		}
	}

	public Set<Paciente> getPacientesAsociados(Usuario usu)
			throws NotBoundException {
		if (!personasCentro.containsKey(usu.getNif())) {
			throw new NotBoundException("Usuario " + usu + " no encontrado");
		} else
			return usuarios.get(usu);
	}

	public String getNombre() {
		return estado.getId();
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

	public HashMap<Paciente, HashSet<Usuario>> getPacientes() {
		return pacientes;
	}

	public HashMap<Usuario, HashSet<Paciente>> getUsuarios() {
		return usuarios;
	}

	/**
	 * Devuelve el paciente con id NIF del mapa de pacientes del centro
	 * 
	 * @param NIF
	 *            NIF buscado
	 * @return Paciente con dicho NIF; null si no se encuentra ningún paciente.
	 * @throws NotBoundException
	 */
	public Paciente getPacienteConNIF(String NIF) throws NotBoundException {
		if (!personasCentro.containsKey(NIF)) {
			throw new NotBoundException("Paciente no encontrado");
		} else if (!(personasCentro.get(NIF) instanceof Paciente)) {
			throw new NotBoundException("Paciente no encontrado");
		} else {
			return (Paciente) personasCentro.get(NIF);
		}
	}

	/**
	 * Devuelve el usuario con id NIF del mapa de usuarios del centro
	 * 
	 * @param NIF
	 *            NIF buscado
	 * @return Usuario con dicho NIF; null si no se encuentra ninguno.
	 * @throws NotBoundException
	 */
	public Usuario getUsuarioConNIF(String NIF) throws NotBoundException {
		if (!personasCentro.containsKey(NIF)) {
			throw new NotBoundException("Usuario no encontrado");
		} else if (!(personasCentro.get(NIF) instanceof Usuario)) {
			throw new NotBoundException("Usuario no encontrado");
		} else {
			return (Usuario) personasCentro.get(NIF);
		}
	}

	/**
	 * Dado un array de filtros del enumerado Hints y valores para dichos
	 * filtros, genera un conjunto de personas del centro cuyos campos coinciden
	 * con los filtros proporcionados
	 * 
	 * @param hints
	 *            Enumerados de filtro (véase Centro.Hints)
	 * @param values
	 *            Valores para cada filtro ({Hints.NOMBRE, Hints.APELLIDO1},
	 *            {"A", "B"} toma como filtros Nombre -> A, Apellido1 -> B)
	 * @return Conjunto con coincidencias
	 * @throws IllegalArgumentException
	 *             Si el número de filtros no coincide con el de valores.
	 */
	public Set<Persona> getPersonas(Hints[] hints, String[] values,
			Hints[] tiposPers) throws IllegalArgumentException {

		if (hints.length != values.length)
			throw new IllegalArgumentException(
					"Número de campos debe coincidir con número de valores de búsqueda");

		Set<Persona> resultadoBusc = new HashSet<>();

		Collection<Persona> personas = personasCentro.values();

		// Mapa de filtros a emplear en la búsqueda.
		Map<Hints, String> filtros = IntStream.range(0, hints.length).boxed()
				.collect(Collectors.toMap(i -> hints[i], i -> values[i]));

		// Conjunto de tipos de persona a buscar.
		Set<Hints> tipos = new HashSet<>(Arrays.asList(tiposPers));

		for (Persona x : personas) {
			boolean valida = true;

			valida = (tipos.size() == 0)
					|| (tipos.contains(Hints.PACIENTE) && x instanceof Paciente)
					|| (tipos.contains(Hints.ADMINISTRADOR)
							&& x instanceof Usuario && ((Usuario) x).isAdmin())
					|| (tipos.contains(Hints.USUARIO) && x instanceof Usuario && !((Usuario) x).isAdmin());

			if(valida){
				valida = filtros.containsKey(Hints.NIF) ? filtros.get(Hints.NIF)
						.equals(x.getNif()) : valida;
			}
			if (valida) {
				valida = filtros.containsKey(Hints.APELLIDO1) ? filtros.get(
						Hints.APELLIDO1).equals(x.getFirstSurname()) : valida;
			}
			if (valida) {
				valida = filtros.containsKey(Hints.APELLIDO2) ? filtros.get(
						Hints.APELLIDO2).equals(x.getSecondSurname()) : valida;
			}
			if (valida) {
				valida = filtros.containsKey(Hints.NOMBRE) ? filtros.get(
						Hints.NOMBRE).equals(x.getName()) : valida;
			}

			if (valida)
				resultadoBusc.add(x);
		}

		return resultadoBusc;
	}

	/**
	 * Funcionará?
	 * 
	 * @param nif
	 * @return
	 */
	public Persona getPersona(String nif) {
		Set<Persona> aux = getPersonas(new Hints[] { Hints.NIF },
				new String[] { nif }, null);
		assert (aux.size() == 1);
		return aux.toArray(new Persona[aux.size()])[0];
	}

	/*
	 * private void initCentro() { for (Persona key : pacientes.keySet()) {
	 * personasCentro.put(key.getNif(), key); } for (Persona key :
	 * usuarios.keySet()) { personasCentro.put(key.getNif(), key); } }
	 */

	public Set<Usuario> getUsuariosAsociados(Paciente pac)
			throws NotBoundException {
		if (!personasCentro.containsKey(pac.getNif())) {
			throw new NotBoundException("Usuario " + pac + " no encontrado");
		} else
			return pacientes.get(pac);
	}

	public EstadoCentro comoAlmacenable() {
		return new EstadoCentro(this.getNombre());
	}
}
