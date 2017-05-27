package DIedrAl_Project.negocio.calendario;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class Calendario {
	private Map<LocalTime, Set<SesionProgramada>> sesiones;

	public void addSesion(SesionProgramada sesion) {
		sesiones.get(sesion.getFecha()).add(sesion);
	}

	// necesario?
	public void change(SesionProgramada antigua, SesionProgramada nueva) {
		if (!sesiones.get(antigua.getFecha()).contains(antigua)) {
			throw new IllegalArgumentException();
		} else {
			sesiones.get(antigua.getFecha()).remove(antigua);
			sesiones.get(antigua.getFecha()).add(nueva);
		}

	}

	public void eliminarSesion(SesionProgramada sesion) {
		if (!sesiones.get(sesion.getFecha()).contains(sesion)) {
			throw new IllegalArgumentException();
		} else {
			sesiones.get(sesion.getFecha()).remove(sesion);
		}
	}

	

}
