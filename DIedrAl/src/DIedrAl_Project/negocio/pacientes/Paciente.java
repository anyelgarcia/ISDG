package DIedrAl_Project.negocio.pacientes;

import java.util.ArrayList;
import java.util.List;
import DIedrAl_Project.negocio.administracion.Centro;
import DIedrAl_Project.negocio.administracion.Terapeuta;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.administracion.Persona;
import DIedrAl_Project.negocio.calendario.Fecha;

	
public class Paciente extends Persona{

    private List<Nota> nota = new ArrayList<Nota> ();

    private List<Informe> informes = new ArrayList<Informe> ();

    private List<Terapeuta> terapeuta = new ArrayList<Terapeuta> ();

    private Centro centro;

    private String perfil;
  
    private DatosPaciente datosPaciente;


    public Paciente(String nombre, String apellido1, String apellido2) {
		  super(nombre, apellido1, apellido2);
	  }
    
    public Paciente(String nombre, String apellido1, String apellido2, String lesion, Fecha fechaLesion, String ... aficiones) {
		  super(nombre, apellido1, apellido2);
		  datosPaciente = new DatosPaciente(lesion, fechaLesion, aficiones);
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

    String getPerfil() {
        return this.perfil;
    }

    void setPerfil(String value) {
        this.perfil = value;
    }

    Centro getCentro() {
        return this.centro;
    }

    void setCentro(Centro value) {
        this.centro = value;
    }
}
