package DIedrAl_Project.negocio.recursos;

import java.util.*;

import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.calendario.SesionProgramada;

public class ArraySesionesProgramadas extends ArrayProgramables<SesionProgramada> {
	
	public ArraySesionesProgramadas(){
		super();
	}
	
	public ArraySesionesProgramadas(HashSet<SesionProgramada> ses) {
		super(ses);
	}
	@Override
	protected ArrayProgramables<SesionProgramada> createNew() {
		return new ArraySesionesProgramadas();
	}
	
	public ArraySesionesProgramadas filtrarNifPaciente(String nif){

		ArraySesionesProgramadas aux = new ArraySesionesProgramadas();
		for (SesionProgramada x : this.etiquetables) {
			if (x.getPacientes().contains(nif)) {
				aux.etiquetables.add(x);
			}
		}
		return aux;
	}
	
	public ArraySesionesProgramadas filtrarNifTerapeuta(String nif){

		ArraySesionesProgramadas aux = new ArraySesionesProgramadas();
		for (SesionProgramada x : this.etiquetables) {
			if (x.getTerapeutas().contains(nif)) {
				aux.etiquetables.add(x);
			}
		}
		return aux;
	}
	
	public ArraySesionesProgramadas filtrarFecha(Fecha fecha){

		ArraySesionesProgramadas aux = new ArraySesionesProgramadas();
		for (SesionProgramada x : this.etiquetables) {
			if (x.getMonth().equals(fecha.getMes()) &&
					x.getYear() == fecha.getAño()  &&
					x.getDay() == fecha.getDia()) {
				
				aux.etiquetables.add(x);
			}
		}
		return aux;
	}


}