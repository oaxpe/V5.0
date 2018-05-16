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
        this.viewHornitzaileaGehitu = viewHornGehitu;
        this.viewMenuNagusia = viewMenuNag;
        botoiakEntzuten();
        hasieratu();
        viewMenuNagusia.setVisible(true);
    }
    
    /* METODOAK */
    private void botoiakEntzuten() { 
        /* ActionListeners gehitu */
        viewMenuNagusia.jButtonIrten.addActionListener(this);
        viewDendaInfo.jButtonIrten.addActionListener(this);
        viewDendaGehitu.jButtonIrten.addActionListener(this);
        viewBezeroaInfo.jButtonIrten.addActionListener(this);
        viewBezeroaGehitu.jButtonIrten.addActionListener(this);
        viewLangileaInfo.jButtonIrten.addActionListener(this);
        viewLangileaGehitu.jButtonIrten.addActionListener(this);
        viewProduktuaAukeratu.jButtonIrten.addActionListener(this);
        viewJertseaGehitu.jButtonIrten.addActionListener(this);
        viewKamisetaGehitu.jButtonIrten.addActionListener(this);
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
        
        // DendaInfo-ko botoiak
        viewDendaInfo.jButtonEzabatu.addActionListener(this);
        viewDendaInfo.jButtonAldatu.addActionListener(this);
        viewDendaInfo.jButtonGehitu.addActionListener(this);
        viewDendaInfo.jButtonAldaketaGorde.addActionListener(this);
        viewDendaInfo.jButtonAldaketaEzabatu.addActionListener(this);
        
        // DendaGehitu-ko botoiak
        viewDendaGehitu.jButtonReset.addActionListener(this);
        viewDendaGehitu.jButtonGorde.addActionListener(this);
        viewDendaGehitu.jButtonBerriaGehitu.addActionListener(this);        
        
        // BezeroaInfo-ko botoiak
        viewBezeroaInfo.jButtonEzabatu.addActionListener(this);
        viewBezeroaInfo.jButtonAldatu.addActionListener(this);
        viewBezeroaInfo.jButtonGehitu.addActionListener(this);
        viewBezeroaInfo.jButtonAldaketaGorde.addActionListener(this);
        viewBezeroaInfo.jButtonAldaketaEzabatu.addActionListener(this);
        
        // BezeroaGehitu-ko botoiak
        viewBezeroaGehitu.jButtonReset.addActionListener(this);
        viewBezeroaGehitu.jButtonGorde.addActionListener(this);
        viewBezeroaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
        // LangileaInfo-ko botoiak
        viewLangileaInfo.jButtonEzabatu.addActionListener(this);
        viewLangileaInfo.jButtonAldatu.addActionListener(this);
        viewLangileaInfo.jButtonGehitu.addActionListener(this);
        viewLangileaInfo.jButtonAldaketaGorde.addActionListener(this);
        viewLangileaInfo.jButtonAldaketaEzabatu.addActionListener(this);
        
        // LangileaGehitu-ko botoiak
        viewLangileaGehitu.jButtonReset.addActionListener(this);
        viewLangileaGehitu.jButtonGorde.addActionListener(this);
        viewLangileaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
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
        viewHornitzaileaInfo.jButtonEzabatu.addActionListener(this);
        viewHornitzaileaInfo.jButtonAldatu.addActionListener(this);
        viewHornitzaileaInfo.jButtonGehitu.addActionListener(this);
        viewHornitzaileaInfo.jButtonAldaketaGorde.addActionListener(this);
        viewHornitzaileaInfo.jButtonAldaketaEzabatu.addActionListener(this);
        
        // HornitzaileaGehitu-ko botoik
        viewHornitzaileaGehitu.jButtonReset.addActionListener(this);
        viewHornitzaileaGehitu.jButtonGorde.addActionListener(this);
        viewHornitzaileaGehitu.jButtonBerriaGehitu.addActionListener(this);
        
        // EskaeraInfo-ko botoiak
        viewEskaeraInfo.jButtonEzabatu.addActionListener(this);
        viewEskaeraInfo.jButtonAldatu.addActionListener(this);
        viewEskaeraInfo.jButtonGehitu.addActionListener(this);
        viewEskaeraInfo.jButtonAldaketaGorde.addActionListener(this);
        viewEskaeraInfo.jButtonAldaketaEzabatu.addActionListener(this);
        
        // EskaeraGehitu-ko botoiak
        viewEskaeraGehitu.jButtonReset.addActionListener(this);
        viewEskaeraGehitu.jButtonGorde.addActionListener(this);
        viewEskaeraGehitu.jButtonBerriaGehitu.addActionListener(this);
         
        /* AncestorListener */
        viewProduktuaAukeratu.jPanelJerts.addAncestorListener(this);
        viewProduktuaAukeratu.jPanelKami.addAncestorListener(this);
        viewProduktuaAukeratu.jPanelPrak.addAncestorListener(this);
                
        /* MouseListener */
        viewDendaInfo.jButtonIrten.addMouseListener(this);
        viewDendaGehitu.jButtonIrten.addMouseListener(this);
        viewBezeroaInfo.jButtonIrten.addMouseListener(this);
        viewBezeroaGehitu.jButtonIrten.addMouseListener(this);
        viewLangileaInfo.jButtonIrten.addMouseListener(this);
        viewLangileaGehitu.jButtonIrten.addMouseListener(this);
        viewProduktuaAukeratu.jButtonIrten.addMouseListener(this);
        viewJertseaGehitu.jButtonIrten.addMouseListener(this);
        viewKamisetaGehitu.jButtonIrten.addMouseListener(this);
        viewPrakaGehitu.jButtonIrten.addMouseListener(this);
        viewHornitzaileaInfo.jButtonIrten.addMouseListener(this);
        viewHornitzaileaGehitu.jButtonIrten.addMouseListener(this);
        viewEskaeraInfo.jButtonIrten.addMouseListener(this);
        viewEskaeraGehitu.jButtonIrten.addMouseListener(this);
        
        /* ListSelectionListener */
        viewDendaInfo.jTableDendaInfo.getSelectionModel().addListSelectionListener(this);
        viewBezeroaInfo.jTableBezeroaInfo.getSelectionModel().addListSelectionListener(this);
        viewLangileaInfo.jTableLangileaInfo.getSelectionModel().addListSelectionListener(this);
        viewProduktuaAukeratu.jTableJertsInfo.getSelectionModel().addListSelectionListener(this);
        viewProduktuaAukeratu.jTableKamiInfo.getSelectionModel().addListSelectionListener(this);
        viewProduktuaAukeratu.jTablePrakInfo.getSelectionModel().addListSelectionListener(this);
        viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectionModel().addListSelectionListener(this);
        viewEskaeraInfo.jTableEskaeraInfo.getSelectionModel().addListSelectionListener(this);
        viewProduktuaAukeratu.jComboBoxAukeratuProd.getModel().addListDataListener(this);

        /* KeyListener */
        viewDendaInfo.jTextFieldBilatu.addKeyListener(this);
        viewBezeroaInfo.jTextFieldBilatu.addKeyListener(this);
        viewLangileaInfo.jTextFieldBilatu.addKeyListener(this);
        viewProduktuaAukeratu.jTextFieldBilatuJerts.addKeyListener(this);
        viewProduktuaAukeratu.jTextFieldBilatuKami.addKeyListener(this);
        viewProduktuaAukeratu.jTextFieldBilatuPrak.addKeyListener(this);
        viewHornitzaileaInfo.jTextFieldBilatu.addKeyListener(this);
        viewEskaeraInfo.jTextFieldBilatu.addKeyListener(this);
        
        /* FocusListener */
        // DendaInfo
        viewDendaInfo.jTextFieldKodeDend.addFocusListener(this);
        viewDendaInfo.jTextFieldIzena.addFocusListener(this);
        viewDendaInfo.jTextFieldHelbidea.addFocusListener(this);
        viewDendaInfo.jTextFieldHerria.addFocusListener(this);
        viewDendaInfo.jTextFieldPostKod.addFocusListener(this);
        viewDendaInfo.jTextFieldTlf.addFocusListener(this);
        viewDendaInfo.jTextFieldEmail.addFocusListener(this);
        
        // DendaGehitu
        viewDendaGehitu.jTextFieldIzena.addFocusListener(this);
        viewDendaGehitu.jTextFieldHelbidea.addFocusListener(this);
        viewDendaGehitu.jTextFieldHerria.addFocusListener(this);
        viewDendaGehitu.jTextFieldPostKod.addFocusListener(this);
        viewDendaGehitu.jTextFieldTlf.addFocusListener(this);
        viewDendaGehitu.jTextFieldEmail.addFocusListener(this);
        
        // BezeroaInfo
        viewBezeroaInfo.jTextFieldKodeBez.addFocusListener(this);
        viewBezeroaInfo.jTextFieldIzena.addFocusListener(this);
        viewBezeroaInfo.jTextFieldAbizena1.addFocusListener(this);
        viewBezeroaInfo.jTextFieldAbizena2.addFocusListener(this);
        viewBezeroaInfo.jTextFieldNan.addFocusListener(this);
//        viewBezeroaInfo.jDateChooserJaioData.addFocusListener(this);
//        viewBezeroaInfo.jRadioButtonEmak.addFocusListener(this);
//        viewBezeroaInfo.jRadioButtonGiz.addFocusListener(this);
        viewBezeroaInfo.jTextFieldHerria.addFocusListener(this);
        viewBezeroaInfo.jTextFieldTlf.addFocusListener(this);
        
        // BezeroaGehitu
        viewBezeroaGehitu.jTextFieldIzena.addFocusListener(this);
        viewBezeroaGehitu.jTextFieldAbizena1.addFocusListener(this);
        viewBezeroaGehitu.jTextFieldAbizena2.addFocusListener(this);
        viewBezeroaGehitu.jTextFieldNan.addFocusListener(this);
//        viewBezeroaGehitu.jDateChooserJaioData.addFocusListener(this);
//        viewBezeroaGehitu.jRadioButtonEmak.addFocusListener(this);
//        viewBezeroaGehitu.jRadioButtonGiz.addFocusListener(this);
        viewBezeroaGehitu.jTextFieldHerria.addFocusListener(this);
        viewBezeroaGehitu.jTextFieldTlf.addFocusListener(this);
        
        // LangileaInfo
        viewLangileaInfo.jTextFieldKodeLang.addFocusListener(this);
        viewLangileaInfo.jTextFieldIzena.addFocusListener(this);
        viewLangileaInfo.jTextFieldAbizena1.addFocusListener(this);
        viewLangileaInfo.jTextFieldAbizena2.addFocusListener(this);
        viewLangileaInfo.jTextFieldNan.addFocusListener(this);
//        viewLangileaInfo.jDateChooserJaioData.addFocusListener(this);
        viewLangileaInfo.jRadioButtonEmak.addFocusListener(this);
        viewLangileaInfo.jRadioButtonGiz.addFocusListener(this);
        viewLangileaInfo.jTextFieldHerria.addFocusListener(this);
        viewLangileaInfo.jTextFieldTlf.addFocusListener(this);
        viewLangileaInfo.jTextFieldSoldata.addFocusListener(this);
        viewLangileaInfo.jComboBoxEremua.addFocusListener(this);
        
        // LangileaGehitu
        viewLangileaGehitu.jTextFieldIzena.addFocusListener(this);
        viewLangileaGehitu.jTextFieldAbizena1.addFocusListener(this);
        viewLangileaGehitu.jTextFieldAbizena2.addFocusListener(this);
        viewLangileaGehitu.jTextFieldNan.addFocusListener(this);
//        viewLangileaGehitu.jDateChooserJaioData.addFocusListener(this);
//        viewLangileaGehitu.jRadioButtonEmak.addFocusListener(this);
//        viewLangileaGehitu.jRadioButtonGiz.addFocusListener(this);
        viewLangileaGehitu.jTextFieldHerria.addFocusListener(this);
        viewLangileaGehitu.jTextFieldTlf.addFocusListener(this);
        viewLangileaGehitu.jTextFieldSoldata.addFocusListener(this);
        viewLangileaGehitu.jComboBoxEremua.addFocusListener(this);
        
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
        viewHornitzaileaInfo.jTextFieldKodeHor.addFocusListener(this);
        viewHornitzaileaInfo.jTextFieldIzena.addFocusListener(this);
        viewHornitzaileaInfo.jTextFieldHerria.addFocusListener(this);
        viewHornitzaileaInfo.jTextFieldTlf.addFocusListener(this);
        viewHornitzaileaInfo.jTextFieldEmail.addFocusListener(this);
        
        // HornitzaileaGehitu
        viewHornitzaileaGehitu.jTextFieldIzena.addFocusListener(this);
        viewHornitzaileaGehitu.jTextFieldHerria.addFocusListener(this);
        viewHornitzaileaGehitu.jTextFieldTlf.addFocusListener(this);
        viewHornitzaileaGehitu.jTextFieldEmail.addFocusListener(this);
        
        // EskaeraInfo
        viewEskaeraInfo.jTextFieldKodeEsk.addFocusListener(this);
        viewEskaeraInfo.jComboBoxHornitzailea.addFocusListener(this);
        viewEskaeraInfo.jDateChooserData.addFocusListener(this);
        viewEskaeraInfo.jTextFieldKopurua.addFocusListener(this);
        
        // EskaeraGehitu
        viewEskaeraGehitu.jTextFieldKopurua.addFocusListener(this);
        viewEskaeraGehitu.jComboBoxHornitzailea.addFocusListener(this);
    }
    
    private void hasieratu() {
        /* BISTEN ESTILOA */
        menuNagEstiloa();
        dendInfoEstiloa();
        dendGehituEstiloa();
        bezInfoEstiloa();
        bezGehituEstiloa();
        langInfoEstiloa();
        langGehituEstiloa();
        prodInfoEstiloa();
        jertsGehituEstiloa();
        kamiGehituEstiloa();
        prakGehituEstiloa();
        hornInfoEstiloa();
        hornGehituEstiloa();
        eskInfoEstiloa();
        eskGehituEstiloa();  
        
        // tauletako estiloa
        viewDendaInfo.jTableDendaInfo.setShowGrid(false);
        viewDendaInfo.jTableDendaInfo.setShowHorizontalLines(true);
        viewBezeroaInfo.jTableBezeroaInfo.setShowGrid(false);
        viewBezeroaInfo.jTableBezeroaInfo.setShowHorizontalLines(true);
        viewLangileaInfo.jTableLangileaInfo.setShowGrid(false);
        viewLangileaInfo.jTableLangileaInfo.setShowHorizontalLines(true);
        viewProduktuaAukeratu.jTableJertsInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTableJertsInfo.setShowHorizontalLines(true);
        viewProduktuaAukeratu.jTableKamiInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTableKamiInfo.setShowHorizontalLines(true);
        viewProduktuaAukeratu.jTablePrakInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTablePrakInfo.setShowHorizontalLines(true);
        viewHornitzaileaInfo.jTableHornitzaileaInfo.setShowGrid(false);
        viewHornitzaileaInfo.jTableHornitzaileaInfo.setShowHorizontalLines(true);
        viewEskaeraInfo.jTableEskaeraInfo.setShowGrid(false);
        viewEskaeraInfo.jTableEskaeraInfo.setShowHorizontalLines(true);

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
        viewDendaInfo.jTextFieldKodeDend.setEditable(false);
        viewBezeroaInfo.jTextFieldKodeBez.setEditable(false);
        viewLangileaInfo.jTextFieldKodeLang.setEditable(false);
        viewProduktuaAukeratu.jTextFieldKodeJerts.setEditable(false);
        viewProduktuaAukeratu.jTextFieldKodeKami.setEditable(false);
        viewProduktuaAukeratu.jTextFieldKodePrak.setEditable(false);
        viewHornitzaileaInfo.jTextFieldKodeHor.setEditable(false);
        viewEskaeraInfo.jTextFieldKodeEsk.setEditable(false);   
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
    
    private void dendInfoEstiloa() {
        viewDendaInfo.setTitle("Dendaren informazioa");
        viewDendaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewDendaInfo.setLocationRelativeTo(null);
        viewDendaInfo.jButtonIrten.setBackground(urdina);
        viewDendaInfo.jButtonIrten.setForeground(Color.WHITE);
        viewDendaInfo.jTextFieldKodeDend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewDendaInfo.jTextFieldBilatu.setOpaque(false);
        viewDendaInfo.jTextFieldKodeDend.setOpaque(false);
        viewDendaInfo.jTextFieldIzena.setOpaque(false);
        viewDendaInfo.jTextFieldHelbidea.setOpaque(false);
        viewDendaInfo.jTextFieldHerria.setOpaque(false);
        viewDendaInfo.jTextFieldPostKod.setOpaque(false);
        viewDendaInfo.jTextFieldTlf.setOpaque(false);
        viewDendaInfo.jTextFieldEmail.setOpaque(false);

        viewDendaInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewDendaInfo.jPanelGoiburua.setOpaque(false);
        viewDendaInfo.jPanelOina.setOpaque(false);
        viewDendaInfo.jPanelDendDatuak.setOpaque(false);
        viewDendaInfo.jPanelDendTaula.setOpaque(false);
        
        viewDendaInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewDendaInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewDendaInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewDendaInfo.jButtonAldaketaGorde.setToolTipText("Gorde");
    }
    
    private void dendGehituEstiloa() {
        viewDendaGehitu.setTitle("Denda berria");
        viewDendaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewDendaGehitu.setLocationRelativeTo(null);
        viewDendaGehitu.jButtonIrten.setBackground(urdina);
        viewDendaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        viewDendaGehitu.jTextFieldIzena.setOpaque(false);
        viewDendaGehitu.jTextFieldHelbidea.setOpaque(false);
        viewDendaGehitu.jTextFieldHerria.setOpaque(false);
        viewDendaGehitu.jTextFieldPostKod.setOpaque(false);
        viewDendaGehitu.jTextFieldTlf.setOpaque(false);
        viewDendaGehitu.jTextFieldEmail.setOpaque(false);
        viewDendaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewDendaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewDendaGehitu.jPanelGoiburua.setOpaque(false);
        viewDendaGehitu.jPanelDendDatuak.setOpaque(false);
    }
    
    private void bezInfoEstiloa() {
        viewBezeroaInfo.setTitle("Bezeroen informazioa");
        viewBezeroaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewBezeroaInfo.setLocationRelativeTo(null);
        viewBezeroaInfo.jButtonIrten.setBackground(urdina);
        viewBezeroaInfo.jButtonIrten.setForeground(Color.WHITE);
        viewBezeroaInfo.jTextFieldKodeBez.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewBezeroaInfo.jTextFieldKodeBez.setOpaque(false);
        viewBezeroaInfo.jTextFieldIzena.setOpaque(false);
        viewBezeroaInfo.jTextFieldAbizena1.setOpaque(false);
        viewBezeroaInfo.jTextFieldAbizena2.setOpaque(false);
        viewBezeroaInfo.jTextFieldHerria.setOpaque(false);
        viewBezeroaInfo.jDateChooserJaioData.setOpaque(false);
        viewBezeroaInfo.jRadioButtonEmak.setOpaque(false);
        viewBezeroaInfo.jRadioButtonGiz.setOpaque(false);
        viewBezeroaInfo.jTextFieldNan.setOpaque(false);
        viewBezeroaInfo.jTextFieldTlf.setOpaque(false);

        viewBezeroaInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewBezeroaInfo.jPanelGoiburua.setOpaque(false);
        viewBezeroaInfo.jPanelOina.setOpaque(false);
        viewBezeroaInfo.jPanelBezDatuak.setOpaque(false);
        viewBezeroaInfo.jPanelBezTaula.setOpaque(false);
        
        viewBezeroaInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewBezeroaInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewBezeroaInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewBezeroaInfo.jButtonAldaketaGorde.setToolTipText("Gorde");
    }
 
    private void bezGehituEstiloa() {
        viewBezeroaGehitu.setTitle("Bezero berria");
        viewBezeroaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewBezeroaGehitu.setLocationRelativeTo(null);
        viewBezeroaGehitu.jButtonIrten.setBackground(urdina);
        viewBezeroaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
        viewBezeroaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
        
        viewBezeroaGehitu.jTextFieldIzena.setOpaque(false);
        viewBezeroaGehitu.jTextFieldAbizena1.setOpaque(false);
        viewBezeroaGehitu.jTextFieldAbizena2.setOpaque(false);
        viewBezeroaGehitu.jTextFieldHerria.setOpaque(false);
        viewBezeroaGehitu.jDateChooserJaioData.setOpaque(false);
        viewBezeroaGehitu.jRadioButtonEmak.setOpaque(false);
        viewBezeroaGehitu.jRadioButtonGiz.setOpaque(false);
        viewBezeroaGehitu.jTextFieldNan.setOpaque(false);
        viewBezeroaGehitu.jTextFieldTlf.setOpaque(false);
        viewBezeroaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewBezeroaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewBezeroaGehitu.jPanelGoiburua.setOpaque(false);
        viewBezeroaGehitu.jPanelBezDatuak.setOpaque(false);
    }
    
    private void langInfoEstiloa() {
        viewLangileaInfo.setTitle("Langileen informazioa");
        viewLangileaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewLangileaInfo.setLocationRelativeTo(null);
        viewLangileaInfo.jButtonIrten.setBackground(urdina);
        viewLangileaInfo.jButtonIrten.setForeground(Color.WHITE);
        viewLangileaInfo.jTextFieldKodeLang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewLangileaInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewLangileaInfo.jTextFieldKodeLang.setOpaque(false);
        viewLangileaInfo.jTextFieldIzena.setOpaque(false);
        viewLangileaInfo.jTextFieldAbizena1.setOpaque(false);
        viewLangileaInfo.jTextFieldAbizena2.setOpaque(false);
        viewLangileaInfo.jTextFieldHerria.setOpaque(false);
        viewLangileaInfo.jDateChooserJaioData.setOpaque(false);
        viewLangileaInfo.jRadioButtonEmak.setOpaque(false);
        viewLangileaInfo.jRadioButtonGiz.setOpaque(false);
        viewLangileaInfo.jTextFieldNan.setOpaque(false);
        viewLangileaInfo.jTextFieldTlf.setOpaque(false);
        viewLangileaInfo.jTextFieldSoldata.setOpaque(false);
        viewLangileaInfo.jComboBoxEremua.setOpaque(false);
        
        viewLangileaInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewLangileaInfo.jPanelGoiburua.setOpaque(false);
        viewLangileaInfo.jPanelOina.setOpaque(false);
        viewLangileaInfo.jPanelLangDatuak.setOpaque(false);
        viewLangileaInfo.jPanelLangTaula.setOpaque(false);
        
        viewLangileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewLangileaInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewLangileaInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewLangileaInfo.jButtonAldaketaGorde.setToolTipText("Gorde");
    }
    
    private void langGehituEstiloa() {
        viewLangileaGehitu.setTitle("Langile berria");
        viewLangileaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewLangileaGehitu.setLocationRelativeTo(null);
        viewLangileaGehitu.jButtonIrten.setBackground(urdina);
        viewLangileaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY)); 
        viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewLangileaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
        viewLangileaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
        
        viewLangileaGehitu.jTextFieldIzena.setOpaque(false);
        viewLangileaGehitu.jTextFieldAbizena1.setOpaque(false);
        viewLangileaGehitu.jTextFieldAbizena2.setOpaque(false);
        viewLangileaGehitu.jTextFieldHerria.setOpaque(false);
        viewLangileaGehitu.jDateChooserJaioData.setOpaque(false);
        viewLangileaGehitu.jRadioButtonEmak.setOpaque(false);
        viewLangileaGehitu.jRadioButtonGiz.setOpaque(false);
        viewLangileaGehitu.jTextFieldNan.setOpaque(false);
        viewLangileaGehitu.jTextFieldTlf.setOpaque(false);
        viewLangileaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewLangileaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewLangileaGehitu.jPanelGoiburua.setOpaque(false);
        viewLangileaGehitu.jPanelLangDatuak.setOpaque(false);
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
    
    private void hornInfoEstiloa() {
        viewHornitzaileaInfo.setTitle("Hornitzaileen informazioa");
        viewHornitzaileaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewHornitzaileaInfo.setLocationRelativeTo(null);
        viewHornitzaileaInfo.jButtonIrten.setBackground(urdina);
        viewHornitzaileaInfo.jButtonIrten.setForeground(Color.WHITE);
        viewHornitzaileaInfo.jTextFieldKodeHor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewHornitzaileaInfo.jTextFieldKodeHor.setOpaque(false);
        viewHornitzaileaInfo.jTextFieldIzena.setOpaque(false);
        viewHornitzaileaInfo.jTextFieldHerria.setOpaque(false);
        viewHornitzaileaInfo.jTextFieldEmail.setOpaque(false);
        viewHornitzaileaInfo.jTextFieldTlf.setOpaque(false);
        
        viewHornitzaileaInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewHornitzaileaInfo.jPanelGoiburua.setOpaque(false);
        viewHornitzaileaInfo.jPanelOina.setOpaque(false);
        viewHornitzaileaInfo.jPanelHornDatuak.setOpaque(false);
        viewHornitzaileaInfo.jPanelHornInfoTaula.setOpaque(false);
        
        viewHornitzaileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewHornitzaileaInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewHornitzaileaInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewHornitzaileaInfo.jButtonAldaketaGorde.setToolTipText("Gorde");
    }
    
    private void hornGehituEstiloa() {
        viewHornitzaileaGehitu.setTitle("Hornitzaile berria");
        viewHornitzaileaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewHornitzaileaGehitu.setLocationRelativeTo(null);
        viewHornitzaileaGehitu.jButtonIrten.setBackground(urdina);
        viewHornitzaileaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewHornitzaileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        viewHornitzaileaGehitu.jTextFieldIzena.setOpaque(false);
        viewHornitzaileaGehitu.jTextFieldHerria.setOpaque(false);
        viewHornitzaileaGehitu.jTextFieldTlf.setOpaque(false);
        viewHornitzaileaGehitu.jTextFieldEmail.setOpaque(false);
        viewHornitzaileaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewHornitzaileaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewHornitzaileaGehitu.jPanelGoiburua.setOpaque(false);
        viewHornitzaileaGehitu.jPanelHornDatuak.setOpaque(false);
    }
    
    private void eskInfoEstiloa() {
        viewEskaeraInfo.setTitle("Eskaeren informazioa");
        viewEskaeraInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewEskaeraInfo.setLocationRelativeTo(null);
        viewEskaeraInfo.jButtonIrten.setBackground(urdina);
        viewEskaeraInfo.jButtonIrten.setForeground(Color.WHITE);
        viewEskaeraInfo.jTextFieldKodeEsk.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewEskaeraInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));

        viewEskaeraInfo.jTextFieldKodeEsk.setOpaque(false);
        viewEskaeraInfo.jComboBoxHornitzailea.setOpaque(false);
        viewEskaeraInfo.jTextFieldKopurua.setOpaque(false);
        
        viewEskaeraInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewEskaeraInfo.jPanelGoiburua.setOpaque(false);
        viewEskaeraInfo.jPanelOina.setOpaque(false);
        viewEskaeraInfo.jPanelEskDatuak.setOpaque(false);
        viewEskaeraInfo.jPanelEskInfoTaula.setOpaque(false);
        
        viewEskaeraInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewEskaeraInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewEskaeraInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewEskaeraInfo.jButtonAldaketaGorde.setToolTipText("Gorde");
    }
    
    private void eskGehituEstiloa() {
        viewEskaeraGehitu.setTitle("Eskaera berria");
        viewEskaeraGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewEskaeraGehitu.setLocationRelativeTo(null);
        viewEskaeraGehitu.jButtonIrten.setBackground(urdina);
        viewEskaeraGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
       
        viewEskaeraGehitu.jTextFieldKopurua.setOpaque(false);
        viewEskaeraGehitu.jComboBoxHornitzailea.setOpaque(false);
        viewEskaeraGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewEskaeraGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewEskaeraGehitu.jPanelGoiburua.setOpaque(false);
        viewEskaeraGehitu.jPanelEskDatuak.setOpaque(false);
    }
        
    /* METODOAK */
    private void bezDatuakErakutsiTaula(ArrayList<Bezeroa> bezGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
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
    
    private void resetDendaGehitu() {
        viewDendaGehitu.jTextFieldIzena.setText(null);
        viewDendaGehitu.jTextFieldHelbidea.setText(null);
        viewDendaGehitu.jTextFieldHerria.setText(null);
        viewDendaGehitu.jTextFieldPostKod.setText(null);
        viewDendaGehitu.jTextFieldTlf.setText(null);
        viewDendaGehitu.jTextFieldEmail.setText(null);
        
        viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
    
    private void resetBezeroaGehitu() {
        viewBezeroaGehitu.jTextFieldIzena.setText(null);
        viewBezeroaGehitu.jTextFieldAbizena1.setText(null);
        viewBezeroaGehitu.jTextFieldAbizena2.setText(null);
        viewBezeroaGehitu.jTextFieldNan.setText(null);
        viewBezeroaGehitu.jDateChooserJaioData.setDate(null);
        viewBezeroaGehitu.jRadioButtonEmak.setSelected(false);
        viewBezeroaGehitu.jRadioButtonGiz.setSelected(false);
        viewBezeroaGehitu.jTextFieldHerria.setText(null);
        viewBezeroaGehitu.jTextFieldTlf.setText(null);
        
        viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
        viewBezeroaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
    }
    
    private void resetLangileaGehitu() {
        viewLangileaGehitu.jTextFieldIzena.setText(null);
        viewLangileaGehitu.jTextFieldAbizena1.setText(null);
        viewLangileaGehitu.jTextFieldAbizena2.setText(null);
        viewLangileaGehitu.jTextFieldNan.setText(null);
        viewLangileaGehitu.jDateChooserJaioData.setDate(null);
        viewLangileaGehitu.jRadioButtonEmak.setSelected(false);
        viewLangileaGehitu.jRadioButtonGiz.setSelected(false);
        viewLangileaGehitu.jTextFieldHerria.setText(null);
        viewLangileaGehitu.jTextFieldTlf.setText(null);
        viewLangileaGehitu.jTextFieldSoldata.setText(null);
        viewLangileaGehitu.jComboBoxEremua.setSelectedIndex(0);

        viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY)); 
        viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewLangileaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
        viewLangileaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
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
    
    private void resetHornitzaileaGehitu() {
        viewHornitzaileaGehitu.jTextFieldIzena.setText(null);
        viewHornitzaileaGehitu.jTextFieldHerria.setText(null);
        viewHornitzaileaGehitu.jTextFieldTlf.setText(null);
        viewHornitzaileaGehitu.jTextFieldEmail.setText(null);
        
        viewHornitzaileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
    
    private void resetEskaeraGehitu() {
        viewEskaeraGehitu.jComboBoxHornitzailea.setSelectedIndex(0);
        viewEskaeraGehitu.jTextFieldKopurua.setText(null);
        
        viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
    
    private void enableComponets (Container container, boolean bool) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                component.setEnabled(bool);
            }
        }
    }

    private void aukDendDatuakBete(int aukLerroa) {
        viewDendaInfo.jTextFieldKodeDend.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 0)));
        viewDendaInfo.jTextFieldIzena.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 1)));
        viewDendaInfo.jTextFieldHelbidea.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 2)));
        viewDendaInfo.jTextFieldHerria.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 3)));
        viewDendaInfo.jTextFieldPostKod.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 4)));
        viewDendaInfo.jTextFieldTlf.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 5)));
        viewDendaInfo.jTextFieldEmail.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 6)));
    }
    
    private void aukBezDatuakBete(int aukLerroa) {    
        viewBezeroaInfo.jTextFieldKodeBez.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 0)));
        viewBezeroaInfo.jTextFieldIzena.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 1)));
        viewBezeroaInfo.jTextFieldAbizena1.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 2)));
        viewBezeroaInfo.jTextFieldAbizena2.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 3)));
        viewBezeroaInfo.jTextFieldNan.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 4)));
        viewBezeroaInfo.jDateChooserJaioData.setDate(Metodoak.dataErakutsi(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 5))));
        String aukSexuaRB = String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 6)).toLowerCase();
        if (aukSexuaRB.equals("emakumea")) {
            viewBezeroaInfo.jRadioButtonEmak.setSelected(true);
        }
        else if (aukSexuaRB.equals("gizona")) {
            viewBezeroaInfo.jRadioButtonGiz.setSelected(true);
        }
        viewBezeroaInfo.jTextFieldHerria.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 7)));
        viewBezeroaInfo.jTextFieldTlf.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 8)));
    }
    
    private void resetDendaInfo() {
        viewDendaInfo.jTextFieldKodeDend.setText(null);
        viewDendaInfo.jTextFieldIzena.setText(null);
        viewDendaInfo.jTextFieldHelbidea.setText(null);
        viewDendaInfo.jTextFieldHerria.setText(null);
        viewDendaInfo.jTextFieldPostKod.setText(null);
        viewDendaInfo.jTextFieldTlf.setText(null);  
        viewDendaInfo.jTextFieldEmail.setText(null);
    }
    
    private void resetBezeroaInfo() {
        viewBezeroaInfo.jTextFieldKodeBez.setText(null);
        viewBezeroaInfo.jTextFieldIzena.setText(null);
        viewBezeroaInfo.jTextFieldAbizena1.setText(null);
        viewBezeroaInfo.jTextFieldAbizena2.setText(null);
        viewBezeroaInfo.jTextFieldNan.setText(null);
        viewBezeroaInfo.jDateChooserJaioData.setDate(null);
        viewBezeroaInfo.jRadioButtonEmak.setSelected(false);
        viewBezeroaInfo.jRadioButtonGiz.setSelected(false);
        viewBezeroaInfo.jTextFieldHerria.setText(null);
        viewBezeroaInfo.jTextFieldTlf.setText(null);  
    }
    
    private void aukLangDatuakBete(int aukLerroa) { 
        viewLangileaInfo.jTextFieldKodeLang.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 0)));
        viewLangileaInfo.jTextFieldIzena.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 1)));
        viewLangileaInfo.jTextFieldAbizena1.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 2)));
        viewLangileaInfo.jTextFieldAbizena2.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 3)));
        viewLangileaInfo.jTextFieldNan.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 4)));
        viewLangileaInfo.jDateChooserJaioData.setDate(Metodoak.dataErakutsi(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 5))));
        System.out.println(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 5)));
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
        viewLangileaInfo.jComboBoxEremua.setSelectedItem(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 10)));
    }
    
    private void resetLangileaInfo() {
        viewLangileaInfo.jTextFieldKodeLang.setText(null);
        viewLangileaInfo.jTextFieldIzena.setText(null);
        viewLangileaInfo.jTextFieldAbizena1.setText(null);
        viewLangileaInfo.jTextFieldAbizena2.setText(null);
        viewLangileaInfo.jTextFieldNan.setText(null);
        viewLangileaInfo.jDateChooserJaioData.setDate(null);
        viewLangileaInfo.jRadioButtonEmak.setSelected(false);
        viewLangileaInfo.jRadioButtonGiz.setSelected(false);
        viewLangileaInfo.jTextFieldHerria.setText(null);
        viewLangileaInfo.jTextFieldTlf.setText(null);
        viewLangileaInfo.jTextFieldSoldata.setText(null);
        viewLangileaInfo.jComboBoxEremua.setSelectedItem(null);      
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
    
    private void aukHornDatuakBete(int aukLerroa) {
        viewHornitzaileaInfo.jTextFieldKodeHor.setText(String.valueOf(viewHornitzaileaInfo.jTableHornitzaileaInfo.getModel().getValueAt(aukLerroa, 0)));
        viewHornitzaileaInfo.jTextFieldIzena.setText(String.valueOf(viewHornitzaileaInfo.jTableHornitzaileaInfo.getModel().getValueAt(aukLerroa, 1)));
        viewHornitzaileaInfo.jTextFieldHerria.setText(String.valueOf(viewHornitzaileaInfo.jTableHornitzaileaInfo.getModel().getValueAt(aukLerroa, 2)));
        viewHornitzaileaInfo.jTextFieldTlf.setText(String.valueOf(viewHornitzaileaInfo.jTableHornitzaileaInfo.getModel().getValueAt(aukLerroa, 3)));
        viewHornitzaileaInfo.jTextFieldEmail.setText(String.valueOf(viewHornitzaileaInfo.jTableHornitzaileaInfo.getModel().getValueAt(aukLerroa, 4)));
    }
    
    private void resetHornInfo() {
        viewHornitzaileaInfo.jTextFieldKodeHor.setText(null);
        viewHornitzaileaInfo.jTextFieldIzena.setText(null);
        viewHornitzaileaInfo.jTextFieldHerria.setText(null);
        viewHornitzaileaInfo.jTextFieldTlf.setText(null);
        viewHornitzaileaInfo.jTextFieldEmail.setText(null);
    }
    
    private void aukEskDatuakBete(int aukLerroa) { 
        viewEskaeraInfo.jTextFieldKodeEsk.setText(String.valueOf(viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 0)));
        viewEskaeraInfo.jComboBoxHornitzailea.setSelectedItem(String.valueOf(viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 1)));
        viewEskaeraInfo.jDateChooserData.setDate(Metodoak.dataErakutsi(String.valueOf(viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 2))));
        viewEskaeraInfo.jTextFieldKopurua.setText(String.valueOf(viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 3)));
    }
    
    private void resetEskInfo() {
        viewEskaeraInfo.jTextFieldKodeEsk.setText(null);
        viewEskaeraInfo.jComboBoxHornitzailea.setSelectedItem(null);
        viewEskaeraInfo.jDateChooserData.setDate(null);
        viewEskaeraInfo.jTextFieldKopurua.setText(null); 
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
        
        /* DendaInfo-ko aukerak */
        else if (comando == viewDendaInfo.jButtonGehitu) {
            viewDendaGehitu.setVisible(true);
            viewDendaInfo.setEnabled(false);
            enableComponets(viewDendaGehitu.jPanelDendDatuak, false);
        }
        else if (comando == viewDendaInfo.jButtonIrten) {
            viewDendaInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (comando == viewDendaInfo.jButtonEzabatu) {
            int aukLerroa = viewDendaInfo.jTableDendaInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(null, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String kodea = (String) viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako bezeroaren nan zenbakia lortu
                    DendaKudeatu.dendaEzabatu(kodea);
                }
                dendDatuakErakutsiTaula(DendaKudeatu.dendGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da dendarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewDendaInfo.jButtonAldatu) {
            if (viewDendaInfo.jTableDendaInfo.getSelectedRow()!=-1) {
                enableComponets(viewDendaInfo.jPanelDendDatuak, true);
                enableComponets(viewDendaInfo.jPanelOina, false);
                viewDendaInfo.jButtonAldaketaGorde.setEnabled(true);
                viewDendaInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da dendarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewDendaInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                enableComponets(viewDendaInfo.jPanelDendDatuak, false);
                enableComponets(viewDendaInfo.jPanelOina, true);
                viewDendaInfo.jButtonAldaketaGorde.setEnabled(false);
                viewDendaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetDendInfoErr();
                aukDendDatuakBete(viewDendaInfo.jTableDendaInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewDendaInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaDendaInfo()) {
                    int aukLerroa = viewDendaInfo.jTableDendaInfo.getSelectedRow();
                    String kodea = (String) viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako bezeroaren nan zenbakia lortu
                    DendaKudeatu.dendaEzabatu(kodea);
                    Denda d = new Denda(viewDendaInfo.jTextFieldKodeDend.getText(), viewDendaInfo.jTextFieldIzena.getText(), 
                            viewDendaInfo.jTextFieldHelbidea.getText(), viewDendaInfo.jTextFieldHerria.getText(), 
                            Integer.parseInt(viewDendaInfo.jTextFieldPostKod.getText()), 
                            viewDendaInfo.jTextFieldTlf.getText(), viewDendaInfo.jTextFieldEmail.getText());
                    DendaKudeatu.dendaGehitu(d);
                    dendDatuakErakutsiTaula(DendaKudeatu.dendGuztiakErakutsi());
                    enableComponets(viewDendaInfo.jPanelDendDatuak, false);
                    enableComponets(viewDendaInfo.jPanelOina, true);
                    viewDendaInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewDendaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
            }
        } 
        
        /* DendaGehitu-ko aukerak */
        else if (comando == viewDendaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewDendaGehitu.jPanelDendDatuak, true);
        }
        else if (comando == viewDendaGehitu.jButtonGorde) {
            if (balidazioaDendaGehitu()) {
                try {
                    Denda d = new Denda(viewDendaGehitu.jTextFieldIzena.getText(), viewDendaGehitu.jTextFieldHelbidea.getText(), 
                        viewDendaGehitu.jTextFieldHerria.getText(), Integer.parseInt(viewDendaGehitu.jTextFieldPostKod.getText()), 
                        viewDendaGehitu.jTextFieldTlf.getText(), viewDendaGehitu.jTextFieldEmail.getText());
                    d.printDatuak();
                    DendaKudeatu.dendaGehitu(d);
                }
                catch (Exception ex) {
                    // fitxategia ez bada existitzen, errorea ematen  du.
                }
                resetDendaGehitu();
                enableComponets(viewDendaGehitu.jPanelDendDatuak, false);
            }
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewDendaGehitu.jButtonReset) {
            resetDendaGehitu();
        }
        else if (comando == viewDendaGehitu.jButtonIrten) {
            resetDendaGehitu();
            viewDendaGehitu.dispose();
            viewDendaInfo.setEnabled(true);
            dendDatuakErakutsiTaula(DendaKudeatu.dendGuztiakErakutsi());
        }
        
        /* BezeroaInfo-ko aukerak */
        else if (comando == viewBezeroaInfo.jButtonGehitu) {
            viewBezeroaGehitu.setVisible(true);
            viewBezeroaInfo.setEnabled(false);
            enableComponets(viewBezeroaGehitu.jPanelBezDatuak, false);
        } 
        else if (comando == viewBezeroaInfo.jButtonIrten) {
            viewBezeroaInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (comando == viewBezeroaInfo.jButtonEzabatu) {
            int aukLerroa = viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(viewBezeroaInfo.jDialogEzabatuKonfirm, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String nan = (String) viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako bezeroaren nan zenbakia lortu
                    BezeroaKudeatu.bezeroaEzabatu(nan);
                }
                bezDatuakErakutsiTaula(BezeroaKudeatu.bezeroGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da bezerorik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewBezeroaInfo.jButtonAldatu) {
            if (viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow()!=-1) {
                enableComponets(viewBezeroaInfo.jPanelBezDatuak, true);
                enableComponets(viewBezeroaInfo.jPanelOina, false);
                viewBezeroaInfo.jButtonAldaketaGorde.setEnabled(true);
                viewBezeroaInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da bezerorik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewBezeroaInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                enableComponets(viewBezeroaInfo.jPanelBezDatuak, false);
                enableComponets(viewBezeroaInfo.jPanelOina, true);
                viewBezeroaInfo.jButtonAldaketaGorde.setEnabled(false);
                viewBezeroaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetBezInfoErr();
                aukBezDatuakBete(viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewBezeroaInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaBezInfo()) {
                    /* Bezeroa ezabatu */
                    int aukLerroa = viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow();
                    String nan = (String) viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako bezeroaren nan zenbakia lortu
                    BezeroaKudeatu.bezeroaEzabatu(nan);
                    /* Bezeroa gehitu */
                    String sexuaRB = ""; // RadioButton-aren balioa gorde
                    if (viewBezeroaInfo.jRadioButtonEmak.isSelected()) {
                        sexuaRB = viewBezeroaInfo.jRadioButtonEmak.getText();
                    }
                    else if (viewBezeroaInfo.jRadioButtonGiz.isSelected()) {
                        sexuaRB = viewBezeroaInfo.jRadioButtonGiz.getText();
                    }
                    Bezeroa bez = new Bezeroa(viewBezeroaInfo.jTextFieldKodeBez.getText(), viewBezeroaInfo.jTextFieldIzena.getText(), 
                            viewBezeroaInfo.jTextFieldAbizena1.getText(), viewBezeroaInfo.jTextFieldAbizena2.getText(), 
                            viewBezeroaInfo.jTextFieldNan.getText(), Metodoak.dataGorde(viewBezeroaInfo.jDateChooserJaioData.getDate()), 
                            sexuaRB, viewBezeroaInfo.jTextFieldHerria.getText(), viewBezeroaInfo.jTextFieldTlf.getText());
                    BezeroaKudeatu.bezeroaGehitu(bez);

                    bezDatuakErakutsiTaula(BezeroaKudeatu.bezeroGuztiakErakutsi());
                    enableComponets(viewBezeroaInfo.jPanelBezDatuak, false);
                    enableComponets(viewBezeroaInfo.jPanelOina, true);
                    viewBezeroaInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewBezeroaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente 
            }           
        }
        
        /* BezeroaGehitu-ko aukerak */
        else if (comando == viewBezeroaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewBezeroaGehitu.jPanelBezDatuak, true);
        }
        else if (comando == viewBezeroaGehitu.jButtonGorde) {
            if (balidazioaBezGehitu()) {
                String sexuaRB = ""; // RadioButton-aren balioa gorde
                if (viewBezeroaGehitu.jRadioButtonEmak.isSelected()) {
                    sexuaRB = viewBezeroaGehitu.jRadioButtonEmak.getText();
                }
                else if (viewBezeroaGehitu.jRadioButtonGiz.isSelected()) {
                    sexuaRB = viewBezeroaGehitu.jRadioButtonGiz.getText();
                }
                Bezeroa bez = new Bezeroa(viewBezeroaGehitu.jTextFieldIzena.getText(), viewBezeroaGehitu.jTextFieldAbizena1.getText(), 
                        viewBezeroaGehitu.jTextFieldAbizena2.getText(), viewBezeroaGehitu.jTextFieldNan.getText(), Metodoak.dataGorde(viewBezeroaGehitu.jDateChooserJaioData.getDate()), 
                        sexuaRB, viewBezeroaGehitu.jTextFieldHerria.getText(), viewBezeroaGehitu.jTextFieldTlf.getText());
                BezeroaKudeatu.bezeroaGehitu(bez);
                resetBezeroaGehitu();
                enableComponets(viewBezeroaGehitu.jPanelBezDatuak, false);
            }
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewBezeroaGehitu.jButtonReset) {
            resetBezeroaGehitu();
        }
        else if (comando == viewBezeroaGehitu.jButtonIrten) {
            resetBezeroaGehitu();
            viewBezeroaGehitu.dispose();
            viewBezeroaInfo.setEnabled(true);
            bezDatuakErakutsiTaula(BezeroaKudeatu.bezeroGuztiakErakutsi());
        }
        
        /* LangileaInfo-ko aukerak */
        else if (comando == viewLangileaInfo.jButtonGehitu) {
            viewLangileaGehitu.setVisible(true);
            viewLangileaInfo.setEnabled(false);
            enableComponets(viewLangileaGehitu.jPanelLangDatuak, false);
        }
        else if (comando == viewLangileaInfo.jButtonIrten) {
            viewLangileaInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (comando == viewLangileaInfo.jButtonEzabatu) {
            int aukLerroa = viewLangileaInfo.jTableLangileaInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(viewLangileaInfo.jDialogEzabatuKonfirm, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String nan = (String) viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako langilearen nan zenbakia lortu
                    LangileaKudeatu.langileaEzabatu(nan);
                }
                langDatuakErakutsiTaula(LangileaKudeatu.langileGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(viewLangileaInfo.jDialogEzabatuKonfirm, "Ez da langilerik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewLangileaInfo.jButtonAldatu) {
            if (viewLangileaInfo.jTableLangileaInfo.getSelectedRow()!=-1) {
                enableComponets(viewLangileaInfo.jPanelLangDatuak, true);
                enableComponets(viewLangileaInfo.jPanelOina, false);
                viewLangileaInfo.jButtonAldaketaGorde.setEnabled(true);
                viewLangileaInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da langilerik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            } 
        }
        else if (comando == viewLangileaInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                enableComponets(viewLangileaInfo.jPanelLangDatuak, false);
                enableComponets(viewLangileaInfo.jPanelOina, true);
                viewLangileaInfo.jButtonAldaketaGorde.setEnabled(false);
                viewLangileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetLangInfoErr();
                aukLangDatuakBete(viewLangileaInfo.jTableLangileaInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewLangileaInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                int aukLerroa = viewLangileaInfo.jTableLangileaInfo.getSelectedRow(); // aukeratutako lerroa
                if (balidazioaLangInfo()) {
                    /* Langilea ezabatu */
                    String nan = (String) viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako langilearen nan zenbakia lortu
                    LangileaKudeatu.langileaEzabatu(nan);

                    /* Langilea gorde */
                    String sexuaRB = ""; // RadioButton-aren balioa gorde
                    if (viewLangileaInfo.jRadioButtonEmak.isSelected()) {
                        sexuaRB = viewLangileaInfo.jRadioButtonEmak.getText();
                    }
                    else if (viewLangileaInfo.jRadioButtonGiz.isSelected()) {
                        sexuaRB = viewLangileaInfo.jRadioButtonGiz.getText();
                    }
                    Langilea lang = new Langilea(viewLangileaInfo.jTextFieldKodeLang.getText(), viewLangileaInfo.jTextFieldIzena.getText(), 
                            viewLangileaInfo.jTextFieldAbizena1.getText(), viewLangileaInfo.jTextFieldAbizena2.getText(), 
                            viewLangileaInfo.jTextFieldNan.getText(), Metodoak.dataGorde(viewLangileaInfo.jDateChooserJaioData.getDate()), 
                            sexuaRB, viewLangileaInfo.jTextFieldHerria.getText(), viewLangileaInfo.jTextFieldTlf.getText(), 
                            Double.parseDouble(viewLangileaInfo.jTextFieldSoldata.getText()), viewLangileaInfo.jComboBoxEremua.getSelectedItem().toString());
                    LangileaKudeatu.langileaGehitu(lang);

                    langDatuakErakutsiTaula(LangileaKudeatu.langileGuztiakErakutsi());
                    enableComponets(viewLangileaInfo.jPanelLangDatuak, false);
                    enableComponets(viewLangileaInfo.jPanelOina, true);
                    viewLangileaInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewLangileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
            }
        }
        
        /* LangileaGehitu-ko aukerak */
        else if (comando == viewLangileaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewLangileaGehitu.jPanelLangDatuak, true);
        }
        else if (comando == viewLangileaGehitu.jButtonGorde) {
            if (balidazioaLangGehitu()) {
                String sexuaRB = ""; // RadioButton-aren balioa gorde
                if (viewLangileaGehitu.jRadioButtonEmak.isSelected()) {
                    sexuaRB = viewLangileaGehitu.jRadioButtonEmak.getText();
                }
                else if (viewLangileaGehitu.jRadioButtonGiz.isSelected()) {
                    sexuaRB = viewLangileaGehitu.jRadioButtonGiz.getText();
                }

                Langilea lang = new Langilea(viewLangileaGehitu.jTextFieldIzena.getText(), viewLangileaGehitu.jTextFieldAbizena1.getText(), 
                        viewLangileaGehitu.jTextFieldAbizena2.getText(), viewLangileaGehitu.jTextFieldNan.getText(),  Metodoak.dataGorde(viewLangileaGehitu.jDateChooserJaioData.getDate()), 
                        sexuaRB, viewLangileaGehitu.jTextFieldHerria.getText(), viewLangileaGehitu.jTextFieldTlf.getText(), 
                        Double.parseDouble(viewLangileaGehitu.jTextFieldSoldata.getText()), viewLangileaGehitu.jComboBoxEremua.getSelectedItem().toString());
                LangileaKudeatu.langileaGehitu(lang);
                resetLangileaGehitu();
                enableComponets(viewLangileaGehitu.jPanelLangDatuak, false);
            }   
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewLangileaGehitu.jButtonReset) {
            resetLangileaGehitu();
        }
        else if (comando == viewLangileaGehitu.jButtonIrten) {
            resetLangileaGehitu();
            viewLangileaGehitu.dispose();
            viewLangileaInfo.setEnabled(true);
            langDatuakErakutsiTaula(LangileaKudeatu.langileGuztiakErakutsi());
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
        
        /* HornitzaileaInfo-ko aukerak */
        else if (comando == viewHornitzaileaInfo.jButtonGehitu) {
            viewHornitzaileaGehitu.setVisible(true);
            viewHornitzaileaInfo.setEnabled(false);
            enableComponets(viewHornitzaileaGehitu.jPanelHornDatuak, false);
        }
        else if (comando == viewHornitzaileaInfo.jButtonIrten) {
            viewHornitzaileaInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        } 
        else if (comando == viewHornitzaileaInfo.jButtonEzabatu) {
            int aukLerroa = viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(viewHornitzaileaInfo.jDialogEzabatuKonfirm, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String kodea = (String) viewHornitzaileaInfo.jTableHornitzaileaInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako langilearen nan zenbakia lortu
                    HornitzaileaKudeatu.hornitzaileaEzabatu(kodea);
                    viewEskaeraGehitu.jComboBoxHornitzailea.removeAllItems();
                    hornitzaileaKargatu(viewEskaeraGehitu.jComboBoxHornitzailea);
                }                
                hornDatuakErakutsiTaula(HornitzaileaKudeatu.hornitzaileGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da hornitzailerik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewHornitzaileaInfo.jButtonAldatu) {
            if (viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectedRow()!=-1) {
                enableComponets(viewHornitzaileaInfo.jPanelHornDatuak, true);
                enableComponets(viewHornitzaileaInfo.jPanelOina, false);
                viewHornitzaileaInfo.jButtonAldaketaGorde.setEnabled(true);
                viewHornitzaileaInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da hornitzailerik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            } 
        }
        else if (comando == viewHornitzaileaInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                enableComponets(viewHornitzaileaInfo.jPanelHornDatuak, false);
                enableComponets(viewHornitzaileaInfo.jPanelOina, true);
                viewHornitzaileaInfo.jButtonAldaketaGorde.setEnabled(false);
                viewHornitzaileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetHornInfoErr();
                aukHornDatuakBete(viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewHornitzaileaInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaHornInfo()) {
                    int aukLerroa = viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectedRow(); // aukeratutako lerroa
                    /* Hornitzailea ezabatu */
                    String kodea = (String) viewHornitzaileaInfo.jTableHornitzaileaInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako langilearen nan zenbakia lortu
                    HornitzaileaKudeatu.hornitzaileaEzabatu(kodea);

                    /* Hornitzailea gorde */
                    Hornitzailea horn = new Hornitzailea(viewHornitzaileaInfo.jTextFieldKodeHor.getText(), viewHornitzaileaInfo.jTextFieldIzena.getText(), 
                            viewHornitzaileaInfo.jTextFieldHerria.getText(), viewHornitzaileaInfo.jTextFieldTlf.getText(), viewHornitzaileaInfo.jTextFieldEmail.getText());
                    HornitzaileaKudeatu.hornitzaileaGehitu(horn);
                    enableComponets(viewHornitzaileaInfo.jPanelHornDatuak, false);
                    
                    /* Hornitzaileak aktualizatu */
                    viewEskaeraGehitu.jComboBoxHornitzailea.removeAllItems();
                    hornitzaileaKargatu(viewEskaeraGehitu.jComboBoxHornitzailea);
                    
                    hornDatuakErakutsiTaula(HornitzaileaKudeatu.hornitzaileGuztiakErakutsi());
                    enableComponets(viewHornitzaileaInfo.jPanelHornDatuak, false);
                    enableComponets(viewHornitzaileaInfo.jPanelOina, true);
                    viewHornitzaileaInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewHornitzaileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
            }
        }
        
        /* HornitzaileaGehituko aukerak */
        else if (comando == viewHornitzaileaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewHornitzaileaGehitu.jPanelHornDatuak, true);
        }
        else if (comando == viewHornitzaileaGehitu.jButtonGorde) {
            if (balidazioaHornGehitu()) {
                Hornitzailea horn = new Hornitzailea(viewHornitzaileaGehitu.jTextFieldIzena.getText(), viewHornitzaileaGehitu.jTextFieldHerria.getText(),
                        viewHornitzaileaGehitu.jTextFieldTlf.getText(), viewHornitzaileaGehitu.jTextFieldEmail.getText());
                HornitzaileaKudeatu.hornitzaileaGehitu(horn);
                resetHornitzaileaGehitu();
                enableComponets(viewHornitzaileaGehitu.jPanelHornDatuak, false);
                // Hornitzaileak aktualizatu
                viewEskaeraGehitu.jComboBoxHornitzailea.removeAllItems();
                hornitzaileaKargatu(viewEskaeraGehitu.jComboBoxHornitzailea);
            }
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewHornitzaileaGehitu.jButtonReset) {
            resetHornitzaileaGehitu();
        }
        else if (comando == viewHornitzaileaGehitu.jButtonIrten) {
            resetHornitzaileaGehitu();
            viewHornitzaileaGehitu.dispose();
            viewHornitzaileaInfo.setEnabled(true);
            hornDatuakErakutsiTaula(HornitzaileaKudeatu.hornitzaileGuztiakErakutsi());
        }
        
        /* EskaeraInfo-ko aukerak */
        else if (comando == viewEskaeraInfo.jButtonGehitu) {
            viewEskaeraGehitu.setVisible(true);
            viewEskaeraInfo.setEnabled(false);
            enableComponets(viewEskaeraGehitu.jPanelEskDatuak, false);
        }
        else if (comando == viewEskaeraInfo.jButtonIrten) {
            viewEskaeraInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (comando == viewEskaeraInfo.jButtonEzabatu) {
            int aukLerroa = viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(null, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String kodea = (String) viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako langilearen nan zenbakia lortu
                    EskaeraKudeatu.eskaeraEzabatu(kodea);
                }                
                eskDatuakErakutsiTaula(EskaeraKudeatu.eskaeraGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da hornitzailerik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewEskaeraInfo.jButtonAldatu) {
            if (viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow()!=-1) {
                enableComponets(viewEskaeraInfo.jPanelEskDatuak, true);
                enableComponets(viewEskaeraInfo.jPanelOina, false);
                viewEskaeraInfo.jButtonAldaketaGorde.setEnabled(true);
                viewEskaeraInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da eskaerarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            } 
        }
        else if (comando == viewEskaeraInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                enableComponets(viewEskaeraInfo.jPanelEskDatuak, false);
                enableComponets(viewEskaeraInfo.jPanelOina, true);
                viewEskaeraInfo.jButtonAldaketaGorde.setEnabled(false);
                viewEskaeraInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetEskInfoErr();
                aukEskDatuakBete(viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewEskaeraInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaEskInfo()) {
                    int aukLerroa = viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow(); // aukeratutako lerroa
                    /* Eskaera ezabatu */
                    String kodea = (String) viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako langilearen nan zenbakia lortu
                    EskaeraKudeatu.eskaeraEzabatu(kodea);

                    /* Eskaera gorde */
                    Eskaera esk = new Eskaera(viewEskaeraInfo.jTextFieldKodeEsk.getText(), viewEskaeraInfo.jComboBoxHornitzailea.getSelectedItem().toString(), 
                            Metodoak.dataGorde(viewEskaeraInfo.jDateChooserData.getDate()), Integer.parseInt(viewEskaeraInfo.jTextFieldKopurua.getText()));
                    EskaeraKudeatu.eskaeraGehitu(esk);
                    enableComponets(viewEskaeraInfo.jPanelEskDatuak, false);
                    
                    /* Hornitzaileak aktualizatu */
                    viewEskaeraInfo.jComboBoxHornitzailea.removeAllItems();
                    hornitzaileaKargatu(viewEskaeraInfo.jComboBoxHornitzailea);
                    viewEskaeraGehitu.jComboBoxHornitzailea.removeAllItems();
                    hornitzaileaKargatu(viewEskaeraGehitu.jComboBoxHornitzailea);
                    
                    eskDatuakErakutsiTaula(EskaeraKudeatu.eskaeraGuztiakErakutsi());
                    enableComponets(viewEskaeraInfo.jPanelEskDatuak, false);
                    enableComponets(viewEskaeraInfo.jPanelOina, true);
                    viewEskaeraInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewEskaeraInfo.jButtonAldaketaEzabatu.setEnabled(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
            }
        }
        
        /* EskaeraGehitu-ko aukerak */
        else if (comando == viewEskaeraGehitu.jButtonBerriaGehitu) {
            enableComponets(viewEskaeraGehitu.jPanelEskDatuak, true);
        }
        else if (comando == viewEskaeraGehitu.jButtonGorde){
            if (balidazioaEskGehitu()) {
                Eskaera esk = new Eskaera (viewEskaeraGehitu.jComboBoxHornitzailea.getSelectedItem().toString(), 
                        Integer.parseInt(viewEskaeraGehitu.jTextFieldKopurua.getText()));
                EskaeraKudeatu.eskaeraGehitu(esk);
                resetEskaeraGehitu();
                enableComponets(viewEskaeraGehitu.jPanelEskDatuak, false);
            }
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewEskaeraGehitu.jButtonReset){
            resetEskaeraGehitu();
        }
        else if (comando == viewEskaeraGehitu.jButtonIrten) {
            resetEskaeraGehitu();
            viewEskaeraGehitu.dispose();
            viewEskaeraInfo.setEnabled(true);
            eskDatuakErakutsiTaula(EskaeraKudeatu.eskaeraGuztiakErakutsi());
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
        if (comando == viewDendaInfo.jButtonIrten)
            viewDendaInfo.jButtonIrten.setBackground(new Color (0,0,51));
        else if (comando == viewDendaGehitu.jButtonIrten)
            viewDendaGehitu.jButtonIrten.setBackground(new Color (0,0,51));
        else if (comando == viewBezeroaInfo.jButtonIrten)
            viewBezeroaInfo.jButtonIrten.setBackground(new Color (0,0,51));
        else if ( comando == viewBezeroaGehitu.jButtonIrten)
            viewBezeroaGehitu.jButtonIrten.setBackground(new Color (0,0,51));
        else if (comando == viewLangileaInfo.jButtonIrten)
            viewLangileaInfo.jButtonIrten.setBackground(new Color (0,0,51));
        else if (comando == viewLangileaGehitu.jButtonIrten)
            viewLangileaGehitu.jButtonIrten.setBackground(new Color (0,0,51));
        else if (comando == viewProduktuaAukeratu.jButtonIrten)
            viewProduktuaAukeratu.jButtonIrten.setBackground(new Color (0,0,51));
        else if (comando == viewJertseaGehitu.jButtonIrten)
            viewJertseaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
        else if (comando == viewKamisetaGehitu.jButtonIrten)
            viewKamisetaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
        else if (comando == viewPrakaGehitu.jButtonIrten)
            viewPrakaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
        else if (comando == viewHornitzaileaInfo.jButtonIrten)
            viewHornitzaileaInfo.jButtonIrten.setBackground(new Color (0,0,51));  
        else if (comando == viewHornitzaileaGehitu.jButtonIrten)
            viewHornitzaileaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
        else if (comando == viewEskaeraInfo.jButtonIrten)
            viewEskaeraInfo.jButtonIrten.setBackground(new Color (0,0,51));  
        else if (comando == viewEskaeraGehitu.jButtonIrten)
            viewEskaeraGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewDendaInfo.jButtonIrten)
            viewDendaInfo.jButtonIrten.setBackground(urdina);
        else if (comando == viewDendaGehitu.jButtonIrten)
            viewDendaGehitu.jButtonIrten.setBackground(urdina);
        else if (comando == viewBezeroaInfo.jButtonIrten)
            viewBezeroaInfo.jButtonIrten.setBackground(urdina);
        else if ( comando == viewBezeroaGehitu.jButtonIrten)
            viewBezeroaGehitu.jButtonIrten.setBackground(urdina);
        else if (comando == viewLangileaInfo.jButtonIrten)
            viewLangileaInfo.jButtonIrten.setBackground(urdina);
        else if (comando == viewLangileaGehitu.jButtonIrten)
            viewLangileaGehitu.jButtonIrten.setBackground(urdina);
        else if (comando == viewProduktuaAukeratu.jButtonIrten)
            viewProduktuaAukeratu.jButtonIrten.setBackground(urdina);
        else if (comando == viewJertseaGehitu.jButtonIrten)
            viewJertseaGehitu.jButtonIrten.setBackground(urdina);
        else if (comando == viewKamisetaGehitu.jButtonIrten)
            viewKamisetaGehitu.jButtonIrten.setBackground(urdina);  
        else if (comando == viewPrakaGehitu.jButtonIrten)
            viewPrakaGehitu.jButtonIrten.setBackground(urdina);  
        else if (comando == viewHornitzaileaInfo.jButtonIrten)
            viewHornitzaileaInfo.jButtonIrten.setBackground(urdina);  
        else if (comando == viewHornitzaileaGehitu.jButtonIrten)
            viewHornitzaileaGehitu.jButtonIrten.setBackground(urdina);  
        else if (comando == viewEskaeraInfo.jButtonIrten)
            viewEskaeraInfo.jButtonIrten.setBackground(urdina);  
        else if (comando == viewEskaeraGehitu.jButtonIrten)
            viewEskaeraGehitu.jButtonIrten.setBackground(urdina);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        /* Tauletako lerroak aukeratzerakoan */
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (lsm == viewDendaInfo.jTableDendaInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetDendaInfo();
            }
            else {
                viewDendaInfo.jTableDendaInfo.setSelectionBackground(urdina);
                viewDendaInfo.jTableDendaInfo.setSelectionForeground(Color.WHITE);
                aukDendDatuakBete(viewDendaInfo.jTableDendaInfo.getSelectedRow());
            }
        }
        else if (lsm == viewBezeroaInfo.jTableBezeroaInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetBezeroaInfo();
            }
            else {
                viewBezeroaInfo.jTableBezeroaInfo.setSelectionBackground(urdina);
                viewBezeroaInfo.jTableBezeroaInfo.setSelectionForeground(Color.WHITE);
                aukBezDatuakBete(viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow());
            }
        }
        else if (lsm == viewLangileaInfo.jTableLangileaInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetLangileaInfo();
            }
            else {
                viewLangileaInfo.jTableLangileaInfo.setSelectionBackground(urdina);
                viewLangileaInfo.jTableLangileaInfo.setSelectionForeground(Color.WHITE);
                aukLangDatuakBete(viewLangileaInfo.jTableLangileaInfo.getSelectedRow());
            }
        }
        else if (lsm == viewProduktuaAukeratu.jTableJertsInfo.getSelectionModel()) {
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
        else if (lsm == viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetHornInfo();
            }
            else {
                viewHornitzaileaInfo.jTableHornitzaileaInfo.setSelectionBackground(urdina);
                viewHornitzaileaInfo.jTableHornitzaileaInfo.setSelectionForeground(Color.WHITE);
                aukHornDatuakBete(viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectedRow());
            }
        }
        else if (lsm == viewEskaeraInfo.jTableEskaeraInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetEskInfo();
            }
            else {
                viewEskaeraInfo.jTableEskaeraInfo.setSelectionBackground(urdina);
                viewEskaeraInfo.jTableEskaeraInfo.setSelectionForeground(Color.WHITE);
                aukEskDatuakBete(viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow());
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
        // DendaInfo
        if (comando == viewDendaInfo.jTextFieldKodeDend) 
            viewDendaInfo.jTextFieldKodeDend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldIzena) 
            viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldHelbidea) 
            viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldHerria) 
            viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldPostKod) 
            viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldTlf) 
            viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldEmail) 
            viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        
        // DendaGehitu
        else if (comando == viewDendaGehitu.jTextFieldIzena) 
            viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldHelbidea) 
            viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldHerria) 
            viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldPostKod) 
            viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldTlf) 
            viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldEmail) 
            viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));

        // BezeroaInfo
        else if (comando == viewBezeroaInfo.jTextFieldKodeBez) 
            viewBezeroaInfo.jTextFieldKodeBez.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldIzena) 
            viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldAbizena1) 
            viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldAbizena2) 
            viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldNan) 
            viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldHerria) 
            viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldTlf) 
            viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        
        // BezeroaGehitu
        else if (comando == viewBezeroaGehitu.jTextFieldIzena)
            viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldAbizena1) 
            viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldAbizena2) 
            viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldNan) 
            viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldHerria) 
            viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldTlf) 
            viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        
        // LangileaInfo
        else if (comando == viewLangileaInfo.jTextFieldKodeLang) 
            viewLangileaInfo.jTextFieldKodeLang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldIzena) 
            viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldAbizena1) 
            viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldAbizena2) 
            viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldNan) 
            viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldHerria) 
            viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldTlf) 
            viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldSoldata)
            viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
         else if (comando == viewLangileaInfo.jComboBoxEremua)
            viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(urdina, 1));
        
        // LangileaGehitu
        else if (comando == viewLangileaGehitu.jTextFieldIzena)
            viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldAbizena1) 
            viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldAbizena2) 
            viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldNan) 
            viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldHerria) 
            viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldTlf) 
            viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldSoldata)
            viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
         else if (comando == viewLangileaGehitu.jComboBoxEremua)
            viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(urdina, 1));
         
        // JertseaInfo
        else if (comando == viewProduktuaAukeratu.jTextFieldKodeJerts)
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
        
        // HornitzaileaInfo
        else if (comando == viewHornitzaileaInfo.jTextFieldKodeHor)
            viewHornitzaileaInfo.jTextFieldKodeHor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaInfo.jTextFieldIzena)
            viewHornitzaileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaInfo.jTextFieldHerria)
            viewHornitzaileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaInfo.jTextFieldEmail)
            viewHornitzaileaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaInfo.jTextFieldTlf)
            viewHornitzaileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        
        // HornitzaileaGehitu
        else if (comando == viewHornitzaileaGehitu.jTextFieldIzena)
            viewHornitzaileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaGehitu.jTextFieldHerria)
            viewHornitzaileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaGehitu.jTextFieldEmail)
            viewHornitzaileaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaGehitu.jTextFieldTlf)
            viewHornitzaileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        
        // EskaeraInfo
        else if (comando == viewEskaeraInfo.jTextFieldKodeEsk)
            viewEskaeraInfo.jTextFieldKodeEsk.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));   
        else if (comando == viewEskaeraInfo.jTextFieldKopurua)
            viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));   
        else if (comando == viewEskaeraInfo.jComboBoxHornitzailea) 
            viewEskaeraInfo.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(urdina, 1));
        
         // EskaeraGehitu
        else if (comando == viewEskaeraGehitu.jTextFieldKopurua)
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));   
        else if (comando == viewEskaeraGehitu.jComboBoxHornitzailea) 
            viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(urdina, 1)); 
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // DendaInfo
        if (comando == viewDendaInfo.jTextFieldKodeDend) 
            viewDendaInfo.jTextFieldKodeDend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldIzena) 
            viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldHelbidea) 
            viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldHerria) 
            viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldPostKod) 
            viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldTlf) 
            viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldEmail)
            viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        // DendaGehitu
        else if (comando == viewDendaGehitu.jTextFieldIzena) 
            viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldHelbidea) 
            viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldHerria) 
            viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldPostKod) 
            viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldTlf)
            viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldEmail)
            viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        // BezeroaInfo
        else if (comando == viewBezeroaInfo.jTextFieldKodeBez) 
            viewBezeroaInfo.jTextFieldKodeBez.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldIzena) 
            viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldAbizena1) 
            viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldAbizena2) 
            viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldNan) 
            viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldHerria) 
            viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldTlf) 
            viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        // BezeroaGehitu
        else if (comando == viewBezeroaGehitu.jTextFieldIzena) 
            viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldAbizena1) 
            viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldAbizena2) 
            viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldNan) 
            viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldHerria) 
            viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldTlf) 
            viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        // LangileaInfo
        else if (comando == viewLangileaInfo.jTextFieldKodeLang) 
            viewLangileaInfo.jTextFieldKodeLang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldIzena) 
            viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldAbizena1) 
            viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldAbizena2) 
            viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldNan) 
            viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldHerria) 
            viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldTlf) 
            viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldSoldata)
            viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jComboBoxEremua)
            viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        // LangileaGehitu
        else if (comando == viewLangileaGehitu.jTextFieldIzena)
            viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldAbizena1) 
            viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldAbizena2) 
            viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldNan) 
            viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldHerria) 
            viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldTlf) 
            viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldSoldata) 
            viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jComboBoxEremua)
            viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        // JertseaInfo
        else if (comando == viewProduktuaAukeratu.jTextFieldKodeJerts)
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
        
        // HornitzaileaInfo
        else if (comando == viewHornitzaileaInfo.jTextFieldKodeHor)
            viewHornitzaileaInfo.jTextFieldKodeHor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaInfo.jTextFieldIzena)
            viewHornitzaileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaInfo.jTextFieldHerria)
            viewHornitzaileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaInfo.jTextFieldEmail)
            viewHornitzaileaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaInfo.jTextFieldTlf)
            viewHornitzaileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        // HornitzaileaGehitu
        else if (comando == viewHornitzaileaGehitu.jTextFieldIzena)
            viewHornitzaileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaGehitu.jTextFieldHerria)
            viewHornitzaileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaGehitu.jTextFieldEmail)
            viewHornitzaileaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaGehitu.jTextFieldTlf)
            viewHornitzaileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        // EskaeraInfo
        else if (comando == viewEskaeraInfo.jTextFieldKodeEsk)
            viewEskaeraInfo.jTextFieldKodeEsk.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));  
        else if (comando == viewEskaeraInfo.jTextFieldKopurua)
            viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));  
        else if (comando == viewEskaeraInfo.jComboBoxHornitzailea) 
            viewEskaeraInfo.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
         // EskaeraGehitu
        else if (comando == viewEskaeraGehitu.jTextFieldKopurua)
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));   
        else if (comando == viewEskaeraGehitu.jComboBoxHornitzailea) 
            viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
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
        if (comando == viewDendaInfo.jTextFieldBilatu)
            txtBilatuTaulan(viewDendaInfo.jTableDendaInfo, viewDendaInfo.jTextFieldBilatu.getText());
        else if (comando == viewBezeroaInfo.jTextFieldBilatu)
            txtBilatuTaulan(viewBezeroaInfo.jTableBezeroaInfo, viewBezeroaInfo.jTextFieldBilatu.getText());
        else if (comando == viewLangileaInfo.jTextFieldBilatu)
            txtBilatuTaulan(viewLangileaInfo.jTableLangileaInfo, viewLangileaInfo.jTextFieldBilatu.getText());
        else if (comando == viewProduktuaAukeratu.jTextFieldBilatuJerts)
            txtBilatuTaulan(viewProduktuaAukeratu.jTableJertsInfo, viewProduktuaAukeratu.jTextFieldBilatuJerts.getText());
        else if (comando == viewProduktuaAukeratu.jTextFieldBilatuKami)
            txtBilatuTaulan(viewProduktuaAukeratu.jTableKamiInfo, viewProduktuaAukeratu.jTextFieldBilatuKami.getText());
        else if (comando == viewProduktuaAukeratu.jTextFieldBilatuPrak)
            txtBilatuTaulan(viewProduktuaAukeratu.jTablePrakInfo, viewProduktuaAukeratu.jTextFieldBilatuPrak.getText());
        else if (comando == viewHornitzaileaInfo.jTextFieldBilatu)
            txtBilatuTaulan(viewHornitzaileaInfo.jTableHornitzaileaInfo, viewHornitzaileaInfo.jTextFieldBilatu.getText());
        else if (comando == viewEskaeraInfo.jTextFieldBilatu)
            txtBilatuTaulan(viewEskaeraInfo.jTableEskaeraInfo, viewEskaeraInfo.jTextFieldBilatu.getText());
    }
    
    private boolean balidazioaDendaInfo() {
        boolean bool = true;
        if (viewDendaInfo.jTextFieldIzena.getText().isEmpty()) {
            viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaInfo.jTextFieldHelbidea.getText().isEmpty()) {
            viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaInfo.jTextFieldHerria.getText().isEmpty()) {
            viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }    
        if (viewDendaInfo.jTextFieldPostKod.getText().isEmpty()) {
            viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaInfo.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewDendaInfo.jTextFieldTlf.getText()))) {
            viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }  
        if (viewDendaInfo.jTextFieldEmail.getText().isEmpty() || !(Metodoak.emailBalidazioa(viewDendaInfo.jTextFieldEmail.getText()))) {
            viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        
        return bool;
    }
    
    private boolean balidazioaDendaGehitu() {
        boolean bool = true;
        if (viewDendaGehitu.jTextFieldIzena.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewDendaGehitu.jTextFieldHelbidea.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewDendaGehitu.jTextFieldHerria.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewDendaGehitu.jTextFieldPostKod.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaGehitu.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewDendaGehitu.jTextFieldTlf.getText()))) {
            viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaGehitu.jTextFieldEmail.getText().isEmpty() || !(Metodoak.emailBalidazioa(viewDendaGehitu.jTextFieldEmail.getText()))) {
            viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        return bool;
    }

    private boolean balidazioaBezInfo() {
        boolean bool = true;
        if (viewBezeroaInfo.jTextFieldIzena.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewBezeroaInfo.jTextFieldAbizena1.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewBezeroaInfo.jTextFieldAbizena2.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewBezeroaInfo.jTextFieldNan.getText().isEmpty() || !(Metodoak.nanBalidazioa(viewBezeroaInfo.jTextFieldNan.getText()))) {
            viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        // data balidatu ??
        if (!viewBezeroaInfo.jRadioButtonEmak.isSelected() && !viewBezeroaInfo.jRadioButtonGiz.isSelected()) {
            viewBezeroaInfo.jRadioButtonEmak.setForeground(Color.RED);
            viewBezeroaInfo.jRadioButtonGiz.setForeground(Color.RED);
        }  
        if (viewBezeroaInfo.jTextFieldHerria.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewBezeroaInfo.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewBezeroaInfo.jTextFieldTlf.getText()))) {
            viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        else {
            viewBezeroaInfo.jRadioButtonEmak.setForeground(Color.RED);
            viewBezeroaInfo.jRadioButtonGiz.setForeground(Color.RED);
        }
        return bool;
    }
    
    private boolean balidazioaBezGehitu() {
        boolean bool = true;
        if (viewBezeroaGehitu.jTextFieldIzena.getText().isEmpty()) {
            viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewBezeroaGehitu.jTextFieldAbizena1.getText().isEmpty()) {
            viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewBezeroaGehitu.jTextFieldAbizena2.getText().isEmpty()) {
            viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewBezeroaGehitu.jTextFieldNan.getText().isEmpty() || !(Metodoak.nanBalidazioa(viewBezeroaGehitu.jTextFieldNan.getText()))) {
            viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        // data balidatu ??
        if (!viewBezeroaGehitu.jRadioButtonEmak.isSelected() && !viewBezeroaGehitu.jRadioButtonGiz.isSelected()) {
            viewBezeroaGehitu.jRadioButtonEmak.setForeground(Color.RED);
            viewBezeroaGehitu.jRadioButtonGiz.setForeground(Color.RED);
        }  
        else if (viewBezeroaGehitu.jRadioButtonEmak.isSelected() || viewBezeroaGehitu.jRadioButtonGiz.isSelected()) {
            viewBezeroaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
            viewBezeroaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
        }
        if (viewBezeroaGehitu.jTextFieldHerria.getText().isEmpty()) {
            viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewBezeroaGehitu.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewBezeroaGehitu.jTextFieldTlf.getText()))) {
            viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        return bool;
    }
    
    private boolean balidazioaLangInfo() {
        boolean bool = true;
        if (viewLangileaInfo.jTextFieldIzena.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewLangileaInfo.jTextFieldAbizena1.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewLangileaInfo.jTextFieldAbizena2.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewLangileaInfo.jTextFieldNan.getText().isEmpty() || !(Metodoak.nanBalidazioa(viewLangileaInfo.jTextFieldNan.getText()))) {
            viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        // data balidatu ??
        if (!viewLangileaInfo.jRadioButtonEmak.isSelected() && !viewLangileaInfo.jRadioButtonGiz.isSelected()) {
            viewLangileaInfo.jRadioButtonEmak.setForeground(Color.RED);
            viewLangileaInfo.jRadioButtonGiz.setForeground(Color.RED);
        }  
        else if (viewLangileaInfo.jRadioButtonEmak.isSelected() || viewLangileaInfo.jRadioButtonGiz.isSelected()) {
            viewLangileaInfo.jRadioButtonEmak.setForeground(Color.BLACK);
            viewLangileaInfo.jRadioButtonGiz.setForeground(Color.BLACK);
        }
        if (viewLangileaInfo.jTextFieldHerria.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaInfo.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewLangileaInfo.jTextFieldTlf.getText()))) {
            viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaInfo.jTextFieldSoldata.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaInfo.jTextFieldSoldata.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaInfo.jComboBoxEremua.getSelectedIndex()==0) {
            viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
    
    private boolean balidazioaLangGehitu() {
        boolean bool = true;
        if (viewLangileaGehitu.jTextFieldIzena.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewLangileaGehitu.jTextFieldAbizena1.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewLangileaGehitu.jTextFieldAbizena2.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewLangileaGehitu.jTextFieldNan.getText().isEmpty() || !(Metodoak.nanBalidazioa(viewLangileaGehitu.jTextFieldNan.getText()))) {
            viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        // data balidatu ??
        if (!viewLangileaGehitu.jRadioButtonEmak.isSelected() && !viewLangileaGehitu.jRadioButtonGiz.isSelected()) {
            viewLangileaGehitu.jRadioButtonEmak.setForeground(Color.RED);
            viewLangileaGehitu.jRadioButtonGiz.setForeground(Color.RED);
        }  
        else if (viewLangileaGehitu.jRadioButtonEmak.isSelected() || viewLangileaGehitu.jRadioButtonGiz.isSelected()) {
            viewLangileaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
            viewLangileaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
        }
        if (viewLangileaGehitu.jTextFieldHerria.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaGehitu.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewLangileaGehitu.jTextFieldTlf.getText()))) {
            viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaGehitu.jTextFieldSoldata.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaGehitu.jTextFieldSoldata.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaGehitu.jComboBoxEremua.getSelectedIndex()==0) {
            viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
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
        
    private boolean balidazioaHornInfo() {
        boolean bool = true;
        if (viewHornitzaileaInfo.jTextFieldIzena.getText().isEmpty()) {
            viewHornitzaileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewHornitzaileaInfo.jTextFieldHerria.getText().isEmpty()) {
            viewHornitzaileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewHornitzaileaInfo.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewHornitzaileaInfo.jTextFieldTlf.getText()))) {
            viewHornitzaileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewHornitzaileaInfo.jTextFieldEmail.getText().isEmpty() || !(Metodoak.emailBalidazioa(viewHornitzaileaInfo.jTextFieldEmail.getText()))) {
            viewHornitzaileaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        return bool;
    }
    
    private boolean balidazioaHornGehitu() {
        boolean bool = true;
        if (viewHornitzaileaGehitu.jTextFieldIzena.getText().isEmpty()) {
            viewHornitzaileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewHornitzaileaGehitu.jTextFieldHerria.getText().isEmpty()) {
            viewHornitzaileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewHornitzaileaGehitu.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewHornitzaileaGehitu.jTextFieldTlf.getText()))) {
            viewHornitzaileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewHornitzaileaGehitu.jTextFieldEmail.getText().isEmpty() || !(Metodoak.emailBalidazioa(viewHornitzaileaGehitu.jTextFieldEmail.getText()))) {
            viewHornitzaileaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        return bool;
    }
    
    private boolean balidazioaEskInfo() {
        boolean bool = true;
        if (viewEskaeraInfo.jComboBoxHornitzailea.getSelectedIndex() == 0) {
            viewEskaeraInfo.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }  
        // data balidatu ?????
        if (viewEskaeraInfo.jTextFieldKopurua.getText().isEmpty()) {
            viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        return bool;
    }
      
    private boolean balidazioaEskGehitu() {
        boolean bool = true;
        if (viewEskaeraGehitu.jComboBoxHornitzailea.getSelectedIndex() == 0) {
            viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }     
        if (viewEskaeraGehitu.jTextFieldKopurua.getText().isEmpty()) {
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        return bool;
    }

    private void resetBezInfoErr() {
        viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jRadioButtonEmak.setForeground(Color.BLACK);
        viewBezeroaInfo.jRadioButtonGiz.setForeground(Color.BLACK);
    }
    
    private void resetDendInfoErr() {
        viewDendaInfo.jTextFieldKodeDend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }    
    
    private void resetLangInfoErr() {
        viewLangileaInfo.jTextFieldKodeLang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private void resetHornInfoErr() {
        viewHornitzaileaInfo.jTextFieldKodeHor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }

    private void resetEskInfoErr() {
        viewEskaeraInfo.jTextFieldKodeEsk.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewEskaeraInfo.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
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