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
        if (!aurkituta)
            System.out.println("\tGaizki sartu duzu taila. Saiatu berriz.");
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
        System.out.println("\tGaizki sartu duzu taila. Saiatu berriz.");
        return false;
    }
    
    /* produktuen edo pertsonan sexua (emakumea edo gizona) kontrolatzeko metodoa. 
     * sexua, array-ean dagoen konprobatzen du. 
     * Bueltatzen duena booleano bat da.*/
    public static boolean sexuaKontrolatu(String sexua) {
        String[] sexuaKontrolatu = { "emakumea", "gizona", "unisex"};
        boolean aurkituta = Arrays.asList(sexuaKontrolatu).contains(sexua.toLowerCase());
        if (!aurkituta)
            System.out.println("\tGaizki idatzi duzu. Saiatu berriz.");
        return aurkituta;
    }
    
    /* Email-a ondo estrukturatuta dagoen konprobatzen duen metodoa.
     * Expresio erregularrak erabiltzen dira (adibidea@adibidea.com) */
    public static boolean emailBalidazioa(String mail) {
         // Email-a balidatzeko expresio erregularra
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"
                + "@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher balidazioa = p.matcher(mail);
        if (!balidazioa.find()) { // email-ak expresio erregularra betetzen duen konprobatzen du
            System.out.println("\tSartutako email-a ez da egokia. Saiatu berriz.");
            return false;
        }
        return true;
    }
    
    /* NAN zenbakia egokia den edo ez konprobatzen duen metodoa.*/
    public static boolean nanBalidazioa(String nan) {
        if (nan.length() != 9) {
            System.out.println("\tSartutako nan zenbakia ez da egokia.");
            return false;
        }
        else {
            String letra = nan.substring(8).toUpperCase(); // azkenengo karakterea hartzeko            
            String zenb = "";
            char[] nanLetrak = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'}; // NAN-ak izan dezakeen letrak
                    
            // Lehenengo 8 karaktereak zenbakiak diren konprobatu
            for (int i=0; i<(nan.length()-1); i++) {
                if(!Character.isDigit(nan.charAt(i))){ // karaktereak banaka begiratu digitoak diren edo ez
                    break;   
                }
                zenb += nan.charAt(i); // digitoak direnak, zenb aldagaian gordetzen dira
            }
            
            int zenbInt = Integer.parseInt(zenb); //String-a int bihurtu (zenbakiekin eragiketak egiteko)
            int hondarra = zenbInt%23; // zatiketaren hondarra kalkulatu
            if ((Character.toUpperCase(nan.charAt(8)))!=nanLetrak[hondarra]) { // azkenengo karakterea arry-ean dagoen konprobatu
                System.out.println("Sartutako nan zenbakia ez da egokia.");
                return false;
            }
            return true;
        }
    }
    
    /* Telefonoa ondo estrukturatuta dagoen konprobatzen duen metodoa.
     * Expresio erregularrak erabiltzen dira */
    public static boolean tlfBalidazioa(String telefonoa) { // momentuz ez da erabiltzen main-ean
        // Telefonoa balidatzeko expresio erregularra
        Pattern p = Pattern.compile("(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}"); // +34|0034|34 opcional
        
        Matcher balidazioa = p.matcher(telefonoa);
        if (!balidazioa.find()) {// email-ak expresio erregularra betetzen duen konprobatzen du
            System.out.println("\tSartutako telefono zenbakia ez da egokia. Saiatu berriz.");
            return false;
        }
        return true;
    }
}
