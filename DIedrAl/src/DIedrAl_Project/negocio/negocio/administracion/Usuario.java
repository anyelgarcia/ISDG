package DIedrAl_Project.negocio.administracion;

import java.util.ArrayList;
import java.util.List;

import DIedrAl_Project.negocio.pacientes.Informe;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class Usuario extends Persona {

	protected String rol;

	protected String infor;
	
	protected String password;
	
	protected List<Paciente> pacientesAsociados = new ArrayList<Paciente> ();

	protected List<Informe> informes = new ArrayList<Informe> ();

	public Usuario(String nombre, String apellido1, String apellido2, String id) {
		super(nombre, apellido1, apellido2, id);
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
	
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * Comprueba si el string introducido coincide con la contraseña del ususuario.
	 * @param pass contraseña a probar
	 * @return true si coincide, false en caso contrario.
	 */
	public boolean inputPassword(String pass){
		return pass.equals(password);
	}
	
}
