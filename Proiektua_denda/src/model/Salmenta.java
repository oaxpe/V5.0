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
 * @version 3.0
 */
public class Salmenta implements Serializable {
    private String salmZenb; 
    private String data;
    private int kopurua;
    
    
    public Salmenta () {
//        setSalmZenb();
//        setData();
//        setKopurua();
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Salmenta zenbakia: "+salmZenb);
        System.out.println("Data: "+this.data);
        System.out.println("Kopurua: "+this.kopurua);
    }
    public void printSalmenta() {
        System.out.printf("\t%1$-15s    %2$-15s    %3$-10s\n", this.salmZenb, this.data, this.kopurua);
    }
    
    /* GETTER and SETTER */
    transient BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    public String getData() {
        return data;
    }

    public void setData() {
         try {
            System.out.print("Sartu data (uuuu/hh/ee): ");
            this.data = Metodoak.dataGorde(br.readLine()); // sartutako data, uuu/hh/ee formatuan bueltatuko du
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
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
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki bat sartu behar zenuen."));
            setKopurua();
        }
    }

    public String getSalmZenb() {
        return salmZenb;
    }

    public void setSalmZenb() {
        this.salmZenb = Metodoak.kodeakAldatuEtaGorde("Salmenta"); // Salmenta zenbakia automatikoki hartu kodeak.txt fitxategitik
    }
    
}
