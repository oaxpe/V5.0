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
import model.Bezeroa;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class BezeroaKudeatu {
    private static File dirObj = new File("Objektuak");
    private static File fBez = new File(dirObj+"\\bezeroa.obj");
    private static File fBezTemp = new File(dirObj+"\\bezTemp.obj");
    
    /* Bezero berri bat gehitu */
    public static void bezeroaGehitu(Bezeroa bez1) {
        if (!dirObj.exists()) {
            dirObj.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fBez, true)); 
            geoos.writeObject(bez1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println("Bezeroa erregistratuta geratu da.");
            System.out.println("\nDatu hauek dituen bezeroa gorde da.");
            System.out.println("\nEremua: Bezeroa");
            bez1.printDatuak();
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printUrdinez("Fitxategia ez du aurkitzen!"));
        } catch (IOException ex) {
            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak jasotzerakoan"));
        }    
    }
    
    /* Bezero zehatz baten datu guztiak ezabatu */ 
    public static void bezeroaEzabatu(String nan) {
        boolean ezabatuta = false;
        GoibururikEzObjectOutputStream geoos = null;
        try {    
            geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fBezTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fBez));
            
            while (true) { // fitxategiko objektuak irakurri
                Bezeroa bez = (Bezeroa) geois.readObject(); // objektua irakurri              
                if (!bez.getNan().toUpperCase().equals(nan.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(bez); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    ezabatuta = true;
                }
            } 
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printUrdinez("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak jasotzerakoan"));
        }
        try {
            geoos.close();
            System.gc();
            Files.move(Paths.get(fBezTemp.getAbsolutePath()), Paths.get(fBez.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(BezeroaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ezabatuta)
            System.out.println(nan+" zenbakidun bezeroa ezabatu da.");
        else
            System.out.println(nan+" zenbakia duen bezerorik ez dago erregistratuta.");
    }
    
    /* Bezeroen inguruko informazioa erakusten du. */
    public static ArrayList<Bezeroa> bezeroGuztiakErakutsi() {
        ArrayList<Bezeroa> bezGuzt = new ArrayList<Bezeroa>();
        try {
            FileInputStream fis = new FileInputStream(fBez);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            System.out.println("BEZEROAK: ");
            System.out.printf("\t%1$-10s    %2$-10s    %3$-20s  %4$-10s    %5$-15s    %6$-10s    %7$-10s    %8$-10s\n", "Bezero kodea", "Izena", "Abizenak", "NAN zenbakia", "Jaiotze data", "Sexua", "Herria", "Telefonoa"); // inprimitzen den informazioari formatua emateko
            while (true) {
                Bezeroa bez = (Bezeroa) geois.readObject(); // objektua irakurri   
                bez.printPerts(); // objektuaren datuak erakutsi
                bezGuzt.add(bez);
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printUrdinez("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak jasotzerakoan"));
        } 
        return bezGuzt;
    }
    
    /* Bezeroaren datuak aldatu (erabiltzaileak bere dni-a sartu beharko du) */
    public static void bezeroDatuakAldatu(String nan, int aukera) {
        boolean aldatuta = true;
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fBezTemp, true)); // fitx berrian idazten joateko
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fBez));
            while (true) {
                Bezeroa bez = (Bezeroa) geois.readObject(); // objektua irakurri   
                Bezeroa b = new Bezeroa(bez.getKodBez(), bez.getIzena(), bez.getAbizena1(), bez.getAbizena2(), bez.getNan(), bez.getJaiotzeData(), bez.getSexua(), bez.getHerria(), bez.getTelefonoa());
                if (!b.getNan().equals(nan.toUpperCase())) { // kodea konparatu
                    aldatuta=false;
                }
                else {
                    switch (aukera) {
                        case 1:
                            b.setIzena();
                            break;
                        case 2:
                            b.setAbizena1();
                            break;
                        case 3:
                            b.setAbizena2();
                            break;
                        case 4:
                            b.setNan();
                            break;
                        case 5:
                            b.setJaiotzeData();
                            break;
                        case 6:
                            b.setSexua();
                            break;
                        case 7:
                            b.setHerria();
                            break;
                        case 8:
                            b.setTelefonoa();
                            break;
                        default:
                            aldatuta = false;
                            System.out.println("Ez da aldaketarik egingo.");
                            break;
                    }
                }
                geoos.writeObject(b); // objektua fitxategian idatzi
                geoos.flush();
                if (aldatuta) {                   
                    System.out.println("\nAldatutako datua gorde da.");
                    System.out.println("\nBezeroaren datuak honako hauek dira: ");
                    b.printDatuak();
                }
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
            System.gc();
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printUrdinez("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak jasotzerakoan"));
        }
        
        try {
            Files.move(Paths.get(fBezTemp.getAbsolutePath()), Paths.get(fBez.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
            fBezTemp.delete();
        }
    }
}
