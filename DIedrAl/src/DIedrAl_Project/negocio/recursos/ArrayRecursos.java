package DIedrAl_Project.negocio.recursos;

import java.util.HashSet;


public class ArrayRecursos extends ArrayEtiquetables<Recurso> {
	
	public ArrayRecursos(){
		super();
	}
	
	public ArrayRecursos(HashSet<Recurso> rec) {
		super(rec);
	}
	
    public HashSet<Recurso> filtrarExtension(String ext) {
    	HashSet<Recurso> aux = new HashSet<Recurso>();
    	for(Recurso rec : this.etiquetables){
    		if(rec.getExtension().equals(ext)){
    			aux.add(rec);
    		}
    	}
    	return aux;
    }

}
