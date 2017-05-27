package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.administracion.CentroAlmacenable;

public class DAOCentroImp implements DAOCentro{
	
private static DAOCentroImp instancia = null;
	
	private DAObasico<CentroAlmacenable> op;
	private final String file = "organizacion.txt";
	
	public static DAOCentroImp getInstance(){
		if(instancia == null) return new DAOCentroImp();
		else return instancia;
	}

	
	private DAOCentroImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void guardarCentro(CentroAlmacenable c) throws IOException {
		op.guardar(c, file);
	}

	@Override
	public void eliminarCentro(String id) throws IOException,
			ClassNotFoundException {
		op.borrar(id, file);
	}

	@Override
	public void modificarCentro(CentroAlmacenable c) throws IOException,
			ClassNotFoundException {
		op.modificar(c, file);
	}

	@Override
	public HashSet<CentroAlmacenable> listarCentros() throws IOException,
			ClassNotFoundException {
		return op.obtenerDatosSet(file);
	}

	@Override
	public boolean existeCentro(String id) throws IOException,
			ClassNotFoundException {
		return op.exists(id, file);
	}


	@Override
	public CentroAlmacenable consultarCentro(String id) throws ClassNotFoundException, IOException {
		return op.consultar(id, file);
	}

}
