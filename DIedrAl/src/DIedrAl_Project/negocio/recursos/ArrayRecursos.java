package DIedrAl_Project.negocio.recursos;

import java.util.HashSet;


public class ArrayRecursos extends ArrayEtiquetables<Recurso> {
	
	public ArrayRecursos(){
		super();
	}
	
	public ArrayRecursos(HashSet<Recurso> rec) {
		super(rec);
	}
	
    public ArrayRecursos filtrarExtension(String ext) {
    	ArrayRecursos aux = new ArrayRecursos();
    	for(Recurso rec : this.etiquetables){
    		if(rec.getExtension().equals(ext)){
    			aux.add(rec);
    		}
    	}
    	return aux;
    }

	@Override
	protected ArrayEtiquetables<Recurso> createNew() {
		return new ArrayRecursos();
	}

}
