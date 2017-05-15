package DIedrAl_Project.negocio.recursos;

import java.util.HashSet;
import java.util.Set;


public class ArrayRecursos extends ArrayEtiquetables<Recurso> {
    public Set<Recurso> filtrarExtension(String ext) {
    	Set<Recurso> aux = new HashSet<Recurso>();
    	for(Recurso rec : this.etiquetables){
    		if(rec.getExtension().equals(ext)){
    			aux.add(rec);
    		}
    	}
    	return aux;
    }

}
