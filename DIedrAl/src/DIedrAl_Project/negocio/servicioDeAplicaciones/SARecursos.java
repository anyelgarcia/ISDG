package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.io.IOException;
import java.util.Set;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.calendario.SesionProgramada;
import DIedrAl_Project.negocio.recursos.*;

public interface SARecursos {
	
	
	public void addRecurso(Recurso rec) throws AccessException, IOException;

	public void removeRecurso(Recurso rec) throws AccessException;

	public void addActividad(Actividad act) throws AccessException;

	public void removeActividad(Actividad act) throws AccessException;

	public void addSesion(Sesion ses) throws AccessException;

	public void removeSesion(Sesion ses) throws AccessException;
	
	public void addSesionProgramada(SesionProgramada sesion) throws AccessException;
	
	public void removeSesionProgramada(SesionProgramada sesion) throws AccessException;

	public ArrayRecursos filtrarRecursosPorNombre(String nombre);

	public ArrayActividades filtrarActividadPorNombre(String nombre);

	public ArraySesiones filtrarSesionPorNombre(String nombre);

	public ArrayRecursos filtrarRecursoPorEtiqueta(Set<String> filtros);

	public ArrayActividades filtrarActividadPorEtiqueta(Set<String> filtros);

	public ArraySesiones filtrarSesionPorEtiqueta(Set<String> filtros);

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
	
	public ArraySesionesProgramadas filtrarSesionProgramadaPorNifPaciente(String nif);
	
	public ArraySesionesProgramadas filtrarSesionProgramadaPorNifTerapeuta(String nif);

	public ArraySesiones getSesiones();

	public ArrayActividades getActividades();

	public ArrayRecursos getRecursos();
	
	public ArraySesionesProgramadas getSesionesProgramadas(Fecha fecha);
	
	public void updateSesion(Sesion ses) throws AccessException;
	
	public void updateActividad(Actividad act) throws AccessException;
	
	public void updateRecurso(Recurso rec) throws AccessException;
	
	public void updateSesionProgramada(SesionProgramada sesion) throws AccessException;

	

}
