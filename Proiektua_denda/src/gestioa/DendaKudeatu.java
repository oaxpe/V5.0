/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import proiektua_denda.Denda;

/**
 *
 * @author Oihane Axpe
 * @version 3.0
 */
public class DendaKudeatu {
    static Denda denda1 = new Denda(); // Dendaren datuak sortu.
    
    public static void datuakErakutsi() {
        denda1.printDatuak();
    }
    
    public static void datuakAldatu(int datua) {
        switch (datua) {
            case 1:
                denda1.setIzena();
                break;
            case 2:
                denda1.setHelbidea();
                break;
            case 3:
                denda1.setHerria();
                break;
            case 4:
                denda1.setKodPostala(); 
                break;
            case 5:
                denda1.setEmail();
                break;
            case 6:
                denda1.setTelefonoa();
                break;
            default:
                break;
        }
    }
}
