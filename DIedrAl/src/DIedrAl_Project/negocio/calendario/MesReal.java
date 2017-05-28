package DIedrAl_Project.negocio.calendario;

public class MesReal implements MesCalendario {
	
	private Calendario calen;

	public MesReal(Calendario c, CalenCharger charger) {
		calen = c;
		charger.charge(calen);
	}
	@Override
	public void removeSesion(SesionProgramada sesion) {
		calen.eliminarSesion(sesion);
	}

	@Override
	public void addSesion(SesionProgramada sesion) {
		calen.addSesion(sesion);

	}
	

}
