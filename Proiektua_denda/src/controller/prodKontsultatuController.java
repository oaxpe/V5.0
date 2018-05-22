/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestioa.JertseaKudeatu;
import gestioa.KamisetaKudeatu;
import gestioa.PrakaKudeatu;
import model.*; // model-eko guztia importatu.
import view.*; // bista guztiak importatu
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class prodKontsultatuController implements ActionListener, MouseListener, FocusListener {
    /* Model */
    private Jertsea jertsea;
    private Kamiseta kamiseta;
    private Praka praka;
    
    /* Bistak */
    private MenuNagusia viewMenuNagusia; 
    private ProdKontsultatu viewProdKontsultatu;

    private Color urdina = new Color(0,0,153);
    private Controller ctr = new Controller(); // Controller klasean dauden metodoak erabili ahal izateko
    
    /* ERAIKITZAILEA */   
    public prodKontsultatuController(Jertsea jerts, Kamiseta kami, Praka prak, MenuNagusia viewMenuNag, ProdKontsultatu viewProdKonts) {
        this.jertsea = jerts;
        this.kamiseta = kami;
        this.praka = prak;
        this.viewMenuNagusia = viewMenuNag;
        this.viewProdKontsultatu = viewProdKonts;
        ProdKontsEstiloa(); // estiloa definituta dagoen metodoa
    }
    
    public prodKontsultatuController() {
        
    }

    /* LISTENERS (ActionListener, FocusListener, MouseListener...)  */
    @Override
    public void actionPerformed(ActionEvent e) {
        prodAukController prodAukCtr = new prodAukController();
        Object comando = e.getSource();
        if (comando == viewProdKontsultatu.jButtonIrten) {
            viewProdKontsultatu.dispose();
            viewMenuNagusia.setEnabled(true);
            resetAukerak();
            ctr.enableComponents(viewProdKontsultatu.jPanelDatuak, false);
            taulaHustu(viewProdKontsultatu.jTableProdInfo); // taulan dauden datuak kendu
        }    
        else if (comando == viewProdKontsultatu.jButtonEzeztatu) {
            resetAukerak();
            ctr.enableComponents(viewProdKontsultatu.jPanelDatuak, false);
            taulaHustu(viewProdKontsultatu.jTableProdInfo); // taulan dauden datuak kendu
        }
        else if (comando == viewProdKontsultatu.jButtonBidali) {
            String kodea = viewProdKontsultatu.jTextFieldKodeProd.getText();
            /* datuak kontsultatu eta kargatu taulan */
            if (viewProdKontsultatu.jRadioButtonJerts.isSelected()) {
                ArrayList<Jertsea> jertsKontsulta = JertseaKudeatu.jertseaKontsultatu(kodea);
                if (jertsKontsulta.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Jertse hori ez dago", "Abisua", JOptionPane.INFORMATION_MESSAGE);
                    resetAukerak();
                }
                else
                    prodAukCtr.jertsDatuakErakutsiTaula(viewProdKontsultatu.jTableProdInfo, jertsKontsulta);
            }
            else if (viewProdKontsultatu.jRadioButtonKami.isSelected()) {
                ArrayList<Kamiseta> kamiKontsulta = KamisetaKudeatu.kamisetaKontsultatu(kodea);
                if (kamiKontsulta.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Kamiseta hori ez dago", "Abisua", JOptionPane.INFORMATION_MESSAGE);
                    resetAukerak();
                }
                else
                    prodAukCtr.kamiDatuakErakutsiTaula(viewProdKontsultatu.jTableProdInfo, kamiKontsulta);
            }
            else if (viewProdKontsultatu.jRadioButtonPrak.isSelected()) {
                ArrayList<Praka> prakKontsulta = PrakaKudeatu.prakaKontsultatu(kodea);
                if (prakKontsulta.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Praka hori ez dago", "Abisua", JOptionPane.INFORMATION_MESSAGE);
                    resetAukerak();
                }
                else
                    prodAukCtr.prakDatuakErakutsiTaula(viewProdKontsultatu.jTableProdInfo, prakKontsulta);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object comando = me.getSource();
        /* Produktu mota aukeratzen denean, Taila ComboBox-ean kargatuko da (motaren arabera) */
        if (comando == viewProdKontsultatu.jRadioButtonJerts || comando == viewProdKontsultatu.jRadioButtonKami) {
            ctr.enableComponents(viewProdKontsultatu.jPanelDatuak, true);
        }
        else if (comando == viewProdKontsultatu.jRadioButtonPrak) {
            ctr.enableComponents(viewProdKontsultatu.jPanelDatuak, true);
        }
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
        if (comando == viewProdKontsultatu.jButtonIrten) {
            viewProdKontsultatu.jButtonIrten.setBackground(new Color (0,0,51));
            viewProdKontsultatu.jButtonIrten.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object comando = e.getSource();
        /* Xagua gainetik kentzen denean */
        if (comando == viewProdKontsultatu.jButtonIrten) {
            viewProdKontsultatu.jButtonIrten.setBackground(urdina);
            viewProdKontsultatu.jButtonIrten.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        Object comando = e.getSource();
        // Produktuak kontsultatzeko aukerak
        if (comando == viewProdKontsultatu.jTextFieldKodeProd) 
            viewProdKontsultatu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object comando = e.getSource();
        // Produktuak kontsultatzeko aukerak
        if (comando == viewProdKontsultatu.jTextFieldKodeProd) 
            viewProdKontsultatu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
    }
        
    /* METODOAK */
    /* ProdKontsultatu bistaren estiloa definitzen da */
    private void ProdKontsEstiloa() {
        viewProdKontsultatu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewProdKontsultatu.setLocationRelativeTo(null);
        viewProdKontsultatu.jButtonIrten.setBackground(urdina);
        viewProdKontsultatu.jButtonIrten.setForeground(Color.WHITE);
        viewProdKontsultatu.jTextFieldKodeProd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        ctr.enableComponents(viewProdKontsultatu.jPanelDatuak, false);
        
        viewProdKontsultatu.jPanelOsoa.setBackground(Color.WHITE);
        viewProdKontsultatu.jPanelKontsultaAukerak.setOpaque(false);
        viewProdKontsultatu.jPanelKontsultaAukerak.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, urdina));
        viewProdKontsultatu.jPanelDatuak.setOpaque(false);
        viewProdKontsultatu.jPanelGoiburua.setOpaque(false);
        viewProdKontsultatu.jPanelOina.setOpaque(false);
        viewProdKontsultatu.jPanelProdTaula.setOpaque(false);
        viewProdKontsultatu.jRadioButtonKami.setOpaque(false);
        viewProdKontsultatu.jRadioButtonJerts.setOpaque(false);
        viewProdKontsultatu.jRadioButtonPrak.setOpaque(false);
        
        /* Laguntza botoietan - xaguarekin gainean jartzean agertuko den mezuak definitu */
        viewProdKontsultatu.jButtonBidali.setToolTipText("Bidali");
        viewProdKontsultatu.jButtonEzeztatu.setToolTipText("Ezeztatu");
        
        /* Tauletako estiloa */
        viewProdKontsultatu.jTableProdInfo.setShowGrid(false);
        viewProdKontsultatu.jTableProdInfo.setShowHorizontalLines(true);
        
        /* Botoien formatua definitu */
        botoienFormatoa(viewProdKontsultatu.jPanelDatuak);
    }
    
    /* Produktuen kontsulta egiteko aukerak reseteatu (aukeratutakoa ezabatu) */
    private void resetAukerak() {
        viewProdKontsultatu.jRadioButtonJerts.setSelected(false);
        viewProdKontsultatu.jRadioButtonKami.setSelected(false);
        viewProdKontsultatu.jRadioButtonPrak.setSelected(false);
        viewProdKontsultatu.jTextFieldKodeProd.setText(null);
    }
    
    /* Taulako datuak ezabatzen duen metodoa */
    private void taulaHustu(JTable taula) {
        DefaultTableModel dm = (DefaultTableModel) taula.getModel();
        int rowCount = dm.getRowCount(); // lerro zenbakia
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
    
    /* Panel bateko botoien formatoa definitzen duen metodoa */
    private void botoienFormatoa (Container container) {
        Color urdinArgia = new Color(102,153,255);
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).setOpaque(true);
                ((JButton) component).setIconTextGap(5); // Ikono eta textuaren arteko tartea definitu
                ((JButton) component).setHorizontalAlignment(JButton.LEFT); // Botoi barrukoa ezkerrean alineatzeko
                ((JButton) component).setBorderPainted(true); // botoien ertzak margotuta
                ((JButton) component).setForeground(urdinArgia); // botoiaren textuaren kolorea
                ((JButton) component).setBackground(Color.WHITE); // botoiaren fondo kolorea
            }
        }
    }
}