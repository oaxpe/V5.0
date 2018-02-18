/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Bezeroa extends Pertsona {
    /* ATRIBUTOAK */
    private static String kodBez = "Bez0999";
    
    /* ERAIKITZAILEAK */
    public Bezeroa () {
        super();
        setKodBez();
    }
    
    public Bezeroa (String izena, String abizena1, String abizena2, String nan, String sexua, String herria, String tlf) {
        super(izena, abizena1, abizena2, nan, sexua, herria, tlf);
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
        super.printPerts();
    }

    
    /* GETTER and SETTER */
    public String getKodBez() {
        return kodBez;
    }

    public void setKodBez() {
        // Bezeroaren kode zenbakia automatikoki hartu
        String zenb = String.valueOf(Integer.parseInt(this.kodBez.substring(3, this.kodBez.length()))+1);
        this.kodBez = this.kodBez.substring(0, 3);
        this.kodBez += zenb;
    }
    
}
