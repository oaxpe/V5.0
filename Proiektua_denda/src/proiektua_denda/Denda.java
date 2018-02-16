/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

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
        izena="Denda";
        helbidea="San Juan kalea, 3";
        herria="Eibar";
        kodPostala="20600";
        email="denda@gmai.com";
        telefonoa="943201258";
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
        System.out.println("\tIzena: "+izena);
        System.out.println("\tHelbidea: "+helbidea);
        System.out.println("\tHerria: "+herria);
        System.out.println("\tPosta kodea: "+kodPostala);
        System.out.println("\tEmail-a: "+email);
        System.out.println("\tTelefonoa: "+telefonoa);
    }
     
    /* GETTER and SETTER */
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    public String getIzena() {
        return izena;
    }

    public void setIzena() throws IOException {
        try {
            System.out.print("Sartu izena: ");
            izena=br.readLine();
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
            helbidea=br.readLine();
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
            herria=br.readLine();
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
            kodPostala=br.readLine();
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
            System.out.print("Sartu email-a: ");
            email=br.readLine();
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
            System.out.print("Sartu telefono zenbakia: ");
            telefonoa=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }     
    }
}
