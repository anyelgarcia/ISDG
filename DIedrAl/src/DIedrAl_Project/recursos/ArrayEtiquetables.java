package DIedrAl_Project.recursos;

import java.util.*;

public abstract class ArrayEtiquetables<T extends Etiquetable> {

	protected HashSet<T> etiquetables;

	public HashSet<T> filtrarEtiqueta(Set<String> filtros) {

		HashSet<T> aux = new HashSet<T>();
		for (T x : etiquetables) {
			if(x.getEtiquetas().containsAll(filtros)){
				aux.add(x);
			}
		}
		return aux;
	}

	public HashSet<T> filtrarNombre(String nombre) {

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

}
