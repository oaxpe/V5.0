/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.util.ArrayList;
import proiektua_denda.Praka;
import java.util.Iterator;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class PrakaKudeatu {
    private static ArrayList<Praka> alPrak = new ArrayList<Praka>();   

    /* Praka berri bat gehitu */
    public static void prakaGehitu() {
        System.out.println("Praka berriaren datuak sartu behar dituzu.");
        Praka prak1 = new Praka();        
        alPrak.add(prak1);
        System.out.println();
        System.out.println("Datu hauek dituen produktua gorde da."
                + "\nProduktua: PRAKA");
        prak1.printDatuak();
    }
    
    /* Praka zehatz baten datu guztiak ezabatu */    
    public static void prakaEzabatu(String kodea) {
        Iterator<Praka> iter = alPrak.iterator();
        while (iter.hasNext()) {
           Praka prak = iter.next();
            if (prak.getKodPro().equalsIgnoreCase(kodea)) {
                iter.remove();
            }  
        }
        System.out.println(kodea+" erreferentziadun praka ondo ezabatu da.");
    }
    
    /* ArrayList-eko Praka guztien datuak erakusteko metodoa, dendan dagoen jakiteko. */
    public static void prakaGutztErakutsi() {
        System.out.println("PRAKAK:");
        if (alPrak.isEmpty()) {
            System.out.println("\tEz dago prakarik erregistratuta.");
        }
        else {
            System.out.println("\tKodea\t\tMarka\tKolorea\tSexua\tPrezioa\tTailak\tSasoia\tLuzeera\tMota");
            for (int i = 0; i < alPrak.size(); i++) {
                    alPrak.get(i).printProd();
            }
        }
        System.out.println();
    }
    
    /* Praka baten kodea, ArrayList-ean dagoen kontsultatu */
    public static void prakaKontsultatu(String kodea) {
        System.out.println("Kodea\tKolorea\tTaila\tKantitatea");
        boolean bool = false;
        for (int i = 0; i < alPrak.size(); i++) {
            if (alPrak.get(i).getKodPro().equals(kodea)) {
                alPrak.get(i).prodKontsultatu();
                bool = true;
            }
        }
        if (!bool)
            System.out.println("Ez dago kode hori duen produkturik.");
    }
    
    /* Dauden praka guztiak erakusteko metodoa */
    public static void prakaInbentarioa() {
        System.out.println("\nPRAKAK:");
        if (alPrak.isEmpty()) {
            System.out.println("\tEz dago prakarik.");
        }
        else {
            System.out.println("\tKodea\tMarka\tSexua\tKantitatea");
            for (int i = 0; i < alPrak.size(); i++) {
                alPrak.get(i).prodInbentarioa();
            }
        }
    }
    
    /* kantitatea 5 baino gutxiago duten prakak erakusten ditu */
    public static void prakaEskatzeko() {      
        System.out.println("\nPRAKAK:");
        System.out.println("\tKodea\tMarka\tSexua\tKantitatea");
        boolean bool = false;
        for (int i = 0; i < alPrak.size(); i++) {
            if (alPrak.get(i).getKantStock()<5)
                alPrak.get(i).prodInbentarioa();
        }
        if (!bool)
            System.out.println("\tEz dago eskatzeko produkturik.");
    }
    
    /* PRAKAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */ 
    public static void prodSaldu(String kodea, int taila, int kantitatea) {
        boolean bool = false;
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        for (int i = 0; i < alPrak.size(); i++) {
            if (alPrak.get(i).isEskuragai()) { // gutxienez bat dagoela konprobatzen du
                if (alPrak.get(i).getKodPro().equals(kodea) && alPrak.get(i).getKantStock()>=kantitatea && alPrak.get(i).getTaila()==taila) {
                    alPrak.get(i).setKantStock(alPrak.get(i).getKantStock()-kantitatea); // salduko den prod kantitatea stock-etik kendu
                    bool = true;
                    System.out.println(""
                        + "\tKodea\t-\tPrezioa \n\n"
                        + "\t"+alPrak.get(i).getKodPro()+"\t-\t"+alPrak.get(i).getPrezioa()+"  (x"+kantitatea+")\n"
                        + "  --------------------------------------\n"
                        + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+alPrak.get(i).getPrezioa()*kantitatea+"€");
                    break;
                }                    
            } 
        }
        if (!bool)
            System.out.println("\tProduktu hori ez dago dendan.");  
    }
}
