package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.pacientes.Informe;
import DIedrAl_Project.negocio.recursos.Actividad;

public class DAOInformeImp implements DAOInforme {

	private static DAOInformeImp instancia;
	
	private DAObasico<Informe> op;
	private String file = "informe.txt";
	
	public static DAOInformeImp getInstance(){
		if(instancia == null) return new DAOInformeImp();
		else return instancia;
	}

	
	private DAOInformeImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void crearInforme(Informe a) throws IOException {
		op.guardar(a, file);
	}

	@Override
	public void eliminarInforme(String id) throws IOException,
			ClassNotFoundException {
		op.borrar(id, file);
	}

	@Override
	public void modificarInforme(Informe f) throws IOException,
			ClassNotFoundException {
		op.modificar(f, file);
	}

	@Override
	public HashSet<Informe> listarInformes() throws IOException,
			ClassNotFoundException {
		return op.obtenerDatosSet(file);
	}

	@Override
	public boolean existeInformes(String id) throws IOException,
			ClassNotFoundException {
		return op.exists(id, file);
	}

}
