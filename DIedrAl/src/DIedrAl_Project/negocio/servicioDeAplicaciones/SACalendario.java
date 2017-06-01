package DIedrAl_Project.negocio.servicioDeAplicaciones;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.calendario.SesionProgramada;
import DIedrAl_Project.negocio.recursos.ArraySesionesProgramadas;

public interface SACalendario {
	
	public void addSesionProgramada(SesionProgramada sesion);
	
	public void removeSesionProgramada(SesionProgramada sesion);
	
	public void updateSesionProgramada(SesionProgramada sesion) throws AccessException;
	
	public ArraySesionesProgramadas getSesionesProgramadas();
	
	public ArraySesionesProgramadas filtrarSesionProgramadaPorNifPaciente(String nif);
	
	public ArraySesionesProgramadas filtrarSesionProgramadaPorNifTerapeuta(String nif);
}
