/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gestioa.Metodoak;
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
public class Salmenta {
    private String salmZenb; 
    private String data;
    private double prezTotala;
    private int salmProdKantitatea;
    private String prodKodea;
    private String prodTaila;
    
    public Salmenta () {
        
    }
    
    public Salmenta (int salmProdKantitatea, String prodKodea, String taila) {
        setSalmZenb();
        setData();
        this.salmProdKantitatea = salmProdKantitatea;
        this.prodKodea = prodKodea;
        this.prodTaila = taila;
    }
    
    public Salmenta (double prezioTotala) {
        setSalmZenb();
        setData();
        this.prezTotala = prezioTotala;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Salmenta zenbakia: " + this.salmZenb);
        System.out.println("Data: " + this.data);
        System.out.println("Salmetaren prezio totala: " + this.prezTotala);
    }
    public void printSalmenta() {
        System.out.printf("\t%1$-15s    %2$-15s    %3$-15s\n", this.salmZenb, this.data, this.prezTotala);
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
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getSalmZenb() {
        return salmZenb;
    }

    public void setSalmZenb() {
        this.salmZenb = Metodoak.kodeakAldatuEtaGorde("Salmenta"); // Salmenta zenbakia automatikoki hartu kodeak.txt fitxategitik
    }
    
    public void setSalmZenb (String kodea) {
        this.salmZenb = kodea;
    }

    public double getPrezTotala() {
        return prezTotala;
    }

    public void setPrezTotala(double prezTotala) {
        this.prezTotala = prezTotala;
    }

    public int getSalmProdKantitatea() {
        return salmProdKantitatea;
    }

    public void setSalmProdKantitatea(int salmProdKantitatea) {
        this.salmProdKantitatea = salmProdKantitatea;
    }

    public String getProdKodea() {
        return prodKodea;
    }

    public void setProdKodea(String prodKodea) {
        this.prodKodea = prodKodea;
    }

    public String getProdTaila() {
        return prodTaila;
    }

    public void setProdTaila(String prodTaila) {
        this.prodTaila = prodTaila;
    }
}
