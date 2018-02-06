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
public class Jertsea extends Produktua {
    private String taila;
    
    public Jertsea () {
        super();
        setTaila();
    }
    
    public Jertsea (String kodea, String marka, double prezioa, String kolorea, String sexua, int kantStock, String taila) {
        super(kodea, marka, prezioa, kolorea, sexua, kantStock);
        this.taila=taila;
    }
    
    public Jertsea (String kodea, String sexua, double prezioa, String sasoia) {
        super(kodea, sexua, prezioa);
    }
    
    /* METODOAK */
    @Override
    public void printDatuak() {
        super.printDatuak();
        System.out.println("Taila: "+taila);
        System.out.println();
    }
    
    @Override
    public void printProd() {
        super.printProd();
        System.out.println(taila);
    }
    
    @Override
    public void prodKontsultatu() {
        super.prodKontsultatu();    
        System.out.println("\t"+taila+"\t"+getKantStock());
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
                if (!Metodoak.tailaKontrolatu(taila))
                    System.out.println("\tGaizki sartu duzu taila. Saiatu berriz.");
            } while (!Metodoak.tailaKontrolatu(taila));
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }
    
}
