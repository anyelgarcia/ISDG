import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface IComponente {
// todo componente tiene un nombre 
// y un comportamiento

public String getnombre();
public float getPrecioNeto();
public void anadir(IComponente e);
public void eliminar(IComponente e);
public Iterator crearIterador();

}


class Procesador implements IComponente {
	String nombre;	
	float precioNeto;

	public Procesador(String nombre,float precio) {
		this.nombre=nombre;
		this.precioNeto=precio;
	}
	public String getnombre(){return "Procesador";}
	public float getPrecioNeto(){	 return precioNeto;	 }

	public void anadir(IComponente e){}
	public void eliminar(IComponente e){}
	public Iterator crearIterador(){return null;}
}


class DVD implements IComponente {
	String nombre;	
	float precioNeto;

	public DVD(String nombre,float precio) {
		this.nombre=nombre;
		this.precioNeto=precio;
	}
	public String getnombre(){return "DVD";}
	public float getPrecioNeto(){	  return precioNeto;	 }

	public void anadir(IComponente e){}
	public void eliminar(IComponente e){}
	public Iterator crearIterador(){return null;}
}


class Composite implements IComponente {

	String nombre;
	ArrayList<IComponente> listaIComponente=new ArrayList<IComponente>();
	

	public String getnombre(){return nombre;}
	
	public float getPrecioNeto() { 
		//Iterator i= crearIterador();
		float total=0;
		for (Iterator<IComponente> i=crearIterador(); i.hasNext(); )
			total += i.next().getPrecioNeto();
		return total;
	}
	

	public void anadir(IComponente e){
		listaIComponente.add(e);
	}
	public void eliminar(IComponente e){
		listaIComponente.remove(e);
	}
	public Iterator crearIterador(){
		return listaIComponente.iterator();
	}

}


class Ordenador extends Composite {
	public Ordenador(String nombre){
		this.nombre=nombre;
	}
}
class Placa extends Composite {
	public Placa(String nombre){
		this.nombre=nombre;
	}

	
}


public class Main {

	public static void main(String[] args) {
		IComponente ordenador= new Ordenador("PC low");
		IComponente placa= new Placa("B75");
		IComponente procesador= new Procesador("i5-3570T",90);
		IComponente dvd= new DVD("+-RW",60);
		placa.anadir(procesador);
		ordenador.anadir(placa);
		ordenador.anadir(dvd);
		System.out.println("PRECIO NETO :" + ordenador.getPrecioNeto());
	}
}
