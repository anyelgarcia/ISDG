package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.util.Set;

import DIedrAl_Project.negocio.recursos.*;

//TODO: HAY QUE HACER filtrarRango y sus amigos una para cada uno.

//NO FUNCIONA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! (TODAVÍA)
public interface SARecursos {
	public void addRecurso(Recurso rec);

	public void removeRecurso(Recurso rec);

	public void addActividad(Actividad act);

	public void removeActividad(Actividad act);

	public void addSesion(Sesion ses);

	public void removeSesion(Sesion ses);

	public Set<Etiquetable> filtrarNombre(String nombre, EnumEtiquetable op);

	public Set<Etiquetable> filtrarEtiqueta(Set<String> filtros, EnumEtiquetable op);

	public ArrayProgramables<Programable> filtrarRango(Integer min, Integer max, EnumEtiquetable op);

	public ArrayProgramables<Programable> filtrarDesde(Integer dur, EnumEtiquetable op);

	public ArrayProgramables<Programable> filtrarHasta(Integer dur, EnumEtiquetable op);

	public ArrayProgramables<Programable> filtrarDestinatarios(Set<String> dest, EnumEtiquetable op);

	public ArrayActividades filtrarRango(Dificultad min, Dificultad max);
	
	public ArrayActividades filtrarDesde(Dificultad dif);
	
	public ArrayActividades filtrarHasta(Dificultad dif);

}
