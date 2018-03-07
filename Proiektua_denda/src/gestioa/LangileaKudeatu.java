/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import proiektua_denda.Langilea;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class LangileaKudeatu {
    private static ArrayList<Langilea> langGuzt = new ArrayList<Langilea>();
    
    /* langileen lan eremua kontrolatzeko metodoa
     * (saltzailea edo garbitzailea izan daitezke) 
     * erabiltzaileak sartutako eremua array-ean dagoen konprobatzen du.
     * Bueltatzen duena, booleano bat da. */
    public static boolean langileEremuaKontrolatu(String eremua) {
        String[] eremuaKontrolatu = { "saltzailea", "garbitzailea"};
        boolean aurkituta = Arrays.asList(eremuaKontrolatu).contains(eremua.toLowerCase());
        if (!aurkituta)
            System.out.println("\tGaizki idatzi duzu. Saiatu berriz.");
        return aurkituta;
    }
    /* Langile berri bat gehitu */
    public static void langileaGehitu() {
        System.out.println("Langile berriaren datuak sartu behar dituzu.\n");
        Langilea lang1 = new Langilea();        
        langGuzt.add(lang1);
        System.out.println("\nDatu hauek dituen langilea gorde da.");
        System.out.println("\nEremua: Langilea");
        lang1.printDatuak();
    }
    
    /* Langile zehatz baten datu guztiak ezabatu */ 
    public static void langileaEzabatu(String nan) {
        boolean ezabatuta = false;
        Iterator<Langilea> iter = langGuzt.iterator();
        while (iter.hasNext()) {
           Langilea lang = iter.next();
            if (lang.getNan().equalsIgnoreCase(nan)) {
                iter.remove();
            }  
        }
        if (ezabatuta)
            System.out.println(nan+" zenbakidun bezeroa ezabatu da.");
        else
            System.out.println(nan+" zenbakia duen bezerorik ez dago erregistratuta.");
    }
    /* Langileen inguruko informazioa erakusten du. */
    public static void langileGuztiakErakutsi() {
        if (langGuzt.isEmpty()) {
            System.out.println("\tEz dago langilerik erregistratuta.");
        }
        else {
            System.out.println("LANGILEAK: ");
            System.out.println("\tLan-eremua\tIzen-abizenak\t\tNAN zenbakia\tSexua\t\tHerria\tTelefonoa");
            for (int i = 0; i < langGuzt.size(); i++) {
                langGuzt.get(i).printPerts();
            }
        }
    }
    
    /* Langilearen datuak aldatu (erabiltzaileak bere dni-a sartu beharko du) */
    public static void langileaDatuakAldatu(String nan) {
        for (Langilea lang : langGuzt) {
            if (lang.getNan().equals(nan)) {
                lang.setIzena();
                lang.setAbizena1();
                lang.setAbizena2();
                lang.setHerria();
                lang.setTelefonoa();
                lang.setSoldata();
            }
        }
    }
}
