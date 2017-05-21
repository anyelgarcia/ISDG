package DIedrAl_Project.negocio.tests;

import static junit.framework.TestCase.assertTrue;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.Centro.Hints;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAPacientes;

import com.sun.istack.internal.logging.Logger;

public class servicioAplicacionTest {

	private static final Logger log = Logger.getLogger(
			servicioAplicacionTest.class.getName(), null);

	@Test
	public void testSAPacientes() {

		Centro centro = new Centro("Centro de Prueba");
		SAFactory factoriaSA = SAFactory.getInstancia();

		SAPacientes servicioApPac = factoriaSA.newSAPacientes(centro);

		String[] nombres = { "Angel", "Pablo", "Enrique", "Guillermo",
				"Alejandro", "Pablo" };
		String[] apellidos = { "Manzana", "Apio", "Naranja", "Limon",
				"Aceituna", "Ajo" };
		Random rand = new Random();

		// Añadir pacientes al centro por medio del SA Pacientes.
		for (int i = 0; i < nombres.length; ++i) {
			try {
				servicioApPac.addPaciente(new Paciente(nombres[i],
						apellidos[i], apellidos[i], Integer.toString(rand
								.nextInt(999999999))));
			} catch (AlreadyBoundException e) {
				log.info(e.getMessage());
			}
		}

		try {
			servicioApPac.addUsuario(new Usuario("Antonio", "Lopez", "Morales",
					"00000001A"));
		} catch (AlreadyBoundException e) {
			log.info(e.getMessage());
		}

		Usuario t = servicioApPac.usuarioConNIF("00000001A");

		assertTrue("El terapeuta ha sido añadido al centro", t != null
				&& t.getId().equals("00000001A"));

		Hints[] campos = new Hints[] { Hints.NOMBRE };
		String[] valores = new String[] { "Pablo" };
		Set<Persona> personas = servicioApPac.filtrarPersonas(campos, valores);

		Persona[] coincidentes = (Persona[]) personas.toArray();
		assertTrue(
				"Se han encontrado dos pacientes con este nombre",
				coincidentes.length == 2
						&& coincidentes[0].getName().equals(
								coincidentes[1].getName())
						&& coincidentes[0].getName().equals("Pablo"));

		try {
			servicioApPac.ligarPaciente((Paciente) coincidentes[0], t);
		} catch (Exception e) {
			log.info("El paciente no se pudo ligar al terapeuta");
			assertTrue(false);
		}

		boolean errorDetectado = false;

		try {
			servicioApPac.ligarPaciente((Paciente) coincidentes[0], t);
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
	}

	public static void main(String... args) {

	}
}
