package DIedrAl_Project.negocio.calendario;

import java.util.List;
import java.util.function.Predicate;

import DIedrAl_Project.negocio.administracion.Terapeuta;

class FiltroTerapeuta<T> implements Predicate<T>{

    private List<Terapeuta> terapeutas;
	
	public FiltroTerapeuta(List<Terapeuta> terapeutas){
		for(Terapeuta t : terapeutas){
			this.terapeutas.add(t);
		}
	}
	
	public FiltroTerapeuta(Terapeuta terapeuta){
		terapeutas.add(terapeuta);
	}

	public boolean test(T var){
		if(var instanceof SesionProgramada)
			if((((SesionProgramada) var).getTerapeuta()).containsAll(terapeutas))
						return true;
		return false;
	}
}  