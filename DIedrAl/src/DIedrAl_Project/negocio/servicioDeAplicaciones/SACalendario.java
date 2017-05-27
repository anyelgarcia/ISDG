package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.time.*;

import DIedrAl_Project.negocio.calendario.SesionProgramada;

public interface SACalendario {
	
	public void swapMonth(LocalDate t);
	
	public void addSesion(SesionProgramada sesion);
	
	public void removeSesion(SesionProgramada sesion);
}
