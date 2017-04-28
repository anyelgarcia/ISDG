
interface IAdaptador{
	//la interfaz que tenemos permite trabajar con pesetas
	public abstract void sacarPesetas( double pesetas );
	public abstract void ingresarPesetas( double pesetas );
}


class Adaptador implements IAdaptador {
	//El adaptador implementa los métodos de la interfaz  
	//y redirige la comunicación hacia el objeto que gestiona la caja en euros

	CajaEuros cajaEuros = new CajaEuros();

	public Adaptador() {  }

	public double getSaldo()    {
		return this.cajaEuros.getTotalEuros();
	}
	public void sacarPesetas( double pesetas )    {
		double euros = pesetas / 166.386;
		cajaEuros.sacarEuros( euros );
	}
	public void ingresarPesetas( double pesetas )    {
		double euros = pesetas / 166.386;
		cajaEuros.ingresarEuros( euros );
	}
}

class CajaEuros {//Adaptada
	//La clase CajaEuros contiene los métodos necesarios para ingresar y sacar fondos en euros.
	private double euros = 0;

	public CajaEuros() {    }

	public double getTotalEuros()    {
		return this.euros;
	}
	public void sacarEuros( double euros )    {
		this.euros -= euros;
	}
	public void ingresarEuros( double euros )    {
		this.euros += euros;
	}
}

public class Main {
	public static void main(String[] args)     {

		Adaptador conversor = new Adaptador();
		conversor.ingresarPesetas( 2000 );
		conversor.ingresarPesetas( 5000 );
		conversor.ingresarPesetas( 1000 );
		System.out.println( "Total euros: " + conversor.getSaldo() );
	}
}