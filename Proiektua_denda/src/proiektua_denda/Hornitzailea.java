/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.Metodoak;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class Hornitzailea implements Serializable {
    /* ATRIBUTOAK */
    private String kodHor;
    private String izena;
    private String herria;
    private String telefonoa;
    private String email;
    
    public Hornitzailea () {
        setKodHor();
        setIzena();
        setHerria();
        setTelefonoa();
        setEmail();
    }
    
    public Hornitzailea (String kodea, String izena, String herria, String tlf, String email) {
        this.kodHor = kodea;
        this.izena=izena;
        this.herria=herria;
        this.telefonoa=tlf;
        this.email=email;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Hornitzailearen datuak:");
        System.out.println("\tKodea: "+this.kodHor);
        System.out.println("\tIzena: "+this.izena);
        System.out.println("\tHerria: "+this.herria);
        System.out.println("\tTelefonoa: "+this.telefonoa);
        System.out.println("\tEmail-a: "+this.email);
    }
    
    public void printHorn() {
         System.out.printf("\t%1$-20s    %2$-10s    %3$-10s    %4$-15s    %5$-10s\n", this.kodHor, this.izena, this.herria, this.telefonoa, this.email);
    }
    
    
    /* GETTER and SETTER */
    transient BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    public String getKodHor() {
        return kodHor;
    }

    public void setKodHor() {
        this.kodHor  = Metodoak.kodeakAldatuEtaGorde("Hornitzailea"); // Eskaera zenbakia automatikoki hartu kodeak.txt fitxategitik 
    }
    
    public String getIzena() {
        return izena;
    }

    public void setIzena() {
        try {
            System.out.print("Sartu izena: ");
            this.izena = br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public String getHerria() {
        return herria;
    }

    public void setHerria() {
        try {
            System.out.print("Sartu herria: ");
            this.herria = br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa() {
        try {
            do {
                System.out.print("Sartu telefonoa: ");
                this.telefonoa = br.readLine();
            } while (!Metodoak.tlfBalidazioa(telefonoa));
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        try {
            do {
                System.out.print("Sartu email-a: ");
                this.email=br.readLine().toLowerCase();
            } while (!Metodoak.emailBalidazioa(email));
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }    
    }
}
