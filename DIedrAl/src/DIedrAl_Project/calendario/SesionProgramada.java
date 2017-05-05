package DIedrAl_Project.calendario;

import java.util.ArrayList;
import java.util.List;

import DIedrAl_Project.administracion.Terapeuta;
import DIedrAl_Project.pacientes.Nota;
import DIedrAl_Project.pacientes.Paciente;
import DIedrAl_Project.recursos.Sesion;

public class SesionProgramada {
    private List<Nota> nota = new ArrayList<Nota> ();

    private List<Paciente> paciente = new ArrayList<Paciente> ();

    private List<Terapeuta> terapeuta = new ArrayList<Terapeuta> ();

    private Sesion sesion;

    private Fecha fecha;

    public void clonFecha(Fecha fecha) {
    	this.fecha.setAnyo(fecha.getAnyo());
    	this.fecha.setMes(fecha.getAnyo());
    	this.fecha.setDia(fecha.getAnyo());
    	this.fecha.setHora(fecha.getHora());
    }

    public void addNota(Nota nota) {
    	this.nota.add(nota);
    }

    public void editarNota(Nota nota) {
    }

    public void eliminarNota(Nota nota) {
    }

    public void editarTerapeuta(Terapeuta terapeuta) {
    }

    public void editarPacientes(List<Paciente> pacientes) {
    }

}
