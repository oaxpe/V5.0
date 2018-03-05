/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Salmenta {
    private static String salmZenb="Salmenta#0999"; // eskaera zenbakia ezin da aldatu. Eskaera berri bakoitzari, aurrekoa +1 egiten zaio
    private Date data;
    private int kopurua;
    
    
    public Salmenta () {
        setSalmZenb();
        setData();
        setKopurua();
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Salmenta zenbakia: "+salmZenb);
        System.out.println("Data: "+this.data);
        System.out.println("Kopurua: "+this.kopurua);
    }
    public void printSalmenta() {
        System.out.println("\t"+this.salmZenb+"\t\t"+this.data+"\t"+this.kopurua);
    }
    
    /* GETTER and SETTER */
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    public Date getData() {
        return data;
    }

    public void setData() {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Sartu Data (ee/hh/uuuu): ");
            Date fetx = df.parse(br.readLine());
            this.data = fetx;
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
        catch (ParseException gaizki) {
            System.out.println("Ez da kapaza sartutako datuak parseatzeko.");
        }
    }

    public int getKopurua() {
        return kopurua;
    }

    public void setKopurua() {
        try {
            System.out.print("Sartu kopurua: ");
            this.kopurua = Integer.parseInt(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println("\tZenbaki bat sartu behar zenuen.");
            setKopurua();
        }
    }

    public static String getSalmZenb() {
        return salmZenb;
    }

    public static void setSalmZenb() {
        // Salmenta zenbakia automatikoki hartu
        String zenb = String.valueOf(Integer.parseInt(salmZenb.substring(9, salmZenb.length()))+1);
        salmZenb = salmZenb.substring(0, 9);
        salmZenb += zenb;
    }
    
}
