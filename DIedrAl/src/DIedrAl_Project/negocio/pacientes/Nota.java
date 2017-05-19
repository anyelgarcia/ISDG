package DIedrAl_Project.negocio.pacientes;

import java.util.Date;
import java.util.GregorianCalendar;

import DIedrAl_Project.negocio.administracion.Terapeuta;

public class Nota {
	private String texto;

	public Terapeuta getAutor() {
		return autor;
	}

	public void setAutor(Terapeuta autor) {
		this.autor = autor;
	}

	public GregorianCalendar getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(GregorianCalendar ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	private Terapeuta autor;
	private GregorianCalendar ultimaActualizacion;

	public Nota(Terapeuta autor, String texto) {
		this.autor = autor;
		this.texto = texto;
	}

	public Nota(Terapeuta autor) {
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

	public void append(String s) {
		append(s, "\n", "");
	}

	public void append(String s, String separatorBefore) {
		append(s, separatorBefore, "");
	}

	public void append(String s, String separatorBefore, String separatorAfter) {
		texto = texto + separatorBefore + s + separatorAfter;
	}

}
