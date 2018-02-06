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
public abstract class Produktua {
    /* ATRIBUTOAK */
    protected String kodPro; // arropak daukan erreferentzia. Adib:  231532-499
    protected String marka;
    protected double prezioa;
    protected String kolorea;
    protected String sexua;
    protected int kantStock;
    protected boolean eskuragai=false;
    protected int deskontua=0;
    protected int tailaInt;
    protected String tailaString;

    
    /* ERAIKITZAILEAK */
    public Produktua () {
        setKodPro();
        setMarka();
        setPrezioa();
        setKolorea();
        setSexua();
        setKantStock();                
    }
    
    public Produktua (String kodea, String sexua, double prezioa) {
        this.kodPro=kodea;
        this.sexua=sexua;
        this.prezioa=prezioa;
    }
    
    public Produktua (String kodea, String marka, double prezioa, String kolorea, String sexua, int kantStock) {
        this.kodPro=kodea;
        this.marka=marka;
        this.prezioa=prezioa;
        this.kolorea=kolorea;
        this.sexua=sexua;
        this.kantStock=kantStock;
    }
    
    /* METODOAK */
    public void printDatuak() {
        System.out.println("Kodea: "+kodPro);
        System.out.println("Marka: "+marka);
        System.out.println("Prezioa : "+prezioa+"€");
        System.out.println("Kolorea: "+kolorea);
        System.out.println("Sexua: "+sexua);
        System.out.println("Stock-ean: "+kantStock);
        if (deskontua>0) {
            System.out.println("Deskontua: %"+deskontua);
        }
    }
    
    public void printProd() {
        System.out.print("\t"+kodPro+"\t"+marka+"\t"+kolorea+"\t"+sexua+"\t"+prezioa+"\t");
    }
    
    public void prodKontsultatu() {
        System.out.print(kodPro+"\t"+kolorea);
    }
    
    public void prodInbentarioa() {
        System.out.println("\t"+kodPro+"\t"+marka+"\t"+sexua+"\t"+kantStock);
    }
   

    /* GETTER and SETTER */
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    public String getKodPro() {
        return kodPro;
    }

    public void setKodPro() {
        try {
                System.out.print("Sartu produktuaren kodea (erreferentzia): ");
            this.kodPro=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka() {
        try {
            System.out.print("Sartu marka: ");
            this.marka=br.readLine();
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }   
    }

    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa() {
        try {
            System.out.print("Sartu prezioa: ");
            this.prezioa = Double.parseDouble(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println("Zenbaki dezimala bat sartu behar zenuen.");
        }
    }

    public String getKolorea() {
        return kolorea;
    }

    public void setKolorea() {
        try {
           System.out.print("Sartu kolorea: ");
            this.kolorea = br.readLine(); 
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public String getSexua() {
        return sexua;
    }

    public void setSexua() {
        try {
            do {
                System.out.print("Emakumea edo gizona?: ");
                sexua=br.readLine(); // array-ean minuskulaz daudelako
                if (!Metodoak.sexuaKontrolatu(sexua))
                    System.out.println("\tGaizki idatzi duzu. Saiatu berriz.");
            } while (!Metodoak.sexuaKontrolatu(sexua));
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    } 

    public int getKantStock() {
        return kantStock;
    }

    public void setKantStock() {
        try {
            System.out.print("Sartu Kantitatea: ");
            this.kantStock = Integer.parseInt(br.readLine());
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println("Zenbaki bat sartu behar zenuen.");
        }
    }
    
    public void setKantStock(int kantitatea) {
        this.kantStock = kantitatea;
    }

    public boolean isEskuragai() {
        if (getKantStock()>0)
            this.eskuragai=true;
        return this.eskuragai;
    }

    public void setEskuragai(boolean eskuragai) {
        this.eskuragai = eskuragai;
    }
    
    public int getDeskontua() {
        return deskontua;
    }

    public void setDeskontua() {
        try {
            System.out.print("Sartu deskontua: ");
            this.deskontua = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println("Zenbaki bat sartu behar zenuen.");
        }
        catch (IOException gaizki) {
            System.out.println("Arazoak daude datuak sartzerakoan.");
        }
    }

    public void setDeskontua(int deskontua) {
        this.deskontua = deskontua;
    }
    
    public int getTailaInt() {
        return tailaInt;
    }

    public String getTailaString() {
        return tailaString;
    }

}
