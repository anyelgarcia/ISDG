package DIedrAl_Project.integracion.BasicClasses;

import java.io.*;

/**
 * Created by Alejandro on 12/05/2017.
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
