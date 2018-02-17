/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Metodoak {
    /* produktuen taila kontrolatzeko metodoa. Taila, array-ean dagoen konprobatzen du. 
     * Bueltatzen duena booleano bat da.*/
    public static boolean tailaKontrolatu(String taila) {
        String[] tailaKontrola = {"XS", "S", "M", "L", "XL", "XXL"}; // taila posibleak gordeko ditu
        boolean aurkituta = Arrays.asList(tailaKontrola).contains(taila.toUpperCase()); // sartutako taila array-ean dagoen begiratzen du (true edo false bueltatzen du)
        return aurkituta;
    }
    
    /* int bat bilatu. adibidez taila*/
    public static boolean tailaKontrolatu(int taila) {
        int[] arr = {38, 40, 42, 44, 46};
        for (int elementua : arr) {
            if (elementua == taila) {
                return true;
            }
        }
        return false;
    }
    
    /* produktuen edo pertsonan sexua (emakumea edo gizona) kontrolatzeko metodoa. 
     * sexua, array-ean dagoen konprobatzen du. 
     * Bueltatzen duena booleano bat da.*/
    public static boolean sexuaKontrolatu(String sexua) {
        String[] sexuaKontrolatu = { "emakumea", "gizona"};
        boolean aurkituta = Arrays.asList(sexuaKontrolatu).contains(sexua.toLowerCase());
        return aurkituta;
    }

    public static boolean emailBalidazioa(String mail) {
         // Email-a balidatzeko expresio erregularra
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"
                + "@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher balidazioa = p.matcher(mail);
        if (!balidazioa.find()) {// email-ak expresio erregularra betetzen duen konprobatzen du
            System.out.println("\tSartutako email-a ez da egokia. Saiatu berriz.");
            return false;
        }
        return true;

    }
}
