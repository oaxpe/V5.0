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
import model.Eskaera;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class EskaeraKudeatu {    
    /* Eskaera berri bat gehitu/gestionatu */
    public static boolean eskaeraGehitu(Eskaera esk1) {
        boolean gehituta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps;
        try {
            String sqlInsert = "INSERT INTO eskaera VALUES (?, ?, ?, ?, (SELECT hornKode FROM hornitzailea WHERE hornIzena = ?), (SELECT prodId FROM produktua WHERE prodKode = ?))";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            ps.setString(1, esk1.getEskZenb());
            ps.setString(2, esk1.getData());
            ps.setInt(3, esk1.getKopurua());
            ps.setString(4, esk1.getProdTaila());
            ps.setString(5, esk1.getHornitzailea());
            ps.setString(6, esk1.getProdKodea());

            ps.executeUpdate(); /* Aldaketak gorde */
            gehituta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gehituta;
        }
    }
    
    /* Eskaera zehatz bat ezabatu */
    public static boolean eskaeraEzabatu(String kodea) {
        boolean ezabatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        try {
            /* ESKAERA taulatik ezabatu */
            String sqlDelete = "DELETE FROM eskaera WHERE eskKode = ?";
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
                System.out.println(kodea+" kodedun eskaera ezabatu da.");
            return ezabatuta;
        }
    }
    
    /* Eskaeren inguruko informazioa erakusten du. */
    public static ArrayList<Eskaera> eskaeraGuztiakErakutsi() {
        ArrayList<Eskaera> eskGuzt = new ArrayList<Eskaera>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT eskKode, eskData, eskKop, hornIzena, prodKode, eskProdTaila "
                                + "FROM (produktua JOIN eskaera ON produktua.prodId = eskaera.produktua_prodId) "
                                + "JOIN hornitzailea ON eskaera.hornitzailea_hornKode = hornitzailea.hornKode "
                                + "ORDER BY eskKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            
            while(rs.next()){
                Eskaera esk = new Eskaera(); // objektu hutsa sortu
                esk.setEskZenb(rs.getString("eskKode"));
                esk.setData(rs.getString("eskData"));
                esk.setKopurua(rs.getInt("eskKop"));
                esk.setHornitzailea(rs.getString("hornIzena"));
                esk.setProdKodea(rs.getString("prodKode"));
                esk.setProdTaila(rs.getString("eskProdTaila"));
                
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

    public static boolean eskaeraDatuakAldatu(Eskaera esk) {
        boolean aldatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psEsk = null;
        try {           
            /* ESKAERA taulako datuak aldatu (bezeroa taulakoak ez dira inoiz aldatuko) */
            String sqlUpdate = "UPDATE eskaera SET eskData = ?, eskKop = ?, eskProdTaila = ?, hornitzailea_hornKode = (SELECT hornKode FROM hornitzailea WHERE hornIzena = ?) "
                    + "WHERE eskKode = ? ";
            psEsk = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            psEsk.setString(1, esk.getData());
            psEsk.setInt(2, esk.getKopurua());
            psEsk.setString(3, esk.getProdTaila());
            psEsk.setString(4, esk.getHornitzailea());
            psEsk.setString(5, esk.getEskZenb());
            psEsk.executeUpdate();

            aldatuta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        }
        finally {
            try {
                psEsk.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
            if (aldatuta)
                System.out.println(esk.getEskZenb()+" kodea duen eskaeraren datuak aldatu dira.");
            else
                System.out.println(esk.getEskZenb()+" kodea duen eskaerarik ez dago erregistratuta.");
            return aldatuta;
        }
    }
}

