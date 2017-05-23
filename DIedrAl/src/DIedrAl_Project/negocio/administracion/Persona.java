package DIedrAl_Project.negocio.administracion;

import java.util.GregorianCalendar;

import DIedrAl_Project.negocio.pacientes.Direccion;

public class Persona {

	protected String name;

	protected String firstSurname;

	protected String secondSurname;

	protected GregorianCalendar birthday;

	protected String estadoCivil;

	protected Direccion address;
	
	protected String email;
	
	protected Integer tfo;

	public Persona(String nombre, String apellido1, String apellido2) {
		name = nombre;
		firstSurname = apellido1;
		secondSurname = apellido2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public GregorianCalendar getBirthday() {
		return birthday;
	}

	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Direccion getAddress() {
		return address;
	}

	public void setAddress(Direccion address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTfo() {
		return tfo;
	}

	public void setTfo(Integer tfo) {
		this.tfo = tfo;
	}
	

}
