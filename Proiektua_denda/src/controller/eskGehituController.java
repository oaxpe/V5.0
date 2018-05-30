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
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class eskGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Eskaera eskaera;
    
    /* Bistak */
    private EskaeraInfo viewEskaeraInfo;
    private EskaeraGehitu viewEskaeraGehitu;
    
    private Color urdina = new Color(0,0,153);
    private Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public eskGehituController(Eskaera esk, EskaeraInfo viewEskInfo, EskaeraGehitu viewEskGehitu) {
        this.eskaera = esk;
        this.viewEskaeraInfo = viewEskInfo;
        this.viewEskaeraGehitu = viewEskGehitu;
        eskGehituEstiloa();
    }
    
    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* instantzia berriak, bertako metodoak erabiltzeko */
        Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
        eskInfoController eskInfoCtr = new eskInfoController();
        
        /* EskaeraGehitu-ko aukerak */
        if (comando == viewEskaeraGehitu.jButtonBerriaGehitu) {
            ctr.enableComponents(viewEskaeraGehitu.jPanelEskDatuak, true);
            viewEskaeraGehitu.jComboBoxHornitzailea.removeAllItems();
            ctr.hornitzaileaKargatu(viewEskaeraGehitu.jComboBoxHornitzailea);
        }
        else if (comando == viewEskaeraGehitu.jButtonGorde){
            if (balidazioaEskGehitu()) {
                Eskaera esk = new Eskaera (viewEskaeraGehitu.jComboBoxHornitzailea.getSelectedItem().toString(), 
                        Integer.parseInt(viewEskaeraGehitu.jTextFieldKopurua.getText()), 
                        viewEskaeraGehitu.jTextFieldProdKode.getText(), viewEskaeraGehitu.jComboBoxProdTaila.getSelectedItem().toString());
                EskaeraKudeatu.eskaeraGehitu(esk);
                resetEskaeraGehitu();
                ctr.enableComponents(viewEskaeraGehitu.jPanelEskDatuak, false);
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
            eskInfoCtr.eskDatuakErakutsiTaula(viewEskaeraInfo.jTableEskaeraInfo, EskaeraKudeatu.eskaeraGuztiakErakutsi());
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object comando = me.getSource();
        /* Produktu mota aukeratzen denean, Taila ComboBox-ean kargatuko da (motaren arabera) */
        if (comando == viewEskaeraGehitu.jRadioButtonJerts || comando == viewEskaeraGehitu.jRadioButtonKami) {
            viewEskaeraGehitu.jComboBoxProdTaila.removeAllItems();
            ctr.tailaKargatuString(viewEskaeraGehitu.jComboBoxProdTaila);
        }
        else if (comando == viewEskaeraGehitu.jRadioButtonPrak) {
            ctr.enableComponents(viewEskaeraGehitu.jComboBoxProdTaila, true);
            viewEskaeraGehitu.jComboBoxProdTaila.removeAllItems();
            ctr.tailaKargatuInt(viewEskaeraGehitu.jComboBoxProdTaila);
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
        if (comando == viewEskaeraGehitu.jButtonIrten) {
            viewEskaeraGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
            viewEskaeraGehitu.jButtonIrten.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if (comando == viewEskaeraGehitu.jButtonBerriaGehitu)
            viewEskaeraGehitu.jButtonBerriaGehitu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewEskaeraGehitu.jButtonGorde)
            viewEskaeraGehitu.jButtonGorde.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewEskaeraGehitu.jButtonReset)
            viewEskaeraGehitu.jButtonReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewEskaeraGehitu.jButtonIrten) {
            viewEskaeraGehitu.jButtonIrten.setBackground(urdina);
            viewEskaeraGehitu.jButtonIrten.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if (comando == viewEskaeraGehitu.jButtonBerriaGehitu)
            viewEskaeraGehitu.jButtonBerriaGehitu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewEskaeraGehitu.jButtonGorde)
            viewEskaeraGehitu.jButtonGorde.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewEskaeraGehitu.jButtonReset)
            viewEskaeraGehitu.jButtonReset.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
         // EskaeraGehitu
        if (comando == viewEskaeraGehitu.jTextFieldKopurua)
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));   
        else if (comando == viewEskaeraGehitu.jComboBoxHornitzailea) 
            viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(urdina, 1)); 
        else if (comando == viewEskaeraGehitu.jComboBoxProdTaila)
            viewEskaeraGehitu.jComboBoxProdTaila.setBorder(BorderFactory.createLineBorder(urdina, 1)); 
        else if (comando == viewEskaeraGehitu.jTextFieldProdKode)
            viewEskaeraGehitu.jTextFieldProdKode.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));   
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // EskaeraGehitu
        if (comando == viewEskaeraGehitu.jTextFieldKopurua)
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));   
        else if (comando == viewEskaeraGehitu.jComboBoxHornitzailea) 
            viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewEskaeraGehitu.jComboBoxProdTaila)
            viewEskaeraGehitu.jComboBoxProdTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0)); 
        else if (comando == viewEskaeraGehitu.jTextFieldProdKode)
            viewEskaeraGehitu.jTextFieldProdKode.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));   
    }
        
    /* METODOAK */       
    private void eskGehituEstiloa() {
        viewEskaeraGehitu.setTitle("Eskaera berria");
        viewEskaeraGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewEskaeraGehitu.setLocationRelativeTo(null);
        viewEskaeraGehitu.jButtonIrten.setBackground(urdina);
        viewEskaeraGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraGehitu.jTextFieldProdKode.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewEskaeraGehitu.jComboBoxProdTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
       
        viewEskaeraGehitu.jTextFieldKopurua.setOpaque(false);
        viewEskaeraGehitu.jComboBoxHornitzailea.setOpaque(false);
        viewEskaeraGehitu.jTextFieldProdKode.setOpaque(false);
        viewEskaeraGehitu.jComboBoxProdTaila.setOpaque(false);
        viewEskaeraGehitu.jRadioButtonKami.setOpaque(false);
        viewEskaeraGehitu.jRadioButtonJerts.setOpaque(false);
        viewEskaeraGehitu.jRadioButtonPrak.setOpaque(false);
        viewEskaeraGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewEskaeraGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewEskaeraGehitu.jPanelGoiburua.setOpaque(false);
        viewEskaeraGehitu.jPanelEskDatuak.setOpaque(false);
        
        viewEskaeraGehitu.jComboBoxProdTaila.addItem("--- Aukeratu ---"); // comboBox-a hasieratu
    }
    
    private void resetEskaeraGehitu() {
        viewEskaeraGehitu.jComboBoxHornitzailea.setSelectedIndex(0);
        viewEskaeraGehitu.jTextFieldProdKode.setText(null);
        viewEskaeraGehitu.jComboBoxProdTaila.setSelectedIndex(0);
        viewEskaeraGehitu.jTextFieldKopurua.setText(null);
        
        viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraGehitu.jTextFieldProdKode.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewEskaeraGehitu.jComboBoxProdTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
   
    private boolean balidazioaEskGehitu() {
        boolean bool = true;
        if (viewEskaeraGehitu.jComboBoxHornitzailea.getSelectedIndex() == 0) {
            viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        } 
        if (viewEskaeraGehitu.jTextFieldProdKode.getText().isEmpty()) {
            viewEskaeraGehitu.jTextFieldProdKode.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewEskaeraGehitu.jComboBoxProdTaila.getSelectedIndex() == 0) {
            viewEskaeraGehitu.jComboBoxProdTaila.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        } 
        if (viewEskaeraGehitu.jTextFieldKopurua.getText().isEmpty()) {
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewEskaeraGehitu.jTextFieldKopurua.setToolTipText(null);
            bool = false;
        }
        else if (!ctr.zenbakiaDa(viewEskaeraGehitu.jTextFieldKopurua.getText())) { // sartutako balioa, zenbakia den edo ez konprobatzen du
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewEskaeraGehitu.jTextFieldKopurua.setToolTipText("Zenbakia izan behar da");
            bool = false;
        }
        else 
            viewEskaeraGehitu.jTextFieldKopurua.setToolTipText(null);
        return bool;
    }
}