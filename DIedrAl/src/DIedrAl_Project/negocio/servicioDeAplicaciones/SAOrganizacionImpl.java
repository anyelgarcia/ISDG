package DIedrAl_Project.negocio.servicioDeAplicaciones;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.HashSet;

import DIedrAl_Project.integracion.DAOCentro;
import DIedrAl_Project.integracion.SimpleFileDAOFactory;
import DIedrAl_Project.negocio.administracion.CentroAlmacenable;
import DIedrAl_Project.negocio.administracion.Organizacion;

public class SAOrganizacionImpl implements SAOrganizacion {
	
	private Organizacion organizacion;
	private SimpleFileDAOFactory factoria;
	
	public SAOrganizacionImpl(Organizacion org) {
		this.organizacion=org;
		factoria = SimpleFileDAOFactory.getInstance();
	}

	@Override
	public ArrayList<String> getCentros() throws ClassNotFoundException, IOException {
		DAOCentro daocen = factoria.getDAOCentro();
		HashSet<CentroAlmacenable> centros = daocen.listarCentros();
		
		ArrayList<String> centrosStrings = new ArrayList<String>();
		centros.forEach((centroTransfer)->{
			centrosStrings.add(centroTransfer.getId());
		});
		
		return centrosStrings;
	}

	@Override
	public void addCentro(String name, String idAdmin, String passAdmin)
			throws AlreadyBoundException {
		
	}

	@Override
	public void eliminarCentro(String name) throws NotBoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeCentro(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputPasswordGod(String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeUsuario(String nif) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
}
