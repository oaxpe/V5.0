/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.io.IOException;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class ProduktuaKudeatu {


    /* Dendan dauden produktuen inbentarioa */
    public static void inbentarioa() {
        System.out.print(""
                + "-------------------------------------------------------------\n"
                + "|        Dendako produktuen inbentarioa (produktuka)        |\n"
                + "-------------------------------------------------------------\n");
        KamisetaKudeatu.kamisetaInbentarioa();
        JertseaKudeatu.jertseaInbentarioa();
        PrakaKudeatu.prakaInbentarioa();
    }
    
    /* Dendan dauden produktu bakoitzaren kantitatea 5 baino txikiagoa bada, produktu hori eskatu egin behar da */
    public static void prodEskatzeko() {
        System.out.print(""
                + "--------------------------------------------\n"
                + "|           Eskatzeko produktuak           |\n"
                + "--------------------------------------------\n");
        KamisetaKudeatu.kamisetaEskatzeko();
        JertseaKudeatu.jertseaEskatzeko();
        PrakaKudeatu.prakaEskatzeko();
    }
    
    public static void prodErakutsi() throws IOException {
        System.out.print(""
                + "------------------------------------------\n"
                + "|        Dendako produktu guztiak        |\n"
                + "------------------------------------------\n");
        KamisetaKudeatu.kamisetaGutztErakutsi();
        JertseaKudeatu.jertsGuztErakutsi();
        PrakaKudeatu.prakaGutztErakutsi();
    }
    
    /* Produktuen taila kontrolatzeko metodoa. Taila (String) bueltatu. */
    public static String[] tailaKontrolatuString() {
        String[] tailaString = {"XS", "S", "M", "L", "XL", "XXL"}; // taila posibleak gordeko ditu
        return tailaString;
    }
    
    /* Produktuen taila kontrolatzeko metodoa. Taila (int) bueltatu. */
    public static int[] tailaKontrolatuZenb() {
        int[] arr = {38, 40, 42, 44, 46};
        return arr;
    }
    
    /* Produktuen sexua kontrolatzeko metodoa. Sexua bueltatu. */
    public static String[] sexuaKontrolatu() {
        String[] sexuaKontrolatu = { "Emakumea", "Gizona", "Unisex"};
        return sexuaKontrolatu;
    }
    
    /* Produktuen sasoia kontrolatzeko metodoa. Sasoia bueltatu. */
    public static String[] sasoiaKontrolatu() {
        String[] sasoia = {"Udaberria", "Uda", "Udazkena", "Negua"};
        return sasoia;
    }
    
    /* Produktu mota (praken kasuan adibidez) kontrolatzeko metodoa. Mota bueltatu. */
    public static String[] motaKontrolatu() {
        String[] mota = {"Elastikoa", "Leggins", "Pitillo"};
        return mota;
    }
}