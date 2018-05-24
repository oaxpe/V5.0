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
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class bezInfoController implements ActionListener, MouseListener, ListSelectionListener, FocusListener, KeyListener {
    /* Model */
    private Bezeroa bezeroa;
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private BezeroaInfo viewBezeroaInfo;
    private BezeroaGehitu viewBezeroaGehitu;

    private Color urdina = new Color(0,0,153);
    private Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public bezInfoController(Bezeroa bez, BezeroaInfo viewBezInfo, BezeroaGehitu viewBezGehitu, MenuNagusia viewMenuNag) {
        this.bezeroa = bez;
        this.viewBezeroaInfo = viewBezInfo;
        this.viewBezeroaGehitu = viewBezGehitu;
        this.viewMenuNagusia = viewMenuNag;
        bezInfoEstiloa();
    }
    
    public bezInfoController() {
        
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* BezeroaInfo-ko aukerak */
        if (comando == viewBezeroaInfo.jButtonGehitu) {
            viewBezeroaGehitu.setVisible(true);
            viewBezeroaInfo.setEnabled(false);
            ctr.enableComponents(viewBezeroaGehitu.jPanelBezDatuak, false);
        } 
        else if (comando == viewBezeroaInfo.jButtonIrten) {
            viewBezeroaInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (comando == viewBezeroaInfo.jButtonEzabatu) {
            int aukLerroa = viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(viewBezeroaInfo.jDialogEzabatuKonfirm, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String nan = (String) viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako bezeroaren nan zenbakia lortu
                    BezeroaKudeatu.bezeroaEzabatu(nan);
                }
                bezDatuakErakutsiTaula(viewBezeroaInfo.jTableBezeroaInfo, BezeroaKudeatu.bezeroGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da bezerorik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewBezeroaInfo.jButtonAldatu) {
            if (viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow()!=-1) {
                ctr.enableComponents(viewBezeroaInfo.jPanelBezDatuak, true);
                ctr.enableComponents(viewBezeroaInfo.jPanelOina, false);
                viewBezeroaInfo.jButtonAldaketaGorde.setEnabled(true);
                viewBezeroaInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da bezerorik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewBezeroaInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                ctr.enableComponents(viewBezeroaInfo.jPanelBezDatuak, false);
                ctr.enableComponents(viewBezeroaInfo.jPanelOina, true);
                viewBezeroaInfo.jButtonAldaketaGorde.setEnabled(false);
                viewBezeroaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetBezInfoErr();
                aukBezDatuakBete(viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewBezeroaInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaBezInfo()) {
                    /* Bezeroa ezabatu */
                    int aukLerroa = viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow();
                    String nan = (String) viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 4); // aukeratutako bezeroaren nan zenbakia lortu
                    BezeroaKudeatu.bezeroaEzabatu(nan);
                    /* Bezeroa gehitu */
                    String sexuaRB = ""; // RadioButton-aren balioa gorde
                    if (viewBezeroaInfo.jRadioButtonEmak.isSelected()) {
                        sexuaRB = viewBezeroaInfo.jRadioButtonEmak.getText();
                    }
                    else if (viewBezeroaInfo.jRadioButtonGiz.isSelected()) {
                        sexuaRB = viewBezeroaInfo.jRadioButtonGiz.getText();
                    }
                    Bezeroa bez = new Bezeroa(viewBezeroaInfo.jTextFieldKodeBez.getText(), viewBezeroaInfo.jTextFieldIzena.getText(), 
                            viewBezeroaInfo.jTextFieldAbizena1.getText(), viewBezeroaInfo.jTextFieldAbizena2.getText(), 
                            viewBezeroaInfo.jTextFieldNan.getText(), Metodoak.dataGorde(viewBezeroaInfo.jDateChooserJaioData.getDate()), 
                            sexuaRB, viewBezeroaInfo.jTextFieldHerria.getText(), viewBezeroaInfo.jTextFieldTlf.getText());
                    BezeroaKudeatu.bezeroaGehitu(bez);

                    bezDatuakErakutsiTaula(viewBezeroaInfo.jTableBezeroaInfo, BezeroaKudeatu.bezeroGuztiakErakutsi());
                    ctr.enableComponents(viewBezeroaInfo.jPanelBezDatuak, false);
                    ctr.enableComponents(viewBezeroaInfo.jPanelOina, true);
                    viewBezeroaInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewBezeroaInfo.jButtonAldaketaEzabatu.setEnabled(false);
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
        if (comando == viewBezeroaInfo.jButtonIrten) {
            viewBezeroaInfo.jButtonIrten.setBackground(new Color (0,0,51));
            viewBezeroaInfo.jButtonIrten.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if (comando == viewBezeroaInfo.jButtonAldaketaEzabatu)
            viewBezeroaInfo.jButtonAldaketaEzabatu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewBezeroaInfo.jButtonAldaketaGorde)
            viewBezeroaInfo.jButtonAldaketaGorde.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewBezeroaInfo.jButtonAldatu)
            viewBezeroaInfo.jButtonAldatu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewBezeroaInfo.jButtonEzabatu)
            viewBezeroaInfo.jButtonEzabatu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        else if (comando == viewBezeroaInfo.jButtonGehitu)
            viewBezeroaInfo.jButtonGehitu.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewBezeroaInfo.jButtonIrten) {
            viewBezeroaInfo.jButtonIrten.setBackground(urdina);
            viewBezeroaInfo.jButtonIrten.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if (comando == viewBezeroaInfo.jButtonAldaketaEzabatu)
            viewBezeroaInfo.jButtonAldaketaEzabatu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewBezeroaInfo.jButtonAldaketaGorde)
            viewBezeroaInfo.jButtonAldaketaGorde.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewBezeroaInfo.jButtonAldatu)
            viewBezeroaInfo.jButtonAldatu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewBezeroaInfo.jButtonEzabatu)
            viewBezeroaInfo.jButtonEzabatu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        else if (comando == viewBezeroaInfo.jButtonGehitu)
            viewBezeroaInfo.jButtonGehitu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Color urdinArgia = new Color(102,153,255); // xagua gainetik pasatzen denean jarriko den kolorea
        /* Tauletako lerroak aukeratzerakoan */
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (lsm == viewBezeroaInfo.jTableBezeroaInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetBezeroaInfo();
            }
            else {
                viewBezeroaInfo.jTableBezeroaInfo.setSelectionBackground(urdinArgia);
                viewBezeroaInfo.jTableBezeroaInfo.setSelectionForeground(Color.WHITE);
                aukBezDatuakBete(viewBezeroaInfo.jTableBezeroaInfo.getSelectedRow());
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // BezeroaInfo
        if (comando == viewBezeroaInfo.jTextFieldKodeBez) 
            viewBezeroaInfo.jTextFieldKodeBez.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldIzena) 
            viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldAbizena1) 
            viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldAbizena2) 
            viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldNan) 
            viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldHerria) 
            viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewBezeroaInfo.jTextFieldTlf) 
            viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // BezeroaInfo
        if (comando == viewBezeroaInfo.jTextFieldKodeBez) 
            viewBezeroaInfo.jTextFieldKodeBez.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldIzena) 
            viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldAbizena1) 
            viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldAbizena2) 
            viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldNan) 
            viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldHerria) 
            viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewBezeroaInfo.jTextFieldTlf) 
            viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
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
        if (comando == viewBezeroaInfo.jTextFieldBilatu)
            ctr.txtBilatuTaulan(viewBezeroaInfo.jTableBezeroaInfo, viewBezeroaInfo.jTextFieldBilatu.getText());
    }
        
    /* METODOAK */  
    private void bezInfoEstiloa() {
        viewBezeroaInfo.setTitle("Bezeroen informazioa");
        viewBezeroaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewBezeroaInfo.setLocationRelativeTo(null);
        viewBezeroaInfo.jButtonIrten.setBackground(urdina);
        viewBezeroaInfo.jButtonIrten.setForeground(Color.WHITE);
        viewBezeroaInfo.jTextFieldKodeBez.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewBezeroaInfo.jTextFieldKodeBez.setOpaque(false);
        viewBezeroaInfo.jTextFieldIzena.setOpaque(false);
        viewBezeroaInfo.jTextFieldAbizena1.setOpaque(false);
        viewBezeroaInfo.jTextFieldAbizena2.setOpaque(false);
        viewBezeroaInfo.jTextFieldHerria.setOpaque(false);
        viewBezeroaInfo.jDateChooserJaioData.setOpaque(false);
        viewBezeroaInfo.jRadioButtonEmak.setOpaque(false);
        viewBezeroaInfo.jRadioButtonGiz.setOpaque(false);
        viewBezeroaInfo.jTextFieldNan.setOpaque(false);
        viewBezeroaInfo.jTextFieldTlf.setOpaque(false);

        viewBezeroaInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewBezeroaInfo.jPanelGoiburua.setOpaque(false);
        viewBezeroaInfo.jPanelOina.setOpaque(false);
        viewBezeroaInfo.jPanelBezDatuak.setOpaque(false);
        viewBezeroaInfo.jPanelBezTaula.setOpaque(false);
        
        viewBezeroaInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewBezeroaInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewBezeroaInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewBezeroaInfo.jButtonAldaketaGorde.setToolTipText("Gorde");

         // tauletako estiloa
        viewBezeroaInfo.jTableBezeroaInfo.setShowGrid(false);
        viewBezeroaInfo.jTableBezeroaInfo.setShowHorizontalLines(true);
        
        /* Kodeak ezin dira aldatu */
        viewBezeroaInfo.jTextFieldKodeBez.setEditable(false);
    }

    public void bezDatuakErakutsiTaula(JTable taula, ArrayList<Bezeroa> bezGuzt) { // bezGehituController-ean ere erabiltzen da
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        taula.getTableHeader().setBackground(urdina);
        taula.getTableHeader().setForeground(Color.WHITE);
        taula.setModel(model);
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
    
    private void aukBezDatuakBete(int aukLerroa) {    
        viewBezeroaInfo.jTextFieldKodeBez.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 0)));
        viewBezeroaInfo.jTextFieldIzena.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 1)));
        viewBezeroaInfo.jTextFieldAbizena1.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 2)));
        viewBezeroaInfo.jTextFieldAbizena2.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 3)));
        viewBezeroaInfo.jTextFieldNan.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 4)));
        viewBezeroaInfo.jDateChooserJaioData.setDate(Metodoak.dataErakutsi(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 5))));
        String aukSexuaRB = String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 6)).toLowerCase();
        if (aukSexuaRB.equals("emakumea")) {
            viewBezeroaInfo.jRadioButtonEmak.setSelected(true);
        }
        else if (aukSexuaRB.equals("gizona")) {
            viewBezeroaInfo.jRadioButtonGiz.setSelected(true);
        }
        viewBezeroaInfo.jTextFieldHerria.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 7)));
        viewBezeroaInfo.jTextFieldTlf.setText(String.valueOf(viewBezeroaInfo.jTableBezeroaInfo.getModel().getValueAt(aukLerroa, 8)));
    }
    
    private void resetBezeroaInfo() {
        viewBezeroaInfo.jTextFieldKodeBez.setText(null);
        viewBezeroaInfo.jTextFieldIzena.setText(null);
        viewBezeroaInfo.jTextFieldAbizena1.setText(null);
        viewBezeroaInfo.jTextFieldAbizena2.setText(null);
        viewBezeroaInfo.jTextFieldNan.setText(null);
        viewBezeroaInfo.jDateChooserJaioData.setDate(null);
        viewBezeroaInfo.jRadioButtonEmak.setSelected(false);
        viewBezeroaInfo.jRadioButtonGiz.setSelected(false);
        viewBezeroaInfo.jTextFieldHerria.setText(null);
        viewBezeroaInfo.jTextFieldTlf.setText(null);  
    }
    
    private boolean balidazioaBezInfo() {
        boolean bool = true;
        if (viewBezeroaInfo.jTextFieldIzena.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewBezeroaInfo.jTextFieldAbizena1.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewBezeroaInfo.jTextFieldAbizena2.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewBezeroaInfo.jTextFieldNan.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewBezeroaInfo.jTextFieldNan.setToolTipText(null);
            bool = false;
        }
        else if (!Metodoak.nanBalidazioa(viewBezeroaInfo.jTextFieldNan.getText())) {
            viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewBezeroaInfo.jTextFieldNan.setToolTipText("NAN formatu okerra");
            bool = false;
        }
        else 
            viewBezeroaInfo.jTextFieldNan.setToolTipText(null);
        // data balidatu ??
        if (!viewBezeroaInfo.jRadioButtonEmak.isSelected() && !viewBezeroaInfo.jRadioButtonGiz.isSelected()) {
            viewBezeroaInfo.jRadioButtonEmak.setForeground(Color.RED);
            viewBezeroaInfo.jRadioButtonGiz.setForeground(Color.RED);
            bool = false;
        }  
        if (viewBezeroaInfo.jTextFieldHerria.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewBezeroaInfo.jTextFieldTlf.getText().isEmpty()) {
            viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewBezeroaInfo.jTextFieldTlf.setToolTipText(null);
            bool = false;
        }
        else if (!Metodoak.tlfBalidazioa(viewBezeroaInfo.jTextFieldTlf.getText())) { // sartutako balioa, egokia den konprobatzen du (expresio erregularrekin)
            viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            viewBezeroaInfo.jTextFieldTlf.setToolTipText("Telefono zenbaki okerra");
            bool = false;
        }
        else 
            viewBezeroaInfo.jTextFieldTlf.setToolTipText(null);
        return bool;
    }

    private void resetBezInfoErr() {
        viewBezeroaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldAbizena1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldAbizena2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldNan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewBezeroaInfo.jRadioButtonEmak.setForeground(Color.BLACK);
        viewBezeroaInfo.jRadioButtonGiz.setForeground(Color.BLACK);
        viewBezeroaInfo.jTextFieldTlf.setToolTipText(null);
        viewBezeroaInfo.jTextFieldNan.setToolTipText(null);
    }
}