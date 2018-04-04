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
public abstract class Pertsona implements Serializable {
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
        setIzena();
        setAbizena1();
        setAbizena2();
        setNan();
        setJaiotzeData();
        setSexua();
        setHerria();
        setTelefonoa();
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
        System.out.println("\t"+this.izena.concat(" ").concat(this.abizena1).concat(" ").concat(this.abizena2)+"\t"+this.nan+"\t"+this.sexua+"\t"+this.herria+"\t"+this.telefonoa);
    }

    
    /* GETTER and SETTER */
    transient BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    public String getIzena() {
        return izena;
    }

    public void setIzena() {
        try {
            System.out.print("Sartu izena: ");
            this.izena=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }      
    }

    public String getAbizena1() {
        return abizena1;
    }

    public void setAbizena1() {
        try {
            System.out.print("Sartu lehenengo abizena: ");
            this.abizena1=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }       
    }
    
    public String getAbizena2() {
        return abizena2;
    }

    public void setAbizena2() {
        try {
            System.out.print("Sartu bigarren abizena: ");
            this.abizena2=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }
    
    public String getNan() {
        return nan;
    }

    public void setNan() {
        try {
            do {
                System.out.print("Sartu NAN zenbakia: ");
                this.nan=br.readLine().toUpperCase();
            } while (!Metodoak.nanBalidazioa(nan));                
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }         
    }

    public String getJaiotzeData() {
        return jaiotzeData;
    }

    public void setJaiotzeData() {
        try {
            System.out.print("Sartu jaiotze data (uuuu/hh/ee): ");
            this.jaiotzeData = Metodoak.dataGorde(br.readLine()); // sartutako data, uuu/hh/ee formatuan bueltatuko du
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }

    public String getSexua() {
        return sexua;
    }

    public void setSexua() {
        try {
            do {
                System.out.print("Emakumea edo gizona?: ");
                this.sexua=br.readLine(); 
            } while (!Metodoak.sexuaKontrolatu(sexua));
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
            this.herria=br.readLine();
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
                System.out.print("Sartu telefono zenbakia: ");
                this.telefonoa=br.readLine();
            } while (!Metodoak.tlfBalidazioa(telefonoa));  
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
    }
}
