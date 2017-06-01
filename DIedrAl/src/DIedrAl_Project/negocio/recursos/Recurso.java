package DIedrAl_Project.negocio.recursos;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


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

	public File getFile() {
		return this.fichero;
	}
	public void setFile(File nuevo){
		this.fichero=nuevo;
	}
	
	public static void main(String...args){

		// CREA UN NUEVO SELECTOR DE ARCHIVOS
		final JFileChooser fc = new JFileChooser();

		// Abre la ventanita para elegir archivo y registra lo que ha hecho el usuario en returnVal
		int returnVal = fc.showOpenDialog(new JFrame("Prueba"));

		// Comprueba si el usuario ha escogido aceptar/abrir (hay más opciones como cancel, etc en JFileChooser)
	        if (returnVal == JFileChooser.APPROVE_OPTION) {

		// Guarda la selección en un archivo.
	            File file = fc.getSelectedFile();

		// Y ahora crea un recurso sobre la base de ese archivo e intenta abrirlo
	            Recurso rec = new Recurso("Recurso de Prueba", file);
	            try {
					File path = new File ("/src/recursos/");
					path.mkdirs();
					Files.copy(rec.getPath(),path.getAbsoluteFile().toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } 
	}
}
