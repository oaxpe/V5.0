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
import model.Salmenta;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class SalmentaKudeatu {    
    /* Salmenta berri bat gehitu/gestionatu */
    public static boolean salmentaGehitu(Salmenta salm1) {
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psSalm;
        boolean gordeta = false;
        try {
            /* SALMENTA taulan datuak gorde */
            String sqlInsert = "INSERT INTO salmenta (salmKode, salmData, salmProdKantitatea, produktua_prodId) VALUES (?, ?, ?, (SELECT prodId FROM produktua WHERE prodKode = ?))";
            psSalm = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psSalm.setString(1, salm1.getSalmZenb());
            psSalm.setString(2, salm1.getData());
            psSalm.setInt(3, salm1.getSalmProdKantitatea());
            psSalm.setString(4, salm1.getProdKodea());
            psSalm.executeUpdate();/* Aldaketak gorde */
            
            gordeta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gordeta; // objektua datu basean gorde den edo ez bueltatuko du
        }
    }
    
    /* Salmenten inguruko informazioa erakusten du (JERTSEAK, KAMISETAK eta PRAKAK). */
    public static ArrayList<Salmenta> salmentaGuztiakErakutsi() {
        ArrayList<Salmenta> salmGuzt = new ArrayList<>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            /* JERTSEAK gehitu */ 
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelectJerts = "SELECT salmKode, salmData, salmProdKantitatea, prodKode, jertsTaila "
                                + "FROM (salmenta JOIN produktua ON salmenta.produktua_prodId = produktua.prodId) JOIN jertsea ON produktua.prodId = jertsea.produktua_prodId "
                                + "ORDER BY salmKode";
            ResultSet rs = stmt.executeQuery(sqlSelectJerts);
            System.out.println("SALMENTAK: ");
            System.out.printf("\t%1$-15s    %2$-15s    %3$-10s    %4$-10s\n", "Salmenta zenb", "Data", "Produktua", "Taila");
            while(rs.next()){
                Salmenta salm = new Salmenta(); // objektu hutsa sortu
                salm.setSalmZenb(rs.getString("salmKode"));
                salm.setData(rs.getString("salmData"));
                salm.setProdKodea(rs.getString("prodKode"));
                salm.setProdTaila(rs.getString("jertsTaila"));
                salm.setSalmProdKantitatea(rs.getInt("salmProdKantitatea"));
                salmGuzt.add(salm);
                salm.printSalmenta();// objektuaren datuak erakutsi
            }
            
            /* KAMISETAK gehitu */
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelectKami = "SELECT salmKode, salmData, salmProdKantitatea, prodKode, kamiTaila "
                                + "FROM (salmenta JOIN produktua ON salmenta.produktua_prodId = produktua.prodId) JOIN kamiseta ON produktua.prodId = kamiseta.produktua_prodId "
                                + "ORDER BY salmKode";
            rs = stmt.executeQuery(sqlSelectKami);
            System.out.println("SALMENTAK: ");
            System.out.printf("\t%1$-15s    %2$-15s    %3$-10s    %4$-10s\n", "Salmenta zenb", "Data", "Produktua", "Taila");
            while(rs.next()){
                Salmenta salm = new Salmenta(); // objektu hutsa sortu
                salm.setSalmZenb(rs.getString("salmKode"));
                salm.setData(rs.getString("salmData"));
                salm.setProdKodea(rs.getString("prodKode"));
                salm.setProdTaila(rs.getString("kamiTaila"));
                salm.setSalmProdKantitatea(rs.getInt("salmProdKantitatea"));
                salmGuzt.add(salm);
                salm.printSalmenta();// objektuaren datuak erakutsi
            }
            
            /* PRAKA gehitu */
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelectPrak = "SELECT salmKode, salmData, salmProdKantitatea, prodKode, prakTaila "
                                + "FROM (salmenta JOIN produktua ON salmenta.produktua_prodId = produktua.prodId) JOIN praka ON produktua.prodId = praka.produktua_prodId "
                                + "ORDER BY salmKode";
            rs = stmt.executeQuery(sqlSelectPrak);
            System.out.println("SALMENTAK: ");
            System.out.printf("\t%1$-15s    %2$-15s    %3$-10s    %4$-10s\n", "Salmenta zenb", "Data", "Produktua", "Taila");
            while(rs.next()){
                Salmenta salm = new Salmenta(); // objektu hutsa sortu
                salm.setSalmZenb(rs.getString("salmKode"));
                salm.setData(rs.getString("salmData"));
                salm.setProdKodea(rs.getString("prodKode"));
                salm.setProdTaila(rs.getString("prakTaila"));
                salm.setSalmProdKantitatea(rs.getInt("salmProdKantitatea"));
                salmGuzt.add(salm);
                salm.printSalmenta();// objektuaren datuak erakutsi
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
        return salmGuzt;
    }
}
