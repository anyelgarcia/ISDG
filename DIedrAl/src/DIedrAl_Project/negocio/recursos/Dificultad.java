package DIedrAl_Project.negocio.recursos;

import java.io.Serializable;


public enum Dificultad implements Serializable{
	
	MUY_FACIL, FACIL, MEDIO, DIFICIL, MUY_DIFICIL;
	
	public String toString(){
		switch(this){
		case DIFICIL:
			return "Dificil";
		case FACIL:
			return "Fácil";
		case MEDIO:
			return "Media";
		case MUY_DIFICIL:
			return "Muy dificil";
		case MUY_FACIL:
			return "Muy facil";
		default:
			return null;
		
		}
		
	}
}
