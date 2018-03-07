/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.util.ArrayList;
import proiektua_denda.Salmenta;
/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class SalmentaKudeatu {
    private static ArrayList<Salmenta> salmentaGuzt = new ArrayList<Salmenta>();
    
    /* Salmenta berri bat gehitu/gestionatu */
    public static void salmentaGehitu() {
        System.out.println("Salmenta berriaren datuak sartu behar dituzu.\n");
        Salmenta salmenta = new Salmenta();
        salmentaGuzt.add(salmenta);
        System.out.println("\nDatu hauek dituen salmenta gorde da.");
        salmenta.printDatuak();
    }
    /* Eskaeren inguruko informazioa erakusten du. */
    public static void salmentaGuztiakErakutsi() {
        if (salmentaGuzt.isEmpty()) {
            System.out.println("Ez dago salmentarik erregistratuta.");
        }
        else {
            System.out.println("SALMENTAK: ");
            System.out.println("\tSalmenta zenb\tData\tKopurua");
            for (int i = 0; i < salmentaGuzt.size(); i++) {
                salmentaGuzt.get(i).printSalmenta();
            }
        }   
    }
}
