package DIedrAl_Project.integracion.BasicClasses;

import java.io.*;
import java.util.ArrayList;

import DIedrAl_Project.negocio.ObjetoAlmacenable;

/**
 * Created by Alejandro on 13/05/2017.
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

	public S consultar(String id, String file) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p = (S) ois.readObject();
		while (!p.getId().equalsIgnoreCase(id)) {
			try {
				p = (S) ois.readObject();
			} catch (EOFException op) {
				ois.close();
				return null;
			}
		}
		ois.close();
		return p;
	}

	public void modificar(S nuevo, String file) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p = (S) ois.readObject();
		ArrayList<S> sobreescribir = new ArrayList<>();
		try {
			while (true) {
				if (p.getId().equalsIgnoreCase(nuevo.getId()))
					sobreescribir.add(nuevo);
				else
					sobreescribir.add(p);
				p = (S) ois.readObject();
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

	public ArrayList<S> obtenerDatos(String file) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		ArrayList<S> r = new ArrayList<>();
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

	public void borrar(String id, String file) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p = (S) ois.readObject();
		ArrayList<S> sobreescribir = new ArrayList<>();
		try {
			while (true) {
				if (!p.getId().equalsIgnoreCase(id))
					sobreescribir.add(p);
				p = (S) ois.readObject();
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

	public boolean exists(String id, String file) throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		AppendableObjectInputStream ois = new AppendableObjectInputStream(bis);
		S p = (S) ois.readObject();
		try {
			while (p.getId() != id) {
				p = (S) ois.readObject();
			}

		} catch (EOFException eof) {
			ois.close();
			return false;
		}
		if (ois != null)
			ois.close();
		return true;
	}
}