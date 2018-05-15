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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Eskaera;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class EskaeraKudeatu implements Serializable {
    private static File d = new File("Objektuak");
    private static File f = new File(d+"\\eskaera.obj");
    private static File fTemp = new File(d+"\\eskTemp.obj");
    
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
    
    /* Eskaera zehatz bat ezabatu */
    public static void eskaeraEzabatu(String kodea) {
        boolean ezabatuta = false;
        GoibururikEzObjectOutputStream geoos = null;
        try {            
            geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            
            while (true) { // fitxategiko objektuak irakurri
                Eskaera esk = (Eskaera) geois.readObject(); // objektua irakurri              
                if (!esk.getEskZenb().toUpperCase().equals(kodea.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(esk); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    ezabatuta = true;
                }
            }  
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));;
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }
        if (ezabatuta) {
            System.out.println("Eskaera ezabatu da.");
        }
        else
            System.out.println(kodea+" kodea duen eskaera ez dago erregistratuta.");
        try {
            geoos.close();
            System.gc();
            Files.move(Paths.get(fTemp.getAbsolutePath()), Paths.get(f.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(EskaeraKudeatu.class.getName()).log(Level.SEVERE, null, ex);
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

