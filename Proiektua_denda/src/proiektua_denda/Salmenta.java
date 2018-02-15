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
public class Salmenta {
    private static int salmZenb = 0;
    private Date data;
    private int kopurua;
    
    
    public Salmenta () {
        this.salmZenb+=1;
        setData();
        setKopurua();
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Data: "+data);
        System.out.println("Kopurua: "+kopurua);
    }
    public void printSalmenta() {
        System.out.println("\t"+salmZenb+"\t\t"+data+"\t"+kopurua);
    }
    
    /* GETTER and SETTER */
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

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
        catch (ParseException gaizki) {
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
}
