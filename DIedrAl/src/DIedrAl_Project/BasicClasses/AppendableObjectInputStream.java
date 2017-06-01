package DIedrAl_Project.integracion.BasicClasses;

import java.io.*;

/**
 * Clase que extiende de ObjectInputStream y permite sacar objetos Serializables
 * con bucles sin que se corrompan los datos a la hora de sacarlos del archivo
 * @author Diedral_Group
 */
public class AppendableObjectInputStream extends ObjectInputStream{

    public AppendableObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        // do not read a header
    }

}
