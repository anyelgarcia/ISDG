package DIedrAl_Project.negocio.administracion;

import java.io.Serializable;

public enum EstadoCivil implements Serializable{
	Casado, Soltero, Divorciado, Viudo;
	
	public int getOrdinal(){
		switch(this){
		case Casado:
			return 1;
		case Soltero:
			return 2;
		case Divorciado:
			return 3;
		case Viudo:
			return 4;
		default: return 0;
		}
	}
}
