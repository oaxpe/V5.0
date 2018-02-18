/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.DendaKudeatu;
import gestioa.BezeroaKudeatu;
import gestioa.LangileaKudeatu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static proiektua_denda.Proiektua_denda.pausa;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class LangBezDenKudeatu {

    /* Main-etik deitzen da. Langileak, bezeroak eta denda kudeatzeko funtzioa  */
    public static void langBezDenKudeatu() {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int aukera = 0;        

        // Bezeroak, langileak eta denda kudeatu.
        do {
            langBezDendMenua();
            try {
                aukera = Integer.parseInt(br.readLine());
            }
            catch (NumberFormatException datuOkerrak) {
                System.out.println("Zenbaki bat sartu behar zenuen.");
            }
            catch (IOException gaizki) {
                System.out.println("Arazoak daude datuak sartzerakoan.");
            }
            System.out.println();
            
            switch (aukera) {
                // 0.- Irten
                case 0:
                    pausa();
                    System.exit(0);
                    break;

                // 1.- Bezeroak kudeatzeko submenua
                case 1:
                {
                    bezeroMenua();
                    try {
                        aukera = Integer.parseInt(br.readLine());
                    }
                    catch (NumberFormatException datuOkerrak) {
                        System.out.println("Zenbaki bat sartu behar zenuen.");
                    }
                    catch (IOException gaizki) {
                        System.out.println("Arazoak daude datuak sartzerakoan.");
                    }
                    switch (aukera) {
                        // 0.- Irten
                        case 0:
                            pausa();
                            System.exit(0);
                            break;
                        // 1.- Bezero berri bat gehitu.      *\n"
                        case 1:
                            BezeroaKudeatu.bezeroaGehitu();
                            pausa();
                            break;
                         
                        //  2.- Bezero bat ezabatu.
                        case 2:
                            try {
                                System.out.print("Sartu NAN zenbakia: ");
                                String nan=br.readLine();
                                BezeroaKudeatu.bezeroaEzabatu(nan);
                            }
                            catch (IOException gaizki) {
                                System.out.println("Arazoak daude datuak sartzerakoan.");
                            }
                            break;
                            
                        // 3.- Bezeroen datuak aldatu.
                        case 3:
                            try {
                                System.out.print("Sartu datuak aldatu nahi dituzun bezeroaren NAN zenbakia: ");
                                String nan = br.readLine().toUpperCase();
                                bezeroDatuakAldatu(); // bezeroaren datuak aukeratzeko menua
                                int atrAuk = Integer.parseInt(br.readLine());
                                BezeroaKudeatu.bezeroDatuakAldatu(nan, atrAuk);
                            }
                            catch (IOException gaizki) {
                                System.out.println("Arazoak daude datuak sartzerakoan.");
                            }
                            break;
                            
                        // 4.- Bezeroak kontsultatu.
                        case 4:
                            BezeroaKudeatu.bezeroGuztiakErakutsi();
                            pausa();
                            break;
                            
                        default:
                            System.out.println("Zenbaki okerra sartu duzu! Irakurri ondo aukerak eta aukeratu.");
                            pausa();
                            break;
                    }
                    break;
                } // "Bezeroak kudeatu" bukaera.
                    
                // 2.- Langileak kudeatzeko submenua
                case 2:
                {
                    langileMenua();
                    try {
                        aukera = Integer.parseInt(br.readLine());
                    }
                    catch (NumberFormatException datuOkerrak) {
                        System.out.println("Zenbaki bat sartu behar zenuen.");
                    }
                    catch (IOException gaizki) {
                        System.out.println("Arazoak daude datuak sartzerakoan.");
                    }
                    switch (aukera) {
                        // 0.- Irten
                        case 0:
                            pausa();
                            System.exit(0);
                            break;
                            
                        // 1.- Langile berri bat gehitu.
                        case 1:
                            LangileaKudeatu.langileaGehitu();
                            pausa();
                            break;
                         
                        //  2.- Langile bat ezabatu.
                        case 2:
                            try {
                                System.out.print("Sartu NAN zenbakia: ");
                                String nan=br.readLine().toUpperCase();
                                LangileaKudeatu.langileaEzabatu(nan);
                            }
                            catch (IOException gaizki) {
                                System.out.println("Arazoak daude datuak sartzerakoan.");
                            }    
                            break;
                            
                        // 3.- Langilearen datuak aldatu.
                        case 3:
                            try {
                                System.out.print("Sartu datuak aldatu nahi dituzun langilearen NAN zenbakia: ");
                                String nan = br.readLine();
                                LangileaKudeatu.langileaDatuakAldatu(nan);
                            }
                            catch (IOException gaizki) {
                                System.out.println("Arazoak daude datuak sartzerakoan.");
                            }
                            break;
                            
                        // 4.- Langileak kontsultatu.
                        case 4:
                            LangileaKudeatu.langileGuztiakErakutsi();
                            pausa();
                            break;
                        default:
                            System.out.println("Zenbaki okerra sartu duzu! Irakurri ondo aukerak eta aukeratu.");
                            pausa();
                            break;
                    }
                    break;
                } // "Langileak kudeatu" bukaera.

                // 3.- Denda kudeatzeko submenua
                case 3:
                {
                    dendaMenua();
                    try {
                        aukera = Integer.parseInt(br.readLine());
                    }
                    catch (NumberFormatException datuOkerrak) {
                        System.out.println("Zenbaki bat sartu behar zenuen.");
                    }
                    catch (IOException gaizki) {
                        System.out.println("Arazoak daude datuak sartzerakoan.");
                    }
                    switch (aukera) {
                        // 0.- Irten
                        case 0:
                            pausa();
                            System.exit(0);
                            break;
                        // 1.- Dendaren datuak kontsultatu.
                        case 1:
                            DendaKudeatu.datuakErakutsi();
                            pausa();
                            break;

                        // 2.- Dendaren datuak aldatu.
                        case 2:
                            dendaDatuakAldatuMenua();                    
                            int aldaketa=0;
                            try {
                                aldaketa = Integer.parseInt(br.readLine());
                            
                                switch (aldaketa) {
                                    case 0:
                                        System.out.println("\nEz duzu aldaketarik egin.");
                                        break;
                                    case 1:
                                        DendaKudeatu.datuakAldatu(1); // Izena aldatu
                                        break;
                                    case 2:
                                        DendaKudeatu.datuakAldatu(2); // Helbidea aldatu
                                        break;
                                    case 3:
                                        DendaKudeatu.datuakAldatu(3); // Herria aldatu
                                        break;
                                    case 4:
                                        DendaKudeatu.datuakAldatu(4); // Posta kodea aldatu
                                        break;
                                    case 5:
                                        DendaKudeatu.datuakAldatu(5); // Email-a aldatu
                                        break;
                                    case 6:
                                        DendaKudeatu.datuakAldatu(6); // Telefonoa aldatu
                                        break;
                                    default:
                                        System.out.println("Zenbaki okerra sartu duzu! Irakurri ondo aukerak eta aukeratu.");
                                        pausa();
                                        break;
                                }
                            }
                            catch (NumberFormatException datuOkerrak) {
                                System.out.println("Zenbaki bat sartu behar zenuen.");
                            }
                            catch (IOException gaizki) {
                                System.out.println("Arazoak daude datuak sartzerakoan.");
                            }
                            
                            pausa();
                            if (aldaketa>0 && aldaketa<=6) {
                                System.out.println("Aldaketak egin ondoren, dendaren datuak honako hauek dira.");
                                DendaKudeatu.datuakErakutsi();
                                pausa();
                            }
                            break;
                    }
                    break;
                } // "Denda kudeatu" bukatu.

                default:
                    System.out.println("Zenbaki okerra sartu duzu! Irakurri ondo aukerak eta aukeratu.");
                    pausa();
                    break;
            } 
        } while (aukera!=0);
    }
    
    /* Langileak, bezeroak eta denda kudeatzeko menua */
    public static void langBezDendMenua() {
        System.out.print("\n"
                    + "*****************************************\n"
                    + "*     LANGILEAK, BEZEROAK eta DENDA     *\n"
                    + "*                KUDEATU                *\n"
                    + "*****************************************\n"
                    + "* Zer egin nahi duzu?                   *\n"
                    + "*    0.- Irten.                         *\n"
                    + "*    1.- Bezeroak kudeatu.              *\n"
                    + "*    2.- Langileak kudeatu.             *\n"
                    + "*    3.- Denda kudeatu.                 *\n"
                    + "*****************************************\n"
                    + "Aukeratu: ");
    }
    
    /* Bezeroak kudeatzeko menua */
    public static void bezeroMenua() {
        System.out.print("\n"
                    + "****************************************\n"
                    + "*               BEZEROAK               *\n"
                    + "****************************************\n"
                    + "* Zer egin nahi duzu?                  *\n"
                    + "*    0.- Irten.                        *\n"
                    + "*    1.- Bezero berri bat gehitu.      *\n"
                    + "*    2.- Bezero bat ezabatu.           *\n"
                    + "*    3.- Bezeroen datuak aldatu.       *\n"
                    + "*    4.- Bezeroak kontsultatu.         *\n"
                    + "*****************************************\n"
                    + "Aukeratu: ");
        
    }
    
    /* Bezero baten datuak aldatzeko submenua */
    public static void bezeroDatuakAldatu() {
        System.out.print("\n"
                    + "Zein datu aldatu nahi duzu?\n"
                    + "\t1.- Izena.\n"
                    + "\t2.- Lehenengo abizena.\n"
                    + "\t3.- Bigarren abizena.\n"
                    + "\t4.- NAN zenbakia.\n"
                    + "\t5.- Jaiotze data.\n"
                    + "\t6.- Sexua.\n"
                    + "\t7.- Herria.\n"
                    + "\t8.- Telefonoa.\n"
                    + "Aukeratu:");
    }
    
    /* Langileak kudeatzeko menua */
    public static void langileMenua() {
        System.out.print("\n"
                    + "****************************************\n"
                    + "*              LANGILEAK               *\n"
                    + "****************************************\n"
                    + "* Zer egin nahi duzu?                  *\n"
                    + "*    0.- Irten.                        *\n"
                    + "*    1.- Langile berri bat gehitu.     *\n"
                    + "*    2.- Langile bat ezabatu.          *\n"
                    + "*    3.- Langileen datuak aldatu.      *\n"
                    + "*    4.- Langileak kontsultatu.        *\n"
                    + "*****************************************\n"
                    + "Aukeratu: ");
    }
    
    /* Denda kudeatzeko menua */
    public static void dendaMenua() {
        System.out.print("\n"
                    + "****************************************\n"
                    + "*                 DENDA                *\n"
                    + "****************************************\n"
                    + "* Zer egin nahi duzu?                  *\n"
                    + "*    0.- Irten.                        *\n"
                    + "*    1.- Dendaren datuak kontsultatu.  *\n"
                    + "*    2.- Dendaren datuak aldatu.       *\n"
                    + "*****************************************\n"
                    + "Aukeratu: ");
    }
    
    /* Dendako datuak aldatzeko submenua */
    public static void dendaDatuakAldatuMenua() {
        System.out.print("Zer aldatu nahi duzu?\n"
                            + "(0) Ezer.\n"
                            + "(1) Izena.\n"
                            + "(2) Helbidea.\n"
                            + "(3) Herria.\n"
                            + "(4) Posta kodea.\n"
                            + "(5) Email-a.\n"
                            + "(6) Telefonoa.\n"
                            + "Aukeratu: ");
    }
}