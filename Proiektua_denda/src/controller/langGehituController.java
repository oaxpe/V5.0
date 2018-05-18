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
public class langGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Langilea langilea;
    
    /* Bistak */
    private LangileaInfo viewLangileaInfo;
    private LangileaGehitu viewLangileaGehitu;
    
    private Color urdina = new Color(0,0,153);
    
    /* ERAIKITZAILEA */   
    public langGehituController(Langilea lang, LangileaInfo viewLangInfo, LangileaGehitu viewLangGehitu) {
        this.langilea = langilea;
        this.viewLangileaInfo = viewLangInfo;
        this.viewLangileaGehitu = viewLangGehitu;
        langGehituEstiloa();
    }
    
    /* METODOAK */
    private void langGehituEstiloa() {
        viewLangileaGehitu.setTitle("Langile berria");
        viewLangileaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewLangileaGehitu.setLocationRelativeTo(null);
        viewLangileaGehitu.jButtonIrten.setBackground(urdina);
        viewLangileaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY)); 
        viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewLangileaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
        viewLangileaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
        
        viewLangileaGehitu.jTextFieldIzena.setOpaque(false);
        viewLangileaGehitu.jTextFieldAbizena1.setOpaque(false);
        viewLangileaGehitu.jTextFieldAbizena2.setOpaque(false);
        viewLangileaGehitu.jTextFieldHerria.setOpaque(false);
        viewLangileaGehitu.jDateChooserJaioData.setOpaque(false);
        viewLangileaGehitu.jRadioButtonEmak.setOpaque(false);
        viewLangileaGehitu.jRadioButtonGiz.setOpaque(false);
        viewLangileaGehitu.jTextFieldNan.setOpaque(false);
        viewLangileaGehitu.jTextFieldTlf.setOpaque(false);
        viewLangileaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewLangileaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewLangileaGehitu.jPanelGoiburua.setOpaque(false);
        viewLangileaGehitu.jPanelLangDatuak.setOpaque(false);
    }

    /* METODOAK */
    private void langDatuakErakutsiTaula(ArrayList<Langilea> langGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewLangileaInfo.jTableLangileaInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Izena");
        model.addColumn("1.abizena");
        model.addColumn("2.abizena");
        model.addColumn("NAN");
        model.addColumn("Jaiotze data");
        model.addColumn("Sexua");
        model.addColumn("Herria");
        model.addColumn("Telefono");
        model.addColumn("Soldata");
        model.addColumn("Eremua");
        
        for (int i=0; i<langGuzt.size(); i++) {
            Langilea lang = langGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(lang.getKodLan(), i, 0);
            model.setValueAt(lang.getIzena(), i, 1);
            model.setValueAt(lang.getAbizena1(), i, 2);
            model.setValueAt(lang.getAbizena2(), i, 3);
            model.setValueAt(lang.getNan(), i, 4);
            model.setValueAt(lang.getJaiotzeData(), i, 5);
            model.setValueAt(lang.getSexua(), i, 6);
            model.setValueAt(lang.getHerria(), i, 7);
            model.setValueAt(lang.getTelefonoa(), i, 8);
            model.setValueAt(lang.getSoldata(), i, 9);
            model.setValueAt(lang.getEremua(), i, 10);
        }
    }
    
    private void resetLangileaGehitu() {
        viewLangileaGehitu.jTextFieldIzena.setText(null);
        viewLangileaGehitu.jTextFieldAbizena1.setText(null);
        viewLangileaGehitu.jTextFieldAbizena2.setText(null);
        viewLangileaGehitu.jTextFieldNan.setText(null);
        viewLangileaGehitu.jDateChooserJaioData.setDate(null);
        viewLangileaGehitu.jRadioButtonEmak.setSelected(false);
        viewLangileaGehitu.jRadioButtonGiz.setSelected(false);
        viewLangileaGehitu.jTextFieldHerria.setText(null);
        viewLangileaGehitu.jTextFieldTlf.setText(null);
        viewLangileaGehitu.jTextFieldSoldata.setText(null);
        viewLangileaGehitu.jComboBoxEremua.setSelectedIndex(0);

        viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY)); 
        viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewLangileaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
        viewLangileaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
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
        /* LangileaGehitu-ko aukerak */
        if (comando == viewLangileaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewLangileaGehitu.jPanelLangDatuak, true);
        }
        else if (comando == viewLangileaGehitu.jButtonGorde) {
            if (balidazioaLangGehitu()) {
                String sexuaRB = ""; // RadioButton-aren balioa gorde
                if (viewLangileaGehitu.jRadioButtonEmak.isSelected()) {
                    sexuaRB = viewLangileaGehitu.jRadioButtonEmak.getText();
                }
                else if (viewLangileaGehitu.jRadioButtonGiz.isSelected()) {
                    sexuaRB = viewLangileaGehitu.jRadioButtonGiz.getText();
                }

                Langilea lang = new Langilea(viewLangileaGehitu.jTextFieldIzena.getText(), viewLangileaGehitu.jTextFieldAbizena1.getText(), 
                        viewLangileaGehitu.jTextFieldAbizena2.getText(), viewLangileaGehitu.jTextFieldNan.getText(),  Metodoak.dataGorde(viewLangileaGehitu.jDateChooserJaioData.getDate()), 
                        sexuaRB, viewLangileaGehitu.jTextFieldHerria.getText(), viewLangileaGehitu.jTextFieldTlf.getText(), 
                        Double.parseDouble(viewLangileaGehitu.jTextFieldSoldata.getText()), viewLangileaGehitu.jComboBoxEremua.getSelectedItem().toString());
                LangileaKudeatu.langileaGehitu(lang);
                resetLangileaGehitu();
                enableComponets(viewLangileaGehitu.jPanelLangDatuak, false);
            }   
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewLangileaGehitu.jButtonReset) {
            resetLangileaGehitu();
        }
        else if (comando == viewLangileaGehitu.jButtonIrten) {
            resetLangileaGehitu();
            viewLangileaGehitu.dispose();
            viewLangileaInfo.setEnabled(true);
            langDatuakErakutsiTaula(LangileaKudeatu.langileGuztiakErakutsi());
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
        if (comando == viewLangileaGehitu.jButtonIrten)
            viewLangileaGehitu.jButtonIrten.setBackground(new Color (0,0,51));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewLangileaGehitu.jButtonIrten)
            viewLangileaGehitu.jButtonIrten.setBackground(urdina);
    }
    

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // LangileaGehitu
        if (comando == viewLangileaGehitu.jTextFieldIzena)
            viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldAbizena1) 
            viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldAbizena2) 
            viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldNan) 
            viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldHerria) 
            viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldTlf) 
            viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaGehitu.jTextFieldSoldata)
            viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
         else if (comando == viewLangileaGehitu.jComboBoxEremua)
            viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(urdina, 1));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // LangileaGehitu
        if (comando == viewLangileaGehitu.jTextFieldIzena)
            viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldAbizena1) 
            viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldAbizena2) 
            viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldNan) 
            viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldHerria) 
            viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldTlf) 
            viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jTextFieldSoldata) 
            viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaGehitu.jComboBoxEremua)
            viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
    
    private boolean balidazioaLangGehitu() {
        boolean bool = true;
        if (viewLangileaGehitu.jTextFieldIzena.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewLangileaGehitu.jTextFieldAbizena1.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewLangileaGehitu.jTextFieldAbizena2.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewLangileaGehitu.jTextFieldNan.getText().isEmpty() || !(Metodoak.nanBalidazioa(viewLangileaGehitu.jTextFieldNan.getText()))) {
            viewLangileaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        // data balidatu ??
        if (!viewLangileaGehitu.jRadioButtonEmak.isSelected() && !viewLangileaGehitu.jRadioButtonGiz.isSelected()) {
            viewLangileaGehitu.jRadioButtonEmak.setForeground(Color.RED);
            viewLangileaGehitu.jRadioButtonGiz.setForeground(Color.RED);
        }  
        else if (viewLangileaGehitu.jRadioButtonEmak.isSelected() || viewLangileaGehitu.jRadioButtonGiz.isSelected()) {
            viewLangileaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
            viewLangileaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
        }
        if (viewLangileaGehitu.jTextFieldHerria.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaGehitu.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewLangileaGehitu.jTextFieldTlf.getText()))) {
            viewLangileaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaGehitu.jTextFieldSoldata.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaGehitu.jTextFieldSoldata.getText().isEmpty()) {
            viewLangileaGehitu.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaGehitu.jComboBoxEremua.getSelectedIndex()==0) {
            viewLangileaGehitu.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
}