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
public class ProduktuaSalmenta {
    /* ATRIBUTUAK */
    private String prodKodea; // produktuaren kodea gordeko du
    private String salmKode; // salmentaren kodea gordeko du
    private int kantitatea; // saltzen den produktu kantitatea
    private String prodTaila;
    private double prodPrezioa; // prezio unitarioa
    
    /* ERAIKITZAILEA */
    public ProduktuaSalmenta() {
        
    }
    
    public ProduktuaSalmenta(String prodKodea, int kantitatea, String prodTaila) {
        this.prodKodea = prodKodea;
        this.kantitatea = kantitatea;
        this.prodTaila = prodTaila;
    }
    
    /* GETTER and SETTER */
    public String getProdKodea() {
        return prodKodea;
    }

    public void setProdKodea(String prodKodea) {
        this.prodKodea = prodKodea;
    }

    public String getSalmKode() {
        return salmKode;
    }

    public void setSalmKode(String salmKode) {
        this.salmKode = salmKode;
    }

    public int getKantitatea() {
        return kantitatea;
    }

    public void setKantitatea(int kantitatea) {
        this.kantitatea = kantitatea;
    }

    public String getProdTaila() {
        return prodTaila;
    }

    public void setProdTaila(String prodTaila) {
        this.prodTaila = prodTaila;
    }

    public double getProdPrezioa() {
        return prodPrezioa;
    }

    public void setProdPrezioa(double prodPrezioa) {
        this.prodPrezioa = prodPrezioa;
    }
}
