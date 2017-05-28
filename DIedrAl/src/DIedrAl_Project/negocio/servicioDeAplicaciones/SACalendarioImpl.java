package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.time.LocalDate;

import DIedrAl_Project.negocio.calendario.*;

public class SACalendarioImpl implements SACalendario {

	private MesProxy mes;

	@Override
	public void swapMonth(LocalDate t) {
		
		Calendario calen = null;
		mes = new MesProxy(calen , (c)->{
			/*
			 * TODO Implementar la logica usando el DAO, que dado un mes
			 * te devuelva las fechas necesarias.
			 */
		});

	}

	@Override
	public void addSesion(SesionProgramada sesion) {
		mes.addSesion(sesion);
	}

	@Override
	public void removeSesion(SesionProgramada sesion) {
		mes.removeSesion(sesion);
	}

}
