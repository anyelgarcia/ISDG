package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.util.Set;

import DIedrAl_Project.negocio.recursos.*;

public interface SARecursos {
	public void addRecurso(Recurso rec);

	public void removeRecurso(Recurso rec);

	public void addActividad(Actividad act);

	public void removeActividad(Actividad act);

	public void addSesion(Sesion ses);

	public void removeSesion(Sesion ses);

	public Set<Recurso> filtrarRecursosPorNombre(String nombre);

	public Set<Actividad> filtrarActividadPorNombre(String nombre);

	public Set<Sesion> filtrarSesionPorNombre(String nombre);

	public Set<Recurso> filtrarRecursoPorEtiqueta(Set<String> filtros);

	public Set<Actividad> filtrarActividadPorEtiqueta(Set<String> filtros);

	public Set<Sesion> filtrarSesionPorEtiqueta(Set<String> filtros);

	public ArrayActividades filtrarActividadesPorRango(Integer min, Integer max);

	public ArrayActividades filtrarActividadesDesde(Integer dur);

	public ArrayActividades filtrarActividadesHasta(Integer dur);

	public ArrayActividades filtrarActividadesPorDestinatarios(Set<String> dest);

	public ArraySesiones filtrarSesionesPorRango(Integer min, Integer max);

	public ArraySesiones filtrarSesionesDesde(Integer dur);

	public ArraySesiones filtrarSesionesHasta(Integer dur);

	public ArraySesiones filtrarSesionesDestinatarios(Set<String> dest);

	public ArrayActividades filtrarActividadesPorRango(Dificultad min, Dificultad max);

	public ArrayActividades filtrarActividadesDesde(Dificultad dif);

	public ArrayActividades filtrarActividadesHasta(Dificultad dif);

}