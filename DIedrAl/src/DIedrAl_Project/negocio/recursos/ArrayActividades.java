package DIedrAl_Project.negocio.recursos;

import java.util.Set;

/*
 * TODO CAMBIAR EL TIPO DE ESTAS FUNCIONES EN PUTO MODELIO
 */
public class ArrayActividades extends ArrayProgramables<Actividad> {
	

	public ArrayActividades(){
		super();
	}
	
	public ArrayActividades(Set<Actividad> act) {
		super(act);
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

	@Override
	protected ArrayActividades createNew() {
		return new ArrayActividades();
	}
}
