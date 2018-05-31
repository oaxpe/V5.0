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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class Controller {
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
    private ProdInbEsk viewProdInbEsk;
    private ProdKontsultatu viewProdKontsultatu;
    private ProdSaldu viewProdSaldu;

    /* ERAIKITZAILEA */  
    public Controller() {
        
    }
    
    public Controller(Bezeroa bez, Denda denda, Eskaera esk, Hornitzailea horn, Jertsea jerts,
            Kamiseta kami, Langilea lang, Praka prak, Salmenta salm,
            DendaInfo viewDendInfo, DendaGehitu viewDendGehitu, BezeroaInfo viewBezInfo, 
            BezeroaGehitu viewBezGehitu, LangileaInfo viewLangInfo, LangileaGehitu viewLangGehitu,
            ProduktuaAukeratu viewProdAuk, JertseaGehitu viewJertsGehitu, KamisetaGehitu viewKamGehitu,
            PrakaGehitu viewPrakGehitu, HornitzaileaInfo viewHornInfo, HornitzaileaGehitu viewHornGehitu,
            EskaeraInfo viewEskInfo, EskaeraGehitu viewEskGehitu, MenuNagusia viewMenuNag, 
            ProdInbEsk viewProdInbEsk, ProdKontsultatu viewProdKonts, ProdSaldu viewProdSaldu) {
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
        this.viewProdInbEsk = viewProdInbEsk;
        this.viewProdKontsultatu = viewProdKonts;
        this.viewProdSaldu = viewProdSaldu;
        botoiakEntzuten();
        hasieratu();
        viewMenuNagusia.setVisible(true);
    }
    
    /* METODOAK */
    private void botoiakEntzuten() { 
        menuNagController menuNagCtr = new menuNagController(viewDendaInfo, viewBezeroaInfo, viewLangileaInfo, viewProduktuaAukeratu, 
            viewHornitzaileaInfo, viewEskaeraInfo, viewMenuNagusia, viewProdInbEsk, viewProdKontsultatu, viewProdSaldu);
        dendaInfoController dendInfoCtr = new dendaInfoController(denda, viewDendaInfo, viewDendaGehitu, viewLangileaInfo, viewLangileaGehitu, viewMenuNagusia);
        dendaGehituController dendGehituCtr = new dendaGehituController(denda, viewDendaInfo, viewDendaGehitu, viewLangileaInfo, viewLangileaGehitu);
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
        prodInbEskController prodInbEskCtr = new prodInbEskController(jertsea, kamiseta, praka, viewMenuNagusia, viewProdInbEsk);
        prodKontsultatuController prodKontsCtr = new prodKontsultatuController(jertsea, kamiseta, praka, viewMenuNagusia, viewProdKontsultatu);
        prodSalduController prodSalduCtr = new prodSalduController(jertsea, kamiseta, praka, viewMenuNagusia, viewProdSaldu);
        
        /* ActionListeners gehitu */
        viewMenuNagusia.jButtonIrten.addActionListener(menuNagCtr);
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
        viewMenuNagusia.jButtonBezeroa.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonDenda.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonEskaera.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonHornitzailea.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonLangilea.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonProduktua.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonInbentarioa.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonEskatzeko.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonKontsulta.addActionListener(menuNagCtr);
        viewMenuNagusia.jButtonSalmenta.addActionListener(menuNagCtr);
        
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
        
        // Produktua Inbentario Eskatzekoak
        viewProdInbEsk.jButtonIrten.addActionListener(prodInbEskCtr);
        
        // ProduktuaKontsultatu
        viewProdKontsultatu.jButtonIrten.addActionListener(prodKontsCtr);
        viewProdKontsultatu.jButtonBidali.addActionListener(prodKontsCtr);
        viewProdKontsultatu.jButtonEzeztatu.addActionListener(prodKontsCtr);
        
        // ProduktuaSaldu
        viewProdSaldu.jButtonIrten.addActionListener(prodSalduCtr);
        viewProdSaldu.jButtonSaldu.addActionListener(prodSalduCtr);
        viewProdSaldu.jButtonEzeztatu.addActionListener(prodSalduCtr);  
         
        /* AncestorListener */
        viewProduktuaAukeratu.jPanelJerts.addAncestorListener(prodAukCtr);
        viewProduktuaAukeratu.jPanelKami.addAncestorListener(prodAukCtr);
        viewProduktuaAukeratu.jPanelPrak.addAncestorListener(prodAukCtr);
                
        /* MouseListener */
        // MenuNagusia
        viewMenuNagusia.jButtonIrten.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonDenda.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonBezeroa.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonLangilea.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonProduktua.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonHornitzailea.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonEskaera.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonInbentarioa.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonEskatzeko.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonKontsulta.addMouseListener(menuNagCtr);
        viewMenuNagusia.jButtonSalmenta.addMouseListener(menuNagCtr);
        
        // DendaInfo
        viewDendaInfo.jButtonIrten.addMouseListener(dendInfoCtr);
        viewDendaInfo.jButtonAldaketaEzabatu.addMouseListener(dendInfoCtr);
        viewDendaInfo.jButtonAldaketaGorde.addMouseListener(dendInfoCtr);
        viewDendaInfo.jButtonAldatu.addMouseListener(dendInfoCtr);
        viewDendaInfo.jButtonEzabatu.addMouseListener(dendInfoCtr);
        viewDendaInfo.jButtonGehitu.addMouseListener(dendInfoCtr);
        
        // DendaGehitu
        viewDendaGehitu.jButtonIrten.addMouseListener(dendGehituCtr);
        viewDendaGehitu.jButtonBerriaGehitu.addMouseListener(dendGehituCtr);
        viewDendaGehitu.jButtonGorde.addMouseListener(dendGehituCtr);
        viewDendaGehitu.jButtonReset.addMouseListener(dendGehituCtr);
        
        // BezeroaInfo
        viewBezeroaInfo.jButtonIrten.addMouseListener(bezInfoCtr);
        viewBezeroaInfo.jButtonAldaketaEzabatu.addMouseListener(bezInfoCtr);
        viewBezeroaInfo.jButtonAldaketaGorde.addMouseListener(bezInfoCtr);
        viewBezeroaInfo.jButtonAldatu.addMouseListener(bezInfoCtr);
        viewBezeroaInfo.jButtonEzabatu.addMouseListener(bezInfoCtr);
        viewBezeroaInfo.jButtonGehitu.addMouseListener(bezInfoCtr);
        
        // BezeroaGehitu
        viewBezeroaGehitu.jButtonIrten.addMouseListener(bezGehituCtr);
        viewBezeroaGehitu.jButtonBerriaGehitu.addMouseListener(bezGehituCtr);
        viewBezeroaGehitu.jButtonGorde.addMouseListener(bezGehituCtr);
        viewBezeroaGehitu.jButtonReset.addMouseListener(bezGehituCtr);
        
        // LangileaInfo
        viewLangileaInfo.jButtonIrten.addMouseListener(langInfoCtr);
        viewLangileaInfo.jButtonAldaketaEzabatu.addMouseListener(langInfoCtr);
        viewLangileaInfo.jButtonAldaketaGorde.addMouseListener(langInfoCtr);
        viewLangileaInfo.jButtonAldatu.addMouseListener(langInfoCtr);
        viewLangileaInfo.jButtonEzabatu.addMouseListener(langInfoCtr);
        viewLangileaInfo.jButtonGehitu.addMouseListener(langInfoCtr);
        
        // LangileaGehitu
        viewLangileaGehitu.jButtonIrten.addMouseListener(langGehituCtr);
        viewLangileaGehitu.jButtonBerriaGehitu.addMouseListener(langGehituCtr);
        viewLangileaGehitu.jButtonGorde.addMouseListener(langGehituCtr);
        viewLangileaGehitu.jButtonReset.addMouseListener(langGehituCtr);
        
        // ProduktuaAukeratu (jerts, kami, prak info)
        viewProduktuaAukeratu.jButtonIrten.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuJerts.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaGordeJerts.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldatuJerts.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonEzabatuJerts.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonGehituJerts.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuKami.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaGordeKami.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldatuKami.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonEzabatuKami.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonGehituKami.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaEzabatuPrak.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldaketaGordePrak.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonAldatuPrak.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonEzabatuPrak.addMouseListener(prodAukCtr);
        viewProduktuaAukeratu.jButtonGehituPrak.addMouseListener(prodAukCtr);
        
        // JertseaGehitu
        viewJertseaGehitu.jButtonIrten.addMouseListener(jertsGehituCtr);
        viewJertseaGehitu.jButtonBerriaGehitu.addMouseListener(jertsGehituCtr);
        viewJertseaGehitu.jButtonGorde.addMouseListener(jertsGehituCtr);
        viewJertseaGehitu.jButtonReset.addMouseListener(jertsGehituCtr);
        
        // KamisetaGehitu
        viewKamisetaGehitu.jButtonIrten.addMouseListener(kamiGehituCtr);
        viewKamisetaGehitu.jButtonBerriaGehitu.addMouseListener(kamiGehituCtr);
        viewKamisetaGehitu.jButtonGorde.addMouseListener(kamiGehituCtr);
        viewKamisetaGehitu.jButtonReset.addMouseListener(kamiGehituCtr);
        
        // PrakaGehitu
        viewPrakaGehitu.jButtonIrten.addMouseListener(prakGehituCtr);
        viewPrakaGehitu.jButtonBerriaGehitu.addMouseListener(prakGehituCtr);
        viewPrakaGehitu.jButtonGorde.addMouseListener(prakGehituCtr);
        viewPrakaGehitu.jButtonReset.addMouseListener(prakGehituCtr);
        
        // HornitzaileaInfo
        viewHornitzaileaInfo.jButtonIrten.addMouseListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonAldaketaEzabatu.addMouseListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonAldaketaGorde.addMouseListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonAldatu.addMouseListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonEzabatu.addMouseListener(hornInfoCtr);
        viewHornitzaileaInfo.jButtonGehitu.addMouseListener(hornInfoCtr);
        
        // HornitzaileaGehitu
        viewHornitzaileaGehitu.jButtonIrten.addMouseListener(hornGehituCtr);
        viewHornitzaileaGehitu.jButtonBerriaGehitu.addMouseListener(hornGehituCtr);
        viewHornitzaileaGehitu.jButtonGorde.addMouseListener(hornGehituCtr);
        viewHornitzaileaGehitu.jButtonReset.addMouseListener(hornGehituCtr);
        
        // EskaeraInfo
        viewEskaeraInfo.jButtonIrten.addMouseListener(eskInfoCtr);
        viewEskaeraInfo.jButtonAldaketaEzabatu.addMouseListener(eskInfoCtr);
        viewEskaeraInfo.jButtonAldaketaGorde.addMouseListener(eskInfoCtr);
        viewEskaeraInfo.jButtonAldatu.addMouseListener(eskInfoCtr);
        viewEskaeraInfo.jButtonEzabatu.addMouseListener(eskInfoCtr);
        viewEskaeraInfo.jButtonGehitu.addMouseListener(eskInfoCtr);
        
        // EskaeraGehitu
        viewEskaeraGehitu.jButtonIrten.addMouseListener(eskGehituCtr);
        viewEskaeraGehitu.jButtonBerriaGehitu.addMouseListener(eskGehituCtr);
        viewEskaeraGehitu.jButtonGorde.addMouseListener(eskGehituCtr);
        viewEskaeraGehitu.jButtonReset.addMouseListener(eskGehituCtr);
        viewEskaeraGehitu.jRadioButtonJerts.addMouseListener(eskGehituCtr);
        viewEskaeraGehitu.jRadioButtonKami.addMouseListener(eskGehituCtr);
        viewEskaeraGehitu.jRadioButtonPrak.addMouseListener(eskGehituCtr);
        
        // Produktua Inbentario Eskatzekoak
        viewProdInbEsk.jButtonIrten.addMouseListener(prodInbEskCtr);
        
        // ProduktuaKontsultatu
        viewProdKontsultatu.jRadioButtonJerts.addMouseListener(prodKontsCtr);
        viewProdKontsultatu.jRadioButtonKami.addMouseListener(prodKontsCtr);
        viewProdKontsultatu.jRadioButtonPrak.addMouseListener(prodKontsCtr);
        viewProdKontsultatu.jButtonBidali.addMouseListener(prodKontsCtr);
        viewProdKontsultatu.jButtonEzeztatu.addMouseListener(prodKontsCtr);
        viewProdKontsultatu.jButtonIrten.addMouseListener(prodKontsCtr);
        
        
        // ProduktuaSaldu
        viewProdSaldu.jRadioButtonJerts.addMouseListener(prodSalduCtr);
        viewProdSaldu.jRadioButtonKami.addMouseListener(prodSalduCtr);
        viewProdSaldu.jRadioButtonPrak.addMouseListener(prodSalduCtr);
        viewProdSaldu.jButtonSaldu.addMouseListener(prodSalduCtr);
        viewProdSaldu.jButtonEzeztatu.addMouseListener(prodSalduCtr);
        viewProdSaldu.jButtonIrten.addMouseListener(prodSalduCtr);
        
        /* ListSelectionListener */
        viewDendaInfo.jTableDendaInfo.getSelectionModel().addListSelectionListener(dendInfoCtr);
        viewBezeroaInfo.jTableBezeroaInfo.getSelectionModel().addListSelectionListener(bezInfoCtr);
        viewLangileaInfo.jTableLangileaInfo.getSelectionModel().addListSelectionListener(langInfoCtr);
        viewProduktuaAukeratu.jTableJertsInfo.getSelectionModel().addListSelectionListener(prodAukCtr);
        viewProduktuaAukeratu.jTableKamiInfo.getSelectionModel().addListSelectionListener(prodAukCtr);
        viewProduktuaAukeratu.jTablePrakInfo.getSelectionModel().addListSelectionListener(prodAukCtr);
        viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectionModel().addListSelectionListener(hornInfoCtr);
        viewEskaeraInfo.jTableEskaeraInfo.getSelectionModel().addListSelectionListener(eskInfoCtr);

        /* KeyListener */
        viewDendaInfo.jTextFieldBilatu.addKeyListener(dendInfoCtr);
        viewBezeroaInfo.jTextFieldBilatu.addKeyListener(bezInfoCtr);
        viewLangileaInfo.jTextFieldBilatu.addKeyListener(langInfoCtr);
        viewProduktuaAukeratu.jTextFieldBilatuJerts.addKeyListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldBilatuKami.addKeyListener(prodAukCtr);
        viewProduktuaAukeratu.jTextFieldBilatuPrak.addKeyListener(prodAukCtr);
        viewHornitzaileaInfo.jTextFieldBilatu.addKeyListener(hornInfoCtr);
        viewEskaeraInfo.jTextFieldBilatu.addKeyListener(eskInfoCtr);
        viewProdInbEsk.jTextFieldBilatuJerts.addKeyListener(prodInbEskCtr);
        viewProdInbEsk.jTextFieldBilatuKami.addKeyListener(prodInbEskCtr);
        viewProdInbEsk.jTextFieldBilatuPrak.addKeyListener(prodInbEskCtr);
        
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
        viewLangileaInfo.jComboBoxDenda.addFocusListener(langInfoCtr);
        
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
        viewLangileaGehitu.jComboBoxDenda.addFocusListener(langGehituCtr);
        
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
        viewEskaeraInfo.jTextFieldProdKode.addFocusListener(eskInfoCtr);
        viewEskaeraInfo.jComboBoxProdTaila.addFocusListener(eskInfoCtr);
        
        // EskaeraGehitu
        viewEskaeraGehitu.jTextFieldKopurua.addFocusListener(eskGehituCtr);
        viewEskaeraGehitu.jComboBoxHornitzailea.addFocusListener(eskGehituCtr);
        viewEskaeraGehitu.jTextFieldProdKode.addFocusListener(eskGehituCtr);
        viewEskaeraGehitu.jComboBoxProdTaila.addFocusListener(eskGehituCtr);
        
        // ProdKontsultatu
        viewProdKontsultatu.jTextFieldKodeProd.addFocusListener(prodKontsCtr);
        
        // ProdSaldu
        viewProdSaldu.jTextFieldKodeProd.addFocusListener(prodSalduCtr);
        viewProdSaldu.jComboBoxTaila.addFocusListener(prodSalduCtr);
        viewProdSaldu.jTextFieldKantitatea.addFocusListener(prodSalduCtr);
    }
    
    private void hasieratu() {        
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
        dendaIzenaKargatu(viewLangileaGehitu.jComboBoxDenda);
        dendaIzenaKargatu(viewLangileaInfo.jComboBoxDenda);
    }
    
    public void hornitzaileaKargatu(JComboBox comboBox) {
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
    
    public void tailaKargatuString(JComboBox comboBox) {
        String[] taila = ProduktuaKudeatu.tailaKontrolatuString();
        comboBox.addItem("--- Aukeratu ---");
        for (String i : taila) {
            comboBox.addItem(i);
        }
    }
    
    public void tailaKargatuInt(JComboBox comboBox) {
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
    
    public void dendaIzenaKargatu(JComboBox comboBox) {
        ArrayList<Denda> dendGuzt = DendaKudeatu.dendGuztiakErakutsi(); // denda objetua gorde
        ArrayList<String> alDendaIzenak = new ArrayList(); // denda izena bakarrik gordeko da
        for (Denda dend : dendGuzt) { // izena alDendaIzenak-en gorde
            alDendaIzenak.add(dend.getIzena());
        }
        comboBox.addItem("--- Aukeratu ---");
        for (int i = 0; i < alDendaIzenak.size(); i++) { // izenak comboBox-ean gorde
            comboBox.addItem(alDendaIzenak.get(i));
        }
    }
    
    public void enableComponents (Container container, boolean bool) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                component.setEnabled(bool);
            }
        }
    }
    
    public void txtBilatuTaulan(JTable taula, String textua) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(taula.getModel());
        taula.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(textua));
    }
    
    public boolean zenbakiaDa(String s){
	try {
            Integer.parseInt(s);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
    
    /* xxxInfo-ko botoien formatua definitzen da */
    public void botoiFormatoa (JButton botoia) {
        Color urdina = new Color(0,0,153);
        botoia.setBorderPainted(true); // botoien ertzak margotuta
        botoia.setForeground(urdina); // botoiaren textuaren kolorea
        botoia.setBackground(Color.WHITE); // botoiaren fondo kolorea
    }

    void tailaGuztKargatu(JComboBox comboBox) {
        comboBox.addItem("--- Aukeratu ---");
        int[] taila = ProduktuaKudeatu.tailaKontrolatuZenb();
        for (int i : taila) {
            comboBox.addItem(String.valueOf(i));
        }
        String[] taila2 = ProduktuaKudeatu.tailaKontrolatuString();
        for (String i : taila2) {
            comboBox.addItem(i);
        }
    }
}