package DIedrAl_Project.negocio.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
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
	
	private SAFactory factoriaSA = SAFactory.getInstancia();
	private SARecursos servicioAPRecursos = factoriaSA.newSARecursos();
	
	@Test
	public void testSARecursosIterator() {
		
		Banco.getInstancia().setSesiones(new ArraySesiones());

		// Añadir al banco diez sesiones de prueba
		for (int i = 0; i < 10; i++) {
			Sesion sesionAux = new Sesion("Sesion " + (i + 1));
			sesionAux.setDuracion(i + 1);
			try {
				servicioAPRecursos.addSesion(sesionAux);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Mover el filtro abarcando cada vez un minuto más.
		for (int x = 1; x < 11; x++) {
			// Filtrar sesiones entre 0 y x de duración
			ArraySesiones resultado = servicioAPRecursos
					.filtrarSesionesPorRango(0, x);

			// Comprobar que se han tomado las diez
			assertTrue("Filtra número correcto", resultado.size() == x);	

			// Texto del resultado
			StringBuilder sb = new StringBuilder("");
			for (Sesion s : resultado) {
				sb.append(s.getDuracion() + " ");
			}

			log.info(sb.toString());
		}
	}
	@Test
	public void testSARecursosCarga(){
		
	}
	/**
	 * Pruebas para:
	 * getActividades, recursos, etc,
	 * deletes
	 * 
	 */
}
