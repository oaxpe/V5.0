/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class GoibururikEzObjectOutputStream extends ObjectOutputStream{

    /* ERAIKITZAILEAK */
    public GoibururikEzObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected GoibururikEzObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    /* METODOAK */
    /* fitxategiko kabezera ez idazteko metodoa berridatzi, ezer ez egiteko */
    @Override
    protected void writeStreamHeader() throws IOException {
        // metodo honek ez du ezer egiten
    }
}
