package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.DAOinterfaces.DAOActividad;
import DIedrAl_Project.integracion.DAOinterfaces.DAORecurso;
import DIedrAl_Project.integracion.DAOinterfaces.DAOSesion;
import DIedrAl_Project.integracion.DAOinterfaces.DAOSesionProgramada;
import DIedrAl_Project.integracion.simplefileImp.SimpleFileDAOFactory;
import DIedrAl_Project.negocio.calendario.*;
import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.ArraySesionesProgramadas;
import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.negocio.recursos.Sesion;

public class SACalendarioImpl implements SACalendario {
	


	private static SACalendarioImpl instancia;
	private DAORecurso daorec;
	private DAOActividad daoact;
	private DAOSesion daoses;
	private DAOSesionProgramada daosp;
	private Banco bank;
	
	public static SACalendario getInstancia() {

		if (instancia == null) {
			instancia = new SACalendarioImpl();
		}

		return instancia;
	}

	private SACalendarioImpl() {
		SimpleFileDAOFactory factoria = SimpleFileDAOFactory.getInstance();
		daorec = factoria.getDAORecurso();
		daoact = factoria.getDAOActividad();
		daoses = factoria.getDAOSesion();
		daosp = factoria.getDAOSesionProgramada();
		bank = Banco.getInstancia();
		cargarBanco();
	}
	@Override
	public void addSesionProgramada(SesionProgramada sesion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeSesionProgramada(SesionProgramada sesion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateSesionProgramada(SesionProgramada sesion) throws AccessException {
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

	
	private void cargarBanco() {
		try {
			HashSet<Actividad> set = daoact.listarActividades();
			for (Actividad a : set) {
				bank.addActividad(a);
			}
		} catch (AccessException e) {
			// e.printStackTrace();
		}
		try {
			HashSet<Sesion> ses = daoses.listarSesiones();
			for (Sesion s : ses) {
				bank.addSesion(s);
			}
		} catch (AccessException e) {
			// e.printStackTrace();
		}

		try {
			HashSet<Recurso> rec = daorec.listarRecursos();
			for (Recurso r : rec) {
				bank.addRecurso(r);
			}
		} catch (AccessException e) {
			// e.printStackTrace();
		}
		
		try {
			HashSet<SesionProgramada> sep = daosp.listarSesionesProgramadas();
			for (SesionProgramada s : sep) {
				bank.addSesionProgramada(s);
			}
		} catch (AccessException e) {
			// e.printStackTrace();
		}
	}
}
