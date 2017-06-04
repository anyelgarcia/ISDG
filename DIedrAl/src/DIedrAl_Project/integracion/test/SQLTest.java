package DIedrAl_Project.integracion.test;

import org.junit.Test;

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.SQL.SQLDAOFactory;
import DIedrAl_Project.negocio.recursos.Actividad;

public class SQLTest {
	
	@Test
	public final static void main() throws AccessException{
		SQLDAOFactory f = SQLDAOFactory.getInstance();
		Actividad a = new Actividad("NombrePrueba");
	
	
	}
}
