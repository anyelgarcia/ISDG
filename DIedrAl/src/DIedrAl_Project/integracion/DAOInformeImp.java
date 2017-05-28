package DIedrAl_Project.integracion;

import java.io.IOException;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.negocio.pacientes.Informe;

/**
 * Clase que implementa la interfaz DAOInforme. Obtiene los datos
 * del fichero "informe.txt". Solo se crea una instancia de este DAO (singleton)
 * @author Diedral_Group
 */
public class DAOInformeImp implements DAOInforme {

	private static DAOInformeImp instancia = null;
	
	private DAObasico<Informe> op;
	private final String file = "informe.txt";
	
	public static DAOInformeImp getInstance(){
		if(instancia == null) instancia = new DAOInformeImp();
		return instancia;
	}

	
	private DAOInformeImp(){
		op = new DAObasico<>();
	}
	
	@Override
	public void crearInforme(Informe a) throws AccessException  {
		try {
			op.guardar(a, file);
		} catch (IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void eliminarInforme(String id) throws AccessException  {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public void modificarInforme(Informe f) throws AccessException {
		try {
			op.modificar(f, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public HashSet<Informe> listarInformes() throws AccessException  {
		try {
			return op.obtenerDatosSet(file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

	@Override
	public boolean existeInformes(String id) throws AccessException{
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException();
		}
	}

}
