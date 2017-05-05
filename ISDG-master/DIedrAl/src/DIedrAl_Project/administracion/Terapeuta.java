package DIedrAl_Project.administracion;

import java.util.ArrayList;
import java.util.List;

import DIedrAl_Project.pacientes.Direccion;
import DIedrAl_Project.pacientes.Informe;
import DIedrAl_Project.pacientes.Paciente;

public class Terapeuta extends Usuario {
	
    public Terapeuta(String id, String email, int tlf, Direccion dir) {
		super(id, email, tlf, dir);
	}

	private List<Paciente> pacientesAsociados = new ArrayList<Paciente> ();

    private List<Informe> informes = new ArrayList<Informe> ();

    public void mostrar() {
    }

    public void mostrarPacientesAsociados() {
    }

    public void modificar(Terapeuta nuevo) {
    }
    
    public boolean addPaciente(Paciente p){
    	boolean ok = pacientesAsociados.contains(p);
    	if(ok) pacientesAsociados.add(p);
    	return ok;
    }

    public boolean removePaciente(Paciente p){
    	boolean ok = pacientesAsociados.contains(p);
    	if(ok) pacientesAsociados.remove(p);
    	return ok;
    }
    
    public boolean addInforme(Informe i){
    	boolean ok = informes.contains(i);
    	if(ok) informes.add(i);
    	return ok;
    }
    
    List<Paciente> getPacientesAsociados() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.pacientesAsociados;
    }

    void setPacientesAsociados(List<Paciente> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pacientesAsociados = value;
    }
   
}
