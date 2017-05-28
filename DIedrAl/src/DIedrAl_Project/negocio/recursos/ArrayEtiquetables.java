package DIedrAl_Project.negocio.recursos;

import java.util.*;


public abstract class ArrayEtiquetables<T extends Etiquetable> implements Iterable<T> {

	protected HashSet<T> etiquetables;

	public ArrayEtiquetables() {
		etiquetables = new HashSet<T>();
	}

	public ArrayEtiquetables(HashSet<T> etique) {
		etiquetables = etique;
	}
	
	public int size(){
		return etiquetables.size();
	}
	
	public boolean empty(){
		return etiquetables.isEmpty();
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
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for(T t: etiquetables){
			sb.append(t.toString()+"\n---\n");
		}
		return sb.toString();
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
