package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;
import java.util.Set;

import DIedrAl_Project.integracion.AccessException;
import DIedrAl_Project.negocio.recursos.*;

public interface SARecursos {
	
	
	public void addRecurso(Recurso rec) throws AccessException, IOException;

	public void removeRecurso(Recurso rec) throws AccessException;

	public void addActividad(Actividad act) throws AccessException;

	public void removeActividad(Actividad act) throws AccessException;

	public void addSesion(Sesion ses) throws AccessException;

	public void removeSesion(Sesion ses) throws AccessException;

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

	public ArraySesiones getSesiones();

	public ArrayActividades getActividades();

	public ArrayRecursos getRecursos();

}
