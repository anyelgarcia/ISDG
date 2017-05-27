package DIedrAl_Project.negocio.calendario;

import java.time.LocalTime;

public class MesProxy implements MesCalendario {

	private MesReal mes;
	
	private CalenCharger charger;
	
	private Calendario cal;

	public MesProxy(Calendario calen, CalenCharger ch) {
		charger = ch;
		cal=calen;
		mes = null;
	}

	@Override
	public void removeSesion(SesionProgramada sesion) {
		autoCreate();
		mes.removeSesion(sesion);
	}

	@Override
	public void addSesion(SesionProgramada sesion) {
		autoCreate();
		mes.addSesion(sesion);
	}

	private void autoCreate() {
		if (mes == null) {
			mes = new MesReal(cal, charger);
		}
	}

}
