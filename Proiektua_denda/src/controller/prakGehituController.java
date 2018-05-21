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
 * @version 4.0
 */
public class prakGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Praka praka;
    
    /* Bistak */
    private ProduktuaAukeratu viewProduktuaAukeratu;
    private PrakaGehitu viewPrakaGehitu;
    
    private Color urdina = new Color(0,0,153);
    
    /* ERAIKITZAILEA */   
    public prakGehituController(Praka prak, ProduktuaAukeratu viewProdAuk, PrakaGehitu viewPrakGehitu) {
        this.praka = prak;
        this.viewProduktuaAukeratu = viewProdAuk;
        this.viewPrakaGehitu = viewPrakGehitu;
        prakGehituEstiloa();
    }
    
    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* instantzia berriak, bertako metodoak erabiltzeko */
        Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
        prodAukController prodAukCtr = new prodAukController();
        
        /* PrakaGehitu-ko aukerak */
        if (comando == viewPrakaGehitu.jButtonBerriaGehitu) {
            ctr.enableComponents(viewPrakaGehitu.jPanelPrakDatuak, true);
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
                ctr.enableComponents(viewPrakaGehitu.jPanelPrakDatuak, false);
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
            prodAukCtr.prakDatuakErakutsiTaula(viewProduktuaAukeratu.jTablePrakInfo, PrakaKudeatu.prakaGutztErakutsi());
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
        if (comando == viewPrakaGehitu.jButtonIrten) {
            viewPrakaGehitu.jButtonIrten.setBackground(new Color (0,0,51));
            viewPrakaGehitu.jButtonIrten.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if (comando == viewPrakaGehitu.jButtonBerriaGehitu)
            viewPrakaGehitu.jButtonBerriaGehitu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewPrakaGehitu.jButtonGorde)
            viewPrakaGehitu.jButtonGorde.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewPrakaGehitu.jButtonReset)
            viewPrakaGehitu.jButtonReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewPrakaGehitu.jButtonIrten) {
            viewPrakaGehitu.jButtonIrten.setBackground(urdina);
            viewPrakaGehitu.jButtonIrten.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if (comando == viewPrakaGehitu.jButtonBerriaGehitu)
            viewPrakaGehitu.jButtonBerriaGehitu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewPrakaGehitu.jButtonGorde)
            viewPrakaGehitu.jButtonGorde.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewPrakaGehitu.jButtonReset)
            viewPrakaGehitu.jButtonReset.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // PrakaGehitu
        if (comando == viewPrakaGehitu.jTextFieldKodePrak)
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
        // PrakaGehitu
        if (comando == viewPrakaGehitu.jTextFieldKodePrak)
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

    /* METODOAK */   
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
}