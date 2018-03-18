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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import proiektua_denda.Praka;
import proiektua_denda.Proiektua_denda;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class PrakaKudeatu {
    private static File d = new File("Objektuak");
    private static File f = new File(d+"\\praka.obj");
    private static File fTemp = new File(d+"\\prakTemp.obj");

    /* Praka berri bat gehitu */
    public static void prakaGehitu() {
        if (!d.exists()) {
            d.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(f, true));
            System.out.println("Praka berriaren datuak sartu behar dituzu.\n");
            Praka prak1 = new Praka();     
            geoos.writeObject(prak1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println();
            System.out.println("Datu hauek dituen produktua gorde da."
                    + "\nProduktua: PRAKA");
            prak1.printDatuak();
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
    }
    
    /* Praka zehatz baten datu guztiak ezabatu */    
    public static void prakaEzabatu(String kodea) throws IOException {
        boolean ezabatuta = false;
        try {    
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            
            while (true) { // fitxategiko objektuak irakurri
                Praka prak = (Praka) geois.readObject(); // objektua irakurri              
                if (!prak.getKodPro().equals(kodea.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(prak); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    ezabatuta = true;
                }
            } 
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, dena itxi eta fitxategiari izena aldatu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }
        System.gc();
        Files.move(Paths.get(fTemp.getAbsolutePath()), Paths.get(f.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        Proiektua_denda.pausa();
        
        if (ezabatuta)
            System.out.println(kodea+" erreferentziadun praka ondo ezabatu da.");
        else
            System.out.println(kodea+" erreferentziadun prakarik ez dago erregistratuta.");
    }
    
    /* ArrayList-eko Praka guztien datuak erakusteko metodoa, dendan dagoen jakiteko. */
    public static void prakaGutztErakutsi() throws IOException {
        FileInputStream fis = null;
        GoibururikEzObjectInputStream geois = null;
        try {
            fis = new FileInputStream(f);
            geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("PRAKAK:");
            System.out.println("\tKodea\t\tMarka\tKolorea\tSexua\tPrezioa\tTailak\tSasoia\tLuzeera\tMota");
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri   
                prak.printProd(); // objektuaren datuak erakutsi
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
        finally {
            fis.close();
            geois.close();
        }
        System.out.println();
    }
    
    /* Praka baten kodea, ArrayList-ean dagoen kontsultatu */
    public static void prakaKontsultatu(String kodea) {
        System.out.println();
        System.out.println("Kodea\tKolorea\tTaila\tKantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri   
                if (prak.getKodPro().equals(kodea)) {
                    prak.prodKontsultatu(); // objektuaren datuak erakutsi
                    bool = true;
                }
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
        if (!bool)
            System.out.println("Ez dago kode hori duen produkturik.");
    }
    
    /* Dauden praka guztiak erakusteko metodoa */
    public static void prakaInbentarioa() {
        boolean bool = false;
        System.out.println("\nPRAKAK:");
        System.out.println("\tKodea\tMarka\tSexua\tKantitatea");
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri   
                prak.prodInbentarioa();// objektuaren datuak erakutsi
                bool = true;
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
        if (!bool)
            System.out.println("\tEz dago prakarik.");      
    }
    
    /* kantitatea 5 baino gutxiago duten prakak erakusten ditu */
    public static void prakaEskatzeko() {  
        System.out.println("\nPRAKAK:");
        System.out.println("\tKodea\tMarka\tSexua\tKantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri   
                if (prak.getKantStock()<5) {
                    prak.prodInbentarioa();// objektuaren datuak erakutsi
                    bool = true;
                }
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
        if (!bool)
            System.out.println("\tEz dago eskatzeko produkturik.");
    }
    
    /* PRAKAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */ 
    public static void prodSaldu(String kodea, int taila, int kantitatea) {
        boolean bool = false;
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true)); // fitx berrian idazten joateko
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri 
                if (!prak.getKodPro().equals(kodea.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(prak); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    if (!(prak.getTaila()==taila)) {
                        geoos.writeObject(prak); // objektua fitxategi berrian idatzi
                        geoos.flush();
                    }
                    else {
                        if (prak.isEskuragai()) {
                            if (prak.getKodPro().equals(kodea) && prak.getKantStock()>=kantitatea) {
                                prak.setKantStock(prak.getKantStock()-kantitatea); // salduko den prod kantitatea stock-etik kendu
                                geoos.writeObject(prak); // objektua fitxategi berrian idatzi
                                geoos.flush();
                                bool = true;
                                System.out.println(""
                                    + "\tKodea\t-\tPrezioa \n\n"
                                    + "\t"+prak.getKodPro()+"\t-\t"+prak.getPrezioa()+"  (x"+kantitatea+")\n"
                                    + "  --------------------------------------\n"
                                    + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+prak.getPrezioa()*kantitatea+"€");
                            }
                            prak.getPrezioa();
                        }
                    }
                }
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
        System.gc();
        try {
            Files.move(Paths.get(fTemp.getAbsolutePath()), Paths.get(f.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Proiektua_denda.pausa();
        
        if (!bool)
                System.out.println("\tProduktu hori ez dago dendan.");
    }
}
