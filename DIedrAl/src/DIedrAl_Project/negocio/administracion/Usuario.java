package DIedrAl_Project.negocio.administracion;

public class Usuario extends Persona {

	protected String rol;

	protected String infor;

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
}
