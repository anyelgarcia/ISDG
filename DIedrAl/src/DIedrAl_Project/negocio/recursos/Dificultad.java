package DIedrAl_Project.negocio.recursos;

import java.io.Serializable;


public enum Dificultad implements Serializable{
	
	MUY_FACIL, FACIL, MEDIO, DIFICIL, MUY_DIFICIL;
	
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
