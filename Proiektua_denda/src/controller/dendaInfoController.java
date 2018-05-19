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
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class dendaInfoController implements ActionListener, MouseListener, ListSelectionListener, FocusListener, KeyListener {
    /* Model */
    private Denda denda;
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private DendaInfo viewDendaInfo;
    private DendaGehitu viewDendaGehitu;
    
    private Color urdina = new Color(0,0,153);
    Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public dendaInfoController(Denda denda, DendaInfo viewDendInfo, DendaGehitu viewDendGehitu, MenuNagusia viewMenuNag) {
        this.denda = denda;       
        this.viewDendaInfo = viewDendInfo;
        this.viewDendaGehitu = viewDendGehitu;
        this.viewMenuNagusia = viewMenuNag;
        dendInfoEstiloa();
    }
    
    /* METODOAK */    
    private void dendInfoEstiloa() {
        viewDendaInfo.setTitle("Dendaren informazioa");
        viewDendaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewDendaInfo.setLocationRelativeTo(null);
        viewDendaInfo.jButtonIrten.setBackground(urdina);
        viewDendaInfo.jButtonIrten.setForeground(Color.WHITE);
        viewDendaInfo.jTextFieldKodeDend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldBilatu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, urdina));
        
        viewDendaInfo.jTextFieldBilatu.setOpaque(false);
        viewDendaInfo.jTextFieldKodeDend.setOpaque(false);
        viewDendaInfo.jTextFieldIzena.setOpaque(false);
        viewDendaInfo.jTextFieldHelbidea.setOpaque(false);
        viewDendaInfo.jTextFieldHerria.setOpaque(false);
        viewDendaInfo.jTextFieldPostKod.setOpaque(false);
        viewDendaInfo.jTextFieldTlf.setOpaque(false);
        viewDendaInfo.jTextFieldEmail.setOpaque(false);

        viewDendaInfo.jPanelOsoa.setBackground(Color.WHITE);
        viewDendaInfo.jPanelGoiburua.setOpaque(false);
        viewDendaInfo.jPanelOina.setOpaque(false);
        viewDendaInfo.jPanelDendDatuak.setOpaque(false);
        viewDendaInfo.jPanelDendTaula.setOpaque(false);
        
        viewDendaInfo.jButtonAldaketaEzabatu.setEnabled(false);
        viewDendaInfo.jButtonAldaketaGorde.setEnabled(false);
        
        viewDendaInfo.jButtonAldaketaEzabatu.setToolTipText("Ezeztatu");
        viewDendaInfo.jButtonAldaketaGorde.setToolTipText("Gorde");
        
        // tauletako estiloa
        viewDendaInfo.jTableDendaInfo.setShowGrid(false);
        viewDendaInfo.jTableDendaInfo.setShowHorizontalLines(true);
        
        /* Kodeak ezin dira aldatu */
        viewDendaInfo.jTextFieldKodeDend.setEditable(false);  
    }
          
    /* METODOAK */   
    public void dendDatuakErakutsiTaula(ArrayList<Denda> dendGuzt) {
        DefaultTableModel model = new DefaultTableModel() {
            /* Datuak taulan ez editatzeko */
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            } 
        };
        viewDendaInfo.jTableDendaInfo.setModel(model);
        model.addColumn("KODEA");
        model.addColumn("IZENA");
        model.addColumn("HELBIDEA");
        model.addColumn("HERRIA");
        model.addColumn("POSTA KODEA");
        model.addColumn("TELEFONOA");
        model.addColumn("EMAILA");
        
        for (int i=0; i<dendGuzt.size(); i++) {
            Denda dend = dendGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(dend.getKodDend(), i, 0);
            model.setValueAt(dend.getIzena(), i, 1);
            model.setValueAt(dend.getHelbidea(), i, 2);
            model.setValueAt(dend.getHerria(), i, 3);
            model.setValueAt(dend.getKodPostala(), i, 4);
            model.setValueAt(dend.getTelefonoa(), i, 5);
            model.setValueAt(dend.getEmail(), i, 6);
        }
    }

    private void aukDendDatuakBete(int aukLerroa) {
        viewDendaInfo.jTextFieldKodeDend.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 0)));
        viewDendaInfo.jTextFieldIzena.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 1)));
        viewDendaInfo.jTextFieldHelbidea.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 2)));
        viewDendaInfo.jTextFieldHerria.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 3)));
        viewDendaInfo.jTextFieldPostKod.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 4)));
        viewDendaInfo.jTextFieldTlf.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 5)));
        viewDendaInfo.jTextFieldEmail.setText(String.valueOf(viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 6)));
    }

    private void resetDendaInfo() {
        viewDendaInfo.jTextFieldKodeDend.setText(null);
        viewDendaInfo.jTextFieldIzena.setText(null);
        viewDendaInfo.jTextFieldHelbidea.setText(null);
        viewDendaInfo.jTextFieldHerria.setText(null);
        viewDendaInfo.jTextFieldPostKod.setText(null);
        viewDendaInfo.jTextFieldTlf.setText(null);  
        viewDendaInfo.jTextFieldEmail.setText(null);
    }
        
    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        /* DendaInfo-ko aukerak */
        if (comando == viewDendaInfo.jButtonGehitu) {
            viewDendaGehitu.setVisible(true);
            viewDendaInfo.setEnabled(false);
            ctr.enableComponents(viewDendaGehitu.jPanelDendDatuak, false);
        }
        else if (comando == viewDendaInfo.jButtonIrten) {
            viewDendaInfo.dispose();
            viewMenuNagusia.setEnabled(true);
        }
        else if (comando == viewDendaInfo.jButtonEzabatu) {
            int aukLerroa = viewDendaInfo.jTableDendaInfo.getSelectedRow(); // aukeratutako lerroa
            if (aukLerroa != -1) {
                int konf = JOptionPane.showConfirmDialog(null, "Ezabatu nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
                if (konf == 0) { // bai
                    String kodea = (String) viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako bezeroaren nan zenbakia lortu
                    DendaKudeatu.dendaEzabatu(kodea);
                }
                dendDatuakErakutsiTaula(DendaKudeatu.dendGuztiakErakutsi());
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da dendarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewDendaInfo.jButtonAldatu) {
            if (viewDendaInfo.jTableDendaInfo.getSelectedRow()!=-1) {
                ctr.enableComponents(viewDendaInfo.jPanelDendDatuak, true);
                ctr.enableComponents(viewDendaInfo.jPanelOina, false);
                viewDendaInfo.jButtonAldaketaGorde.setEnabled(true);
                viewDendaInfo.jButtonAldaketaEzabatu.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Ez da dendarik aukeratu", "KONTUZ!", JOptionPane.WARNING_MESSAGE); // ventana emergente
            }
        }
        else if (comando == viewDendaInfo.jButtonAldaketaEzabatu) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak ez dira gordeko. Irten nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                ctr.enableComponents(viewDendaInfo.jPanelDendDatuak, false);
                ctr.enableComponents(viewDendaInfo.jPanelOina, true);
                viewDendaInfo.jButtonAldaketaGorde.setEnabled(false);
                viewDendaInfo.jButtonAldaketaEzabatu.setEnabled(false);
                resetDendInfoErr();
                aukDendDatuakBete(viewDendaInfo.jTableDendaInfo.getSelectedRow()); // taulako datuekin berriz bete
            }
        }
        else if (comando == viewDendaInfo.jButtonAldaketaGorde) {
            int konf = JOptionPane.showConfirmDialog(null, "Aldaketak gorde nahi duzu?", "Aukeratu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // ventana emergente
            if (konf == 0) { // bai
                if (balidazioaDendaInfo()) {
                    int aukLerroa = viewDendaInfo.jTableDendaInfo.getSelectedRow();
                    String kodea = (String) viewDendaInfo.jTableDendaInfo.getModel().getValueAt(aukLerroa, 0); // aukeratutako bezeroaren nan zenbakia lortu
                    DendaKudeatu.dendaEzabatu(kodea);
                    Denda d = new Denda(viewDendaInfo.jTextFieldKodeDend.getText(), viewDendaInfo.jTextFieldIzena.getText(), 
                            viewDendaInfo.jTextFieldHelbidea.getText(), viewDendaInfo.jTextFieldHerria.getText(), 
                            Integer.parseInt(viewDendaInfo.jTextFieldPostKod.getText()), 
                            viewDendaInfo.jTextFieldTlf.getText(), viewDendaInfo.jTextFieldEmail.getText());
                    DendaKudeatu.dendaGehitu(d);
                    dendDatuakErakutsiTaula(DendaKudeatu.dendGuztiakErakutsi());
                    ctr.enableComponents(viewDendaInfo.jPanelDendDatuak, false);
                    ctr.enableComponents(viewDendaInfo.jPanelOina, true);
                    viewDendaInfo.jButtonAldaketaGorde.setEnabled(false);
                    viewDendaInfo.jButtonAldaketaEzabatu.setEnabled(false);
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
        if (comando == viewDendaInfo.jButtonIrten)
            viewDendaInfo.jButtonIrten.setBackground(new Color (0,0,51));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewDendaInfo.jButtonIrten)
            viewDendaInfo.jButtonIrten.setBackground(urdina);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        /* Tauletako lerroak aukeratzerakoan */
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (lsm == viewDendaInfo.jTableDendaInfo.getSelectionModel()) {
            if (lsm.isSelectionEmpty()) {
                resetDendaInfo();
            }
            else {
                viewDendaInfo.jTableDendaInfo.setSelectionBackground(urdina);
                viewDendaInfo.jTableDendaInfo.setSelectionForeground(Color.WHITE);
                aukDendDatuakBete(viewDendaInfo.jTableDendaInfo.getSelectedRow());
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // DendaInfo
        if (comando == viewDendaInfo.jTextFieldKodeDend) 
            viewDendaInfo.jTextFieldKodeDend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldIzena) 
            viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldHelbidea) 
            viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldHerria) 
            viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldPostKod) 
            viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldTlf) 
            viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaInfo.jTextFieldEmail) 
            viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // DendaInfo
        if (comando == viewDendaInfo.jTextFieldKodeDend) 
            viewDendaInfo.jTextFieldKodeDend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldIzena) 
            viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldHelbidea) 
            viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldHerria) 
            viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldPostKod) 
            viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldTlf) 
            viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaInfo.jTextFieldEmail)
            viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
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
        if (comando == viewDendaInfo.jTextFieldBilatu)
            ctr.txtBilatuTaulan(viewDendaInfo.jTableDendaInfo, viewDendaInfo.jTextFieldBilatu.getText());
    }
    
    private boolean balidazioaDendaInfo() {
        boolean bool = true;
        if (viewDendaInfo.jTextFieldIzena.getText().isEmpty()) {
            viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaInfo.jTextFieldHelbidea.getText().isEmpty()) {
            viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaInfo.jTextFieldHerria.getText().isEmpty()) {
            viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }    
        if (viewDendaInfo.jTextFieldPostKod.getText().isEmpty()) {
            viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaInfo.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewDendaInfo.jTextFieldTlf.getText()))) {
            viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }  
        if (viewDendaInfo.jTextFieldEmail.getText().isEmpty() || !(Metodoak.emailBalidazioa(viewDendaInfo.jTextFieldEmail.getText()))) {
            viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        
        return bool;
    }

    private void resetDendInfoErr() {
        viewDendaInfo.jTextFieldKodeDend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaInfo.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
}