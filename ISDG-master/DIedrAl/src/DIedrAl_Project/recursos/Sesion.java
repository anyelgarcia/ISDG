package DIedrAl_Project.recursos;

import java.util.ArrayList;
import java.util.List;

public class Sesion extends Etiquetable {
    private int duracion;

    private String[] destinatarios;

    private List<Actividad> actividad = new ArrayList<Actividad> ();

    private List<Recurso> recurso = new ArrayList<Recurso> ();

    int getDuracion() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.duracion;
    }

    void setDuracion(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.duracion = value;
    }

    String[] getDestinatarios() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.destinatarios;
    }

    void setDestinatarios(String[] value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.destinatarios = value;
    }

    public void addRecurso(Recurso rec) {
    }

    public void removeActividad(Actividad act) {
    }

    public void addActividad(Actividad act) {
    }

    public void removeRecurso(Recurso rec) {
    }

}
