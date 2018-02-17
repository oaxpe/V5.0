/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.util.ArrayList;
import java.util.Iterator;
import proiektua_denda.Kamiseta;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class KamisetaKudeatu {
    private static ArrayList<Kamiseta> alKami = new ArrayList<Kamiseta>();

    /* Kamiseta berri bat gehitu */
    public static void kamisetaGehitu() {
        System.out.println("Kamiseta berriaren datuak sartu behar dituzu.\n");
        Kamiseta kami1 = new Kamiseta();
        alKami.add(kami1);
        System.out.println();
        System.out.println("Datu hauek dituen produktua gorde da."
                + "\nProduktua: KAMISETA");
        kami1.printDatuak();   
    }
    
    /* Kamiseta zehatz baten datu guztiak ezabatu */    
    public static void kamisetaEzabatu(String kodea) {
        Iterator<Kamiseta> iter = alKami.iterator();
        while (iter.hasNext()) {
           Kamiseta kami = iter.next();
            if (kami.getKodPro().equalsIgnoreCase(kodea)) {
                iter.remove();
            }  
        }
        System.out.println(kodea+" erreferentziadun jertsea ondo ezabatu da.");
    }

    /* ArrayList-eko Kamiseta guztien datuak erakusteko metodoa */
    public static void kamisetaGutztErakutsi() {
        System.out.println("KAMISETAK:");
        if (alKami.isEmpty()) {
            System.out.println("\tEz dago kamisetarik erregistratuta.");
        }
        else {
            System.out.println("\tKodea\tMarka\tKolorea\tSexua\tPrezioa\tTailak\tSasoia");
            for (int i = 0; i < alKami.size(); i++) {
                alKami.get(i).printProd();
            }
        }
        System.out.println();
    }
    
    /* Kamiseta baten kodea, ArrayList-ean dagoen kontsultatu, dendan dagoen jakiteko. */
    public static void kamisetaKontsultatu(String kodea) {
        System.out.println("Kodea\tKolorea\tTaila\tKantitatea");
        boolean bool = false;
        for (int i = 0; i < alKami.size(); i++) {
            if (alKami.get(i).getKodPro().equals(kodea)) {
                alKami.get(i).prodKontsultatu();
                bool = true;
            }
        }
        if (!bool)
            System.out.println("Ez dago kode hori duen produkturik.");
    }
    
    /* Dauden kamiseta guztiak erakusteko metodoa */
    public static void kamisetaInbentarioa() {
        System.out.println("KAMISETAK:");
        if (alKami.isEmpty()) {
            System.out.println("\tEz dago kamisetarik.");
        }
        else {
            System.out.println("\tKodea\tMarka\tSexua\tKantitatea");
            for (int i = 0; i < alKami.size(); i++) {
                    alKami.get(i).prodInbentarioa();
            }   
        } 
    }
    
    /* kantitatea 5 baino gutxiago duten kamisetak erakusten ditu */
    public static void kamisetaEskatzeko() {
        System.out.println("KAMISETAK:");
        System.out.println("\tKodea\tMarka\tSexua\tKantitatea");
        boolean bool = false;
        for (int i = 0; i < alKami.size(); i++) {
            if (alKami.get(i).getKantStock()<5) {
                alKami.get(i).prodInbentarioa();
                bool = true; // gutxienez badago eskatzeko produktu bat
            }
        }
        if (!bool)
            System.out.println("\tEz dago eskatzeko produkturik.");
    }
       
    /* KAMISETAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */
    public static void prodSaldu(String kodea, String taila, int kantitatea) {
        boolean bool = false;
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        for (int i = 0; i < alKami.size(); i++) {
            if (alKami.get(i).isEskuragai()) { // gutxienez bat dagoela konprobatzen du
                if (alKami.get(i).getKodPro().equals(kodea) && alKami.get(i).getKantStock()>=kantitatea  && alKami.get(i).getTaila().equals(taila)) {
                    alKami.get(i).setKantStock(alKami.get(i).getKantStock()-kantitatea); // salduko den prod kantitatea stock-etik kendu
                    bool = true;
                    System.out.println(""
                        + "\tKodea\t-\tPrezioa \n\n"
                        + "\t"+alKami.get(i).getKodPro()+"\t-\t"+alKami.get(i).getPrezioa()+"  (x"+kantitatea+")\n"
                        + "  --------------------------------------\n"
                        + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+alKami.get(i).getPrezioa()*kantitatea+"€");
                    break;
                }
                alKami.get(i).getPrezioa();
            }      
        }
        if (!bool)
            System.out.println("\tProduktu hori ez dago dendan.");
    }
    
}
