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
import model.Denda;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class DendaKudeatu {    
    /* Denda berri bat gehitu */
    public static boolean dendaGehitu(Denda d) {
        boolean gordeta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps;
        try {
            String sqlInsert = "INSERT INTO denda VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            ps.setString(1, d.getKodDend());
            ps.setString(2, d.getIzena());
            ps.setString(3, d.getHelbidea());
            ps.setString(4, d.getHerria());
            ps.setInt(5, d.getKodPostala());
            ps.setString(6, d.getTelefonoa());
            ps.setString(7, d.getEmail());

            ps.executeUpdate(); /* Aldaketak gorde */
            gordeta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gordeta; // objektua datu basean gorde den edo ez bueltatuko du
        }
    }
 
    /* Denda zehatz baten datu guztiak ezabatu */ 
    public static boolean dendaEzabatu(String kodea) {
        boolean ezabatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        try {
            String sqlDelete = "DELETE FROM denda WHERE dendKode = ?";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlDelete); // INSERT-a preparatu
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
                System.out.println(kodea+" zenbakidun denda ezabatu da.");
            else
                System.out.println(kodea+" zenbakia duen dendarik ez dago erregistratuta.");
            return ezabatuta;
        }      
    }
    
    /* Dendaren inguruko informazioa erakusten du. */
    public static ArrayList<Denda> dendGuztiakErakutsi() {
        ArrayList<Denda> dendaGuzt = new ArrayList<Denda>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT dendKode, dendIzena, dendHelbidea, dendHerria, dendPK, dendTlf, dendEmail FROM denda ORDER BY dendKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            
            while(rs.next()){
                Denda dend = new Denda(); // objektu hutsa sortu
                dend.setKodDend(rs.getString("dendKode"));
                dend.setIzena(rs.getString("dendIzena"));
                dend.setHelbidea(rs.getString("dendHelbidea"));
                dend.setHerria(rs.getString("dendHerria"));
                dend.setKodPostala(rs.getInt("dendPK"));
                dend.setTelefonoa(rs.getString("dendTlf"));
                dend.setEmail(rs.getString("dendEmail"));
                dendaGuzt.add(dend);
            }
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } 
        finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
        }
        return dendaGuzt;
    }
}
