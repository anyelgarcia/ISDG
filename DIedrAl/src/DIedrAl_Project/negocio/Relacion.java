package DIedrAl_Project.negocio;

import java.io.Serializable;
import java.util.ArrayList;

public class Relacion implements Serializable, ObjetoAlmacenable {
	
	private final String id;
	
	private ArrayList<String>  relacionados;
	
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
	
}
