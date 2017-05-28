package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.administracion.EstadoCentro;

public class DAOCentroImp implements DAOCentro{
	
private static DAOCentroImp instancia = null;
	
	private DAObasico<EstadoCentro> op;
	private final String file = "organizacion.txt";
	
	public static DAOCentroImp getInstance(){
		if(instancia == null) instancia = new DAOCentroImp();
		return instancia;
	}

	
	private DAOCentroImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void guardarCentro(EstadoCentro c) throws IOException {
		op.guardar(c, file);
	}

	@Override
	public void eliminarCentro(String id) throws IOException,
			ClassNotFoundException {
		op.borrar(id, file);
	}

	@Override
	public void modificarCentro(EstadoCentro c) throws IOException,
			ClassNotFoundException {
		op.modificar(c, file);
	}

	@Override
	public HashSet<EstadoCentro> listarCentros() throws IOException,
			ClassNotFoundException {
		return op.obtenerDatosSet(file);
	}

	@Override
	public boolean existeCentro(String id) throws IOException,
			ClassNotFoundException {
		return op.exists(id, file);
	}


	@Override
	public EstadoCentro consultarCentro(String id) throws ClassNotFoundException, IOException {
		return op.consultar(id, file);
	}

}
