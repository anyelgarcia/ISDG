package DIedrAl_Project.negocio.calendario;

import java.time.LocalTime;

public class MesReal implements MesCalendario {
	
	private Calendario calen;
	
	private CalenCharger charger;

	public MesReal(Calendario c, CalenCharger calench) {
		calen = c;
		charger = calench;
	}
	@Override
	public void removeSesion(SesionProgramada sesion) {
		charge();
		calen.eliminarSesion(sesion);
	}

	@Override
	public void addSesion(SesionProgramada sesion) {
		charge();
		calen.addSesion(sesion);

	}
	
	private void charge(){
		if(calen==null){
			charger.charge(calen);
		}
	}

}
