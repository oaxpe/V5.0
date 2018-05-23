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
import model.Kamiseta;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class KamisetaKudeatu {
    private static File d = new File("Objektuak");
    private static File f = new File(d+"\\kamiseta.obj");
    private static File fTemp = new File(d+"\\kamiTemp.obj");

    /* Kamiseta berri bat gehitu */
    public static void kamisetaGehitu(Kamiseta kami1) {
        if (!d.exists()) {
            d.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(f, true));  
            geoos.writeObject(kami1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println();
            System.out.println("Datu hauek dituen produktua gorde da."
                    + "\nProduktua: KAMISETA");
            kami1.printDatuak();
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }    
    }
    
    /* Kamiseta zehatz baten datu guztiak ezabatu */    
    public static void kamisetaEzabatu(String kodea, String taila) {
        boolean ezabatuta = false;
        try {    
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            
            while (true) { // fitxategiko objektuak irakurri
                Kamiseta kami = (Kamiseta) geois.readObject(); // objektua irakurri              
                if (kami.getKodPro().toUpperCase().equals(kodea.toUpperCase()) && kami.getTaila().equals(taila.toUpperCase())) { // kodea konparatu
                    ezabatuta = true;
                } 
                else {
                    geoos.writeObject(kami); // objektua fitxategi berrian idatzi
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
            Files.move(Paths.get(fTemp.getAbsolutePath()), Paths.get(f.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(KamisetaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (ezabatuta)
            System.out.println(kodea+" erreferentziadun kamiseta ondo ezabatu da.");
        else
            System.out.println(kodea+" erreferentziadun kamisetarik ez dago erregistratuta.");
    }

    /* ArrayList-eko Kamiseta guztien datuak erakusteko metodoa */
    public static ArrayList<Kamiseta> kamisetaGuztErakutsi() {
        ArrayList<Kamiseta> kamiGuzt = new ArrayList<Kamiseta>();
        FileInputStream fis = null;
        GoibururikEzObjectInputStream geois = null;
        try {
            fis = new FileInputStream(f);
            geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("KAMISETAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Sasoia");
            while (true) {
                Kamiseta kami = (Kamiseta) geois.readObject(); // objektua irakurri   
                kami.printProd(); // objektuaren datuak erakutsi
                kamiGuzt.add(kami);
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
                Logger.getLogger(KamisetaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return kamiGuzt;
    }
    
    /* Kamiseta baten kodea, ArrayList-ean dagoen kontsultatu, dendan dagoen jakiteko. */
    public static ArrayList<Kamiseta> kamisetaKontsultatu(String kodea) {
        ArrayList<Kamiseta> kamiKonts = new ArrayList<Kamiseta>();
        System.out.println();
        System.out.printf("%1$-15s    %2$-10s    %3$-10s    %4$-10s\n", "Kodea", "Kolorea", "Taila", "Kantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Kamiseta kami = (Kamiseta) geois.readObject(); // objektua irakurri   
                if (kami.getKodPro().equals(kodea)) {
                    kami.prodKontsultatu(); // objektuaren datuak erakutsi
                    kamiKonts.add(kami);
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
        return kamiKonts;
    }
    
    /* Dauden kamiseta guztiak erakusteko metodoa */
    public static ArrayList<Kamiseta> kamisetaInbentarioa() {
        ArrayList<Kamiseta> kamiEsk = new ArrayList<Kamiseta>();
        boolean bool = false;
        System.out.println("\nKAMISETAK:");
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", "Kodea", "Marka", "Sexua", "Kantitatea");
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Kamiseta kami = (Kamiseta) geois.readObject(); // objektua irakurri   
                kami.prodInbentarioa();// objektuaren datuak erakutsi
                kamiEsk.add(kami);
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
            System.out.println("\tEz dago kamisetarik.");
        return kamiEsk;
    }
    
    /* kantitatea 5 baino gutxiago duten kamisetak erakusten ditu */
    public static ArrayList<Kamiseta> kamisetaEskatzeko() {
        ArrayList<Kamiseta> kamiInb = new ArrayList<Kamiseta>();
        System.out.println("\nKAMISETAK:");
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", "Kodea", "Marka", "Sexua", "Kantitatea");
        boolean bool = false;
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Kamiseta kami = (Kamiseta) geois.readObject(); // objektua irakurri   
                if (kami.getKantStock()<5) {
                    kami.prodInbentarioa();// objektuaren datuak erakutsi
                    kamiInb.add(kami);
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
        return kamiInb;
    }
       
    /* KAMISETAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */
    public static boolean prodSaldu(String kodea, int kantitatea, String taila) {
        boolean bool = false;
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true)); // fitx berrian idazten joateko
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            while (true) {
                Kamiseta kami = (Kamiseta) geois.readObject(); // objektua irakurri   
                if (!kami.getKodPro().toLowerCase().equals(kodea.toLowerCase())) { // kodea konparatu
                    geoos.writeObject(kami); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    if (!kami.getTaila().toLowerCase().equals(taila.toLowerCase())) {
                        geoos.writeObject(kami); // objektua fitxategi berrian idatzi
                        geoos.flush();
                    }
                    else {
                        if (kami.isEskuragai()) {
                            if (kami.getKodPro().toLowerCase().equals(kodea.toLowerCase()) && kami.getKantStock()>=kantitatea) {
                                kami.setKantStock(kami.getKantStock()-kantitatea); // salduko den prod kantitatea stock-etik kendu
                                geoos.writeObject(kami); // objektua fitxategi berrian idatzi
                                geoos.flush();
                                bool = true;
                                System.out.println(""
                                    + "\tKodea\t-\tPrezioa \n\n"
                                    + "\t"+kami.getKodPro()+"\t-\t"+kami.getPrezioa()+"  (x"+kantitatea+")\n"
                                    + "  --------------------------------------\n"
                                    + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+kami.getPrezioa()*kantitatea+"€");
                            }
                            kami.getPrezioa();
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
            fTemp.delete();
        }
        
        if (!bool)
                System.out.println("\tProduktu hori ez dago dendan.");
        return bool;
    }
    
}
