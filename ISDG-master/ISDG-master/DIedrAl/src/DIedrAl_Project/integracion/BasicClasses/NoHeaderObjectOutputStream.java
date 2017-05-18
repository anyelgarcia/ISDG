package DIedrAl_Project.integracion.BasicClasses;

import java.io.*;

/**
 * Created by Alejandro on 12/05/2017.
 */
public class NoHeaderObjectOutputStream extends ObjectOutputStream {
    public NoHeaderObjectOutputStream(OutputStream os) throws IOException {
        super(os);
    }

    @Override
    protected void writeStreamHeader() {}
}
