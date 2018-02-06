/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import proiektua_denda.Bezeroa;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class BezeroaKudeatu {
    private static ArrayList<Bezeroa> bezeroGuzt = new ArrayList<Bezeroa>();
    static Set setNanBezero = new HashSet(); // Bezeroen NAN-ak gordeko dira (ezin dira duplikatuta egon)
    
    /* Bezero berri bat gehitu */
    public static void bezeroaGehitu() {
        Bezeroa bez1 = new Bezeroa();         
        System.out.println("\nEremua: Bezeroa");
        bez1.printDatuak();
        bezeroGuzt.add(bez1);
        setNanBezero.add(bez1.getNan());
    }
    
    /* Bezero zehatz baten datu guztiak ezabatu */ 
    public static void bezeroaEzabatu(String nan) {
        Iterator<Bezeroa> iter = bezeroGuzt.iterator();
        while (iter.hasNext()) {
            Bezeroa bez = iter.next();
            if (bez.getNan().equalsIgnoreCase(nan)) { // konparaketa
                iter.remove(); // objektua ezabatu
            }  
        }
        setNanBezero.remove(nan); // ezabatu behar den bezeroaren NAN zenbakia ezabatu
    }
    
    /* Bezeroen inguruko informazioa erakusten du. */
    public static void bezeroGuztiakErakutsi() {
        System.out.println("BEZEROAK: ");
        System.out.println("\tIzen-abizenak\t\tNAN zenbakia\tSexua\t\tHerria\tTelefonoa");
        for (int i = 0; i < bezeroGuzt.size(); i++) {
            bezeroGuzt.get(i).printPerts();
        }
    }
    
    /* Bezeroaren datuak aldatu (erabiltzaileak bere dni-a sartu beharko du) */
    public static void bezeroDatuakAldatu(String nan) {
        for (Bezeroa bez : bezeroGuzt) {
            if (bez.getNan().equals(nan)) {
                bez.setIzena();
                bez.setAbizena1();
                bez.setAbizena2();
                bez.setHerria();
                bez.setTelefonoa();
            }
        }
    }
    
}
