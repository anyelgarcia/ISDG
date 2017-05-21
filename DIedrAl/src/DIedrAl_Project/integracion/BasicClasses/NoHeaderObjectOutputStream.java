package DIedrAl_Project.integracion.BasicClasses;

import java.io.*;

/**
 * Clase que extiende ObjectOuputStream que permite guardar objetos Serializables
 * sin el centinela, con lo que podemos extraerlos con un bucle
 * @author Diedral_Group
 */
public class NoHeaderObjectOutputStream extends ObjectOutputStream {
    public NoHeaderObjectOutputStream(OutputStream os) throws IOException {
        super(os);
    }

    @Override
    protected void writeStreamHeader() {}
}
