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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Jertsea;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class JertseaKudeatu {
    private static File dirObj = new File("Objektuak");
    private static File fJerts = new File(dirObj+"\\jertsea.obj");
    private static File fJertsTemp = new File(dirObj+"\\jertsTemp.obj");
    
    /* Jertse berri bat gehitu */
    public static void jertsGehitu(Jertsea jerts1) {
        if (!dirObj.exists()) {
            dirObj.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fJerts, true));    
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
    public static void jertseaEzabatu(String kodea, String taila) {
        boolean ezabatuta = false;
        try {    
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fJertsTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fJerts));
            
            while (true) { // fitxategiko objektuak irakurri
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri              
                if (jerts.getKodPro().toUpperCase().equals(kodea.toUpperCase()) && (jerts.getTaila().equals(taila.toUpperCase()))) { // kodea konparatu
                    ezabatuta = true;
                } 
                else {
                    geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
                    geoos.flush();
                }
            } 
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, dena itxi eta fitxategiari izena aldatu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }
        try {
            System.gc();
            Files.move(Paths.get(fJertsTemp.getAbsolutePath()), Paths.get(fJerts.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(JertseaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (ezabatuta)
            System.out.println(kodea+" erreferentziadun jertsea ondo ezabatu da.");
        else
            System.out.println(kodea+" erreferentziadun jertserik ez dago erregistratuta.");
    }
    
    /* ArrayList-eko Jertse guztien datuak erakusteko metodoa */
    public static ArrayList<Jertsea> jertsGuztErakutsi() {
        ArrayList<Jertsea> jertsGuzt = new ArrayList<Jertsea>();
        FileInputStream fis = null;
        GoibururikEzObjectInputStream geois = null;
        try {
            fis = new FileInputStream(fJerts);
            geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("JERTSEAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak");
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri   
                jerts.printProd(); // objektuaren datuak erakutsi
                jertsGuzt.add(jerts);
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
        finally {
            try {
                fis.close();
                geois.close();
            } catch (IOException ex) {
                Logger.getLogger(JertseaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println();
        return jertsGuzt;
    }
    
    /* Jertse baten kodea, ArrayList-ean dagoen kontsultatu, dendan dagoen jakiteko. */
    public static ArrayList<Jertsea> jertseaKontsultatu(String kodea) {
        ArrayList<Jertsea> jertsKonts = new ArrayList<Jertsea>();
        System.out.println();
        System.out.printf("%1$-15s    %2$-10s    %3$-10s    %4$-10s\n", "Kodea", "Kolorea", "Taila", "Kantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(fJerts);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri   
                if (jerts.getKodPro().equals(kodea)) {
                    jerts.prodKontsultatu(); // objektuaren datuak erakutsi
                    jertsKonts.add(jerts);
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
        return jertsKonts;
    }
    
    /* Dauden jertse guztiak erakusteko metodoa */
    public static ArrayList<Jertsea> jertseaInbentarioa() {
        ArrayList<Jertsea> jertsInb = new ArrayList<Jertsea>();
        boolean bool = false;
        System.out.println("\nJERTSEAK:");
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", "Kodea", "Marka", "Sexua", "Kantitatea");
        try {
            FileInputStream fis = new FileInputStream(fJerts);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri   
                jerts.prodInbentarioa();// objektuaren datuak erakutsi
                jertsInb.add(jerts);
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
        return jertsInb;
    }
    
    /* kantitatea 5 baino gutxiago duten jertseak erakusten ditu */
    public static ArrayList<Jertsea> jertseaEskatzeko() {
        ArrayList<Jertsea> jertsEsk = new ArrayList<Jertsea>();
        System.out.println("\nJERTSEAK:");
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", "Kodea", "Marka", "Sexua", "Kantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(fJerts);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri   
                if (jerts.getKantStock()<5) {
                    jerts.prodInbentarioa();// objektuaren datuak erakutsi
                    jertsEsk.add(jerts);
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
        return jertsEsk;
    }
    
    /* JERTSEAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */
    public static boolean prodSaldu(String kodea, int kantitatea, String taila) {
        boolean bool = false;
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fJertsTemp, true)); // fitx berrian idazten joateko
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fJerts));
            while (true) {
                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri  
                if (!jerts.getKodPro().toLowerCase().equals(kodea.toLowerCase())) { // kodea konparatu
                    geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    if (!jerts.getTaila().toLowerCase().equals(taila.toLowerCase())) {
                        geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
                        geoos.flush();
                    }
                    else {
                        if (jerts.isEskuragai()) {
                            if (jerts.getKodPro().toLowerCase().equals(kodea.toLowerCase()) && jerts.getKantStock()>=kantitatea) {
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
            Files.move(Paths.get(fJertsTemp.getAbsolutePath()), Paths.get(fJerts.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!bool)
                System.out.println("\tProduktu hori ez dago dendan.");
        return bool;
    }
}
