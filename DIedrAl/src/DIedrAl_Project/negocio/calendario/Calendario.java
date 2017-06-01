package DIedrAl_Project.negocio.calendario;

import java.io.Serializable;
import java.time.*;
import java.util.*;

import DIedrAl_Project.negocio.ObjetoAlmacenable;

public class Calendario implements ObjetoAlmacenable, Serializable {

	private String id;
	private Map<LocalDate, Set<SesionProgramada>> sesiones;

	public Calendario() {
		id = UUID.randomUUID().toString();
		sesiones = new TreeMap<LocalDate, Set<SesionProgramada>>();
	}

	public void addSesion(SesionProgramada sesion) {
		sesiones.get(sesion.getFecha()).add(sesion);
	}

	public void eliminarSesion(SesionProgramada sesion) {
		if (!sesiones.get(sesion.getFecha()).contains(sesion)) {
			throw new IllegalArgumentException();
		} else {
			sesiones.get(sesion.getFecha()).remove(sesion);
		}
	}

	@Override
	public String getId() {
		return id;
	}

}
