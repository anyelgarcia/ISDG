package DIedrAl_Project.negocio.recursos;

import java.util.*;

public abstract class Programable extends Etiquetable {
	private int duracion;

	private Set<String> destinatarios;

	protected Set<Etiquetable> asociados;

	public Programable(String name) {
		super(name);
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
