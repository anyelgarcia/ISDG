package DIedrAl_Project.negocio.calendario;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.pacientes.*;
import DIedrAl_Project.negocio.recursos.*;

public class SesionProgramada {

	private Set<Nota> notas;

	private Set<Paciente> pacientes;

	private Set<Terapeuta> terapeutas;

	private Sesion modeloSesion;

	private GregorianCalendar fecha;


	public SesionProgramada(GregorianCalendar fecha) {
		this.fecha = fecha;
		terapeutas = new TreeSet<Terapeuta>();
		pacientes = new TreeSet<Paciente>();
		notas = new TreeSet<Nota>();
	}

	public void addNota(Nota nota) {
		this.notas.add(nota);
	}

	public void eliminarNota(Nota nota) {
		this.notas.remove(nota);
	}

	public void addTerapeuta(Terapeuta terapeuta) {
		this.terapeutas.add(terapeuta);
	}

	public void removeTerapeuta(Terapeuta terapeuta) {
		this.terapeutas.remove(terapeuta);
	}
	public void addPaciente(Paciente paciente) {
		this.pacientes.add(paciente);
	}

	public void removePaciente(Paciente paciente) {
		this.pacientes.remove(paciente);
	}

	public Set<Terapeuta> getTerapeutas() {
		return terapeutas;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}

	// USO DEL PATRÓN FACHADA
	public int getDay(){
		return fecha.get(GregorianCalendar.DATE);
	}
	
	public int getMonth() {
		return fecha.get(GregorianCalendar.MONTH);
	}

	public int getYear() {
		return fecha.get(GregorianCalendar.YEAR);
	}

	public Sesion getModeloSesion() {
		return modeloSesion;
	}
	
	public void setModeloSesion(Sesion modeloSesion) {
		this.modeloSesion = modeloSesion;
	}
	
	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

}
