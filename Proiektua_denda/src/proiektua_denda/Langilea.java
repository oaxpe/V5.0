/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.LangileaKudeatu;
import gestioa.Metodoak;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class Langilea extends Pertsona implements Serializable {
    /* ATRIBUTOAK */
    private static String kodLan = "Lan0999";
    private double soldata;
    private String eremua; // saltzailea edo garbitzailea den gordetzen du.
    
    /* ERAIKITZAILEAK */
    public Langilea () {
        super();
        setKodLan();
        setSoldata();
        setEremua();
    }
    
    public Langilea (String izena, String abizena1, String abizena2) {
        super(izena, abizena1, abizena2);
        setKodLan();
        this.soldata=1300;
        this.eremua="Saltzailea";
    }
    
    public Langilea (String kodLan, String izena, String abizena1, String abizena2, String nan, Date jaiotzeData, String sexua, String herria, String tlf, double soldata, String eremua) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, tlf);
        this.kodLan = kodLan;
        this.soldata = soldata;
        this.eremua = eremua;
    }
    
    /* METODOAK */
    @Override
    public void printDatuak() {
        System.out.println("Kodea: "+this.kodLan);
        System.out.println("Lan eremua: "+this.eremua);
        super.printDatuak();
        System.out.println("Soldata: "+this.soldata+"€");
    }  
    
    @Override
    public void printPerts() {
        System.out.print("\t"+this.eremua);
        super.printPerts();
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
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki dezimala bat sartu behar zenuen."));
            setSoldata();
        }
    }

    public String getKodLan() {
        return kodLan;
    }

    public void setKodLan() {
        // Langilearen kode zenbakia automatikoki hartu
        String zenb = String.valueOf(Integer.parseInt(this.kodLan.substring(3, this.kodLan.length()))+1);
        this.kodLan = this.kodLan.substring(0, 3);
        this.kodLan += zenb;
    }

    public String getEremua() {
        return eremua;
    }

    public void setEremua() {
        try {
            do {
                System.out.print("Sartu langilearen eremua (saltzailea edo garbitzailea): ");
                this.eremua=br.readLine();
            } while (!LangileaKudeatu.langileEremuaKontrolatu(this.eremua));
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }
}
