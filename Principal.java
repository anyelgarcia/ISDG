
public class Principal {
	 
	public static void main(String[] args) {
	 
	 Configurador c1= Configurador.getInstancia("miurl1", "mibaseDatos1");
	 System.out.println(c1.getUrl());
	 System.out.println(c1.getBaseDatos());
	 
	 c1= Configurador.getInstancia("miurl2", "mibaseDatos2");
	 System.out.println(c1.getUrl());
	 System.out.println(c1.getBaseDatos());
	 
	}
	 
	}