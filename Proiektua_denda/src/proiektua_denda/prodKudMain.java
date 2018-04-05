/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.EskaeraKudeatu;
import gestioa.HornitzaileaKudeatu;
import gestioa.Metodoak;
import gestioa.ProduktuaKudeatu;
import gestioa.PrakaKudeatu;
import gestioa.KamisetaKudeatu;
import gestioa.JertseaKudeatu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static proiektua_denda.Proiektua_denda.pausa; // pausa funtzioa importatu

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class prodKudMain {

    /* Main-etik deitzen da. Produktuak kudeatzeko funtzioa  */
    public static void prodKudMain() throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int aukera = 0;    
        do {
            prodKudeatuMenua();
            try {
                aukera = Integer.parseInt(br.readLine());
            }
            catch (NumberFormatException datuOkerrak) {
                System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
            }
            catch (IOException gaizki) {
                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
            }
            System.out.println();
            
            switch (aukera) {
                //0.- Irten
                case 0:
                    System.exit(0);
                
                // 1.- Produktuak gehitu.    
                case 1:
                {
                    System.out.print("Produktu berri bat gehitu behar duzu.\n\n");
                    produktuMotaMenua(); // produktu mota desberdinak agertzen diren menua.
                    int prodMota=0;
                    try {
                        prodMota = Integer.parseInt(br.readLine());
                    }
                    catch (NumberFormatException datuOkerrak) {
                        System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
                    }
                    catch (IOException gaizki) {
                        System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                    }
                    System.out.println();
                    switch (prodMota) {
                        // Produktua, JERTSEA bada:
                        case 1:
                            JertseaKudeatu.jertsGehitu();
                            break;
                           
                        // Produktua, KAMISETA bada:
                        case 2:
                            KamisetaKudeatu.kamisetaGehitu();
                            break;
                        // Produktua, PRAKA bada:
                        case 3:
                            PrakaKudeatu.prakaGehitu();
                            break;
                            
                        default:
                            System.out.println(Metodoak.printGorriz("Zenbaki okerra sartu duzu. Saiatu berriro!"));
                    }
                    pausa();
                    break;
                } // case 1-en bukaera
                
                // 2.- Produktua ezabatu.
                case 2:
                {
                    System.out.println("Zein produktu ezabatu nahi duzu?");
                    produktuMotaMenua(); // produktu mota desberdinak agertzen diren menua.
                    int prodMota = 0;
                    try {
                        prodMota = Integer.parseInt(br.readLine());
                    }
                     catch (NumberFormatException datuOkerrak) {
                        System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
                    }
                    catch (IOException gaizki) {
                        System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                    }
                    System.out.println();
                    switch (prodMota) {
                        case 0:
                            System.exit(0);
                            
                        // Produktua, JERTSEA bada:
                        case 1:
                        {
                            try {
                                System.out.print("Sartu ezabatzea nahi duzun jertsearen kodea: ");
                                String kodea = br.readLine();
                                JertseaKudeatu.jertseaEzabatu(kodea);
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            } 
                            break;
                        }
  
                        // Produktua, KAMISETA bada:
                        case 2:
                        {
                            try {
                                System.out.print("Sartu ezabatzea nahi duzun kamisetaren kodea: ");
                                String kodea = br.readLine();
                                KamisetaKudeatu.kamisetaEzabatu(kodea);
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            }
                            break;
                        }
                              
                        // Produktua, PRAKA bada:
                        case 3:
                        {
                            try {
                                System.out.print("Sartu ezabatzea nahi duzun kamisetaren kodea: ");
                                String kodea = br.readLine();
                                PrakaKudeatu.prakaEzabatu(kodea);   
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            }
                            break;
                        }                          
                    }
                    pausa();
                    break;
                } // "Produktua ezabatu" bukaera
                    
                // 3.- Produktuak kontsultatu.
                case 3:
                    ProduktuaKudeatu.prodErakutsi();
                    pausa();
                    break;
                    
                // 4.- Produktua dendan dagoen kontsultatu.
                case 4:
                {
                    System.out.println("Zein produktu mota kontsultatu nahi duzu? ");
                    produktuMotaMenua();
                    int prodMota = 0;
                    try {
                        prodMota = Integer.parseInt(br.readLine());
                    }
                    catch (NumberFormatException datuOkerrak) {
                        System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
                    }
                    catch (IOException gaizki) {
                        System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                    }
                    System.out.println();
                    switch (prodMota) {
                        // Produktua, JERTSEA bada:
                        case 1:
                        {
                            try {
                                System.out.print("Sartu produktuaren kodea (erreferentzia): ");
                                String kodPro = br.readLine();
                                JertseaKudeatu.jertseaKontsultatu(kodPro);
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            }
                            pausa();
                            break;
                        }
                        
                        // Produktua, KAMISETA bada:
                        case 2:
                        {
                            try {
                                System.out.print("Sartu produktuaren kodea (erreferentzia): ");
                                String kodPro = br.readLine();
                                KamisetaKudeatu.kamisetaKontsultatu(kodPro);
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            }
                            pausa();
                            break;
                        }
                        
                        // Produktua, PRAKA bada:
                        case 3:
                        {
                            try {
                                System.out.print("Sartu produktuaren kodea (erreferentzia): ");
                                String kodPro = br.readLine();
                                PrakaKudeatu.prakaKontsultatu(kodPro);
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            }
                            pausa();
                            break;
                        } 
                    }
                    break;                   
                }
                
                // 5.- Inbentarioa (zer dagoen eta zenbat).
                case 5:
                    ProduktuaKudeatu.inbentarioa();
                    pausa();
                    break;
                    
                // 6.- Eskatzeko produktuen zerrenda ikusi
                case 6:
                    ProduktuaKudeatu.prodEskatzeko();
                    pausa();
                    break;
                
                // 7.- Produktuak saldu.
                case 7:
                {
                    System.out.print("Produktu bat saldu behar duzu.\n\n");
                    produktuMotaMenua(); // produktu mota desberdinak agertzen diren menua.
                    int prodMota = 0;
                    try {
                        prodMota = Integer.parseInt(br.readLine());
                    }
                     catch (NumberFormatException datuOkerrak) {
                        System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
                    }
                    catch (IOException gaizki) {
                        System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                    }
                    System.out.println();
                    switch (prodMota) {
                        case 0:
                            System.exit(0);
                        
                        // Produktua, JERTSEA bada:
                        case 1:
                        {
                            try {
                                System.out.print("Sartu saldu behar duzun produktuaren kodea: ");
                                String kodea = br.readLine();
                                System.out.print("Sartu taila: ");
                                String taila = br.readLine().toUpperCase();
                                System.out.print("Sartu kantitatea: ");
                                int kantitatea = Integer.parseInt(br.readLine());
                                JertseaKudeatu.prodSaldu(kodea, kantitatea, taila);
                            }
                            catch (NumberFormatException datuOkerrak) {
                                System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            }
                            pausa();
                            break;
                        }
                        
                        // Produktua, KAMISETA bada:
                        case 2:
                        {
                            try {
                                System.out.print("Sartu saldu behar duzun produktuaren kodea: ");
                                String kodea = br.readLine();
                                String taila;
                                do {
                                    System.out.print("Sartu taila (XS,S,M,L,XL,XXL): ");
                                    taila = br.readLine().toUpperCase();
                                    if (!Metodoak.tailaKontrolatu(taila))
                                        System.out.println(Metodoak.printGorriz("\tGaizki sartu duzu taila. Saiatu berriz."));
                                } while (!Metodoak.tailaKontrolatu(taila));                          
                                System.out.print("Sartu kantitatea: ");
                                int kantitatea = Integer.parseInt(br.readLine());

                                KamisetaKudeatu.prodSaldu(kodea, taila, kantitatea);
                            }
                            catch (NumberFormatException datuOkerrak) {
                                System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            }
                            pausa();
                            break;
                        }
                        
                        // Produktua, PRAKA bada:
                        case 3:
                        {
                            try {
                                System.out.print("Sartu saldu behar duzun produktuaren kodea: ");
                                String kodea = br.readLine();
                                int taila;
                                do {
                                    System.out.print("Sartu taila (38,40,42,44,46): ");
                                    taila = Integer.parseInt(br.readLine());
                                    if (!Metodoak.tailaKontrolatu(taila))
                                        System.out.println(Metodoak.printGorriz("\tGaizki sartu duzu taila. Saiatu berriz."));
                                } while (!Metodoak.tailaKontrolatu(taila));
                                System.out.print("Sartu kantitatea: ");
                                int kantitatea = Integer.parseInt(br.readLine());

                                PrakaKudeatu.prodSaldu(kodea, taila, kantitatea);
                            }
                            catch (NumberFormatException datuOkerrak) {
                                System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
                            }
                            catch (IOException gaizki) {
                                System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                            }   
                            pausa();
                            break;
                        }     
                    }
                    break;
                } 
          
                default:
                    System.out.println(Metodoak.printGorriz("Zenbaki okerra sartu duzu! Irakurri ondo aukerak eta aukeratu."));
                    pausa();
                    break;
            } 
        } while (aukera!=0);
    }
    
    /* Produktuak kudeatzeko menua */
    public static void prodKudeatuMenua() {
        System.out.print("\n"
                    + "************************************************\n"
                    + "*              PRODUKTUAK KUDEATU              *\n"
                    + "************************************************\n"
                    + "* Zer egin nahi duzu?                          *\n"
                    + "*    0.- Irten                                 *\n"
                    + "*    1.- Produktuak gehitu.                    *\n"
                    + "*    2.- Produktuak ezabatu.                   *\n"
                    + "*    3.- Produktuak erakutsi.                  *\n"
                    + "*    4.- Produktua dendan dagoen kontsultatu.  *\n"
                    + "*    5.- Produktuen inbentarioa.               *\n"
                    + "*    6.- Eskatzeko produktuen zerrenda ikusi.  *\n"
                    + "*    7.- Produktua saldu.                      *\n" // Salmentak
                    + "************************************************\n\n"
                    + "  Aukeratu: ");
    }
    
    /* produktu moten menua */
    public static void produktuMotaMenua() {
        System.out.print(""
                + "*************************\n"
                + "    0.- Irten.\n"
                + "    1.- Jertsea.\n"
                + "    2.- Kamiseta.\n"
                + "    3.- Praka.\n"
                + "*************************\n"
                + "Aukeratu: ");
    }
    
    /* Main-etik deitzen da. Hornitzaileak kudeatzeko funtzioa  */
    public static void horniKudMain() {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        horniKudeatuMenua();
        int aukera = 0;
        try {
            aukera = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        System.out.println();
            
        switch (aukera) {
            //0.- Irten
            case 0:
                System.exit(0);

            // 1.- Hornitzailea gehitu.    
            case 1:
            {
                System.out.print("Hornitzaile berri bat gehitu behar duzu.\n\n");
                HornitzaileaKudeatu.hornitzaileaGehitu();
                pausa();
                break;
            } // case 1-en bukaera
            
            // 2.- Hornitzailea ezabatu.
            case 2:
                try {
                    System.out.print("Sartu hornitzailearen kodea: ");
                    String kodea=br.readLine();
                    HornitzaileaKudeatu.hornitzaileaEzabatu(kodea);
                }
                catch (IOException gaizki) {
                    System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                }
                pausa();
                break;
                
            // 3.- Hornitzaile guztiak erakutsi.
            case 3:
                HornitzaileaKudeatu.hornitzaileGuztiakErakutsi();
                pausa();
                break;
            
            // 4.- Hornitzailearen datuak aldatu.
            case 4:
                try {
                    System.out.print("\nSartu datuak aldatu nahi dituzun hornitzailearen kodea: ");
                    String kodea = br.readLine().toLowerCase();
                    hornitzaileaDatuakAldatuMenua(); // hornitzailearen datuak aukeratzeko menua
                    int atrAuk = Integer.parseInt(br.readLine());
                    HornitzaileaKudeatu.hornitzaileaDatuakAldatu(kodea, atrAuk);
                }
                catch (IOException gaizki) {
                    System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
                }
                break;
                
            default:
                System.out.println(Metodoak.printGorriz("Zenbaki okerra sartu duzu. Saiatu berriro!"));
        }
        
    }
    
    /* Produktuak kudeatzeko menua */
    public static void horniKudeatuMenua() {
        System.out.print("\n"
                    + "************************************************\n"
                    + "*             HORNITZAILEA KUDEATU             *\n"
                    + "************************************************\n"
                    + "* Zer egin nahi duzu?                          *\n"
                    + "*    0.- Irten                                 *\n"
                    + "*    1.- Hornitzailea gehitu.                  *\n"
                    + "*    2.- Hornitzailea ezabatu.                 *\n"
                    + "*    3.- Hornitzaile guztiak erakutsi.         *\n"
                    + "*    4.- Hornitzailearen datuak aldatu.        *\n"
                    + "************************************************\n\n"
                    + "  Aukeratu: ");
    }
    
    /* Hornitzailearen datuak aukeratzeko menua */
    public static void hornitzaileaDatuakAldatuMenua() {
        System.out.print("\n"
                    + "Zein datu aldatu nahi duzu?\n"
                    + "\t1.- Izena.\n"
                    + "\t2.- Herria.\n"
                    + "\t3.- Telefono zenbakia.\n"
                    + "\t4.- Email-a.\n"
                    + "\tBeste EDOZEIN ZENBAKI ezer ez aldatzeko.\n"
                    + "Aukeratu: ");
    }
      
    /* Produktuen eskaerak kudeatzeko funtzioa*/
    public static void eskaeraKudMain() {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        eskaeraKudeatuMenua();
        int aukera = 0;
        try {
            aukera = Integer.parseInt(br.readLine());
        }
        catch (NumberFormatException datuOkerrak) {
            System.out.println(Metodoak.printGorriz("Zenbaki bat sartu behar zenuen."));
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        System.out.println();
            
        switch (aukera) {
            //0.- Irten
            case 0:
                System.exit(0);

            // 1.- Eskaera berri bat gehitu.    
            case 1:
            {
                System.out.print("Eskaera berri bat gehitu behar duzu.\n\n");
                EskaeraKudeatu.eskaeraGehitu();
                pausa();
                break;
            } // case 1-en bukaera
            
            // 2.- Eskaera guztiak erakutsi.
            case 2:
                EskaeraKudeatu.eskaeraGuztiakErakutsi();
                pausa();
                break;
                
            default:
                System.out.println(Metodoak.printGorriz("Zenbaki okerra sartu duzu. Saiatu berriro!"));
        }
    }
    /* Eskaerak kudeatzeko menua */
    public static void eskaeraKudeatuMenua() {
        System.out.print("\n"
                    + "************************************************\n"
                    + "*                ESKAERA KUDEATU               *\n"
                    + "************************************************\n"
                    + "* Zer egin nahi duzu?                          *\n"
                    + "*    0.- Irten                                 *\n"
                    + "*    1.- Eskaera berri bat gehitu.             *\n"
                    + "*    2.- Eskaera guztiak erakutsi.             *\n"
                    + "************************************************\n\n"
                    + "  Aukeratu: ");
    }
}
