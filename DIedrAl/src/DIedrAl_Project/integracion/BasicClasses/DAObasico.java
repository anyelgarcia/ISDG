package DIedrAl_Project.integracion.BasicClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

import DIedrAl_Project.negocio.ObjetoAlmacenable;

/**
 * Clase generica que implementa todos los metodos CRUD. Cualquier clase que
 * implemente ObjetoAlmacenable puede utilizar un DAObasico para realizar estas
 * operaciones
 * 
 * @author Diedral_Group
 */
public class DAObasico<S extends ObjetoAlmacenable> {

	public void guardar(S datos, String file) throws IOException {
		FileOutputStream arch = new FileOutputStream(file, true);
		BufferedOutputStream bf = new BufferedOutputStream(arch);
		ObjectOutputStream obj = new NoHeaderObjectOutputStream(bf);
		obj.writeObject(datos);
		obj.reset();
		obj.close();
	}

	public S consultar(String id, String file) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p = null;
		try {
			do {
				p = (S) ois.readObject();
			} while (!p.getId().equalsIgnoreCase(id));
		} catch (EOFException op) {
			ois.close();
			return null;
		}
		ois.close();
		return p;
	}

	public void modificar(S nuevo, String file) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p;
		ArrayList<S> sobreescribir = new ArrayList<>();
		try {
			while (true) {
				p = (S) ois.readObject();
				if (p.getId().equalsIgnoreCase(nuevo.getId()))
					sobreescribir.add(nuevo);
				else
					sobreescribir.add(p);
			}
		} catch (EOFException op) {
			if (ois != null)
				ois.close();
			FileOutputStream arch = new FileOutputStream(file);
			BufferedOutputStream bf = new BufferedOutputStream(arch);
			ObjectOutputStream obj = new NoHeaderObjectOutputStream(bf);
			for (int i = 0; i < sobreescribir.size(); ++i) {
				obj.writeObject(sobreescribir.get(i));
			}
			obj.close();
		}
	}

	public ArrayList<S> obtenerDatos(String file) throws IOException,
			ClassNotFoundException {
		ArrayList<S> r = new ArrayList<>();
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
		}
		catch(FileNotFoundException e) {
			return r;
		}
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		
		S p = null;
		try {
			while (true) {
				p = (S) ois.readObject();
				r.add(p);
			}

		} catch (EOFException eof) {
			if (ois != null)
				ois.close();
			return r;
		}
	}

	public void borrar(String id, String file) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p = null;
		ArrayList<S> sobreescribir = new ArrayList<>();
		try {
			while (true) {
				p = (S) ois.readObject();
				if (!p.getId().equalsIgnoreCase(id))
					sobreescribir.add(p);
			}
		} catch (EOFException op) {
			if (ois != null)
				ois.close();
			FileOutputStream arch = new FileOutputStream(file);
			BufferedOutputStream bf = new BufferedOutputStream(arch);
			ObjectOutputStream obj = new NoHeaderObjectOutputStream(bf);
			for (int i = 0; i < sobreescribir.size(); ++i) {
				obj.writeObject(sobreescribir.get(i));
			}
			obj.close();
		}
	}

	public boolean exists(String id, String file)
			throws ClassNotFoundException, IOException {
		FileInputStream fis;
		try{
			fis = new FileInputStream(file);
		}
		catch(FileNotFoundException e) {
			return false;
		}
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p = null;
		try {
			do {
				p = (S) ois.readObject();
			} while (p.getId() != id);

		} catch (EOFException eof) {
			ois.close();
			return false;
		}
		if (ois != null)
			ois.close();
		return true;
	}

	public HashSet<S> obtenerDatosSet(String file) throws IOException,
			ClassNotFoundException {
		HashSet<S> r = new HashSet<>();
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
		}
		catch(FileNotFoundException e) {
			return r;
		}
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p = null;
		try {
			while (true) {
				p = (S) ois.readObject();
				r.add(p);
			}

		} catch (EOFException eof) {
			if (ois != null)
				ois.close();
			return r;
		}
	}
}
