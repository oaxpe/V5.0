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
public abstract class Produktua implements Serializable {
    /* ATRIBUTOAK */
    protected String kodPro; // arropak daukan erreferentzia. Adib:  231532-499
    protected String marka;
    protected double prezioa;
    protected String kolorea;
    protected String sexua;
    protected int kantStock;
    protected boolean eskuragai=false;
    protected int deskontua=0;

    
    /* ERAIKITZAILEAK */
    public Produktua () {
               
    }
    
    public Produktua (String kodea, String sexua, double prezioa) {
        this.kodPro=kodea;
        this.sexua=sexua;
        this.prezioa=prezioa;
    }
    
    public Produktua (String kodea, String marka, double prezioa, String kolorea, String sexua, int kantStock) {
        this.kodPro=kodea;
        this.marka=marka;
        this.prezioa=prezioa;
        this.kolorea=kolorea;
        this.sexua=sexua;
        this.kantStock=kantStock;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Kodea: "+this.kodPro);
        System.out.println("Marka: "+this.marka);
        System.out.printf("Prezioa : %.2f€\n", this.prezioa); // bi dezimalekin erakusteko
        System.out.println("Kolorea: "+this.kolorea);
        System.out.println("Sexua: "+this.sexua);
        System.out.println("Stock-ean: "+this.kantStock);
        if (deskontua>0) {
            System.out.println("Deskontua: %"+this.deskontua);
        }
    }
    
    public void printProd() {
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s", this.kodPro, this.marka, this.kolorea, this.sexua, this.prezioa); 
    }
    
    public void prodKontsultatu() {
        System.out.printf("%1$-15s    %2$-10s", this.kodPro, this.kolorea);
    }
    
    public void prodInbentarioa() {
        System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s\n", this.kodPro, this.marka, this.sexua, this.kantStock);
    }
   

    /* GETTER and SETTER */
    transient BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    public String getKodPro() {
        return kodPro;
    }

    public void setKodPro() {
        try {
            System.out.print("Sartu produktuaren kodea (erreferentzia): ");
            this.kodPro=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka() {
        try {
            System.out.print("Sartu marka: ");
            this.marka=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }   
    }

    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa() {
        try {
            System.out.print("Sartu prezioa: ");
            this.prezioa = Double.parseDouble(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki dezimala bat sartu behar zenuen."));
            setPrezioa();
        }
    }

    public String getKolorea() {
        return kolorea;
    }

    public void setKolorea() {
        try {
           System.out.print("Sartu kolorea: ");
            this.kolorea = br.readLine(); 
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public String getSexua() {
        return sexua;
    }

    public void setSexua() {
        try {
            System.out.print("Emakumea, gizona edo unisex?: ");
            this.sexua=br.readLine(); 
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    } 

    public int getKantStock() {
        return kantStock;
    }

    public void setKantStock() {
        try {
            System.out.print("Sartu Kantitatea: ");
            this.kantStock = Integer.parseInt(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki bat sartu behar zenuen."));
            setKantStock();
        }
    }
    
    public void setKantStock(int kantitatea) {
        this.kantStock = kantitatea;
    }

    public boolean isEskuragai() {
        if (getKantStock()>0)
            this.eskuragai=true;
        return this.eskuragai;
    }

    public void setEskuragai(boolean eskuragai) {
        this.eskuragai = eskuragai;
    }
    
    public int getDeskontua() {
        return deskontua;
    }

    public void setDeskontua() {
        try {
            System.out.print("Sartu deskontua: ");
            this.deskontua = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki bat sartu behar zenuen."));
            setDeskontua();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public void setDeskontua(int deskontua) {
        this.deskontua = deskontua;
    }
}
