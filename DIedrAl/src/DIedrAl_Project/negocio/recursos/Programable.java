package DIedrAl_Project.negocio.recursos;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.*;

public abstract class Programable extends Etiquetable {
	protected int duracion;

	protected Set<String> destinatarios;

	protected Set<Etiquetable> asociados;

	protected String desarrollo;

	protected String variaciones;

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

	public void addRecurso(Recurso rec) throws AlreadyBoundException {
		if (asociados.contains(rec)) {
			throw new AlreadyBoundException("Recurso " + rec + " ya existente");
		} else {
			asociados.add(rec);
		}

	}

	public void removeRecurso(Recurso rec) throws NotBoundException {
		if (!asociados.contains(rec)) {
			throw new NotBoundException("Recurso " + rec + " no existente");
		} else {
			asociados.remove(rec);
		}
	}

	public void removeActividad(Actividad act) throws NotBoundException {
		if (!asociados.contains(act)) {
			throw new NotBoundException("Actividad " + act + " no existente");
		} else {
			asociados.remove(act);
		}

	}

	public void addActividad(Actividad act) throws AlreadyBoundException {
		if(asociados.contains(act)){
			throw new AlreadyBoundException("Actividad "+ act+" ya existente");
		}
		else{
			asociados.add(act);
		}
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

	public void addDestinatario(String des) {
		destinatarios.add(des);
	}

	public void removeDestinatario(String des) {
		destinatarios.remove(des);
	}

	public String getDesarrollo() {
		return desarrollo;
	}

	public void setDesarrollo(String desarrollo) {
		this.desarrollo = desarrollo;
	}

	public String getVariaciones() {
		return variaciones;
	}

	public void setVariaciones(String variaciones) {
		this.variaciones = variaciones;
	}

}
