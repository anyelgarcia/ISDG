package DIedrAl_Project.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Objeto transfer que almacena la relacion entre un tipo de Objeto con una
 * lista de otros, dado el identificador de esos objetos. Se puede utilizar para
 * guardar las vinculaciones de un terapeuta con sus pacientes y viceversa.
 * 
 * @author Diedral_Group
 *
 */
public class Relacion implements Serializable, ObjetoAlmacenable {

	private static final long serialVersionUID = -1761048758403070404L;

	private final String id;

	private ArrayList<String> relacionados;

	private String nombreCentro;

	private String idAgente;

	public Relacion(String agente, String cen) {
		relacionados = new ArrayList<String>();
		id = UUID.randomUUID().toString();
		idAgente = agente;
		nombreCentro = cen;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public ArrayList<String> getRelacionados() {
		return this.relacionados;
	}

	public void setRelacionados(ArrayList<String> list) {
		this.relacionados = list;
	}

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public String getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(String idAgente) {
		this.idAgente = idAgente;
	}

	

	
}
