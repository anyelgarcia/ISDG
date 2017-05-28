package DIedrAl_Project.negocio.pacientes;

import java.util.Set;
import java.util.TreeSet;

import DIedrAl_Project.negocio.administracion.Persona;

public class Paciente extends Persona {

	private static final long serialVersionUID = -5410072833506454068L;
	
	private DatosPaciente datos;
	
	private Set<Nota> notas;

	public Paciente(String nombre, String apellido1, String apellido2, String nif) {
		super(nombre, apellido1, apellido2, nif);
		datos = new DatosPaciente();
		notas = new TreeSet<Nota>();
	}

	public void addInforme(Informe Informe) {
	}

	public void eliminarInforme(Informe Informe) {
	}

	public void addNota(Nota nota) {
		notas.add(nota);
	}

	public void eliminarNota(Nota nota) {
		notas.remove(nota);
	}

	public DatosPaciente getDatos() {
		return datos;
	}

}
