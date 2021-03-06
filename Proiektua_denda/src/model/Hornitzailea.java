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
public class Hornitzailea {
    /* ATRIBUTOAK */
    private String kodHor;
    private String izena;
    private String herria;
    private String telefonoa;
    private String email;
    
    public Hornitzailea () {

    }
    
    public Hornitzailea (String izena, String herria, String tlf, String email) {
        setKodHor();
        this.izena = izena;
        this.herria = herria;
        this.telefonoa = tlf;
        this.email = email;
    }

    public Hornitzailea(String kodHor, String izena, String herria, String telefonoa, String email) {
        this.kodHor = kodHor;
        this.izena = izena;
        this.herria = herria;
        this.telefonoa = telefonoa;
        this.email = email;
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
    public String getKodHor() {
        return kodHor;
    }

    public void setKodHor() {
        this.kodHor  = Metodoak.kodeakAldatuEtaGorde("Hornitzailea"); // Eskaera zenbakia automatikoki hartu kodeak.txt fitxategitik 
    }
    
    public void setKodHor(String kodea) {
        this.kodHor  = kodea; 
    }
    
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getHerria() {
        return herria;
    }

    public void setHerria(String herria) {
        this.herria = herria;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String tlf) {
        this.telefonoa = tlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
