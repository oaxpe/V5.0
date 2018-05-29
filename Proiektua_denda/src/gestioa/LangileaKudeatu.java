/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.DBKonexioa;
import model.Langilea;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class LangileaKudeatu {    
    /* langileen lan eremua bistan ikusteko */
    public static String[] langileEremuaKontrolatu() {
        String[] eremua = { "Saltzailea", "Garbitzailea"};
        return eremua;
    }
    
    /* Langile berri bat gehitu */
    public static boolean langileaGehitu(Langilea lang1) {
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psLang, psPerts;
        boolean gordeta = false;
        try {
            /* PERTSONA taulan datuak gorde */
            String sqlInsert = "INSERT INTO pertsona VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            psPerts = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psPerts.setString(1, lang1.getIzena());
            psPerts.setString(2, lang1.getAbizena1());
            psPerts.setString(3, lang1.getAbizena2());
            psPerts.setString(4, lang1.getNan());
            psPerts.setString(5, lang1.getJaiotzeData());
            psPerts.setString(6, lang1.getSexua());
            psPerts.setString(7, lang1.getHerria());
            psPerts.setString(8, lang1.getTelefonoa());
            psPerts.executeUpdate();/* Aldaketak gorde */
            
            /* LANGILEA taulan datuak gorde */
            sqlInsert = "INSERT INTO langilea VALUES (?, ?, ?, ?, (SELECT dendKode FROM denda WHERE dendIzena = ?))";
            psLang = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psLang.setString(1, lang1.getKodLan());
            psLang.setDouble(2, lang1.getSoldata());
            psLang.setString(3, lang1.getEremua());
            psLang.setString(4, lang1.getNan());
            psLang.setString(5, lang1.getDendIzena()); // denda kodea
            psLang.executeUpdate(); /* Aldaketak gorde */
            
            System.out.println("\nDatu hauek dituen langilea gorde da.");
            System.out.println("\nEremua: Langilea");
            lang1.printDatuak();
            gordeta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gordeta; // objektua datu basean gorde den edo ez bueltatuko du
        }   
    }
    
    /* Langile zehatz baten datu guztiak ezabatu */ 
    public static boolean langileaEzabatu(String nan) {
        boolean ezabatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        try {
            /* LANGILEA taulatik ezabatu */
            String sqlDelete = "DELETE FROM langilea WHERE pertsona_pertsNan = ?";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlDelete); // INSERT-a preparatu
            ps.setString(1, nan);
            ps.executeUpdate();
            
            /* PERTSONA taulatik ezabatu */
            sqlDelete = "DELETE FROM pertsona WHERE pertsNan = ?";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlDelete); // INSERT-a preparatu
            ps.setString(1, nan);
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
                System.out.println(nan+" zenbakidun langilea ezabatu da.");
            else
                System.out.println(nan+" zenbakia duen langilea ez dago erregistratuta.");
            return ezabatuta;
        }
    }
    
    /* Langileen inguruko informazioa erakusten du. */
    public static ArrayList<Langilea> langileGuztiakErakutsi() {
        ArrayList<Langilea> langGuzt = new ArrayList<Langilea>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT langKode, pertsIzena, pertsAbiz1, pertsAbiz2, pertsNan, pertsJaioData, pertsSexua, pertsHerria, pertsTlf, langSoldata, langEremua, dendIzena "
                                + "FROM (pertsona JOIN langilea ON pertsona_pertsNan = pertsNan) JOIN denda ON langilea.denda_dendKode = denda.dendKode "
                                + "ORDER BY langKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            System.out.println("LANGILEAK: ");
            System.out.printf("\t%1$-10s    %2$-10s    %3$-20s    %4$-10s  %5$-15s    %6$-10s    %7$-10s    %8$-10s    %9$-10s\n", "Langile kodea", "Izena", "Abizenak", "NAN zenbakia", "Jaiotze data", "Sexua", "Herria", "Telefonoa", "Lan-eremua");  // inprimitzen den informazioari formatua emateko
            while(rs.next()){
                Langilea lang = new Langilea(); // objektu hutsa sortu
                lang.setKodLan(rs.getString("langKode"));
                lang.setIzena(rs.getString("pertsIzena"));
                lang.setAbizena1(rs.getString("pertsAbiz1"));
                lang.setAbizena2(rs.getString("pertsAbiz2"));
                lang.setNan(rs.getString("pertsNan"));
                lang.setJaiotzeData(rs.getString("pertsJaioData"));
                lang.setSexua(rs.getString("pertsSexua"));
                lang.setHerria(rs.getString("pertsHerria"));
                lang.setTelefonoa(rs.getString("pertsTlf"));
                lang.setSoldata(rs.getDouble("langSoldata"));
                lang.setEremua(rs.getString("langEremua"));
                lang.setDendIzena(rs.getString("dendIzena")); // denda_dendKode, langile taulan
                langGuzt.add(lang);
                lang.printPerts(); // objektuaren datuak erakutsi
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
        return langGuzt;
    }
    
    /* Langilearen datuak aldatu, nan zenbakiaren arabera */
    public static boolean langileaDatuakAldatu(Langilea lang1) {
        boolean aldatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psPerts = null, psLang = null;
        try {
            /* PERTSONA taulako datuak aldatu */
            String sqlUpdate = "UPDATE pertsona SET pertsIzena = ?, pertsAbiz1 = ?, pertsAbiz2 = ?, pertsJaioData = ?, pertsSexua = ?, pertsHerria = ?, pertsTlf = ? WHERE pertsNan = ? ";
            psPerts = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            psPerts.setString(1, lang1.getIzena());
            psPerts.setString(2, lang1.getAbizena1());
            psPerts.setString(3, lang1.getAbizena2());
            psPerts.setString(4, lang1.getJaiotzeData());
            psPerts.setString(5, lang1.getSexua());
            psPerts.setString(6, lang1.getHerria());
            psPerts.setString(7, lang1.getTelefonoa());
            psPerts.setString(8, lang1.getNan());
            psPerts.executeUpdate();

            /* LANGILEA taulako datuak aldatu */
            sqlUpdate = "UPDATE langilea SET langSoldata = ?, langEremua = ?, denda_dendKode = (SELECT dendKode FROM denda WHERE dendIzena = ?) WHERE pertsona_pertsNan = ? ";
            psLang = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            psLang.setDouble(1, lang1.getSoldata());
            psLang.setString(2, lang1.getEremua());
            psLang.setString(3, lang1.getDendIzena());
            psLang.setString(4, lang1.getNan());
            psLang.executeUpdate();
            
            aldatuta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        }
        finally {
            try {
                psPerts.close();
                psLang.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
            if (aldatuta)
                System.out.println(lang1.getNan()+" nan zenbakia duen langilearen datuak aldatu dira.");
            else
                System.out.println(lang1.getNan()+" nan zenbakia duen langilerik ez dago erregistratuta.");
            return aldatuta;
        }
    }
}
