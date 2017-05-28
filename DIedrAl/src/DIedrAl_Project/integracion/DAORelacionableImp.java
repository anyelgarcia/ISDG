package DIedrAl_Project.integracion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import DIedrAl_Project.integracion.BasicClasses.AppendableObjectInputStream;
import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.integracion.BasicClasses.NoHeaderObjectOutputStream;
import DIedrAl_Project.negocio.Relacion;

/**
 * Clase que implementa la interfaz DAORelacionable. Es el unico DAO que recibe el
 * argumento del que buscar, y no es un Singleton (cada centro tiene sus propios
 * archivos de relaciones)
 * @author Diedral_Group
 */
public class DAORelacionableImp implements DAORelacionable{
	
	private static DAORelacionableImp dao_user = null;
	
	private static DAORelacionableImp dao_pac = null;
	
	private DAObasico<Relacion> op;
	
	private String file;
	
	public static DAORelacionableImp getInstance(tRelacion rel){
		switch(rel){
		case usuario: 
			if(dao_user == null){
				dao_user = new DAORelacionableImp("relaciones_users.txt");
			}
			return dao_user;
		case paciente: 
			if(dao_pac == null){
				dao_pac = new DAORelacionableImp("relaciones_paciente.txt");
			}
			return dao_pac;
		}
		return null;
	}
	
	private DAORelacionableImp(String file){
		op = new DAObasico<>();
		this.file = file;
	}
	
	@Override
	public void crearRelacion(Relacion r) throws IOException {
		op.guardar(r, file);
	}

	@Override
	public void eliminarRelacion(String id) throws IOException, ClassNotFoundException {
		op.borrar(id, file);
	}

	@Override
	public void modificarRelacion(Relacion r) throws IOException, ClassNotFoundException {
		op.modificar(r, file);
	}

	@Override
	public HashSet<Relacion> listarRelaciones(String id) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		HashSet<Relacion> r = new HashSet<>();
		Relacion rel = null;
		try {
			while (true) {
				rel = (Relacion) ois.readObject();
				if(rel.getNombreCentro().equals(id)) r.add(rel);
			}

		} catch (EOFException eof) {
			if (ois != null)
				ois.close();
			return r;
		}
	}

	@Override
	public boolean existeRelacion(String id) throws IOException, ClassNotFoundException {
		return op.exists(id, file);
	}

	@Override
	public void eliminarRelacionesCentro(String id) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		ArrayList<Relacion> r = new ArrayList<>();
		Relacion rel = null;
		try {
			while (true) {
				rel = (Relacion) ois.readObject();
				if(!rel.getNombreCentro().equals(id)) r.add(rel);
			}

		} catch (EOFException eof) {
			FileOutputStream arch = new FileOutputStream(file);
			BufferedOutputStream bf = new BufferedOutputStream(arch);
			ObjectOutputStream obj = new NoHeaderObjectOutputStream(bf);
			for (int i = 0; i < r.size(); ++i) {
				obj.writeObject(r.get(i));
			}
			obj.close();
			if (ois != null) ois.close();
		}
	}

}
