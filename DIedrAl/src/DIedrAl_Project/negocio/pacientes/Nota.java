package DIedrAl_Project.negocio.pacientes;

import java.util.Date;
import java.util.GregorianCalendar;

import DIedrAl_Project.negocio.administracion.Terapeuta;
import DIedrAl_Project.negocio.administracion.Usuario;

public class Nota {
	private String texto;

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public GregorianCalendar getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(GregorianCalendar ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	private Usuario autor;
	private GregorianCalendar ultimaActualizacion;

	public Nota(Usuario autor, String texto) {
		this.autor = autor;
		this.texto = texto;
	}

	public Nota(Usuario autor) {
		this.autor = autor;
		this.texto = "";
	}

	void set(Usuario value) {
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
