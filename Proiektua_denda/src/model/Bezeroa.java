/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gestioa.Metodoak;
import java.io.Serializable;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class Bezeroa extends Pertsona implements Serializable {
    /* ATRIBUTOAK */
    private String kodBez;
    
    /* ERAIKITZAILEAK */
    public Bezeroa () {
//        super();
//        setKodBez();
    }
    
    public Bezeroa (String izena, String abizena1, String abizena2, String nan, String jaiotzeData, String sexua, String herria, String tlf) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, tlf);
        setKodBez();
    }
    
    /* METODOAK */
    @Override
    public void printDatuak() {
        System.out.println("Kodea: "+this.kodBez);
        super.printDatuak();
    }
    
    @Override
    public void printPerts() {
        System.out.printf("\t%1$-10s    ", this.kodBez);  // inprimitzen den informazioari formatua emateko
        super.printPerts();
        System.out.println();
    }

    
    /* GETTER and SETTER */
    public String getKodBez() {
        return kodBez;
    }

    public void setKodBez() {
        this.kodBez = Metodoak.kodeakAldatuEtaGorde("Bezeroa"); // Bezeroaren kodea automatikoki hartu kodeak.txt fitxategitik 
    }
    
}
