/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import gestioa.Metodoak;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class DBKonexioa {
    /* ATRIBUTUAK */
    private String db = "dendaproiektua"; // datu basearen izena
    private String url = "jdbc:mysql://localhost:3306/"+db;//+"?useSSL=false&requireSSL=false&verifyServerCertificate=false";
    private String usr = "root"; // datu baseko erabiltzailea
    private String pwd = ""; // datu baseko erabiltzailearen pasahitza
    private Connection konexioa = null;
    
    /* ERAIKITZAILEA */
    public DBKonexioa() {
        try {
            this.konexioa = (Connection) DriverManager.getConnection(url, usr, pwd);
            System.out.println(Metodoak.printUrdinez(db + " datu basera konektatuta"));
            
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            System.out.println(db + " datu basera ez da konektatu");
        }
    }

    /* Datu basera konexioa bueltatzen du */
    public Connection getDBKonexioa() {
        return konexioa;
    }

    /* Datu basetik deskonektatu egiten da  */
    public void deskonektatu() {
        try {
            this.konexioa.close();
            System.out.println(Metodoak.printUrdinez("Datu basetik deskonektatu da."));
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        }
    }
}
