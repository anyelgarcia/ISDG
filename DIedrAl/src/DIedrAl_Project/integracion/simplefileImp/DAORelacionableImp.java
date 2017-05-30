package DIedrAl_Project.integracion.simplefileImp;

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

import DIedrAl_Project.integracion.BasicClasses.AccessException;
import DIedrAl_Project.integracion.BasicClasses.AppendableObjectInputStream;
import DIedrAl_Project.integracion.BasicClasses.DAObasico;
import DIedrAl_Project.integracion.BasicClasses.NoHeaderObjectOutputStream;
import DIedrAl_Project.integracion.BasicClasses.tRelacion;
import DIedrAl_Project.integracion.DAOinterfaces.DAORelacionable;
import DIedrAl_Project.negocio.Relacion;

/**
 * Clase que implementa la interfaz DAORelacionable. Es el unico DAO que recibe
 * el argumento del que buscar, y no es un Singleton (cada centro tiene sus
 * propios archivos de relaciones)
 * 
 * @author Diedral_Group
 */
public class DAORelacionableImp implements DAORelacionable {

	private static DAORelacionableImp dao_user = null;

	private static DAORelacionableImp dao_pac = null;

	private DAObasico<Relacion> op;

	private String file;

	public static DAORelacionableImp getInstance(tRelacion rel) {
		switch (rel) {
		case usuario:
			if (dao_user == null) {
				dao_user = new DAORelacionableImp("relaciones_users.txt");
			}
			return dao_user;
		case paciente:
			if (dao_pac == null) {
				dao_pac = new DAORelacionableImp("relaciones_paciente.txt");
			}
			return dao_pac;
		}
		return null;
	}

	private DAORelacionableImp(String file) {
		op = new DAObasico<>();
		this.file = file;
	}

	@Override
	public void crearRelacion(Relacion r) throws AccessException {
		try {
			op.guardar(r, file);
		} catch (IOException e) {
			throw new AccessException("No se pudo guardar la relacion");
		}
	}

	@Override
	public void eliminarRelacion(String id) throws AccessException {
		try {
			op.borrar(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo eliminar la relacion");
		}
	}

	@Override
	public void modificarRelacion(Relacion r) throws AccessException {
		try {
			op.modificar(r, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo modificar la relacion");
		}
	}

	@Override
	public HashSet<Relacion> listarRelaciones(String id) throws AccessException {
		FileInputStream fis;
		AppendableObjectInputStream ois = null;
		HashSet<Relacion> r = new HashSet<>();
		try {
			try{
				fis = new FileInputStream(file);
			}
			catch(FileNotFoundException e) {
				return r;
			}
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new AppendableObjectInputStream(bis);
			Relacion rel = null;
			try {
				while (true) {
					rel = (Relacion) ois.readObject();
					if (rel.getNombreCentro().equals(id))
						r.add(rel);
				}

			} catch (EOFException eof) {
				if (ois != null)
					try {
						ois.close();
					} catch (IOException e) {
						throw new AccessException();
					}
				return r;
			}
		} catch (IOException | ClassNotFoundException e) {
			throw new AccessException("No se pudo listar las relaciones");
		}
	}

	@Override
	public boolean existeRelacion(String id) throws AccessException {
		try {
			return op.exists(id, file);
		} catch (ClassNotFoundException | IOException e) {
			throw new AccessException("No se pudo comprobar la existencia de la relacion");
		}
	}

	@Override
	public void eliminarRelacionesCentro(String id) throws AccessException {
		BufferedInputStream bis;
		AppendableObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			try{
				fis = new FileInputStream(file);
			}
			catch(FileNotFoundException e){
				return;
			}
			bis = new BufferedInputStream(fis);
			ois = new AppendableObjectInputStream(bis);
			ArrayList<Relacion> r = new ArrayList<>();
			Relacion rel = null;
			try {
				while (true) {
					rel = (Relacion) ois.readObject();
					if (!rel.getNombreCentro().equals(id))
						r.add(rel);
				}

			} catch (EOFException eof) {
				FileOutputStream arch;
				arch = new FileOutputStream(file);
				BufferedOutputStream bf = new BufferedOutputStream(arch);
				ObjectOutputStream obj = new NoHeaderObjectOutputStream(bf);
				for (int i = 0; i < r.size(); ++i) {
					obj.writeObject(r.get(i));
				}
				obj.close();
				if (ois != null) ois.close();
			}

		} catch (IOException | ClassNotFoundException e) {
			throw new AccessException("No se pudo eliminar la relaciones del centro dado");
		}
	}

}
