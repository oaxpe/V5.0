/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestioa.BezeroaKudeatu;
import gestioa.HornitzaileaKudeatu;
import gestioa.LangileaKudeatu;
import gestioa.Metodoak;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.*; // model-eko guztia importatu.
import view.*; // bista guztiak importatu
import java.awt.event.MouseListener;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class Controller implements ActionListener, MouseListener/*, KeyListener*/ {
    /* Model */
    private Bezeroa bezeroa;
    private Denda denda;
    private Eskaera eskaera;
    private Hornitzailea hornitzailea;
    private Jertsea jertsea;
    private Kamiseta kamiseta;
    private Langilea langilea;
    private Pertsona pertsona;
    private Praka praka;
    private Produktua produktua;
    private Salmenta salmenta;
    
    
    /* Bistak */
    private menuNagusia viewMenuNagusia; 
    private BezeroaInfo viewBezeroaInfo;
    private BezeroaGehitu viewBezeroaGehitu;
    private LangileaInfo viewLangileaInfo;
    private LangileaGehitu viewLangileaGehitu;
    private JertseaInfo viewJertseaInfo;
    private JertseaGehitu viewJertseaGehitu;
    private KamisetaInfo viewKamisetaInfo;
    private KamisetaGehitu viewKamisetaGehitu;
    private PrakaInfo viewPrakaInfo;
    private PrakaGehitu viewPrakaGehitu;
    private HornitzaileaInfo viewHornitzaileaInfo;
    private HornitzaileaGehitu viewHornitzaileaGehitu;
    private EskaeraInfo viewEskaeraInfo;
    private EskaeraGehitu viewEskaeraGehitu;
    // falata DendaInfo eta DendaGehitu?????
      
    
    /* ERAIKITZAILEA */   
    public Controller(Bezeroa bez, Denda denda, Eskaera esk, Hornitzailea horn, Jertsea jerts,
            Kamiseta kami, Langilea lang, Praka prak, Salmenta salm,
            BezeroaInfo viewBezInfo, BezeroaGehitu viewBezGehitu, LangileaInfo viewLangInfo, LangileaGehitu viewLangGehitu,
            JertseaInfo viewJertsInfo, JertseaGehitu viewJertsGehitu, KamisetaInfo viewKamInfo, KamisetaGehitu viewKamGehitu,
            PrakaInfo viewPrakInfo, PrakaGehitu viewPrakGehitu, HornitzaileaInfo viewHornInfo, HornitzaileaGehitu viewHornGehitu,
            EskaeraInfo viewEskInfo, EskaeraGehitu viewEskGehitu, menuNagusia viewMenuNag) {
        this.bezeroa = bez;
        this.denda = denda;
        this.eskaera = esk;
        this.hornitzailea = horn;
        this.jertsea = jerts;
        this.kamiseta = kami;
        this.langilea = lang;
        this.praka = prak;
        this.salmenta = salm;
        
        this.viewBezeroaInfo = viewBezInfo;
        this.viewBezeroaGehitu = viewBezGehitu;
        this.viewLangileaInfo = viewLangInfo;
        this.viewLangileaGehitu = viewLangGehitu;
        this.viewJertseaInfo = viewJertsInfo;
        this.viewJertseaGehitu = viewJertsGehitu;
        this.viewKamisetaInfo = viewKamInfo;
        this.viewKamisetaGehitu = viewKamGehitu;
        this.viewPrakaInfo = viewPrakInfo;
        this.viewPrakaGehitu = viewPrakGehitu;
        this.viewHornitzaileaInfo = viewHornInfo;
        this.viewHornitzaileaGehitu = viewHornGehitu;
        this.viewEskaeraInfo = viewEskInfo;
        this.viewEskaeraGehitu = viewEskGehitu;
        this.viewHornitzaileaGehitu = viewHornGehitu;
        this.viewMenuNagusia = viewMenuNag;

        hasieratu();
    }
    
    /* METODOAK */
    public void hasieratu() {
        viewMenuNagusia.setTitle("Aplikazioa");
        viewMenuNagusia.setVisible(true);
        viewMenuNagusia.setLocationRelativeTo(null); // erdian agertzeko
        
        viewMenuNagusia.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewBezeroaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewBezeroaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewLangileaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewLangileaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewJertseaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewJertseaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewKamisetaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewKamisetaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewPrakaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewPrakaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewHornitzaileaInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewHornitzaileaGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewEskaeraInfo.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        viewEskaeraGehitu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        /* ActionListeners gehitu */
        viewMenuNagusia.jButtonIrten.addActionListener(this);
        viewBezeroaInfo.jButtonIrten.addActionListener(this);
        viewBezeroaGehitu.jButtonIrten.addActionListener(this);
        viewLangileaInfo.jButtonIrten.addActionListener(this);
        viewLangileaGehitu.jButtonIrten.addActionListener(this);
        viewJertseaInfo.jButtonIrten.addActionListener(this);
        viewJertseaGehitu.jButtonIrten.addActionListener(this);
        viewKamisetaInfo.jButtonIrten.addActionListener(this);
        viewKamisetaGehitu.jButtonIrten.addActionListener(this);
        viewPrakaInfo.jButtonIrten.addActionListener(this);
        viewPrakaGehitu.jButtonIrten.addActionListener(this);
        viewHornitzaileaInfo.jButtonIrten.addActionListener(this);
        viewHornitzaileaGehitu.jButtonIrten.addActionListener(this);
        viewEskaeraInfo.jButtonIrten.addActionListener(this);
        viewEskaeraGehitu.jButtonIrten.addActionListener(this);

        // Menu Nagusiko botoiak
        viewMenuNagusia.jButtonBezeroa.addActionListener(this);
        viewMenuNagusia.jButtonDenda.addActionListener(this);
        viewMenuNagusia.jButtonEskaera.addActionListener(this);
        viewMenuNagusia.jButtonHornitzailea.addActionListener(this);
        viewMenuNagusia.jButtonLangilea.addActionListener(this);
        viewMenuNagusia.jButtonProduktua.addActionListener(this);
        
        // BezeroaInfo-ko botoiak
        viewBezeroaInfo.jButtonEzabatu.addActionListener(this);
        viewBezeroaInfo.jButtonAldatu.addActionListener(this);
        viewBezeroaInfo.jButtonGehitu.addActionListener(this);
        
        // BezeroaGehitu-ko botoiak
        viewBezeroaGehitu.jButtonReset.addActionListener(this);
        viewBezeroaGehitu.jButtonGorde.addActionListener(this);
        
        // LangileaInfo-ko botoiak
        viewLangileaInfo.jButtonEzabatu.addActionListener(this);
        viewLangileaInfo.jButtonAldatu.addActionListener(this);
        viewLangileaInfo.jButtonGehitu.addActionListener(this);
        
        // LangileaGehitu-ko botoiak
        viewLangileaGehitu.jButtonReset.addActionListener(this);
        viewLangileaGehitu.jButtonGorde.addActionListener(this);
        
        // JertseaInfo-ko botoiak
        viewJertseaInfo.jButtonEzabatu.addActionListener(this);
        viewJertseaInfo.jButtonAldatu.addActionListener(this);
        viewJertseaInfo.jButtonGehitu.addActionListener(this);
        
        // JertseaGehitu-ko botoiak
        viewJertseaGehitu.jButtonReset.addActionListener(this);
        viewJertseaGehitu.jButtonGorde.addActionListener(this);
        
        // KamisetaInfo-ko botoiak
        
        // KamisetaGehitu-ko botoiak
        
        // PrakaInfo-ko botoiak
        
        // PrakaGehitu-ko botoiak
        
        // HornitzaileaInfo-ko botoiak
        viewHornitzaileaInfo.jButtonEzabatu.addActionListener(this);
        viewHornitzaileaInfo.jButtonAldatu.addActionListener(this);
        viewHornitzaileaInfo.jButtonGehitu.addActionListener(this);        
        
        // HornitzaileaGehitu-ko botoik
        viewHornitzaileaGehitu.jButtonReset.addActionListener(this);
        viewHornitzaileaGehitu.jButtonGorde.addActionListener(this);
        
        // EskaeraInfo-ko botoiak
        viewEskaeraInfo.jButtonEzabatu.addActionListener(this);
        viewEskaeraInfo.jButtonAldatu.addActionListener(this);
        viewEskaeraInfo.jButtonGehitu.addActionListener(this);
        
        // EskaeraGehitu-ko botoiak
        viewEskaeraGehitu.jButtonReset.addActionListener(this);
        viewEskaeraGehitu.jButtonGorde.addActionListener(this);

        /*  MouseLiseners */
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object comando = e.getSource();
        System.out.println(comando);
        if (comando == viewMenuNagusia.jButtonIrten) {
            System.exit(0);
        }
        else if (comando == viewMenuNagusia.jButtonDenda) {
            
        }
        else if (comando == viewMenuNagusia.jButtonProduktua) {
            
        }
        else if (comando == viewMenuNagusia.jButtonBezeroa) {
            viewBezeroaInfo.setVisible(true);
            viewBezeroaInfo.setLocationRelativeTo(null);
            viewMenuNagusia.setEnabled(false);
            bezDatuakErakutsiTaula();
        }
        else if (comando == viewMenuNagusia.jButtonLangilea) {
            viewLangileaInfo.setVisible(true);
            viewLangileaInfo.setLocationRelativeTo(null);
            viewMenuNagusia.setEnabled(false);
            langDatuakErakutsiTaula();
        }
        else if (comando == viewMenuNagusia.jButtonHornitzailea) {
            viewHornitzaileaInfo.setVisible(true);
            viewHornitzaileaInfo.setLocationRelativeTo(null); 
            viewMenuNagusia.setEnabled(false);
            hornDatuakErakutsiTaula();
        }
        else if (comando == viewMenuNagusia.jButtonEskaera) {
            viewEskaeraInfo.setVisible(true);
            viewEskaeraInfo.setLocationRelativeTo(null);
            viewMenuNagusia.setEnabled(false);
        }
        
        /* BezeroaInfoko aukerak */
        else if (comando == viewBezeroaInfo.jButtonGehitu) {
            viewBezeroaGehitu.setVisible(true);
            viewBezeroaGehitu.setLocationRelativeTo(null);
            viewBezeroaInfo.setEnabled(false);
        }
        
        /* IRTEN botoia atzera joateko (menu nagusian ez) */
        else if (comando == viewBezeroaInfo.jButtonIrten) {
            viewBezeroaInfo.setVisible(false);
            viewMenuNagusia.setEnabled(true);
//            viewMenuNagusia.setAlwaysOnTop(true);
        }
        else if (comando == viewLangileaInfo.jButtonIrten) {
            viewLangileaInfo.setVisible(false);
            viewMenuNagusia.setEnabled(true);
//            viewMenuNagusia.setAlwaysOnTop(true);
        }
        // jertsea, praka, kamiseta???
        else if (comando == viewHornitzaileaInfo.jButtonIrten) {
            viewHornitzaileaInfo.setVisible(false);
            viewMenuNagusia.setEnabled(true);
//            viewMenuNagusia.setAlwaysOnTop(true);
        }
        else if (comando == viewEskaeraInfo.jButtonIrten) {
            viewEskaeraInfo.setVisible(false);
            viewMenuNagusia.setEnabled(true);
//            viewMenuNagusia.setAlwaysOnTop(true);
        }
        
        /* BezeroaGehituko aukerak */
        else if (comando == viewBezeroaGehitu.jButtonGorde) {
            Bezeroa bez = new Bezeroa(viewBezeroaGehitu.jTextFieldIzena.getText(), viewBezeroaGehitu.jTextFieldAbizena1.getText(), 
                    viewBezeroaGehitu.jTextFieldAbizena2.getText(), viewBezeroaGehitu.jTextFieldNan.getText(), viewBezeroaGehitu.jTextFieldJaioData.getText(), 
                    "emakumea", viewBezeroaGehitu.jTextFieldHerria.getText(), viewBezeroaGehitu.jTextFieldTlf.getText());
            BezeroaKudeatu.bezeroaGehitu(bez);
        }
        
        /* HornitzaileaGehituko aukerak */
        else if (comando == viewHornitzaileaGehitu.jButtonGorde) {
            Hornitzailea horn = new Hornitzailea(viewHornitzaileaGehitu.jTextFieldIzena.getText(), viewHornitzaileaGehitu.jTextFieldHerria.getText(),
                    viewHornitzaileaGehitu.jTextFieldTlf.getText(), viewHornitzaileaGehitu.jTextFieldEmail.getText());
            HornitzaileaKudeatu.hornitzaileaGehitu(horn);
        }
    }
    
//    @Override
    @Override
    public void mouseClicked(MouseEvent me) {
        Object mouseSource = me.getSource();
        
        
        
    }
    

    
//    public static void dataErakutsi() {
//        Calendar c1 = new GregorianCalendar();
//        String egun = Integer.toString(c1.get(Calendar.DATE)); // eguna gorde
//        String hilabete = Integer.toString(c1.get(Calendar.MONTH)+1); // hilabetea gorde
//        String urte = Integer.toString(c1.get(Calendar.YEAR)); // urtea gorde
//        BezeroaInfo.setTextData(Metodoak.dataGorde(urte+"/"+hilabete+"/"+egun));
//    }
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    public void bezDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        BezeroaInfo.setModel(model);
        model.addColumn("Kodea");
        model.addColumn("Izena");
        model.addColumn("Abizenak");
        model.addColumn("NAN");
        model.addColumn("Jaiotze data");
        model.addColumn("Sexua");
        model.addColumn("Herria");
        model.addColumn("Telefonoa");
        ArrayList<Bezeroa> bezGuzt = BezeroaKudeatu.bezeroGuztiakErakutsi();
        
        for (int i=0; i<bezGuzt.size(); i++) {
            Bezeroa bez = bezGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(bez.getKodBez(), i, 0);
            model.setValueAt(bez.getIzena(), i, 1);
            model.setValueAt(bez.getAbizena1().concat(" ").concat(bez.getAbizena2()), i, 2);
            model.setValueAt(bez.getNan(), i, 3);
            model.setValueAt(bez.getJaiotzeData(), i, 4);
            model.setValueAt(bez.getSexua(), i, 5);
            model.setValueAt(bez.getHerria(), i, 6);
            model.setValueAt(bez.getTelefonoa(), i, 7);
        }
    }

    public void langDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        LangileaInfo.setModel(model); // ?
        model.addColumn("Kodea");
        model.addColumn("Izena");
        model.addColumn("Abizenak");
        model.addColumn("NAN");
        model.addColumn("Jaiotze data");
        model.addColumn("Sexua");
        model.addColumn("Herria");
        model.addColumn("Telefono");
        model.addColumn("Soldata");
        model.addColumn("Eremua");
        ArrayList<Langilea> langGuzt = LangileaKudeatu.langileGuztiakErakutsi();
        
        for (int i=0; i<langGuzt.size(); i++) {
            Langilea lang = langGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(lang.getKodLan(), i, 0);
            model.setValueAt(lang.getIzena(), i, 1);
            model.setValueAt(lang.getAbizena1().concat(" ").concat(lang.getAbizena2()), i, 2);
            model.setValueAt(lang.getNan(), i, 3);
            model.setValueAt(lang.getJaiotzeData(), i, 4);
            model.setValueAt(lang.getSexua(), i, 5);
            model.setValueAt(lang.getHerria(), i, 6);
            model.setValueAt(lang.getTelefonoa(), i, 7);
            model.setValueAt(lang.getSoldata(), i, 8);
            model.setValueAt(lang.getEremua(), i, 9);
        }
    }
    
    public void hornDatuakErakutsiTaula() {
        DefaultTableModel model = new DefaultTableModel();// definimos el objeto tableModel
        HornitzaileaInfo.setModel(model); // ?
        model.addColumn("Kodea");
        model.addColumn("Izena");
        model.addColumn("Herria");
        model.addColumn("Telefono");
        model.addColumn("Emaila");
        ArrayList<Hornitzailea> hornGuzt = HornitzaileaKudeatu.hornitzaileGuztiakErakutsi();
        
        for (int i=0; i<hornGuzt.size(); i++) {
            Hornitzailea horn = hornGuzt.get(i);
            Array[] os = null;
            model.addRow(os);
            model.setValueAt(horn.getKodHor(), i, 0);
            model.setValueAt(horn.getIzena(), i, 1);
            model.setValueAt(horn.getHerria(), i, 2);
            model.setValueAt(horn.getTelefonoa(), i, 3);
            model.setValueAt(horn.getEmail(), i, 4);
        }
    }
    
    public void hornitzaileaKargatu() {
        ArrayList<String> alHornitzaileGuzt = HornitzaileaKudeatu.hornitzaileIzenak();
        for (int i = 0; i < alHornitzaileGuzt.size(); i++) {
            viewEskaeraGehitu.jComboBoxHornitzailea.addItem(alHornitzaileGuzt.get(i));
            System.out.println(alHornitzaileGuzt.get(i));
        }
    }
    
    public void tailaKargatuJerts() {
        String[] taila = Metodoak.tailaKontrolatuString();
        for (String i : taila) {
            viewJertseaGehitu.jComboBoxTaila.addItem(i);
        }
    }
    
    public void tailaKargatuKam() {
        String[] taila = Metodoak.tailaKontrolatuString();
        for (String i : taila) {
            viewKamisetaGehitu.jComboBoxTaila.addItem(i);
        }
    }
    
    public void tailaKargatuPrak() {
        int[] taila = Metodoak.tailaKontrolatuZenb();
        for (int i : taila) {
            viewPrakaGehitu.jComboBoxTaila.addItem(String.valueOf(i));
        }
    }
    
    public void sexuaKargatuJerts() {
        String[] sexua = Metodoak.sexuaKontrolatu();
        for (String i : sexua) {
            viewJertseaGehitu.jComboBoxSexua.addItem(i);
        }
    }
    
    public void sexuaKargatuKami() {
        String[] sexua = Metodoak.sexuaKontrolatu();
        for (String i : sexua) {
            viewKamisetaGehitu.jComboBoxSexua.addItem(i);
        }
    }
    public void sexuaKargatuPrak() {
        String[] sexua = Metodoak.sexuaKontrolatu();
        for (String i : sexua) {
            viewPrakaGehitu.jComboBoxSexua.addItem(i);
        }
    }
    
//    public void sasoiaKargatuKami() {
//        String[] sasoia = Metodoak.();
//        for (String i : sasoia) {
//            viewKamisetaGehitu.jComboBoxSasoia.addItem(i);
//        }
//    }
//    
//    public void sasoiaKargatuPrak() {
//        String[] sasoia = Metodoak.();
//        for (String i : sasoia) {
//            viewKamisetaGehitu.jComboBoxSasoia.addItem(i);
//        }
//    } 
}
