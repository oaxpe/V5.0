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
import model.Praka;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class PrakaKudeatu {
    private static File dirObj = new File("Objektuak");
    private static File fPrak = new File(dirObj+"\\praka.obj");
    private static File fPrakTemp = new File(dirObj+"\\prakTemp.obj");

    /* Praka berri bat gehitu */
    public static void prakaGehitu(Praka prak1) {
        if (!dirObj.exists()) {
            dirObj.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fPrak, true)); 
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
    public static void prakaEzabatu(String kodea, int taila) {
        boolean ezabatuta = false;
        try {    
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fPrakTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fPrak));
            
            while (true) { // fitxategiko objektuak irakurri
                Praka prak = (Praka) geois.readObject(); // objektua irakurri              
                if (prak.getKodPro().toUpperCase().equals(kodea.toUpperCase()) && (prak.getTaila() == taila)) { // kodea eta taila konparatu
                    ezabatuta = true;
                } 
                else {
                    geoos.writeObject(prak); // objektua fitxategi berrian idatzi
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
            Files.move(Paths.get(fPrakTemp.getAbsolutePath()), Paths.get(fPrak.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (ezabatuta)
            System.out.println(kodea+" erreferentziadun praka ondo ezabatu da.");
        else
            System.out.println(kodea+" erreferentziadun prakarik ez dago erregistratuta.");
    }
    
    /* ArrayList-eko Praka guztien datuak erakusteko metodoa, dendan dagoen jakiteko. */
    public static ArrayList<Praka> prakaGutztErakutsi() {
        ArrayList<Praka> prakGuzt = new ArrayList<Praka>();
        FileInputStream fis = null;
        GoibururikEzObjectInputStream geois = null;
        try {
            fis = new FileInputStream(fPrak);
            geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("PRAKAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s    %8$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Luzeera", "Mota");
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri   
                prak.printProd(); // objektuaren datuak erakutsi
                prakGuzt.add(prak);
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
                Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println();
        return prakGuzt;
    }
    
    /* Praka baten kodea, ArrayList-ean dagoen kontsultatu */
    public static ArrayList<Praka> prakaKontsultatu(String kodea) {
        ArrayList<Praka> prakKonts = new ArrayList<Praka>();
        System.out.println();
        System.out.printf("%1$-15s    %2$-10s    %3$-10s    %4$-10s\n", "Kodea", "Kolorea", "Taila", "Kantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(fPrak);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri   
                if (prak.getKodPro().equals(kodea)) {
                    prak.prodKontsultatu(); // objektuaren datuak erakutsi
                    prakKonts.add(prak);
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
        return prakKonts;
    }
    
    /* Dauden praka guztiak erakusteko metodoa */
    public static ArrayList<Praka> prakaInbentarioa() {
        ArrayList<Praka> prakInb = new ArrayList<Praka>();
        boolean bool = false;
        System.out.println("\nPRAKAK:");
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", "Kodea", "Marka", "Sexua", "Kantitatea");
        try {
            FileInputStream fis = new FileInputStream(fPrak);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri   
                prak.prodInbentarioa();// objektuaren datuak erakutsi
                prakInb.add(prak);
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
        return prakInb;
    }
    
    /* kantitatea 5 baino gutxiago duten prakak erakusten ditu */
    public static ArrayList<Praka> prakaEskatzeko() {  
        ArrayList<Praka> prakEsk = new ArrayList<Praka>();
        System.out.println("\nPRAKAK:");
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", "Kodea", "Marka", "Sexua", "Kantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(fPrak);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Praka prak = (Praka) geois.readObject(); // objektua irakurri   
                if (prak.getKantStock()<5) {
                    prak.prodInbentarioa();// objektuaren datuak erakutsi
                    prakEsk.add(prak);
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
        return prakEsk;
    }
    
    /* PRAKAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */ 
    public static boolean prodSaldu(String kodea, int taila, int kantitatea) {
        boolean bool = false;
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fPrakTemp, true)); // fitx berrian idazten joateko
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fPrak));
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
            Files.move(Paths.get(fPrakTemp.getAbsolutePath()), Paths.get(fPrak.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!bool)
                System.out.println("\tProduktu hori ez dago dendan.");
        return bool;
    }
}
