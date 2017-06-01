package DIedrAl_Project.negocio.pacientes;

import java.io.Serializable;

public class Direccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1611004593963612260L;

	private String localidad;

	private String provincia;

	private String calle;

	private int piso;

	private int portal;

	private int puerta;

	private int codigopostal;

	public String toString() {
		return calle + " " + portal + " " + piso + " " +
				puerta + ", " + localidad + " (" + provincia + ").";
	}
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getPortal() {
		return portal;
	}

	public void setPortal(int portal) {
		this.portal = portal;
	}

	public int getPuerta() {
		return puerta;
	}

	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}

	public int getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}
	
}
