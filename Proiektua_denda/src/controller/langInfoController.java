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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class langInfoController implements ActionListener, MouseListener, ListSelectionListener, FocusListener, KeyListener {
    /* Model */
    private Langilea langilea;
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private LangileaInfo viewLangileaInfo;
    private LangileaGehitu viewLangileaGehitu;
    
    private Color urdina = new Color(0,0,153);
    Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public langInfoController(Langilea lang, LangileaInfo viewLangInfo, LangileaGehitu viewLangGehitu, MenuNagusia viewMenuNag) {
        this.langilea = lang;
        this.viewLangileaInfo = viewLangInfo;
        this.viewLangileaGehitu = viewLangGehitu;
        this.viewMenuNagusia = viewMenuNag;
        langInfoEstiloa();
    }
    
    /* METODOAK */
    private void langInfoEstiloa() {
        viewLangileaInfo.setTitle("Langileen informazioa");
        viewLangileaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewLangileaInfo.setLocationRelativeTo(null);
        viewLangileaInfo.jButtonIrten.setBackground(urdina);
        viewLangileaInfo.jButtonIrten.setForeground(Color.WHITE);
        viewLangileaInfo.jTextFieldKodeLang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewLangileaInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewLangileaInfo.jTextFieldKodeLang.setOpaque(false);
        viewLangileaInfo.jTextFieldIzena.setOpaque(false);
        viewLangileaInfo.jTextFieldAbizena1.setOpaque(false);
        viewLangileaInfo.jTextFieldAbizena2.setOpaque(false);
        viewLangileaInfo.jTextFieldHerria.setOpaque(false);
        viewLangileaInfo.jDateChooserJaioData.setOpaque(false);
        viewLangileaInfo.jRadioButtonEmak.setOpaque(false);
        viewLangileaInfo.jRadioButtonGiz.setOpaque(false);
        viewLangileaInfo.jTextFieldNan.setOpaque(false);
        viewLangileaInfo.jTextFieldTlf.setOpaque(false);
        viewLangileaInfo.jTextFieldSoldata.setOpaque(false);
        viewLangileaInfo.jComboBoxEremua.setOpaque(false);
        
        viewLangileaInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewLangileaInfo.jPanelGoiburua.setOpaque(false);
        viewLangileaInfo.jPanelOina.setOpaque(false);
        viewLangileaInfo.jPanelLangDatuak.setOpaque(false);
        viewLangileaInfo.jPanelLangTaula.setOpaque(false);
        
        viewLangileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewLangileaInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewLangileaInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewLangileaInfo.jButtonAldaketaGorde.setToolTipText("Gorde");
        
        // tauletako estiloa
        viewLangileaInfo.jTableLangileaInfo.setShowGrid(false);
        viewLangileaInfo.jTableLangileaInfo.setShowHorizontalLines(true);

        /* Kodeak ezin dira aldatu */
        viewLangileaInfo.jTextFieldKodeLang.setEditable(false);
    }
 
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

    private void aukLangDatuakBete(int aukLerroa) { 
        viewLangileaInfo.jTextFieldKodeLang.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 0)));
        viewLangileaInfo.jTextFieldIzena.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 1)));
        viewLangileaInfo.jTextFieldAbizena1.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 2)));
        viewLangileaInfo.jTextFieldAbizena2.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 3)));
        viewLangileaInfo.jTextFieldNan.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 4)));
        viewLangileaInfo.jDateChooserJaioData.setDate(Metodoak.dataErakutsi(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 5))));
        System.out.println(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 5)));
        String aukSexuaRB = String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 6)).toLowerCase();
        if (aukSexuaRB.equals("emakumea")) {
            viewLangileaInfo.jRadioButtonEmak.setSelected(true);
        }
        else {
            viewLangileaInfo.jRadioButtonGiz.setSelected(true);
        }
        viewLangileaInfo.jTextFieldHerria.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 7)));
        viewLangileaInfo.jTextFieldTlf.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 8)));
        viewLangileaInfo.jTextFieldSoldata.setText(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 9)));
        viewLangileaInfo.jComboBoxEremua.setSelectedItem(String.valueOf(viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 10)));
    }
    
    private void resetLangileaInfo() {
        viewLangileaInfo.jTextFieldKodeLang.setText(null);
        viewLangileaInfo.jTextFieldIzena.setText(null);
        viewLangileaInfo.jTextFieldAbizena1.setText(null);
        viewLangileaInfo.jTextFieldAbizena2.setText(null);
        viewLangileaInfo.jTextFieldNan.setText(null);
        viewLangileaInfo.jDateChooserJaioData.setDate(null);
        viewLangileaInfo.jRadioButtonEmak.setSelected(false);
        viewLangileaInfo.jRadioButtonGiz.setSelected(false);
        viewLangileaInfo.jTextFieldHerria.setText(null);
        viewLangileaInfo.jTextFieldTlf.setText(null);
        viewLangileaInfo.jTextFieldSoldata.setText(null);
        viewLangileaInfo.jComboBoxEremua.setSelectedItem(null);      
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* LangileaInfo-ko aukerak */
        if (comando == viewLangileaInfo.jButtonGehitu) {
            viewLangileaGehitu.setVisible(true);
            viewLangileaInfo.setEnabled(false);
            ctr.enableComponents(viewLangileaGehitu.jPanelLangDatuak, false);
        }
        else if (comando == viewLangileaInfo.jButtonIrten) {
            viewLangileaInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (comando == viewLangileaInfo.jButtonEzabatu) {
            int aukLerroa = viewLangileaInfo.jTableLangileaInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(viewLangileaInfo.jDialogEzabatuKonfirm, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String nan = (String) viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako langilearen nan zenbakia lortu
                    LangileaKudeatu.langileaEzabatu(nan);
                }
                langDatuakErakutsiTaula(LangileaKudeatu.langileGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(viewLangileaInfo.jDialogEzabatuKonfirm, "Ez da langilerik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewLangileaInfo.jButtonAldatu) {
            if (viewLangileaInfo.jTableLangileaInfo.getSelectedRow()!=-1) {
                ctr.enableComponents(viewLangileaInfo.jPanelLangDatuak, true);
                ctr.enableComponents(viewLangileaInfo.jPanelOina, false);
                viewLangileaInfo.jButtonAldaketaGorde.setEnabled(true);
                viewLangileaInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da langilerik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            } 
        }
        else if (comando == viewLangileaInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                ctr.enableComponents(viewLangileaInfo.jPanelLangDatuak, false);
                ctr.enableComponents(viewLangileaInfo.jPanelOina, true);
                viewLangileaInfo.jButtonAldaketaGorde.setEnabled(false);
                viewLangileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetLangInfoErr();
                aukLangDatuakBete(viewLangileaInfo.jTableLangileaInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewLangileaInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                int aukLerroa = viewLangileaInfo.jTableLangileaInfo.getSelectedRow(); // aukeratutako lerroa
                if (balidazioaLangInfo()) {
                    /* Langilea ezabatu */
                    String nan = (String) viewLangileaInfo.jTableLangileaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako langilearen nan zenbakia lortu
                    LangileaKudeatu.langileaEzabatu(nan);

                    /* Langilea gorde */
                    String sexuaRB = ""; // RadioButton-aren balioa gorde
                    if (viewLangileaInfo.jRadioButtonEmak.isSelected()) {
                        sexuaRB = viewLangileaInfo.jRadioButtonEmak.getText();
                    }
                    else if (viewLangileaInfo.jRadioButtonGiz.isSelected()) {
                        sexuaRB = viewLangileaInfo.jRadioButtonGiz.getText();
                    }
                    Langilea lang = new Langilea(viewLangileaInfo.jTextFieldKodeLang.getText(), viewLangileaInfo.jTextFieldIzena.getText(), 
                            viewLangileaInfo.jTextFieldAbizena1.getText(), viewLangileaInfo.jTextFieldAbizena2.getText(), 
                            viewLangileaInfo.jTextFieldNan.getText(), Metodoak.dataGorde(viewLangileaInfo.jDateChooserJaioData.getDate()), 
                            sexuaRB, viewLangileaInfo.jTextFieldHerria.getText(), viewLangileaInfo.jTextFieldTlf.getText(), 
                            Double.parseDouble(viewLangileaInfo.jTextFieldSoldata.getText()), viewLangileaInfo.jComboBoxEremua.getSelectedItem().toString());
                    LangileaKudeatu.langileaGehitu(lang);

                    langDatuakErakutsiTaula(LangileaKudeatu.langileGuztiakErakutsi());
                    ctr.enableComponents(viewLangileaInfo.jPanelLangDatuak, false);
                    ctr.enableComponents(viewLangileaInfo.jPanelOina, true);
                    viewLangileaInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewLangileaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
            }
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
        if (comando == viewLangileaInfo.jButtonIrten)
            viewLangileaInfo.jButtonIrten.setBackground(new Color (0,0,51));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewLangileaInfo.jButtonIrten)
            viewLangileaInfo.jButtonIrten.setBackground(urdina);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        /* Tauletako lerroak aukeratzerakoan */
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (lsm == viewLangileaInfo.jTableLangileaInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetLangileaInfo();
            }
            else {
                viewLangileaInfo.jTableLangileaInfo.setSelectionBackground(urdina);
                viewLangileaInfo.jTableLangileaInfo.setSelectionForeground(Color.WHITE);
                aukLangDatuakBete(viewLangileaInfo.jTableLangileaInfo.getSelectedRow());
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // LangileaInfo
        if (comando == viewLangileaInfo.jTextFieldKodeLang) 
            viewLangileaInfo.jTextFieldKodeLang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldIzena) 
            viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldAbizena1) 
            viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldAbizena2) 
            viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldNan) 
            viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldHerria) 
            viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldTlf) 
            viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewLangileaInfo.jTextFieldSoldata)
            viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
         else if (comando == viewLangileaInfo.jComboBoxEremua)
            viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(urdina, 1));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // LangileaInfo
        if (comando == viewLangileaInfo.jTextFieldKodeLang) 
            viewLangileaInfo.jTextFieldKodeLang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldIzena) 
            viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldAbizena1) 
            viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldAbizena2) 
            viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldNan) 
            viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldHerria) 
            viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldTlf) 
            viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jTextFieldSoldata)
            viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewLangileaInfo.jComboBoxEremua)
            viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
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
        if (comando == viewLangileaInfo.jTextFieldBilatu)
            ctr.txtBilatuTaulan(viewLangileaInfo.jTableLangileaInfo, viewLangileaInfo.jTextFieldBilatu.getText());
    }
    
    private boolean balidazioaLangInfo() {
        boolean bool = true;
        if (viewLangileaInfo.jTextFieldIzena.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewLangileaInfo.jTextFieldAbizena1.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewLangileaInfo.jTextFieldAbizena2.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewLangileaInfo.jTextFieldNan.getText().isEmpty() || !(Metodoak.nanBalidazioa(viewLangileaInfo.jTextFieldNan.getText()))) {
            viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        // data balidatu ??
        if (!viewLangileaInfo.jRadioButtonEmak.isSelected() && !viewLangileaInfo.jRadioButtonGiz.isSelected()) {
            viewLangileaInfo.jRadioButtonEmak.setForeground(Color.RED);
            viewLangileaInfo.jRadioButtonGiz.setForeground(Color.RED);
        }  
        else if (viewLangileaInfo.jRadioButtonEmak.isSelected() || viewLangileaInfo.jRadioButtonGiz.isSelected()) {
            viewLangileaInfo.jRadioButtonEmak.setForeground(Color.BLACK);
            viewLangileaInfo.jRadioButtonGiz.setForeground(Color.BLACK);
        }
        if (viewLangileaInfo.jTextFieldHerria.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaInfo.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewLangileaInfo.jTextFieldTlf.getText()))) {
            viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaInfo.jTextFieldSoldata.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaInfo.jTextFieldSoldata.getText().isEmpty()) {
            viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewLangileaInfo.jComboBoxEremua.getSelectedIndex()==0) {
            viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }
        return bool;
    }
   
    private void resetLangInfoErr() {
        viewLangileaInfo.jTextFieldKodeLang.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jTextFieldSoldata.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewLangileaInfo.jComboBoxEremua.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
    }
}