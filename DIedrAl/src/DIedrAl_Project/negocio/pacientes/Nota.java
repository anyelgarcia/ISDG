package DIedrAl_Project.negocio.pacientes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import DIedrAl_Project.negocio.ObjetoAlmacenable;
import DIedrAl_Project.negocio.administracion.Usuario;

public class Nota implements ObjetoAlmacenable, Serializable {

	private static final long serialVersionUID = 5858585383509332063L;
	private String texto;
	private Usuario autor;
	private LocalDateTime ultimaActualizacion;
	private String id;

	public Nota(Usuario autor, String texto) {
		this.autor = autor;
		this.texto = texto;
		id = UUID.randomUUID().toString();
	}

	public Nota(Usuario autor) {
		this.autor = autor;
		this.texto = "";
		id = UUID.randomUUID().toString();
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public LocalDateTime getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	void set(Usuario value) {
		this.autor = value;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		ultimaActualizacion = LocalDateTime.now();

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

	@Override
	public String getId() {
		return id;
	}

}
