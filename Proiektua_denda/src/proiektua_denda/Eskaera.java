/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.Metodoak;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class Eskaera implements Serializable {
    private String eskZenb; 
    private String hornitzailea;
    private String data;
    private int kopurua;    
    
    public Eskaera () {
        setHornitzailea();
        setData();
        setKopurua();
        setEskZenb();
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Eskaera zenbakia: "+this.eskZenb);
        System.out.println("Hornitzailea: "+this.hornitzailea);
        System.out.println("Data: "+this.data);
        System.out.println("Kopurua: "+this.kopurua);
    }

    public void printEskaera() {
        System.out.println("\t"+this.eskZenb+"\t\t"+this.hornitzailea+"\t"+this.kopurua+"\t"+this.data);
    }
    
    
    /* GETTER and SETTER */
    transient BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    public String getHornitzailea() {
        return hornitzailea;
    }

    public void setHornitzailea() {
        try {
            System.out.print("Sartu Hornitzailea: ");
            this.hornitzailea = br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public String getData() {
        return data;
    }

    public void setData() {
        Calendar c1 = new GregorianCalendar();
        String egun = Integer.toString(c1.get(Calendar.DATE)); // eguna gorde
        String hilabete = Integer.toString(c1.get(Calendar.MONTH)+1); // hilabetea gorde
        String urte = Integer.toString(c1.get(Calendar.YEAR)); // urtea gorde
        this.data = Metodoak.dataGorde(urte+"/"+hilabete+"/"+egun); // sartutako data, uuu/hh/ee formatuan bueltatuko du
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
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki bat sartu behar zenuen."));
            setKopurua();
        }
    }

    public String getEskZenb() {
        return eskZenb;
    }

    public void setEskZenb() {
        this.eskZenb = Metodoak.kodeakAldatuEtaGorde("Eskaera"); // Eskaera zenbakia automatikoki hartu kodeak.txt fitxategitik
    }
}
