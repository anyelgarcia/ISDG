package DIedrAl_Project.negocio.pacientes;


import java.util.ArrayList;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.calendario.Fecha;


public class DatosPaciente {

    private String lesion;

    private Fecha fechalesion;
    
    private ArrayList<String> aficiones;


    public DatosPaciente(String lesion, Fecha fechalesion,
			String... aficiones) {

		this.lesion = lesion;
		this.fechalesion = fechalesion;
		this.aficiones = new ArrayList<String>();
		for(String str: aficiones) 
			this.aficiones.add(str);
	}

    String getLesion() {
        return this.lesion;
    }

    void setLesion(String value) {
        this.lesion = value;
    }

	public Fecha getFechalesion() {
		return fechalesion;
	}

	public void setFechalesion(Fecha fechalesion) {
		this.fechalesion = fechalesion;
	}

}
