package DIedrAl_Project.negocio.recursos;

import java.util.*;

public abstract class Programable extends Etiquetable {
	private int duracion;

	private Set<String> destinatarios;

	protected Set<Etiquetable> asociados;

	public Programable(String name) {
		super(name);
		this.destinatarios = new HashSet<String>();
		this.asociados = new HashSet<Etiquetable>();
	}

	public Programable(String name, String... etiquetas) {
		super(name, etiquetas);
		this.destinatarios = new HashSet<String>();
		this.asociados = new HashSet<Etiquetable>();
	}
	
	public Programable(String name, int duracion, String descripcion, String desarrollo, String variaciones, String... etiquetas) {
		super(name, descripcion, etiquetas);
		this.duracion = duracion;
		this.desarrollo = desarrollo;
		this.variaciones = variaciones;
		
		this.destinatarios = new HashSet<String>();
		this.asociados = new HashSet<Etiquetable>();
	}
	public Set<String> getEtiquetas() {
		Set<String> aux = new HashSet<String>();
		aux.addAll(etiquetas);
		for (Etiquetable e : asociados) {
			aux.addAll(e.getEtiquetas());
		}
		return aux;
	}

	public void addRecurso(Recurso rec) {
		asociados.add(rec);
	}

	public void removeRecurso(Recurso rec) {
		asociados.remove(rec);
	}
	public void removeActividad(Actividad act) {
    	asociados.remove(act);
    }

    public void addActividad(Actividad act) {
    	asociados.add(act);
    }

	public Set<String> getDestinatarios() {
		return this.destinatarios;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
