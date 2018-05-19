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
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class bezGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Bezeroa bezeroa;
    
    /* Bistak */
    private BezeroaInfo viewBezeroaInfo;
    private BezeroaGehitu viewBezeroaGehitu;

    private Color urdina = new Color(0,0,153);
    Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public bezGehituController(Bezeroa bez, BezeroaInfo viewBezInfo, BezeroaGehitu viewBezGehitu) {
        this.bezeroa = bez;
        this.viewBezeroaInfo = viewBezInfo;
        this.viewBezeroaGehitu = viewBezGehitu;
        bezGehituEstiloa();
    }
    
    /* METODOAK */
    private void bezGehituEstiloa() {
        viewBezeroaGehitu.setTitle("Bezero berria");
        viewBezeroaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewBezeroaGehitu.setLocationRelativeTo(null);
        viewBezeroaGehitu.jButtonIrten.setBackground(urdina);
        viewBezeroaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
        viewBezeroaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
        
        viewBezeroaGehitu.jTextFieldIzena.setOpaque(false);
        viewBezeroaGehitu.jTextFieldAbizena1.setOpaque(false);
        viewBezeroaGehitu.jTextFieldAbizena2.setOpaque(false);
        viewBezeroaGehitu.jTextFieldHerria.setOpaque(false);
        viewBezeroaGehitu.jDateChooserJaioData.setOpaque(false);
        viewBezeroaGehitu.jRadioButtonEmak.setOpaque(false);
        viewBezeroaGehitu.jRadioButtonGiz.setOpaque(false);
        viewBezeroaGehitu.jTextFieldNan.setOpaque(false);
        viewBezeroaGehitu.jTextFieldTlf.setOpaque(false);
        viewBezeroaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewBezeroaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewBezeroaGehitu.jPanelGoiburua.setOpaque(false);
        viewBezeroaGehitu.jPanelBezDatuak.setOpaque(false);
    }

    /* METODOAK */
    private void bezDatuakErakutsiTaula(ArrayList<Bezeroa> bezGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewBezeroaInfo.jTableBezeroaInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("IZENA");
        model.addColumn("1.ABIZENA");
        model.addColumn("2.ABIZENA");
        model.addColumn("NAN");
        model.addColumn("JAIOTZE DATA");
        model.addColumn("SEXUA");
        model.addColumn("HERRIA");
        model.addColumn("TELEFONOA");
        
        for (int i=0; i<bezGuzt.size(); i++) {
            Bezeroa bez = bezGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(bez.getKodBez(), i, 0);
            model.setValueAt(bez.getIzena(), i, 1);
            model.setValueAt(bez.getAbizena1(), i, 2);
            model.setValueAt(bez.getAbizena2(), i, 3);
            model.setValueAt(bez.getNan(), i, 4);
            model.setValueAt(bez.getJaiotzeData(), i, 5);
            model.setValueAt(bez.getSexua(), i, 6);
            model.setValueAt(bez.getHerria(), i, 7);
            model.setValueAt(bez.getTelefonoa(), i, 8);
        }
    }

    private void resetBezeroaGehitu() {
        viewBezeroaGehitu.jTextFieldIzena.setText(null);
        viewBezeroaGehitu.jTextFieldAbizena1.setText(null);
        viewBezeroaGehitu.jTextFieldAbizena2.setText(null);
        viewBezeroaGehitu.jTextFieldNan.setText(null);
        viewBezeroaGehitu.jDateChooserJaioData.setDate(null);
        viewBezeroaGehitu.jRadioButtonEmak.setSelected(false);
        viewBezeroaGehitu.jRadioButtonGiz.setSelected(false);
        viewBezeroaGehitu.jTextFieldHerria.setText(null);
        viewBezeroaGehitu.jTextFieldTlf.setText(null);
        
        viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
        viewBezeroaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* BezeroaGehitu-ko aukerak */
        if (comando == viewBezeroaGehitu.jButtonBerriaGehitu) {
            ctr.enableComponents(viewBezeroaGehitu.jPanelBezDatuak, true);
        }
        else if (comando == viewBezeroaGehitu.jButtonGorde) {
            if (balidazioaBezGehitu()) {
                String sexuaRB = ""; // RadioButton-aren balioa gorde
                if (viewBezeroaGehitu.jRadioButtonEmak.isSelected()) {
                    sexuaRB = viewBezeroaGehitu.jRadioButtonEmak.getText();
                }
                else if (viewBezeroaGehitu.jRadioButtonGiz.isSelected()) {
                    sexuaRB = viewBezeroaGehitu.jRadioButtonGiz.getText();
                }
                Bezeroa bez = new Bezeroa(viewBezeroaGehitu.jTextFieldIzena.getText(), viewBezeroaGehitu.jTextFieldAbizena1.getText(), 
                        viewBezeroaGehitu.jTextFieldAbizena2.getText(), viewBezeroaGehitu.jTextFieldNan.getText(), Metodoak.dataGorde(viewBezeroaGehitu.jDateChooserJaioData.getDate()), 
                        sexuaRB, viewBezeroaGehitu.jTextFieldHerria.getText(), viewBezeroaGehitu.jTextFieldTlf.getText());
                BezeroaKudeatu.bezeroaGehitu(bez);
                resetBezeroaGehitu();
                ctr.enableComponents(viewBezeroaGehitu.jPanelBezDatuak, false);
            }
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewBezeroaGehitu.jButtonReset) {
            resetBezeroaGehitu();
        }
        else if (comando == viewBezeroaGehitu.jButtonIrten) {
            resetBezeroaGehitu();
            viewBezeroaGehitu.dispose();
            viewBezeroaInfo.setEnabled(true);
            bezDatuakErakutsiTaula(BezeroaKudeatu.bezeroGuztiakErakutsi());
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
        if ( comando == viewBezeroaGehitu.jButtonIrten)
            viewBezeroaGehitu.jButtonIrten.setBackground(new Color (0,0,51));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if ( comando == viewBezeroaGehitu.jButtonIrten)
            viewBezeroaGehitu.jButtonIrten.setBackground(urdina);
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // BezeroaGehitu
        if (comando == viewBezeroaGehitu.jTextFieldIzena)
            viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldAbizena1) 
            viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldAbizena2) 
            viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldNan) 
            viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldHerria) 
            viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaGehitu.jTextFieldTlf) 
            viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina)); 
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // BezeroaGehitu
        if (comando == viewBezeroaGehitu.jTextFieldIzena) 
            viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldAbizena1) 
            viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldAbizena2) 
            viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldNan) 
            viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldHerria) 
            viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaGehitu.jTextFieldTlf) 
            viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }

    private boolean balidazioaBezGehitu() {
        boolean bool = true;
        if (viewBezeroaGehitu.jTextFieldIzena.getText().isEmpty()) {
            viewBezeroaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewBezeroaGehitu.jTextFieldAbizena1.getText().isEmpty()) {
            viewBezeroaGehitu.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewBezeroaGehitu.jTextFieldAbizena2.getText().isEmpty()) {
            viewBezeroaGehitu.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewBezeroaGehitu.jTextFieldNan.getText().isEmpty() || !(Metodoak.nanBalidazioa(viewBezeroaGehitu.jTextFieldNan.getText()))) {
            viewBezeroaGehitu.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        // data balidatu ??
        if (!viewBezeroaGehitu.jRadioButtonEmak.isSelected() && !viewBezeroaGehitu.jRadioButtonGiz.isSelected()) {
            viewBezeroaGehitu.jRadioButtonEmak.setForeground(Color.RED);
            viewBezeroaGehitu.jRadioButtonGiz.setForeground(Color.RED);
        }  
        else if (viewBezeroaGehitu.jRadioButtonEmak.isSelected() || viewBezeroaGehitu.jRadioButtonGiz.isSelected()) {
            viewBezeroaGehitu.jRadioButtonEmak.setForeground(Color.BLACK);
            viewBezeroaGehitu.jRadioButtonGiz.setForeground(Color.BLACK);
        }
        if (viewBezeroaGehitu.jTextFieldHerria.getText().isEmpty()) {
            viewBezeroaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewBezeroaGehitu.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewBezeroaGehitu.jTextFieldTlf.getText()))) {
            viewBezeroaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        return bool;
    }
}