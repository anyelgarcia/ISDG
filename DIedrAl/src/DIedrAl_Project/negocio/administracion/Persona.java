package DIedrAl_Project.negocio.administracion;

import java.util.GregorianCalendar;
import java.util.UUID;

import DIedrAl_Project.negocio.ObjetoAlmacenable;
import DIedrAl_Project.negocio.calendario.Fecha;
import DIedrAl_Project.negocio.pacientes.Direccion;

public class Persona implements ObjetoAlmacenable{

	protected String name;

	protected String firstSurname;

	protected String secondSurname;

	protected Fecha birthday;

	protected String estadoCivil;

	protected Direccion address;
	
	protected String email;
	
	protected Integer tfo;
	
	protected String id;

	protected String descripcion;
	
	public Persona(String nombre, String apellido1, String apellido2) {
		name = nombre;
		firstSurname = apellido1;
		secondSurname = apellido2;
		this.id = UUID.randomUUID().toString();
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

	public Fecha getBirthday() {
		return birthday;
	}

	public void setBirthday(Fecha birthday) {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String getId() {
		return id;
	}
	

}
