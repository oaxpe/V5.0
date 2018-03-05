/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiektua_denda;

import gestioa.Metodoak;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static proiektua_denda.LangBezDenKudeatu.langBezDenKudeatu;
import static proiektua_denda.prodKudMain.horniKudMain;
import static proiektua_denda.prodKudMain.prodKudMain;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class Proiektua_denda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int aukera = 0;
        
        do {
            menuNagusia();
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

                // 1.- Langileak, bezeroak eta denda kudeatu.
                case 1:
                    langBezDenKudeatu();
                    break;
                    
                // 2.- Produktuak kudeatu.
                case 2:
                    prodKudMain();
                    break;
                    
                case 3:
                    horniKudMain();
                    break;
                
                default:
                    System.out.println(Metodoak.printGorriz("Zenbaki okerra sartu duzu! Irakurri ondo aukerak eta aukeratu."));
                    pausa();
                    break;
            }
        } while (aukera!=0);
        
    }

    // PAUSA bat egiteko funtzioa
    public static void pausa() {
        try {
            System.out.println("\nSakatu 'Enter' jarraitzeko...");
            System.in.read();
        }
        catch (IOException gaizki) {
            System.out.println(Metodoak.printGorriz("Arazoak daude datuak sartzerakoan."));
        }
        
    }
    
    public static void menuNagusia() {
        System.out.print(""
                    + "'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n"
                    + "''                     MENU  NAGUSIA                     ''\n"
                    + "'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n"
                    + "''  Zer egin nahi duzu?                                  ''\n"
                    + "''    1.- Langileak, bezeroak eta denda kudeatu.         ''\n"
                    + "''    2.- Produktuak kudeatu.                            ''\n"
                    + "''    3.- Hornitzaileak kudeatu.                         ''\n"
                    + "'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n\n"
                    + " Aukeratu: ");
    }
    
}



