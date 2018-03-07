/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.util.ArrayList;
import java.util.Iterator;
import proiektua_denda.Jertsea;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class JertseaKudeatu {
    private static ArrayList<Jertsea> alJerts = new ArrayList<Jertsea>(); 
    
    /* Jertse berri bat gehitu */
    public static void jertsGehitu() {
        System.out.println("Jertse berriaren datuak sartu behar dituzu.\n");
        Jertsea jerts1 = new Jertsea();
        alJerts.add(jerts1); // arraylist-ean gehitu
        System.out.println();
        System.out.println("Datu hauek dituen produktua gorde da."
                + "\nProduktua: JERTSEA");
        jerts1.printDatuak();               
        
    }
    
    /* Jertse zehatz baten datu guztiak ezabatu */    
    public static void jertseaEzabatu(String kodea) {
        Iterator<Jertsea> iter = alJerts.iterator();
        while (iter.hasNext()) {
           Jertsea jerts = iter.next();
            if (jerts.getKodPro().equalsIgnoreCase(kodea)) { // konparaketa
                iter.remove(); // ezabatu
            }  
        }
        System.out.println(kodea+" erreferentziadun jertsea ondo ezabatu da.");
    }
    
    /* ArrayList-eko Jertse guztien datuak erakusteko metodoa */
    public static void jertsGuztErakutsi() {
        System.out.println("JERTSEAK:");
        if (alJerts.isEmpty()) {
            System.out.println("\tEz dago jertserik erregistratuta.");
        }
        else {
            System.out.println("\tKodea\t\tMarka\tKolorea\tSexua\tPrezioa\tTailak\tSasoia");
            for (int i = 0; i < alJerts.size(); i++) {
                alJerts.get(i).printProd();
            }
        }
        System.out.println();
    }
    
    /* Jertse baten kodea, ArrayList-ean dagoen kontsultatu, dendan dagoen jakiteko. */
    public static void jertseaKontsultatu(String kodea) {
        System.out.println("Kodea\tKolorea\tTaila\tKantitatea");
        boolean bool = false;
        for (int i = 0; i < alJerts.size(); i++) {
            if (alJerts.get(i).getKodPro().equals(kodea)) {
                alJerts.get(i).prodKontsultatu();
                bool = true;
            }
        }
        if (!bool)
            System.out.println("Ez dago kode hori duen produkturik.");
    }
    
    /* Dauden jertse guztiak erakusteko metodoa */
    public static void jertseaInbentarioa() {
        System.out.println("\nJERTSEAK:");
        if (alJerts.isEmpty()) {
            System.out.println("\tEz dago jertserik.");
        }
        else {
            System.out.println("\tKodea\tMarka\tSexua\tKantitatea");
            for (int i = 0; i < alJerts.size(); i++) {
                alJerts.get(i).prodInbentarioa();
            }
        }    
    }
    
    /* kantitatea 5 baino gutxiago duten jertseak erakusten ditu */
    public static void jertseaEskatzeko() {
        System.out.println("\nJERTSEAK:");
        System.out.println("\tKodea\tMarka\tSexua\tKantitatea");
        boolean bool = false;
        for (int i = 0; i < alJerts.size(); i++) {
            if (alJerts.get(i).getKantStock()<5)
                alJerts.get(i).prodInbentarioa();
        }
        if (!bool)
            System.out.println("\tEz dago eskatzeko produkturik.");
    }
    
    /* JERTSEAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */
    public static void prodSaldu(String kodea, int kantitatea, String taila) {
        boolean bool = false;
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        for (int i = 0; i < alJerts.size(); i++) {
            if (alJerts.get(i).isEskuragai()) { // gutxienez bat dagoela konprobatzen du
                if (alJerts.get(i).getKodPro().equals(kodea) && alJerts.get(i).getKantStock()>=kantitatea  && alJerts.get(i).getTaila().equals(taila)) {
                    alJerts.get(i).setKantStock(alJerts.get(i).getKantStock()-kantitatea); // salduko den prod kantitatea stock-etik kendu
                    bool = true;
                    System.out.println(""
                        + "\tKodea\t-\tPrezioa \n\n"
                        + "\t"+alJerts.get(i).getKodPro()+"\t-\t"+alJerts.get(i).getPrezioa()+"  (x"+kantitatea+")\n"
                        + "  --------------------------------------\n"
                        + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+alJerts.get(i).getPrezioa()*kantitatea+"€");
                    break;
                }
                alJerts.get(i).getPrezioa();
            }      
        }
        if (!bool)
            System.out.println("\tProduktu hori ez dago dendan.");
    }

}
