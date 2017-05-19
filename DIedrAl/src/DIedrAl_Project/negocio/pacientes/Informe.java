package DIedrAl_Project.negocio.pacientes;

import DIedrAl_Project.negocio.administracion.Terapeuta;
import DIedrAl_Project.negocio.calendario.SesionProgramada;

public class Informe {
	private String texto;
	/*
	 * TODO No tiene sentido cambiar la sesion de la que está hablando el
	 * informe.
	 */
	private final SesionProgramada sesion;
	// TODO Pueden ser más?
	private Terapeuta autor;

	public Informe(SesionProgramada ses, Terapeuta autor) {
		sesion = ses;
		this.autor = autor;
		texto = "";
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Terapeuta getAutor() {
		return this.autor;
	}

	public void setAutor(Terapeuta value) {
		this.autor = value;
	}

	public SesionProgramada getSesion() {
		return sesion;
	}

}
