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
import model.Bezeroa;
import model.DBKonexioa;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class BezeroaKudeatu {    
    /* Bezero berri bat gehitu */
    public static boolean bezeroaGehitu(Bezeroa bez1) {
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psBez, psPerts;
        boolean gordeta = false;
        try {
            /* PERTSONA taulan datuak gorde */
            String sqlInsert = "INSERT INTO pertsona VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            psPerts = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psPerts.setString(1, bez1.getIzena());
            psPerts.setString(2, bez1.getAbizena1());
            psPerts.setString(3, bez1.getAbizena2());
            psPerts.setString(4, bez1.getNan());
            psPerts.setString(5, bez1.getJaiotzeData());
            psPerts.setString(6, bez1.getSexua());
            psPerts.setString(7, bez1.getHerria());
            psPerts.setString(8, bez1.getTelefonoa());
            psPerts.executeUpdate();/* Aldaketak gorde */
            
            /* BEZEROA taulan datuak gorde */
            sqlInsert = "INSERT INTO bezeroa VALUES (?, ?)";
            psBez = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psBez.setString(1, bez1.getKodBez());
            psBez.setString(2, bez1.getNan());
            psBez.executeUpdate(); /* Aldaketak gorde */
            
            gordeta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gordeta; // objektua datu basean gorde den edo ez bueltatuko du
        }
    }
    
    /* Bezero zehatz baten datu guztiak ezabatu */ 
    public static boolean bezeroaEzabatu(String nan) {
        boolean ezabatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        try {
            /* BEZEROA taulatik ezabatu */
            String sqlDelete = "DELETE FROM bezeroa WHERE pertsona_pertsNan = ?";
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
                System.out.println(nan+" zenbakidun bezeroa ezabatu da.");
            else
                System.out.println(nan+" zenbakia duen bezerorik ez dago erregistratuta.");
            return ezabatuta;
        }
    }
    
    /* Bezeroen inguruko informazioa erakusten du. */
    public static ArrayList<Bezeroa> bezeroGuztiakErakutsi() {
        ArrayList<Bezeroa> bezGuzt = new ArrayList<Bezeroa>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT bezKode, pertsIzena, pertsAbiz1, pertsAbiz2, pertsNan, pertsJaioData, pertsSexua, pertsHerria, pertsTlf "
                                + "FROM pertsona JOIN bezeroa ON pertsona_pertsNan = pertsNan "
                                + "ORDER BY bezKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            System.out.println("BEZEROAK: ");
            System.out.printf("\t%1$-10s    %2$-10s    %3$-20s  %4$-10s    %5$-15s    %6$-10s    %7$-10s    %8$-10s\n", "Bezero kodea", "Izena", "Abizenak", "NAN zenbakia", "Jaiotze data", "Sexua", "Herria", "Telefonoa"); // inprimitzen den informazioari formatua emateko
            while(rs.next()){
                Bezeroa bez = new Bezeroa(); // objektu hutsa sortu
                bez.setKodBez(rs.getString("bezKode"));
                bez.setIzena(rs.getString("pertsIzena"));
                bez.setAbizena1(rs.getString("pertsAbiz1"));
                bez.setAbizena2(rs.getString("pertsAbiz2"));
                bez.setNan(rs.getString("pertsNan"));
                bez.setJaiotzeData(rs.getString("pertsJaioData"));
                bez.setSexua(rs.getString("pertsSexua"));
                bez.setHerria(rs.getString("pertsHerria"));
                bez.setTelefonoa(rs.getString("pertsTlf"));
                bezGuzt.add(bez);
                bez.printPerts(); // objektuaren datuak erakutsi
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
        return bezGuzt;
    }
    
    /* Bezeroaren datuak aldatu (erabiltzaileak bere dni-a sartu beharko du) */
    public static boolean bezeroDatuakAldatu(Bezeroa bez1) {
        boolean aldatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psPerts = null;
        try {
            /* PERTSONA taulako datuak aldatu (bezeroa taulakoak ez dira inoiz aldatuko) */
            String sqlUpdate = "UPDATE pertsona SET pertsIzena = ?, pertsAbiz1 = ?, pertsAbiz2 = ?, pertsJaioData = ?, pertsSexua = ?, pertsHerria = ?, pertsTlf = ? WHERE pertsNan = ? ";
            psPerts = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            psPerts.setString(1, bez1.getIzena());
            psPerts.setString(2, bez1.getAbizena1());
            psPerts.setString(3, bez1.getAbizena2());
            psPerts.setString(4, bez1.getJaiotzeData());
            psPerts.setString(5, bez1.getSexua());
            psPerts.setString(6, bez1.getHerria());
            psPerts.setString(7, bez1.getTelefonoa());
            psPerts.setString(8, bez1.getNan());
            psPerts.executeUpdate();

            aldatuta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        }
        finally {
            try {
                psPerts.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
            if (aldatuta)
                System.out.println(bez1.getNan()+" nan zenbakia duen bezeroaren datuak aldatu dira.");
            else
                System.out.println(bez1.getNan()+" nan zenbakia duen bezerorik ez dago erregistratuta.");
            return aldatuta;
        }
    }
}
