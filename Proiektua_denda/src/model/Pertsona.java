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

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public abstract class Pertsona /* implements Serializable */ {
    /* ATRIBUTOAK */
    protected String izena;
    protected String abizena1;
    protected String abizena2;
    protected String nan;
    protected String jaiotzeData;
    protected String sexua;
    protected String herria;
    protected String telefonoa;

    
    /* ERAIKITZAILEAK */
    public Pertsona () {
        
    }
    
    public Pertsona (String izena, String abizena1, String abizena2) {
        this.izena=izena;
        this.abizena1=abizena1;
        this.abizena2=abizena2;
    }
    
    public Pertsona (String izena, String abizena1, String abizena2, String nan, String jaiotzeData, String sexua, String herria, String tlf) {
        this.izena=izena;
        this.abizena1=abizena1;
        this.abizena2=abizena2;
        this.nan=nan;
        this.jaiotzeData=jaiotzeData;
        this.sexua=sexua;
        this.herria=herria;
        this.telefonoa=tlf;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Izen abizenak: "+this.izena+" "+this.abizena1+" "+this.abizena2);
        System.out.println("NAN: "+this.nan);
        System.out.println("Jaiotze data: "+this.jaiotzeData);
        System.out.println("Sexua: "+this.sexua);
        System.out.println("Herria: "+this.herria);
        System.out.println("Tlf: "+this.telefonoa);
    }
    
    public void printPerts() {
        System.out.printf("%1$-10s    %2$-20s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s", this.izena, this.abizena1.concat(" ").concat(this.abizena2), this.nan, this.jaiotzeData, this.sexua, this.herria, this.telefonoa); // inprimitzen den informazioari formatua emateko
    }

    
    /* GETTER and SETTER */
    transient BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;    
    }

    public String getAbizena1() {
        return abizena1;
    }

    public void setAbizena1(String abiz1) {
        this.abizena1 = abiz1;   
    }
    
    public String getAbizena2() {
        return abizena2;
    }

    public void setAbizena2(String abiz2) {
        this.abizena2 = abiz2;
    }
    
    public String getNan() {
        return nan;
    }

    public void setNan(String nan) {
        this.nan = nan;    
    }

    public String getJaiotzeData() {
        return jaiotzeData;
    }

    public void setJaiotzeData(String jaioData) {
        this.jaiotzeData = jaioData;
    }

    public String getSexua() {
        return sexua;
    }

    public void setSexua(String sexua) {
        this.sexua = sexua;
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
}
