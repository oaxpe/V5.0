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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class Controller implements ActionListener, MouseListener, AncestorListener, ListSelectionListener, ListDataListener, FocusListener, KeyListener {
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
    
    private Color urdina = new Color(0,0,153);
    
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
        viewProduktuaAukeratu.jButtonIrten.addActionListener(this);
        viewJertseaGehitu.jButtonIrten.addActionListener(this);
        viewKamisetaGehitu.jButtonIrten.addActionListener(this);
        viewPrakaGehitu.jButtonIrten.addActionListener(this);
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
        viewProduktuaAukeratu.jButtonGehituJerts.addActionListener(this);
        viewProduktuaAukeratu.jButtonEzabatuJerts.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldatuJerts.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuJerts.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldaketaGordeJerts.addActionListener(this);
        viewProduktuaAukeratu.jButtonGehituKami.addActionListener(this);
        viewProduktuaAukeratu.jButtonEzabatuKami.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldatuKami.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuKami.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldaketaGordeKami.addActionListener(this);
        viewProduktuaAukeratu.jButtonGehituPrak.addActionListener(this);
        viewProduktuaAukeratu.jButtonEzabatuPrak.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldatuPrak.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuPrak.addActionListener(this);
        viewProduktuaAukeratu.jButtonAldaketaGordePrak.addActionListener(this);
        viewProduktuaAukeratu.jToggleButtonErakutsi.addActionListener(this);
        viewProduktuaAukeratu.jToggleButtonEzkutatu.addActionListener(this);
        viewProduktuaAukeratu.jButtonBidali.addActionListener(this);
        
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
        viewProduktuaAukeratu.jPanelJerts.addAncestorListener(this);
        viewProduktuaAukeratu.jPanelKami.addAncestorListener(this);
        viewProduktuaAukeratu.jPanelPrak.addAncestorListener(this);
                
        /* MouseListener */
        viewDendaInfo.jButtonIrten.addMouseListener(dendInfoCtr);
        viewDendaGehitu.jButtonIrten.addMouseListener(dendGehituCtr);
        viewBezeroaInfo.jButtonIrten.addMouseListener(bezInfoCtr);
        viewBezeroaGehitu.jButtonIrten.addMouseListener(bezGehituCtr);
        viewLangileaInfo.jButtonIrten.addMouseListener(langInfoCtr);
        viewLangileaGehitu.jButtonIrten.addMouseListener(langGehituCtr);
        viewProduktuaAukeratu.jButtonIrten.addMouseListener(this);
        viewJertseaGehitu.jButtonIrten.addMouseListener(this);
        viewKamisetaGehitu.jButtonIrten.addMouseListener(this);
        viewPrakaGehitu.jButtonIrten.addMouseListener(this);
        viewHornitzaileaInfo.jButtonIrten.addMouseListener(hornInfoCtr);
        viewHornitzaileaGehitu.jButtonIrten.addMouseListener(hornGehituCtr);
        viewEskaeraInfo.jButtonIrten.addMouseListener(eskInfoCtr);
        viewEskaeraGehitu.jButtonIrten.addMouseListener(eskGehituCtr);
        
        /* ListSelectionListener */
        viewDendaInfo.jTableDendaInfo.getSelectionModel().addListSelectionListener(dendInfoCtr);
        viewBezeroaInfo.jTableBezeroaInfo.getSelectionModel().addListSelectionListener(bezInfoCtr);
        viewLangileaInfo.jTableLangileaInfo.getSelectionModel().addListSelectionListener(langInfoCtr);
        viewProduktuaAukeratu.jTableJertsInfo.getSelectionModel().addListSelectionListener(this);
        viewProduktuaAukeratu.jTableKamiInfo.getSelectionModel().addListSelectionListener(this);
        viewProduktuaAukeratu.jTablePrakInfo.getSelectionModel().addListSelectionListener(this);
        viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectionModel().addListSelectionListener(hornInfoCtr);
        viewEskaeraInfo.jTableEskaeraInfo.getSelectionModel().addListSelectionListener(eskInfoCtr);
        viewProduktuaAukeratu.jComboBoxAukeratuProd.getModel().addListDataListener(this);

        /* KeyListener */
        viewDendaInfo.jTextFieldBilatu.addKeyListener(dendInfoCtr);
        viewBezeroaInfo.jTextFieldBilatu.addKeyListener(bezInfoCtr);
        viewLangileaInfo.jTextFieldBilatu.addKeyListener(langInfoCtr);
        viewProduktuaAukeratu.jTextFieldBilatuJerts.addKeyListener(this);
        viewProduktuaAukeratu.jTextFieldBilatuKami.addKeyListener(this);
        viewProduktuaAukeratu.jTextFieldBilatuPrak.addKeyListener(this);
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
        viewProduktuaAukeratu.jTextFieldKodeJerts.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldMarkaJerts.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldPrezioaJerts.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldKoloreaJerts.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxSexuaJerts.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldStockJerts.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxTailaJerts.addFocusListener(this);
        
        /* KAMISETA */
        viewProduktuaAukeratu.jTextFieldKodeKami.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldMarkaKami.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldPrezioaKami.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldKoloreaKami.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxSexuaKami.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldStockKami.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxTailaKami.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxSasoiaKami.addFocusListener(this);
        
        /* PRAKA */
        viewProduktuaAukeratu.jTextFieldKodePrak.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldMarkaPrak.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldPrezioaPrak.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldKoloreaPrak.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxSexuaPrak.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldStockPrak.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxTailaPrak.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxSasoiaPrak.addFocusListener(this);
        viewProduktuaAukeratu.jTextFieldLuzeeraPrak.addFocusListener(this);
        viewProduktuaAukeratu.jComboBoxMotaPrak.addFocusListener(this);
        
        // JertseaGehitu
        viewJertseaGehitu.jTextFieldKodeJerts.addFocusListener(this);
        viewJertseaGehitu.jTextFieldMarka.addFocusListener(this);
        viewJertseaGehitu.jTextFieldPrezioa.addFocusListener(this);
        viewJertseaGehitu.jTextFieldKolorea.addFocusListener(this);
        viewJertseaGehitu.jComboBoxSexua.addFocusListener(this);
        viewJertseaGehitu.jTextFieldStock.addFocusListener(this);
        viewJertseaGehitu.jComboBoxTaila.addFocusListener(this);
        
        // KamisetaGehitu
        viewKamisetaGehitu.jTextFieldKodeKami.addFocusListener(this);
        viewKamisetaGehitu.jTextFieldMarka.addFocusListener(this);
        viewKamisetaGehitu.jTextFieldPrezioa.addFocusListener(this);
        viewKamisetaGehitu.jTextFieldKolorea.addFocusListener(this);
        viewKamisetaGehitu.jComboBoxSexua.addFocusListener(this);
        viewKamisetaGehitu.jTextFieldStock.addFocusListener(this);
        viewKamisetaGehitu.jComboBoxTaila.addFocusListener(this);
        viewKamisetaGehitu.jComboBoxSasoia.addFocusListener(this);
        
        // PrakaGehitu
        viewPrakaGehitu.jTextFieldKodePrak.addFocusListener(this);
        viewPrakaGehitu.jTextFieldMarka.addFocusListener(this);
        viewPrakaGehitu.jTextFieldPrezioa.addFocusListener(this);
        viewPrakaGehitu.jTextFieldKolorea.addFocusListener(this);
        viewPrakaGehitu.jComboBoxSexua.addFocusListener(this);
        viewPrakaGehitu.jTextFieldStock.addFocusListener(this);
        viewPrakaGehitu.jComboBoxTaila.addFocusListener(this);
        viewPrakaGehitu.jComboBoxSasoia.addFocusListener(this);
        viewPrakaGehitu.jTextFieldLuzeera.addFocusListener(this);
        viewPrakaGehitu.jComboBoxMota.addFocusListener(this);
        
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
        prodInfoEstiloa();
        jertsGehituEstiloa();
        kamiGehituEstiloa();
        prakGehituEstiloa();
        
        // tauletako estiloa
        viewProduktuaAukeratu.jTableJertsInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTableJertsInfo.setShowHorizontalLines(true);
        viewProduktuaAukeratu.jTableKamiInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTableKamiInfo.setShowHorizontalLines(true);
        viewProduktuaAukeratu.jTablePrakInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTablePrakInfo.setShowHorizontalLines(true);

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
        
        /* Kodeak ezin dira aldatu */
        viewProduktuaAukeratu.jTextFieldKodeJerts.setEditable(false);
        viewProduktuaAukeratu.jTextFieldKodeKami.setEditable(false);
        viewProduktuaAukeratu.jTextFieldKodePrak.setEditable(false);
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

    private void prodInfoEstiloa() {
        viewProduktuaAukeratu.setTitle("Produktuen informazioa");
        viewProduktuaAukeratu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewProduktuaAukeratu.setLocationRelativeTo(null);
        viewProduktuaAukeratu.jTabbedPaneProd.setTabPlacement(JTabbedPane.TOP);
        viewProduktuaAukeratu.jButtonIrten.setBackground(urdina);
        viewProduktuaAukeratu.jButtonIrten.setForeground(Color.WHITE);
        
        /* Jertsea */
        viewProduktuaAukeratu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldMarkaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldPrezioaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldKoloreaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxSexuaJerts.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldStockJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxTailaJerts.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldBilatuJerts.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));

        viewProduktuaAukeratu.jTextFieldKodeJerts.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldKoloreaJerts.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldMarkaJerts.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldPrezioaJerts.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldStockJerts.setOpaque(false);
        
        viewProduktuaAukeratu.jButtonAldaketaEzabatuJerts.setToolTipText("Ezeztatu");
        viewProduktuaAukeratu.jButtonAldaketaGordeJerts.setToolTipText("Gorde");

        /* Kamiseta */
        viewProduktuaAukeratu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldMarkaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldPrezioaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldKoloreaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxSexuaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldStockKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxTailaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jComboBoxSasoiaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldBilatuKami.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewProduktuaAukeratu.jTextFieldKodeKami.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldKoloreaKami.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldMarkaKami.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldPrezioaKami.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldStockKami.setOpaque(false);
        
        viewProduktuaAukeratu.jButtonAldaketaEzabatuKami.setToolTipText("Ezeztatu");
        viewProduktuaAukeratu.jButtonAldaketaGordeKami.setToolTipText("Gorde");
        
        /* Praka */
        viewProduktuaAukeratu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldMarkaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldPrezioaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldKoloreaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxSexuaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldStockPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxTailaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jComboBoxSasoiaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldLuzeeraPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxMotaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldBilatuPrak.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewProduktuaAukeratu.jTextFieldKodePrak.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldKoloreaPrak.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldMarkaPrak.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldPrezioaPrak.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldStockPrak.setOpaque(false);
        viewProduktuaAukeratu.jTextFieldLuzeeraPrak.setOpaque(false);
        
        viewProduktuaAukeratu.jButtonAldaketaEzabatuPrak.setToolTipText("Ezeztatu");
        viewProduktuaAukeratu.jButtonAldaketaGordePrak.setToolTipText("Gorde");

        /* Aukerak */
        viewProduktuaAukeratu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jToggleButtonEzkutatu.setSelected(true);
        viewProduktuaAukeratu.jTextFieldKodeProd.setOpaque(false);
        viewProduktuaAukeratu.jRadioButtonJertsea.setOpaque(false);
        viewProduktuaAukeratu.jRadioButtonKamiseta.setOpaque(false);
        viewProduktuaAukeratu.jRadioButtonPraka.setOpaque(false);
        
        /* Fondo txuria jarri */
        viewProduktuaAukeratu.jPanelOsoa.setBackground(Color.WHITE);
        viewProduktuaAukeratu.jPanelGoiburua.setOpaque(false);
        viewProduktuaAukeratu.jPanelAukerak.setOpaque(false);
        viewProduktuaAukeratu.jTabbedPaneProd.setOpaque(false);
        viewProduktuaAukeratu.jPanelJerts.setBackground(Color.WHITE);
        viewProduktuaAukeratu.jPanelJertsGoiburua.setOpaque(false);
        viewProduktuaAukeratu.jPanelJertsGorp.setOpaque(false);
        viewProduktuaAukeratu.jPanelJertsInfo.setOpaque(false);
        viewProduktuaAukeratu.jPanelJertsInfoTaula.setOpaque(false);
        viewProduktuaAukeratu.jPanelJertsBotoiak.setOpaque(false);
        viewProduktuaAukeratu.jPanelKami.setBackground(Color.WHITE);
        viewProduktuaAukeratu.jPanelKamiGoiburua.setOpaque(false);
        viewProduktuaAukeratu.jPanelKamiGorp.setOpaque(false);
        viewProduktuaAukeratu.jPanelKamiInfo.setOpaque(false);
        viewProduktuaAukeratu.jPanelKamiInfoTaula.setOpaque(false);
        viewProduktuaAukeratu.jPanelKamiBotoiak.setOpaque(false);
        viewProduktuaAukeratu.jPanelPrak.setBackground(Color.WHITE);
        viewProduktuaAukeratu.jPanelPrakGoiburua.setOpaque(false);
        viewProduktuaAukeratu.jPanelPrakGorp.setOpaque(false);
        viewProduktuaAukeratu.jPanelPrakInfo.setOpaque(false);
        viewProduktuaAukeratu.jPanelPrakInfoTaula.setOpaque(false);
        viewProduktuaAukeratu.jPanelPrakBotoiak.setOpaque(false); 
    }
    
    private void jertsGehituEstiloa() {
        viewJertseaGehitu.setTitle("Jertse berria");
        viewJertseaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewJertseaGehitu.setLocationRelativeTo(null);
        viewJertseaGehitu.jButtonIrten.setBackground(urdina);
        viewJertseaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        viewJertseaGehitu.jTextFieldKodeJerts.setOpaque(false);
        viewJertseaGehitu.jTextFieldMarka.setOpaque(false);
        viewJertseaGehitu.jTextFieldPrezioa.setOpaque(false);
        viewJertseaGehitu.jTextFieldKolorea.setOpaque(false);
        viewJertseaGehitu.jTextFieldStock.setOpaque(false);
        viewJertseaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewJertseaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewJertseaGehitu.jPanelGoiburua.setOpaque(false);
        viewJertseaGehitu.jPanelJertsDatuak.setOpaque(false);
    }
    
    private void kamiGehituEstiloa() {
        viewKamisetaGehitu.setTitle("Kamiseta berria");
        viewKamisetaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewKamisetaGehitu.setLocationRelativeTo(null);
        viewKamisetaGehitu.jButtonIrten.setBackground(urdina);
        viewKamisetaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        viewKamisetaGehitu.jTextFieldKodeKami.setOpaque(false);
        viewKamisetaGehitu.jTextFieldMarka.setOpaque(false);
        viewKamisetaGehitu.jTextFieldPrezioa.setOpaque(false);
        viewKamisetaGehitu.jTextFieldKolorea.setOpaque(false);
        viewKamisetaGehitu.jTextFieldStock.setOpaque(false);
        viewKamisetaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewKamisetaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewKamisetaGehitu.jPanelGoiburua.setOpaque(false);
        viewKamisetaGehitu.jPanelKamiDatuak.setOpaque(false);
    }
    
    private void prakGehituEstiloa() {
        viewPrakaGehitu.setTitle("Praka berria");
        viewPrakaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewPrakaGehitu.setLocationRelativeTo(null);
        viewPrakaGehitu.jButtonIrten.setBackground(urdina);
        viewPrakaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewPrakaGehitu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewPrakaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewPrakaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewPrakaGehitu.jTextFieldLuzeera.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jComboBoxMota.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        viewPrakaGehitu.jTextFieldKodePrak.setOpaque(false);
        viewPrakaGehitu.jTextFieldMarka.setOpaque(false);
        viewPrakaGehitu.jTextFieldPrezioa.setOpaque(false);
        viewPrakaGehitu.jTextFieldKolorea.setOpaque(false);
        viewPrakaGehitu.jTextFieldStock.setOpaque(false);
        viewPrakaGehitu.jTextFieldLuzeera.setOpaque(false);
        viewPrakaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewPrakaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewPrakaGehitu.jPanelGoiburua.setOpaque(false);
        viewPrakaGehitu.jPanelPrakDatuak.setOpaque(false);
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
    
    private void jertsDatuakErakutsiTaula(ArrayList<Jertsea> jertsGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewProduktuaAukeratu.jTableJertsInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("MARKA");
        model.addColumn("PREZIOA");
        model.addColumn("KOLOREA");
        model.addColumn("SEXUA");
        model.addColumn("STOCK kantitatea");
        model.addColumn("TAILA");
        
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
    
    private void kamiDatuakErakutsiTaula(ArrayList<Kamiseta> kamiGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewProduktuaAukeratu.jTableKamiInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("MARKA");
        model.addColumn("PREZIOA");
        model.addColumn("KOLOREA");
        model.addColumn("SEXUA");
        model.addColumn("STOCK kantitatea");
        model.addColumn("TAILA");
        model.addColumn("SASOIA");
        
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
    
    private void prakDatuakErakutsiTaula(ArrayList<Praka> prakGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewProduktuaAukeratu.jTablePrakInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("MARKA");
        model.addColumn("PREZIOA");
        model.addColumn("KOLOREA");
        model.addColumn("SEXUA");
        model.addColumn("STOCK kantitatea");
        model.addColumn("TAILA");
        model.addColumn("SASOIA");
        model.addColumn("LUZEERA");
        model.addColumn("MOTA");
        
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
 
    private void resetJertseaGehitu() {
        viewJertseaGehitu.jTextFieldKodeJerts.setText(null);
        viewJertseaGehitu.jTextFieldMarka.setText(null);
        viewJertseaGehitu.jTextFieldPrezioa.setText(null);
        viewJertseaGehitu.jTextFieldKolorea.setText(null);
        viewJertseaGehitu.jComboBoxSexua.setSelectedIndex(0);
        viewJertseaGehitu.jTextFieldStock.setText(null);
        viewJertseaGehitu.jComboBoxTaila.setSelectedIndex(0);
        
        viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private void resetKamisetaGehitu() {
        viewKamisetaGehitu.jTextFieldKodeKami.setText(null);
        viewKamisetaGehitu.jTextFieldMarka.setText(null);
        viewKamisetaGehitu.jTextFieldPrezioa.setText(null);
        viewKamisetaGehitu.jTextFieldKolorea.setText(null);
        viewKamisetaGehitu.jComboBoxSexua.setSelectedIndex(0);
        viewKamisetaGehitu.jTextFieldStock.setText(null);
        viewKamisetaGehitu.jComboBoxTaila.setSelectedIndex(0);
        viewKamisetaGehitu.jComboBoxSasoia.setSelectedIndex(0);
        
        viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private void resetPrakaGehitu() {
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
        
        viewPrakaGehitu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewPrakaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewPrakaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewPrakaGehitu.jTextFieldLuzeera.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewPrakaGehitu.jComboBoxMota.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private void enableComponets (Container container, boolean bool) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                component.setEnabled(bool);
            }
        }
    }
    
    private void aukJertsDatuakBete(int aukLerroa) {
        viewProduktuaAukeratu.jTextFieldKodeJerts.setText(String.valueOf(viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 0)));
        viewProduktuaAukeratu.jTextFieldMarkaJerts.setText(String.valueOf(viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 1)));
        viewProduktuaAukeratu.jTextFieldPrezioaJerts.setText(String.valueOf(viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 2)));
        viewProduktuaAukeratu.jTextFieldKoloreaJerts.setText(String.valueOf(viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 3)));
        viewProduktuaAukeratu.jComboBoxSexuaJerts.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 4)));
        viewProduktuaAukeratu.jTextFieldStockJerts.setText(String.valueOf(viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 5)));
        viewProduktuaAukeratu.jComboBoxTailaJerts.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 6)));
    }
    
    private void resetJerts() {
        viewProduktuaAukeratu.jTextFieldKodeJerts.setText(null);
        viewProduktuaAukeratu.jTextFieldMarkaJerts.setText(null);
        viewProduktuaAukeratu.jTextFieldPrezioaJerts.setText(null);
        viewProduktuaAukeratu.jTextFieldKoloreaJerts.setText(null);
        viewProduktuaAukeratu.jComboBoxSexuaJerts.setSelectedItem(null);
        viewProduktuaAukeratu.jTextFieldStockJerts.setText(null);
        viewProduktuaAukeratu.jComboBoxTailaJerts.setSelectedItem(null);
    }
    
    private void aukKamiDatuakBete(int aukLerroa) {
        viewProduktuaAukeratu.jTextFieldKodeKami.setText(String.valueOf(viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 0)));
        viewProduktuaAukeratu.jTextFieldMarkaKami.setText(String.valueOf(viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 1)));
        viewProduktuaAukeratu.jTextFieldPrezioaKami.setText(String.valueOf(viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 2)));
        viewProduktuaAukeratu.jTextFieldKoloreaKami.setText(String.valueOf(viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 3)));
        viewProduktuaAukeratu.jComboBoxSexuaKami.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 4)));
        viewProduktuaAukeratu.jTextFieldStockKami.setText(String.valueOf(viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 5)));
        viewProduktuaAukeratu.jComboBoxTailaKami.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 6)));
        viewProduktuaAukeratu.jComboBoxSasoiaKami.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 7)));
    }
    
    private void resetKami() {
        viewProduktuaAukeratu.jTextFieldKodeKami.setText(null);
        viewProduktuaAukeratu.jTextFieldMarkaKami.setText(null);
        viewProduktuaAukeratu.jTextFieldPrezioaKami.setText(null);
        viewProduktuaAukeratu.jTextFieldKoloreaKami.setText(null);
        viewProduktuaAukeratu.jComboBoxSexuaKami.setSelectedItem(null);
        viewProduktuaAukeratu.jTextFieldStockKami.setText(null);
        viewProduktuaAukeratu.jComboBoxTailaKami.setSelectedItem(null);
        viewProduktuaAukeratu.jComboBoxSasoiaKami.setSelectedItem(null);
    }
    
    private void aukPrakDatuakBete(int aukLerroa) { 
        viewProduktuaAukeratu.jTextFieldKodePrak.setText(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 0)));
        viewProduktuaAukeratu.jTextFieldMarkaPrak.setText(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 1)));
        viewProduktuaAukeratu.jTextFieldPrezioaPrak.setText(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 2)));
        viewProduktuaAukeratu.jTextFieldKoloreaPrak.setText(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 3)));
        viewProduktuaAukeratu.jComboBoxSexuaPrak.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 4)));
        viewProduktuaAukeratu.jTextFieldStockPrak.setText(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 5)));
        viewProduktuaAukeratu.jComboBoxTailaPrak.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 6)));
        viewProduktuaAukeratu.jComboBoxSasoiaPrak.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 7)));
        viewProduktuaAukeratu.jTextFieldLuzeeraPrak.setText(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 8)));
        viewProduktuaAukeratu.jComboBoxMotaPrak.setSelectedItem(String.valueOf(viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 9)));
    }
    
    private void resetPrak() {
        viewProduktuaAukeratu.jTextFieldKodePrak.setText(null);
        viewProduktuaAukeratu.jTextFieldMarkaPrak.setText(null);
        viewProduktuaAukeratu.jTextFieldPrezioaPrak.setText(null);
        viewProduktuaAukeratu.jTextFieldKoloreaPrak.setText(null);
        viewProduktuaAukeratu.jComboBoxSexuaPrak.setSelectedItem(null);
        viewProduktuaAukeratu.jTextFieldStockPrak.setText(null);
        viewProduktuaAukeratu.jComboBoxTailaPrak.setSelectedItem(null);
        viewProduktuaAukeratu.jComboBoxSasoiaPrak.setSelectedItem(null);
        viewProduktuaAukeratu.jTextFieldLuzeeraPrak.setText(null);
        viewProduktuaAukeratu.jComboBoxMotaPrak.setSelectedItem(null); 
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
        
        /* ProduktuakAukeratu-ko aukerak */
        else if (comando == viewProduktuaAukeratu.jButtonGehituJerts) {
            viewJertseaGehitu.setVisible(true);
            viewProduktuaAukeratu.setEnabled(false);
            enableComponets(viewJertseaGehitu.jPanelJertsDatuak, false);
        }
        else if (comando == viewProduktuaAukeratu.jButtonEzabatuJerts) {
            int aukLerroa = viewProduktuaAukeratu.jTableJertsInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(viewProduktuaAukeratu.jDialogEzabatuKonfirm, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String kodea = (String) viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
                    String taila = (String) viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
                    JertseaKudeatu.jertseaEzabatu(kodea, taila);
                }
                jertsDatuakErakutsiTaula(JertseaKudeatu.jertsGuztErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da jertserik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldatuJerts) {
            if (viewProduktuaAukeratu.jTableJertsInfo.getSelectedRow()!=-1) {
                enableComponets(viewProduktuaAukeratu.jPanelJertsInfo, true);
                enableComponets(viewProduktuaAukeratu.jPanelJertsBotoiak, false);
                viewProduktuaAukeratu.jButtonIrten.setEnabled(false);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(1, false);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(2, false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da produkturik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            } 
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldaketaEzabatuJerts) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                enableComponets(viewProduktuaAukeratu.jPanelJertsInfo, false);
                enableComponets(viewProduktuaAukeratu.jPanelJertsBotoiak, true);
                resetJertsInfoErr();
                aukJertsDatuakBete(viewProduktuaAukeratu.jTableJertsInfo.getSelectedRow()); // taulako datuekin berriz bete
                viewProduktuaAukeratu.jButtonIrten.setEnabled(true);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(1, true);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(2, true);
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldaketaGordeJerts) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaJertsInfo()) {
                    int aukLerroa = viewProduktuaAukeratu.jTableJertsInfo.getSelectedRow(); // aukeratutako lerroa
                    /* Jertsea ezabatu */
                    String kodea = (String) viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
                    String taila = (String) viewProduktuaAukeratu.jTableJertsInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
                    JertseaKudeatu.jertseaEzabatu(kodea, taila);

                    /* Jertsea gorde */
                    Jertsea jerts = new Jertsea(viewProduktuaAukeratu.jTextFieldKodeJerts.getText(), viewProduktuaAukeratu.jTextFieldMarkaJerts.getText(), 
                            Double.parseDouble(viewProduktuaAukeratu.jTextFieldPrezioaJerts.getText()), viewProduktuaAukeratu.jTextFieldKoloreaJerts.getText(), 
                            viewProduktuaAukeratu.jComboBoxSexuaJerts.getSelectedItem().toString(), Integer.parseInt(viewProduktuaAukeratu.jTextFieldStockJerts.getText()), 
                            viewProduktuaAukeratu.jComboBoxTailaJerts.getSelectedItem().toString());
                    JertseaKudeatu.jertsGehitu(jerts);
                    
                    jertsDatuakErakutsiTaula(JertseaKudeatu.jertsGuztErakutsi());
                    enableComponets(viewProduktuaAukeratu.jPanelJertsInfo, false);
                    enableComponets(viewProduktuaAukeratu.jPanelJertsBotoiak, true);
                    viewProduktuaAukeratu.jButtonIrten.setEnabled(true);
                    viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(1, true);
                    viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(2, true);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonGehituKami) {
            viewKamisetaGehitu.setVisible(true);
            viewProduktuaAukeratu.setEnabled(false);
            enableComponets(viewKamisetaGehitu.jPanelKamiDatuak, false);
        }
        else if (comando == viewProduktuaAukeratu.jButtonEzabatuKami) {
            int aukLerroa = viewProduktuaAukeratu.jTableKamiInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(viewProduktuaAukeratu.jDialogEzabatuKonfirm, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String kodea = (String) viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
                    String taila = (String) viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
                    KamisetaKudeatu.kamisetaEzabatu(kodea, taila);
                }
                kamiDatuakErakutsiTaula(KamisetaKudeatu.kamisetaGuztErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da kamisetarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldatuKami) {
            if (viewProduktuaAukeratu.jTableKamiInfo.getSelectedRow()!=-1) {
                enableComponets(viewProduktuaAukeratu.jPanelKamiInfo, true);
                enableComponets(viewProduktuaAukeratu.jPanelKamiBotoiak, false);
                viewProduktuaAukeratu.jButtonIrten.setEnabled(false);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(0, false);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(2, false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da produkturik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            } 
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldaketaEzabatuKami) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                enableComponets(viewProduktuaAukeratu.jPanelKamiInfo, false);
                enableComponets(viewProduktuaAukeratu.jPanelKamiBotoiak, true);
                resetKamiInfoErr();
                aukKamiDatuakBete(viewProduktuaAukeratu.jTableKamiInfo.getSelectedRow()); // taulako datuekin berriz bete
                viewProduktuaAukeratu.jButtonIrten.setEnabled(true);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(0, true);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(2, true);
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldaketaGordeKami) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaKamiInfo()) {
                    int aukLerroa = viewProduktuaAukeratu.jTableKamiInfo.getSelectedRow(); // aukeratutako lerroa
                    /* Kamiseta ezabatu */
                    String kodea = (String) viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
                    String taila = (String) viewProduktuaAukeratu.jTableKamiInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
                    KamisetaKudeatu.kamisetaEzabatu(kodea, taila);

                    /* Kamiseta gorde */
                    Kamiseta kami = new Kamiseta(viewProduktuaAukeratu.jTextFieldKodeKami.getText(), viewProduktuaAukeratu.jTextFieldMarkaKami.getText(), 
                            Double.parseDouble(viewProduktuaAukeratu.jTextFieldPrezioaKami.getText()), viewProduktuaAukeratu.jTextFieldKoloreaKami.getText(), 
                            viewProduktuaAukeratu.jComboBoxSexuaKami.getSelectedItem().toString(), Integer.parseInt(viewProduktuaAukeratu.jTextFieldStockKami.getText()), 
                            viewProduktuaAukeratu.jComboBoxTailaKami.getSelectedItem().toString(), viewProduktuaAukeratu.jComboBoxSasoiaKami.getSelectedItem().toString());
                    KamisetaKudeatu.kamisetaGehitu(kami);
                    
                    kamiDatuakErakutsiTaula(KamisetaKudeatu.kamisetaGuztErakutsi());
                    enableComponets(viewProduktuaAukeratu.jPanelKamiInfo, false);
                    enableComponets(viewProduktuaAukeratu.jPanelKamiBotoiak, true);
                    viewProduktuaAukeratu.jButtonIrten.setEnabled(true);
                    viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(0, true);
                    viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(2, true);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonGehituPrak) {
            viewPrakaGehitu.setVisible(true);
            viewProduktuaAukeratu.setEnabled(false);
            enableComponets(viewPrakaGehitu.jPanelPrakDatuak, false);
        }
        else if (comando == viewProduktuaAukeratu.jButtonEzabatuPrak) {
            int aukLerroa = viewProduktuaAukeratu.jTablePrakInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(viewProduktuaAukeratu.jDialogEzabatuKonfirm, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String kodea = (String) viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
                    int taila = (int) viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
                    PrakaKudeatu.prakaEzabatu(kodea, taila);
                }
                prakDatuakErakutsiTaula(PrakaKudeatu.prakaGutztErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da prakarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldatuPrak) {
            if (viewProduktuaAukeratu.jTablePrakInfo.getSelectedRow()!=-1) {
                enableComponets(viewProduktuaAukeratu.jPanelPrakInfo, true);
                enableComponets(viewProduktuaAukeratu.jPanelPrakBotoiak, false);
                viewProduktuaAukeratu.jButtonIrten.setEnabled(false);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(0, false);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(1, false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da produkturik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            } 
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldaketaEzabatuPrak) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                enableComponets(viewProduktuaAukeratu.jPanelPrakInfo, false);
                enableComponets(viewProduktuaAukeratu.jPanelPrakBotoiak, true);
                resetPrakInfoErr();
                aukPrakDatuakBete(viewProduktuaAukeratu.jTablePrakInfo.getSelectedRow()); // taulako datuekin berriz bete
                viewProduktuaAukeratu.jButtonIrten.setEnabled(true);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(0, true);
                viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(1, true);
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldaketaGordePrak) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaPrakInfo()) {
                    int aukLerroa = viewProduktuaAukeratu.jTablePrakInfo.getSelectedRow(); // aukeratutako lerroa
                    /* Praka ezabatu */
                    String kodea = (String) viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako produktuaren kodea lortu
                    int taila = (int) viewProduktuaAukeratu.jTablePrakInfo.getModel().getValueAt(aukLerroa, 6); // aukeratutako produktuaren taila lortu
                    PrakaKudeatu.prakaEzabatu(kodea, taila);

                    /* Praka gorde */
                    Praka prak = new Praka(viewProduktuaAukeratu.jTextFieldKodePrak.getText(), viewProduktuaAukeratu.jTextFieldMarkaPrak.getText(), 
                            Double.parseDouble(viewProduktuaAukeratu.jTextFieldPrezioaPrak.getText()), viewProduktuaAukeratu.jTextFieldKoloreaPrak.getText(), 
                            viewProduktuaAukeratu.jComboBoxSexuaPrak.getSelectedItem().toString(), Integer.parseInt(viewProduktuaAukeratu.jTextFieldStockPrak.getText()), 
                            Integer.parseInt(viewProduktuaAukeratu.jComboBoxTailaPrak.getSelectedItem().toString()), viewProduktuaAukeratu.jComboBoxSasoiaPrak.getSelectedItem().toString(),
                            Integer.parseInt(viewProduktuaAukeratu.jTextFieldLuzeeraPrak.getText()), viewProduktuaAukeratu.jComboBoxMotaPrak.getSelectedItem().toString());
                    PrakaKudeatu.prakaGehitu(prak);
                    
                    prakDatuakErakutsiTaula(PrakaKudeatu.prakaGutztErakutsi());
                    enableComponets(viewProduktuaAukeratu.jPanelPrakInfo, false);
                    enableComponets(viewProduktuaAukeratu.jPanelPrakBotoiak, true);
                    viewProduktuaAukeratu.jButtonIrten.setEnabled(true);
                    viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(0, true);
                    viewProduktuaAukeratu.jTabbedPaneProd.setEnabledAt(1, true);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonIrten) {
            viewProduktuaAukeratu.jToggleButtonEzkutatu.setSelected(true);
            enableComponets(viewProduktuaAukeratu.jPanelGoiburua, false);
            enableComponets(viewProduktuaAukeratu.jPanelAukerak, false);
            viewProduktuaAukeratu.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (viewProduktuaAukeratu.jToggleButtonErakutsi.isSelected()) {
            enableComponets(viewProduktuaAukeratu.jPanelGoiburua, true);
        }
        else if (viewProduktuaAukeratu.jToggleButtonEzkutatu.isSelected()) {
            enableComponets(viewProduktuaAukeratu.jPanelGoiburua, false);
            enableComponets(viewProduktuaAukeratu.jPanelAukerak, false);
            viewProduktuaAukeratu.jComboBoxAukeratuProd.setSelectedIndex(0);
        }
        
        /* JertseaGehitu-ko aukerak */
        if (comando == viewJertseaGehitu.jButtonBerriaGehitu){
            enableComponets(viewJertseaGehitu.jPanelJertsDatuak, true);
        }
        else if (comando == viewJertseaGehitu.jButtonGorde) {
            if (balidazioaJertsGehitu()) {
                Jertsea jerts = new Jertsea(viewJertseaGehitu.jTextFieldKodeJerts.getText(), viewJertseaGehitu.jTextFieldMarka.getText(), 
                        Double.parseDouble(viewJertseaGehitu.jTextFieldPrezioa.getText()), viewJertseaGehitu.jTextFieldKolorea.getText(), 
                        viewJertseaGehitu.jComboBoxSexua.getSelectedItem().toString(), Integer.parseInt(viewJertseaGehitu.jTextFieldStock.getText()),
                        viewJertseaGehitu.jComboBoxTaila.getSelectedItem().toString());
                JertseaKudeatu.jertsGehitu(jerts);
                resetJertseaGehitu();
                enableComponets(viewJertseaGehitu.jPanelJertsDatuak, false);
            }   
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        } 
        else if (comando == viewJertseaGehitu.jButtonReset) {
            resetJertseaGehitu();
        }
        else if (comando == viewJertseaGehitu.jButtonIrten) {
            resetJertseaGehitu();
            viewJertseaGehitu.dispose();
            viewProduktuaAukeratu.setEnabled(true);
            jertsDatuakErakutsiTaula(JertseaKudeatu.jertsGuztErakutsi());
        }
        
        /* KamisetaGehitu-ko aukerak */
        else if (comando == viewKamisetaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewKamisetaGehitu.jPanelKamiDatuak, true);
        }
        else if (comando == viewKamisetaGehitu.jButtonGorde) {
            if (balidazioaKamiGehitu()) {
                Kamiseta kami = new Kamiseta (viewKamisetaGehitu.jTextFieldKodeKami.getText(), viewKamisetaGehitu.jTextFieldMarka.getText(), 
                        Double.parseDouble(viewKamisetaGehitu.jTextFieldPrezioa.getText()), viewKamisetaGehitu.jTextFieldKolorea.getText(), 
                        viewKamisetaGehitu.jComboBoxSexua.getSelectedItem().toString(), Integer.parseInt(viewKamisetaGehitu.jTextFieldStock.getText()), 
                        viewKamisetaGehitu.jComboBoxTaila.getSelectedItem().toString(), viewKamisetaGehitu.jComboBoxSasoia.getSelectedItem().toString());
                KamisetaKudeatu.kamisetaGehitu(kami);
                resetKamisetaGehitu();
                enableComponets(viewKamisetaGehitu.jPanelKamiDatuak, false);
            }   
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewKamisetaGehitu.jButtonReset) {
            resetKamisetaGehitu();
        }
        else if (comando == viewKamisetaGehitu.jButtonIrten) {
            resetKamisetaGehitu();
            viewKamisetaGehitu.dispose();
            viewProduktuaAukeratu.setEnabled(true);
            kamiDatuakErakutsiTaula(KamisetaKudeatu.kamisetaGuztErakutsi());
        }
        
        /* PrakaGehitu-ko aukerak */
        else if (comando == viewPrakaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewPrakaGehitu.jPanelPrakDatuak, true);
        }
        else if (comando == viewPrakaGehitu.jButtonGorde) {
            if (balidazioaPrakGehitu()) {
                Praka prak = new Praka (viewPrakaGehitu.jTextFieldKodePrak.getText(), viewPrakaGehitu.jTextFieldMarka.getText(), 
                        Double.parseDouble(viewPrakaGehitu.jTextFieldPrezioa.getText()), viewPrakaGehitu.jTextFieldKolorea.getText(), 
                        viewPrakaGehitu.jComboBoxSexua.getSelectedItem().toString(), Integer.parseInt(viewPrakaGehitu.jTextFieldStock.getText()), 
                        Integer.parseInt(viewPrakaGehitu.jComboBoxTaila.getSelectedItem().toString()), viewPrakaGehitu.jComboBoxSasoia.getSelectedItem().toString(), 
                        Integer.parseInt(viewPrakaGehitu.jTextFieldLuzeera.getText()), viewPrakaGehitu.jComboBoxMota.getSelectedItem().toString());
                PrakaKudeatu.prakaGehitu(prak);
                resetPrakaGehitu();
                enableComponets(viewPrakaGehitu.jPanelPrakDatuak, false);
            }   
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewPrakaGehitu.jButtonReset) {
            resetPrakaGehitu();
        }
        else if (comando == viewPrakaGehitu.jButtonIrten) {
            resetPrakaGehitu();
            viewPrakaGehitu.dispose();
            viewProduktuaAukeratu.setEnabled(true);
            prakDatuakErakutsiTaula(PrakaKudeatu.prakaGutztErakutsi());
        }
    }
            
    @Override
    public void ancestorAdded(AncestorEvent event) {
        Object comando = event.getSource();
        if (comando == viewProduktuaAukeratu.jPanelJerts) {
            if (viewProduktuaAukeratu.jToggleButtonEzkutatu.isSelected()) {
                enableComponets(viewProduktuaAukeratu.jPanelJertsInfo, false);
                jertsDatuakErakutsiTaula(JertseaKudeatu.jertsGuztErakutsi());
            }
            else {
                if (viewProduktuaAukeratu.jComboBoxAukeratuProd.getSelectedItem() == "Inbentarioa") {
                    jertsDatuakErakutsiTaula(JertseaKudeatu.jertseaInbentarioa());
                }
            }
        }
        else if (comando == viewProduktuaAukeratu.jPanelKami) {
            enableComponets(viewProduktuaAukeratu.jPanelKamiInfo, false);
            kamiDatuakErakutsiTaula(KamisetaKudeatu.kamisetaGuztErakutsi());
        }
        else if (comando == viewProduktuaAukeratu.jPanelPrak) {
            enableComponets(viewProduktuaAukeratu.jPanelPrakInfo, false);
            prakDatuakErakutsiTaula(PrakaKudeatu.prakaGutztErakutsi());
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
        
    } 

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewProduktuaAukeratu.jButtonIrten)
            viewProduktuaAukeratu.jButtonIrten.setBackground(new Color (0,0,51));
        else if (comando == viewJertseaGehitu.jButtonIrten)
            viewJertseaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
        else if (comando == viewKamisetaGehitu.jButtonIrten)
            viewKamisetaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
        else if (comando == viewPrakaGehitu.jButtonIrten)
            viewPrakaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewProduktuaAukeratu.jButtonIrten)
            viewProduktuaAukeratu.jButtonIrten.setBackground(urdina);
        else if (comando == viewJertseaGehitu.jButtonIrten)
            viewJertseaGehitu.jButtonIrten.setBackground(urdina);
        else if (comando == viewKamisetaGehitu.jButtonIrten)
            viewKamisetaGehitu.jButtonIrten.setBackground(urdina);  
        else if (comando == viewPrakaGehitu.jButtonIrten)
            viewPrakaGehitu.jButtonIrten.setBackground(urdina);  
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        /* Tauletako lerroak aukeratzerakoan */
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (lsm == viewProduktuaAukeratu.jTableJertsInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetJerts();
            }
            else {
                viewProduktuaAukeratu.jTableJertsInfo.setSelectionBackground(urdina);
                viewProduktuaAukeratu.jTableJertsInfo.setSelectionForeground(Color.WHITE);
                aukJertsDatuakBete(viewProduktuaAukeratu.jTableJertsInfo.getSelectedRow());
            }
        }
        else if (lsm == viewProduktuaAukeratu.jTableKamiInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetKami();
            }
            else {
                viewProduktuaAukeratu.jTableKamiInfo.setSelectionBackground(urdina);
                viewProduktuaAukeratu.jTableKamiInfo.setSelectionForeground(Color.WHITE);
                aukKamiDatuakBete(viewProduktuaAukeratu.jTableKamiInfo.getSelectedRow());
            }
        }
        else if (lsm == viewProduktuaAukeratu.jTablePrakInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetPrak();
            }
            else {
                viewProduktuaAukeratu.jTablePrakInfo.setSelectionBackground(urdina);
                viewProduktuaAukeratu.jTablePrakInfo.setSelectionForeground(Color.WHITE);
                aukPrakDatuakBete(viewProduktuaAukeratu.jTablePrakInfo.getSelectedRow());
            }
        }
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        Object comando = e.getSource();
        if (viewProduktuaAukeratu.jComboBoxAukeratuProd.getSelectedItem() == "Inbentarioa") {
            jertsDatuakErakutsiTaula(JertseaKudeatu.jertseaInbentarioa());
        }
        if (viewProduktuaAukeratu.jComboBoxAukeratuProd.getSelectedItem() == "Eskatzeko dauden produktuak") {
            jertsDatuakErakutsiTaula(JertseaKudeatu.jertseaEskatzeko());
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // JertseaInfo
        if (comando == viewProduktuaAukeratu.jTextFieldKodeJerts)
            viewProduktuaAukeratu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldMarkaJerts)
            viewProduktuaAukeratu.jTextFieldMarkaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldPrezioaJerts)
            viewProduktuaAukeratu.jTextFieldPrezioaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldKoloreaJerts)
            viewProduktuaAukeratu.jTextFieldKoloreaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jComboBoxSexuaJerts)
            viewProduktuaAukeratu.jComboBoxSexuaJerts.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewProduktuaAukeratu.jTextFieldStockJerts)
            viewProduktuaAukeratu.jTextFieldStockJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jComboBoxTailaJerts)
            viewProduktuaAukeratu.jComboBoxTailaJerts.setBorder(BorderFactory.createLineBorder(urdina, 1));
         
        // JertseaGehitu
        else if (comando == viewJertseaGehitu.jTextFieldKodeJerts)
            viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jTextFieldMarka)
            viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jTextFieldPrezioa)
            viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jTextFieldKolorea)
            viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jComboBoxSexua)
            viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewJertseaGehitu.jTextFieldStock)
            viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jComboBoxTaila)
            viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(urdina, 1));
        
        // KamisetaInfo
        else if (comando == viewProduktuaAukeratu.jTextFieldKodeKami)
            viewProduktuaAukeratu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldMarkaKami)
            viewProduktuaAukeratu.jTextFieldMarkaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldPrezioaKami)
            viewProduktuaAukeratu.jTextFieldPrezioaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldKoloreaKami)
            viewProduktuaAukeratu.jTextFieldKoloreaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jComboBoxSexuaKami)
            viewProduktuaAukeratu.jComboBoxSexuaKami.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewProduktuaAukeratu.jTextFieldStockKami)
            viewProduktuaAukeratu.jTextFieldStockKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jComboBoxTailaKami)
            viewProduktuaAukeratu.jComboBoxTailaKami.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewProduktuaAukeratu.jComboBoxSasoiaKami)
            viewProduktuaAukeratu.jComboBoxSasoiaKami.setBorder(BorderFactory.createLineBorder(urdina, 1));
        
        // KamisetaGehitu
        else if (comando == viewKamisetaGehitu.jTextFieldKodeKami)
            viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jTextFieldMarka)
            viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jTextFieldPrezioa)
            viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jTextFieldKolorea)
            viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jComboBoxSexua)
            viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewKamisetaGehitu.jTextFieldStock)
            viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jComboBoxTaila)
            viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewKamisetaGehitu.jComboBoxSasoia)
            viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(urdina, 1));
        
        // PrakaInfo
        else if (comando == viewProduktuaAukeratu.jTextFieldKodePrak)
            viewProduktuaAukeratu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldMarkaPrak)
            viewProduktuaAukeratu.jTextFieldMarkaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldPrezioaPrak)
            viewProduktuaAukeratu.jTextFieldPrezioaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jTextFieldKoloreaPrak)
            viewProduktuaAukeratu.jTextFieldKoloreaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jComboBoxSexuaPrak)
            viewProduktuaAukeratu.jComboBoxSexuaPrak.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewProduktuaAukeratu.jTextFieldStockPrak)
            viewProduktuaAukeratu.jTextFieldStockPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jComboBoxTailaPrak)
            viewProduktuaAukeratu.jComboBoxTailaPrak.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewProduktuaAukeratu.jComboBoxSasoiaPrak)
            viewProduktuaAukeratu.jComboBoxSasoiaPrak.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewProduktuaAukeratu.jTextFieldLuzeeraPrak)
            viewProduktuaAukeratu.jTextFieldLuzeeraPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProduktuaAukeratu.jComboBoxMotaPrak) 
            viewProduktuaAukeratu.jComboBoxMotaPrak.setBorder(BorderFactory.createLineBorder(urdina, 1));
        
        // PrakaGehitu
        else if (comando == viewPrakaGehitu.jTextFieldKodePrak)
            viewPrakaGehitu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewPrakaGehitu.jTextFieldMarka)
            viewPrakaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewPrakaGehitu.jTextFieldPrezioa)
            viewPrakaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewPrakaGehitu.jTextFieldKolorea)
            viewPrakaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewPrakaGehitu.jComboBoxSexua)
            viewPrakaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewPrakaGehitu.jTextFieldStock)
            viewPrakaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewPrakaGehitu.jComboBoxTaila)
            viewPrakaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewPrakaGehitu.jComboBoxSasoia)
            viewPrakaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewPrakaGehitu.jTextFieldLuzeera)
            viewPrakaGehitu.jTextFieldLuzeera.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewPrakaGehitu.jComboBoxMota) 
            viewPrakaGehitu.jComboBoxMota.setBorder(BorderFactory.createLineBorder(urdina, 1));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // JertseaInfo
        if (comando == viewProduktuaAukeratu.jTextFieldKodeJerts)
            viewProduktuaAukeratu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldMarkaJerts)
            viewProduktuaAukeratu.jTextFieldMarkaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldPrezioaJerts)
            viewProduktuaAukeratu.jTextFieldPrezioaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldKoloreaJerts)
            viewProduktuaAukeratu.jTextFieldKoloreaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jComboBoxSexuaJerts)
            viewProduktuaAukeratu.jComboBoxSexuaJerts.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewProduktuaAukeratu.jTextFieldStockJerts)
            viewProduktuaAukeratu.jTextFieldStockJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jComboBoxTailaJerts)
            viewProduktuaAukeratu.jComboBoxTailaJerts.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        // JertseaGehitu
        else if (comando == viewJertseaGehitu.jTextFieldKodeJerts)
            viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jTextFieldMarka)
            viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jTextFieldPrezioa)
            viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jTextFieldKolorea)
            viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jComboBoxSexua)
            viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewJertseaGehitu.jTextFieldStock)
            viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jComboBoxTaila)
            viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        // KamisetaInfo
        else if (comando == viewProduktuaAukeratu.jTextFieldKodeKami)
            viewProduktuaAukeratu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldMarkaKami)
            viewProduktuaAukeratu.jTextFieldMarkaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldPrezioaKami)
            viewProduktuaAukeratu.jTextFieldPrezioaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldKoloreaKami)
            viewProduktuaAukeratu.jTextFieldKoloreaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jComboBoxSexuaKami)
            viewProduktuaAukeratu.jComboBoxSexuaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewProduktuaAukeratu.jTextFieldStockKami)
            viewProduktuaAukeratu.jTextFieldStockKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jComboBoxTailaKami)
            viewProduktuaAukeratu.jComboBoxTailaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewProduktuaAukeratu.jComboBoxSasoiaKami)
            viewProduktuaAukeratu.jComboBoxSasoiaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
     
        // KamisetaGehitu
        else if (comando == viewKamisetaGehitu.jTextFieldKodeKami)
            viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jTextFieldMarka)
            viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jTextFieldPrezioa)
            viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jTextFieldKolorea)
            viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jComboBoxSexua)
            viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewKamisetaGehitu.jTextFieldStock)
            viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jComboBoxTaila)
            viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewKamisetaGehitu.jComboBoxSasoia)
            viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        // PrakaInfo
        else if (comando == viewProduktuaAukeratu.jTextFieldKodePrak)
            viewProduktuaAukeratu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldMarkaPrak)
            viewProduktuaAukeratu.jTextFieldMarkaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldPrezioaPrak)
            viewProduktuaAukeratu.jTextFieldPrezioaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jTextFieldKoloreaPrak)
            viewProduktuaAukeratu.jTextFieldKoloreaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jComboBoxSexuaPrak)
            viewProduktuaAukeratu.jComboBoxSexuaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewProduktuaAukeratu.jTextFieldStockPrak)
            viewProduktuaAukeratu.jTextFieldStockPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jComboBoxTailaPrak)
            viewProduktuaAukeratu.jComboBoxTailaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewProduktuaAukeratu.jComboBoxSasoiaPrak)
            viewProduktuaAukeratu.jComboBoxSasoiaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewProduktuaAukeratu.jTextFieldLuzeeraPrak)
            viewProduktuaAukeratu.jTextFieldLuzeeraPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProduktuaAukeratu.jComboBoxMotaPrak) 
            viewProduktuaAukeratu.jComboBoxMotaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        // PrakaGehitu
        else if (comando == viewPrakaGehitu.jTextFieldKodePrak)
            viewPrakaGehitu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewPrakaGehitu.jTextFieldMarka)
            viewPrakaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewPrakaGehitu.jTextFieldPrezioa)
            viewPrakaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewPrakaGehitu.jTextFieldKolorea)
            viewPrakaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewPrakaGehitu.jComboBoxSexua)
            viewPrakaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewPrakaGehitu.jTextFieldStock)
            viewPrakaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewPrakaGehitu.jComboBoxTaila)
            viewPrakaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewPrakaGehitu.jComboBoxSasoia)
            viewPrakaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewPrakaGehitu.jTextFieldLuzeera)
            viewPrakaGehitu.jTextFieldLuzeera.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewPrakaGehitu.jComboBoxMota) 
            viewPrakaGehitu.jComboBoxMota.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object comando = e.getSource();
        if (comando == viewProduktuaAukeratu.jTextFieldBilatuJerts)
            txtBilatuTaulan(viewProduktuaAukeratu.jTableJertsInfo, viewProduktuaAukeratu.jTextFieldBilatuJerts.getText());
        else if (comando == viewProduktuaAukeratu.jTextFieldBilatuKami)
            txtBilatuTaulan(viewProduktuaAukeratu.jTableKamiInfo, viewProduktuaAukeratu.jTextFieldBilatuKami.getText());
        else if (comando == viewProduktuaAukeratu.jTextFieldBilatuPrak)
            txtBilatuTaulan(viewProduktuaAukeratu.jTablePrakInfo, viewProduktuaAukeratu.jTextFieldBilatuPrak.getText());
    }
   
    private boolean balidazioaJertsInfo() {
        boolean bool = true;
        if (viewProduktuaAukeratu.jTextFieldKodeJerts.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewProduktuaAukeratu.jTextFieldMarkaJerts.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldMarkaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewProduktuaAukeratu.jTextFieldPrezioaJerts.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldPrezioaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewProduktuaAukeratu.jTextFieldKoloreaJerts.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldKoloreaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxSexuaJerts.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxSexuaJerts.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewProduktuaAukeratu.jTextFieldStockJerts.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldStockJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxTailaJerts.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxTailaJerts.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
    
    private boolean balidazioaKamiInfo() {
        boolean bool = true;
        if (viewProduktuaAukeratu.jTextFieldKodeKami.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewProduktuaAukeratu.jTextFieldMarkaKami.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldMarkaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewProduktuaAukeratu.jTextFieldPrezioaKami.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldPrezioaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewProduktuaAukeratu.jTextFieldKoloreaKami.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldKoloreaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxSexuaKami.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxSexuaKami.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewProduktuaAukeratu.jTextFieldStockKami.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldStockKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxTailaKami.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxTailaKami.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxSasoiaKami.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxSasoiaKami.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
    
    private boolean balidazioaPrakInfo() {
        boolean bool = true;
        if (viewProduktuaAukeratu.jTextFieldKodePrak.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewProduktuaAukeratu.jTextFieldMarkaPrak.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldMarkaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewProduktuaAukeratu.jTextFieldPrezioaPrak.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldPrezioaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewProduktuaAukeratu.jTextFieldKoloreaPrak.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldKoloreaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxSexuaPrak.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxSexuaPrak.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewProduktuaAukeratu.jTextFieldStockPrak.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldStockPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxTailaPrak.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxTailaPrak.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxSasoiaPrak.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxSasoiaPrak.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewProduktuaAukeratu.jTextFieldLuzeeraPrak.getText().isEmpty()) {
            viewProduktuaAukeratu.jTextFieldLuzeeraPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewProduktuaAukeratu.jComboBoxMotaPrak.getSelectedIndex() == 0) {
            viewProduktuaAukeratu.jComboBoxMotaPrak.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
    
    private boolean balidazioaJertsGehitu() {
        boolean bool = true;
        if (viewJertseaGehitu.jTextFieldKodeJerts.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewJertseaGehitu.jTextFieldMarka.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewJertseaGehitu.jTextFieldPrezioa.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewJertseaGehitu.jTextFieldKolorea.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewJertseaGehitu.jComboBoxSexua.getSelectedIndex() == 0) {
            viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewJertseaGehitu.jTextFieldStock.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewJertseaGehitu.jComboBoxTaila.getSelectedIndex() == 0) {
            viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
    
    private boolean balidazioaKamiGehitu() {
        boolean bool = true;
        if (viewKamisetaGehitu.jTextFieldKodeKami.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewKamisetaGehitu.jTextFieldMarka.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewKamisetaGehitu.jTextFieldPrezioa.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewKamisetaGehitu.jTextFieldKolorea.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewKamisetaGehitu.jComboBoxSexua.getSelectedIndex() == 0) {
            viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewKamisetaGehitu.jTextFieldStock.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewKamisetaGehitu.jComboBoxTaila.getSelectedIndex() == 0) {
            viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewKamisetaGehitu.jComboBoxSasoia.getSelectedIndex() == 0) {
            viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }

    private boolean balidazioaPrakGehitu() {
        boolean bool = true;
        if (viewPrakaGehitu.jTextFieldKodePrak.getText().isEmpty()) {
            viewPrakaGehitu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewPrakaGehitu.jTextFieldMarka.getText().isEmpty()) {
            viewPrakaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewPrakaGehitu.jTextFieldPrezioa.getText().isEmpty()) {
            viewPrakaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewPrakaGehitu.jTextFieldKolorea.getText().isEmpty()) {
            viewPrakaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewPrakaGehitu.jComboBoxSexua.getSelectedIndex() == 0) {
            viewPrakaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewPrakaGehitu.jTextFieldStock.getText().isEmpty()) {
            viewPrakaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewPrakaGehitu.jComboBoxTaila.getSelectedIndex() == 0) {
            viewPrakaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewPrakaGehitu.jComboBoxSasoia.getSelectedIndex() == 0) {
            viewPrakaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewPrakaGehitu.jTextFieldLuzeera.getText().isEmpty()) {
            viewPrakaGehitu.jTextFieldLuzeera.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewPrakaGehitu.jComboBoxMota.getSelectedIndex() == 0) {
            viewPrakaGehitu.jComboBoxMota.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }

    private void resetJertsInfoErr() {
        viewProduktuaAukeratu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldMarkaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldPrezioaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldKoloreaJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxSexuaJerts.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldStockJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxTailaJerts.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private void resetKamiInfoErr() {
        viewProduktuaAukeratu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldMarkaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldPrezioaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldKoloreaKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxSexuaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldStockKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxTailaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jComboBoxSasoiaKami.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }

    private void resetPrakInfoErr() {
        viewProduktuaAukeratu.jTextFieldKodePrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldMarkaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldPrezioaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jTextFieldKoloreaPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxSexuaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldStockPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxTailaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jComboBoxSasoiaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewProduktuaAukeratu.jTextFieldLuzeeraPrak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProduktuaAukeratu.jComboBoxMotaPrak.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private void txtBilatuTaulan(JTable taula, String textua) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(taula.getModel());
        taula.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(textua));
    }
}