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
public class jertsGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Jertsea jertsea;
    
    /* Bistak */
    private ProduktuaAukeratu viewProduktuaAukeratu;
    private JertseaGehitu viewJertseaGehitu;
    
    private Color urdina = new Color(0,0,153);
    
    /* ERAIKITZAILEA */   
    public jertsGehituController(Jertsea jerts, ProduktuaAukeratu viewProdAuk, JertseaGehitu viewJertsGehitu) {
        this.jertsea = jerts;
        this.viewProduktuaAukeratu = viewProdAuk;
        this.viewJertseaGehitu = viewJertsGehitu;
        jertsGehituEstiloa();
    }
    
    /* METODOAK */        
    private void jertsGehituEstiloa() {
        viewJertseaGehitu.setTitle("Jertse berria");
        viewJertseaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewJertseaGehitu.setLocationRelativeTo(null);
        viewJertseaGehitu.jButtonIrten.setBackground(urdina);
        viewJertseaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        
        viewJertseaGehitu.jTextFieldKodeJerts.setOpaque(false);
        viewJertseaGehitu.jTextFieldMarka.setOpaque(false);
        viewJertseaGehitu.jTextFieldPrezioa.setOpaque(false);
        viewJertseaGehitu.jTextFieldKolorea.setOpaque(false);
        viewJertseaGehitu.jTextFieldStock.setOpaque(false);
        viewJertseaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewJertseaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewJertseaGehitu.jPanelGoiburua.setOpaque(false);
        viewJertseaGehitu.jPanelJertsDatuak.setOpaque(false);
    }
    
    private void jertsDatuakErakutsiTaula(ArrayList<Jertsea> jertsGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewProduktuaAukeratu.jTableJertsInfo.setModel(model);
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
 
    private void resetJertseaGehitu() {
        viewJertseaGehitu.jTextFieldKodeJerts.setText(null);
        viewJertseaGehitu.jTextFieldMarka.setText(null);
        viewJertseaGehitu.jTextFieldPrezioa.setText(null);
        viewJertseaGehitu.jTextFieldKolorea.setText(null);
        viewJertseaGehitu.jComboBoxSexua.setSelectedIndex(0);
        viewJertseaGehitu.jTextFieldStock.setText(null);
        viewJertseaGehitu.jComboBoxTaila.setSelectedIndex(0);
        
        viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
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
        /* JertseaGehitu-ko aukerak */
        if (comando == viewJertseaGehitu.jButtonBerriaGehitu){
            enableComponets(viewJertseaGehitu.jPanelJertsDatuak, true);
        }
        else if (comando == viewJertseaGehitu.jButtonGorde) {
            if (balidazioaJertsGehitu()) {
                Jertsea jerts = new Jertsea(viewJertseaGehitu.jTextFieldKodeJerts.getText(), viewJertseaGehitu.jTextFieldMarka.getText(), 
                        Double.parseDouble(viewJertseaGehitu.jTextFieldPrezioa.getText()), viewJertseaGehitu.jTextFieldKolorea.getText(), 
                        viewJertseaGehitu.jComboBoxSexua.getSelectedItem().toString(), Integer.parseInt(viewJertseaGehitu.jTextFieldStock.getText()),
                        viewJertseaGehitu.jComboBoxTaila.getSelectedItem().toString());
                JertseaKudeatu.jertsGehitu(jerts);
                resetJertseaGehitu();
                enableComponets(viewJertseaGehitu.jPanelJertsDatuak, false);
            }   
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        } 
        else if (comando == viewJertseaGehitu.jButtonReset) {
            resetJertseaGehitu();
        }
        else if (comando == viewJertseaGehitu.jButtonIrten) {
            resetJertseaGehitu();
            viewJertseaGehitu.dispose();
            viewProduktuaAukeratu.setEnabled(true);
            jertsDatuakErakutsiTaula(JertseaKudeatu.jertsGuztErakutsi());
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
        if (comando == viewJertseaGehitu.jButtonIrten)
            viewJertseaGehitu.jButtonIrten.setBackground(new Color (0,0,51));  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewJertseaGehitu.jButtonIrten)
            viewJertseaGehitu.jButtonIrten.setBackground(urdina);
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource(); 
        // JertseaGehitu
        if (comando == viewJertseaGehitu.jTextFieldKodeJerts)
            viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jTextFieldMarka)
            viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jTextFieldPrezioa)
            viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jTextFieldKolorea)
            viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jComboBoxSexua)
            viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(urdina, 1));
        else if (comando == viewJertseaGehitu.jTextFieldStock)
            viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewJertseaGehitu.jComboBoxTaila)
            viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(urdina, 1));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // JertseaGehitu
        if (comando == viewJertseaGehitu.jTextFieldKodeJerts)
            viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jTextFieldMarka)
            viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jTextFieldPrezioa)
            viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jTextFieldKolorea)
            viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jComboBoxSexua)
            viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        else if (comando == viewJertseaGehitu.jTextFieldStock)
            viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewJertseaGehitu.jComboBoxTaila)
            viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private boolean balidazioaJertsGehitu() {
        boolean bool = true;
        if (viewJertseaGehitu.jTextFieldKodeJerts.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldKodeJerts.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewJertseaGehitu.jTextFieldMarka.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldMarka.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewJertseaGehitu.jTextFieldPrezioa.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldPrezioa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewJertseaGehitu.jTextFieldKolorea.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldKolorea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewJertseaGehitu.jComboBoxSexua.getSelectedIndex() == 0) {
            viewJertseaGehitu.jComboBoxSexua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        if (viewJertseaGehitu.jTextFieldStock.getText().isEmpty()) {
            viewJertseaGehitu.jTextFieldStock.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewJertseaGehitu.jComboBoxTaila.getSelectedIndex() == 0) {
            viewJertseaGehitu.jComboBoxTaila.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
}