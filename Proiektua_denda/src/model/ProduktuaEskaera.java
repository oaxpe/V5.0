/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class ProduktuaEskaera {
    /* ATRIBUTUAK */
    private String prodKodea; 
    private String dendKodea;
    private String eskKodea;
    private String hornKode;
    private int kopurua;
    
    /* ERAIKITZAILEA */
    public ProduktuaEskaera() {
        
    }

    /* METODOAK */
    public String getProdKodea() {
        return prodKodea;
    }

    public void setProdKodea(String prodKodea) {
        this.prodKodea = prodKodea;
    }

    public String getDendKodea() {
        return dendKodea;
    }

    public void setDendKodea(String dendKodea) {
        this.dendKodea = dendKodea;
    }

    public String getEskKodea() {
        return eskKodea;
    }

    public void setEskKodea(String eskKodea) {
        this.eskKodea = eskKodea;
    }

    public String getHornKode() {
        return hornKode;
    }

    public void setHornKode(String hornKode) {
        this.hornKode = hornKode;
    }

    public int getKopurua() {
        return kopurua;
    }

    public void setKopurua(int kopurua) {
        this.kopurua = kopurua;
    }
    
    
}
