package DIedrAl_Project.negocio.calendario;

import java.util.ArrayList;
import java.util.List;

import DIedrAl_Project.negocio.administracion.Terapeuta;
import DIedrAl_Project.negocio.pacientes.Nota;
import DIedrAl_Project.negocio.pacientes.Paciente;
import DIedrAl_Project.negocio.recursos.Sesion;

//ACTUALIZARMODELIO
public class SesionProgramada extends Sesion{
    private List<Nota> nota = new ArrayList<Nota> ();

    private List<Paciente> pacientes = new ArrayList<Paciente> ();

    private List<Terapeuta> terapeutas = new ArrayList<Terapeuta> ();

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
    
    public List<Terapeuta> getTerapeuta(){
    	return terapeutas;
    }
    
    public List<Paciente> getPaciente(){
    	return pacientes;
    }
    
    public int getMes(){
    	return fecha.getMes();
    }
    
    public int getAnyo(){
    	return fecha.getAnyo();
    }
    
    public Sesion getSesion(){
    	return sesion;
    }

}
