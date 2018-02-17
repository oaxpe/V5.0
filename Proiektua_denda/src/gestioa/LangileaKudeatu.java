/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.util.ArrayList;
import java.util.Iterator;
import proiektua_denda.Langilea;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class LangileaKudeatu {
    private static ArrayList<Langilea> langGuzt = new ArrayList<Langilea>();
    
    /* Langile berri bat gehitu */
    public static void langileaGehitu() {
        Langilea lang1 = new Langilea();         
        System.out.println("\nEremua: Langilea");
        lang1.printDatuak();
        langGuzt.add(lang1);
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
            System.out.println("\tIzen-abizenak\t\tNAN zenbakia\tSexua\t\tHerria\tTelefonoa\tLan-eremua");
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
