package DIedrAl_Project.negocio.administracion;


public class Usuario extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 991728753309384395L;

	protected boolean admin;

	protected String infor = "";

	protected String password = "";

	public Usuario(String nombre, String apellido1, String apellido2, String nif) {
		super(nombre, apellido1, apellido2, nif);
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin() {
		admin = true;
	}

	public void resetAdmin() {
		admin = false;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}
	
	public String getInfor(){
		return infor;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}

	/**
	 * Comprueba si el string introducido coincide con la contraseña del
	 * ususuario.
	 * 
	 * @param pass contraseña a probar
	 * @return true si coincide, false en caso contrario.
	 */
	public boolean inputPassword(String pass) {
		return pass.equals(password);
	}
	
	
	public void igualarCampos(Usuario that){
		super.igualarCampos(that);
		admin = that.admin;
		infor = that.infor;
		password = that.password;
	}
	
}
