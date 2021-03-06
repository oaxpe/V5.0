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
import model.Praka;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class PrakaKudeatu {
    /* Praka berri bat gehitu */
    public static boolean prakaGehitu(Praka prak1) {
        boolean gordeta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psPrak, psProd;
        try {
            /* PRODUKTUA taulan datuak gorde */
            String sqlInsert = "INSERT INTO produktua (prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock) VALUES (?, ?, ?, ?, ?, ?)";
            psProd = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psProd.setString(1, prak1.getKodPro());
            psProd.setString(2, prak1.getMarka());
            psProd.setDouble(3, prak1.getPrezioa());
            psProd.setString(4, prak1.getKolorea());
            psProd.setString(5, prak1.getSexua());
            psProd.setInt(6, prak1.getKantStock());
            psProd.executeUpdate();/* Aldaketak gorde */
            
            /* PRAKA taulan datuak gorde */
            sqlInsert = "INSERT INTO praka VALUES (?, ?, ?, ?, (SELECT prodId FROM produktua WHERE prodKode = ?))";
            psPrak = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psPrak.setInt(1, prak1.getTaila());
            psPrak.setString(2, prak1.getSasoia());
            psPrak.setInt(3, prak1.getLuzeera());
            psPrak.setString(4, prak1.getMota());
            psPrak.setString(5, prak1.getKodPro());
            psPrak.executeUpdate(); /* Aldaketak gorde */
            
            System.out.println("Datu hauek dituen produktua gorde da."
                    + "\nProduktua: PRAKA");
            prak1.printDatuak();
            
            gordeta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gordeta; // objektua datu basean gorde den edo ez bueltatuko du
        }  
    }
    
    /* Praka zehatz baten datu guztiak ezabatu */    
    public static boolean prakaEzabatu(String kodea, int taila) {
        boolean ezabatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            /* Produktuaren/Kamisetaren id zenbakia lortu */
            String sqlSelect = "SELECT produktua_prodId FROM praka WHERE produktua_prodId = (SELECT prodId FROM produktua WHERE prodKode = ?) AND prakTaila = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, kodea);
            ps.setInt(2, taila);
            rs = ps.executeQuery();
            rs.next();
            String id = rs.getString("produktua_prodId"); /* Ezabatu nahi den produktuaren ID-a gordetzen da */

            /* KAMISETA taulatik ezabatu */
            String sqlDelete = "DELETE FROM praka WHERE produktua_prodId = ?";
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
                System.out.println(kodea+" erreferentziadun praka ondo ezabatu da.");
            return ezabatuta;
        }
    }
    
    /* ArrayList-eko Praka guztien datuak erakusteko metodoa, dendan dagoen jakiteko. */
    public static ArrayList<Praka> prakaGutztErakutsi() {
        ArrayList<Praka> prakGuzt = new ArrayList<Praka>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, prakTaila, prakSasoia, prakLuzeera, prakMota "
                                + "FROM produktua JOIN praka ON prodId = produktua_prodId "
                                + "ORDER BY prodKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            System.out.println("PRAKAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s    %8$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Luzeera", "Mota");
            while(rs.next()){
                Praka prak = new Praka(); // objektu hutsa sortu
                prak.setKodPro(rs.getString("prodKode"));
                prak.setMarka(rs.getString("prodMarka"));
                prak.setPrezioa(rs.getDouble("prodPrezioa"));
                prak.setKolorea(rs.getString("prodKolorea"));
                prak.setSexua(rs.getString("prodSexua"));
                prak.setKantStock(rs.getInt("prodKantStock"));
                prak.setTaila(rs.getInt("prakTaila"));
                prak.setSasoia(rs.getString("prakSasoia"));
                prak.setLuzeera(rs.getInt("prakLuzeera"));
                prak.setMota(rs.getString("prakMota"));
                prakGuzt.add(prak);
                prak.printProd(); // objektuaren datuak erakutsi
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
            return prakGuzt;
        }
    }
    
    /* Praken datuak aldatzen dituen metodoa. Booleano bat itzuliko du, datuak aldatu diren edo ez jakiteko */
    public static boolean prakaDatuakAldatu(Praka prak1) {
        boolean aldatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null, psProd = null, psPrak = null;
        ResultSet rs = null;
        try {
            /* Produktuaren/Kamisetaren id zenbakia lortu */
            String sqlSelect = "SELECT produktua_prodId FROM praka WHERE produktua_prodId = (SELECT prodId FROM produktua WHERE prodKode = ?) AND prakTaila = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, prak1.getKodPro());
            ps.setInt(2, prak1.getTaila());
            rs = ps.executeQuery();
            rs.next();
            String id = rs.getString("produktua_prodId"); /* Aldatu nahi den produktuaren ID-a gordetzen da */
            
            /* PRODUKTUA taulako datuak aldatu */
            String sqlUpdate = "UPDATE produktua SET prodMarka = ?, prodPrezioa = ?, prodKolorea = ?, prodSexua = ?, prodKantStock = ? WHERE prodId = ? ";
            psProd = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            psProd.setString(1, prak1.getMarka());
            psProd.setDouble(2, prak1.getPrezioa());
            psProd.setString(3, prak1.getKolorea());
            psProd.setString(4, prak1.getSexua());
            psProd.setInt(5, prak1.getKantStock());
            psProd.setString(6, id);
            psProd.executeUpdate();

            /* KAMISETA taulako datuak aldatu */
            sqlUpdate = "UPDATE praka SET prakTaila = ?, prakSasoia = ?, prakLuzeera = ?, prakMota = ? WHERE produktua_prodId = ? ";
            psPrak = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
            psPrak.setInt(1, prak1.getTaila());
            psPrak.setString(2, prak1.getSasoia());
            psPrak.setInt(3, prak1.getLuzeera());
            psPrak.setString(4, prak1.getMota());
            psPrak.setString(5, id);
            psPrak.executeUpdate();
            
            aldatuta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        }
        finally {
            try {
                ps.close();
                psProd.close();
                psPrak.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
            if (aldatuta)
                System.out.println(prak1.getKodPro()+" kodea duen kamisetaren datuak aldatu dira.");
            else
                System.out.println(prak1.getKodPro()+" kodea duen kamisetaren datuak ez dira aldatu.");
            return aldatuta;
        }
    }
    
    /* Praka baten kodea, ArrayList-ean dagoen kontsultatu */
    public static ArrayList<Praka> prakaKontsultatu(String kodea) {
        ArrayList<Praka> prakKonts = new ArrayList<Praka>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        try {
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, prakTaila, prakSasoia, prakLuzeera, prakMota "
                                + "FROM produktua JOIN praka ON prodId = produktua_prodId "
                                + "WHERE prodKode = ?"
                                + "ORDER BY prodKode";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, kodea);
            ResultSet rs = ps.executeQuery();
            System.out.println();
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s    %8$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Luzeera", "Mota");
            while(rs.next()){
                Praka prak = new Praka(); // objektu hutsa sortu
                prak.setKodPro(rs.getString("prodKode"));
                prak.setMarka(rs.getString("prodMarka"));
                prak.setPrezioa(rs.getDouble("prodPrezioa"));
                prak.setKolorea(rs.getString("prodKolorea"));
                prak.setSexua(rs.getString("prodSexua"));
                prak.setKantStock(rs.getInt("prodKantStock"));
                prak.setTaila(rs.getInt("prakTaila"));
                prak.setSasoia(rs.getString("prakSasoia"));
                prak.setLuzeera(rs.getInt("prakLuzeera"));
                prak.setMota(rs.getString("prakMota"));
                prakKonts.add(prak);
                prak.printProd(); // objektuaren datuak erakutsi
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
            return prakKonts;
        }
    }

    /* kantitatea 5 baino gutxiago duten prakak erakusten ditu */
    public static ArrayList<Praka> prakaEskatzeko() {  
        ArrayList<Praka> prakEsk = new ArrayList<Praka>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, prakTaila, prakSasoia, prakLuzeera, prakMota "
                                + "FROM produktua JOIN praka ON prodId = produktua_prodId "
                                + "WHERE prodKantStock < 5 "
                                + "ORDER BY prodKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            System.out.println("PRAKAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s    %7$-10s    %8$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak", "Luzeera", "Mota");
            while(rs.next()){
                Praka prak = new Praka(); // objektu hutsa sortu
                prak.setKodPro(rs.getString("prodKode"));
                prak.setMarka(rs.getString("prodMarka"));
                prak.setPrezioa(rs.getDouble("prodPrezioa"));
                prak.setKolorea(rs.getString("prodKolorea"));
                prak.setSexua(rs.getString("prodSexua"));
                prak.setKantStock(rs.getInt("prodKantStock"));
                prak.setTaila(rs.getInt("prakTaila"));
                prak.setSasoia(rs.getString("prakSasoia"));
                prak.setTaila(rs.getInt("prakLuzeera"));
                prak.setSasoia(rs.getString("prakMota"));
                prakEsk.add(prak);
                prak.printProd(); // objektuaren datuak erakutsi
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
            return prakEsk;
        }
    }
    
    /* PRAKAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */ 
    public static boolean prodSaldu(String kodea, int taila, int kantitatea) {
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
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, prakTaila, prakSasoia, prakLuzeera, prakMota "
                                + "FROM produktua JOIN praka ON prodId = produktua_prodId "
                                + "WHERE prodKode = '"+kodea+"' AND prakTaila = '"+taila+"' "
                                + "ORDER BY prodKode";
            rs = stmt.executeQuery(sqlSelect);
            System.out.println("PRAKAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak");
            Praka prak = null;
            while(rs.next()){
                prak = new Praka(); // objektu hutsa sortu
                prak.setKodPro(rs.getString("prodKode"));
                prak.setMarka(rs.getString("prodMarka"));
                prak.setPrezioa(rs.getDouble("prodPrezioa"));
                prak.setKolorea(rs.getString("prodKolorea"));
                prak.setSexua(rs.getString("prodSexua"));
                prak.setKantStock(rs.getInt("prodKantStock"));
                prak.setTaila(rs.getInt("prakTaila"));
                prak.setSasoia(rs.getString("prakSasoia"));
                prak.setLuzeera(rs.getInt("prakLuzeera"));
                prak.setMota(rs.getString("prakMota"));
            }
            
            /* Produktuaren/Jertsearen id zenbakia lortu */
            sqlSelect = "SELECT produktua_prodId FROM jertsea WHERE produktua_prodId = (SELECT prodId FROM produktua WHERE prodKode = ?) AND jertsTaila = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, prak.getKodPro());
            ps.setInt(2, prak.getTaila());
            rs = ps.executeQuery();
            rs.next();
            id = rs.getString("produktua_prodId"); /* Ezabatu nahi den produktuaren ID-a gordetzen da */
            
            if (prak.isEskuragai()) {
                /* PRODUKTUA TAULA ALDATU */
                String sqlUpdate = "UPDATE produktua SET prodKantStock = ? WHERE prodId = ? ";
                psProduktua = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlUpdate); // UPDATE-a preparatu
                psProduktua.setInt(1, prak.getKantStock()-kantitatea); // saldutakoak stock-etik kendu
                psProduktua.setString(2, id);
                psProduktua.executeUpdate();
                
                salduta = true;
                System.out.println(""
                    + "\tKodea\t-\tPrezioa \n\n"
                    + "\t"+prak.getKodPro()+"\t-\t"+prak.getPrezioa()+"  (x"+kantitatea+")\n"
                    + "  --------------------------------------\n"
                    + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+prak.getPrezioa()*kantitatea+"€");
            }
                prak.getPrezioa();
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return salduta; // objektua datu basean gorde den edo ez bueltatuko du
        } 
    }
}
