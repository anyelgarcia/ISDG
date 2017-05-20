package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.util.Set;

import DIedrAl_Project.negocio.recursos.*;

public class SARecursosImpl implements SARecursos{
	private Banco bank;
	
	public SARecursosImpl(Banco b){
		bank=b;
	}

	@Override
	public void addRecurso(Recurso rec) {
		bank.addRecurso(rec);
	}

	@Override
	public void removeRecurso(Recurso rec) {
		bank.removeRecurso(rec);
		
	}

	@Override
	public void addActividad(Actividad act) {
		bank.addActividad(act);
		
	}

	@Override
	public void removeActividad(Actividad act) {
		bank.removeActividad(act);
		
	}

	@Override
	public void addSesion(Sesion ses) {
		bank.addSesion(ses);
		
	}

	@Override
	public void removeSesion(Sesion ses) {
		bank.removeSesion(ses);
		
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


}
