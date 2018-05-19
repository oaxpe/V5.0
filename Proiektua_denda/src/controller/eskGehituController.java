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
public class eskGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Eskaera eskaera;
    
    /* Bistak */
    private EskaeraInfo viewEskaeraInfo;
    private EskaeraGehitu viewEskaeraGehitu;
    
    private Color urdina = new Color(0,0,153);
    
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
        }
        else if (comando == viewEskaeraGehitu.jButtonGorde){
            if (balidazioaEskGehitu()) {
                Eskaera esk = new Eskaera (viewEskaeraGehitu.jComboBoxHornitzailea.getSelectedItem().toString(), 
                        Integer.parseInt(viewEskaeraGehitu.jTextFieldKopurua.getText()));
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
        if (comando == viewEskaeraGehitu.jButtonIrten)
            viewEskaeraGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewEskaeraGehitu.jButtonIrten)
            viewEskaeraGehitu.jButtonIrten.setBackground(urdina);
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
         // EskaeraGehitu
        if (comando == viewEskaeraGehitu.jTextFieldKopurua)
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));   
        else if (comando == viewEskaeraGehitu.jComboBoxHornitzailea) 
            viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(urdina, 1)); 
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // EskaeraGehitu
        if (comando == viewEskaeraGehitu.jTextFieldKopurua)
            viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));   
        else if (comando == viewEskaeraGehitu.jComboBoxHornitzailea) 
            viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
        
    /* METODOAK */       
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
    
    private void resetEskaeraGehitu() {
        viewEskaeraGehitu.jComboBoxHornitzailea.setSelectedIndex(0);
        viewEskaeraGehitu.jTextFieldKopurua.setText(null);
        
        viewEskaeraGehitu.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraGehitu.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
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
}