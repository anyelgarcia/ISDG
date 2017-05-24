package DIedrAl_Project.negocio.tests;

import static org.junit.Assert.*;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Test;

import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.recursos.*;
import DIedrAl_Project.negocio.servicioDeAplicaciones.*;

public class servicioAplicacionTest {

	private static final Logger log = Logger
			.getLogger(servicioAplicacionTest.class.getName());

	@Test
	public void testSARecursosIterator() {
    
		SAFactory factoriaSA = SAFactory.getInstancia();
		SARecursos servicioAPRecursos = factoriaSA.newSARecursos(Banco
				.getInstancia());

		Sesion sesionAux;

		// Añadir al banco diez sesiones de prueba
		for (int i = 0; i < 10; i++) {
			sesionAux = new Sesion("Sesion " + (i + 1));
			sesionAux.setDuracion(i + 1);
			servicioAPRecursos.addSesion(sesionAux);
		}

		// Mover el filtro abarcando cada vez un minuto más.
		for (int x = 1; x < 11; x++) {
			// Filtrar sesiones entre 0 y x de duración
			ArraySesiones resultado = servicioAPRecursos
					.filtrarSesionesPorRango(0, x);

			// Comprobar que se han tomado las diez
			assertTrue("Filtra número correcto", resultado.size() == x);

			// Creación de un iterador para recorrer el resultado.
			Iterator<Sesion> it = resultado.iterator();

			// Texto del resultado
			StringBuilder sb = new StringBuilder("");
			for (Sesion s : resultado) {
				sb.append(s.getDuracion() + " ");
			}

			log.info(sb.toString());
		}
	}

	/**
	 * Tests para comprobar el funcionamiento de los métodos: -Construcción de
	 * Centro y SAPacientesImpl -filtrarPersonas -addPaciente, addUsuario
	 * -erasePaciente, eraseUsuario -getUsuarioConNIF -ligarPaciente
	 */
	@Test
	public void testSAPacientesOperaciones() {

		// Crear un nuevo centro de prueba donde añadir pacientes y terapeutas.
		Centro centro = new Centro("Centro de Prueba");

		assertTrue("Centro iniciado correctamente", centro != null);

		// Tomar instancia de factoría SA y conseguir SA de pacientes
		SAFactory factoriaSA = SAFactory.getInstancia();
		SAPacientes servicioApPac = factoriaSA.newSAPacientes(centro);

		assertTrue("SA iniciado correctamente", servicioApPac != null);

		// PRUEBA: LOS PACIENTES SE AÑADEN CORRECTAMENTE. FILTRO FUNCIONA
		// ----------------------------------------------------------------------------------

		// Nombres y Apellidos para la prueba
		String[] nombres = { "Angel", "Pablo", "Enrique", "Guillermo",
				"Alejandro", "Pablo" };
		String[] apellidos = { "Manzana", "Apio", "Naranja", "Limon",
				"Aceituna", "Ajo" };

		Random rand = new Random();

		// Añadir pacientes al centro por medio del SA Pacientes.
		for (int i = 0; i < nombres.length; ++i) {
			try {
				// Paciente a añadir.
				Paciente pacAux = new Paciente(nombres[i], apellidos[i],
						apellidos[i], Integer.toString(rand.nextInt(99999)));

				// Intentar añadirlo.
				servicioApPac.addPaciente(pacAux);

				// Comprueba que ha sido añadido y que el filtro funciona.
				Set<Persona> personas = servicioApPac.filtrarPersonas(
						new Hints[] { Hints.NOMBRE, Hints.APELLIDO1 },
						new String[] { nombres[i], apellidos[i] },
						new Hints[] {});

				assertTrue("Paciente añadido correctamente",
						personas.contains(pacAux));
			} catch (AlreadyBoundException e) {
				log.info(e.getMessage());
			}
		}

		// PRUEBA: LOS USUARIOS SE AÑADEN CORRECTAMENTE. FILTRO FUNCIONA
		// ----------------------------------------------------------------------------------
		try {
			// Usuario a añadir
			Usuario usAux = new Usuario("Antonio", "Lopez", "Morales",
					"00000001A");

			// Intentar añadir usuario al centro
			servicioApPac.addUsuario(usAux);

			// Comprueba que ha sido añadido y que el filtro funciona.
			Set<Persona> personas = servicioApPac.filtrarPersonas(new Hints[] {
					Hints.NOMBRE, Hints.APELLIDO1 }, new String[] { "Antonio",
					"Lopez" }, new Hints[] {});

			assertTrue("Usuario añadido correctamente",
					personas.contains(usAux));
		} catch (AlreadyBoundException e) {
			log.info(e.getMessage());
		}

		// PRUEBA: NO SE ENCUENTRAN PERSONAS QUE NO EXISTEN
		// ----------------------------------------------------------------------------------
		// Comprueba que al filtrar por personas que no existen no encuentra
		// nada.
		Set<Persona> noEncontradas = servicioApPac.filtrarPersonas(new Hints[] {
				Hints.NOMBRE, Hints.APELLIDO1 }, new String[] { "Inexistente",
				"NoExisto" }, new Hints[] {});

		assertTrue("Usuario no encontrado", noEncontradas.size() == 0);

		// PRUEBA: getUsuarioConNIF funciona adecuadamente. Ligar paciente con
		// terapeuta ok. Volver a intentar ligar da error.
		// ----------------------------------------------------------------------------------

		Usuario t = null;
		try {
			t = servicioApPac.getUsuarioConNIF("00000001A");
		} catch (NotBoundException e1) {
			assertTrue("El terapeuta no se pudo añadir", t == null);
		}
		assertTrue("El terapeuta ha sido añadido al centro", t != null
				&& t.getNif().equals("00000001A"));

		// Obtener conjunto de personas que se llamen Pablo
		Set<Persona> coincidentes = servicioApPac.filtrarPersonas(
				new Hints[] { Hints.NOMBRE }, new String[] { "Pablo" },
				new Hints[] { Hints.PACIENTE });

		try {
			servicioApPac.ligarPaciente((Paciente) coincidentes
					.toArray(new Persona[coincidentes.size()])[0], t);
		} catch (Exception e) {
			log.info("El paciente no se pudo ligar al terapeuta");
			assertTrue("El paciente se ha ligado al terapeuta", false);
		}

		boolean errorDetectado = false;

		// Volver a intentar ligarlo; se comprueba que da error

		Paciente buscado = (Paciente) coincidentes
				.toArray(new Persona[coincidentes.size()])[0];

		try {
			servicioApPac.ligarPaciente(buscado, t);
		} catch (NotBoundException e) {
			log.info("El paciente no se encontraba en el registro del centro");
			assertTrue(false);
		} catch (AlreadyBoundException e) {
			log.info("El paciente ya estaba ligado al terapeuta");
			errorDetectado = true;
		}

		assertTrue(
				"Intento de ligar el mismo paciente con el mismo terapeuta por segunda vez",
				errorDetectado);

		// PRUEBA: comprobar que paciente y terapeuta están ligados.
		// ----------------------------------------------------------------------------------
		try {
			assertTrue("El terapeuta tiene como asociado al paciente",
					servicioApPac.getPacientesAsociados(t).contains(buscado));
		} catch (NotBoundException e) {
			assertTrue(false);
		}

		try {
			Set<Usuario> usAsoc = servicioApPac.getUsuariosAsociados(buscado);
			assertTrue("El terapeuta tiene como asociado al paciente",
					servicioApPac.getUsuariosAsociados(buscado).contains(t));
		} catch (NotBoundException e) {
			assertTrue(false);
		}

		// PRUEBA: un paciente se desliga del terapeuta si se borra del sistema.
		// ----------------------------------------------------------------------------------
		
		// Borrar paciente del sistema y comprobar que no sigue ligado
		try {
			servicioApPac.erasePaciente(buscado);
			assertFalse("El paciente ya no está asociado al usuario",
					servicioApPac.getPacientesAsociados(t).contains(buscado));
		} catch (NotBoundException e) {
			assertTrue(false);
		}

		// Borrar usuario del sistema y comprobar que ya no es accesible.
		boolean yaNoAccesible  = false;
		try {
			servicioApPac.eraseUsuario(t);
			servicioApPac.getUsuarioConNIF(t.getNif());
		} catch (NotBoundException e) {
			yaNoAccesible = true;
		}
		assertTrue("El usuario ya no es accesible", yaNoAccesible);

	}

	public static void main(String... args) {

	}
}
