package DIedrAl_Project.negocio.administracion;

import DIedrAl_Project.negocio.ObjetoAlmacenable;

public class CentroAlmacenable implements ObjetoAlmacenable {
	
	private String nombre;
	
	private final String filePacientes;
	
	private final String fileUsuarios;
	
	public CentroAlmacenable(String n){
		nombre = n;
		filePacientes = nombre + "_pacientes.txt";
		fileUsuarios = nombre + "_usuarios.txt";
	}
	
	@Override
	public String getId() {
		return nombre;
	}

	public String getFilePacientes() {
		return filePacientes;
	}

	public String getFileUsuarios() {
		return fileUsuarios;
	}

}
