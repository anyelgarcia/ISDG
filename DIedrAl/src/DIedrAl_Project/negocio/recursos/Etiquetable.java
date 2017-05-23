package DIedrAl_Project.negocio.recursos;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.Set;
import java.util.TreeSet;

import DIedrAl_Project.negocio.*;

public abstract class Etiquetable implements ObjetoAlmacenable {

	/**
	 * Etiquetas asociadas al objeto
	 */
	protected Set<String> etiquetas;

	protected String nombre;

	protected String descripcion;

	protected String id;

	public Etiquetable(String name) {
		nombre = name;
		this.etiquetas = new TreeSet<String>();
	}

	public Etiquetable(String name, String... etiquetas) {
		nombre = name;
		this.etiquetas = new TreeSet<String>();
		for (String s : etiquetas) {
			this.etiquetas.add(s);
		}
	}

	public Etiquetable(String name, String desc, String... etiquetas) {
		nombre = name;
		this.etiquetas = new TreeSet<String>();
		for (String s : etiquetas) {
			this.etiquetas.add(s);
		}
		descripcion = desc;
	}

	/**
	 * @param etiqueta
	 *            etiqueta a comprobar
	 * @return true si el objeto tiene asociada la etiqueta
	 */
	public boolean ContieneEtiqueta(String etiqueta) {
		return this.getEtiquetas().contains(etiqueta);
	}

	public abstract Set<String> getEtiquetas();

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
	
	public void removeEtiqueta(String eti) throws NotBoundException{
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

}
