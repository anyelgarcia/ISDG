package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import DIedrAl_Project.integracion.BasicClasses.*;
import DIedrAl_Project.integracion.DAOinterfaces.*;
import DIedrAl_Project.integracion.simplefileImp.*;
import DIedrAl_Project.negocio.recursos.*;

public class SARecursosImpl implements SARecursos {

	private Banco bank;

	private DAORecurso daorec;

	private DAOActividad daoact;

	private DAOSesion daoses;
	
	private DAOSesionProgramada daosp;

	private static SARecursosImpl instancia = null;

	public static SARecursosImpl getInstancia() {

		if (instancia == null) {
			instancia = new SARecursosImpl();
		}

		return instancia;
	}

	private SARecursosImpl() {
		SimpleFileDAOFactory factoria = SimpleFileDAOFactory.getInstance();
		daorec = factoria.getDAORecurso();
		daoact = factoria.getDAOActividad();
		daoses = factoria.getDAOSesion();
		daosp = factoria.getDAOSesionProgramada();
		bank = Banco.getInstancia();
		cargarBanco();
	}

	@Override
	public void addRecurso(Recurso rec) throws AccessException, IOException {
		bank.addRecurso(rec);
		daorec.crearRecurso(rec);

		File dir = new File("/src/recursos");
		dir.mkdirs();
		File recursoSave= new File(dir, rec.getFileName());
		recursoSave.createNewFile();
		File resourcesDir = new File("\\srcrecursos/" + rec.getFileName());
		resourcesDir.mkdirs();
		Logger.getLogger(SARecursosImpl.class.getName()).severe(resourcesDir.mkdirs() + "");
		//Files.createDirectories(Paths.get(resourcesDir.getPath()));
		Files.copy(rec.getPath(), resourcesDir.toPath(),
				StandardCopyOption.REPLACE_EXISTING);

	}

	@Override
	public void removeRecurso(Recurso rec) throws AccessException {

		// Primera capa de borrado: se elimina el recurso de la lista de
		// recursos del banco
		bank.removeRecurso(rec);
		daorec.eliminarRecurso(rec.getId());

		// Segunda capa de borrado: se elimina de todas los programables que la
		// tuvieran como asociado
		HashSet<Programable> programables = new HashSet<Programable>();
		programables.addAll(daoses.listarSesiones());
		programables.addAll(daoact.listarActividades());
		programables.addAll(daosp.listarSesionesProgramadas());
		for (Programable p : programables) {
			if (p.getAsociados().contains(rec)) {
				p.getAsociados().remove(rec);
				try {
					if (p instanceof SesionProgramada)
						daosp.modificarSesionProgramada((SesionProgramada) p);
					else if (p instanceof Sesion) 
						daoses.modificarSesion((Sesion) p);
					else
						daoact.modificarActividad((Actividad) p);

				} catch (AccessException e) {
					throw new AccessException(e.getMessage()
							+ "\nFallo al utilizar el DAO");
				}
			}
		}

		rec.getFile().delete();

	}

	@Override
	public void addActividad(Actividad act) throws AccessException {
		bank.addActividad(act);
		daoact.crearActividad(act);
	}

	@Override
	public void removeActividad(Actividad act) throws AccessException {

		// Primera capa de borrado: se elimina el recurso de la lista de
		// recursos del banco
		bank.removeActividad(act);
		daoact.eliminarActividad(act.getId());

		// Segunda capa de borrado: se elimina de todas los programables que la
		// tuvieran como asociado
		HashSet<Programable> programables = new HashSet<Programable>();
		programables.addAll(daoses.listarSesiones());
		programables.addAll(daoact.listarActividades());
		programables.addAll(daosp.listarSesionesProgramadas());
		for (Programable p : programables) {
			if (p.getAsociados().contains(act)) {
				p.getAsociados().remove(act);
				try {
					if (p instanceof SesionProgramada)
						daosp.modificarSesionProgramada((SesionProgramada) p);
					else if (p instanceof Sesion) 
						daoses.modificarSesion((Sesion) p);
					else
						daoact.modificarActividad((Actividad) p);

				}catch (AccessException e) {
					throw new AccessException(e.getMessage()
							+ "\nFallo al utilizar el DAO");
				}
			}
		}

	}

	@Override
	public void addSesion(Sesion ses) throws AccessException {
		bank.addSesion(ses);
		daoses.crearSesion(ses);
	}

	@Override
	public void removeSesion(Sesion ses) throws AccessException {
		bank.removeSesion(ses);
		daoses.eliminarSesion(ses.getId());
	}
	

	@Override
	public void addSesionProgramada(SesionProgramada sp) throws AccessException {
		bank.addSesionProgramada(sp);
		daosp.crearSesionProgramada(sp);
	}
	
	@Override
	public void removeSesionProgramada(SesionProgramada sp) throws AccessException {
		bank.removeSesionProgramada(sp);
		daosp.eliminarSesionProgramada(sp.getId());
	}
	

	@Override
	public ArrayRecursos filtrarRecursosPorNombre(String nombre) {
		return (ArrayRecursos) bank.getRecursos().filtrarNombre(nombre);
	}

	@Override
	public ArrayActividades filtrarActividadPorNombre(String nombre) {
		return (ArrayActividades) bank.getActividades().filtrarNombre(nombre);
	}

	@Override
	public ArraySesiones filtrarSesionPorNombre(String nombre) {
		return (ArraySesiones) bank.getSesiones().filtrarNombre(nombre);
	}

	@Override
	public ArrayRecursos filtrarRecursoPorEtiqueta(Set<String> filtros) {
		return (ArrayRecursos) bank.getRecursos().filtrarEtiqueta(filtros);
	}

	@Override
	public ArrayActividades filtrarActividadPorEtiqueta(Set<String> filtros) {
		return (ArrayActividades) bank.getActividades().filtrarEtiqueta(filtros);
	}

	@Override
	public ArraySesiones filtrarSesionPorEtiqueta(Set<String> filtros) {
		return (ArraySesiones) bank.getSesiones().filtrarEtiqueta(filtros);
	}

	@Override
	public ArrayActividades filtrarActividadesPorRango(Integer min, Integer max) {
		return (ArrayActividades) bank.getActividades().filtrarRango(min, max);
	}

	@Override
	public ArrayActividades filtrarActividadesDesde(Integer dur) {
		return (ArrayActividades) bank.getActividades().filtrarDesde(dur);
	}

	@Override
	public ArrayActividades filtrarActividadesHasta(Integer dur) {
		return (ArrayActividades) bank.getActividades().filtrarHasta(dur);
	}

	@Override
	public ArrayActividades filtrarActividadesPorDestinatarios(Set<String> dest) {
		return (ArrayActividades) bank.getActividades().filtrarDestinatarios(
				dest);
	}

	@Override
	public ArraySesiones filtrarSesionesPorRango(Integer min, Integer max) {
		return (ArraySesiones) bank.getSesiones().filtrarRango(min, max);
	}

	@Override
	public ArraySesiones filtrarSesionesDesde(Integer dur) {
		return (ArraySesiones) bank.getSesiones().filtrarDesde(dur);
	}

	@Override
	public ArraySesiones filtrarSesionesHasta(Integer dur) {
		return (ArraySesiones) bank.getSesiones().filtrarHasta(dur);
	}

	@Override
	public ArraySesiones filtrarSesionesDestinatarios(Set<String> dest) {
		return (ArraySesiones) bank.getSesiones().filtrarDestinatarios(dest);
	}

	@Override
	public ArrayActividades filtrarActividadesPorRango(Dificultad min,
			Dificultad max) {
		return bank.getActividades().filtrarRango(min, max);
	}

	@Override
	public ArrayActividades filtrarActividadesDesde(Dificultad dif) {
		return bank.getActividades().filtrarDesde(dif);
	}

	@Override
	public ArrayActividades filtrarActividadesHasta(Dificultad dif) {
		return bank.getActividades().filtrarHasta(dif);
	}
	
	public ArraySesionesProgramadas filtrarSesionProgramadaPorNifPaciente(String nif){
		return bank.getSesionesProgramadas().filtrarNifPaciente(nif);
	}
	
	public ArraySesionesProgramadas filtrarSesionProgramadaPorNifTerapeuta(String nif){
		return bank.getSesionesProgramadas().filtrarNifTerapeuta(nif);
	}

	@Override
	public ArraySesiones getSesiones() {
		return bank.getSesiones();
	}

	@Override
	public ArrayActividades getActividades() {
		return bank.getActividades();
	}

	@Override
	public ArrayRecursos getRecursos() {
		return bank.getRecursos();
	}
	
	@Override
	public ArraySesionesProgramadas getSesionesProgramadas(Fecha fecha) {
		return bank.getSesionesProgramadas().filtrarFecha(fecha);
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

	@Override
	public void updateSesion(Sesion ses) throws AccessException {
		this.daoses.modificarSesion(ses);
	}

	@Override
	public void updateActividad(Actividad act) throws AccessException {
		this.daoact.modificarActividad(act);
	}

	@Override
	public void updateRecurso(Recurso rec) throws AccessException {
		this.daorec.modificarRecurso(rec);
	}
	
	@Override
	public void updateSesionProgramada(SesionProgramada sp) throws AccessException {
		this.daosp.modificarSesionProgramada(sp);
	}

}
