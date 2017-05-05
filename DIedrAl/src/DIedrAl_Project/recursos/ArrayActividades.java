package DIedrAl_Project.recursos;

import java.util.Set;

/*
 * TODO CAMBIAR EL TIPO DE ESTAS FUNCIONES EN PUTO MODELIO
 */
public class ArrayActividades extends ArrayEtiquetables<Actividad> {

	public ArrayActividades filtrarRango(Integer min, Integer max) {
		return filtrarDur(min, max);
	}

	public ArrayActividades filtrarDesde(Integer dur) {
		return filtrarDur(dur, Integer.MAX_VALUE);

	}

	public ArrayActividades filtrarHasta(Integer dur) {
		return filtrarDur(Integer.MIN_VALUE, dur);
	}

	public ArrayActividades filtrarRango(Dificultad min, Dificultad max) {
		return filtrarDif(min, max);
	}

	public ArrayActividades filtrarDesde(Dificultad dif) {
		return filtrarDif(dif, Dificultad.MUY_DIFICIL);

	}

	public ArrayActividades filtrarHasta(Dificultad dif) {
		return filtrarDif(Dificultad.MUY_FACIL, dif);
	}
	/*
	public ArrayActividades filtrarEtiquetas(Set<String> eti) {
		ArrayActividades aux = new ArrayActividades();
		for (Actividad x : this.etiquetables) {
			if (x.g) {
				aux.etiquetables.add(x);
			}
		}
		return aux;
	}*/

	public ArrayActividades filtrarDestinatarios(Set<String> dest) {
		ArrayActividades aux = new ArrayActividades();
		for (Actividad x : this.etiquetables) {
			if (x.getDestinatarios().containsAll(dest)) {
				aux.etiquetables.add(x);
			}
		}
		return aux;
	}

	private ArrayActividades filtrarDur(Integer min, Integer max) {

		ArrayActividades aux = new ArrayActividades();

		for (Actividad x : this.etiquetables) {
			if (x.getDuracion() >= min && x.getDuracion() <= max) {
				aux.etiquetables.add(x);
			}
		}
		return aux;
	}

	private ArrayActividades filtrarDif(Dificultad min, Dificultad max) {

		ArrayActividades aux = new ArrayActividades();

		for (Actividad x : this.etiquetables) {
			if (x.getDificultad().compareTo(min)>=0 
					&& x.getDificultad().compareTo(max)<=0) {
				aux.etiquetables.add(x);
			}
		}
		return aux;
	}
}
