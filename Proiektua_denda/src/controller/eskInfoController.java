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
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class eskInfoController implements ActionListener, MouseListener, ListSelectionListener, FocusListener, KeyListener {
    /* Model */
    private Eskaera eskaera;
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private EskaeraInfo viewEskaeraInfo;
    private EskaeraGehitu viewEskaeraGehitu;
    
    private Color urdina = new Color(0,0,153);
    private Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public eskInfoController(Eskaera esk, EskaeraInfo viewEskInfo, EskaeraGehitu viewEskGehitu, MenuNagusia viewMenuNag) {
        this.eskaera = esk;
        this.viewEskaeraInfo = viewEskInfo;
        this.viewEskaeraGehitu = viewEskGehitu;
        this.viewMenuNagusia = viewMenuNag;
        eskInfoEstiloa();
    }
    
    public eskInfoController() {
        
    }
    
    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* EskaeraInfo-ko aukerak */
        if (comando == viewEskaeraInfo.jButtonGehitu) {
            viewEskaeraGehitu.setVisible(true);
            viewEskaeraInfo.setEnabled(false);
            ctr.enableComponents(viewEskaeraGehitu.jPanelEskDatuak, false);
        }
        else if (comando == viewEskaeraInfo.jButtonIrten) {
            viewEskaeraInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (comando == viewEskaeraInfo.jButtonEzabatu) {
            int aukLerroa = viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(null, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String kodea = (String) viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako langilearen nan zenbakia lortu
                    EskaeraKudeatu.eskaeraEzabatu(kodea);
                }                
                eskDatuakErakutsiTaula(viewEskaeraInfo.jTableEskaeraInfo, EskaeraKudeatu.eskaeraGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da hornitzailerik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewEskaeraInfo.jButtonAldatu) {
            if (viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow()!=-1) {
                ctr.enableComponents(viewEskaeraInfo.jPanelEskDatuak, true);
                ctr.enableComponents(viewEskaeraInfo.jPanelOina, false);
                viewEskaeraInfo.jButtonAldaketaGorde.setEnabled(true);
                viewEskaeraInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da eskaerarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            } 
        }
        else if (comando == viewEskaeraInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                ctr.enableComponents(viewEskaeraInfo.jPanelEskDatuak, false);
                ctr.enableComponents(viewEskaeraInfo.jPanelOina, true);
                viewEskaeraInfo.jButtonAldaketaGorde.setEnabled(false);
                viewEskaeraInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetEskInfoErr();
                aukEskDatuakBete(viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewEskaeraInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaEskInfo()) {
                    int aukLerroa = viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow(); // aukeratutako lerroa
                    /* Eskaera ezabatu */
                    String kodea = (String) viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako langilearen nan zenbakia lortu
                    EskaeraKudeatu.eskaeraEzabatu(kodea);

                    /* Eskaera gorde */
                    Eskaera esk = new Eskaera(viewEskaeraInfo.jTextFieldKodeEsk.getText(), viewEskaeraInfo.jComboBoxHornitzailea.getSelectedItem().toString(), 
                            Metodoak.dataGorde(viewEskaeraInfo.jDateChooserData.getDate()), Integer.parseInt(viewEskaeraInfo.jTextFieldKopurua.getText()));
                    EskaeraKudeatu.eskaeraGehitu(esk);
                    ctr.enableComponents(viewEskaeraInfo.jPanelEskDatuak, false);
                    
                    /* Hornitzaileak aktualizatu */
                    viewEskaeraInfo.jComboBoxHornitzailea.removeAllItems();
                    ctr.hornitzaileaKargatu(viewEskaeraInfo.jComboBoxHornitzailea);
                    viewEskaeraGehitu.jComboBoxHornitzailea.removeAllItems();
                    ctr.hornitzaileaKargatu(viewEskaeraGehitu.jComboBoxHornitzailea);
                    
                    eskDatuakErakutsiTaula(viewEskaeraInfo.jTableEskaeraInfo, EskaeraKudeatu.eskaeraGuztiakErakutsi());
                    ctr.enableComponents(viewEskaeraInfo.jPanelEskDatuak, false);
                    ctr.enableComponents(viewEskaeraInfo.jPanelOina, true);
                    viewEskaeraInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewEskaeraInfo.jButtonAldaketaEzabatu.setEnabled(false);
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
        if (comando == viewEskaeraInfo.jButtonIrten)
            viewEskaeraInfo.jButtonIrten.setBackground(new Color (0,0,51));  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewEskaeraInfo.jButtonIrten)
            viewEskaeraInfo.jButtonIrten.setBackground(urdina);  
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        /* Tauletako lerroak aukeratzerakoan */
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (lsm == viewEskaeraInfo.jTableEskaeraInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetEskInfo();
            }
            else {
                viewEskaeraInfo.jTableEskaeraInfo.setSelectionBackground(urdina);
                viewEskaeraInfo.jTableEskaeraInfo.setSelectionForeground(Color.WHITE);
                aukEskDatuakBete(viewEskaeraInfo.jTableEskaeraInfo.getSelectedRow());
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // EskaeraInfo
        if (comando == viewEskaeraInfo.jTextFieldKodeEsk)
            viewEskaeraInfo.jTextFieldKodeEsk.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));   
        else if (comando == viewEskaeraInfo.jTextFieldKopurua)
            viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));   
        else if (comando == viewEskaeraInfo.jComboBoxHornitzailea) 
            viewEskaeraInfo.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(urdina, 1));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // EskaeraInfo
        if (comando == viewEskaeraInfo.jTextFieldKodeEsk)
            viewEskaeraInfo.jTextFieldKodeEsk.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));  
        else if (comando == viewEskaeraInfo.jTextFieldKopurua)
            viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));  
        else if (comando == viewEskaeraInfo.jComboBoxHornitzailea) 
            viewEskaeraInfo.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
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
        if (comando == viewEskaeraInfo.jTextFieldBilatu)
            ctr.txtBilatuTaulan(viewEskaeraInfo.jTableEskaeraInfo, viewEskaeraInfo.jTextFieldBilatu.getText());
    }
    
    /* METODOAK */
    private void eskInfoEstiloa() {
        viewEskaeraInfo.setTitle("Eskaeren informazioa");
        viewEskaeraInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewEskaeraInfo.setLocationRelativeTo(null);
        viewEskaeraInfo.jButtonIrten.setBackground(urdina);
        viewEskaeraInfo.jButtonIrten.setForeground(Color.WHITE);
        viewEskaeraInfo.jTextFieldKodeEsk.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewEskaeraInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));

        viewEskaeraInfo.jTextFieldKodeEsk.setOpaque(false);
        viewEskaeraInfo.jComboBoxHornitzailea.setOpaque(false);
        viewEskaeraInfo.jTextFieldKopurua.setOpaque(false);
        
        viewEskaeraInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewEskaeraInfo.jPanelGoiburua.setOpaque(false);
        viewEskaeraInfo.jPanelOina.setOpaque(false);
        viewEskaeraInfo.jPanelEskDatuak.setOpaque(false);
        viewEskaeraInfo.jPanelEskInfoTaula.setOpaque(false);
        
        viewEskaeraInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewEskaeraInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewEskaeraInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewEskaeraInfo.jButtonAldaketaGorde.setToolTipText("Gorde");
        
        // tauletako estiloa
        viewEskaeraInfo.jTableEskaeraInfo.setShowGrid(false);
        viewEskaeraInfo.jTableEskaeraInfo.setShowHorizontalLines(true);

        /* Kodeak ezin dira aldatu */
        viewEskaeraInfo.jTextFieldKodeEsk.setEditable(false);  
    }
    
    public void eskDatuakErakutsiTaula(JTable taula, ArrayList<Eskaera> eskGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        taula.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("HORNITZAILEA");
        model.addColumn("DATA");
        model.addColumn("KOPURUA");
        
        for (int i=0; i<eskGuzt.size(); i++) {
            Eskaera esk = eskGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(esk.getEskZenb(), i, 0);
            model.setValueAt(esk.getHornitzailea(), i, 1);
            model.setValueAt(esk.getData(), i, 2);
            model.setValueAt(esk.getKopurua(), i, 3);
        }
    }
    
    private void aukEskDatuakBete(int aukLerroa) { 
        viewEskaeraInfo.jTextFieldKodeEsk.setText(String.valueOf(viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 0)));
        viewEskaeraInfo.jComboBoxHornitzailea.setSelectedItem(String.valueOf(viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 1)));
        viewEskaeraInfo.jDateChooserData.setDate(Metodoak.dataErakutsi(String.valueOf(viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 2))));
        viewEskaeraInfo.jTextFieldKopurua.setText(String.valueOf(viewEskaeraInfo.jTableEskaeraInfo.getModel().getValueAt(aukLerroa, 3)));
    }
    
    private void resetEskInfo() {
        viewEskaeraInfo.jTextFieldKodeEsk.setText(null);
        viewEskaeraInfo.jComboBoxHornitzailea.setSelectedItem(null);
        viewEskaeraInfo.jDateChooserData.setDate(null);
        viewEskaeraInfo.jTextFieldKopurua.setText(null); 
    }
    
    private boolean balidazioaEskInfo() {
        boolean bool = true;
        if (viewEskaeraInfo.jComboBoxHornitzailea.getSelectedIndex() == 0) {
            viewEskaeraInfo.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            bool = false;
        }  
        // data balidatu ?????
        if (viewEskaeraInfo.jTextFieldKopurua.getText().isEmpty()) {
            viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        return bool;
    }
      
    private void resetEskInfoErr() {
        viewEskaeraInfo.jTextFieldKodeEsk.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewEskaeraInfo.jComboBoxHornitzailea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        viewEskaeraInfo.jTextFieldKopurua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
}