package DIedrAl_Project.negocio.recursos;

import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import DIedrAl_Project.negocio.*;

public abstract class Etiquetable implements ObjetoAlmacenable, Serializable {

	private static final long serialVersionUID = 4574224692338847257L;

	/**
	 * Etiquetas asociadas al objeto
	 */
	protected TreeSet<String> etiquetas;

	protected String nombre;

	protected String descripcion;

	protected final String id;

	public Etiquetable(String name) {
		nombre = name;
		this.etiquetas = new TreeSet<String>();
		id = UUID.randomUUID().toString();
	}

	public Etiquetable(String name, String... etiquetas) {
		nombre = name;
		this.etiquetas = new TreeSet<String>();
		for (String s : etiquetas) {
			this.etiquetas.add(s);
		}
		id = UUID.randomUUID().toString();
	}

	public Etiquetable(String name, String desc, String... etiquetas) {
		nombre = name;
		this.etiquetas = new TreeSet<String>();
		for (String s : etiquetas) {
			this.etiquetas.add(s);
		}
		descripcion = desc;
		id = UUID.randomUUID().toString();
	}

	/**
	 * @param etiqueta
	 *            etiqueta a comprobar
	 * @return true si el objeto tiene asociada la etiqueta
	 */
	public boolean contains(String etiqueta) {
		return this.getEtiquetas().contains(etiqueta);
	}

	public abstract Set<String> getEtiquetas();
	
	public void igualarCampos(Etiquetable that){
		this.etiquetas = that.etiquetas;
		this.descripcion  = that.descripcion;
		this.nombre = that.nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String value) {
		this.nombre = value;
	}

	public void addEtiqueta(String eti) throws AlreadyBoundException {
		if (etiquetas.contains(eti)) {
			throw new AlreadyBoundException("Etiqueta " + eti + " ya existente");
		} else {
			this.etiquetas.add(eti);
		}
	}

	public void removeEtiqueta(String eti) throws NotBoundException {
		if (!etiquetas.contains(eti)) {
			throw new NotBoundException("Etiqueta " + eti + " no existente");
		} else {
			this.etiquetas.remove(eti);
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nombre+"\n");
		sb.append(this.descripcion+"\n");
		sb.append("Lista de etiquetas:\n");
		for(String e:etiquetas){
			sb.append(e+" ");
		}
		return sb.toString();
	}
	
}
