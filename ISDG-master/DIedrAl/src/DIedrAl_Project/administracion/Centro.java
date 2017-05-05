package DIedrAl_Project.administracion;

import java.util.ArrayList;
import java.util.List;

import DIedrAl_Project.calendario.Calendario;
import DIedrAl_Project.pacientes.Paciente;

public class Centro {
    private String nombre;

    private Administrador administrador;

    private Calendario calendario;

    private List<Paciente> pacientes = new ArrayList<Paciente> ();

    private List<Terapeuta> terapeutas = new ArrayList<Terapeuta> ();

    private Organizacion organizacion;

    public void nuevoTerapeuta(Terapeuta ter) {
    }

    public void nuevoPaciente(Paciente pac1) {
    }

    public void eliminarPaciente(String pac) {
    }

    public void eliminarTerapeuta(String ter) {
    }

    public void modificarTerapeuta(String ter, Terapeuta nuevaInfo) {
    }

    public void ligarPaciente(Paciente pac, Terapeuta ter) {
    }

    public void desligarPaciente(Terapeuta ter, Paciente pac) {
    }

    public void mostrarTerapeutas() {
    }

    public void mostrarPacientes() {
    }

    public void modificarPaciente(Paciente nuevo, Paciente antiguo) {
    }

    String getNombre() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nombre;
    }

    void setNombre(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nombre = value;
    }

    Organizacion getOrganizacion() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.organizacion;
    }

    void setOrganizacion(Organizacion value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.organizacion = value;
    }

}
