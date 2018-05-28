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
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
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
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
        }
        finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printUrdinez(ex.getMessage()));
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
                prak.setTaila(rs.getInt("prakLuzeera"));
                prak.setSasoia(rs.getString("prakMota"));
                prakGuzt.add(prak);
                prak.printProd(); // objektuaren datuak erakutsi
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
            return prakGuzt;
        }
    }
    
    /* Praka baten kodea, ArrayList-ean dagoen kontsultatu */
    public static ArrayList<Praka> prakaKontsultatu(String kodea) {
        ArrayList<Praka> prakKonts = new ArrayList<Praka>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        try {
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, jertsTaila "
                                + "FROM produktua JOIN jertsea ON prodId = produktua_prodId "
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
                prak.setTaila(rs.getInt("prakLuzeera"));
                prak.setSasoia(rs.getString("prakMota"));
                prakKonts.add(prak);
                prak.printProd(); // objektuaren datuak erakutsi
            }
        } catch (SQLException ex) {
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
        } 
        finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printUrdinez(ex.getMessage()));
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
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
        } 
        finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println(Metodoak.printUrdinez(ex.getMessage()));
            }
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return prakEsk;
        }
    }
    
    /* PRAKAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */ 
//    public static boolean prodSaldu(String kodea, int taila, int kantitatea) {
//        boolean bool = false;
//        System.out.println(""
//                + "-----------------------------------------\n"
//                + "|         Produktuaren salmenta         |\n"
//                + "-----------------------------------------");
//        try {
//            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fPrakTemp, true)); // fitx berrian idazten joateko
//            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fPrak));
//            while (true) {
//                Praka prak = (Praka) geois.readObject(); // objektua irakurri 
//                if (!prak.getKodPro().equals(kodea.toUpperCase())) { // kodea konparatu
//                    geoos.writeObject(prak); // objektua fitxategi berrian idatzi
//                    geoos.flush();
//                } 
//                else {
//                    if (!(prak.getTaila()==taila)) {
//                        geoos.writeObject(prak); // objektua fitxategi berrian idatzi
//                        geoos.flush();
//                    }
//                    else {
//                        if (prak.isEskuragai()) {
//                            if (prak.getKodPro().equals(kodea) && prak.getKantStock()>=kantitatea) {
//                                prak.setKantStock(prak.getKantStock()-kantitatea); // salduko den prod kantitatea stock-etik kendu
//                                geoos.writeObject(prak); // objektua fitxategi berrian idatzi
//                                geoos.flush();
//                                bool = true;
//                                System.out.println(""
//                                    + "\tKodea\t-\tPrezioa \n\n"
//                                    + "\t"+prak.getKodPro()+"\t-\t"+prak.getPrezioa()+"  (x"+kantitatea+")\n"
//                                    + "  --------------------------------------\n"
//                                    + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+prak.getPrezioa()*kantitatea+"€");
//                            }
//                            prak.getPrezioa();
//                        }
//                    }
//                }
//            }
//        } catch (EOFException ex) { 
//            // fitxategiaren bukaerara heltzen denean, errorea omititu
//        } catch (FileNotFoundException ex) {
//            System.out.println(Metodoak.printUrdinez("Fitxategia ez du aurkitzen!"));
//        } catch (ClassNotFoundException | IOException ex) {
//            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak jasotzerakoan"));
//        } 
//        System.gc();
//        try {
//            Files.move(Paths.get(fPrakTemp.getAbsolutePath()), Paths.get(fPrak.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ex) {
//            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        if (!bool)
//                System.out.println("\tProduktu hori ez dago dendan.");
//        return bool;
//    }
}
