/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gestioa.Metodoak;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class Salmenta implements Serializable {
    private String salmZenb; 
    private String data;
    private int kopurua;
    private String kodProd;
    private String tailaProd;
    
    public Salmenta () {

    }
    
    public Salmenta (int kop, String kodea, String taila) {
        setSalmZenb();
        setData();
        this.kopurua = kop;
        this.kodProd = kodea;
        this.tailaProd = taila;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Salmenta zenbakia: "+salmZenb);
        System.out.println("Data: "+this.data);
        System.out.println("Produktuaren kodea: "+kodProd);
        System.out.println("Produktuaren taila: "+tailaProd);
        System.out.println("Kopurua: "+this.kopurua);
    }
    public void printSalmenta() {
        System.out.printf("\t%1$-15s    %2$-15s    %3$-15s    %4$-10s    %5$-10s\n", this.salmZenb, this.data, this.kopurua, this.tailaProd, this.kopurua);
    }
    
    /* GETTER and SETTER */
    public String getData() {
        return data;
    }

    public void setData() {
        Calendar c1 = new GregorianCalendar();
        String egun = Integer.toString(c1.get(Calendar.DATE)); // eguna gorde
        String hilabete = Integer.toString(c1.get(Calendar.MONTH)+1); // hilabetea gorde
        String urte = Integer.toString(c1.get(Calendar.YEAR)); // urtea gorde
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date fetx = null;
        try {
            fetx = df.parse(urte+"/"+hilabete+"/"+egun); // data hori Date formatura parseatu
        } catch (ParseException ex) {
            Logger.getLogger(Eskaera.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.data = Metodoak.dataGorde(fetx); // sartutako data, uuuu/hh/ee formatuan bueltatuko du
    }

    public int getKopurua() {
        return kopurua;
    }

    public void setKopurua(int kop) {
        this.kopurua = kop;
    }

    public String getSalmZenb() {
        return salmZenb;
    }

    public void setSalmZenb() {
        this.salmZenb = Metodoak.kodeakAldatuEtaGorde("Salmenta"); // Salmenta zenbakia automatikoki hartu kodeak.txt fitxategitik
    }
    
    public void setSalmZenb(String salmZenb) {
        this.salmZenb = salmZenb;
    }

    public String getKodProd() {
        return kodProd;
    }

    public void setKodProd(String kodProd) {
        this.kodProd = kodProd;
    }

    public String getTailaProd() {
        return tailaProd;
    }

    public void setTailaProd(String tailaProd) {
        this.tailaProd = tailaProd;
    }
}
