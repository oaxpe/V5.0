/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Langilea extends Pertsona {
    /* ATRIBUTOAK */
    private String kodLan;
    private double soldata;
    private String eremua; // saltzailea edo garbitzailea den gordetzen du.
    
    /* ERAIKITZAILEAK */
    public Langilea () {
        super();
        setKodLan();
        setSoldata();
        setEremua();
    }
    
    public Langilea (String kodLan, String izena, String abizena1, String abizena2) {
        super(izena, abizena1, abizena2);
        this.kodLan=kodLan;
        this.soldata=1300;
        this.eremua="Saltzailea";
    }
    
    public Langilea (String kodLan, String izena, String abizena1, String abizena2, String nan, /*Date jaiotzeData,*/ String sexua, String herria, String tlf, int soldata) {
        super(izena, abizena1, abizena2, nan, /*jaiotzeData,*/ sexua, herria, tlf);
        this.soldata=soldata;
        this.kodLan=kodLan;
        this.eremua="Saltzailea";
    }
    
    /* METODOAK */
    @Override
    public void printDatuak() {
        System.out.println("Kodea: "+this.kodLan);
        System.out.println("Lan eremua (saltzaile edo garbitzaile): "+this.eremua);
        super.printDatuak();
        System.out.println("Soldata: "+this.soldata+"€");
    }  
    
    @Override
    public void printPerts() {
        super.printPerts();
        System.out.print("\t"+this.eremua);
    }
    
    /* GETTER and SETTER */
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    public double getSoldata() {
        return soldata;
    }

    public void setSoldata() {
        try {
            System.out.print("Sartu soldata: ");
            this.soldata=Double.parseDouble(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println("Zenbaki dezimala bat sartu behar zenuen.");
        }
    }

    public String getKodLan() {
        return kodLan;
    }

    public void setKodLan() {
        try {
            System.out.print("Sartu langilearen kodea (XXX0000000): ");
            this.kodLan=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public String getEremua() {
        return eremua;
    }

    public void setEremua() {
        try {
            System.out.print("Sartu langilearen eremua (saltzailea edo garbitzailea): ");
            eremua=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }
}
