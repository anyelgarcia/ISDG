package DIedrAl_Project.negocio.recursos;

import java.util.Set;


public abstract class Etiquetable {
	
	/**
	 * Etiquetas asociadas al objeto
	 */
    protected Set<String> arrayEtiquetas;

    protected String nombre;

    protected Integer id;

    /**
     * @param etiqueta etiqueta a comprobar
     * @return true si el objeto tiene asociada la etiqueta
     */
    public boolean ContieneEtiqueta(String etiqueta) {
    	return arrayEtiquetas.contains(etiqueta);
    }

    public Set<String> getEtiquetas() {
        return this.arrayEtiquetas;
    }

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
    	this.arrayEtiquetas.add(etiqueta);
    }

}
