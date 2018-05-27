/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gestioa.Metodoak;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class Langilea extends Pertsona implements Serializable {
    /* ATRIBUTOAK */
    private String kodLan;
    private double soldata;
    private String eremua; // saltzailea edo garbitzailea den gordetzen du.
    private String dendIzena; // Langileak lan egingo duen dendaren izena
    
    /* ERAIKITZAILEAK */
    public Langilea () {
        super();
    }
    
    public Langilea (String izena, String abizena1, String abizena2, String dendIzena) {
        super(izena, abizena1, abizena2);
        setKodLan();
        this.dendIzena = dendIzena;
        this.soldata=1300;
        this.eremua="Saltzailea";
    }
    
    public Langilea (String kodLan, String izena, String abizena1, String abizena2, String nan, String jaiotzeData, String sexua, String herria, String tlf, double soldata, String eremua, String dendIzena) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, tlf);
        this.kodLan = kodLan;
        this.soldata = soldata;
        this.eremua = eremua;
        this.dendIzena = dendIzena;
    }

    public Langilea (String izena, String abizena1, String abizena2, String nan, String jaiotzeData, String sexua, String herria, String tlf, double soldata, String eremua, String dendIzena) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, tlf);
        setKodLan();
        this.soldata = soldata;
        this.eremua = eremua;
        this.dendIzena = dendIzena;
    }
    
    /* METODOAK */
    @Override
    public void printDatuak() {
        System.out.println("Kodea: "+this.kodLan);
        System.out.println("Lan eremua: "+this.eremua);
        super.printDatuak();
        System.out.printf("Soldata: %.2f€\n", this.soldata); // bi dezimalekin erakusteko
    }  
    
    @Override
    public void printPerts() {
        System.out.printf("\t%1$-10s    ", this.kodLan);
        super.printPerts();
        System.out.printf("    %1$-10s\n", this.eremua);
    }
    
    /* GETTER and SETTER */
    transient BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    public double getSoldata() {
        return soldata;
    }

    public void setSoldata(Double soldata) {
        this.soldata = soldata;
    }

    public String getKodLan() {
        return kodLan;
    }

    public void setKodLan() {
        this.kodLan = Metodoak.kodeakAldatuEtaGorde("Langilea"); // Langilearen kodea automatikoki hartu kodeak.txt fitxategitik
    }
    
    public void setKodLan(String kodea) {
        this.kodLan = kodea;
    }

    public String getEremua() {
        return eremua;
    }

    public void setEremua(String eremua) {
        this.eremua = eremua;
    }

    public String getDendIzena() {
        return dendIzena;
    }

    public void setDendIzena(String dendIzena) {
        this.dendIzena = dendIzena;
    }
}
