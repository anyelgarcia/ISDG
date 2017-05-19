package DIedrAl_Project.negocio.pacientes;

import java.util.ArrayList;
import java.util.List;

import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.Terapeuta;
import DIedrAl_Project.negocio.administracion.Usuario;

public class Paciente extends Usuario {
    private String perfil;

    private List<Nota> nota = new ArrayList<Nota> ();

    private List<Informe> informes = new ArrayList<Informe> ();

    private List<Terapeuta> terapeuta = new ArrayList<Terapeuta> ();

    private Centro centro;

    private DatosPaciente datosPaciente;

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

    String getPerfil() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.perfil;
    }

    void setPerfil(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.perfil = value;
    }

    Centro getCentro() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.centro;
    }

    void setCentro(Centro value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.centro = value;
    }

}
