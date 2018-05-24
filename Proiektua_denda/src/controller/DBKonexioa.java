/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class DBKonexioa {
    /* ATRIBUTUAK */
    private String db = "dendaProiektua"; // datu basearen izena
    private String url = "jdbc:mysql://localhost:3306/"+db+"?useSSL=false&requireSSL=false&verifyServerCertificate=false";
    private String usr = "root"; // datu baseko erabiltzailea
    private String pwd = "Asdf134"; // datu baseko erabiltzailearen pasahitza
    private Connection konexioa = null;
    
    /* ERAIKITZAILEA */
    public void DBKonexioa() {
        try {
            this.konexioa = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if (konexioa != null) {
            System.out.println(db + " datu basera konektatuta");
        }
        else {
            System.out.println(db + " datu basera ez da konektatu");
        }  
    }

    /* Datu basera konexioa bueltatzen du */
    public Connection getDBKonexioa() {
        return konexioa;
    }

    /* Datu basetik deskonektatu egiten da  */
    public void deskonektatu(Connection con) {
        try {
            this.konexioa.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
