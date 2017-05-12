package DIedrAl_Project.negocio.recursos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Actividad extends Etiquetable {
    private int duracion;

    private Set<String> destinatarios;

    private HashSet<Recurso> recurso = new HashSet<Recurso> ();

    private Dificultad dificultad;

    public void removeRecurso(Recurso rec) {
    	recurso.remove(rec);
    }

    public void addRecurso(Recurso rec) {
    	recurso.add(rec);
    }
    public Dificultad getDificultad(){
    	return this.dificultad;
    }
    public Set<String> getDestinatarios(){
    	return this.destinatarios;
    }
    public int getDuracion(){
    	return this.duracion;
    }

}
