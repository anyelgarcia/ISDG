package DIedrAl_Project.negocio.recursos;

import java.util.*;

public abstract class ArrayProgramables<T extends Programable> extends
		ArrayEtiquetables<T>{

	public ArrayProgramables(){
		super();
	}
	
	public ArrayProgramables(HashSet<T> progra) {
		super(progra);
	}
	
	public ArrayProgramables<T> filtrarRango(Integer min, Integer max) {
		return filtrarDur(min, max);
	}

	public ArrayProgramables<T> filtrarDesde(Integer dur) {
		return filtrarDur(dur, Integer.MAX_VALUE);

	}
	
	public ArrayProgramables<T> filtrarHasta(Integer dur) {
		return filtrarDur(Integer.MIN_VALUE, dur);
	}

	
	public ArrayProgramables<T> filtrarDestinatarios(Set<String> dest) {
		ArrayProgramables<T> aux = createNew();
		for (T x : this.etiquetables) {
			if (x.getDestinatarios().containsAll(dest)) {
				aux.etiquetables.add(x);
			}
		}
		return aux;
	}
	

	private ArrayProgramables<T> filtrarDur(Integer min, Integer max) {

		ArrayProgramables<T> aux = createNew();

		for (T x : this.etiquetables) {
			if (min <= x.getDuracion() && x.getDuracion() <= max) {
				aux.etiquetables.add(x);
			}
		}
		return aux;
		
	}
	
	
	
	
	protected abstract ArrayProgramables<T> createNew();

}
