/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class Kamiseta extends Produktua {
    private String taila;
    private String sasoia; // uda, negua...
    
    public Kamiseta () {

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
        System.out.printf("    %1$-10s    %2$-10s\n", this.taila, this.sasoia);
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

    public void setTaila(String taila) {
        this.taila = taila;
    }

    public String getSasoia() {
        return sasoia;
    }

    public void setSasoia(String sasoia) {
        this.sasoia = sasoia;
    }
}
