package DIedrAl_Project.negocio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Objeto transfer que almacena la relacion entre un tipo de Objeto con una lista
 * de otros, dado el identificador de esos objetos. Se puede utilizar para guardar
 * las vinculaciones de un terapeuta con sus pacientes y viceversa.
 * @author Diedral_Group
 *
 */
public class Relacion implements Serializable, ObjetoAlmacenable {
	
	private final String id;
	
	private ArrayList<String>  relacionados;
	
	private String centro;
	
	public Relacion(String id){
		this.id = id;
		this.relacionados = new ArrayList<>();
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	public ArrayList<String> getRelacionados(){
		return this.relacionados;
	}
	
	public void setRelacionados(ArrayList<String> list){
		this.relacionados = list;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}
	
}
