package DIedrAl_Project.negocio.recursos;

import java.util.Set;

public class Recurso extends Etiquetable {
	private String extension;
	private String fileName;

	public Recurso(String fileName, String name) {
		super(name);
		this.fileName = fileName;
		int pos = fileName.lastIndexOf('.');
		extension = fileName.substring(pos + 1, fileName.length() - 1);
	}

	public Recurso(String fileName, String name, String... etiquetas) {
		super(name, etiquetas);
		this.fileName = fileName;
		int pos = fileName.lastIndexOf('.');
		extension = fileName.substring(pos + 1, fileName.length() - 1);
	}

	String getExtension() {
		return this.extension;
	}

	void setExtension(String value) {
		this.extension = value;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void open() {

	}

	@Override
	public Set<String> getEtiquetas() {
		return this.etiquetas;
	}

}
