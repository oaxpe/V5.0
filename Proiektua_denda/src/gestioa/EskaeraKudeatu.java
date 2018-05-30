/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBKonexioa;
import model.Eskaera;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class EskaeraKudeatu implements Serializable {
    private static File dirObj = new File("Objektuak");
    private static File fEsk = new File(dirObj+"\\eskaera.obj");
    private static File fEskTemp = new File(dirObj+"\\eskTemp.obj");
    
    /* Eskaera berri bat gehitu/gestionatu */
    public static void eskaeraGehitu(Eskaera esk1) {
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps;
        try {
            String sqlInsert = "INSERT INTO eskaera VALUES (?, ?, ?, ?)";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            ps.setString(1, esk1.getEskZenb());
            ps.setString(2, esk1.getHornitzailea());
            ps.setString(3, esk1.getData());
            ps.setInt(4, esk1.getKopurua());

            ps.executeUpdate(); /* Aldaketak gorde */
        } catch (SQLException ex) {
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
        }
    }
    
    /* Eskaera zehatz bat ezabatu */
    public static void eskaeraEzabatu(String kodea) {
        boolean ezabatuta = false;
        GoibururikEzObjectOutputStream geoos = null;
        try {            
            geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fEskTemp, true));
            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fEsk));
            
            while (true) { // fitxategiko objektuak irakurri
                Eskaera esk = (Eskaera) geois.readObject(); // objektua irakurri              
                if (!esk.getEskZenb().toUpperCase().equals(kodea.toUpperCase())) { // kodea konparatu
                    geoos.writeObject(esk); // objektua fitxategi berrian idatzi
                    geoos.flush();
                } 
                else {
                    ezabatuta = true;
                }
            }  
        } catch (EOFException ex) { 
            // fitxategiaren bukaerara heltzen denean, errorea omititu
        } catch (FileNotFoundException ex) {
            System.out.println(Metodoak.printUrdinez("Fitxategia ez du aurkitzen!"));;
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak jasotzerakoan"));
        }
        if (ezabatuta) {
            System.out.println("Eskaera ezabatu da.");
        }
        else
            System.out.println(kodea+" kodea duen eskaera ez dago erregistratuta.");
        try {
            geoos.close();
            System.gc();
            Files.move(Paths.get(fEskTemp.getAbsolutePath()), Paths.get(fEsk.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(EskaeraKudeatu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Eskaeren inguruko informazioa erakusten du. */
    public static ArrayList<Eskaera> eskaeraGuztiakErakutsi() {
        ArrayList<Eskaera> eskGuzt = new ArrayList<Eskaera>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT eskKode, eskHornitzailea, eskData, eskKopurua FROM eskaera ORDER BY eskKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            
            while(rs.next()){
                Eskaera esk = new Eskaera(); // objektu hutsa sortu
                esk.setEskZenb(rs.getString("eskKode"));
                esk.setHornitzailea(rs.getString("eskHornitzailea"));
                esk.setData(rs.getString("eskData"));
                esk.setKopurua(rs.getInt("eskKopurua"));
                eskGuzt.add(esk);
                esk.printDatuak();
            }
        } catch (SQLException ex) {
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
        } 
        finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printUrdinez(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
        }
        return eskGuzt;
    }
}

