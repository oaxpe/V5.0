/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.Metodoak;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class Praka extends Produktua implements Serializable {
    private int taila; //38, 40, 42, 44...
//    private String sasoia; // uda, negua...
    private int luzeera;
    private String mota;
    
    
    public Praka () {
        super();
        setTaila();
//        setSasoia(sasoia);
        setLuzeera();
        setMota();
    }
    
    public Praka (String kodea, String marka, double prezioa, String kolorea, String sexua, int kantStock, int taila/*, String sasoia*/) {
        super(kodea, marka, prezioa, kolorea, sexua, kantStock);
        this.taila=taila;
        this.luzeera=80;
        this.mota="Elastikoa";
        //this.sasoia=sasoia;
    }
    
    public Praka (String kodea, String sexua, double prezioa/*, String sasoia*/) {
        super(kodea, sexua, prezioa);
//        this.sasoia=sasoia;
        this.luzeera=80;
        this.mota="Elastikoa";
    }
    
    /* METODOAK */
    @Override
    public void printDatuak() {
        super.printDatuak();
        System.out.println(""
                + "Taila: "+this.taila
                + "\nLuzeera: "+this.luzeera
                + "\nMota: "+this.mota);
//        System.out.println("Sasoia: "+sasoia);
    }
    
    @Override
    public void printProd() {
        super.printProd();
        System.out.printf("    %1$-10s    %2$-10s    %3$-10s\n", this.taila, this.luzeera, this.mota);
    }
    
    @Override
    public void prodKontsultatu() {
        super.prodKontsultatu();    
        System.out.printf("    %1$-10s    %2$-10s\n",this.taila, getKantStock());
    }
    
    
    /* GETTER and SETTER */
    public int getTaila() {
        return taila;
    }

    public void setTaila() {
        try {
            do {
                System.out.print("Sartu taila (38,40,42,44,46): ");
                this.taila = Integer.parseInt(br.readLine());
            } while (!Metodoak.tailaKontrolatu(taila));
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("\tZenbaki bat sartu behar zenuen."));
            setTaila();
        }
    }

//    public String getSasoia() {
//        return sasoia;
//    }
//
//    public void setSasoia(String sasoia) {
//        this.sasoia = sasoia;
//    }

    public int getLuzeera() {
        return luzeera;
    }

    public void setLuzeera() {
        try {
            System.out.print("Sartu luzeera: ");
            this.luzeera = Integer.parseInt(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
        }
    }
    
    public String getMota() {
        return mota;
    }

    public void setMota() {
        try {
           System.out.print("Sartu mota: ");
            this.mota = br.readLine(); 
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }  
}
