package DIedrAl_Project.negocio.recursos;


/*
 * TODO CAMBIAR EL TIPO DE ESTAS FUNCIONES EN PUTO MODELIO
 */
public class ArrayActividades extends ArrayEtiquetables<Actividad> {


	public ArrayActividades filtrarRango(Dificultad min, Dificultad max) {
		return filtrarDif(min, max);
	}

	public ArrayActividades filtrarDesde(Dificultad dif) {
		return filtrarDif(dif, Dificultad.ALTA);

	}

	public ArrayActividades filtrarHasta(Dificultad dif) {
		return filtrarDif(Dificultad.BAJA, dif);
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
