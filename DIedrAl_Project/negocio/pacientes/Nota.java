package DIedrAl_Project.negocio.pacientes;

import java.util.Date;
import java.util.GregorianCalendar;

import DIedrAl_Project.negocio.administracion.Terapeuta;


public class Nota {
    private String texto;

    private Terapeuta autor;
    private GregorianCalendar ultimaActualizacion;
    
    public Nota(Terapeuta autor, String texto){
    	this.autor = autor;
    	this.texto = texto;
    }
    public Nota(Terapeuta autor){
    	this.autor = autor;
    	this.texto = "";
    }

    void set(Terapeuta value) {
        this.autor = value;
    }

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		ultimaActualizacion.setTimeInMillis(new Date().getTime());
	}

}
