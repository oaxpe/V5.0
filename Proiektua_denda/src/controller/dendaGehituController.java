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
public class dendaGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Denda denda;
    
    /* Bistak */
    private DendaInfo viewDendaInfo;
    private DendaGehitu viewDendaGehitu;
    private LangileaInfo viewLangileaInfo;
    private LangileaGehitu viewLangileaGehitu;
    
    private Color urdina = new Color(0,0,153);
    private Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public dendaGehituController(Denda denda, DendaInfo viewDendInfo, DendaGehitu viewDendGehitu, LangileaInfo viewLangInfo, LangileaGehitu viewLangGehitu) {
        this.denda = denda;
        this.viewDendaInfo = viewDendInfo;
        this.viewDendaGehitu = viewDendGehitu;
        this.viewLangileaInfo = viewLangInfo;
        this.viewLangileaGehitu = viewLangGehitu;
        dendGehituEstiloa();
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* instantzia berriak, bertako metodoak erabiltzeko */
        Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
        dendaInfoController dendInfoCtr = new dendaInfoController();
        
        /* DendaGehitu-ko aukerak */
        if (comando == viewDendaGehitu.jButtonBerriaGehitu) {
            ctr.enableComponents(viewDendaGehitu.jPanelDendDatuak, true);
        }
        else if (comando == viewDendaGehitu.jButtonGorde) {
            if (balidazioaDendaGehitu()) {
                try {
                    Denda d = new Denda(viewDendaGehitu.jTextFieldIzena.getText(), viewDendaGehitu.jTextFieldHelbidea.getText(), 
                        viewDendaGehitu.jTextFieldHerria.getText(), Integer.parseInt(viewDendaGehitu.jTextFieldPostKod.getText()), 
                        viewDendaGehitu.jTextFieldTlf.getText(), viewDendaGehitu.jTextFieldEmail.getText());
                    boolean gehitu = DendaKudeatu.dendaGehitu(d); /* booleano bat bueltatuko du, gehitu bada edo ez jakiteko */
                    if (gehitu) 
                        JOptionPane.showMessageDialog(null, "Denda erregistratu da", "EGINDA!", JOptionPane.PLAIN_MESSAGE); // ventana emergente
                    else
                        JOptionPane.showMessageDialog(null, "Ez da dendarik erregistratu", "KONTUZ!", JOptionPane.ERROR); // ventana emergente
                    viewLangileaGehitu.jComboBoxDenda.removeAllItems();
                    ctr.dendaIzenaKargatu(viewLangileaGehitu.jComboBoxDenda);
                    viewLangileaInfo.jComboBoxDenda.removeAllItems();
                    ctr.dendaIzenaKargatu(viewLangileaInfo.jComboBoxDenda);
                }
                catch (Exception ex) {
                    // fitxategia ez bada existitzen, errorea ematen  du.
                }
                resetDendaGehitu();
                ctr.enableComponents(viewDendaGehitu.jPanelDendDatuak, false);
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
            dendInfoCtr.dendDatuakErakutsiTaula(viewDendaInfo.jTableDendaInfo, DendaKudeatu.dendGuztiakErakutsi());
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
        if (comando == viewDendaGehitu.jButtonIrten) {
            viewDendaGehitu.jButtonIrten.setBackground(new Color (0,0,51));
            viewDendaGehitu.jButtonIrten.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if (comando == viewDendaGehitu.jButtonBerriaGehitu)
            viewDendaGehitu.jButtonBerriaGehitu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewDendaGehitu.jButtonGorde)
            viewDendaGehitu.jButtonGorde.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewDendaGehitu.jButtonReset)
            viewDendaGehitu.jButtonReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewDendaGehitu.jButtonIrten) {
            viewDendaGehitu.jButtonIrten.setBackground(urdina);
            viewDendaGehitu.jButtonIrten.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if (comando == viewDendaGehitu.jButtonBerriaGehitu)
            viewDendaGehitu.jButtonBerriaGehitu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewDendaGehitu.jButtonGorde)
            viewDendaGehitu.jButtonGorde.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewDendaGehitu.jButtonReset)
            viewDendaGehitu.jButtonReset.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }


    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // DendaGehitu
        if (comando == viewDendaGehitu.jTextFieldIzena) 
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
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();       
        // DendaGehitu
        if (comando == viewDendaGehitu.jTextFieldIzena) 
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
    }
        
    /* METODOAK */
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
        
        viewDendaGehitu.jTextFieldTlf.setToolTipText(null);
        viewDendaGehitu.jTextFieldEmail.setToolTipText(null);
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
            viewDendaGehitu.jTextFieldPostKod.setToolTipText(null);
            bool = false;
        }
        else if (!ctr.zenbakiaDa(viewDendaGehitu.jTextFieldPostKod.getText())) { // sartutako balioa, zenbakia den edo ez konprobatzen du
            viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewDendaGehitu.jTextFieldPostKod.setToolTipText("Zenbakia izan behar da");
            bool = false;
        }
        else 
            viewDendaGehitu.jTextFieldPostKod.setToolTipText(null);
        if (viewDendaGehitu.jTextFieldTlf.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewDendaGehitu.jTextFieldTlf.setToolTipText(null);
            bool = false;
        }
        else if (!Metodoak.tlfBalidazioa(viewDendaGehitu.jTextFieldTlf.getText())) { // sartutako balioa, egokia den konprobatzen du (expresio erregularrekin)
            viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewDendaGehitu.jTextFieldTlf.setToolTipText("Telefono zenbaki okerra");
            bool = false;
        }
        else 
            viewDendaGehitu.jTextFieldTlf.setToolTipText(null);
        if (viewDendaGehitu.jTextFieldEmail.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewDendaGehitu.jTextFieldEmail.setToolTipText(null);
            bool = false;
        }
        else if (!Metodoak.emailBalidazioa(viewDendaGehitu.jTextFieldEmail.getText())) { // sartutako balioa, egokia den konprobatzen du (expresio erregularrekin)
            viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewDendaGehitu.jTextFieldEmail.setToolTipText("Email kontu okerra");
            bool = false;
        }
        else 
            viewDendaGehitu.jTextFieldEmail.setToolTipText(null);
        return bool;
    }
}