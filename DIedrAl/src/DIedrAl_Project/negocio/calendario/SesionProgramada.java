package DIedrAl_Project.negocio.calendario;

import java.io.Serializable;
import java.util.*;

import DIedrAl_Project.negocio.pacientes.*;
import DIedrAl_Project.negocio.recursos.*;

public class SesionProgramada extends Sesion implements Serializable {

	private static final long serialVersionUID = -138011061952205162L;

	private Set<Nota> notas;

	private Set<String> nifsPacientes;

	private Set<String> nifsTerapeutas;

	private Fecha fecha;

	public SesionProgramada(String name, Fecha fecha) {
		super(name);
		this.fecha = fecha;
		nifsTerapeutas = new TreeSet<String>();
		nifsPacientes = new TreeSet<String>();
		notas = new HashSet<Nota>();
	}
	
	public SesionProgramada(String name, Fecha fecha, String ...etiquetas) {
		super(name, etiquetas);
		this.fecha = fecha;
		nifsTerapeutas = new TreeSet<String>();
		nifsPacientes = new TreeSet<String>();
		notas = new HashSet<Nota>();
	}

	public void addNota(Nota nota) {
		this.notas.add(nota);
	}

	public void eliminarNota(Nota nota) {
		this.notas.remove(nota);
	}

	public void addTerapeuta(String nif) {
		this.nifsTerapeutas.add(nif);
	}

	public void removeTerapeuta(String nif) {
		this.nifsTerapeutas.remove(nif);
	}
	
	public void addPaciente(String nif) {
		this.nifsPacientes.add(nif);
	}

	public void removePaciente(String nif) {
		this.nifsPacientes.remove(nif);
	}

	public Set<String> getTerapeutas() {
		return nifsTerapeutas;
	}

	public Set<String> getPacientes() {
		return nifsPacientes;
	}

	public int getDay(){
		return fecha.getDia();
	}
	
	public String getMonth() {
		return fecha.getMes();
	}
	
	public int getMonthIndex() {
		return fecha.getMesIndex();
	}

	public int getYear() {
		return fecha.getAño();
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public String toString(){
		String res = getNombre();
		res+=" - Pacientes: ";
		for(String pac: nifsPacientes)
			res+= pac + ", ";
		return res;
	}

	
	

}
