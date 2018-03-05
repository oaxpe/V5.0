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

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Denda {
    /* ATRIBUTOAK */
    private String izena;
    private String helbidea;
    private String herria;
    private String kodPostala;
    private String email;
    private String telefonoa;
    
    /* ERAIKITZAILEAK */
    public Denda () {
        this.izena="Denda";
        this.helbidea="San Juan kalea, 3";
        this.herria="Eibar";
        this.kodPostala="20600";
        this.email="denda@gmai.com";
        this.telefonoa="943201258";
    }
    
    public Denda (String izena, String helbidea, String herria, String kodPostala, String email, String tlf) {
        this.izena=izena;
        this.helbidea=helbidea;
        this.herria=herria;
        this.kodPostala=kodPostala;
        this.email=email;
        this.telefonoa=tlf;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("DENDAREN DATUAK:");
        System.out.println("\tIzena: "+this.izena);
        System.out.println("\tHelbidea: "+this.helbidea);
        System.out.println("\tHerria: "+this.herria);
        System.out.println("\tPosta kodea: "+this.kodPostala);
        System.out.println("\tEmail-a: "+this.email);
        System.out.println("\tTelefonoa: "+this.telefonoa);
    }
     
    /* GETTER and SETTER */
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    public String getIzena() {
        return izena;
    }

    public void setIzena() {
        try {
            System.out.print("Sartu izena: ");
            this.izena=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }      
    }

    public String getHelbidea() {
        return helbidea;
    }

    public void setHelbidea() {
        try {
            System.out.print("Sartu helbidea: ");
            this.helbidea=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public String getHerria() {
        return herria;
    }

    public void setHerria() {
        try {
            System.out.print("Sartu herria: ");
            this.herria=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public String getKodPostala() {
        return kodPostala;
    }

    public void setKodPostala() {
        try {
            System.out.print("Sartu posta kodea: ");
            this.kodPostala=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
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
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }    
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa() {
        try {
            do {
                System.out.print("Sartu telefono zenbakia: ");
                this.telefonoa=br.readLine();
            } while (!Metodoak.tlfBalidazioa(telefonoa));
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }     
    }
}
