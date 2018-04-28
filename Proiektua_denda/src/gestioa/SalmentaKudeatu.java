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
import model.Salmenta;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class SalmentaKudeatu {
    private static File d = new File("Objektuak");
    private static File f = new File(d+"\\salmenta.obj");
    
    /* Salmenta berri bat gehitu/gestionatu */
    public static void salmentaGehitu() {
        if (!d.exists()) {
            d.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(f, true));
            System.out.println("Salmenta berriaren datuak sartu behar dituzu.\n");
            Salmenta salm1 = new Salmenta(); 
            geoos.writeObject(salm1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println("\nDatu hauek dituen salmenta gorde da.");
            salm1.printDatuak();      
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));;
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }   
    }
    
    /* Eskaeren inguruko informazioa erakusten du. */
    public static void salmentaGuztiakErakutsi() {
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("SALMENTAK: ");
            System.out.printf("\t%1$-15s    %2$-15s    %3$-10s\n", "Salmenta zenb", "Data", "Kopurua");
            while (true) {
                Salmenta salm = (Salmenta) geois.readObject(); // objektua irakurri              
                salm.printSalmenta(); // objektuaren datuak erakutsi
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }
    }
}
