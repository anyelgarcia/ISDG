package DIedrAl_Project.negocio.calendario;

import java.time.LocalDate;
import java.util.*;

import DIedrAl_Project.negocio.administracion.*;
import DIedrAl_Project.negocio.pacientes.*;
import DIedrAl_Project.negocio.recursos.*;

public class SesionProgramada {

	private Set<Nota> notas;

	private Set<Paciente> pacientes;

	private Set<Usuario> terapeutas;

	private Sesion modeloSesion;

	private LocalDate fecha;

	public SesionProgramada(LocalDate fecha) {
		this.fecha = fecha;
		terapeutas = new TreeSet<Usuario>();
		pacientes = new TreeSet<Paciente>();
		notas = new HashSet<Nota>();
	}

	public void addNota(Nota nota) {
		this.notas.add(nota);
	}

	public void eliminarNota(Nota nota) {
		this.notas.remove(nota);
	}

	public void addTerapeuta(Usuario terapeuta) {
		this.terapeutas.add(terapeuta);
	}

	public void removeTerapeuta(Usuario terapeuta) {
		this.terapeutas.remove(terapeuta);
	}
	public void addPaciente(Paciente paciente) {
		this.pacientes.add(paciente);
	}

	public void removePaciente(Paciente paciente) {
		this.pacientes.remove(paciente);
	}

	public Set<Usuario> getTerapeutas() {
		return terapeutas;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}

	public int getDay(){
		return fecha.getDayOfMonth();
	}
	
	public int getMonth() {
		return fecha.getMonthValue();
	}

	public int getYear() {
		return fecha.getYear();
	}

	public Sesion getModeloSesion() {
		return modeloSesion;
	}
	
	public void setModeloSesion(Sesion modeloSesion) {
		this.modeloSesion = modeloSesion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	
	

}
