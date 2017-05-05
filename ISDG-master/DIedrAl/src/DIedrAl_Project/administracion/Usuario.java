package DIedrAl_Project.administracion;

import DIedrAl_Project.pacientes.Direccion;

public class Usuario {
	private String id;

	private int tlf;

	private String email;

	private Direccion direccion;

	public Usuario(String id, String email, int tlf, Direccion dir){
    	this.id = id;
    	this.tlf = tlf;
    	this.email = email;
    	this.direccion = dir;
    }

	public void mostrar() {

	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
