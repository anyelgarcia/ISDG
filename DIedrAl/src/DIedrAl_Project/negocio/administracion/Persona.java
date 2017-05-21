package DIedrAl_Project.negocio.administracion;

import java.util.GregorianCalendar;

import DIedrAl_Project.negocio.ObjetoAlmacenable;
import DIedrAl_Project.negocio.pacientes.Direccion;
import DIedrAl_Project.negocio.pacientes.Paciente;

public class Persona implements ObjetoAlmacenable{

	protected String nombre;

	protected String apellido1;

	protected String apellido2;

	protected GregorianCalendar fechaNacimiento;

	protected String estadoCivil;

	protected Direccion direccion;
	
	protected String email;
	
	protected Integer tfo;
	
	protected String id;

	public Persona(String nombre, String apellido1, String apellido2, String id) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public String getFirstSurname() {
		return apellido1;
	}

	public void setFirstSurname(String firstSurname) {
		this.apellido1 = firstSurname;
	}

	public String getSecondSurname() {
		return apellido2;
	}

	public void setSecondSurname(String secondSurname) {
		this.apellido2 = secondSurname;
	}

	public GregorianCalendar getBirthday() {
		return fechaNacimiento;
	}

	public void setBirthday(GregorianCalendar birthday) {
		fechaNacimiento = birthday;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Direccion getAddress() {
		return direccion;
	}

	public void setAddress(Direccion address) {
		direccion = address;
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

	@Override
	public String getId() {
		return id;
	}

	public int compararAlfab(Persona otra) {
		if(apellido1.compareTo(otra.apellido1) == -1){
			return -1;
		}
		else if(apellido1.compareTo(otra.apellido1) == 1){
			return 1;
		}
		else{
			if(apellido2.compareTo(otra.apellido2) == -1){
				return -1;
			}
			else if(apellido2.compareTo(otra.apellido2) == 1){
				return 1;
			}
			else{
				if(nombre.compareTo(otra.nombre) == -1){
					return -1;
				}
				else if(nombre.compareTo(otra.nombre) == 1){
					return 1;
				}
				else return 0;
			}
		}
	}
	
	/**
	 * Comprueba si la persona comparte id con la dada
	 * @return 0 si id es el mismo que el de otra, -1/1 si menor/mayor, respectivamente.
	 */
	public int compararID(Persona otra){
		return id.compareTo(otra.id);
	}
	

}
