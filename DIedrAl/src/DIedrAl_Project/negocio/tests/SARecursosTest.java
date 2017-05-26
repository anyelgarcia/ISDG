package DIedrAl_Project.negocio.tests;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.logging.Logger;

import org.junit.Test;

import DIedrAl_Project.negocio.recursos.ArraySesiones;
import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Sesion;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SAFactory;
import DIedrAl_Project.negocio.servicioDeAplicaciones.SARecursos;

public class SARecursosTest {


	private static final Logger log = Logger
			.getLogger(SARecursosTest.class.getName());
	
	@Test
	public void testSARecursosIterator() {

		SAFactory factoriaSA = SAFactory.getInstancia();
		SARecursos servicioAPRecursos = factoriaSA.newSARecursos(Banco
				.getInstancia());

		Sesion sesionAux;

		// A�adir al banco diez sesiones de prueba
		for (int i = 0; i < 10; i++) {
			sesionAux = new Sesion("Sesion " + (i + 1));
			sesionAux.setDuracion(i + 1);
			servicioAPRecursos.addSesion(sesionAux);
		}

		// Mover el filtro abarcando cada vez un minuto m�s.
		for (int x = 1; x < 11; x++) {
			// Filtrar sesiones entre 0 y x de duraci�n
			ArraySesiones resultado = servicioAPRecursos
					.filtrarSesionesPorRango(0, x);

			// Comprobar que se han tomado las diez
			assertTrue("Filtra n�mero correcto", resultado.size() == x);

			// Creaci�n de un iterador para recorrer el resultado.
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
	 * Pruebas para:
	 * getActividades, recursos, etc,
	 * deletes
	 * 
	 */
}
