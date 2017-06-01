package DIedrAl_Project.negocio.recursos;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.*;

public abstract class Programable extends Etiquetable {

	private static final long serialVersionUID = 7766081036213708004L;

	protected int duracion;

	protected HashSet<String> destinatarios;

	protected HashSet<Etiquetable> asociados;

	protected String desarrollo;

	protected String variaciones;

	public Programable(String name) {
		super(name);
		destinatarios = new HashSet<String>();
		asociados = new HashSet<Etiquetable>();
	}

	public Programable(String name, String... etiquetas) {
		super(name, etiquetas);
		destinatarios = new HashSet<String>();
		asociados = new HashSet<Etiquetable>();
	}

	public HashSet<Etiquetable> getAsociados() {
		return asociados;
	}

	public TreeSet<String> getEtiquetas() {
		TreeSet<String> aux = new TreeSet<String>();
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
		if (act == this) {
			throw new AlreadyBoundException(
					"No se puede a�adir una actividad a s� misma");
		} else if (asociados.contains(act)) {
			throw new AlreadyBoundException("Actividad " + act
					+ " ya existente");
		}

		else {
			asociados.add(act);
		}
	}

	public HashSet<String> getDestinatarios() {
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		StringBuilder sbdes = new StringBuilder();
		for(String s: destinatarios){
			sbdes.append(s+" ");
		}
		sb.append(super.toString() + "\nDuracion: " + duracion
				+ "\nDestinatarios: " + sbdes.toString() + "\nSu desarrollo es: "
				+ desarrollo + "\nSus variaciones son: " + variaciones);
		sb.append("\nContiene a:");
		for (Etiquetable e : asociados) {
			sb.append("\n" + e.toString());
		}
		return sb.toString();
	}
	
	public void igualarCampos(Programable that){
		super.igualarCampos(that);
		this.duracion = that.duracion;
		this.destinatarios = that.destinatarios;
		this.asociados = that.asociados;
		this.desarrollo = that.desarrollo;
		this.variaciones = that.variaciones;
	}

}
