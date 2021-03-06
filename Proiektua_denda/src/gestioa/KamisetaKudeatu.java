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
import model.Kamiseta;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class KamisetaKudeatu {
    /* Kamiseta berri bat gehitu */
    public static boolean kamisetaGehitu(Kamiseta kami1) {
        boolean gordeta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psKami, psProd;
        try {
            /* PRODUKTUA taulan datuak gorde */
            String sqlInsert = "INSERT INTO produktua (prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            psProd = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psProd.setString(1, kami1.getKodPro());
            psProd.setString(2, kami1.getMarka());
            psProd.setDouble(3, kami1.getPrezioa());
            psProd.setString(4, kami1.getKolorea());
            psProd.setString(5, kami1.getSexua());
            psProd.setInt(6, kami1.getKantStock());
            psProd.executeUpdate();/* Aldaketak gorde */
            
            /* KAMISETA taulan datuak gorde */
            sqlInsert = "INSERT INTO kamiseta VALUES (?, ?, (SELECT prodId FROM produktua WHERE prodKode = ?))";
            psKami = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psKami.setString(1, kami1.getTaila());
            psKami.setString(2, kami1.getSasoia());
            psKami.setString(3, kami1.getKodPro());
            psKami.executeUpdate(); /* Aldaketak gorde */
            
            System.out.println("Datu hauek dituen produktua gorde da."
                    + "\nProduktua: KAMISETA");
            kami1.printDatuak();
            
            gordeta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gordeta; // objektua datu basean gorde den edo ez bueltatuko du
        }  
    }
    
    /* Kamiseta zehatz baten datu guztiak ezabatu */    
    public static boolean kamisetaEzabatu(String kodea, String taila) {
        boolean ezabatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            /* Produktuaren/Kamisetaren id zenbakia lortu */
            String sqlSelect = "SELECT produktua_prodId FROM kamiseta WHERE produktua_prodId = (SELECT prodId FROM produktua WHERE prodKode = ?) AND kamiTaila = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, kodea);
            ps.setString(2, taila);
            rs = ps.executeQuery();
            rs.next();
            String id = rs.getString("produktua_prodId"); /* Ezabatu nahi den produktuaren ID-a gordetzen da */

            /* KAMISETA taulatik ezabatu */
            String sqlDelete = "DELETE FROM kamiseta WHERE produktua_prodId = ?";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlDelete); // DELETE-a preparatu
            ps.setString(1, id);
            ps.executeUpdate();
            
            /* PRODUKTUA taulatik ezabatu */
            sqlDelete = "DELETE FROM produktua WHERE prodId = ?";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlDelete); // INSERT-a preparatu
            ps.setString(1, id);
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
                System.out.println(kodea+" erreferentziadun kamiseta ondo ezabatu da.");
            return ezabatuta;
        }
    }

    /* ArrayList-eko Kamiseta guztien datuak erakusteko metodoa */
    public static ArrayList<Kamiseta> kamisetaGuztErakutsi() {
        ArrayList<Kamiseta> kamiGuzt = new ArrayList<Kamiseta>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, kamiTaila, kamiSasoia "
                                + "FROM produktua JOIN kamiseta ON prodId = produktua_prodId "
                                + "ORDER BY prodKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            System.out.println("KAMISETAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Sasoia");
            while(rs.next()){
                Kamiseta kami = new Kamiseta(); // objektu hutsa sortu
                kami.setKodPro(rs.getString("prodKode"));
                kami.setMarka(rs.getString("prodMarka"));
                kami.setPrezioa(rs.getDouble("prodPrezioa"));
                kami.setKolorea(rs.getString("prodKolorea"));
                kami.setSexua(rs.getString("prodSexua"));
                kami.setKantStock(rs.getInt("prodKantStock"));
                kami.setTaila(rs.getString("kamiTaila"));
                kami.setSasoia(rs.getString("kamiSasoia"));
                kamiGuzt.add(kami);
                kami.printProd(); // objektuaren datuak erakutsi
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
            return kamiGuzt;
        }
    }
    
    /* Kamisetaren datuak aldatzen dituen metodoa. Booleano bat itzuliko du, datuak aldatu diren edo ez jakiteko */
    public static boolean kamisetaDatuakAldatu(Kamiseta kami1) {
        boolean aldatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null, psProd = null, psKami = null;
        ResultSet rs = null;
        try {
            /* Produktuaren/Kamisetaren id zenbakia lortu */
            String sqlSelect = "SELECT produktua_prodId FROM kamiseta WHERE produktua_prodId = (SELECT prodId FROM produktua WHERE prodKode = ?) AND kamiTaila = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, kami1.getKodPro());
            ps.setString(2, kami1.getTaila());
            rs = ps.executeQuery();
            rs.next();
            String id = rs.getString("produktua_prodId"); /* Aldatu nahi den produktuaren ID-a gordetzen da */
            
            /* PRODUKTUA taulako datuak aldatu */
            String sqlUpdate = "UPDATE produktua SET prodMarka = ?, prodPrezioa = ?, prodKolorea = ?, prodSexua = ?, prodKantStock = ? WHERE prodId = ? ";
            psProd = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            psProd.setString(1, kami1.getMarka());
            psProd.setDouble(2, kami1.getPrezioa());
            psProd.setString(3, kami1.getKolorea());
            psProd.setString(4, kami1.getSexua());
            psProd.setInt(5, kami1.getKantStock());
            psProd.setString(6, id);
            psProd.executeUpdate();

            /* KAMISETA taulako datuak aldatu */
            sqlUpdate = "UPDATE kamiseta SET kamiTaila = ?, kamiSasoia = ? WHERE produktua_prodId = ? ";
            psKami = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            psKami.setString(1, kami1.getTaila());
            psKami.setString(2, kami1.getSasoia());
            psKami.setString(3, id);
            psKami.executeUpdate();
            
            aldatuta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        }
        finally {
            try {
                ps.close();
                psProd.close();
                psKami.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
            if (aldatuta)
                System.out.println(kami1.getKodPro()+" kodea duen kamisetaren datuak aldatu dira.");
            else
                System.out.println(kami1.getKodPro()+" kodea duen kamisetaren datuak ez dira aldatu.");
            return aldatuta;
        }
    }
    
    /* Kamiseta baten kodea, ArrayList-ean dagoen kontsultatu, dendan dagoen jakiteko. */
    public static ArrayList<Kamiseta> kamisetaKontsultatu(String kodea) {
        ArrayList<Kamiseta> kamiKonts = new ArrayList<Kamiseta>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        try {
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, kamiTaila, kamiSasoia "
                                + "FROM produktua JOIN kamiseta ON prodId = produktua_prodId "
                                + "WHERE prodKode = ?"
                                + "ORDER BY prodKode";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, kodea);
            ResultSet rs = ps.executeQuery();
            System.out.println();
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Sasoia");
            while(rs.next()){
                Kamiseta kami = new Kamiseta(); // objektu hutsa sortu
                kami.setKodPro(rs.getString("prodKode"));
                kami.setMarka(rs.getString("prodMarka"));
                kami.setPrezioa(rs.getDouble("prodPrezioa"));
                kami.setKolorea(rs.getString("prodKolorea"));
                kami.setSexua(rs.getString("prodSexua"));
                kami.setKantStock(rs.getInt("prodKantStock"));
                kami.setTaila(rs.getString("kamiTaila"));
                kami.setSasoia(rs.getString("kamiSasoia"));
                kamiKonts.add(kami);
                kami.printProd(); // objektuaren datuak erakutsi
            }
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
            return kamiKonts;
        }
    }
    
    /* kantitatea 5 baino gutxiago duten kamisetak erakusten ditu */
    public static ArrayList<Kamiseta> kamisetaEskatzeko() {
        ArrayList<Kamiseta> kamiInb = new ArrayList<Kamiseta>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, kamiTaila, kamiSasoia "
                                + "FROM produktua JOIN kamiseta ON prodId = produktua_prodId "
                                + "WHERE prodKantStock < 5 "
                                + "ORDER BY prodKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            System.out.println("KAMISETAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Sasoia");
            while(rs.next()){
                Kamiseta kami = new Kamiseta(); // objektu hutsa sortu
                kami.setKodPro(rs.getString("prodKode"));
                kami.setMarka(rs.getString("prodMarka"));
                kami.setPrezioa(rs.getDouble("prodPrezioa"));
                kami.setKolorea(rs.getString("prodKolorea"));
                kami.setSexua(rs.getString("prodSexua"));
                kami.setKantStock(rs.getInt("prodKantStock"));
                kami.setTaila(rs.getString("kamiTaila"));
                kami.setSasoia(rs.getString("kamiSasoia"));
                kamiInb.add(kami);
                kami.printProd(); // objektuaren datuak erakutsi
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
            return kamiInb;
        }
    }
       
    /* KAMISETAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */
    public static boolean prodSaldu(String kodea, String taila, int kantitatea) {
        boolean salduta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        System.out.println(""
                + "-----------------------------------------\n"
                + "|         Produktuaren salmenta         |\n"
                + "-----------------------------------------");
        PreparedStatement psProduktua, ps;
        ResultSet rs;
        String id = null;
        try {
            Statement stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, kamiTaila, kamiSasoia "
                                + "FROM produktua JOIN kamiseta ON prodId = produktua_prodId "
                                + "WHERE prodKode = '"+kodea+"' AND kamiTaila = '"+taila+"' "
                                + "ORDER BY prodKode";
            rs = stmt.executeQuery(sqlSelect);
            System.out.println("KAMISETAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Sasoia");
            Kamiseta kami = null;
            while(rs.next()){
                kami = new Kamiseta(); // objektu hutsa sortu
                kami.setKodPro(rs.getString("prodKode"));
                kami.setMarka(rs.getString("prodMarka"));
                kami.setPrezioa(rs.getDouble("prodPrezioa"));
                kami.setKolorea(rs.getString("prodKolorea"));
                kami.setSexua(rs.getString("prodSexua"));
                kami.setKantStock(rs.getInt("prodKantStock"));
                kami.setTaila(rs.getString("kamiTaila"));
                kami.setSasoia(rs.getString("kamiSasoia"));
            }
            
            /* Produktuaren/Jertsearen id zenbakia lortu */
            sqlSelect = "SELECT produktua_prodId FROM kamiseta WHERE produktua_prodId = (SELECT prodId FROM produktua WHERE prodKode = ?) AND kamiTaila = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, kami.getKodPro());
            ps.setString(2, kami.getTaila());
            rs = ps.executeQuery();
            rs.next();
            id = rs.getString("produktua_prodId"); /* Ezabatu nahi den produktuaren ID-a gordetzen da */
            
            if (kami.isEskuragai()) {
                /* PRODUKTUA TAULA ALDATU */
                String sqlUpdate = "UPDATE produktua SET prodKantStock = ? WHERE prodId = ? ";
                psProduktua = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
                psProduktua.setInt(1, kami.getKantStock()-kantitatea); // saldutakoak stock-etik kendu
                psProduktua.setString(2, id);
                psProduktua.executeUpdate();
                
                salduta = true;
                System.out.println(""
                    + "\tKodea\t-\tPrezioa \n\n"
                    + "\t"+kami.getKodPro()+"\t-\t"+kami.getPrezioa()+"  (x"+kantitatea+")\n"
                    + "  --------------------------------------\n"
                    + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+kami.getPrezioa()*kantitatea+"€");
                kami.getPrezioa();
            }  
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return salduta; // objektua datu basean gorde den edo ez bueltatuko du
        } 
    }
}
