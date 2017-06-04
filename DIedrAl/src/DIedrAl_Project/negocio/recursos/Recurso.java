package DIedrAl_Project.negocio.recursos;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.rmi.AlreadyBoundException;
import java.util.*;



public class Recurso extends Etiquetable {

	private static final long serialVersionUID = 695552343831162918L;
	private File fichero;
	private URI direccion;

	
	public Recurso(String name, String dir, String... etiquetas) throws URISyntaxException {
		super(name, etiquetas);
		this.direccion = new URI(dir);
		this.fichero = null;
	}

	public Recurso(String name, String dir) throws URISyntaxException {
		super(name);
		this.direccion = new URI(dir);
		this.fichero = null;
	}

	public Recurso(String name, File fichero) {
		super(name);
		this.fichero = fichero;
		this.direccion = null;
	}

	public Recurso(String name, File fichero, String... etiquetas) {
		super(name, etiquetas);
		this.fichero = fichero;
		this.direccion = null;
	}

	public Path getPath() {
		return fichero != null ? fichero.toPath() : null;
	}
	
	public URI getURI() {
		return direccion;
	}

	public String getExtension() {
		if (fichero != null) {
			String fileName = fichero.getName();
			int pos = fileName.lastIndexOf('.');
			return fileName.substring(pos + 1, fileName.length() - 1);
		} else if (direccion != null) {
			return ".url";
		} else
			return null;
	}

	public String getFileName() {
		return this.fichero != null ? fichero.getName() : null;
	}
	
	public boolean isFich(){
		return fichero != null;
	}

	public void open() throws IOException, UnsupportedOperationException {
		if(!Desktop.isDesktopSupported()){
			throw new UnsupportedOperationException();
		}
		else if (fichero != null && fichero.isFile()){
			Desktop.getDesktop().open(fichero);
		}
		else if (direccion != null) {
			Desktop.getDesktop().browse(direccion);
		}
		else throw new UnsupportedOperationException();
	}

	@Override
	public TreeSet<String> getEtiquetas() {
		return this.etiquetas;
	}
	
	public URI getUrl(){
		return direccion;
	}

	public File getFile() {
		return this.fichero;
	}
	public void setFile(File nuevo) throws AlreadyBoundException{
		if(direccion != null) throw new AlreadyBoundException("Ya tiene asociada una url");
		else this.fichero=nuevo;
	}
}
