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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class dendaGehituController implements ActionListener, MouseListener, FocusListener {
    /* Model */
//    private Bezeroa bezeroa;
    private Denda denda;
//    private Eskaera eskaera;
//    private Hornitzailea hornitzailea;
//    private Jertsea jertsea;
//    private Kamiseta kamiseta;
//    private Langilea langilea;
//    private Pertsona pertsona;
//    private Praka praka;
//    private Produktua produktua;
//    private Salmenta salmenta;
    
    /* Bistak */
//    private MenuNagusia viewMenuNagusia; 
    private DendaInfo viewDendaInfo;
    private DendaGehitu viewDendaGehitu;
//    private BezeroaInfo viewBezeroaInfo;
//    private BezeroaGehitu viewBezeroaGehitu;
//    private LangileaInfo viewLangileaInfo;
//    private LangileaGehitu viewLangileaGehitu;
//    private ProduktuaAukeratu viewProduktuaAukeratu;
//    private JertseaGehitu viewJertseaGehitu;
//    private KamisetaGehitu viewKamisetaGehitu;
//    private PrakaGehitu viewPrakaGehitu;
//    private HornitzaileaInfo viewHornitzaileaInfo;
//    private HornitzaileaGehitu viewHornitzaileaGehitu;
//    private EskaeraInfo viewEskaeraInfo;
//    private EskaeraGehitu viewEskaeraGehitu;
    
    private Color urdina = new Color(0,0,153);
    
    /* ERAIKITZAILEA */   
    public dendaGehituController(Denda denda, DendaInfo viewDendInfo, DendaGehitu viewDendGehitu, MenuNagusia viewMenuNag) {
        this.denda = denda;
        this.viewDendaInfo = viewDendInfo;
        this.viewDendaGehitu = viewDendGehitu;
        dendGehituEstiloa();
    }
    
    /* METODOAK */
    private void dendGehituEstiloa() {
        viewDendaGehitu.setTitle("Denda berria");
        viewDendaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewDendaGehitu.setLocationRelativeTo(null);
        viewDendaGehitu.jButtonIrten.setBackground(urdina);
        viewDendaGehitu.jButtonIrten.setForeground(Color.WHITE);
        viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        
        viewDendaGehitu.jTextFieldIzena.setOpaque(false);
        viewDendaGehitu.jTextFieldHelbidea.setOpaque(false);
        viewDendaGehitu.jTextFieldHerria.setOpaque(false);
        viewDendaGehitu.jTextFieldPostKod.setOpaque(false);
        viewDendaGehitu.jTextFieldTlf.setOpaque(false);
        viewDendaGehitu.jTextFieldEmail.setOpaque(false);
        viewDendaGehitu.jButtonBerriaGehitu.setBackground(Color.WHITE);

        viewDendaGehitu.jPanelOsoa.setBackground(Color.WHITE);
        viewDendaGehitu.jPanelGoiburua.setOpaque(false);
        viewDendaGehitu.jPanelDendDatuak.setOpaque(false);
    }

    private void resetDendaGehitu() {
        viewDendaGehitu.jTextFieldIzena.setText(null);
        viewDendaGehitu.jTextFieldHelbidea.setText(null);
        viewDendaGehitu.jTextFieldHerria.setText(null);
        viewDendaGehitu.jTextFieldPostKod.setText(null);
        viewDendaGehitu.jTextFieldTlf.setText(null);
        viewDendaGehitu.jTextFieldEmail.setText(null);
        
        viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
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
        /* DendaGehitu-ko aukerak */
        if (comando == viewDendaGehitu.jButtonBerriaGehitu) {
            enableComponets(viewDendaGehitu.jPanelDendDatuak, true);
        }
        else if (comando == viewDendaGehitu.jButtonGorde) {
            if (balidazioaDendaGehitu()) {
                try {
                    Denda d = new Denda(viewDendaGehitu.jTextFieldIzena.getText(), viewDendaGehitu.jTextFieldHelbidea.getText(), 
                        viewDendaGehitu.jTextFieldHerria.getText(), Integer.parseInt(viewDendaGehitu.jTextFieldPostKod.getText()), 
                        viewDendaGehitu.jTextFieldTlf.getText(), viewDendaGehitu.jTextFieldEmail.getText());
                    d.printDatuak();
                    DendaKudeatu.dendaGehitu(d);
                }
                catch (Exception ex) {
                    // fitxategia ez bada existitzen, errorea ematen  du.
                }
                resetDendaGehitu();
                enableComponets(viewDendaGehitu.jPanelDendDatuak, false);
            }
            else
                JOptionPane.showMessageDialog(null, "Zerbait gaizki dago", "KONTUZ!", JOptionPane.ERROR_MESSAGE); // ventana emergente
        }
        else if (comando == viewDendaGehitu.jButtonReset) {
            resetDendaGehitu();
        }
        else if (comando == viewDendaGehitu.jButtonIrten) {
            resetDendaGehitu();
            viewDendaGehitu.dispose();
            viewDendaInfo.setEnabled(true);
            dendDatuakErakutsiTaula(DendaKudeatu.dendGuztiakErakutsi());
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
        if (comando == viewDendaGehitu.jButtonIrten)
            viewDendaGehitu.jButtonIrten.setBackground(new Color (0,0,51));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        if (comando == viewDendaGehitu.jButtonIrten)
            viewDendaGehitu.jButtonIrten.setBackground(urdina);
    }


    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // DendaGehitu
        if (comando == viewDendaGehitu.jTextFieldIzena) 
            viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldHelbidea) 
            viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldHerria) 
            viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldPostKod) 
            viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldTlf) 
            viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        else if (comando == viewDendaGehitu.jTextFieldEmail) 
            viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();       
        // DendaGehitu
        if (comando == viewDendaGehitu.jTextFieldIzena) 
            viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldHelbidea) 
            viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldHerria) 
            viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldPostKod) 
            viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldTlf)
            viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        else if (comando == viewDendaGehitu.jTextFieldEmail)
            viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }

    private boolean balidazioaDendaGehitu() {
        boolean bool = true;
        if (viewDendaGehitu.jTextFieldIzena.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldIzena.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }     
        if (viewDendaGehitu.jTextFieldHelbidea.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldHelbidea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewDendaGehitu.jTextFieldHerria.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldHerria.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }   
        if (viewDendaGehitu.jTextFieldPostKod.getText().isEmpty()) {
            viewDendaGehitu.jTextFieldPostKod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaGehitu.jTextFieldTlf.getText().isEmpty() || !(Metodoak.tlfBalidazioa(viewDendaGehitu.jTextFieldTlf.getText()))) {
            viewDendaGehitu.jTextFieldTlf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        if (viewDendaGehitu.jTextFieldEmail.getText().isEmpty() || !(Metodoak.emailBalidazioa(viewDendaGehitu.jTextFieldEmail.getText()))) {
            viewDendaGehitu.jTextFieldEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
            bool = false;
        }
        return bool;
    }
    
    private void dendDatuakErakutsiTaula(ArrayList<Denda> dendGuzt) {
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
}