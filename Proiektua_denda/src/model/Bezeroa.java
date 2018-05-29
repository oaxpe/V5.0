/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gestioa.Metodoak;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class Bezeroa extends Pertsona {
    /* ATRIBUTOAK */
    private String kodBez;
    
    /* ERAIKITZAILEAK */
    public Bezeroa () {
        super();
    }
    
    public Bezeroa (String izena, String abizena1, String abizena2, String nan, String jaiotzeData, String sexua, String herria, String tlf) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, tlf);
        setKodBez();
    }

    public Bezeroa(String kodBez, String izena, String abizena1, String abizena2, String nan, String jaiotzeData, String sexua, String herria, String telefonoa) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, telefonoa);
        this.kodBez = kodBez;
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
    
    public void setKodBez(String kodea) {
        this.kodBez = kodea;
    }
    
}
