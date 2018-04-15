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
import proiektua_denda.Jertsea;
import proiektua_denda.Proiektua_denda;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class JertseaKudeatu {
    private static File d = new File("Objektuak");
    private static File f = new File(d+"\\jertsea.obj");
    private static File fTemp = new File(d+"\\jertsTemp.obj");
    
    /* Jertse berri bat gehitu */
    public static void jertsGehitu() {
        if (!d.exists()) {
            d.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(f, true));
            System.out.println("Jertse berriaren datuak sartu behar dituzu.\n");
            Jertsea jerts1 = new Jertsea();         
            geoos.writeObject(jerts1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println();
            System.out.println("Datu hauek dituen produktua gorde da."
                + "\nProduktua: JERTSEA");
            jerts1.printDatuak();
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }  
    }
    
    /* Jertse zehatz baten datu guztiak ezabatu */    
    public static void jertseaEzabatu(String kodea) throws IOException {
        boolean ezabatuta = false;
        try {    
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            
            while (true) { // fitxategiko objektuak irakurri
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri              
                if (!jerts.getKodPro().equals(kodea.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
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
            System.out.println(kodea+" erreferentziadun jertsea ondo ezabatu da.");
        else
            System.out.println(kodea+" erreferentziadun jertserik ez dago erregistratuta.");
    }
    
    /* ArrayList-eko Jertse guztien datuak erakusteko metodoa */
    public static void jertsGuztErakutsi() throws IOException {
        FileInputStream fis = null;
        GoibururikEzObjectInputStream geois = null;
        try {
            fis = new FileInputStream(f);
            geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("JERTSEAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak");
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri   
                jerts.printProd(); // objektuaren datuak erakutsi
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
    
    /* Jertse baten kodea, ArrayList-ean dagoen kontsultatu, dendan dagoen jakiteko. */
    public static void jertseaKontsultatu(String kodea) {
        System.out.println();
        System.out.printf("%1$-15s    %2$-10s    %3$-10s    %4$-10s\n", "Kodea", "Kolorea", "Taila", "Kantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri   
                if (jerts.getKodPro().equals(kodea)) {
                    jerts.prodKontsultatu(); // objektuaren datuak erakutsi
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
    
    /* Dauden jertse guztiak erakusteko metodoa */
    public static void jertseaInbentarioa() {
        boolean bool = false;
        System.out.println("\nJERTSEAK:");
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", "Kodea", "Marka", "Sexua", "Kantitatea");
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri   
                jerts.prodInbentarioa();// objektuaren datuak erakutsi
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
            System.out.println("Ez dago jertserik.");   
    }
    
    /* kantitatea 5 baino gutxiago duten jertseak erakusten ditu */
    public static void jertseaEskatzeko() {
        System.out.println("\nJERTSEAK:");
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", "Kodea", "Marka", "Sexua", "Kantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri   
                if (jerts.getKantStock()<5) {
                    jerts.prodInbentarioa();// objektuaren datuak erakutsi
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
    
    /* JERTSEAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */
    public static void prodSaldu(String kodea, int kantitatea, String taila) {
        boolean bool = false;
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true)); // fitx berrian idazten joateko
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri  
                if (!jerts.getKodPro().equals(kodea.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    if (!jerts.getTaila().equals(taila.toUpperCase())) {
                        geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
                        geoos.flush();
                    }
                    else {
                        if (jerts.isEskuragai()) {
                            if (jerts.getKodPro().equals(kodea) && jerts.getKantStock()>=kantitatea) {
                                int k = jerts.getKantStock()-kantitatea;
                                jerts.setKantStock(k); // salduko den prod kantitatea stock-etik kendu
                                geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
                                geoos.flush();
                                bool = true;
                                System.out.println(""
                                    + "\tKodea\t-\tPrezioa \n\n"
                                    + "\t"+jerts.getKodPro()+"\t-\t"+jerts.getPrezioa()+"  (x"+kantitatea+")\n"
                                    + "  --------------------------------------\n"
                                    + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+jerts.getPrezioa()*kantitatea+"€");
                            }
                            jerts.getPrezioa();
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
        
        if (!bool)
                System.out.println("\tProduktu hori ez dago dendan.");
    }
}
