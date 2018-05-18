/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*; // model-eko guztia importatu.
import view.*; // bista guztiak importatu
import gestioa.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class Controller implements ActionListener{
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
    private DendaInfo viewDendaInfo;
    private DendaGehitu viewDendaGehitu;
    private BezeroaInfo viewBezeroaInfo;
    private BezeroaGehitu viewBezeroaGehitu;
    private LangileaInfo viewLangileaInfo;
    private LangileaGehitu viewLangileaGehitu;
    private ProduktuaAukeratu viewProduktuaAukeratu;
    private JertseaGehitu viewJertseaGehitu;
    private KamisetaGehitu viewKamisetaGehitu;
    private PrakaGehitu viewPrakaGehitu;
    private HornitzaileaInfo viewHornitzaileaInfo;
    private HornitzaileaGehitu viewHornitzaileaGehitu;
    private EskaeraInfo viewEskaeraInfo;
    private EskaeraGehitu viewEskaeraGehitu;

    /* ERAIKITZAILEA */   
    public Controller(Bezeroa bez, Denda denda, Eskaera esk, Hornitzailea horn, Jertsea jerts,
            Kamiseta kami, Langilea lang, Praka prak, Salmenta salm,
            DendaInfo viewDendInfo, DendaGehitu viewDendGehitu, BezeroaInfo viewBezInfo, BezeroaGehitu viewBezGehitu, 
            LangileaInfo viewLangInfo, LangileaGehitu viewLangGehitu, ProduktuaAukeratu viewProdAuk, 
            JertseaGehitu viewJertsGehitu, KamisetaGehitu viewKamGehitu, PrakaGehitu viewPrakGehitu, 
            HornitzaileaInfo viewHornInfo, HornitzaileaGehitu viewHornGehitu, EskaeraInfo viewEskInfo, 
            EskaeraGehitu viewEskGehitu, MenuNagusia viewMenuNag) {
        this.bezeroa = bez;
        this.denda = denda;
        this.eskaera = esk;
        this.hornitzailea = horn;
        this.jertsea = jerts;
        this.kamiseta = kami;
        this.langilea = lang;
        this.praka = prak;
        this.salmenta = salm;
        
        this.viewDendaInfo = viewDendInfo;
        this.viewDendaGehitu = viewDendGehitu;
        this.viewBezeroaInfo = viewBezInfo;
        this.viewBezeroaGehitu = viewBezGehitu;
        this.viewLangileaInfo = viewLangInfo;
        this.viewLangileaGehitu = viewLangGehitu;
        this.viewProduktuaAukeratu = viewProdAuk;
        this.viewJertseaGehitu = viewJertsGehitu;
        this.viewKamisetaGehitu = viewKamGehitu;
        this.viewPrakaGehitu = viewPrakGehitu;
        this.viewHornitzaileaInfo = viewHornInfo;
        this.viewHornitzaileaGehitu = viewHornGehitu;
        this.viewEskaeraInfo = viewEskInfo;
        this.viewEskaeraGehitu = viewEskGehitu;
        this.viewMenuNagusia = viewMenuNag;
        botoiakEntzuten();
        hasieratu();
        viewMenuNagusia.setVisible(true);
    }
    
    /* METODOAK */
    private void botoiakEntzuten() { 
        dendaInfoController dendInfoCtr = new dendaInfoController(denda, viewDendaInfo, viewDendaGehitu, viewMenuNagusia);
        dendaGehituController dendGehituCtr = new dendaGehituController(denda, viewDendaInfo, viewDendaGehitu, viewMenuNagusia);
        bezInfoController bezInfoCtr = new bezInfoController(bezeroa, viewBezeroaInfo, viewBezeroaGehitu, viewMenuNagusia);
        bezGehituController bezGehituCtr = new bezGehituController(bezeroa, viewBezeroaInfo, viewBezeroaGehitu);
        langInfoController langInfoCtr = new langInfoController(langilea, viewLangileaInfo, viewLangileaGehitu, viewMenuNagusia);
        langGehituController langGehituCtr = new langGehituController(langilea, viewLangileaInfo, viewLangileaGehitu);
        prodAukController prodAukCtr = new prodAukController(jertsea, kamiseta, praka, viewProduktuaAukeratu, viewJertseaGehitu,
            viewKamisetaGehitu, viewPrakaGehitu, viewMenuNagusia);
        jertsGehituController jertsGehituCtr = new jertsGehituController(jertsea, viewProduktuaAukeratu, viewJertseaGehitu);
        kamiGehituController kamiGehituCtr = new kamiGehituController(kamiseta, viewProduktuaAukeratu, viewKamisetaGehitu);
        prakGehituController prakGehituCtr = new prakGehituController(praka, viewProduktuaAukeratu, viewPrakaGehitu);
        hornInfoController hornInfoCtr = new hornInfoController(hornitzailea, viewHornitzaileaInfo, viewHornitzaileaGehitu, viewMenuNagusia);
        hornGehituController hornGehituCtr = new hornGehituController(hornitzailea, viewHornitzaileaInfo, viewHornitzaileaGehitu, viewEskaeraGehitu);
        eskInfoController eskInfoCtr = new eskInfoController(eskaera, viewEskaeraInfo, viewEskaeraGehitu, viewMenuNagusia);
        eskGehituController eskGehituCtr = new eskGehituController(eskaera, viewEskaeraInfo, viewEskaeraGehitu);
        
        /* ActionListeners gehitu */
        viewMenuNagusia.jButtonIrten.addActionListener(this);
        viewDendaInfo.jButtonIrten.addActionListener(dendInfoCtr);
        viewDendaGehitu.jButtonIrten.addActionListener(dendGehituCtr);
        viewBezeroaInfo.jButtonIrten.addActionListener(bezInfoCtr);
        viewBezeroaGehitu.jButtonIrten.addActionListener(bezGehituCtr);
        viewLangileaInfo.jButtonIrten.addActionListener(langInfoCtr);
        viewLangileaGehitu.jButtonIrten.addActionListener(langGehituCtr);
        viewProduktuaAukeratu.jButtonIrten.addActionListener(prodAukCtr);
        viewJertseaGehitu.jButtonIrten.addActionListener(jertsGehituCtr);
        viewKamisetaGehitu.jButtonIrten.addActionListener(kamiGehituCtr);
        viewPrakaGehitu.jButtonIrten.addActionListener(prakGehituCtr);
        viewHornitzaileaInfo.jButtonIrten.addActionListener(hornInfoCtr);
        viewHornitzaileaGehitu.jButtonIrten.addActionListener(hornGehituCtr);
        viewEskaeraInfo.jButtonIrten.addActionListener(eskInfoCtr);
        viewEskaeraGehitu.jButtonIrten.addActionListener(eskGehituCtr);

        // Menu Nagusiko botoiak
        viewMenuNagusia.jButtonBezeroa.addActionListener(this);
        viewMenuNagusia.jButtonDenda.addActionListener(this);
        viewMenuNagusia.jButtonEskaera.addActionListener(this);
        viewMenuNagusia.jButtonHornitzailea.addActionListener(this);
        viewMenuNagusia.jButtonLangilea.addActionListener(this);
        viewMenuNagusia.jButtonProduktua.addActionListener(this);
        
        // DendaInfo-ko botoiak
        viewDendaInfo.jButtonEzabatu.addActionListener(dendInfoCtr);
        viewDendaInfo.jButtonAldatu.addActionListener(dendInfoCtr);
        viewDendaInfo.jButtonGehitu.addActionListener(dendInfoCtr);
        viewDendaInfo.jButtonAldaketaGorde.addActionListener(dendInfoCtr);
        viewDendaInfo.jButtonAldaketaEzabatu.addActionListener(dendInfoCtr);
        
        // DendaGehitu-ko botoiak
        viewDendaGehitu.jButtonReset.addActionListener(dendGehituCtr);
        viewDendaGehitu.jButtonGorde.addActionListener(dendGehituCtr);
        viewDendaGehitu.jButtonBerriaGehitu.addActionListener(dendGehituCtr);        
        
        // BezeroaInfo-ko botoiak
        viewBezeroaInfo.jButtonEzabatu.addActionListener(bezInfoCtr);
        viewBezeroaInfo.jButtonAldatu.addActionListener(bezInfoCtr);
        viewBezeroaInfo.jButtonGehitu.addActionListener(bezInfoCtr);
        viewBezeroaInfo.jButtonAldaketaGorde.addActionListener(bezInfoCtr);
        viewBezeroaInfo.jButtonAldaketaEzabatu.addActionListener(bezInfoCtr);
        
        // BezeroaGehitu-ko botoiak
        viewBezeroaGehitu.jButtonReset.addActionListener(bezGehituCtr);
        viewBezeroaGehitu.jButtonGorde.addActionListener(bezGehituCtr);
        viewBezeroaGehitu.jButtonBerriaGehitu.addActionListener(bezGehituCtr);
        
        // LangileaInfo-ko botoiak
        viewLangileaInfo.jButtonEzabatu.addActionListener(langInfoCtr);
        viewLangileaInfo.jButtonAldatu.addActionListener(langInfoCtr);
        viewLangileaInfo.jButtonGehitu.addActionListener(langInfoCtr);
        viewLangileaInfo.jButtonAldaketaGorde.addActionListener(langInfoCtr);
        viewLangileaInfo.jButtonAldaketaEzabatu.addActionListener(langInfoCtr);
        
        // LangileaGehitu-ko botoiak
        viewLangileaGehitu.jButtonReset.addActionListener(langGehituCtr);
        viewLangileaGehitu.jButtonGorde.addActionListener(langGehituCtr);
        viewLangileaGehitu.jButtonBerriaGehitu.addActionListener(langGehituCtr);
        
        // ProduktuaAukeratu-ko botoiak
        viewProduktuaAukeratu.jButtonGehituJerts.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonEzabatuJerts.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldatuJerts.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuJerts.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaGordeJerts.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonGehituKami.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonEzabatuKami.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldatuKami.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuKami.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaGordeKami.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonGehituPrak.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonEzabatuPrak.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldatuPrak.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuPrak.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaGordePrak.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jToggleButtonErakutsi.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jToggleButtonEzkutatu.addActionListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonBidali.addActionListener(prodAukCtr);
        
        // JertseaGehitu-ko botoiak
        viewJertseaGehitu.jButtonReset.addActionListener(jertsGehituCtr);
        viewJertseaGehitu.jButtonGorde.addActionListener(jertsGehituCtr);
        viewJertseaGehitu.jButtonBerriaGehitu.addActionListener(jertsGehituCtr);
        
        // KamisetaGehitu-ko botoiak
        viewKamisetaGehitu.jButtonReset.addActionListener(kamiGehituCtr);
        viewKamisetaGehitu.jButtonGorde.addActionListener(kamiGehituCtr);
        viewKamisetaGehitu.jButtonBerriaGehitu.addActionListener(kamiGehituCtr);
        
        // PrakaGehitu-ko botoiak
        viewPrakaGehitu.jButtonReset.addActionListener(prakGehituCtr);
        viewPrakaGehitu.jButtonGorde.addActionListener(prakGehituCtr);
        viewPrakaGehitu.jButtonBerriaGehitu.addActionListener(prakGehituCtr);
        
        // HornitzaileaInfo-ko botoiak
        viewHornitzaileaInfo.jButtonEzabatu.addActionListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonAldatu.addActionListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonGehitu.addActionListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonAldaketaGorde.addActionListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonAldaketaEzabatu.addActionListener(hornInfoCtr);
        
        // HornitzaileaGehitu-ko botoik
        viewHornitzaileaGehitu.jButtonReset.addActionListener(hornGehituCtr);
        viewHornitzaileaGehitu.jButtonGorde.addActionListener(hornGehituCtr);
        viewHornitzaileaGehitu.jButtonBerriaGehitu.addActionListener(hornGehituCtr);
        
        // EskaeraInfo-ko botoiak
        viewEskaeraInfo.jButtonEzabatu.addActionListener(eskInfoCtr);
        viewEskaeraInfo.jButtonAldatu.addActionListener(eskInfoCtr);
        viewEskaeraInfo.jButtonGehitu.addActionListener(eskInfoCtr);
        viewEskaeraInfo.jButtonAldaketaGorde.addActionListener(eskInfoCtr);
        viewEskaeraInfo.jButtonAldaketaEzabatu.addActionListener(eskInfoCtr);
        
        // EskaeraGehitu-ko botoiak
        viewEskaeraGehitu.jButtonReset.addActionListener(eskGehituCtr);
        viewEskaeraGehitu.jButtonGorde.addActionListener(eskGehituCtr);
        viewEskaeraGehitu.jButtonBerriaGehitu.addActionListener(eskGehituCtr);
         
        /* AncestorListener */
        viewProduktuaAukeratu.jPanelJerts.addAncestorListener(prodAukCtr);
        viewProduktuaAukeratu.jPanelKami.addAncestorListener(prodAukCtr);
        viewProduktuaAukeratu.jPanelPrak.addAncestorListener(prodAukCtr);
                
        /* MouseListener */
        viewDendaInfo.jButtonIrten.addMouseListener(dendInfoCtr);
        viewDendaGehitu.jButtonIrten.addMouseListener(dendGehituCtr);
        viewBezeroaInfo.jButtonIrten.addMouseListener(bezInfoCtr);
        viewBezeroaGehitu.jButtonIrten.addMouseListener(bezGehituCtr);
        viewLangileaInfo.jButtonIrten.addMouseListener(langInfoCtr);
        viewLangileaGehitu.jButtonIrten.addMouseListener(langGehituCtr);
        viewProduktuaAukeratu.jButtonIrten.addMouseListener(prodAukCtr);
        viewJertseaGehitu.jButtonIrten.addMouseListener(jertsGehituCtr);
        viewKamisetaGehitu.jButtonIrten.addMouseListener(kamiGehituCtr);
        viewPrakaGehitu.jButtonIrten.addMouseListener(prakGehituCtr);
        viewHornitzaileaInfo.jButtonIrten.addMouseListener(hornInfoCtr);
        viewHornitzaileaGehitu.jButtonIrten.addMouseListener(hornGehituCtr);
        viewEskaeraInfo.jButtonIrten.addMouseListener(eskInfoCtr);
        viewEskaeraGehitu.jButtonIrten.addMouseListener(eskGehituCtr);
        
        /* ListSelectionListener */
        viewDendaInfo.jTableDendaInfo.getSelectionModel().addListSelectionListener(dendInfoCtr);
        viewBezeroaInfo.jTableBezeroaInfo.getSelectionModel().addListSelectionListener(bezInfoCtr);
        viewLangileaInfo.jTableLangileaInfo.getSelectionModel().addListSelectionListener(langInfoCtr);
        viewProduktuaAukeratu.jTableJertsInfo.getSelectionModel().addListSelectionListener(prodAukCtr);
        viewProduktuaAukeratu.jTableKamiInfo.getSelectionModel().addListSelectionListener(prodAukCtr);
        viewProduktuaAukeratu.jTablePrakInfo.getSelectionModel().addListSelectionListener(prodAukCtr);
        viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectionModel().addListSelectionListener(hornInfoCtr);
        viewEskaeraInfo.jTableEskaeraInfo.getSelectionModel().addListSelectionListener(eskInfoCtr);
        viewProduktuaAukeratu.jComboBoxAukeratuProd.getModel().addListDataListener(prodAukCtr);

        /* KeyListener */
        viewDendaInfo.jTextFieldBilatu.addKeyListener(dendInfoCtr);
        viewBezeroaInfo.jTextFieldBilatu.addKeyListener(bezInfoCtr);
        viewLangileaInfo.jTextFieldBilatu.addKeyListener(langInfoCtr);
        viewProduktuaAukeratu.jTextFieldBilatuJerts.addKeyListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldBilatuKami.addKeyListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldBilatuPrak.addKeyListener(prodAukCtr);
        viewHornitzaileaInfo.jTextFieldBilatu.addKeyListener(hornInfoCtr);
        viewEskaeraInfo.jTextFieldBilatu.addKeyListener(eskInfoCtr);
        
        /* FocusListener */
        // DendaInfo
        viewDendaInfo.jTextFieldKodeDend.addFocusListener(dendInfoCtr);
        viewDendaInfo.jTextFieldIzena.addFocusListener(dendInfoCtr);
        viewDendaInfo.jTextFieldHelbidea.addFocusListener(dendInfoCtr);
        viewDendaInfo.jTextFieldHerria.addFocusListener(dendInfoCtr);
        viewDendaInfo.jTextFieldPostKod.addFocusListener(dendInfoCtr);
        viewDendaInfo.jTextFieldTlf.addFocusListener(dendInfoCtr);
        viewDendaInfo.jTextFieldEmail.addFocusListener(dendInfoCtr);
        
        // DendaGehitu
        viewDendaGehitu.jTextFieldIzena.addFocusListener(dendGehituCtr);
        viewDendaGehitu.jTextFieldHelbidea.addFocusListener(dendGehituCtr);
        viewDendaGehitu.jTextFieldHerria.addFocusListener(dendGehituCtr);
        viewDendaGehitu.jTextFieldPostKod.addFocusListener(dendGehituCtr);
        viewDendaGehitu.jTextFieldTlf.addFocusListener(dendGehituCtr);
        viewDendaGehitu.jTextFieldEmail.addFocusListener(dendGehituCtr);
        
        // BezeroaInfo
        viewBezeroaInfo.jTextFieldKodeBez.addFocusListener(bezInfoCtr);
        viewBezeroaInfo.jTextFieldIzena.addFocusListener(bezInfoCtr);
        viewBezeroaInfo.jTextFieldAbizena1.addFocusListener(bezInfoCtr);
        viewBezeroaInfo.jTextFieldAbizena2.addFocusListener(bezInfoCtr);
        viewBezeroaInfo.jTextFieldNan.addFocusListener(bezInfoCtr);
//        viewBezeroaInfo.jDateChooserJaioData.addFocusListener(bezInfoCtr);
//        viewBezeroaInfo.jRadioButtonEmak.addFocusListener(bezInfoCtr);
//        viewBezeroaInfo.jRadioButtonGiz.addFocusListener(bezInfoCtr);
        viewBezeroaInfo.jTextFieldHerria.addFocusListener(bezInfoCtr);
        viewBezeroaInfo.jTextFieldTlf.addFocusListener(bezInfoCtr);
        
        // BezeroaGehitu
        viewBezeroaGehitu.jTextFieldIzena.addFocusListener(bezGehituCtr);
        viewBezeroaGehitu.jTextFieldAbizena1.addFocusListener(bezGehituCtr);
        viewBezeroaGehitu.jTextFieldAbizena2.addFocusListener(bezGehituCtr);
        viewBezeroaGehitu.jTextFieldNan.addFocusListener(bezGehituCtr);
//        viewBezeroaGehitu.jDateChooserJaioData.addFocusListener(bezGehituCtr);
//        viewBezeroaGehitu.jRadioButtonEmak.addFocusListener(bezGehituCtr);
//        viewBezeroaGehitu.jRadioButtonGiz.addFocusListener(bezGehituCtr);
        viewBezeroaGehitu.jTextFieldHerria.addFocusListener(bezGehituCtr);
        viewBezeroaGehitu.jTextFieldTlf.addFocusListener(bezGehituCtr);
        
        // LangileaInfo
        viewLangileaInfo.jTextFieldKodeLang.addFocusListener(langInfoCtr);
        viewLangileaInfo.jTextFieldIzena.addFocusListener(langInfoCtr);
        viewLangileaInfo.jTextFieldAbizena1.addFocusListener(langInfoCtr);
        viewLangileaInfo.jTextFieldAbizena2.addFocusListener(langInfoCtr);
        viewLangileaInfo.jTextFieldNan.addFocusListener(langInfoCtr);
//        viewLangileaInfo.jDateChooserJaioData.addFocusListener(langInfoCtr);
        viewLangileaInfo.jRadioButtonEmak.addFocusListener(langInfoCtr);
        viewLangileaInfo.jRadioButtonGiz.addFocusListener(langInfoCtr);
        viewLangileaInfo.jTextFieldHerria.addFocusListener(langInfoCtr);
        viewLangileaInfo.jTextFieldTlf.addFocusListener(langInfoCtr);
        viewLangileaInfo.jTextFieldSoldata.addFocusListener(langInfoCtr);
        viewLangileaInfo.jComboBoxEremua.addFocusListener(langInfoCtr);
        
        // LangileaGehitu
        viewLangileaGehitu.jTextFieldIzena.addFocusListener(langGehituCtr);
        viewLangileaGehitu.jTextFieldAbizena1.addFocusListener(langGehituCtr);
        viewLangileaGehitu.jTextFieldAbizena2.addFocusListener(langGehituCtr);
        viewLangileaGehitu.jTextFieldNan.addFocusListener(langGehituCtr);
//        viewLangileaGehitu.jDateChooserJaioData.addFocusListener(langGehituCtr);
//        viewLangileaGehitu.jRadioButtonEmak.addFocusListener(langGehituCtr);
//        viewLangileaGehitu.jRadioButtonGiz.addFocusListener(langGehituCtr);
        viewLangileaGehitu.jTextFieldHerria.addFocusListener(langGehituCtr);
        viewLangileaGehitu.jTextFieldTlf.addFocusListener(langGehituCtr);
        viewLangileaGehitu.jTextFieldSoldata.addFocusListener(langGehituCtr);
        viewLangileaGehitu.jComboBoxEremua.addFocusListener(langGehituCtr);
        
        // ProduktuaAukeratu
        /* JERTSEA */
        viewProduktuaAukeratu.jTextFieldKodeJerts.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldMarkaJerts.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldPrezioaJerts.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldKoloreaJerts.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxSexuaJerts.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldStockJerts.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxTailaJerts.addFocusListener(prodAukCtr);
        
        /* KAMISETA */
        viewProduktuaAukeratu.jTextFieldKodeKami.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldMarkaKami.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldPrezioaKami.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldKoloreaKami.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxSexuaKami.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldStockKami.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxTailaKami.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxSasoiaKami.addFocusListener(prodAukCtr);
        
        /* PRAKA */
        viewProduktuaAukeratu.jTextFieldKodePrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldMarkaPrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldPrezioaPrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldKoloreaPrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxSexuaPrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldStockPrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxTailaPrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxSasoiaPrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldLuzeeraPrak.addFocusListener(prodAukCtr);
        viewProduktuaAukeratu.jComboBoxMotaPrak.addFocusListener(prodAukCtr);
        
        // JertseaGehitu
        viewJertseaGehitu.jTextFieldKodeJerts.addFocusListener(jertsGehituCtr);
        viewJertseaGehitu.jTextFieldMarka.addFocusListener(jertsGehituCtr);
        viewJertseaGehitu.jTextFieldPrezioa.addFocusListener(jertsGehituCtr);
        viewJertseaGehitu.jTextFieldKolorea.addFocusListener(jertsGehituCtr);
        viewJertseaGehitu.jComboBoxSexua.addFocusListener(jertsGehituCtr);
        viewJertseaGehitu.jTextFieldStock.addFocusListener(jertsGehituCtr);
        viewJertseaGehitu.jComboBoxTaila.addFocusListener(jertsGehituCtr);
        
        // KamisetaGehitu
        viewKamisetaGehitu.jTextFieldKodeKami.addFocusListener(kamiGehituCtr);
        viewKamisetaGehitu.jTextFieldMarka.addFocusListener(kamiGehituCtr);
        viewKamisetaGehitu.jTextFieldPrezioa.addFocusListener(kamiGehituCtr);
        viewKamisetaGehitu.jTextFieldKolorea.addFocusListener(kamiGehituCtr);
        viewKamisetaGehitu.jComboBoxSexua.addFocusListener(kamiGehituCtr);
        viewKamisetaGehitu.jTextFieldStock.addFocusListener(kamiGehituCtr);
        viewKamisetaGehitu.jComboBoxTaila.addFocusListener(kamiGehituCtr);
        viewKamisetaGehitu.jComboBoxSasoia.addFocusListener(kamiGehituCtr);
        
        // PrakaGehitu
        viewPrakaGehitu.jTextFieldKodePrak.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jTextFieldMarka.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jTextFieldPrezioa.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jTextFieldKolorea.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jComboBoxSexua.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jTextFieldStock.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jComboBoxTaila.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jComboBoxSasoia.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jTextFieldLuzeera.addFocusListener(prakGehituCtr);
        viewPrakaGehitu.jComboBoxMota.addFocusListener(prakGehituCtr);
        
        // HornitzaileaInfo
        viewHornitzaileaInfo.jTextFieldKodeHor.addFocusListener(hornInfoCtr);
        viewHornitzaileaInfo.jTextFieldIzena.addFocusListener(hornInfoCtr);
        viewHornitzaileaInfo.jTextFieldHerria.addFocusListener(hornInfoCtr);
        viewHornitzaileaInfo.jTextFieldTlf.addFocusListener(hornInfoCtr);
        viewHornitzaileaInfo.jTextFieldEmail.addFocusListener(hornInfoCtr);
        
        // HornitzaileaGehitu
        viewHornitzaileaGehitu.jTextFieldIzena.addFocusListener(hornGehituCtr);
        viewHornitzaileaGehitu.jTextFieldHerria.addFocusListener(hornGehituCtr);
        viewHornitzaileaGehitu.jTextFieldTlf.addFocusListener(hornGehituCtr);
        viewHornitzaileaGehitu.jTextFieldEmail.addFocusListener(hornGehituCtr);
        
        // EskaeraInfo
        viewEskaeraInfo.jTextFieldKodeEsk.addFocusListener(eskInfoCtr);
        viewEskaeraInfo.jComboBoxHornitzailea.addFocusListener(eskInfoCtr);
        viewEskaeraInfo.jDateChooserData.addFocusListener(eskInfoCtr);
        viewEskaeraInfo.jTextFieldKopurua.addFocusListener(eskInfoCtr);
        
        // EskaeraGehitu
        viewEskaeraGehitu.jTextFieldKopurua.addFocusListener(eskGehituCtr);
        viewEskaeraGehitu.jComboBoxHornitzailea.addFocusListener(eskGehituCtr);
    }
    
    private void hasieratu() {
        /* BISTEN ESTILOA */
        menuNagEstiloa();
        
        /* Bista guztietako ComboBox-ak kargatu */
        langEremuaKargatu(viewLangileaInfo.jComboBoxEremua);
        langEremuaKargatu(viewLangileaGehitu.jComboBoxEremua);
        hornitzaileaKargatu(viewEskaeraInfo.jComboBoxHornitzailea);
        hornitzaileaKargatu(viewEskaeraGehitu.jComboBoxHornitzailea);
        sexuaKargatu(viewProduktuaAukeratu.jComboBoxSexuaJerts);
        sexuaKargatu(viewProduktuaAukeratu.jComboBoxSexuaKami);
        sexuaKargatu(viewProduktuaAukeratu.jComboBoxSexuaPrak);
        tailaKargatuString(viewProduktuaAukeratu.jComboBoxTailaJerts);
        tailaKargatuString(viewProduktuaAukeratu.jComboBoxTailaKami);
        tailaKargatuInt(viewProduktuaAukeratu.jComboBoxTailaPrak);
        sasoiaKargatu(viewProduktuaAukeratu.jComboBoxSasoiaKami);
        sasoiaKargatu(viewProduktuaAukeratu.jComboBoxSasoiaPrak);
        motaKargatu(viewProduktuaAukeratu.jComboBoxMotaPrak);
        sexuaKargatu(viewJertseaGehitu.jComboBoxSexua);
        tailaKargatuString(viewJertseaGehitu.jComboBoxTaila);
        sasoiaKargatu(viewKamisetaGehitu.jComboBoxSasoia);
        sexuaKargatu(viewKamisetaGehitu.jComboBoxSexua);
        tailaKargatuString(viewKamisetaGehitu.jComboBoxTaila);
        sasoiaKargatu(viewPrakaGehitu.jComboBoxSasoia);
        sexuaKargatu(viewPrakaGehitu.jComboBoxSexua);
        tailaKargatuInt(viewPrakaGehitu.jComboBoxTaila);
        motaKargatu(viewPrakaGehitu.jComboBoxMota);
        aukKargatu(viewProduktuaAukeratu.jComboBoxAukeratuProd);
    }
    
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

    private void bezDatuakErakutsiTaula(ArrayList<Bezeroa> bezGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewBezeroaInfo.jTableBezeroaInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("IZENA");
        model.addColumn("1.ABIZENA");
        model.addColumn("2.ABIZENA");
        model.addColumn("NAN");
        model.addColumn("JAIOTZE DATA");
        model.addColumn("SEXUA");
        model.addColumn("HERRIA");
        model.addColumn("TELEFONOA");
        
        for (int i=0; i<bezGuzt.size(); i++) {
            Bezeroa bez = bezGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(bez.getKodBez(), i, 0);
            model.setValueAt(bez.getIzena(), i, 1);
            model.setValueAt(bez.getAbizena1(), i, 2);
            model.setValueAt(bez.getAbizena2(), i, 3);
            model.setValueAt(bez.getNan(), i, 4);
            model.setValueAt(bez.getJaiotzeData(), i, 5);
            model.setValueAt(bez.getSexua(), i, 6);
            model.setValueAt(bez.getHerria(), i, 7);
            model.setValueAt(bez.getTelefonoa(), i, 8);
        }
    }
    
    private void dendDatuakErakutsiTaula(ArrayList<Denda> dendGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewDendaInfo.jTableDendaInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("IZENA");
        model.addColumn("HELBIDEA");
        model.addColumn("HERRIA");
        model.addColumn("POSTA KODEA");
        model.addColumn("TELEFONOA");
        model.addColumn("EMAILA");
        
        for (int i=0; i<dendGuzt.size(); i++) {
            Denda dend = dendGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(dend.getKodDend(), i, 0);
            model.setValueAt(dend.getIzena(), i, 1);
            model.setValueAt(dend.getHelbidea(), i, 2);
            model.setValueAt(dend.getHerria(), i, 3);
            model.setValueAt(dend.getKodPostala(), i, 4);
            model.setValueAt(dend.getTelefonoa(), i, 5);
            model.setValueAt(dend.getEmail(), i, 6);
        }
    }

    private void langDatuakErakutsiTaula(ArrayList<Langilea> langGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
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

    private void hornDatuakErakutsiTaula(ArrayList<Hornitzailea> hornGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewHornitzaileaInfo.jTableHornitzaileaInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("IZENA");
        model.addColumn("HERRIA");
        model.addColumn("TELEFONOA");
        model.addColumn("EMAILA");
        
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
    
    private void eskDatuakErakutsiTaula(ArrayList<Eskaera> eskGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewEskaeraInfo.jTableEskaeraInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("HORNITZAILEA");
        model.addColumn("DATA");
        model.addColumn("KOPURUA");
        
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
    
    private void hornitzaileaKargatu(JComboBox comboBox) {
        ArrayList<Hornitzailea> hornGuzt = HornitzaileaKudeatu.hornitzaileGuztiakErakutsi(); // hornitzaile objetua gorde
        ArrayList<String> alHonritzaileIzenak = new ArrayList(); // horn izena bakarrik gordeko da
        for (Hornitzailea horn : hornGuzt) { // izena alHornitzaileIzenak-en gorde
            alHonritzaileIzenak.add(horn.getIzena());
        }
        comboBox.addItem("--- Aukeratu ---");
        for (int i = 0; i < alHonritzaileIzenak.size(); i++) { // izenak comboBox-ean gorde
            comboBox.addItem(alHonritzaileIzenak.get(i));
        }
    }
    
    private void tailaKargatuString(JComboBox comboBox) {
        String[] taila = ProduktuaKudeatu.tailaKontrolatuString();
        comboBox.addItem("--- Aukeratu ---");
        for (String i : taila) {
            comboBox.addItem(i);
        }
    }
    
    private void tailaKargatuInt(JComboBox comboBox) {
        int[] taila = ProduktuaKudeatu.tailaKontrolatuZenb();
        comboBox.addItem("--- Aukeratu ---");
        for (int i : taila) {
            comboBox.addItem(String.valueOf(i));
        }
    }
    
    private void sexuaKargatu(JComboBox comboBox) {
        String[] sexua = ProduktuaKudeatu.sexuaKontrolatu();
        comboBox.addItem("--- Aukeratu ---");
        for (String i : sexua) {
            comboBox.addItem(i);
        }
    }
    
    private void sasoiaKargatu(JComboBox comboBox) {
        String[] sasoia = ProduktuaKudeatu.sasoiaKontrolatu();
        comboBox.addItem("--- Aukeratu ---");
        for (String i : sasoia) {
            comboBox.addItem(i);
        }
    }
    
    private void motaKargatu(JComboBox comboBox) {
        String[] mota = ProduktuaKudeatu.motaKontrolatu();
        comboBox.addItem("--- Aukeratu ---");
        for (String i : mota) {
            comboBox.addItem(i);
        }
    }
    
    private void langEremuaKargatu(JComboBox comboBox) {
        String[] eremua = LangileaKudeatu.langileEremuaKontrolatu();
        comboBox.addItem("--- Aukeratu ---");
        for (String i : eremua) {
            comboBox.addItem(i);
        }
    }
    
    private void aukKargatu(JComboBox comboBox) {
        String[] produktua = {"--- Aukeratu ---", "Koltsultatu", "Inbentarioa", "Eskatzeko dauden produktuak"};
        comboBox.removeAllItems();
        for (String i : produktua) {
            comboBox.addItem(i);
        }
    }
    
    private void enableComponets (Container container, boolean bool) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                component.setEnabled(bool);
            }
        }
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* Menu nagusiko aukerak */
        if (comando == viewMenuNagusia.jButtonIrten) {
            System.exit(0);
        }
        else if (comando == viewMenuNagusia.jButtonDenda) {
            viewDendaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewDendaInfo.jPanelDendDatuak, false);
            dendDatuakErakutsiTaula(DendaKudeatu.dendGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonProduktua) {
            viewProduktuaAukeratu.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            viewProduktuaAukeratu.jToggleButtonEzkutatu.setSelected(true);
            enableComponets(viewProduktuaAukeratu.jPanelGoiburua, false);
            enableComponets(viewProduktuaAukeratu.jPanelAukerak, false);
        }
        else if (comando == viewMenuNagusia.jButtonBezeroa) {
            viewBezeroaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewBezeroaInfo.jPanelBezDatuak, false);
            bezDatuakErakutsiTaula(BezeroaKudeatu.bezeroGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonLangilea) {
            viewLangileaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewLangileaInfo.jPanelLangDatuak, false);
            langDatuakErakutsiTaula(LangileaKudeatu.langileGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonHornitzailea) {
            viewHornitzaileaInfo.setVisible(true); 
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewHornitzaileaInfo.jPanelHornDatuak, false);
            hornDatuakErakutsiTaula(HornitzaileaKudeatu.hornitzaileGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonEskaera) {
            viewEskaeraInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            enableComponets(viewEskaeraInfo.jPanelEskDatuak, false);
            eskDatuakErakutsiTaula(EskaeraKudeatu.eskaeraGuztiakErakutsi());
        }
    }
}