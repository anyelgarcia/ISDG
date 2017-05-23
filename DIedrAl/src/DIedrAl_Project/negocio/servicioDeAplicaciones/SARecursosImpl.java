package DIedrAl_Project.negocio.servicioDeAplicaciones;

import java.util.Set;

import DIedrAl_Project.negocio.recursos.Actividad;
import DIedrAl_Project.negocio.recursos.ArrayActividades;
import DIedrAl_Project.negocio.recursos.ArrayProgramables;
import DIedrAl_Project.negocio.recursos.Banco;
import DIedrAl_Project.negocio.recursos.Dificultad;
import DIedrAl_Project.negocio.recursos.Etiquetable;
import DIedrAl_Project.negocio.recursos.Programable;
import DIedrAl_Project.negocio.recursos.Recurso;
import DIedrAl_Project.negocio.recursos.Sesion;

public class SARecursosImpl implements SARecursos{
	private Banco bank;
	
	public SARecursosImpl(Banco b){
		bank=b;
	}

	@Override
	public void addRecurso(Recurso rec) {
		bank.addRecurso(rec);
	}

	@Override
	public void removeRecurso(Recurso rec) {
		bank.removeRecurso(rec);
		
	}

	@Override
	public void addActividad(Actividad act) {
		bank.addActividad(act);
		
	}

	@Override
	public void removeActividad(Actividad act) {
		bank.removeActividad(act);
		
	}

	@Override
	public void addSesion(Sesion ses) {
		bank.addSesion(ses);
		
	}

	@Override
	public void removeSesion(Sesion ses) {
		bank.removeSesion(ses);
		
	}


	@Override
	public ArrayActividades filtrarRango(Dificultad min, Dificultad max) {
		return bank.getActividades().filtrarRango(min, max);
	}

	@Override
	public ArrayActividades filtrarDesde(Dificultad dif) {
		return bank.getActividades().filtrarDesde(dif);
	}

	@Override
	public ArrayActividades filtrarHasta(Dificultad dif) {
		return bank.getActividades().filtrarHasta(dif);
	}

	@

	@Override
	public Set<Etiquetable> filtrarEtiqueta(Set<String> filtros,
			EnumEtiquetable op) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayProgramables<Programable> filtrarRango(Integer min,
			Integer max, EnumEtiquetable op) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayProgramables<Programable> filtrarDesde(Integer dur,
			EnumEtiquetable op) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayProgramables<Programable> filtrarHasta(Integer dur,
			EnumEtiquetable op) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayProgramables<Programable> filtrarDestinatarios(
			Set<String> dest, EnumEtiquetable op) {
		// TODO Auto-generated method stub
		return null;
	}

}
