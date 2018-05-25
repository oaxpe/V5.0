/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gestioa.Metodoak;
import java.io.BufferedReader;
import java.io.IOException;
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
    
    /* ERAIKITZAILEAK */
    public Langilea () {
//        super();
//        setKodLan();
//        setSoldata();
//        setEremua();
    }
    
    public Langilea (String izena, String abizena1, String abizena2) {
        super(izena, abizena1, abizena2);
        setKodLan();
        this.soldata=1300;
        this.eremua="Saltzailea";
    }
    
    public Langilea (String kodLan, String izena, String abizena1, String abizena2, String nan, String jaiotzeData, String sexua, String herria, String tlf, double soldata, String eremua) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, tlf);
        this.kodLan = kodLan;
        this.soldata = soldata;
        this.eremua = eremua;
    }

    public Langilea (String izena, String abizena1, String abizena2, String nan, String jaiotzeData, String sexua, String herria, String tlf, double soldata, String eremua) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, tlf);
        setKodLan();
        this.soldata = soldata;
        this.eremua = eremua;
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

    public void setSoldata() {
        try {
            System.out.print("Sartu soldata: ");
            this.soldata=Double.parseDouble(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printUrdinez("\tZenbaki dezimala bat sartu behar zenuen."));
            setSoldata();
        }
    }

    public String getKodLan() {
        return kodLan;
    }

    public void setKodLan() {
        this.kodLan = Metodoak.kodeakAldatuEtaGorde("Langilea"); // Langilearen kodea automatikoki hartu kodeak.txt fitxategitik
    }

    public String getEremua() {
        return eremua;
    }

    public void setEremua() {
        try {
            System.out.print("Sartu langilearen eremua (saltzailea edo garbitzailea): ");
            this.eremua=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak sartzerakoan."));
        }
    }
}
