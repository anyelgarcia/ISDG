package DIedrAl_Project.negocio.recursos;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Recurso extends Etiquetable {

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

	public void open() throws IOException {
		if (fichero != null && fichero.isFile())
			Desktop.getDesktop().open(fichero);
		else if (direccion != null) {
			Desktop.getDesktop().browse(direccion);
		}
	}

	@Override
	public Set<String> getEtiquetas() {
		return this.etiquetas;
	}
	
	public File getFile(){
		return this.fichero;
	}

	public static void main(String... args) {

		// CREA UN NUEVO SELECTOR DE ARCHIVOS
		final JFileChooser fc = new JFileChooser();

		// Abre la ventanita para elegir archivo y registra lo que ha hecho el
		// usuario en returnVal
		int returnVal = fc.showOpenDialog(new JFrame("Prueba"));

		// Comprueba si el usuario ha escogido aceptar/abrir (hay más opciones
		// como cancel, etc en JFileChooser)
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			// Guarda la selección en un archivo.
			File file = fc.getSelectedFile();

			Recurso rec = new Recurso("Recurso de Prueba", file);
			File resourcesDir = new File("src/recursos/" + file.getName());
			System.out.println(resourcesDir.getAbsolutePath());

			try {
				Files.copy(rec.getPath(), resourcesDir.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
