package DIedrAl_Project.negocio.calendario;

import java.util.List;
import java.util.function.Predicate;

import DIedrAl_Project.negocio.pacientes.Paciente;

class FiltroPaciente<T> implements Predicate<T>{

    private List<Paciente> pacientes;
	
	public FiltroPaciente(List<Paciente> pacientes){
		for(Paciente t : pacientes){
			this.pacientes.add(t);
		}
	}
	
	public FiltroPaciente(Paciente paciente){
		pacientes.add(paciente);
	}

	public boolean test(T var){
		if(var instanceof SesionProgramada)
			if((((SesionProgramada) var).getPaciente()).containsAll(pacientes))
						return true;
		return false;
	}
}  