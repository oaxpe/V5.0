/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Eskaera {
    private static int eskZenb=0; // eskaera zenbakia ezin da aldatu. Eskaera berri bakoitzari, aurrekoa +1 egiten zaio
    private String hornitzailea;
    private Date data;
    private int kopurua;
    
    
    public Eskaera () {
        setHornitzailea();
        setData();
        setKopurua();
        this.eskZenb+=1;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Eskaera zenbakia: "+this.eskZenb);
        System.out.println("Hornitzailea: "+this.hornitzailea);
        System.out.println("Data: "+this.data);
        System.out.println("Kopurua: "+this.kopurua);
    }

    public void printEskaera() {
        System.out.println("\t"+this.eskZenb+"\t\t"+this.hornitzailea+"\t"+this.kopurua+"\t"+this.data);
    }
    
    
    /* GETTER and SETTER */
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    public String getHornitzailea() {
        return hornitzailea;
    }

    public void setHornitzailea() {
        try {
            System.out.print("Sartu Hornitzailea: ");
            this.hornitzailea = br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public Date getData() {
        return data;
    }

    public void setData() {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Sartu Data (ee/hh/uuuu): ");
            Date fetx = df.parse(br.readLine());
            this.data = fetx;
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
        catch (ParseException e) {
            System.out.println("Ez da kapaza sartutako datuak parseatzeko.");
        }
    }

    public int getKopurua() {
        return kopurua;
    }

    public void setKopurua() {
        try {
            System.out.print("Sartu kopurua: ");
            this.kopurua = Integer.parseInt(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public int getEskZenb() {
        return eskZenb;
    }

    public void setEskZenb() {
        this.eskZenb += 1;
    }

}
