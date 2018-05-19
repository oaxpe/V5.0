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
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class prodAukController implements ActionListener, MouseListener, AncestorListener, ListSelectionListener, ListDataListener, FocusListener, KeyListener {
    /* Model */
    private Jertsea jertsea;
    private Kamiseta kamiseta;
    private Praka praka;
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private ProduktuaAukeratu viewProduktuaAukeratu;
    private JertseaGehitu viewJertseaGehitu;
    private KamisetaGehitu viewKamisetaGehitu;
    private PrakaGehitu viewPrakaGehitu;
    
    private Color urdina = new Color(0,0,153);
    private Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public prodAukController(Jertsea jerts, Kamiseta kami, Praka prak, ProduktuaAukeratu viewProdAuk, 
            JertseaGehitu viewJertsGehitu, KamisetaGehitu viewKamGehitu, PrakaGehitu viewPrakGehitu, 
            MenuNagusia viewMenuNag) {
        this.jertsea = jerts;
        this.kamiseta = kami;
        this.praka = prak;
        this.viewProduktuaAukeratu = viewProdAuk;
        this.viewJertseaGehitu = viewJertsGehitu;
        this.viewKamisetaGehitu = viewKamGehitu;
        this.viewPrakaGehitu = viewPrakGehitu;
        this.viewMenuNagusia = viewMenuNag;
        prodInfoEstiloa();
    }
    
    public prodAukController() {
        
    }
    
    /* METODOAK */
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
        
        // tauletako estiloa
        viewProduktuaAukeratu.jTableJertsInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTableJertsInfo.setShowHorizontalLines(true);
        viewProduktuaAukeratu.jTableKamiInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTableKamiInfo.setShowHorizontalLines(true);
        viewProduktuaAukeratu.jTablePrakInfo.setShowGrid(false);
        viewProduktuaAukeratu.jTablePrakInfo.setShowHorizontalLines(true);

        /* Kodeak ezin dira aldatu */
        viewProduktuaAukeratu.jTextFieldKodeJerts.setEditable(false);
        viewProduktuaAukeratu.jTextFieldKodeKami.setEditable(false);
        viewProduktuaAukeratu.jTextFieldKodePrak.setEditable(false);
    }

    public void jertsDatuakErakutsiTaula(JTable taula, ArrayList<Jertsea> jertsGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        taula.setModel(model);
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
    
    public void kamiDatuakErakutsiTaula(JTable taula, ArrayList<Kamiseta> kamiGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        taula.setModel(model);
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
    
    public void prakDatuakErakutsiTaula(JTable taula, ArrayList<Praka> prakGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        taula.setModel(model);
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
        /* ProduktuakAukeratu-ko aukerak */
        if (comando == viewProduktuaAukeratu.jButtonGehituJerts) {
            viewJertseaGehitu.setVisible(true);
            viewProduktuaAukeratu.setEnabled(false);
            ctr.enableComponents(viewJertseaGehitu.jPanelJertsDatuak, false);
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
                jertsDatuakErakutsiTaula(viewProduktuaAukeratu.jTableJertsInfo, JertseaKudeatu.jertsGuztErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da jertserik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldatuJerts) {
            if (viewProduktuaAukeratu.jTableJertsInfo.getSelectedRow()!=-1) {
                ctr.enableComponents(viewProduktuaAukeratu.jPanelJertsInfo, true);
                ctr.enableComponents(viewProduktuaAukeratu.jPanelJertsBotoiak, false);
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
                ctr.enableComponents(viewProduktuaAukeratu.jPanelJertsInfo, false);
                ctr.enableComponents(viewProduktuaAukeratu.jPanelJertsBotoiak, true);
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
                    
                    jertsDatuakErakutsiTaula(viewProduktuaAukeratu.jTableJertsInfo, JertseaKudeatu.jertsGuztErakutsi());
                    ctr.enableComponents(viewProduktuaAukeratu.jPanelJertsInfo, false);
                    ctr.enableComponents(viewProduktuaAukeratu.jPanelJertsBotoiak, true);
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
            ctr.enableComponents(viewKamisetaGehitu.jPanelKamiDatuak, false);
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
                kamiDatuakErakutsiTaula(viewProduktuaAukeratu.jTableKamiInfo, KamisetaKudeatu.kamisetaGuztErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da kamisetarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldatuKami) {
            if (viewProduktuaAukeratu.jTableKamiInfo.getSelectedRow()!=-1) {
                ctr.enableComponents(viewProduktuaAukeratu.jPanelKamiInfo, true);
                ctr.enableComponents(viewProduktuaAukeratu.jPanelKamiBotoiak, false);
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
                ctr.enableComponents(viewProduktuaAukeratu.jPanelKamiInfo, false);
                ctr.enableComponents(viewProduktuaAukeratu.jPanelKamiBotoiak, true);
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
                    
                    kamiDatuakErakutsiTaula(viewProduktuaAukeratu.jTableKamiInfo, KamisetaKudeatu.kamisetaGuztErakutsi());
                    ctr.enableComponents(viewProduktuaAukeratu.jPanelKamiInfo, false);
                    ctr.enableComponents(viewProduktuaAukeratu.jPanelKamiBotoiak, true);
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
            ctr.enableComponents(viewPrakaGehitu.jPanelPrakDatuak, false);
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
                prakDatuakErakutsiTaula(viewProduktuaAukeratu.jTablePrakInfo, PrakaKudeatu.prakaGutztErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da prakarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewProduktuaAukeratu.jButtonAldatuPrak) {
            if (viewProduktuaAukeratu.jTablePrakInfo.getSelectedRow()!=-1) {
                ctr.enableComponents(viewProduktuaAukeratu.jPanelPrakInfo, true);
                ctr.enableComponents(viewProduktuaAukeratu.jPanelPrakBotoiak, false);
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
                ctr.enableComponents(viewProduktuaAukeratu.jPanelPrakInfo, false);
                ctr.enableComponents(viewProduktuaAukeratu.jPanelPrakBotoiak, true);
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
                    
                    prakDatuakErakutsiTaula(viewProduktuaAukeratu.jTablePrakInfo, PrakaKudeatu.prakaGutztErakutsi());
                    ctr.enableComponents(viewProduktuaAukeratu.jPanelPrakInfo, false);
                    ctr.enableComponents(viewProduktuaAukeratu.jPanelPrakBotoiak, true);
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
            ctr.enableComponents(viewProduktuaAukeratu.jPanelGoiburua, false);
            ctr.enableComponents(viewProduktuaAukeratu.jPanelAukerak, false);
            viewProduktuaAukeratu.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (viewProduktuaAukeratu.jToggleButtonErakutsi.isSelected()) {
            ctr.enableComponents(viewProduktuaAukeratu.jPanelGoiburua, true);
        }
        else if (viewProduktuaAukeratu.jToggleButtonEzkutatu.isSelected()) {
            ctr.enableComponents(viewProduktuaAukeratu.jPanelGoiburua, false);
            ctr.enableComponents(viewProduktuaAukeratu.jPanelAukerak, false);
            viewProduktuaAukeratu.jComboBoxAukeratuProd.setSelectedIndex(0);
        }
    }
            
    @Override
    public void ancestorAdded(AncestorEvent event) {
        Object comando = event.getSource();
        if (comando == viewProduktuaAukeratu.jPanelJerts) {
            if (viewProduktuaAukeratu.jToggleButtonEzkutatu.isSelected()) {
                ctr.enableComponents(viewProduktuaAukeratu.jPanelJertsInfo, false);
                jertsDatuakErakutsiTaula(viewProduktuaAukeratu.jTableJertsInfo, JertseaKudeatu.jertsGuztErakutsi());
            }
            else {
                if (viewProduktuaAukeratu.jComboBoxAukeratuProd.getSelectedItem() == "Inbentarioa") {
                    jertsDatuakErakutsiTaula(viewProduktuaAukeratu.jTableJertsInfo, JertseaKudeatu.jertseaInbentarioa());
                }
            }
        }
        else if (comando == viewProduktuaAukeratu.jPanelKami) {
            ctr.enableComponents(viewProduktuaAukeratu.jPanelKamiInfo, false);
            kamiDatuakErakutsiTaula(viewProduktuaAukeratu.jTableKamiInfo, KamisetaKudeatu.kamisetaGuztErakutsi());
        }
        else if (comando == viewProduktuaAukeratu.jPanelPrak) {
            ctr.enableComponents(viewProduktuaAukeratu.jPanelPrakInfo, false);
            prakDatuakErakutsiTaula(viewProduktuaAukeratu.jTablePrakInfo, PrakaKudeatu.prakaGutztErakutsi());
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewProduktuaAukeratu.jButtonIrten)
            viewProduktuaAukeratu.jButtonIrten.setBackground(urdina);
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
            jertsDatuakErakutsiTaula(viewProduktuaAukeratu.jTableJertsInfo, JertseaKudeatu.jertseaInbentarioa());
        }
        if (viewProduktuaAukeratu.jComboBoxAukeratuProd.getSelectedItem() == "Eskatzeko dauden produktuak") {
            jertsDatuakErakutsiTaula(viewProduktuaAukeratu.jTableJertsInfo, JertseaKudeatu.jertseaEskatzeko());
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
            ctr.txtBilatuTaulan(viewProduktuaAukeratu.jTableJertsInfo, viewProduktuaAukeratu.jTextFieldBilatuJerts.getText());
        else if (comando == viewProduktuaAukeratu.jTextFieldBilatuKami)
            ctr.txtBilatuTaulan(viewProduktuaAukeratu.jTableKamiInfo, viewProduktuaAukeratu.jTextFieldBilatuKami.getText());
        else if (comando == viewProduktuaAukeratu.jTextFieldBilatuPrak)
            ctr.txtBilatuTaulan(viewProduktuaAukeratu.jTablePrakInfo, viewProduktuaAukeratu.jTextFieldBilatuPrak.getText());
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
}