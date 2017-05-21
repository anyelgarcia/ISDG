package DIedrAl_Project.negocio.pacientes;

import DIedrAl_Project.negocio.administracion.Terapeuta;
import DIedrAl_Project.negocio.recursos.Sesion;


public class Informe {
    private String texto;

    private Sesion sesion;

    private Terapeuta autor;

    public void modificar() {
    }

    Terapeuta getAutor() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.autor;
    }

    void setAutor(Terapeuta value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.autor = value;
    }

}
