package DIedrAl_Project.negocio.calendario;

import java.time.*;
import java.util.*;
public class Calendario {
	private Map<LocalDate, Set<SesionProgramada>> sesiones;

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

	

}
