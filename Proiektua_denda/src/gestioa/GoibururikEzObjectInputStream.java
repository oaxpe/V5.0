/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author DM3-1-05
 */
public class GoibururikEzObjectInputStream extends ObjectInputStream{

    /* ERAIKITZAILEAK */
    public GoibururikEzObjectInputStream(InputStream is) throws IOException {
        super(is);
    }

    protected GoibururikEzObjectInputStream() throws IOException, SecurityException {
        super();
    }

    /* METODOAK */
    /* fitxategiko kabezera ez irakurtzeko metodoa berridatzi, ezer ez egiteko */
    @Override
    protected void readStreamHeader() throws IOException {
    }
}
