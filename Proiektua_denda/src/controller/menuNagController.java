/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.*; // bista guztiak importatu
import gestioa.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class menuNagController implements ActionListener{
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private DendaInfo viewDendaInfo;
    private BezeroaInfo viewBezeroaInfo;
    private LangileaInfo viewLangileaInfo;
    private ProduktuaAukeratu viewProduktuaAukeratu;
    private HornitzaileaInfo viewHornitzaileaInfo;
    private EskaeraInfo viewEskaeraInfo;

    /* ERAIKITZAILEA */   
    public menuNagController(DendaInfo viewDendInfo, BezeroaInfo viewBezInfo, 
            LangileaInfo viewLangInfo,  ProduktuaAukeratu viewProdAuk, 
            HornitzaileaInfo viewHornInfo, EskaeraInfo viewEskInfo, MenuNagusia viewMenuNag) {
        this.viewDendaInfo = viewDendInfo;
        this.viewBezeroaInfo = viewBezInfo;
        this.viewLangileaInfo = viewLangInfo;
        this.viewProduktuaAukeratu = viewProdAuk;
        this.viewHornitzaileaInfo = viewHornInfo;
        this.viewEskaeraInfo = viewEskInfo;
        this.viewMenuNagusia = viewMenuNag;
        menuNagEstiloa();
    }
    
    /* METODOAK */      
    private void menuNagEstiloa() {
        viewMenuNagusia.setTitle("ATENEA");
        viewMenuNagusia.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewMenuNagusia.setLocationRelativeTo(null);
        viewMenuNagusia.jPanelGoiburua.setBackground(new Color(0,0,153));
        viewMenuNagusia.jPanelOina.setBackground(new Color(0,0,153));
        viewMenuNagusia.jPanelGorputza.setBackground(Color.WHITE);
        viewMenuNagusia.jButtonIrten.setBackground(Color.WHITE);
        
        viewMenuNagusia.jButtonDenda.setToolTipText("Denda");
        viewMenuNagusia.jButtonBezeroa.setToolTipText("Bezeroa");
        viewMenuNagusia.jButtonLangilea.setToolTipText("Langilea");
        viewMenuNagusia.jButtonProduktua.setToolTipText("Produktuak");
        viewMenuNagusia.jButtonHornitzailea.setToolTipText("Hornitzailea");
        viewMenuNagusia.jButtonEskaera.setToolTipText("Eskaera");
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* instantzia berriak, bertako metodoak erabiltzeko */
        Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
        dendaInfoController dendInfoCtr = new dendaInfoController();
        bezInfoController bezInfoCtr = new bezInfoController();
        langInfoController langInfoCtr = new langInfoController();
        hornInfoController hornInfoCtr = new hornInfoController();
        eskInfoController eskInfoCtr = new eskInfoController();
        
        /* Menu nagusiko aukerak */
        if (comando == viewMenuNagusia.jButtonIrten) {
            System.exit(0);
        }
        else if (comando == viewMenuNagusia.jButtonDenda) {
            viewDendaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            ctr.enableComponents(viewDendaInfo.jPanelDendDatuak, false);
            dendInfoCtr.dendDatuakErakutsiTaula(viewDendaInfo.jTableDendaInfo, DendaKudeatu.dendGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonProduktua) {
            viewProduktuaAukeratu.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            viewProduktuaAukeratu.jToggleButtonEzkutatu.setSelected(true);
            ctr.enableComponents(viewProduktuaAukeratu.jPanelGoiburua, false);
            ctr.enableComponents(viewProduktuaAukeratu.jPanelAukerak, false);
        }
        else if (comando == viewMenuNagusia.jButtonBezeroa) {
            viewBezeroaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            ctr.enableComponents(viewBezeroaInfo.jPanelBezDatuak, false);
            bezInfoCtr.bezDatuakErakutsiTaula(viewBezeroaInfo.jTableBezeroaInfo, BezeroaKudeatu.bezeroGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonLangilea) {
            viewLangileaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            ctr.enableComponents(viewLangileaInfo.jPanelLangDatuak, false);
            langInfoCtr.langDatuakErakutsiTaula(viewLangileaInfo.jTableLangileaInfo, LangileaKudeatu.langileGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonHornitzailea) {
            viewHornitzaileaInfo.setVisible(true); 
            viewMenuNagusia.setEnabled(false);
            ctr.enableComponents(viewHornitzaileaInfo.jPanelHornDatuak, false);
            hornInfoCtr.hornDatuakErakutsiTaula(viewHornitzaileaInfo.jTableHornitzaileaInfo, HornitzaileaKudeatu.hornitzaileGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonEskaera) {
            viewEskaeraInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            ctr.enableComponents(viewEskaeraInfo.jPanelEskDatuak, false);
            eskInfoCtr.eskDatuakErakutsiTaula(viewEskaeraInfo.jTableEskaeraInfo, EskaeraKudeatu.eskaeraGuztiakErakutsi());
        }
    }
}