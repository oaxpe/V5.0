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
import proiektua_denda.Hornitzailea;
import proiektua_denda.Proiektua_denda;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class HornitzaileaKudeatu {
    private static File d = new File("Objektuak");
    private static File f = new File(d+"\\hornitzailea.obj");
    private static File fTemp = new File(d+"\\hornTemp.obj");
    /* Hornitzaile berri bat gehitu */
    public static void hornitzaileaGehitu() {
        if (!d.exists()) {
            d.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(f, true));
            System.out.println("Hornitzaile berriaren datuak sartu behar dituzu.");
            Hornitzailea horn1 = new Hornitzailea(); 
            geoos.writeObject(horn1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println("\nDatu hauek dituen hornitzailea gorde da.");
            horn1.printDatuak();      
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));;
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }   
    }
    
    /* Hornitzaile zehatz bat ezabatu */
    public static void hornitzaileaEzabatu(String kodea) throws IOException {
        boolean ezabatuta = false;
        GoibururikEzObjectOutputStream geoos = null;
        try {            
            geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            
            while (true) { // fitxategiko objektuak irakurri
                Hornitzailea horn = (Hornitzailea) geois.readObject(); // objektua irakurri              
                if (!horn.getKodHor().equals(kodea)) { // kodea konparatu
                    horn.printHorn(); // objektuaren datuak inprimatu
                    geoos.writeObject(horn); // objektua fitxategi berrian idatzi
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
            System.out.println("Hornitzailea ezabatu da.");
        }
        else
            System.out.println(kodea+" kodea duen hornitzailerik ez dago erregistratuta.");
        geoos.close();
        System.gc();
        Files.move(Paths.get(fTemp.getAbsolutePath()), Paths.get(f.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        Proiektua_denda.pausa();
    }
    
    /* Hornitzaileen inguruko informazioa erakusten du. */
    public static void hornitzaileGuztiakErakutsi() {
        try {
            FileInputStream fis = new FileInputStream(f);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("HORNITZAILEAK: ");
            System.out.printf("\t%1$-20s    %2$-10s    %3$-10s    %4$-15s    %5$-10s\n", "Kodea", "Izena", "Herria", "Telefonoa", "Email-a");
            while (true) {
                Hornitzailea horn = (Hornitzailea) geois.readObject(); // objektua irakurri              
                horn.printHorn(); // objektuaren datuak erakutsi
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));;
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }
    }
    
    /* Hornitzailearen datuak aldatu (erabiltzaileak hornitzailearen kodea sartu beharko du) */
    public static void hornitzaileaDatuakAldatu(String kodea, int aukera) {
        boolean aldatuta = true;
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fTemp, true)); // fitx berrian idazten joateko
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(f));
            while (true) {
                Hornitzailea horni = (Hornitzailea) geois.readObject(); // objektua irakurri  
                Hornitzailea h = new Hornitzailea(horni.getKodHor(), horni.getIzena(), horni.getHerria(), horni.getTelefonoa(), horni.getEmail());
                if (!(h.getKodHor().equals(kodea.toLowerCase()))) { // kodea konparatu
                    aldatuta=false;
                }
                else {
                    switch (aukera) {
                        case 1:
                            h.setIzena();
                            break;
                        case 2:
                            h.setHerria();
                            break;
                        case 3:
                            h.setTelefonoa();
                            break;
                        case 4:
                            h.setEmail();
                            break;
                        default:
                            aldatuta = false;
                            System.out.println("Ez da aldaketarik egingo.");
                            break;
                    }
                }
                geoos.writeObject(h); // objektua fitxategian idatzi
                geoos.flush();
                if (aldatuta) {                   
                    System.out.println("\nAldatutako datua gorde da.");
                    System.out.println("\nHornitzailearen datuak honako hauek dira: ");
                    h.printDatuak();
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
            Files.move(Paths.get(fTemp.getAbsolutePath()), Paths.get(f.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
            fTemp.delete();
        }
        Proiektua_denda.pausa();  
    }
}
