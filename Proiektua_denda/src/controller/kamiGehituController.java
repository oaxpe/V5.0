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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class kamiGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Kamiseta kamiseta;
    
    /* Bistak */
    private ProduktuaAukeratu viewProduktuaAukeratu;
    private KamisetaGehitu viewKamisetaGehitu;
    
    private Color urdina = new Color(0,0,153);
    
    /* ERAIKITZAILEA */   
    public kamiGehituController(Kamiseta kami, ProduktuaAukeratu viewProdAuk, KamisetaGehitu viewKamGehitu) {
        this.kamiseta = kami;
        this.viewProduktuaAukeratu = viewProdAuk;
        this.viewKamisetaGehitu = viewKamGehitu;
        kamiGehituEstiloa();
    }
    
    /* METODOAK */    
    private void kamiGehituEstiloa() {
        viewKamisetaGehitu.setTitle("Kamiseta berria");
        viewKamisetaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewKamisetaGehitu.setLocationRelativeTo(null);
        viewKamisetaGehitu.jButtonIrten.setBackground(urdina);
        viewKamisetaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        viewKamisetaGehitu.jTextFieldKodeKami.setOpaque(false);
        viewKamisetaGehitu.jTextFieldMarka.setOpaque(false);
        viewKamisetaGehitu.jTextFieldPrezioa.setOpaque(false);
        viewKamisetaGehitu.jTextFieldKolorea.setOpaque(false);
        viewKamisetaGehitu.jTextFieldStock.setOpaque(false);
        viewKamisetaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewKamisetaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewKamisetaGehitu.jPanelGoiburua.setOpaque(false);
        viewKamisetaGehitu.jPanelKamiDatuak.setOpaque(false);
    }
    
    private void kamiDatuakErakutsiTaula(ArrayList<Kamiseta> kamiGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewProduktuaAukeratu.jTableKamiInfo.setModel(model);
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

    private void resetKamisetaGehitu() {
        viewKamisetaGehitu.jTextFieldKodeKami.setText(null);
        viewKamisetaGehitu.jTextFieldMarka.setText(null);
        viewKamisetaGehitu.jTextFieldPrezioa.setText(null);
        viewKamisetaGehitu.jTextFieldKolorea.setText(null);
        viewKamisetaGehitu.jComboBoxSexua.setSelectedIndex(0);
        viewKamisetaGehitu.jTextFieldStock.setText(null);
        viewKamisetaGehitu.jComboBoxTaila.setSelectedIndex(0);
        viewKamisetaGehitu.jComboBoxSasoia.setSelectedIndex(0);
        
        viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private void enableComponets (Container container, boolean bool) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (!(component instanceof JLabel)) {
                component.setEnabled(bool);
            }
        }
    }
    
    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* KamisetaGehitu-ko aukerak */
        if (comando == viewKamisetaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewKamisetaGehitu.jPanelKamiDatuak, true);
        }
        else if (comando == viewKamisetaGehitu.jButtonGorde) {
            if (balidazioaKamiGehitu()) {
                Kamiseta kami = new Kamiseta (viewKamisetaGehitu.jTextFieldKodeKami.getText(), viewKamisetaGehitu.jTextFieldMarka.getText(), 
                        Double.parseDouble(viewKamisetaGehitu.jTextFieldPrezioa.getText()), viewKamisetaGehitu.jTextFieldKolorea.getText(), 
                        viewKamisetaGehitu.jComboBoxSexua.getSelectedItem().toString(), Integer.parseInt(viewKamisetaGehitu.jTextFieldStock.getText()), 
                        viewKamisetaGehitu.jComboBoxTaila.getSelectedItem().toString(), viewKamisetaGehitu.jComboBoxSasoia.getSelectedItem().toString());
                KamisetaKudeatu.kamisetaGehitu(kami);
                resetKamisetaGehitu();
                enableComponets(viewKamisetaGehitu.jPanelKamiDatuak, false);
            }   
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewKamisetaGehitu.jButtonReset) {
            resetKamisetaGehitu();
        }
        else if (comando == viewKamisetaGehitu.jButtonIrten) {
            resetKamisetaGehitu();
            viewKamisetaGehitu.dispose();
            viewProduktuaAukeratu.setEnabled(true);
            kamiDatuakErakutsiTaula(KamisetaKudeatu.kamisetaGuztErakutsi());
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
        if (comando == viewKamisetaGehitu.jButtonIrten)
            viewKamisetaGehitu.jButtonIrten.setBackground(new Color (0,0,51));   
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewKamisetaGehitu.jButtonIrten)
            viewKamisetaGehitu.jButtonIrten.setBackground(urdina);  
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // KamisetaGehitu
        if (comando == viewKamisetaGehitu.jTextFieldKodeKami)
            viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jTextFieldMarka)
            viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jTextFieldPrezioa)
            viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jTextFieldKolorea)
            viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jComboBoxSexua)
            viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewKamisetaGehitu.jTextFieldStock)
            viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewKamisetaGehitu.jComboBoxTaila)
            viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewKamisetaGehitu.jComboBoxSasoia)
            viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(urdina, 1));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // KamisetaGehitu
        if (comando == viewKamisetaGehitu.jTextFieldKodeKami)
            viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jTextFieldMarka)
            viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jTextFieldPrezioa)
            viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jTextFieldKolorea)
            viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jComboBoxSexua)
            viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewKamisetaGehitu.jTextFieldStock)
            viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewKamisetaGehitu.jComboBoxTaila)
            viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewKamisetaGehitu.jComboBoxSasoia)
            viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
   
    private boolean balidazioaKamiGehitu() {
        boolean bool = true;
        if (viewKamisetaGehitu.jTextFieldKodeKami.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldKodeKami.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewKamisetaGehitu.jTextFieldMarka.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewKamisetaGehitu.jTextFieldPrezioa.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewKamisetaGehitu.jTextFieldKolorea.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewKamisetaGehitu.jComboBoxSexua.getSelectedIndex() == 0) {
            viewKamisetaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewKamisetaGehitu.jTextFieldStock.getText().isEmpty()) {
            viewKamisetaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewKamisetaGehitu.jComboBoxTaila.getSelectedIndex() == 0) {
            viewKamisetaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewKamisetaGehitu.jComboBoxSasoia.getSelectedIndex() == 0) {
            viewKamisetaGehitu.jComboBoxSasoia.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
}