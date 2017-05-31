package DIedrAl_Project.negocio.pacientes;

import java.io.Serializable;
import java.util.ArrayList;

import DIedrAl_Project.negocio.calendario.Fecha;


public class DatosPaciente implements Serializable {
    private String estadocivil;

    private String datosfamiliares;

    private String lesion;

    private Fecha fechalesion;
    
    private ArrayList<String> aficiones;
    
    public DatosPaciente(){
    	aficiones = new ArrayList<String>();
    }

    public String getEstadocivil() {
        return this.estadocivil;
    }

    public void setEstadocivil(String value) {
        this.estadocivil = value;
    }

    public String getDatosfamiliares() {
        return this.datosfamiliares;
    }

    public void setDatosfamiliares(String value) {
        this.datosfamiliares = value;
    }

    public String getLesion() {
        return this.lesion;
    }

    public void setLesion(String value) {
        this.lesion = value;
    }
    
    public void addAficion(String aficion){
    	aficiones.add(aficion);
    }

	public Fecha getFechalesion() {
		return fechalesion;
	}

	public void setFechalesion(Fecha fechalesion) {
		this.fechalesion = fechalesion;
	}

	public ArrayList<String> getAficiones() {
		return aficiones;
	}

  
}
