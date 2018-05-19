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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
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
    Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko

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
            ctr.enableComponents(viewDendaInfo.jPanelDendDatuak, false);
            dendDatuakErakutsiTaula(DendaKudeatu.dendGuztiakErakutsi());
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
            bezDatuakErakutsiTaula(BezeroaKudeatu.bezeroGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonLangilea) {
            viewLangileaInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            ctr.enableComponents(viewLangileaInfo.jPanelLangDatuak, false);
            langDatuakErakutsiTaula(LangileaKudeatu.langileGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonHornitzailea) {
            viewHornitzaileaInfo.setVisible(true); 
            viewMenuNagusia.setEnabled(false);
            ctr.enableComponents(viewHornitzaileaInfo.jPanelHornDatuak, false);
            hornDatuakErakutsiTaula(HornitzaileaKudeatu.hornitzaileGuztiakErakutsi());
        }
        else if (comando == viewMenuNagusia.jButtonEskaera) {
            viewEskaeraInfo.setVisible(true);
            viewMenuNagusia.setEnabled(false);
            ctr.enableComponents(viewEskaeraInfo.jPanelEskDatuak, false);
            eskDatuakErakutsiTaula(EskaeraKudeatu.eskaeraGuztiakErakutsi());
        }
    }
}