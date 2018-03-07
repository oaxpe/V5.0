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
        System.out.println("Bezero berriaren datuak sartu behar dituzu.\n");
        Bezeroa bez1 = new Bezeroa();         
        bezeroGuzt.add(bez1);
        setNanBezero.add(bez1.getNan());
        System.out.println("\nDatu hauek dituen bezeroa gorde da.");
        System.out.println("\nEremua: Bezeroa");
        bez1.printDatuak();
    }
    
    /* Bezero zehatz baten datu guztiak ezabatu */ 
    public static void bezeroaEzabatu(String nan) {
        Iterator<Bezeroa> iter = bezeroGuzt.iterator();
        boolean ezabatuta = false;
        while (iter.hasNext()) {
            Bezeroa bez = iter.next();
            if (bez.getNan().equalsIgnoreCase(nan)) { // konparaketa
                iter.remove(); // objektua ezabatu
                ezabatuta = true;
            }  
        }
        setNanBezero.remove(nan); // ezabatu behar den bezeroaren NAN zenbakia ezabatu
        
        if (ezabatuta)
            System.out.println(nan+" zenbakidun bezeroa ezabatu da.");
        else
            System.out.println(nan+" zenbakia duen bezerorik ez dago erregistratuta.");
    }
    
    /* Bezeroen inguruko informazioa erakusten du. */
    public static void bezeroGuztiakErakutsi() {
        if (bezeroGuzt.isEmpty()) {
            System.out.println("Ez dago bezerorik erregistratuta.");
        }
        else {
            System.out.println("BEZEROAK: ");
            System.out.println("\tIzen-abizenak\t\tNAN zenbakia\tSexua\t\tHerria\tTelefonoa");
            for (int i = 0; i < bezeroGuzt.size(); i++) {
                bezeroGuzt.get(i).printPerts();
            }
        }
            
    }
    
    /* Bezeroaren datuak aldatu (erabiltzaileak bere dni-a sartu beharko du) */
    public static void bezeroDatuakAldatu(String nan, int aukera) {
        boolean aldatuta = true;
        for (Bezeroa bez : bezeroGuzt) {
            if (bez.getNan().equals(nan)) {
                switch (aukera) {
                    case 1:
                        bez.setIzena();
                        break;
                    case 2:
                        bez.setAbizena1();
                        break;
                    case 3:
                        bez.setAbizena2();
                        break;
                    case 4:
                        bez.setNan();
                        break;
                    case 5:
                        bez.setJaiotzeData();
                        break;
                    case 6:
                        bez.setSexua();
                        break;
                    case 7:
                        bez.setHerria();
                        break;
                    case 8:
                        bez.setTelefonoa();
                        break;
                    default:
                        aldatuta = false;
                        break;
                }
            } 
        }
        if (aldatuta)
            System.out.println("Aldatutako datua gorde da.");
    }
}
