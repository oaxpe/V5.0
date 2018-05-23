/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestioa.JertseaKudeatu;
import gestioa.KamisetaKudeatu;
import gestioa.PrakaKudeatu;
import gestioa.SalmentaKudeatu;
import model.*; // model-eko guztia importatu.
import view.*; // bista guztiak importatu
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class prodSalduController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Jertsea jertsea;
    private Kamiseta kamiseta;
    private Praka praka;
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private ProdSaldu viewProdSaldu;

    private Color urdina = new Color(0,0,153);
    private Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public prodSalduController(Jertsea jerts, Kamiseta kami, Praka prak, MenuNagusia viewMenuNag, ProdSaldu viewProdSaldu) {
        this.jertsea = jerts;
        this.kamiseta = kami;
        this.praka = prak;
        this.viewMenuNagusia = viewMenuNag;
        this.viewProdSaldu = viewProdSaldu;
        ProdKontsEstiloa(); // estiloa definituta dagoen metodoa
    }
    
    public prodSalduController() {
        
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
//        prodAukController prodAukCtr = new prodAukController();
        Object comando = e.getSource();
        if (comando == viewProdSaldu.jButtonIrten) {
            viewProdSaldu.dispose();
            viewMenuNagusia.setEnabled(true);
            resetAukerak();
            ctr.enableComponents(viewProdSaldu.jPanelDatuak, false);
            taulaHustu(viewProdSaldu.jTableProdInfo); // taulan dauden datuak kendu
        }    
        else if (comando == viewProdSaldu.jButtonEzeztatu) {
            resetAukerak();
            ctr.enableComponents(viewProdSaldu.jPanelDatuak, false);

        }
        else if (comando == viewProdSaldu.jButtonSaldu) {
            if (balidazioaProdSaldu()) { // kanpo guztiak beteta dauden konprobatzen du
                /* datuak kontsultatu eta kargatu taulan */
                if (viewProdSaldu.jRadioButtonJerts.isSelected()) {
                    if (!JertseaKudeatu.prodSaldu(viewProdSaldu.jTextFieldKodeProd.getText(), Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), viewProdSaldu.jComboBoxTaila.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Ezin da saldu. \nProduktu hori ez dago dendan", "EZ DA EXISTITZEN", JOptionPane.ERROR_MESSAGE);
                        resetAukerak();
                    }
                    else {
                        JertseaKudeatu.prodSaldu(viewProdSaldu.jTextFieldKodeProd.getText(), Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), viewProdSaldu.jComboBoxTaila.getSelectedItem().toString());
                        SalmentaKudeatu.salmentaGehitu(new Salmenta(Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), viewProdSaldu.jTextFieldKodeProd.getText(), viewProdSaldu.jComboBoxTaila.getSelectedItem().toString()));
                        taulaHustu(viewProdSaldu.jTableProdInfo);
                        lerroaGehituTaulan(viewProdSaldu.jTableProdInfo, SalmentaKudeatu.salmentaGuztiakErakutsi());
                    }    
                }
                else if (viewProdSaldu.jRadioButtonKami.isSelected()) {
                    if (!KamisetaKudeatu.prodSaldu(viewProdSaldu.jTextFieldKodeProd.getText(), Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), viewProdSaldu.jComboBoxTaila.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Ezin da saldu. \nProduktu hori ez dago dendan", "EZ DA EXISTITZEN", JOptionPane.ERROR_MESSAGE);
                        resetAukerak();
                    }
                    else {
                        KamisetaKudeatu.prodSaldu(viewProdSaldu.jTextFieldKodeProd.getText(), Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), viewProdSaldu.jComboBoxTaila.getSelectedItem().toString());
                        SalmentaKudeatu.salmentaGehitu(new Salmenta(Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), viewProdSaldu.jTextFieldKodeProd.getText(), viewProdSaldu.jComboBoxTaila.getSelectedItem().toString()));
                        taulaHustu(viewProdSaldu.jTableProdInfo);
                        lerroaGehituTaulan(viewProdSaldu.jTableProdInfo, SalmentaKudeatu.salmentaGuztiakErakutsi());
                    }    
                }
                else if (viewProdSaldu.jRadioButtonPrak.isSelected()) {
                    if (!PrakaKudeatu.prodSaldu(viewProdSaldu.jTextFieldKodeProd.getText(), Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), Integer.parseInt(viewProdSaldu.jComboBoxTaila.getSelectedItem().toString()))) {
                        JOptionPane.showMessageDialog(null, "Ezin da saldu. \nProduktu hori ez dago dendan", "EZ DA EXISTITZEN", JOptionPane.ERROR_MESSAGE);
                        resetAukerak();
                    }
                    else {
                        PrakaKudeatu.prodSaldu(viewProdSaldu.jTextFieldKodeProd.getText(), Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), Integer.parseInt(viewProdSaldu.jComboBoxTaila.getSelectedItem().toString()));
                        SalmentaKudeatu.salmentaGehitu(new Salmenta(Integer.parseInt(viewProdSaldu.jTextFieldKantitatea.getText()), viewProdSaldu.jTextFieldKodeProd.getText(), viewProdSaldu.jComboBoxTaila.getSelectedItem().toString()));
                        taulaHustu(viewProdSaldu.jTableProdInfo);
                        lerroaGehituTaulan(viewProdSaldu.jTableProdInfo, SalmentaKudeatu.salmentaGuztiakErakutsi());
                    }    
                }
            }
            else 
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object comando = me.getSource();
        /* Produktu mota aukeratzen denean, Taila ComboBox-ean kargatuko da (motaren arabera) */
        if (comando == viewProdSaldu.jRadioButtonJerts || comando == viewProdSaldu.jRadioButtonKami) {
            ctr.enableComponents(viewProdSaldu.jPanelDatuak, true);
            viewProdSaldu.jComboBoxTaila.removeAllItems();
            ctr.tailaKargatuString(viewProdSaldu.jComboBoxTaila);
        }
        else if (comando == viewProdSaldu.jRadioButtonPrak) {
            ctr.enableComponents(viewProdSaldu.jPanelDatuak, true);
            viewProdSaldu.jComboBoxTaila.removeAllItems();
            ctr.tailaKargatuInt(viewProdSaldu.jComboBoxTaila);
        }
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
        /* Xagua gainean jartzen denean */
        if (comando == viewProdSaldu.jButtonIrten) {
            viewProdSaldu.jButtonIrten.setBackground(new Color (0,0,51));
            viewProdSaldu.jButtonIrten.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if (comando == viewProdSaldu.jButtonSaldu) 
            viewProdSaldu.jButtonSaldu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewProdSaldu.jButtonEzeztatu)
            viewProdSaldu.jButtonEzeztatu.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        /* Xagua gainetik kentzen denean */
        if (comando == viewProdSaldu.jButtonIrten) {
            viewProdSaldu.jButtonIrten.setBackground(urdina);
            viewProdSaldu.jButtonIrten.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if (comando == viewProdSaldu.jButtonSaldu) 
            viewProdSaldu.jButtonSaldu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewProdSaldu.jButtonEzeztatu)
            viewProdSaldu.jButtonEzeztatu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // Produktuak kontsultatzeko aukerak
        if (comando == viewProdSaldu.jTextFieldKodeProd) 
            viewProdSaldu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewProdSaldu.jComboBoxTaila)
            viewProdSaldu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewProdSaldu.jTextFieldKantitatea)
                viewProdSaldu.jTextFieldKantitatea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // Produktuak kontsultatzeko aukerak
        if (comando == viewProdSaldu.jTextFieldKodeProd) 
            viewProdSaldu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewProdSaldu.jComboBoxTaila)
            viewProdSaldu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewProdSaldu.jTextFieldKantitatea)
                viewProdSaldu.jTextFieldKantitatea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
        
    /* METODOAK */
    /* ProdKontsultatu bistaren estiloa definitzen da */
    private void ProdKontsEstiloa() {
        viewProdSaldu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewProdSaldu.setLocationRelativeTo(null);
        viewProdSaldu.jButtonIrten.setBackground(urdina);
        viewProdSaldu.jButtonIrten.setForeground(Color.WHITE);
        viewProdSaldu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        ctr.enableComponents(viewProdSaldu.jPanelDatuak, false);
        
        viewProdSaldu.jPanelOsoa.setBackground(Color.WHITE);
        viewProdSaldu.jPanelKontsultaAukerak.setOpaque(false);
        viewProdSaldu.jPanelKontsultaAukerak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        viewProdSaldu.jPanelDatuak.setOpaque(false);
        viewProdSaldu.jPanelGoiburua.setOpaque(false);
        viewProdSaldu.jPanelOina.setOpaque(false);
        viewProdSaldu.jPanelProdTaula.setOpaque(false);
        viewProdSaldu.jRadioButtonKami.setOpaque(false);
        viewProdSaldu.jRadioButtonJerts.setOpaque(false);
        viewProdSaldu.jRadioButtonPrak.setOpaque(false);
        
        /* Laguntza botoietan - xaguarekin gainean jartzean agertuko den mezuak definitu */
        viewProdSaldu.jButtonSaldu.setToolTipText("Produktua saldu");
        viewProdSaldu.jButtonEzeztatu.setToolTipText("Ezeztatu");
        
        /* Tauletako estiloa */
        taulaEstiloa(viewProdSaldu.jTableProdInfo);
        viewProdSaldu.jTableProdInfo.setShowGrid(false);
        viewProdSaldu.jTableProdInfo.setShowHorizontalLines(true);
        
        /* Botoien formatua definitu */
        botoienFormatoa(viewProdSaldu.jPanelDatuak);
        viewProdSaldu.jComboBoxTaila.removeAllItems();
        
        /* jTextField eta jComboBox-en ertzen kolorea definitu */
        viewProdSaldu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProdSaldu.jTextFieldKantitatea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewProdSaldu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    /* Produktuen kontsulta egiteko aukerak reseteatu (aukeratutakoa ezabatu) */
    private void resetAukerak() {
        viewProdSaldu.jRadioButtonJerts.setSelected(false);
        viewProdSaldu.jRadioButtonKami.setSelected(false);
        viewProdSaldu.jRadioButtonPrak.setSelected(false);
        viewProdSaldu.jTextFieldKodeProd.setText(null);
        viewProdSaldu.jTextFieldKantitatea.setText(null);
        viewProdSaldu.jComboBoxTaila.setSelectedIndex(0);
    }
    
    /* Saldu nahi den produktua aukeratzeko kanpoak hutsik ezin dira geratu. */
    private boolean balidazioaProdSaldu() {
        boolean bool = true;
        if (viewProdSaldu.jTextFieldKodeProd.getText().isEmpty()) {
            viewProdSaldu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewProdSaldu.jComboBoxTaila.getSelectedIndex() == 0) {
            viewProdSaldu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewProdSaldu.jTextFieldKantitatea.getText().isEmpty()) {
            viewProdSaldu.jTextFieldKantitatea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (!ctr.zenbakiaDa(viewProdSaldu.jTextFieldKantitatea.getText())) { // sartutako balioa, zenbakia den edo ez konprobatzen du
            viewProdSaldu.jTextFieldKantitatea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewProdSaldu.jTextFieldKantitatea.setToolTipText("Zenbakia izan behar da");
            bool = false;
        }
        else {
            viewProdSaldu.jTextFieldKantitatea.setToolTipText(null);
        }
        return bool;
    }
    
    /* Taulako datuak ezabatzen duen metodoa */
    private void taulaHustu(JTable taula) {
        DefaultTableModel dm = (DefaultTableModel) taula.getModel();
        int rowCount = dm.getRowCount(); // lerro zenbakia
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
    
    /* Panel bateko botoien formatoa definitzen duen metodoa */
    private void botoienFormatoa (Container container) {
        Color urdinArgia = new Color(102,153,255);
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).setOpaque(true);
                ((JButton) component).setIconTextGap(5); // Ikono eta textuaren arteko tartea definitu
                ((JButton) component).setHorizontalAlignment(JButton.LEFT); // Botoi barrukoa ezkerrean alineatzeko
                ((JButton) component).setBorderPainted(true); // botoien ertzak margotuta
                ((JButton) component).setForeground(urdinArgia); // botoiaren textuaren kolorea
                ((JButton) component).setBackground(Color.WHITE); // botoiaren fondo kolorea
            }
        }
    }
    
    public void taulaEstiloa (JTable taula) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        taula.getTableHeader().setBackground(urdina);
        taula.getTableHeader().setForeground(Color.WHITE);
        taula.setModel(model);
        model.addColumn("SALMENTA KODEA");
        model.addColumn("DATA");
        model.addColumn("PROD KODEA");
        model.addColumn("TAILA");
        model.addColumn("KOPURUA");
    }
    
    public void lerroaGehituTaulan (JTable taula, ArrayList<Salmenta> salmGuzt) {
        DefaultTableModel model = (DefaultTableModel) taula.getModel();
        for (int i=0; i<salmGuzt.size(); i++) {
            Salmenta salm = salmGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(salm.getSalmZenb(), i, 0);
            model.setValueAt(salm.getData(), i, 1);
            model.setValueAt(salm.getKodProd(), i, 2);
            model.setValueAt(salm.getTailaProd(), i, 3);
            model.setValueAt(salm.getKopurua(), i, 4);        
        }
    }
}