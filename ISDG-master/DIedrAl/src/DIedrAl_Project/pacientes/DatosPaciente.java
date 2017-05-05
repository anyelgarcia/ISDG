package DIedrAl_Project.pacientes;

import DIedrAl_Project.calendario.Fecha;


public class DatosPaciente {
    private String estadocivil;

    private String datosfamiliares;

    private String lesion;

    private Fecha fechalesion;

    String getEstadocivil() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.estadocivil;
    }

    void setEstadocivil(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.estadocivil = value;
    }

    String getDatosfamiliares() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.datosfamiliares;
    }

    void setDatosfamiliares(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.datosfamiliares = value;
    }

    String getLesion() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.lesion;
    }

    void setLesion(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.lesion = value;
    }

    void setFechalesion(Fecha value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.fechalesion = value;
    }

}
