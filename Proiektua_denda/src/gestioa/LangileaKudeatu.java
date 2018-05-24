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
import model.Langilea;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class LangileaKudeatu {
    private static File dirObj = new File("Objektuak");
    private static File fLang = new File(dirObj+"\\langilea.obj");
    private static File fLangTemp = new File(dirObj+"\\langTemp.obj");
    
    /* langileen lan eremua bistan ikusteko */
    public static String[] langileEremuaKontrolatu() {
        String[] eremua = { "Saltzailea", "Garbitzailea"};
        return eremua;
    }
    
    /* Langile berri bat gehitu */
    public static void langileaGehitu(Langilea lang1) {
        if (!dirObj.exists()) {
            dirObj.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fLang, true));        
            geoos.writeObject(lang1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println("\nDatu hauek dituen langilea gorde da.");
            System.out.println("\nEremua: Langilea");
            lang1.printDatuak();
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }    
    }
    
    /* Langile zehatz baten datu guztiak ezabatu */ 
    public static void langileaEzabatu(String nan) {
        boolean ezabatuta = false;
        GoibururikEzObjectOutputStream geoos = null;
        try {    
            geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fLangTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fLang));
            
            while (true) { // fitxategiko objektuak irakurri
                Langilea lang = (Langilea) geois.readObject(); // objektua irakurri              
                if (!lang.getNan().toUpperCase().equals(nan.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(lang); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    ezabatuta = true;
                }
            } 
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }
        try {
            geoos.close();
            System.gc();
            Files.move(Paths.get(fLangTemp.getAbsolutePath()), Paths.get(fLang.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(LangileaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (ezabatuta)
            System.out.println(nan+" zenbakidun bezeroa ezabatu da.");
        else
            System.out.println(nan+" zenbakia duen bezerorik ez dago erregistratuta.");
    }
    
    /* Langileen inguruko informazioa erakusten du. */
    public static ArrayList<Langilea> langileGuztiakErakutsi() {
        ArrayList<Langilea> langGuzt = new ArrayList<Langilea>();
        try {
            FileInputStream fis = new FileInputStream(fLang);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("LANGILEAK: ");
            System.out.printf("\t%1$-10s    %2$-10s    %3$-20s    %4$-10s  %5$-15s    %6$-10s    %7$-10s    %8$-10s    %9$-10s\n", "Langile kodea", "Izena", "Abizenak", "NAN zenbakia", "Jaiotze data", "Sexua", "Herria", "Telefonoa", "Lan-eremua");  // inprimitzen den informazioari formatua emateko
            while (true) {
                Langilea lang = (Langilea) geois.readObject(); // objektua irakurri   
                lang.printPerts(); // objektuaren datuak erakutsi
                langGuzt.add(lang);
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
        return langGuzt;
    }
    
    /* Langilearen datuak aldatu (erabiltzaileak bere dni-a sartu beharko du) */
    public static void langileaDatuakAldatu(String nan, int aukera) {
        boolean aldatuta = true;
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fLangTemp, true)); // fitx berrian idazten joateko
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fLang));
            while (true) {
                Langilea lang = (Langilea) geois.readObject(); // objektua irakurri   
                Langilea l = new Langilea(lang.getKodLan(), lang.getIzena(), lang.getAbizena1(), lang.getAbizena2(), lang.getNan(), lang.getJaiotzeData(), lang.getSexua(), lang.getHerria(), lang.getTelefonoa(), lang.getSoldata(), lang.getEremua());
                if (!l.getNan().equals(nan.toUpperCase())) { // kodea konparatu
                    aldatuta=false;
                }
                else {
                    switch (aukera) {
                        case 1:
                            l.setIzena();
                            break;
                        case 2:
                            l.setAbizena1();
                            break;
                        case 3:
                            l.setAbizena2();
                            break;
                        case 4:
                            l.setNan();
                            break;
                        case 5:
                            l.setJaiotzeData();
                            break;
                        case 6:
                            l.setSexua();
                            break;
                        case 7:
                            l.setHerria();
                            break;
                        case 8:
                            l.setTelefonoa();
                            break;
                        case 9:
                            l.setSoldata();
                            break;
                        case 10:
                            l.setEremua();
                            break;
                        default:
                            aldatuta = false;
                            System.out.println("Ez da aldaketarik egingo.");
                            break;
                    }
                }
                geoos.writeObject(l); // objektua fitxategian idatzi
                geoos.flush();
                if (aldatuta) {                   
                    System.out.println("\nAldatutako datua gorde da.");
                    System.out.println("\nBezeroaren datuak honako hauek dira: ");
                    l.printDatuak();
                }
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
            System.gc();
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }
        
        try {
            Files.move(Paths.get(fLangTemp.getAbsolutePath()), Paths.get(fLang.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
            fLangTemp.delete();
        }
    }
}
