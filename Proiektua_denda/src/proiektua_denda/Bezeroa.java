/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import java.io.IOException;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Bezeroa extends Pertsona {
    /* ATRIBUTOAK */
    private String kodBez;
    
    /* ERAIKITZAILEAK */
    public Bezeroa () {
        super();
        setKodBez();
    }
    
    public Bezeroa (String izena, String abizena1, String abizena2, String nan, String sexua, String herria, String tlf, String kodea) {
        super(izena, abizena1, abizena2, nan, sexua, herria, tlf);
        this.kodBez=kodea;
    }
    
    /* METODOAK */
    @Override
    public void printDatuak() {
        System.out.println("Kodea: "+this.kodBez);
        super.printDatuak();
    }
    
    @Override
    public void printPerts() {
        super.printPerts();
    }

    
    /* GETTER and SETTER */
    public String getKodBez() {
        return kodBez;
    }

    public void setKodBez() {
        try {
            System.out.print("Sartu bezeroaren kodea (XXX0000000): ");
            this.kodBez=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }
    
}
