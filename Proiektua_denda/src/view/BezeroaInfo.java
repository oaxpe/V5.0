/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Oihane Axpe
 * @version 4.0
 */
public class BezeroaInfo extends javax.swing.JFrame {
    
    /**
     * Creates new form BezeroaInformazioa
     */
    public BezeroaInfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroupEmGiz = new javax.swing.ButtonGroup();
        jDialogEzabatuKonfirm = new javax.swing.JDialog();
        jPanelOsoa = new javax.swing.JPanel();
        jPanelBezTaula = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBezeroaInfo = new javax.swing.JTable();
        jButtonAldaketaGorde = new javax.swing.JButton();
        jButtonAldaketaEzabatu = new javax.swing.JButton();
        jPanelBezDatuak = new javax.swing.JPanel();
        jLabelIzena = new javax.swing.JLabel();
        jLabelAbizena2 = new javax.swing.JLabel();
        jLabelNan = new javax.swing.JLabel();
        jLabelJaioData = new javax.swing.JLabel();
        jLabelSexua = new javax.swing.JLabel();
        jLabelAbizena1 = new javax.swing.JLabel();
        jLabelHerria = new javax.swing.JLabel();
        jLabelTlf = new javax.swing.JLabel();
        jLabelKodBez = new javax.swing.JLabel();
        jTextFieldKodeBez = new javax.swing.JTextField();
        jTextFieldIzena = new javax.swing.JTextField();
        jTextFieldAbizena1 = new javax.swing.JTextField();
        jTextFieldAbizena2 = new javax.swing.JTextField();
        jTextFieldNan = new javax.swing.JTextField();
        jRadioButtonEmak = new javax.swing.JRadioButton();
        jRadioButtonGiz = new javax.swing.JRadioButton();
        jTextFieldHerria = new javax.swing.JTextField();
        jTextFieldTlf = new javax.swing.JTextField();
        jDateChooserJaioData = new com.toedter.calendar.JDateChooser();
        jPanelGoiburua = new javax.swing.JPanel();
        jTextFieldBilatu = new javax.swing.JTextField();
        jLabelBezKud = new javax.swing.JLabel();
        bilatuLabel2 = new javax.swing.JLabel();
        jPanelOina = new javax.swing.JPanel();
        jButtonIrten = new javax.swing.JButton();
        jButtonGehitu = new javax.swing.JButton();
        jButtonAldatu = new javax.swing.JButton();
        jButtonEzabatu = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jDialogEzabatuKonfirmLayout = new javax.swing.GroupLayout(jDialogEzabatuKonfirm.getContentPane());
        jDialogEzabatuKonfirm.getContentPane().setLayout(jDialogEzabatuKonfirmLayout);
        jDialogEzabatuKonfirmLayout.setHorizontalGroup(
            jDialogEzabatuKonfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialogEzabatuKonfirmLayout.setVerticalGroup(
            jDialogEzabatuKonfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableBezeroaInfo.setAutoCreateRowSorter(true);
        jTableBezeroaInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableBezeroaInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableBezeroaInfo.setToolTipText("");
        jTableBezeroaInfo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(jTableBezeroaInfo);

        jButtonAldaketaGorde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/argazkiak/gorde.png"))); // NOI18N
        jButtonAldaketaGorde.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonAldaketaEzabatu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/argazkiak/ezeztatu.png"))); // NOI18N
        jButtonAldaketaEzabatu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelBezTaulaLayout = new javax.swing.GroupLayout(jPanelBezTaula);
        jPanelBezTaula.setLayout(jPanelBezTaulaLayout);
        jPanelBezTaulaLayout.setHorizontalGroup(
            jPanelBezTaulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(jPanelBezTaulaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAldaketaGorde)
                .addGap(18, 18, 18)
                .addComponent(jButtonAldaketaEzabatu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBezTaulaLayout.setVerticalGroup(
            jPanelBezTaulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBezTaulaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBezTaulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAldaketaGorde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAldaketaEzabatu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabelIzena.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelIzena.setText("Izena:");

        jLabelAbizena2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelAbizena2.setText("Bigarren abizena:");

        jLabelNan.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelNan.setText("NAN:");

        jLabelJaioData.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelJaioData.setText("Jaiotze data:");

        jLabelSexua.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelSexua.setText("Sexua:");

        jLabelAbizena1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelAbizena1.setText("Lehenengo abizena:");

        jLabelHerria.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelHerria.setText("Herria:");

        jLabelTlf.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelTlf.setText("Telefonoa:");

        jLabelKodBez.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelKodBez.setText("Kodea:");

        jTextFieldKodeBez.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldKodeBez.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldIzena.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldIzena.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldAbizena1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldAbizena1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldAbizena2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldAbizena2.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldNan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldNan.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        buttonGroupEmGiz.add(jRadioButtonEmak);
        jRadioButtonEmak.setText("Emakumea");

        buttonGroupEmGiz.add(jRadioButtonGiz);
        jRadioButtonGiz.setText("Gizona");

        jTextFieldHerria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldHerria.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldTlf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldTlf.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jDateChooserJaioData.setDateFormatString("yyyy/MM/dd");

        javax.swing.GroupLayout jPanelBezDatuakLayout = new javax.swing.GroupLayout(jPanelBezDatuak);
        jPanelBezDatuak.setLayout(jPanelBezDatuakLayout);
        jPanelBezDatuakLayout.setHorizontalGroup(
            jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBezDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKodBez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTlf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelHerria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAbizena1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelJaioData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSexua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelIzena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAbizena2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBezDatuakLayout.createSequentialGroup()
                        .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBezDatuakLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldKodeBez, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIzena, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldAbizena1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldAbizena2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBezDatuakLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonEmak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonGiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jTextFieldHerria, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBezDatuakLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooserJaioData, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(jPanelBezDatuakLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelBezDatuakLayout.setVerticalGroup(
            jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBezDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKodBez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldKodeBez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIzena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldIzena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAbizena1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldAbizena1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAbizena2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldAbizena2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldNan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelJaioData)
                    .addComponent(jDateChooserJaioData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSexua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonEmak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonGiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHerria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldHerria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBezDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTlf)
                    .addComponent(jTextFieldTlf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldBilatu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelBezKud.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelBezKud.setText("BEZEROAK KUDEATU");

        bilatuLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/argazkiak/bilaketaLupa.png"))); // NOI18N

        javax.swing.GroupLayout jPanelGoiburuaLayout = new javax.swing.GroupLayout(jPanelGoiburua);
        jPanelGoiburua.setLayout(jPanelGoiburuaLayout);
        jPanelGoiburuaLayout.setHorizontalGroup(
            jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGoiburuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBezKud, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 658, Short.MAX_VALUE)
                .addComponent(bilatuLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldBilatu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelGoiburuaLayout.setVerticalGroup(
            jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGoiburuaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextFieldBilatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGoiburuaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bilatuLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGoiburuaLayout.createSequentialGroup()
                        .addComponent(jLabelBezKud)
                        .addContainerGap())))
        );

        jButtonIrten.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonIrten.setText("Irten");
        jButtonIrten.setBorderPainted(false);

        jButtonGehitu.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonGehitu.setText("Gehitu");

        jButtonAldatu.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonAldatu.setText("Aldatu");

        jButtonEzabatu.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonEzabatu.setText("Ezabatu");

        javax.swing.GroupLayout jPanelOinaLayout = new javax.swing.GroupLayout(jPanelOina);
        jPanelOina.setLayout(jPanelOinaLayout);
        jPanelOinaLayout.setHorizontalGroup(
            jPanelOinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOinaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEzabatu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAldatu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGehitu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonIrten)
                .addContainerGap())
        );
        jPanelOinaLayout.setVerticalGroup(
            jPanelOinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOinaLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanelOinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonEzabatu)
                        .addComponent(jButtonAldatu)
                        .addComponent(jButtonGehitu))
                    .addComponent(jButtonIrten))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelOsoaLayout = new javax.swing.GroupLayout(jPanelOsoa);
        jPanelOsoa.setLayout(jPanelOsoaLayout);
        jPanelOsoaLayout.setHorizontalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOsoaLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelOina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelOsoaLayout.createSequentialGroup()
                        .addComponent(jPanelBezDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelBezTaula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelOsoaLayout.setVerticalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOsoaLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBezDatuak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBezTaula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelOina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(376, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelOsoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOsoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BezeroaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BezeroaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BezeroaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BezeroaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BezeroaInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bilatuLabel2;
    private javax.swing.ButtonGroup buttonGroupEmGiz;
    public javax.swing.JButton jButtonAldaketaEzabatu;
    public javax.swing.JButton jButtonAldaketaGorde;
    public javax.swing.JButton jButtonAldatu;
    public javax.swing.JButton jButtonEzabatu;
    public javax.swing.JButton jButtonGehitu;
    public javax.swing.JButton jButtonIrten;
    public com.toedter.calendar.JDateChooser jDateChooserJaioData;
    public javax.swing.JDialog jDialogEzabatuKonfirm;
    private javax.swing.JLabel jLabelAbizena1;
    private javax.swing.JLabel jLabelAbizena2;
    private javax.swing.JLabel jLabelBezKud;
    private javax.swing.JLabel jLabelHerria;
    private javax.swing.JLabel jLabelIzena;
    private javax.swing.JLabel jLabelJaioData;
    private javax.swing.JLabel jLabelKodBez;
    private javax.swing.JLabel jLabelNan;
    private javax.swing.JLabel jLabelSexua;
    private javax.swing.JLabel jLabelTlf;
    public javax.swing.JPanel jPanelBezDatuak;
    public javax.swing.JPanel jPanelBezTaula;
    public javax.swing.JPanel jPanelGoiburua;
    public javax.swing.JPanel jPanelOina;
    public javax.swing.JPanel jPanelOsoa;
    public javax.swing.JRadioButton jRadioButtonEmak;
    public javax.swing.JRadioButton jRadioButtonGiz;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTableBezeroaInfo;
    public javax.swing.JTextField jTextFieldAbizena1;
    public javax.swing.JTextField jTextFieldAbizena2;
    public javax.swing.JTextField jTextFieldBilatu;
    public javax.swing.JTextField jTextFieldHerria;
    public javax.swing.JTextField jTextFieldIzena;
    public javax.swing.JTextField jTextFieldKodeBez;
    public javax.swing.JTextField jTextFieldNan;
    public javax.swing.JTextField jTextFieldTlf;
    // End of variables declaration//GEN-END:variables
    
}
