package DIedrAl_Project.negocio.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.Test;

import DIedrAl_Project.negocio.recursos.*;
import DIedrAl_Project.negocio.servicioDeAplicaciones.*;

public class SARecursosTest {

	private static final Logger log = Logger.getLogger(SARecursosTest.class.getName());

	private SAFactory factoriaSA = SAFactory.getInstancia();
	private SARecursos sarec = factoriaSA.newSARecursos();

	@Test
	public void testSARecursosSesionesIterator() {

		// Limpiamos el banco.
		Banco.getInstancia().setSesiones(new ArraySesiones());

		// Añadir al banco diez sesiones de prueba
		for (int i = 0; i < 10; i++) {
			Sesion sesionAux = new Sesion("Sesion " + (i + 1));
			sesionAux.setDuracion(i + 1);
			try {
				sarec.addSesion(sesionAux);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Mover el filtro abarcando cada vez un minuto más.
		for (int x = 1; x < 11; x++) {
			// Filtrar sesiones entre 0 y x de duración
			ArraySesiones resultado = sarec.filtrarSesionesPorRango(0, x);

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
	public void testSARecursosCarga() {
		sarec = factoriaSA.newSARecursos();
		testSARecursosSesionesIterator();
		sarec = factoriaSA.newSARecursos();
		assertTrue(sarec.getSesiones().size() != 0);
	}

	@Test
	public void testActs() {
		testCrearActs();
		testFiltrarActs();
	}

	public void testCrearActs() {
		// Limpiamos el banco.
		Banco.getInstancia().setActividades(new ArrayActividades());

		// Añadir al banco diez actividades de prueba
		for (int i = 0; i < 10; i++) {
			Actividad a = new Actividad("Actividad nº " + (i + 1));
			try {
				try {
					a.addEtiqueta("Sukerorku es el rey nº " + (i + 1));
				} catch (AlreadyBoundException e) {
					log.severe("No añadas etiquetas de más, que es un test");
				}
				a.setDuracion((120 + i) % 30);
				a.setDescripcion("Shouwa genroku rakugo shinjuu es genial");
				a.addDestinatario("Pablo Gutiérrez no va a leer esto");
				a.setVariaciones("Psycho pass " + (Math.abs(new Random().nextInt()) % 2 +1) + " tambien está bien");
				a.setDesarrollo("Estoy viendo el capitulo " + (Math.abs(new Random().nextInt())) % 25);
				try {
					a.addActividad(null);
				} catch (AlreadyBoundException e) {
					log.severe(e.getMessage());
				}
				if ((i % 3) == 2) {
					a.setDificultad(Dificultad.DIFICIL);
				} else {
					a.setDificultad(Dificultad.MUY_FACIL);
				}
				sarec.addActividad(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		testFiltrarActs();

	}

	public void testFiltrarActs() {
		testFiltrarActsDif();
		testFiltrarActsDur();
	}

	private void testFiltrarActsDur() {
		ArrayActividades act=sarec.filtrarActividadesDesde(0);
		assertTrue(act.size()==sarec.getActividades().size());

	}

	public void testFiltrarActsDif() {
		ArrayActividades rango = sarec.filtrarActividadesPorRango(Dificultad.MEDIO, Dificultad.MEDIO);
		assertTrue(rango.empty());
		rango = sarec.filtrarActividadesPorRango(Dificultad.MEDIO, Dificultad.MUY_DIFICIL);
		assertTrue(rango.size() != 0);
		log.info(rango.toString());
		ArrayActividades desde = sarec.filtrarActividadesDesde(Dificultad.MEDIO);
		assertTrue(desde.size() == rango.size());
		log.info(desde.toString());
		ArrayActividades hasta = sarec.filtrarActividadesHasta(Dificultad.MUY_FACIL);
		log.info(hasta.toString());
		ArrayActividades vacio = sarec.filtrarActividadesPorRango(Dificultad.MUY_DIFICIL, Dificultad.MUY_FACIL);
		assertTrue(vacio.empty());

	}
	
	@Test
	public void clearBanco(){
		ArrayActividades a=sarec.getActividades();
		for(Actividad act:a){
			try {
				sarec.removeActividad(act);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
		ArrayRecursos r=sarec.getRecursos();
		for(Recurso rec:r){
			try {
				sarec.removeRecurso(rec);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		} 
		ArraySesiones s=sarec.getSesiones();
		for(Sesion ses:s){
			try {
				sarec.removeSesion(ses);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Pruebas para: getActividades, recursos, etc, deletes
	 * 
	 */
}
