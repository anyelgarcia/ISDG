package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.ArrayList;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.administracion.Terapeuta;

public class DAOTerapeutaImp implements DAOTerapeuta {
	
	private static DAOTerapeutaImp instancia = null;
	
	private DAObasico<Terapeuta> op;
	private String file = "terapeutas.txt";
	
	public static DAOTerapeutaImp getInstance(){
		if(instancia == null) return new DAOTerapeutaImp();
		else return instancia;
	}

	
	private DAOTerapeutaImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void crearTerapeuta(Terapeuta t) throws IOException {
		op.guardar(t, file);
	}

	@Override
	public void eliminarTerapeuta(String id)  throws IOException, ClassNotFoundException{
		op.borrar(id, file);
	}

	@Override
	public void modificarTerapeuta(Terapeuta t) throws IOException, ClassNotFoundException {
		op.modificar(t, file);
	}

	@Override
	public ArrayList<Terapeuta> listarTerapeutas()  throws IOException, ClassNotFoundException {
		return op.obtenerDatos(file);
	}

	public boolean existeTerapeuta(String id)  throws IOException, ClassNotFoundException{
		return op.exists(id, id);
	}
	
}
