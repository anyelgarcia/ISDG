package DIedrAl_Project.recursos;

import java.util.Set;


public abstract class Etiquetable {
	
	/**
	 * Etiquetas asociadas al objeto
	 */
    private Set<String> arrayEtiquetas;

    private String nombre;

    private Integer id;

    /**
     * @param etiqueta etiqueta a comprobar
     * @return true si el objeto tiene asociada la etiqueta
     */
    public boolean ContieneEtiqueta(String etiqueta) {
    	return arrayEtiquetas.contains(etiqueta);
    }

    Set<String> getEtiquetas() {
        return this.arrayEtiquetas;
    }

    String getNombre() {
        return this.nombre;
    }

    void setNombre(String value) {
        this.nombre = value;
    }

    int getId() {
        return this.id;
    }

    void setId(int value) {
        this.id = value;
    }
    
    void insertarEtiqueta(String etiqueta){
    	this.arrayEtiquetas.add(etiqueta);
    }

}
