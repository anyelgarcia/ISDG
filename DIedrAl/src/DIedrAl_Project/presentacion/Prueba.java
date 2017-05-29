package DIedrAl_Project.presentacion;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import DIedrAl_Project.negocio.recursos.Recurso;

public class Prueba {
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
					rec.open();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } 
	}
}
