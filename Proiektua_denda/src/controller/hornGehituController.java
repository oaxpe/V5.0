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
public class hornGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Hornitzailea hornitzailea;
    
    /* Bistak */
    private HornitzaileaInfo viewHornitzaileaInfo;
    private HornitzaileaGehitu viewHornitzaileaGehitu;
    private EskaeraGehitu viewEskaeraGehitu;
    
    private Color urdina = new Color(0,0,153);
    
    /* ERAIKITZAILEA */   
    public hornGehituController(Hornitzailea horn, HornitzaileaInfo viewHornInfo, HornitzaileaGehitu viewHornGehitu, EskaeraGehitu viewEskGehitu) {
        this.hornitzailea = horn;
        this.viewHornitzaileaInfo = viewHornInfo;
        this.viewHornitzaileaGehitu = viewHornGehitu;
        this.viewEskaeraGehitu = viewEskGehitu;
        hornGehituEstiloa();
    }
    
    /* METODOAK */        
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
    
    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* instantzia berriak, bertako metodoak erabiltzeko */
        Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
        hornInfoController hornInfoCtr = new hornInfoController();
        
        /* HornitzaileaGehituko aukerak */
        if (comando == viewHornitzaileaGehitu.jButtonBerriaGehitu) {
            ctr.enableComponents(viewHornitzaileaGehitu.jPanelHornDatuak, true);
        }
        else if (comando == viewHornitzaileaGehitu.jButtonGorde) {
            if (balidazioaHornGehitu()) {
                Hornitzailea horn = new Hornitzailea(viewHornitzaileaGehitu.jTextFieldIzena.getText(), viewHornitzaileaGehitu.jTextFieldHerria.getText(),
                        viewHornitzaileaGehitu.jTextFieldTlf.getText(), viewHornitzaileaGehitu.jTextFieldEmail.getText());
                HornitzaileaKudeatu.hornitzaileaGehitu(horn);
                resetHornitzaileaGehitu();
                ctr.enableComponents(viewHornitzaileaGehitu.jPanelHornDatuak, false);
                // Hornitzaileak aktualizatu
                viewEskaeraGehitu.jComboBoxHornitzailea.removeAllItems();
                ctr.hornitzaileaKargatu(viewEskaeraGehitu.jComboBoxHornitzailea);
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
            hornInfoCtr.hornDatuakErakutsiTaula(viewHornitzaileaInfo.jTableHornitzaileaInfo, HornitzaileaKudeatu.hornitzaileGuztiakErakutsi());
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
        if (comando == viewHornitzaileaGehitu.jButtonIrten)
            viewHornitzaileaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewHornitzaileaGehitu.jButtonIrten)
            viewHornitzaileaGehitu.jButtonIrten.setBackground(urdina);  
    }   

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // HornitzaileaGehitu
        if (comando == viewHornitzaileaGehitu.jTextFieldIzena)
            viewHornitzaileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaGehitu.jTextFieldHerria)
            viewHornitzaileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaGehitu.jTextFieldEmail)
            viewHornitzaileaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewHornitzaileaGehitu.jTextFieldTlf)
            viewHornitzaileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // HornitzaileaGehitu
        if (comando == viewHornitzaileaGehitu.jTextFieldIzena)
            viewHornitzaileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaGehitu.jTextFieldHerria)
            viewHornitzaileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaGehitu.jTextFieldEmail)
            viewHornitzaileaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewHornitzaileaGehitu.jTextFieldTlf)
            viewHornitzaileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
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
}