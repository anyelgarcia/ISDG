package DIedrAl_Project.administracion;

import java.util.ArrayList;
import java.util.List;

import DIedrAl_Project.pacientes.Informe;
import DIedrAl_Project.pacientes.Paciente;

public class Terapeuta extends Usuario {
    private List<Paciente> pacientesAsociados = new ArrayList<Paciente> ();

    private List<Informe> informes = new ArrayList<Informe> ();

    public void mostrar() {
    }

    public void mostrarPacientesAsociados() {
    }

    public void modificar(Terapeuta nuevo) {
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
