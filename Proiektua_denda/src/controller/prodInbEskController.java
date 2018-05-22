/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*; // model-eko guztia importatu.
import view.*; // bista guztiak importatu
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class prodInbEskController implements ActionListener, MouseListener, KeyListener {
    /* Model */
    private Jertsea jertsea;
    private Kamiseta kamiseta;
    private Praka praka;
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private ProdInbEsk viewProdInbEsk;

    private Color urdina = new Color(0,0,153);
    private Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public prodInbEskController(Jertsea jerts, Kamiseta kami, Praka prak, MenuNagusia viewMenuNag, ProdInbEsk viewProdInbEsk) {
        this.jertsea = jerts;
        this.kamiseta = kami;
        this.praka = prak;
        this.viewMenuNagusia = viewMenuNag;
        this.viewProdInbEsk = viewProdInbEsk;
        ProdInbEskEstiloa();
    }
    
    public prodInbEskController() {
        
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        if (comando == viewProdInbEsk.jButtonIrten) {
            viewProdInbEsk.dispose();
            viewMenuNagusia.setEnabled(true);
            /* Bilatzeko jTextField-ak hustu */
            viewProdInbEsk.jTextFieldBilatuKami.setText(null);
            viewProdInbEsk.jTextFieldBilatuJerts.setText(null);
            viewProdInbEsk.jTextFieldBilatuPrak.setText(null);
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
        /* Xagua gainean jartzen denean */
        if (comando == viewProdInbEsk.jButtonIrten) {
            viewProdInbEsk.jButtonIrten.setBackground(new Color (0,0,51));
            viewProdInbEsk.jButtonIrten.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        /* Xagua gainetik kentzen denean */
        if (comando == viewProdInbEsk.jButtonIrten) {
            viewProdInbEsk.jButtonIrten.setBackground(urdina);
            viewProdInbEsk.jButtonIrten.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
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
        if (comando == viewProdInbEsk.jTextFieldBilatuKami)
            ctr.txtBilatuTaulan(viewProdInbEsk.jTableKamiseta, viewProdInbEsk.jTextFieldBilatuKami.getText());
        if (comando == viewProdInbEsk.jTextFieldBilatuJerts)
            ctr.txtBilatuTaulan(viewProdInbEsk.jTableJertsea, viewProdInbEsk.jTextFieldBilatuJerts.getText());
        if (comando == viewProdInbEsk.jTextFieldBilatuPrak)
            ctr.txtBilatuTaulan(viewProdInbEsk.jTablePraka, viewProdInbEsk.jTextFieldBilatuPrak.getText());
    }
        
    /* METODOAK */
    /* ProdInbEsk bistaren estiloa definitzen da */
    private void ProdInbEskEstiloa() {
        viewProdInbEsk.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewProdInbEsk.setLocationRelativeTo(null);
        viewProdInbEsk.jButtonIrten.setBackground(urdina);
        viewProdInbEsk.jButtonIrten.setForeground(Color.WHITE);
        /* Textua bilatzeko jTextField-en ertzen kolorea definitu */
        viewProdInbEsk.jTextFieldBilatuKami.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        viewProdInbEsk.jTextFieldBilatuJerts.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        viewProdInbEsk.jTextFieldBilatuPrak.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewProdInbEsk.jPanelOsoa.setBackground(Color.WHITE);
        viewProdInbEsk.jPanelGoiburua.setOpaque(false);
        viewProdInbEsk.jPanelOina.setOpaque(false);
        viewProdInbEsk.jPanelProdTaula.setOpaque(false);
        
        viewProdInbEsk.jLabelJertsea.setForeground(urdina);
        viewProdInbEsk.jLabelKamiseta.setForeground(urdina);
        viewProdInbEsk.jLabelPraka.setForeground(urdina);
        
        /* Tauletako estiloa */
        viewProdInbEsk.jTablePraka.setShowGrid(false);
        viewProdInbEsk.jTablePraka.setShowHorizontalLines(true);
        viewProdInbEsk.jTableKamiseta.setShowGrid(false);
        viewProdInbEsk.jTableKamiseta.setShowHorizontalLines(true);
        viewProdInbEsk.jTableJertsea.setShowGrid(false);
        viewProdInbEsk.jTableJertsea.setShowHorizontalLines(true);
    }
}