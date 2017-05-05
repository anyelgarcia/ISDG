package DIedrAl_Project.pacientes;

public class Direccion {

	private String localidad;

	private String calle;

	private int piso;

	private int numero;

	private int codigopostal;

	public Direccion(String localidad, String calle, int piso, int numero,
			int codigopostal) {
		this.localidad = localidad;
		this.calle = calle;
		this.piso = piso;
		this.numero = numero;
		this.codigopostal = codigopostal;
	}

	public void mostrar() {

	}

	public void modificar(Direccion nuevo) {
		this.localidad = nuevo.localidad;
		this.calle = nuevo.calle;
		this.piso = nuevo.piso;
		this.numero = nuevo.numero;
		this.codigopostal = nuevo.codigopostal;
	}

}
