
import java.util.*;

abstract class Componente
{
	protected String nombre;
	public Componente (String nombre)
	{
		this.nombre = nombre;
	}
	abstract public void agregar(Componente c);
	abstract public void eliminar(Componente c);
	abstract public void mostrar(int profundidad);
}
class Compuesto extends Componente
{
	private ArrayList<Componente> hijo = new ArrayList<Componente>();
	public Compuesto (String name)
	{
		super(name);
	}
	public void agregar(Componente componente)
	{
		hijo.add(componente);
	}
	
	public void eliminar(Componente componente)
	{
		hijo.remove(componente);
	}
	public void mostrar(int profundidad)
	{
		System.out.println(nombre + " nivel: " + profundidad);
		for (int i = 0; i < hijo.size(); i++)
			hijo.get(i).mostrar(profundidad + 1);
	}
}
class Hoja extends Componente
{
	public Hoja (String nombre)
	{
		super(nombre);
	}
	public void agregar(Componente c)
	{
		System.out.println("no se puede agregar la hoja");
	}
	public void eliminar(Componente c)
	{
		System.out.println("no se puede quitar la hoja");
	}
	public void mostrar(int depth)
	{
		System.out.println('-' + "" + nombre);
	}
}
public class Client
{
	public static void main(String[] args)
	{
		Compuesto raiz = new Compuesto("root");
		raiz.agregar(new Hoja("hoja A"));
		raiz.agregar(new Hoja("hoja B"));
		Compuesto comp = new Compuesto("compuesto X");
		comp.agregar(new Hoja("  hoja XA"));
		comp.agregar(new Hoja("  hoja XB"));
		raiz.agregar(comp);
		raiz.agregar(new Hoja("hoja C"));
		Hoja l = new Hoja("hoja D");
		raiz.agregar(l);
		raiz.mostrar(1);
		System.out.println("========================");
		raiz.eliminar(l);
		raiz.mostrar(1);
	}
}