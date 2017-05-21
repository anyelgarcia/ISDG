package DIedrAl_Project.negocio.pacientes;

import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.calendario.Fecha;

public class Paciente extends Persona {
   
	DatosPaciente datos;
	
    public Paciente(String nombre, String apellido1, String apellido2) {
		super(nombre, apellido1, apellido2);
	}
    
    public Paciente(String nombre, String apellido1, String apellido2, String lesion, Fecha fechaLesion, String ... aficiones) {
		super(nombre, apellido1, apellido2);
		datos = new DatosPaciente(lesion, fechaLesion, aficiones);
	}

	public void addInforme(Informe Informe) {
    }

    public void eliminarInforme(Informe Informe) {
    }

    public void modificarInforme(Informe informe) {
    }

    public void addNota(Nota nota) {
    }

    public void eliminarNota(Nota nota) {
    }

    public void modificarNota(Nota nota) {
    }

    public void editarPerfil() {
    }

    public void editarDatos() {
    }

    
}
