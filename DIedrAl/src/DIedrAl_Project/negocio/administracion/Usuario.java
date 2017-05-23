package DIedrAl_Project.negocio.administracion;

import java.util.Set;

import DIedrAl_Project.negocio.pacientes.Paciente;

public class Usuario extends Persona {

	protected String rol;

	protected String infor;

	protected Set<Paciente> asociados;

	public Usuario(String nombre, String apellido1, String apellido2) {
		super(nombre, apellido1, apellido2);
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	public Set<Paciente> getAsociados() {
		return asociados;
	}

	public void setAsociados(Set<Paciente> asociados) {
		this.asociados = asociados;
	}

}
