/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import model.Eskaera;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class EskaeraKudeatu implements Serializable {
    private static File d = new File("Objektuak");
    private static File f = new File(d+"\\eskaera.obj");
    
    /* Eskaera berri bat gehitu/gestionatu */
    public static void eskaeraGehitu(Eskaera esk1) {
        if (!d.exists()) {
            d.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(f, true));
            geoos.writeObject(esk1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println("\nDatu hauek dituen eskaera gorde da.");
            esk1.printDatuak();      
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));;
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }   
    }
    
    /* Eskaeren inguruko informazioa erakusten du. */
    public static ArrayList<Eskaera> eskaeraGuztiakErakutsi() {
        ArrayList<Eskaera> eskGuzt = new ArrayList<Eskaera>();
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("ESKAERAK: ");
            System.out.printf("\t%1$-15s    %2$-15s    %3$-10s    %4$-15s\n", "Eskaera zenb", "Hornitzailea", "Kopurua", "Data");
            while (true) {
                Eskaera esk = (Eskaera) geois.readObject(); // objektua irakurri              
                esk.printEskaera(); // objektuaren datuak erakutsi
                eskGuzt.add(esk);
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));;
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }    
        return eskGuzt;
    }
    
}

