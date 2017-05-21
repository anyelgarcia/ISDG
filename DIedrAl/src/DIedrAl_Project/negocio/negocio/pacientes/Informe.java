package DIedrAl_Project.negocio.pacientes;

import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.calendario.SesionProgramada;

public class Informe {
	private String texto;
	/*
	 * TODO No tiene sentido cambiar la sesion de la que est� hablando el
	 * informe.
	 */
	private final SesionProgramada sesion;
	// TODO Pueden ser m�s?
	private Usuario autor;

	public Informe(SesionProgramada ses, Usuario autor) {
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
	
	public Usuario getAutor() {
		return this.autor;
	}

	public void setAutor(Usuario value) {
		this.autor = value;
	}

	public SesionProgramada getSesion() {
		return sesion;
	}

}