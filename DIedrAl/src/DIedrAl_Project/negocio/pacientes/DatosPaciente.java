package DIedrAl_Project.negocio.pacientes;

import java.util.GregorianCalendar;


public class DatosPaciente {
    private String estadocivil;

    private String datosfamiliares;

    private String lesion;

    private GregorianCalendar fechalesion;

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

	public GregorianCalendar getFechalesion() {
		return fechalesion;
	}

	public void setFechalesion(GregorianCalendar fechalesion) {
		this.fechalesion = fechalesion;
	}

  
}
