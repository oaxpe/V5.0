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
import model.Denda;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class DendaKudeatu {
    private static File dirObj = new File("Objektuak");
    private static File fDend = new File(dirObj+"\\denda.obj");
    private static File fDendTemp = new File(dirObj+"\\dendaTemp.obj");
    
    /* Denda berri bat gehitu */
    public static void dendaGehitu(Denda dend1) {
        if (!dirObj.exists()) {
            dirObj.mkdir();
        }
        try {
            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fDend, true)); 
            geoos.writeObject(dend1); // objektua fitxategian idatzi
            geoos.flush();
            geoos.close();
            System.out.println("Denda erregistratuta geratu da.");
            System.out.println("\nDatu hauek dituen bezeroa gorde da.");
            System.out.println();
            dend1.printDatuak();
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        }    
    }
 
    /* Denda zehatz baten datu guztiak ezabatu */ 
    public static void dendaEzabatu(String kodea) {
        boolean ezabatuta = false;
        GoibururikEzObjectOutputStream geoos = null;
        try {    
            geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fDendTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fDend));
            
            while (true) { // fitxategiko objektuak irakurri
                Denda dend = (Denda) geois.readObject(); // objektua irakurri              
                if (!dend.getKodDend().toUpperCase().equals(kodea.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(dend); // objektua fitxategi berrian idatzi
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
            Files.move(Paths.get(fDendTemp.getAbsolutePath()), Paths.get(fDend.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(BezeroaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ezabatuta)
            System.out.println(kodea+" zenbakidun bezeroa ezabatu da.");
        else
            System.out.println(kodea+" zenbakia duen bezerorik ez dago erregistratuta.");
    }
    
    /* Dendaren inguruko informazioa erakusten du. */
    public static ArrayList<Denda> dendGuztiakErakutsi() {
        ArrayList<Denda> dendaGuzt = new ArrayList<Denda>();
        try {
            FileInputStream fis = new FileInputStream(fDend);
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(fis);
            while (true) {
                Denda denda = (Denda) geois.readObject(); // objektua irakurri   
                dendaGuzt.add(denda);
            }
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printGorriz("Fitxategia ez du aurkitzen!"));
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak jasotzerakoan"));
        } 
        return dendaGuzt;
    }
}
