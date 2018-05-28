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
import model.Jertsea;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class JertseaKudeatu {
    /* Jertse berri bat gehitu */
    public static boolean jertsGehitu(Jertsea jerts1) {
        boolean gordeta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement psJerts, psProd;
        try {
            /* PRODUKTUA taulan datuak gorde */
            String sqlInsert = "INSERT INTO produktua (prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock) VALUES (?, ?, ?, ?, ?, ?)";
            psProd = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psProd.setString(1, jerts1.getKodPro());
            psProd.setString(2, jerts1.getMarka());
            psProd.setDouble(3, jerts1.getPrezioa());
            psProd.setString(4, jerts1.getKolorea());
            psProd.setString(5, jerts1.getSexua());
            psProd.setInt(6, jerts1.getKantStock());
            psProd.executeUpdate();/* Aldaketak gorde */
            
            /* JERTSEA taulan datuak gorde */
            sqlInsert = "INSERT INTO jertsea VALUES (?, (SELECT prodId FROM produktua WHERE prodKode = ?))";
            psJerts = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlInsert); // INSERT-a preparatu
            /* Objektuko datuak, ps-n gehitu */
            psJerts.setString(1, jerts1.getTaila());
            psJerts.setString(2, jerts1.getKodPro());
            psJerts.executeUpdate(); /* Aldaketak gorde */
            
            System.out.println("Datu hauek dituen produktua gorde da."
                + "\nProduktua: JERTSEA");
            jerts1.printDatuak();
            
            gordeta = true;
        } catch (SQLException ex) {
            System.out.println(Metodoak.printErrMezuak(ex.getMessage()));
        } finally {
            konexioa.deskonektatu(); // datu basetik deskonektatu
            return gordeta; // objektua datu basean gorde den edo ez bueltatuko du
        }
    }
    
    /* Jertse zehatz baten datu guztiak ezabatu */    
    public static boolean jertseaEzabatu(String kodea, String taila) {
        boolean ezabatuta = false;
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            /* Produktuaren/Jertsearen id zenbakia lortu */
            String sqlSelect = "SELECT produktua_prodId FROM jertsea WHERE produktua_prodId = (SELECT prodId FROM produktua WHERE prodKode = ?) AND jertsTaila = ? ";
            ps = (PreparedStatement) konexioa.getDBKonexioa().prepareStatement(sqlSelect);
            ps.setString(1, kodea);
            ps.setString(2, taila);
            rs = ps.executeQuery();
            rs.next();
            String id = rs.getString("produktua_prodId"); /* Ezabatu nahi den produktuaren ID-a gordetzen da */

            /* JERTSEA taulatik ezabatu */
            String sqlDelete = "DELETE FROM jertsea WHERE produktua_prodId = ?";
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
                System.out.println(kodea+" erreferentziadun jertsea ondo ezabatu da.");
            return ezabatuta;
        }
    }
    
    /* ArrayList-eko Jertse guztien datuak erakusteko metodoa */
    public static ArrayList<Jertsea> jertsGuztErakutsi() {
        ArrayList<Jertsea> jertsGuzt = new ArrayList<Jertsea>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, jertsTaila "
                                + "FROM produktua JOIN jertsea ON prodId = produktua_prodId "
                                + "ORDER BY prodKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            System.out.println("JERTSEAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak");
            while(rs.next()){
                Jertsea jerts = new Jertsea(); // objektu hutsa sortu
                jerts.setKodPro(rs.getString("prodKode"));
                jerts.setMarka(rs.getString("prodMarka"));
                jerts.setPrezioa(rs.getDouble("prodPrezioa"));
                jerts.setKolorea(rs.getString("prodKolorea"));
                jerts.setSexua(rs.getString("prodSexua"));
                jerts.setKantStock(rs.getInt("prodKantStock"));
                jerts.setTaila(rs.getString("jertsTaila"));
                jertsGuzt.add(jerts);
                jerts.printProd(); // objektuaren datuak erakutsi
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
            return jertsGuzt;
        }
    }
    
    /* Jertse baten kodea, ArrayList-ean dagoen kontsultatu, dendan dagoen jakiteko. */
    public static ArrayList<Jertsea> jertseaKontsultatu(String kodea) {
        ArrayList<Jertsea> jertsKonts = new ArrayList<Jertsea>();
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
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-10s    %5$-10s    %6$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Kantitatea", "Taila");
            while(rs.next()){
                Jertsea jerts = new Jertsea(); // objektu hutsa sortu
                jerts.setKodPro(rs.getString("prodKode"));
                jerts.setMarka(rs.getString("prodMarka"));
                jerts.setPrezioa(rs.getDouble("prodPrezioa"));
                jerts.setKolorea(rs.getString("prodKolorea"));
                jerts.setSexua(rs.getString("prodSexua"));
                jerts.setKantStock(rs.getInt("prodKantStock"));
                jerts.setTaila(rs.getString("jertsTaila"));
                jertsKonts.add(jerts);
                jerts.printProd(); // objektuaren datuak erakutsi
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
            return jertsKonts;
        }
    }
    
    /* kantitatea 5 baino gutxiago duten jertseak erakusten ditu */
    public static ArrayList<Jertsea> jertseaEskatzeko() {
        ArrayList<Jertsea> jertsEsk = new ArrayList<Jertsea>();
        DBKonexioa konexioa = new DBKonexioa(); // datu basera konektatu
        Statement stmt = null;
        try {
            stmt = (Statement) konexioa.getDBKonexioa().createStatement();
            String sqlSelect = "SELECT prodKode, prodMarka, prodPrezioa, prodKolorea, prodSexua, prodKantStock, jertsTaila "
                                + "FROM produktua JOIN jertsea ON prodId = produktua_prodId "
                                + "WHERE prodKantStock < 5 "
                                + "ORDER BY prodKode";
            ResultSet rs = stmt.executeQuery(sqlSelect);
            System.out.println("JERTSEAK:");
            System.out.printf("\t%1$-15s    %2$-10s    %3$-10s    %4$-15s    %5$-10s    %6$-10s\n", "Kodea", "Marka", "Kolorea", "Sexua", "Prezioa", "Tailak");
            while(rs.next()){
                Jertsea jerts = new Jertsea(); // objektu hutsa sortu
                jerts.setKodPro(rs.getString("prodKode"));
                jerts.setMarka(rs.getString("prodMarka"));
                jerts.setPrezioa(rs.getDouble("prodPrezioa"));
                jerts.setKolorea(rs.getString("prodKolorea"));
                jerts.setSexua(rs.getString("prodSexua"));
                jerts.setKantStock(rs.getInt("prodKantStock"));
                jerts.setTaila(rs.getString("jertsTaila"));
                jertsEsk.add(jerts);
                jerts.printProd(); // objektuaren datuak erakutsi
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
            return jertsEsk;
        }
    }
    
    /* JERTSEAK saltzeko metodoa. Erabiltzaileak kodea, taila eta kantitatea sartuko ditu. */
//    public static boolean prodSaldu(String kodea, int kantitatea, String taila) {
//        boolean bool = false;
//        System.out.println(""
//                + "-----------------------------------------\n"
//                + "|         Produktuaren salmenta         |\n"
//                + "-----------------------------------------");
//        try {
//            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fJertsTemp, true)); // fitx berrian idazten joateko
//            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fJerts));
//            while (true) {
//                Jertsea jerts = (Jertsea) geois.readObject(); // objektua irakurri  
//                if (!jerts.getKodPro().toLowerCase().equals(kodea.toLowerCase())) { // kodea konparatu
//                    geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
//                    geoos.flush();
//                } 
//                else {
//                    if (!jerts.getTaila().toLowerCase().equals(taila.toLowerCase())) {
//                        geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
//                        geoos.flush();
//                    }
//                    else {
//                        if (jerts.isEskuragai()) {
//                            if (jerts.getKodPro().toLowerCase().equals(kodea.toLowerCase()) && jerts.getKantStock()>=kantitatea) {
//                                int k = jerts.getKantStock()-kantitatea;
//                                jerts.setKantStock(k); // salduko den prod kantitatea stock-etik kendu
//                                geoos.writeObject(jerts); // objektua fitxategi berrian idatzi
//                                geoos.flush();
//                                bool = true;
//                                System.out.println(""
//                                    + "\tKodea\t-\tPrezioa \n\n"
//                                    + "\t"+jerts.getKodPro()+"\t-\t"+jerts.getPrezioa()+"  (x"+kantitatea+")\n"
//                                    + "  --------------------------------------\n"
//                                    + "\tORDAINTZEKOA \n\tGUZTIRA: \t\t"+jerts.getPrezioa()*kantitatea+"€");
//                            }
//                            jerts.getPrezioa();
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
//            Files.move(Paths.get(fJertsTemp.getAbsolutePath()), Paths.get(fJerts.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ex) {
//            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        if (!bool)
//                System.out.println("\tProduktu hori ez dago dendan.");
//        return bool;
//    }
}
