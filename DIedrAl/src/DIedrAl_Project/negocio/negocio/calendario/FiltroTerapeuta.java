package DIedrAl_Project.negocio.calendario;

import java.util.List;
import java.util.function.Predicate;

import DIedrAl_Project.negocio.administracion.Usuario;


class FiltroTerapeuta<T> implements Predicate<T>{

    private List<Usuario> terapeutas;
	
	public FiltroTerapeuta(List<Usuario> terapeutas){
		for(Usuario t : terapeutas){
			this.terapeutas.add(t);
		}
	}
	
	public FiltroTerapeuta(Usuario terapeuta){
		terapeutas.add(terapeuta);
	}

	public boolean test(T var){
		if(var instanceof SesionProgramada)
			//if((((SesionProgramada) var).getTerapeuta()).containsAll(terapeutas))
						return true;
		return false;
	}
}  