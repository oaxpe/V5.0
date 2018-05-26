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
            System.out.println(Metodoak.printUrdinez(ex.getMessage()));
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
        return bezGuzt;
    }
    
    /* Bezeroaren datuak aldatu (erabiltzaileak bere dni-a sartu beharko du) */
//    public static void bezeroDatuakAldatu(String nan, int aukera) {
//        boolean aldatuta = true;
//        try {
//            GoibururikEzObjectOutputStream geoos = new GoibururikEzObjectOutputStream(new FileOutputStream(fBezTemp, true)); // fitx berrian idazten joateko
//            GoibururikEzObjectInputStream geois = new GoibururikEzObjectInputStream(new FileInputStream(fBez));
//            while (true) {
//                Bezeroa bez = (Bezeroa) geois.readObject(); // objektua irakurri   
//                Bezeroa b = new Bezeroa(bez.getKodBez(), bez.getIzena(), bez.getAbizena1(), bez.getAbizena2(), bez.getNan(), bez.getJaiotzeData(), bez.getSexua(), bez.getHerria(), bez.getTelefonoa());
//                if (!b.getNan().equals(nan.toUpperCase())) { // kodea konparatu
//                    aldatuta=false;
//                }
//                else {
//                    switch (aukera) {
//                        case 1:
//                            b.setIzena();
//                            break;
//                        case 2:
//                            b.setAbizena1();
//                            break;
//                        case 3:
//                            b.setAbizena2();
//                            break;
//                        case 4:
//                            b.setNan();
//                            break;
//                        case 5:
//                            b.setJaiotzeData();
//                            break;
//                        case 6:
//                            b.setSexua();
//                            break;
//                        case 7:
//                            b.setHerria();
//                            break;
//                        case 8:
//                            b.setTelefonoa();
//                            break;
//                        default:
//                            aldatuta = false;
//                            System.out.println("Ez da aldaketarik egingo.");
//                            break;
//                    }
//                }
//                geoos.writeObject(b); // objektua fitxategian idatzi
//                geoos.flush();
//                if (aldatuta) {                   
//                    System.out.println("\nAldatutako datua gorde da.");
//                    System.out.println("\nBezeroaren datuak honako hauek dira: ");
//                    b.printDatuak();
//                }
//            }
//        } catch (EOFException ex) { 
//            // fitxategiaren bukaerara heltzen denean, errorea omititu
//            System.gc();
//        } catch (FileNotFoundException ex) {
//            System.out.println(Metodoak.printUrdinez("Fitxategia ez du aurkitzen!"));
//        } catch (ClassNotFoundException | IOException ex) {
//            System.out.println(Metodoak.printUrdinez("Arazoak daude datuak jasotzerakoan"));
//        }
//        
//        try {
//            Files.move(Paths.get(fBezTemp.getAbsolutePath()), Paths.get(fBez.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException ex) {
//            Logger.getLogger(PrakaKudeatu.class.getName()).log(Level.SEVERE, null, ex);
//            fBezTemp.delete();
//        }
//    }
}
