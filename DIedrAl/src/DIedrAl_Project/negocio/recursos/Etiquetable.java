package DIedrAl_Project.negocio.recursos;

import java.util.Set;


public abstract class Etiquetable {
	
	/**
	 * Etiquetas asociadas al objeto
	 */
    protected Set<String> etiquetas;

    protected String nombre;

    protected Integer id;

    public Etiquetable(String name) {
		nombre=name;
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
    
    public void insertarEtiqueta(String etiqueta){
    	this.etiquetas.add(etiqueta);
    }

}
