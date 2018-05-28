/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class Metodoak {
    /* Mezuak urdinez kontsolan inprimitzeko (db-ra konektatzen denean adibidez) */
    public static String printUrdinez(String textua) {
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";
        return (ANSI_BLUE + textua + ANSI_RESET);
    }
    
    /* Errore mezuak larroxaz inprimatzeko */
    public static String printErrMezuak(String textua) {
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_RESET = "\u001B[0m";
        return (ANSI_PURPLE + textua + ANSI_RESET);
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
            System.out.println(printUrdinez("\tSartutako email-a ez da egokia. Saiatu berriz."));
            return false;
        }
        return true;
    }
    
    /* NAN zenbakia egokia den edo ez konprobatzen duen metodoa.*/
    public static boolean nanBalidazioa(String nan) {
        if (nan.length() != 9) {
            System.out.println(printUrdinez("\tSartutako nan zenbakia ez da egokia."));
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
                System.out.println(printUrdinez("Sartutako nan zenbakia ez da egokia."));
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
            System.out.println(printUrdinez("\tSartutako telefono zenbakia ez da egokia. Saiatu berriz."));
            return false;
        }
        return true;
    }
    
    /* kodeak.txt fitxategian gordeta dauden objektuen kodeak aldatzeko metodoa 
    *  Objektu berri bat sortzen denean, azkenengo sortutako objektuaren kodea gordeko da 
    *  (aurrekoa +1 eginez) */
    public static String kodeakAldatuEtaGorde(String hasiera) {
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        String kodea = null;
        File f = new File("kodeak.txt"); // kodeak gordeta dauden fitxategia
        hasiera = hasiera.toLowerCase(); // minuskulaz 
        try {
            ArrayList<String> kodGuztiak = new ArrayList<String>(); // fitxategiko kode guztiak arraylistean gordetzeko
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String lerroa;

            while((lerroa=br.readLine()) != null){
                if (lerroa.contains(hasiera)) { //kodearen hasiera konprobatu
                    kodea = String.valueOf(lerroa.substring(0, hasiera.length()+1) + (Integer.parseInt(lerroa.substring(hasiera.length()+1)) +1)); // kodearen balioari 1 gehitu
                    lerroa = lerroa.replace(lerroa, kodea);
                }
                kodGuztiak.add(lerroa); // lerroa arraylistean gorde
            }
            
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            
            for (int i = 0; i<kodGuztiak.size(); i++) {
                pw.println(kodGuztiak.get(i)); // fitxategian kode guztiak berriz idatzi (aldaketa eginda)
                pw.flush();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fitxategia ez da existitzen."); 
        } catch (IOException ex) {
            Logger.getLogger(Metodoak.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                fr.close();
                br.close();
                pw.flush();
                fw.close();
                pw.close();
            } catch (IOException ex) {
                Logger.getLogger(Metodoak.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return kodea; // kode zenbakia bueltatu, objektuan gordetzeko
    }
    
    /* String-a data bezela kontrolatzeko metodoa. Data uuuu/hh/ee formatuan bueltatuko du. */
    public static String dataGorde(Date data) {
        String dataFormatua = null;
        dataFormatua = new SimpleDateFormat("yyyy/MM/dd").format(data.getTime()); // formatu zehatz baten jarri            
        return dataFormatua; 
    }
    
    
    public static Date dataErakutsi(String s) {
        Date data  = null;
        DateFormat dataFormatua = new SimpleDateFormat("yyyy/MM/dd");//.format(data.getTime()); // formatu zehatz baten jarri            
        try {
            data = dataFormatua.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(Metodoak.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
    }
}
