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
    public static boolean dendaGehitu(Denda dend1) {
        boolean gordeta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps;
        try {
            String sqlInsert = "INSERT INTO denda VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            ps.setString(1, dend1.getKodDend());
            ps.setString(2, dend1.getIzena());
            ps.setString(3, dend1.getHelbidea());
            ps.setString(4, dend1.getHerria());
            ps.setInt(5, dend1.getKodPostala());
            ps.setString(6, dend1.getTelefonoa());
            ps.setString(7, dend1.getEmail());

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
    
    /* Dendaren datuak aldatzeko metodoa. Boolean bat bueltatuko du, objektua aldatu den edo ez jakiteko */
    public static boolean dendaDatuakAldatu(Denda dend1) {
        boolean aldatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;        
        try {
            String sqlUpdate = "UPDATE denda SET dendIzena = ?, dendHelbidea = ?, dendHerria = ?, dendPK = ?, dendTlf = ?, dendEmail = ? WHERE dendKode = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            ps.setString(1, dend1.getIzena());
            ps.setString(2, dend1.getHelbidea());
            ps.setString(3, dend1.getHerria());
            ps.setInt(4, dend1.getKodPostala());
            ps.setString(5, dend1.getTelefonoa());
            ps.setString(6, dend1.getEmail());
            ps.setString(7, dend1.getKodDend());
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
                System.out.println(dend1.getKodDend()+" kodea duen dendaren datuak aldatu dira.");
            else
                System.out.println(dend1.getKodDend()+" kodea duen dendarik ez dago erregistratuta.");
            return aldatuta;
        }
    }
}
