/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DBKonexioa;
import model.Hornitzailea;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class HornitzaileaKudeatu {
    /* Hornitzaile berri bat gehitu */
    public static boolean hornitzaileaGehitu(Hornitzailea horn1) {
        boolean gehituta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps;
        try {
            String sqlInsert = "INSERT INTO hornitzailea VALUES (?, ?, ?, ?, ?)";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            ps.setString(1, horn1.getKodHor());
            ps.setString(2, horn1.getIzena());
            ps.setString(3, horn1.getHerria());
            ps.setString(4, horn1.getTelefonoa());
            ps.setString(5, horn1.getEmail());

            ps.executeUpdate(); /* Aldaketak gorde */
            System.out.println("\nDatu hauek dituen hornitzailea gorde da.");
            horn1.printDatuak();
            gehituta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gehituta;
        }
    }
    
    /* Hornitzaile zehatz bat ezabatu */
    public static boolean hornitzaileaEzabatu(String kodea) {
        boolean ezabatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        try {
            String sqlDelete = "DELETE FROM hornitzailea WHERE hornKode = ?";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlDelete); // DELETE-a preparatu
            ps.setString(1, kodea);
            ps.executeUpdate();
            ezabatuta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        }
        finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
            if (ezabatuta)
                System.out.println(kodea+" zenbakidun hornitzailea ezabatu da.");
            return ezabatuta;
        }
    }
    
    /* Hornitzaileen inguruko informazioa erakusten du. */
    public static ArrayList<Hornitzailea> hornitzaileGuztiakErakutsi() {
        ArrayList<Hornitzailea> hornGuzt = new ArrayList<Hornitzailea>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT * "
                                + "FROM hornitzailea "
                                + "ORDER BY hornKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            
            System.out.println("HORNITZAILEAK: ");
            System.out.printf("\t%1$-20s    %2$-10s    %3$-10s    %4$-15s    %5$-10s\n", "Kodea", "Izena", "Herria", "Telefonoa", "Email-a");
            
            while(rs.next()){
                Hornitzailea horn = new Hornitzailea(); // objektu hutsa sortu
                horn.setKodHor(rs.getString("hornKode"));
                horn.setIzena(rs.getString("hornIzena"));
                horn.setHerria(rs.getString("hornHerria"));
                horn.setTelefonoa(rs.getString("hornTlf"));
                horn.setEmail(rs.getString("hornEmail"));
                
                hornGuzt.add(horn);
                horn.printDatuak();
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
        return hornGuzt;
    }
    
    /* Hornitzailearen datuak aldatu.  Boolean bat bueltatuko du, objektua aldatu den edo ez jakiteko */
    public static boolean hornitzaileDatuakAldatu(Hornitzailea horn1) {
        boolean aldatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;        
        try {
            String sqlUpdate = "UPDATE hornitzailea SET hornIzena = ?, hornHerria = ?, hornTlf = ?, hornEmail = ? WHERE hornKode = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            ps.setString(1, horn1.getIzena());
            ps.setString(2, horn1.getHerria());
            ps.setString(3, horn1.getTelefonoa());
            ps.setString(4, horn1.getEmail());
            ps.setString(5, horn1.getKodHor());
            ps.executeUpdate();
            aldatuta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        }
        finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
            if (aldatuta)
                System.out.println(horn1.getKodHor()+" kodea duen hornitzailearen datuak aldatu dira.");
            else
                System.out.println(horn1.getKodHor()+" kodea duen hornitzailerik ez dago erregistratuta.");
            return aldatuta;
        }
    }
}
