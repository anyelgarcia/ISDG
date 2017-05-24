package DIedrAl_Project.negocio.recursos;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public abstract class ArrayEtiquetables<T extends Etiquetable> implements Iterable<T> {

	protected Set<T> etiquetables;

	public ArrayEtiquetables() {
		etiquetables = new HashSet<T>();
	}

	public ArrayEtiquetables(Set<T> etique) {
		etiquetables = etique;
	}
	
	public int size(){
		return etiquetables.size();
	}

	public Set<T> filtrarEtiqueta(Set<String> filtros) {

		HashSet<T> aux = new HashSet<T>();
		for (T x : etiquetables) {
			if (x.getEtiquetas().containsAll(filtros)) {
				aux.add(x);
			}
		}
		return aux;
	}

	public Set<T> filtrarNombre(String nombre) {

		HashSet<T> aux = new HashSet<T>();

		String nameAux;

		for (T x : etiquetables) {
			nameAux = x.getNombre().toLowerCase();
			if (nameAux.contains(nombre.toLowerCase())) {
				aux.add(x);
			}
		}

		return aux;
	}

	public void add(T elem) {
		etiquetables.add(elem);
	}

	public void erase(T elem) {
		etiquetables.remove(elem);
	}

	@Override
	public Iterator<T> iterator() {
		return new IteratorEtiquetable<T>();
	}

	protected class IteratorEtiquetable<S extends Etiquetable> 
	implements Iterator<S> {

		protected Iterator<S> it;

		public IteratorEtiquetable() {
			//TODO xq el cast? NPI
			it = (Iterator<S>) etiquetables.iterator();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public S next() {
			return it.next();
		}

	}

}
