/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestioa.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.*; // model-eko guztia importatu.
import view.*; // bista guztiak importatu
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class Controller implements ActionListener, MouseListener, AncestorListener/*, KeyListener*/ {
    /* Model */
    private Bezeroa bezeroa;
    private Denda denda;
    private Eskaera eskaera;
    private Hornitzailea hornitzailea;
    private Jertsea jertsea;
    private Kamiseta kamiseta;
    private Langilea langilea;
    private Pertsona pertsona;
    private Praka praka;
    private Produktua produktua;
    private Salmenta salmenta;
    
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private BezeroaInfo viewBezeroaInfo;
    private BezeroaGehitu viewBezeroaGehitu;
    private LangileaInfo viewLangileaInfo;
    private LangileaGehitu viewLangileaGehitu;
    private ProduktuaAukeratu viewProduktuaAukeratu;
    private JertseaInfo viewJertseaInfo;
    private JertseaGehitu viewJertseaGehitu;
    private KamisetaInfo viewKamisetaInfo;
    private KamisetaGehitu viewKamisetaGehitu;
    private PrakaInfo viewPrakaInfo;
    private PrakaGehitu viewPrakaGehitu;
    private HornitzaileaInfo viewHornitzaileaInfo;
    private HornitzaileaGehitu viewHornitzaileaGehitu;
    private EskaeraInfo viewEskaeraInfo;
    private EskaeraGehitu viewEskaeraGehitu;
    // falta --> DendaInfo eta DendaGehitu?????
      
    
    /* ERAIKITZAILEA */   
    public Controller(Bezeroa bez, Denda denda, Eskaera esk, Hornitzailea horn, Jertsea jerts,
            Kamiseta kami, Langilea lang, Praka prak, Salmenta salm,
            BezeroaInfo viewBezInfo, BezeroaGehitu viewBezGehitu, LangileaInfo viewLangInfo, LangileaGehitu viewLangGehitu,
            ProduktuaAukeratu viewProdAuk,
            JertseaInfo viewJertsInfo, JertseaGehitu viewJertsGehitu, KamisetaInfo viewKamInfo, KamisetaGehitu viewKamGehitu,
            PrakaInfo viewPrakInfo, PrakaGehitu viewPrakGehitu, HornitzaileaInfo viewHornInfo, HornitzaileaGehitu viewHornGehitu,
            EskaeraInfo viewEskInfo, EskaeraGehitu viewEskGehitu, MenuNagusia viewMenuNag) {
        this.bezeroa = bez;
        this.denda = denda;
        this.eskaera = esk;
        this.hornitzailea = horn;
        this.jertsea = jerts;
        this.kamiseta = kami;
        this.langilea = lang;
        this.praka = prak;
        this.salmenta = salm;
        
        this.viewBezeroaInfo = viewBezInfo;
        this.viewBezeroaGehitu = viewBezGehitu;
        this.viewLangileaInfo = viewLangInfo;
        this.viewLangileaGehitu = viewLangGehitu;
        this.viewProduktuaAukeratu = viewProdAuk;
        this.viewJertseaInfo = viewJertsInfo;
        this.viewJertseaGehitu = viewJertsGehitu;
        this.viewKamisetaInfo = viewKamInfo;
        this.viewKamisetaGehitu = viewKamGehitu;
        this.viewPrakaInfo = viewPrakInfo;
        this.viewPrakaGehitu = viewPrakGehitu;
        this.viewHornitzaileaInfo = viewHornInfo;
        this.viewHornitzaileaGehitu = viewHornGehitu;
        this.viewEskaeraInfo = viewEskInfo;
        this.viewEskaeraGehitu = viewEskGehitu;
        this.viewHornitzaileaGehitu = viewHornGehitu;
        this.viewMenuNagusia = viewMenuNag;
        
        botoiakEntzuten();
        hasieratu();
    }
    
    /* METODOAK */
    public void botoiakEntzuten() {
        /* ActionListeners gehitu */
        viewMenuNagusia.jButtonIrten.addActionListener(this);
        viewBezeroaInfo.jButtonIrten.addActionListener(this);
        viewBezeroaGehitu.jButtonIrten.addActionListener(this);
        viewLangileaInfo.jButtonIrten.addActionListener(this);
        viewLangileaGehitu.jButtonIrten.addActionListener(this);
        viewProduktuaAukeratu.jButtonIrten.addActionListener(this);
//        viewJertseaInfo.jButtonIrten.addActionListener(this);
        viewJertseaGehitu.jButtonIrten.addActionListener(this);
//        viewKamisetaInfo.jButtonIrten.addActionListener(this);
        viewKamisetaGehitu.jButtonIrten.addActionListener(this);
//        viewPrakaInfo.jButtonIrten.addActionListener(this);
        viewPrakaGehitu.jButtonIrten.addActionListener(this);
        viewHornitzaileaInfo.jButtonIrten.addActionListener(this);
        viewHornitzaileaGehitu.jButtonIrten.addActionListener(this);
        viewEskaeraInfo.jButtonIrten.addActionListener(this);
        viewEskaeraGehitu.jButtonIrten.addActionListener(this);

        // Menu Nagusiko botoiak
        viewMenuNagusia.jButtonBezeroa.addActionListener(this);
        viewMenuNagusia.jButtonDenda.addActionListener(this);
        viewMenuNagusia.jButtonEskaera.addActionListener(this);
        viewMenuNagusia.jButtonHornitzailea.addActionListener(this);
        viewMenuNagusia.jButtonLangilea.addActionListener(this);
        viewMenuNagusia.jButtonProduktua.addActionListener(this);
        
        // BezeroaInfo-ko botoiak
        viewBezeroaInfo.jButtonEzabatu.addActionListener(this);
        viewBezeroaInfo.jButtonAldatu.addActionListener(this);
        viewBezeroaInfo.jButtonGehitu.addActionListener(this);
        
        // BezeroaGehitu-ko botoiak
        viewBezeroaGehitu.jButtonReset.addActionListener(this);
        viewBezeroaGehitu.jButtonGorde.addActionListener(this);
        viewBezeroaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
        // LangileaInfo-ko botoiak
        viewLangileaInfo.jButtonEzabatu.addActionListener(this);
        viewLangileaInfo.jButtonAldatu.addActionListener(this);
        viewLangileaInfo.jButtonGehitu.addActionListener(this);
        
        // LangileaGehitu-ko botoiak
        viewLangileaGehitu.jButtonReset.addActionListener(this);
        viewLangileaGehitu.jButtonGorde.addActionListener(this);
        viewLangileaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
        // ProduktuaAukeratu-ko botoiak
        viewProduktuaAukeratu.jButtonGehituJerts.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldatuJerts.addActionListener(this);
        viewProduktuaAukeratu.jButtonEzabatuJerts.addActionListener(this);
        viewProduktuaAukeratu.jButtonGehituKami.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldatuKami.addActionListener(this);
        viewProduktuaAukeratu.jButtonEzabatuKami.addActionListener(this);
        viewProduktuaAukeratu.jButtonGehituPrak.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldatuPrak.addActionListener(this);
        viewProduktuaAukeratu.jButtonEzabatuPrak.addActionListener(this);
        
        // JertseaGehitu-ko botoiak
        viewJertseaGehitu.jButtonReset.addActionListener(this);
        viewJertseaGehitu.jButtonGorde.addActionListener(this);
        viewJertseaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
        // KamisetaGehitu-ko botoiak
        viewKamisetaGehitu.jButtonReset.addActionListener(this);
        viewKamisetaGehitu.jButtonGorde.addActionListener(this);
        viewKamisetaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
        // PrakaGehitu-ko botoiak
        viewPrakaGehitu.jButtonReset.addActionListener(this);
        viewPrakaGehitu.jButtonGorde.addActionListener(this);
        viewPrakaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
        // HornitzaileaInfo-ko botoiak
        viewHornitzaileaInfo.jButtonEzabatu.addActionListener(this);
        viewHornitzaileaInfo.jButtonAldatu.addActionListener(this);
        viewHornitzaileaInfo.jButtonGehitu.addActionListener(this);        
        
        // HornitzaileaGehitu-ko botoik
        viewHornitzaileaGehitu.jButtonReset.addActionListener(this);
        viewHornitzaileaGehitu.jButtonGorde.addActionListener(this);
        viewHornitzaileaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
        // EskaeraInfo-ko botoiak
        viewEskaeraInfo.jButtonEzabatu.addActionListener(this);
        viewEskaeraInfo.jButtonAldatu.addActionListener(this);
        viewEskaeraInfo.jButtonGehitu.addActionListener(this);
        
        // EskaeraGehitu-ko botoiak
        viewEskaeraGehitu.jButtonReset.addActionListener(this);
        viewEskaeraGehitu.jButtonGorde.addActionListener(this);
        viewEskaeraGehitu.jButtonBerriaGehitu.addActionListener(this);
         
        /* AncestorListener */
        viewProduktuaAukeratu.jPanelJerts.addAncestorListener(this);
        viewProduktuaAukeratu.jPanelKami.addAncestorListener(this);
        viewProduktuaAukeratu.jPanelPrak.addAncestorListener(this);
    }
    
    public void hasieratu() {
        viewMenuNagusia.setTitle("Atenea");
        viewMenuNagusia.setVisible(true);
        
        viewMenuNagusia.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewBezeroaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewBezeroaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewLangileaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewLangileaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewJertseaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewJertseaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewKamisetaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewKamisetaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewPrakaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewPrakaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewHornitzaileaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewHornitzaileaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewEskaeraInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewEskaeraGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        // LocationRelativeTo
        viewMenuNagusia.setLocationRelativeTo(null);
        viewBezeroaInfo.setLocationRelativeTo(null);
        viewBezeroaGehitu.setLocationRelativeTo(null);
        viewLangileaInfo.setLocationRelativeTo(null);
        viewLangileaGehitu.setLocationRelativeTo(null);
        viewProduktuaAukeratu.setLocationRelativeTo(null);
        viewJertseaGehitu.setLocationRelativeTo(null);
        viewKamisetaGehitu.setLocationRelativeTo(null);
        viewPrakaGehitu.setLocationRelativeTo(null);
        viewHornitzaileaInfo.setLocationRelativeTo(null);
        viewHornitzaileaGehitu.setLocationRelativeTo(null);
        viewEskaeraInfo.setLocationRelativeTo(null);
        viewEskaeraGehitu.setLocationRelativeTo(null);
        
        viewBezeroaInfo.jButtonAldatu.setEnabled(false);
        viewLangileaInfo.jButtonAldatu.setEnabled(false);
        viewProduktuaAukeratu.jButtonAldatuJerts.setEnabled(false);
        viewProduktuaAukeratu.jButtonAldatuKami.setEnabled(false);
        viewProduktuaAukeratu.jButtonAldatuPrak.setEnabled(false);
        viewHornitzaileaInfo.jButtonAldatu.setEnabled(false);
        viewEskaeraInfo.jButtonAldatu.setEnabled(false); // ez dago eskaerak aldatzeko aukerarik
        viewEskaeraInfo.jButtonEzabatu.setEnabled(false); // ez dago eskaerak ezabatzeko aukerarik
        
        // Bista guztietako ComboBox-ak kargatu.
        langEremuaKargatu();
        hornitzaileaKargatu();
        sexuaKargatuJerts();
        sexuaKargatuKami();
        sexuaKargatuPrak();
        tailaKargatuJerts();
        tailaKargatuKami();
        tailaKargatuPrak();
        sasoiaKargatuKami();
        sasoiaKargatuPrak();
        motaKargatu();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* Menu nagusiko aukerak */
        if (comando == viewMenuNagusia.jButtonIrten) {
            System.exit(0);
        }
        else if (comando == viewMenuNagusia.jButtonDenda) {
            
        }
        else if (comando == viewMenuNagusia.jButtonProduktua) {
            viewProduktuaAukeratu.setVisible(true);
            viewMenuNagusia.setEnabled(false);
        }
        else if (comando == viewMenuNagusia.jButtonBezeroa) {
            viewBezeroaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewBezeroaInfo.jPanelBezDatuak, false);
            bezDatuakErakutsiTaula();
        }
        else if (comando == viewMenuNagusia.jButtonLangilea) {
            viewLangileaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewLangileaInfo.jPanelLangDatuak, false);
            langDatuakErakutsiTaula();
        }
        else if (comando == viewMenuNagusia.jButtonHornitzailea) {
            viewHornitzaileaInfo.setVisible(true); 
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewHornitzaileaInfo.jPanelHornDatuak, false);
            hornDatuakErakutsiTaula();
        }
        else if (comando == viewMenuNagusia.jButtonEskaera) {
            viewEskaeraInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewEskaeraInfo.jPanelEskDatuak, false);
            eskDatuakErakutsiTaula();
        }
        
        /* BezeroaInfo-ko aukerak */
        else if (comando == viewBezeroaInfo.jButtonGehitu) {
            viewBezeroaGehitu.setVisible(true);
            viewBezeroaInfo.setEnabled(false);
            enableComponets(viewBezeroaGehitu.jPanelBezDatuak, false);
        } 
        else if (comando == viewBezeroaInfo.jButtonIrten) {
            viewBezeroaInfo.setVisible(false);
            viewMenuNagusia.setEnabled(true);
//            viewMenuNagusia.setAlwaysOnTop(true);
        }
        else if (comando == viewBezeroaInfo.jButtonEzabatu) {
            int aukLerroa = viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow(); // aukeratutako lerroa
            String nan = (String) viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 3); // aukeratutako bezeroaren nan zenbakia lortu
            BezeroaKudeatu.bezeroaEzabatu(nan);
            bezDatuakErakutsiTaula();
        }
        
        /* BezeroaGehitu-ko aukerak */
        else if (comando == viewBezeroaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewBezeroaGehitu.jPanelBezDatuak, true);
        }
        else if (comando == viewBezeroaGehitu.jButtonGorde) {
            String sexuaRB = ""; // RadioButton-aren balioa gorde
            if (viewBezeroaGehitu.jRadioButtonEmak.isSelected()) {
                sexuaRB = viewBezeroaGehitu.jRadioButtonEmak.getText();
            }
            else if (viewBezeroaGehitu.jRadioButtonGiz.isSelected()) {
                sexuaRB = viewBezeroaGehitu.jRadioButtonGiz.getText();
            }
            Bezeroa bez = new Bezeroa(viewBezeroaGehitu.jTextFieldIzena.getText(), viewBezeroaGehitu.jTextFieldAbizena1.getText(), 
                    viewBezeroaGehitu.jTextFieldAbizena2.getText(), viewBezeroaGehitu.jTextFieldNan.getText(), viewBezeroaGehitu.jTextFieldJaioData.getText(), 
                    sexuaRB, viewBezeroaGehitu.jTextFieldHerria.getText(), viewBezeroaGehitu.jTextFieldTlf.getText());
            BezeroaKudeatu.bezeroaGehitu(bez);
            resetBezeroa();
            enableComponets(viewBezeroaGehitu.jPanelBezDatuak, false);
        }
        else if (comando == viewBezeroaGehitu.jButtonReset) {
            resetBezeroa();
        }
        else if (comando == viewBezeroaGehitu.jButtonIrten) {
            resetBezeroa();
            viewBezeroaGehitu.setVisible(false);
            viewBezeroaInfo.setEnabled(true);
            bezDatuakErakutsiTaula();
        }
        
        /* LangileaInfo-ko aukerak */
        else if (comando == viewLangileaInfo.jButtonGehitu) {
            viewLangileaGehitu.setVisible(true);
            viewLangileaInfo.setEnabled(false);
            enableComponets(viewLangileaGehitu.jPanelLangDatuak, false);
        }
        else if (comando == viewLangileaInfo.jButtonIrten) {
            viewLangileaInfo.setVisible(false);
            viewMenuNagusia.setEnabled(true);
//            viewMenuNagusia.setAlwaysOnTop(true);
        }
        else if (comando == viewLangileaInfo.jButtonEzabatu) {
            int aukLerroa = viewLangileaInfo.jTableLangileaInfo.getSelectedRow(); // aukeratutako lerroa
            String nan = (String) viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako langilearen nan zenbakia lortu
            LangileaKudeatu.langileaEzabatu(nan);
            langDatuakErakutsiTaula();
        }
        
        /* LangileaGehitu-ko aukerak */
        else if (comando == viewLangileaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewLangileaGehitu.jPanelLangDatuak, true);
        }
        else if (comando == viewLangileaGehitu.jButtonGorde) {
            String sexuaRB = ""; // RadioButton-aren balioa gorde
            if (viewLangileaGehitu.jRadioButtonEmak.isSelected()) {
                sexuaRB = viewLangileaGehitu.jRadioButtonEmak.getText();
            }
            else if (viewLangileaGehitu.jRadioButtonGiz.isSelected()) {
                sexuaRB = viewLangileaGehitu.jRadioButtonGiz.getText();
            }

            Langilea lang = new Langilea(viewLangileaGehitu.jTextFieldIzena.getText(), viewLangileaGehitu.jTextFieldAbizena1.getText(), 
                    viewLangileaGehitu.jTextFieldAbizena2.getText(), viewLangileaGehitu.jTextFieldNan.getText(), viewLangileaGehitu.jTextFieldJaioData.getText(), 
                    sexuaRB, viewLangileaGehitu.jTextFieldHerria.getText(), viewLangileaGehitu.jTextFieldTlf.getText(), 
                    Double.parseDouble(viewLangileaGehitu.jTextFieldSoldata.getText()), viewLangileaGehitu.jComboBoxEremua.getSelectedItem().toString());
            LangileaKudeatu.langileaGehitu(lang);
            resetLangilea();
            enableComponets(viewLangileaGehitu.jPanelLangDatuak, false);
        }
        else if (comando == viewLangileaGehitu.jButtonReset) {
            resetLangilea();
        }
        else if (comando == viewLangileaGehitu.jButtonIrten) {
            resetLangilea();
            viewLangileaGehitu.setVisible(false);
            viewLangileaInfo.setEnabled(true);
            langDatuakErakutsiTaula();
        }
        
        /* ProduktuakAukeratu-ko aukerak */
        else if (comando == viewProduktuaAukeratu.jButtonGehituJerts) {
            viewJertseaGehitu.setVisible(true);
            viewProduktuaAukeratu.setEnabled(false);
            enableComponets(viewJertseaGehitu.jPanelJertsDatuak, false);
        }
        else if (comando == viewProduktuaAukeratu.jButtonEzabatuJerts) {
            int aukLerroa = viewProduktuaAukeratu.jTableJertsInfo.getSelectedRow(); // aukeratutako lerroa
            String kodea = (String) viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
            String taila = (String) viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
            JertseaKudeatu.jertseaEzabatu(kodea, taila);
            jertsDatuakErakutsiTaula();
        }
        else if (comando == viewProduktuaAukeratu.jButtonGehituKami) {
            viewKamisetaGehitu.setVisible(true);
            viewProduktuaAukeratu.setEnabled(false);
            enableComponets(viewKamisetaGehitu.jPanelKamiDatuak, false);
        }
        else if (comando == viewProduktuaAukeratu.jButtonEzabatuKami) {
            int aukLerroa = viewProduktuaAukeratu.jTableKamiInfo.getSelectedRow(); // aukeratutako lerroa
            String kodea = (String) viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
            String taila = (String) viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
            KamisetaKudeatu.kamisetaEzabatu(kodea, taila);
            kamiDatuakErakutsiTaula();
        }
        else if (comando == viewProduktuaAukeratu.jButtonGehituPrak) {
            viewPrakaGehitu.setVisible(true);
            viewProduktuaAukeratu.setEnabled(false);
            enableComponets(viewPrakaGehitu.jPanelPrakDatuak, false);
        }
        else if (comando == viewProduktuaAukeratu.jButtonEzabatuPrak) {
            int aukLerroa = viewProduktuaAukeratu.jTablePrakInfo.getSelectedRow(); // aukeratutako lerroa
            String kodea = (String) viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
            int taila = (int) viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
            PrakaKudeatu.prakaEzabatu(kodea, taila);
            prakDatuakErakutsiTaula();
        }
        else if (comando == viewProduktuaAukeratu.jButtonIrten) {
            viewProduktuaAukeratu.setVisible(false);
            viewMenuNagusia.setEnabled(true);
        }
        
        /* JertseaGehitu-ko aukerak */
        else if (comando == viewJertseaGehitu.jButtonBerriaGehitu){
            enableComponets(viewJertseaGehitu.jPanelJertsDatuak, true);
        }
        else if (comando == viewJertseaGehitu.jButtonGorde) {
            Jertsea jerts = new Jertsea(viewJertseaGehitu.jTextFieldKodeJerts.getText(), viewJertseaGehitu.jTextFieldMarka.getText(), 
                    Double.parseDouble(viewJertseaGehitu.jTextFieldPrezioa.getText()), viewJertseaGehitu.jTextFieldKolorea.getText(), 
                    viewJertseaGehitu.jComboBoxSexua.getSelectedItem().toString(), Integer.parseInt(viewJertseaGehitu.jTextFieldStock.getText()),
                    viewJertseaGehitu.jComboBoxTaila.getSelectedItem().toString());
            JertseaKudeatu.jertsGehitu(jerts);
            resetJertsea();
            enableComponets(viewJertseaGehitu.jPanelJertsDatuak, false);
        } 
        else if (comando == viewJertseaGehitu.jButtonReset) {
            resetJertsea();
        }
        else if (comando == viewJertseaGehitu.jButtonIrten) {
            resetJertsea();
            viewJertseaGehitu.setVisible(false);
            viewProduktuaAukeratu.setEnabled(true);
            jertsDatuakErakutsiTaula();
        }
        
        /* KamisetaGehitu-ko aukerak */
        else if (comando == viewKamisetaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewKamisetaGehitu.jPanelKamiDatuak, true);
        }
        else if (comando == viewKamisetaGehitu.jButtonGorde) {
            Kamiseta kami = new Kamiseta (viewKamisetaGehitu.jTextFieldKodeKami.getText(), viewKamisetaGehitu.jTextFieldMarka.getText(), 
                    Double.parseDouble(viewKamisetaGehitu.jTextFieldPrezioa.getText()), viewKamisetaGehitu.jTextFieldKolorea.getText(), 
                    viewKamisetaGehitu.jComboBoxSexua.getSelectedItem().toString(), Integer.parseInt(viewKamisetaGehitu.jTextFieldStock.getText()), 
                    viewKamisetaGehitu.jComboBoxTaila.getSelectedItem().toString(), viewKamisetaGehitu.jComboBoxSasoia.getSelectedItem().toString());
            KamisetaKudeatu.kamisetaGehitu(kami);
            resetKamiseta();
            enableComponets(viewKamisetaGehitu.jPanelKamiDatuak, false);
        }
        else if (comando == viewKamisetaGehitu.jButtonReset) {
            resetKamiseta();
        }
        else if (comando == viewKamisetaGehitu.jButtonIrten) {
            resetKamiseta();
            viewKamisetaGehitu.setVisible(false);
            viewProduktuaAukeratu.setEnabled(true);
            kamiDatuakErakutsiTaula();
        }
        
        /* PrakaGehitu-ko aukerak */
        else if (comando == viewPrakaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewPrakaGehitu.jPanelPrakDatuak, true);
        }
        else if (comando == viewPrakaGehitu.jButtonGorde) {
            Praka prak = new Praka (viewPrakaGehitu.jTextFieldKodePrak.getText(), viewPrakaGehitu.jTextFieldMarka.getText(), 
                    Double.parseDouble(viewPrakaGehitu.jTextFieldPrezioa.getText()), viewPrakaGehitu.jTextFieldKolorea.getText(), 
                    viewPrakaGehitu.jComboBoxSexua.getSelectedItem().toString(), Integer.parseInt(viewPrakaGehitu.jTextFieldStock.getText()), 
                    Integer.parseInt(viewPrakaGehitu.jComboBoxTaila.getSelectedItem().toString()), viewPrakaGehitu.jComboBoxSasoia.getSelectedItem().toString(), 
                    Integer.parseInt(viewPrakaGehitu.jTextFieldLuzeera.getText()), viewPrakaGehitu.jComboBoxMota.getSelectedItem().toString());
            PrakaKudeatu.prakaGehitu(prak);
            resetPraka();
            enableComponets(viewPrakaGehitu.jPanelPrakDatuak, false);
        }
        else if (comando == viewPrakaGehitu.jButtonReset) {
            resetPraka();
        }
        else if (comando == viewPrakaGehitu.jButtonIrten) {
            resetPraka();
            viewPrakaGehitu.setVisible(false);
            viewProduktuaAukeratu.setEnabled(true);
            prakDatuakErakutsiTaula();
        }
        
        /* HornitzaileaInfo-ko aukerak */
        else if (comando == viewHornitzaileaInfo.jButtonGehitu) {
            viewHornitzaileaGehitu.setVisible(true);
            viewHornitzaileaInfo.setEnabled(false);
            enableComponets(viewHornitzaileaGehitu.jPanelHornDatuak, false);
        }
        else if (comando == viewHornitzaileaInfo.jButtonIrten) {
            viewHornitzaileaInfo.setVisible(false);
            viewMenuNagusia.setEnabled(true);
        } 
        else if (comando == viewHornitzaileaInfo.jButtonEzabatu) {
            int aukLerroa = viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectedRow(); // aukeratutako lerroa
            String kodea = (String) viewHornitzaileaInfo.jTableHornitzaileaInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako langilearen nan zenbakia lortu
            HornitzaileaKudeatu.hornitzaileaEzabatu(kodea);
            hornDatuakErakutsiTaula();
        }
        
        /* HornitzaileaGehituko aukerak */
        else if (comando == viewHornitzaileaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewHornitzaileaGehitu.jPanelHornDatuak, true);
        }
        else if (comando == viewHornitzaileaGehitu.jButtonGorde) {
            Hornitzailea horn = new Hornitzailea(viewHornitzaileaGehitu.jTextFieldIzena.getText(), viewHornitzaileaGehitu.jTextFieldHerria.getText(),
                    viewHornitzaileaGehitu.jTextFieldTlf.getText(), viewHornitzaileaGehitu.jTextFieldEmail.getText());
            HornitzaileaKudeatu.hornitzaileaGehitu(horn);
            resetHornitzailea();
            enableComponets(viewHornitzaileaGehitu.jPanelHornDatuak, false);
        }
        else if (comando == viewHornitzaileaGehitu.jButtonReset) {
            resetHornitzailea();
        }
        else if (comando == viewHornitzaileaGehitu.jButtonIrten) {
            resetHornitzailea();
            viewHornitzaileaGehitu.setVisible(false);
            viewHornitzaileaInfo.setEnabled(true);
            hornDatuakErakutsiTaula();
        }
        
        /* EskaeraInfo-ko aukerak */
        else if (comando == viewEskaeraInfo.jButtonGehitu) {
            viewEskaeraGehitu.setVisible(true);
            viewEskaeraInfo.setEnabled(false);
            enableComponets(viewEskaeraGehitu.jPanelEskDatuak, false);
        }
        else if (comando == viewEskaeraInfo.jButtonIrten) {
            viewEskaeraInfo.setVisible(false);
            viewMenuNagusia.setEnabled(true);
//            viewMenuNagusia.setAlwaysOnTop(true);
        }
        
        /* EskaeraGehitu-ko aukerak */
        else if (comando == viewEskaeraGehitu.jButtonBerriaGehitu) {
            enableComponets(viewEskaeraGehitu.jPanelEskDatuak, true);
        }
        else if (comando == viewEskaeraGehitu.jButtonGorde){
            Eskaera esk = new Eskaera (viewEskaeraGehitu.jComboBoxHornitzailea.getSelectedItem().toString(), 
                    Integer.parseInt(viewEskaeraGehitu.jTextFieldKopurua.getText()));
            EskaeraKudeatu.eskaeraGehitu(esk);
            resetEskaera();
            enableComponets(viewEskaeraGehitu.jPanelEskDatuak, false);
        }
        else if (comando == viewEskaeraGehitu.jButtonReset){
            resetEskaera();
        }
        else if (comando == viewEskaeraGehitu.jButtonIrten) {
            resetEskaera();
            viewEskaeraGehitu.setVisible(false);
            viewEskaeraInfo.setEnabled(true);
            eskDatuakErakutsiTaula();
        }
    }

    
    @Override
    public void ancestorAdded(AncestorEvent event) {
        Object comando = event.getSource();
        if (comando == viewProduktuaAukeratu.jPanelJerts) {
            enableComponets(viewProduktuaAukeratu.jPanelJertsInfo, false);
            jertsDatuakErakutsiTaula();
        }
        else if (comando == viewProduktuaAukeratu.jPanelKami) {
            enableComponets(viewProduktuaAukeratu.jPanelKamiInfo, false);
            kamiDatuakErakutsiTaula();
        }
        else if (comando == viewProduktuaAukeratu.jPanelPrak) {
            enableComponets(viewProduktuaAukeratu.jPanelPrakInfo, false);
            prakDatuakErakutsiTaula();
        }
    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {
        
    }

    @Override
    public void ancestorMoved(AncestorEvent event) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object mouseSource = me.getSource(); 
    } 

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    /* METODOAK */
    public void bezDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        viewBezeroaInfo.jTableBezeroaInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Izena");
        model.addColumn("Abizenak");
        model.addColumn("NAN");
        model.addColumn("Jaiotze data");
        model.addColumn("Sexua");
        model.addColumn("Herria");
        model.addColumn("Telefonoa");
        ArrayList<Bezeroa> bezGuzt = BezeroaKudeatu.bezeroGuztiakErakutsi();
        
        for (int i=0; i<bezGuzt.size(); i++) {
            Bezeroa bez = bezGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(bez.getKodBez(), i, 0);
            model.setValueAt(bez.getIzena(), i, 1);
            model.setValueAt(bez.getAbizena1().concat(" ").concat(bez.getAbizena2()), i, 2);
            model.setValueAt(bez.getNan(), i, 3);
            model.setValueAt(bez.getJaiotzeData(), i, 4);
            model.setValueAt(bez.getSexua(), i, 5);
            model.setValueAt(bez.getHerria(), i, 6);
            model.setValueAt(bez.getTelefonoa(), i, 7);
        }
    }

    public void langDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        viewLangileaInfo.jTableLangileaInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Izena");
        model.addColumn("1.abizena");
        model.addColumn("2.abizena");
        model.addColumn("NAN");
        model.addColumn("Jaiotze data");
        model.addColumn("Sexua");
        model.addColumn("Herria");
        model.addColumn("Telefono");
        model.addColumn("Soldata");
        model.addColumn("Eremua");
        ArrayList<Langilea> langGuzt = LangileaKudeatu.langileGuztiakErakutsi();
        
        for (int i=0; i<langGuzt.size(); i++) {
            Langilea lang = langGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(lang.getKodLan(), i, 0);
            model.setValueAt(lang.getIzena(), i, 1);
            model.setValueAt(lang.getAbizena1(), i, 2);
            model.setValueAt(lang.getAbizena2(), i, 3);
            model.setValueAt(lang.getNan(), i, 4);
            model.setValueAt(lang.getJaiotzeData(), i, 5);
            model.setValueAt(lang.getSexua(), i, 6);
            model.setValueAt(lang.getHerria(), i, 7);
            model.setValueAt(lang.getTelefonoa(), i, 8);
            model.setValueAt(lang.getSoldata(), i, 9);
            model.setValueAt(lang.getEremua(), i, 10);
        }
    }
    
    public void jertsDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        viewProduktuaAukeratu.jTableJertsInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Marka");
        model.addColumn("Prezioa");
        model.addColumn("Kolorea");
        model.addColumn("Sexua");
        model.addColumn("Stock kantitatea");
        model.addColumn("Taila");
        ArrayList<Jertsea> jertsGuzt = JertseaKudeatu.jertsGuztErakutsi();
        
        for (int i=0; i<jertsGuzt.size(); i++) {
            Jertsea jerts = jertsGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(jerts.getKodPro(), i, 0);
            model.setValueAt(jerts.getMarka(), i, 1);
            model.setValueAt(jerts.getPrezioa(), i, 2);
            model.setValueAt(jerts.getKolorea(), i, 3);
            model.setValueAt(jerts.getSexua(), i, 4);
            model.setValueAt(jerts.getKantStock(), i, 5);
            model.setValueAt(jerts.getTaila(), i, 6);
        }
    }
    
    public void kamiDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        viewProduktuaAukeratu.jTableKamiInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Marka");
        model.addColumn("Prezioa");
        model.addColumn("Kolorea");
        model.addColumn("Sexua");
        model.addColumn("Stock kantitatea");
        model.addColumn("Taila");
        model.addColumn("Sasoia");
        ArrayList<Kamiseta> kamiGuzt = KamisetaKudeatu.kamisetaGuztErakutsi();
        
        for (int i=0; i<kamiGuzt.size(); i++) {
            Kamiseta kami = kamiGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(kami.getKodPro(), i, 0);
            model.setValueAt(kami.getMarka(), i, 1);
            model.setValueAt(kami.getPrezioa(), i, 2);
            model.setValueAt(kami.getKolorea(), i, 3);
            model.setValueAt(kami.getSexua(), i, 4);
            model.setValueAt(kami.getKantStock(), i, 5);
            model.setValueAt(kami.getTaila(), i, 6);
            model.setValueAt(kami.getSasoia(), i, 7);
        }
    }
    
    public void prakDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        viewProduktuaAukeratu.jTablePrakInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Marka");
        model.addColumn("Prezioa");
        model.addColumn("Kolorea");
        model.addColumn("Sexua");
        model.addColumn("Stock kantitatea");
        model.addColumn("Taila");
        model.addColumn("Sasoia");
        model.addColumn("Luzeera");
        model.addColumn("Mota");
        
        ArrayList<Praka> prakGuzt = PrakaKudeatu.prakaGutztErakutsi();
        
        for (int i=0; i<prakGuzt.size(); i++) {
            Praka prak = prakGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(prak.getKodPro(), i, 0);
            model.setValueAt(prak.getMarka(), i, 1);
            model.setValueAt(prak.getPrezioa(), i, 2);
            model.setValueAt(prak.getKolorea(), i, 3);
            model.setValueAt(prak.getSexua(), i, 4);
            model.setValueAt(prak.getKantStock(), i, 5);
            model.setValueAt(prak.getTaila(), i, 6);
            model.setValueAt(prak.getSasoia(), i, 7);
            model.setValueAt(prak.getLuzeera(), i, 8);
            model.setValueAt(prak.getMota(), i, 9);
        }
    }

    public void hornDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        viewHornitzaileaInfo.jTableHornitzaileaInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Izena");
        model.addColumn("Herria");
        model.addColumn("Telefono");
        model.addColumn("Emaila");
        ArrayList<Hornitzailea> hornGuzt = HornitzaileaKudeatu.hornitzaileGuztiakErakutsi();
        
        for (int i=0; i<hornGuzt.size(); i++) {
            Hornitzailea horn = hornGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(horn.getKodHor(), i, 0);
            model.setValueAt(horn.getIzena(), i, 1);
            model.setValueAt(horn.getHerria(), i, 2);
            model.setValueAt(horn.getTelefonoa(), i, 3);
            model.setValueAt(horn.getEmail(), i, 4);
        }
    }
    
    public void eskDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        viewEskaeraInfo.jTableEskaeraInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Hornitzailea");
        model.addColumn("Data");
        model.addColumn("Kopurua");
        ArrayList<Eskaera> eskGuzt = EskaeraKudeatu.eskaeraGuztiakErakutsi();
        
        for (int i=0; i<eskGuzt.size(); i++) {
            Eskaera esk = eskGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(esk.getEskZenb(), i, 0);
            model.setValueAt(esk.getHornitzailea(), i, 1);
            model.setValueAt(esk.getData(), i, 2);
            model.setValueAt(esk.getKopurua(), i, 3);
        }
    }
    
    public void hornitzaileaKargatu() {
        ArrayList<String> alHornitzaileGuzt = HornitzaileaKudeatu.hornitzaileIzenak();
        for (int i = 0; i < alHornitzaileGuzt.size(); i++) {
            viewEskaeraGehitu.jComboBoxHornitzailea.addItem(alHornitzaileGuzt.get(i));
            System.out.println(alHornitzaileGuzt.get(i));
        }
    }
    
    public void tailaKargatuJerts() {
        String[] taila = ProduktuaKudeatu.tailaKontrolatuString();
        for (String i : taila) {
            viewJertseaGehitu.jComboBoxTaila.addItem(i);
        }
    }
    
    public void tailaKargatuKami() {
        String[] taila = ProduktuaKudeatu.tailaKontrolatuString();
        for (String i : taila) {
            viewKamisetaGehitu.jComboBoxTaila.addItem(i);
        }
    }
    
    public void tailaKargatuPrak() {
        int[] taila = ProduktuaKudeatu.tailaKontrolatuZenb();
        for (int i : taila) {
            viewPrakaGehitu.jComboBoxTaila.addItem(String.valueOf(i));
        }
    }
    
    public void sexuaKargatuJerts() {
        String[] sexua = ProduktuaKudeatu.sexuaKontrolatu();
        for (String i : sexua) {
            viewJertseaGehitu.jComboBoxSexua.addItem(i);
        }
    }
    
    public void sexuaKargatuKami() {
        String[] sexua = ProduktuaKudeatu.sexuaKontrolatu();
        for (String i : sexua) {
            viewKamisetaGehitu.jComboBoxSexua.addItem(i);
        }
    }
    
    public void sexuaKargatuPrak() {
        String[] sexua = ProduktuaKudeatu.sexuaKontrolatu();
        for (String i : sexua) {
            viewPrakaGehitu.jComboBoxSexua.addItem(i);
        }
    }
    
    public void sasoiaKargatuKami() {
        String[] sasoia = ProduktuaKudeatu.sasoiaKontrolatu();
        for (String i : sasoia) {
            viewKamisetaGehitu.jComboBoxSasoia.addItem(i);
        }
    }
    
    public void sasoiaKargatuPrak() {
        String[] sasoia = ProduktuaKudeatu.sasoiaKontrolatu();
        for (String i : sasoia) {
            viewPrakaGehitu.jComboBoxSasoia.addItem(i);
        }
    }
    
    public void motaKargatu() {
        String[] mota = ProduktuaKudeatu.motaKontrolatu();
        for (String i : mota) {
            viewPrakaGehitu.jComboBoxMota.addItem(i);
        }
    }
    
    public void langEremuaKargatu() {
        String[] eremua = LangileaKudeatu.langileEremuaKontrolatu();
        for (String i : eremua) {
            viewLangileaGehitu.jComboBoxEremua.addItem(i);
        }
    }
    
    public void resetBezeroa() {
        viewBezeroaGehitu.jTextFieldIzena.setText(null);
        viewBezeroaGehitu.jTextFieldAbizena1.setText(null);
        viewBezeroaGehitu.jTextFieldAbizena2.setText(null);
        viewBezeroaGehitu.jTextFieldNan.setText(null);
        viewBezeroaGehitu.jTextFieldJaioData.setText(null);
        viewBezeroaGehitu.jRadioButtonEmak.setSelected(false);
        viewBezeroaGehitu.jRadioButtonGiz.setSelected(false);
        viewBezeroaGehitu.jTextFieldHerria.setText(null);
        viewBezeroaGehitu.jTextFieldTlf.setText(null);
    }
    
    private void resetLangilea() {
        viewLangileaGehitu.jTextFieldIzena.setText(null);
        viewLangileaGehitu.jTextFieldAbizena1.setText(null);
        viewLangileaGehitu.jTextFieldAbizena2.setText(null);
        viewLangileaGehitu.jTextFieldNan.setText(null);
        viewLangileaGehitu.jTextFieldJaioData.setText(null);
        viewLangileaGehitu.jRadioButtonEmak.setSelected(false);
        viewLangileaGehitu.jRadioButtonGiz.setSelected(false);
        viewLangileaGehitu.jTextFieldHerria.setText(null);
        viewLangileaGehitu.jTextFieldTlf.setText(null);
        viewLangileaGehitu.jTextFieldSoldata.setText(null);
        viewLangileaGehitu.jComboBoxEremua.setSelectedIndex(0);
    }
    
    private void resetJertsea() {
        viewJertseaGehitu.jTextFieldKodeJerts.setText(null);
        viewJertseaGehitu.jTextFieldMarka.setText(null);
        viewJertseaGehitu.jTextFieldPrezioa.setText(null);
        viewJertseaGehitu.jTextFieldKolorea.setText(null);
        viewJertseaGehitu.jComboBoxSexua.setSelectedIndex(0);
        viewJertseaGehitu.jTextFieldStock.setText(null);
        viewJertseaGehitu.jComboBoxTaila.setSelectedIndex(0);
    }
    
    private void resetKamiseta() {
        viewKamisetaGehitu.jTextFieldKodeKami.setText(null);
        viewKamisetaGehitu.jTextFieldMarka.setText(null);
        viewKamisetaGehitu.jTextFieldPrezioa.setText(null);
        viewKamisetaGehitu.jTextFieldKolorea.setText(null);
        viewKamisetaGehitu.jComboBoxSexua.setSelectedIndex(0);
        viewKamisetaGehitu.jTextFieldStock.setText(null);
        viewKamisetaGehitu.jComboBoxTaila.setSelectedIndex(0);
        viewKamisetaGehitu.jComboBoxSasoia.setSelectedIndex(0);
    }
    
    private void resetPraka() {
        viewPrakaGehitu.jTextFieldKodePrak.setText(null);
        viewPrakaGehitu.jTextFieldMarka.setText(null);
        viewPrakaGehitu.jTextFieldPrezioa.setText(null);
        viewPrakaGehitu.jTextFieldKolorea.setText(null);
        viewPrakaGehitu.jComboBoxSexua.setSelectedIndex(0);
        viewPrakaGehitu.jTextFieldStock.setText(null);
        viewPrakaGehitu.jComboBoxTaila.setSelectedIndex(0);
        viewPrakaGehitu.jComboBoxSasoia.setSelectedIndex(0);
        viewPrakaGehitu.jTextFieldLuzeera.setText(null);
        viewPrakaGehitu.jComboBoxMota.setSelectedIndex(0);
    }
    
    private void resetHornitzailea() {
        viewHornitzaileaGehitu.jTextFieldIzena.setText(null);
        viewHornitzaileaGehitu.jTextFieldHerria.setText(null);
        viewHornitzaileaGehitu.jTextFieldTlf.setText(null);
        viewHornitzaileaGehitu.jTextFieldEmail.setText(null);
    }
    
    private void resetEskaera() {
        viewEskaeraGehitu.jComboBoxHornitzailea.setSelectedIndex(0);
        viewEskaeraGehitu.jTextFieldKopurua.setText(null);
    }
    
    public void enableComponets (Container container, boolean bool) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(bool);
        }
    }
    
    public void a() {
        int aukLerroa = viewLangileaInfo.jTableLangileaInfo.getSelectedRow(); // aukeratutako lerroa
        
        viewLangileaInfo.jTextFieldKodeLang.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 0)));
        viewLangileaInfo.jTextFieldIzena.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 1)));
        viewLangileaInfo.jTextFieldAbizena1.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 2)));
        viewLangileaInfo.jTextFieldAbizena2.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 3)));
        viewLangileaInfo.jTextFieldNan.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 4)));
        viewLangileaInfo.jTextFieldJaioData.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 5)));
        String aukSexuaRB = String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 6)).toLowerCase();
        if (aukSexuaRB.equals("emakumea")) {
            viewLangileaInfo.jRadioButtonEmak.setSelected(true);
        }
        else {
            viewLangileaInfo.jRadioButtonGiz.setSelected(true);
        }
        viewLangileaInfo.jTextFieldHerria.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 7)));
        viewLangileaInfo.jTextFieldTlf.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 8)));
        viewLangileaInfo.jTextFieldSoldata.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 9)));
        viewLangileaInfo.jTextFieldEremua.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 10)));
//        viewLangileaInfo.jTextFieldTlf.setText(nan);
//        viewLangileaInfo.jTextFieldSoldata.setText();
    }
    
//    public static void dataErakutsi() {
//        Calendar c1 = new GregorianCalendar();
//        String egun = Integer.toString(c1.get(Calendar.DATE)); // eguna gorde
//        String hilabete = Integer.toString(c1.get(Calendar.MONTH)+1); // hilabetea gorde
//        String urte = Integer.toString(c1.get(Calendar.YEAR)); // urtea gorde
//        BezeroaInfo.setTextData(Metodoak.dataGorde(urte+"/"+hilabete+"/"+egun));
//    }
}