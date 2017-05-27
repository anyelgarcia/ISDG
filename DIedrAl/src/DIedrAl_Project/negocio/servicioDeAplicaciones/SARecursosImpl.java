package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;

import DIedrAl_Project.integracion.DAOActividad;
import DIedrAl_Project.integracion.DAORecurso;
import DIedrAl_Project.integracion.DAOSesion;
import DIedrAl_Project.integracion.SimpleFileDAOFactory;
import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.ArrayActividades;
import DIedrAl_Project.negocio.recursos.ArrayRecursos;
import DIedrAl_Project.negocio.recursos.ArraySesiones;
import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Dificultad;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.negocio.recursos.Sesion;

public class SARecursosImpl implements SARecursos {
	private Banco bank = Banco.getInstancia();
	private SimpleFileDAOFactory factoria;

	public SARecursosImpl() {
	}

	@Override
	public void addRecurso(Recurso rec) throws IOException {
		bank.addRecurso(rec);
		DAORecurso daorec = factoria.getDAORecurso();
		daorec.crearRecurso(rec);
		
		File resourcesDir = new File("src/recursos/" + rec.getFileName());
		Files.copy(rec.getPath(), resourcesDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}

	@Override
	public void removeRecurso(Recurso rec) throws ClassNotFoundException, IOException {

		// Primera capa de borrado: se elimina el recurso de la lista de
		// recursos del banco
		bank.removeRecurso(rec);
		DAORecurso daorec = factoria.getDAORecurso();
		daorec.eliminarRecurso(rec.getId());

		// Segunda capa de borrado: se elimina de todas las actividades que lo
		// tuvieran como asociado
		DAOActividad daoact = factoria.getDAOActividad();
		HashSet<Actividad> actividades = daoact.listarActividades();
		actividades.forEach((actividad) -> {
			if (actividad.getAsociados().contains(rec)) {
				actividad.getAsociados().remove(rec);
				try {
					daoact.modificarActividad(actividad);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// Tercera capa de borrado: se elimina de todas las sesiones que lo
		// tuvieran como asociado
		DAOSesion daoses = factoria.getDAOSesion();
		HashSet<Sesion> sesiones = daoses.listarSesiones();
		sesiones.forEach((sesion) -> {
			if (sesion.getAsociados().contains(rec)) {
				sesion.getAsociados().remove(rec);
				try {
					daoses.modificarSesion(sesion);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		rec.getFile().delete();

	}

	@Override
	public void addActividad(Actividad act) throws IOException {
		bank.addActividad(act);
		DAOActividad daoact = factoria.getDAOActividad();
		daoact.crearActividad(act);
	}

	@Override
	public void removeActividad(Actividad act) throws ClassNotFoundException, IOException {

		// Primera capa de borrado: se elimina el recurso de la lista de
		// recursos del banco
		bank.removeActividad(act);
		DAOActividad daoact = factoria.getDAOActividad();
		daoact.eliminarActividad(act.getId());

		// Segunda capa de borrado: se elimina de todas las sesiones que la
		// tuvieran como asociado
		DAOSesion daoses = factoria.getDAOSesion();
		HashSet<Sesion> sesiones = daoses.listarSesiones();
		sesiones.forEach((sesion) -> {
			if (sesion.getAsociados().contains(act)) {
				sesion.getAsociados().remove(act);
				try {
					daoses.modificarSesion(sesion);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	public void addSesion(Sesion ses) throws IOException{
		bank.addSesion(ses);
		DAOSesion daoses = factoria.getDAOSesion();
		daoses.crearSesion(ses);
	}

	@Override
	public void removeSesion(Sesion ses) throws ClassNotFoundException, IOException {
		bank.removeSesion(ses);
		DAOSesion daoses = factoria.getDAOSesion();
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
		return (ArrayActividades) bank.getActividades().filtrarDestinatarios(dest);
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
	public ArrayActividades filtrarActividadesPorRango(Dificultad min, Dificultad max) {
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

}
