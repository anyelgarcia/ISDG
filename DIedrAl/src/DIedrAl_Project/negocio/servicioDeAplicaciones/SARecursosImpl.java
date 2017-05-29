package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import DIedrAl_Project.integracion.*;
import DIedrAl_Project.negocio.recursos.*;

public class SARecursosImpl implements SARecursos {

	private Banco bank;

	private DAORecurso daorec;

	private DAOActividad daoact;

	private DAOSesion daoses;

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
		bank = Banco.getInstancia();
		cargarBanco();
	}

	@Override
	public void addRecurso(Recurso rec) throws AccessException, IOException {
		bank.addRecurso(rec);
		daorec.crearRecurso(rec);

		File resourcesDir = new File("src/recursos/" + rec.getFileName());
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
		for (Programable p : programables) {
			if (p.getAsociados().contains(rec)) {
				p.getAsociados().remove(rec);
				try {
					if (p instanceof Sesion) {
						daoses.modificarSesion((Sesion) p);
					} else {
						daoact.modificarActividad((Actividad) p);
					}
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
		if (daoact.existeActividad(act.getId())) {

		}
		daoact.eliminarActividad(act.getId());

		// Segunda capa de borrado: se elimina de todas los programables que la
		// tuvieran como asociado
		HashSet<Programable> programables = new HashSet<Programable>();
		programables.addAll(daoses.listarSesiones());
		programables.addAll(daoact.listarActividades());
		for (Programable p : programables) {
			if (p.getAsociados().contains(act)) {
				p.getAsociados().remove(act);
				try {
					if (p instanceof Sesion) {
						daoses.modificarSesion((Sesion) p);
					} else {
						daoact.modificarActividad((Actividad) p);
					}
				} catch (AccessException e) {
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
	public Set<Recurso> filtrarRecursosPorNombre(String nombre) {
		return bank.getRecursos().filtrarNombre(nombre);
	}

	@Override
	public Set<Actividad> filtrarActividadPorNombre(String nombre) {
		return bank.getActividades().filtrarNombre(nombre);
	}

	@Override
	public Set<Sesion> filtrarSesionPorNombre(String nombre) {
		return bank.getSesiones().filtrarNombre(nombre);
	}

	@Override
	public Set<Recurso> filtrarRecursoPorEtiqueta(Set<String> filtros) {
		return bank.getRecursos().filtrarEtiqueta(filtros);
	}

	@Override
	public Set<Actividad> filtrarActividadPorEtiqueta(Set<String> filtros) {
		return bank.getActividades().filtrarEtiqueta(filtros);
	}

	@Override
	public Set<Sesion> filtrarSesionPorEtiqueta(Set<String> filtros) {
		return bank.getSesiones().filtrarEtiqueta(filtros);
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
	}

}
