package DIedrAl_Project.negocio.pacientes;

import java.io.Serializable;
import java.util.UUID;

import DIedrAl_Project.negocio.ObjetoAlmacenable;
import DIedrAl_Project.negocio.administracion.Usuario;
import DIedrAl_Project.negocio.calendario.SesionProgramada;

public class Informe implements ObjetoAlmacenable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1305608104357593197L;
	private String texto;
	
	private final SesionProgramada sesion;
	private Usuario autor;
	private String id;

	public Informe(SesionProgramada ses, Usuario autor) {
		sesion = ses;
		this.autor = autor;
		texto = "";
		id = UUID.randomUUID().toString();
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

	@Override
	public String getId() {
		return id;
	}

}
