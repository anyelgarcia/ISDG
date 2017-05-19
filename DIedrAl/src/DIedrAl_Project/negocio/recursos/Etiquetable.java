package DIedrAl_Project.negocio.recursos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public abstract class Etiquetable {
	
	/**
	 * Etiquetas asociadas al objeto
	 */
    protected Set<String> etiquetas;

    protected String nombre;
    
    protected String descripcion;


	protected Integer id;

    public Etiquetable(String name) {
		nombre=name;
		this.etiquetas=new TreeSet<String>();
	}
    public Etiquetable(String name, String[] etiquetas) {
		nombre=name;
		this.etiquetas=new TreeSet<String>();
		for(String s:etiquetas){
			addEtiqueta(s);
		}
	}
    public Etiquetable(String name, String[] etiquetas, String desc) {
		nombre=name;
		this.etiquetas=new TreeSet<String>();
		for(String s:etiquetas){
			addEtiqueta(s);
		}
		descripcion = desc;
	}

	/**
     * @param etiqueta etiqueta a comprobar
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

    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }
    
    public void addEtiqueta(String etiqueta){
    	this.etiquetas.add(etiqueta);
    }
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
