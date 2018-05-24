/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gestioa.Metodoak;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class Jertsea extends Produktua implements Serializable {
    private String taila;
    
    public Jertsea () {

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
        System.out.println("Taila: "+this.taila);
        System.out.println();
    }
    
    @Override
    public void printProd() {
        super.printProd();
        System.out.printf("    %1$-10s\n", this.taila);
    }
    
    @Override
    public void prodKontsultatu() {
        super.prodKontsultatu();    
        System.out.printf("    %1$-10s    %2$-10s\n", this.taila, getKantStock());
    }
    
    /* GETTER and SETTER */
    public String getTaila() {
        return taila;
    }

    public void setTaila() {
        try {
            System.out.print("Sartu taila (XS,S,M,L,XL,XXL): ");
            this.taila = br.readLine().toUpperCase();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki dezimala bat sartu behar zenuen."));
            setTaila();
        }
    }
    
}
