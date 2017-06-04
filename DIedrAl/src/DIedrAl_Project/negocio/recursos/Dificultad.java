package DIedrAl_Project.negocio.recursos;

import java.io.Serializable;


public enum Dificultad implements Serializable{


	MUY_FACIL, FACIL, MEDIO, DIFICIL, MUY_DIFICIL;
  
	public static Dificultad toDificultad(String a){
		switch(a){
		case "MUY_FACIL": return Dificultad.MUY_FACIL; 
		case "FACIL": return Dificultad.FACIL; 
		case "MEDIO": return Dificultad.MEDIO; 
		case "DIFICIL": return Dificultad.DIFICIL;
		case "MUY_DIFICIL": return Dificultad.MUY_DIFICIL;
		default: return null;
		}
	}
	
	public int getOrdinal(){
		switch(this){
		case MUY_FACIL:
			return 1;
		case FACIL:
			return 2;
		case MEDIO:
			return 3;
		case DIFICIL:
			return 4;
		case MUY_DIFICIL:
			return 5;
		default: return 0;
		}
	}
}
