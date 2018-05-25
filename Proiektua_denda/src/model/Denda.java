/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import gestioa.Metodoak;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class Denda /*implements Serializable*/ { 
    /* ATRIBUTOAK */
    private String kodDend;
    private String izena;
    private String helbidea;
    private String herria;
    private int kodPostala;
    private String telefonoa;
    private String email;
    
    /* ERAIKITZAILEAK */
    public Denda () {
        
    }
    
    public Denda (String izena, String helbidea, String herria, int kodPostala, String tlf, String email) {
        setKodDend();
        this.izena = izena;
        this.helbidea = helbidea;
        this.herria = herria;
        this.kodPostala = kodPostala;
        this.telefonoa = tlf;
        this.email = email;
    }
    
    public Denda (String kodea, String izena, String helbidea, String herria, int kodPostala, String tlf, String email) {
        this.kodDend = kodea;
        this.izena = izena;
        this.helbidea = helbidea;
        this.herria = herria;
        this.kodPostala = kodPostala;
        this.telefonoa = tlf;
        this.email = email;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("DENDAREN DATUAK:");
        System.out.println("\tKodea: " + this.kodDend);
        System.out.println("\tIzena: " + this.izena);
        System.out.println("\tHelbidea: " + this.helbidea);
        System.out.println("\tHerria: " + this.herria);
        System.out.println("\tPosta kodea: " + this.kodPostala);
        System.out.println("\tEmail-a: " + this.email);
        System.out.println("\tTelefonoa: " + this.telefonoa);
    }
     
    /* GETTER and SETTER */
    transient BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    public String getKodDend() {
        return kodDend;
    }

    public void setKodDend() {
        this.kodDend = Metodoak.kodeakAldatuEtaGorde("Denda"); // Bezeroaren kodea automatikoki hartu kodeak.txt fitxategitik 
    }
    
    public void setKodDend(String kodea) {
        this.kodDend = kodea;
    }
    
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getHelbidea() {
        return helbidea;
    }

    public void setHelbidea(String helb) {
        this.helbidea=helb;
    }

    public String getHerria() {
        return herria;
    }

    public void setHerria(String herria) {
        System.out.print("Sartu herria: ");
        this.herria=herria;
    }

    public int getKodPostala() {
        return kodPostala;
    }

    public void setKodPostala(int pk) {
        this.kodPostala = pk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String tlf) {
        this.telefonoa = tlf;
    }
}
