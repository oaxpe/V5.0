/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioa;

import java.io.IOException;
import proiektua_denda.Denda;

/**
 *
 * @author Oihane Axpe
 * @version 2.0
 */
public class DendaKudeatu {
    static Denda denda1 = new Denda(); // Dendaren datuak sortu.
    
    public static void datuakErakutsi() {
        denda1.printDatuak();
    }
    
    public static void datuakAldatu(int datua) {
        if (datua==1)
            denda1.setIzena();
        else if (datua==2)
            denda1.setHelbidea();
        else if (datua==3)
            denda1.setHerria();
        else if (datua==4)
            denda1.setKodPostala();
        else if (datua==5)
            denda1.setEmail(); 
        else if (datua==6)
            denda1.setTelefonoa(); 
    }
}
