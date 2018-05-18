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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class hornInfoController implements ActionListener, MouseListener, ListSelectionListener, FocusListener, KeyListener {
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
    public hornInfoController(Hornitzailea horn, HornitzaileaInfo viewHornInfo, HornitzaileaGehitu viewHornGehitu, MenuNagusia viewMenuNag) {
        this.hornitzailea = horn;
        this.viewHornitzaileaInfo = viewHornInfo;
        this.viewHornitzaileaGehitu = viewHornGehitu;
        this.viewMenuNagusia = viewMenuNag;
        hornInfoEstiloa();
    }
    
    /* METODOAK */
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
        
        // tauletako estiloa
        viewHornitzaileaInfo.jTableHornitzaileaInfo.setShowGrid(false);
        viewHornitzaileaInfo.jTableHornitzaileaInfo.setShowHorizontalLines(true);
        
        /* Kodeak ezin dira aldatu */
        viewHornitzaileaInfo.jTextFieldKodeHor.setEditable(false);
    }

    /* METODOAK */ 
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
    
    private void enableComponets (Container container, boolean bool) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                component.setEnabled(bool);
            }
        }
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
    
    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* HornitzaileaInfo-ko aukerak */
        if (comando == viewHornitzaileaInfo.jButtonGehitu) {
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
        if (comando == viewHornitzaileaInfo.jButtonIrten)
            viewHornitzaileaInfo.jButtonIrten.setBackground(new Color (0,0,51));   
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewHornitzaileaInfo.jButtonIrten)
            viewHornitzaileaInfo.jButtonIrten.setBackground(urdina);  
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        /* Tauletako lerroak aukeratzerakoan */
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (lsm == viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetHornInfo();
            }
            else {
                viewHornitzaileaInfo.jTableHornitzaileaInfo.setSelectionBackground(urdina);
                viewHornitzaileaInfo.jTableHornitzaileaInfo.setSelectionForeground(Color.WHITE);
                aukHornDatuakBete(viewHornitzaileaInfo.jTableHornitzaileaInfo.getSelectedRow());
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // HornitzaileaInfo
        if (comando == viewHornitzaileaInfo.jTextFieldKodeHor)
            viewHornitzaileaInfo.jTextFieldKodeHor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaInfo.jTextFieldIzena)
            viewHornitzaileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaInfo.jTextFieldHerria)
            viewHornitzaileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaInfo.jTextFieldEmail)
            viewHornitzaileaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaInfo.jTextFieldTlf)
            viewHornitzaileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // HornitzaileaInfo
        if (comando == viewHornitzaileaInfo.jTextFieldKodeHor)
            viewHornitzaileaInfo.jTextFieldKodeHor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaInfo.jTextFieldIzena)
            viewHornitzaileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaInfo.jTextFieldHerria)
            viewHornitzaileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaInfo.jTextFieldEmail)
            viewHornitzaileaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaInfo.jTextFieldTlf)
            viewHornitzaileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
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
         if (comando == viewHornitzaileaInfo.jTextFieldBilatu)
            txtBilatuTaulan(viewHornitzaileaInfo.jTableHornitzaileaInfo, viewHornitzaileaInfo.jTextFieldBilatu.getText());
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
    
    private void resetHornInfoErr() {
        viewHornitzaileaInfo.jTextFieldKodeHor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewHornitzaileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
    
    private void txtBilatuTaulan(JTable taula, String textua) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(taula.getModel());
        taula.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(textua));
    }
}