package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.time.LocalDate;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.calendario.*;
import DIedrAl_Project.negocio.recursos.ArraySesionesProgramadas;

public class SACalendarioImpl implements SACalendario {


	@Override
	public void addSesion(SesionProgramada sesion) {
		mes.addSesion(sesion);
	}

	@Override
	public void removeSesion(SesionProgramada sesion) {
		mes.removeSesion(sesion);
	}

	@Override
	public void updateSesion(SesionProgramada sesion) throws AccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArraySesionesProgramadas getSesionesProgramadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArraySesionesProgramadas filtrarSesionProgramadaPorNifPaciente(
			String nif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArraySesionesProgramadas filtrarSesionProgramadaPorNifTerapeuta(
			String nif) {
		// TODO Auto-generated method stub
		return null;
	}

}
