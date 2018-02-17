/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.Metodoak;
import java.io.IOException;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Kamiseta extends Produktua {
    private String taila;
    private String sasoia; // uda, negua...
    
    public Kamiseta () {
        super();
        setTaila();
        setSasoia();
    }
    
    public Kamiseta (String kodea, String marka, double prezioa, String kolorea, String sexua, int kantStock, String taila, String sasoia) {
        super(kodea, marka, prezioa, kolorea, sexua, kantStock);
        this.taila=taila;
        this.sasoia=sasoia;
    }
    
    public Kamiseta (String kodea, String sexua, double prezioa, String sasoia) {
        super(kodea, sexua, prezioa);
        this.sasoia=sasoia;
    }
    
    /* METODOAK */
    @Override
    public void printDatuak() {
        super.printDatuak();
        System.out.println("Taila: "+this.taila);
        System.out.println("Sasoia: "+this.sasoia);
    }
    
    @Override
    public void printProd() {
        super.printProd();
        System.out.println(this.taila+"\t"+this.sasoia);
    }
    
    @Override
    public void prodKontsultatu() {
        super.prodKontsultatu();    
        System.out.println("\t"+this.taila+"\t"+getKantStock());
    }
    
    
    /* GETTER and SETTER */
    public String getTaila() {
        return taila;
    }

    public void setTaila() {
        try {
            do {
                System.out.print("Sartu taila (XS,S,M,L,XL,XXL): ");
                this.taila = br.readLine().toUpperCase();
            } while (!Metodoak.tailaKontrolatu(taila));
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public String getSasoia() {
        return sasoia;
    }

    public void setSasoia() {
        try {
            System.out.print("Sartu sasoia (uda, negua...): ");
            this.sasoia = br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }
}
