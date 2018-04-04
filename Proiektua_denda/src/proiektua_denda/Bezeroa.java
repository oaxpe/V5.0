/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.Metodoak;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class Bezeroa extends Pertsona implements Serializable {
    /* ATRIBUTOAK */
    private String kodBez;
    
    /* ERAIKITZAILEAK */
    public Bezeroa () {
        super();
        setKodBez();
    }
    
    public Bezeroa (String kodBez, String izena, String abizena1, String abizena2, String nan, Date jaiotzeData, String sexua, String herria, String tlf) {
        super(izena, abizena1, abizena2, nan, jaiotzeData, sexua, herria, tlf);
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
        super.printPerts();
    }

    
    /* GETTER and SETTER */
    public String getKodBez() {
        return kodBez;
    }

    public void setKodBez() {
        this.kodBez = Metodoak.kodeakAldatuEtaGorde("Hornitzailea"); // Bezeroaren kodea automatikoki hartu kodeak.txt fitxategitik 
    }
    
}
