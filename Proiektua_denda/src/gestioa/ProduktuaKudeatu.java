/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class ProduktuaKudeatu {


    /* Dendan dauden produktuen inbentarioa */
    public static void inbentarioa() {
        System.out.println(""
                + "-------------------------------------------------------------\n"
                + "|        Dendako produktuen inbentarioa (produktuka)        |\n"
                + "-------------------------------------------------------------\n");
        KamisetaKudeatu.kamisetaInbentarioa();
        JertseaKudeatu.jertseaInbentarioa();
        PrakaKudeatu.prakaInbentarioa();
    }
    
    /* Dendan dauden produktu bakoitzaren kantitatea 5 baino txikiagoa bada, produktu hori eskatu egin behar da */
    public static void prodEskatzeko() {
        System.out.println(""
                + "--------------------------------------------\n"
                + "|           Eskatzeko produktuak           |\n"
                + "--------------------------------------------\n");
        KamisetaKudeatu.kamisetaEskatzeko();
        JertseaKudeatu.jertseaEskatzeko();
        PrakaKudeatu.prakaEskatzeko();
    }
    
}