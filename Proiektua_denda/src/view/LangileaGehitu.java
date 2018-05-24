/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class LangileaGehitu extends javax.swing.JFrame {

    /**
     * Creates new form BezeroaGehitu
     */
    public LangileaGehitu() {
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

        jDialog1 = new javax.swing.JDialog();
        emakumeGizonbuttonGroup1 = new javax.swing.ButtonGroup();
        jPanelOsoa = new javax.swing.JPanel();
        jPanelGoiburua = new javax.swing.JPanel();
        jButtonBerriaGehitu = new javax.swing.JButton();
        jLabelBerriaGehitu = new javax.swing.JLabel();
        jLabelLangGehitu = new javax.swing.JLabel();
        jButtonIrten = new javax.swing.JButton();
        jPanelLangDatuak = new javax.swing.JPanel();
        jLabelIzena = new javax.swing.JLabel();
        jLabelAbizena2 = new javax.swing.JLabel();
        jLabelNan = new javax.swing.JLabel();
        jLabelJaioData = new javax.swing.JLabel();
        jLabelSexua = new javax.swing.JLabel();
        jTextFieldIzena = new javax.swing.JTextField();
        jTextFieldAbizena2 = new javax.swing.JTextField();
        jTextFieldNan = new javax.swing.JTextField();
        jRadioButtonEmak = new javax.swing.JRadioButton();
        jRadioButtonGiz = new javax.swing.JRadioButton();
        jLabelAbizena1 = new javax.swing.JLabel();
        jTextFieldAbizena1 = new javax.swing.JTextField();
        jButtonGorde = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelHerria = new javax.swing.JLabel();
        jTextFieldHerria = new javax.swing.JTextField();
        jLabelTlf = new javax.swing.JLabel();
        jTextFieldTlf = new javax.swing.JTextField();
        jLabelSoldata = new javax.swing.JLabel();
        jTextFieldSoldata = new javax.swing.JTextField();
        jLabelEremua = new javax.swing.JLabel();
        jComboBoxEremua = new javax.swing.JComboBox<>();
        jDateChooserJaioData = new com.toedter.calendar.JDateChooser();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Langile berria");

        jPanelOsoa.setToolTipText("");

        jButtonBerriaGehitu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/argazkiak/berriaGehitu.png"))); // NOI18N
        jButtonBerriaGehitu.setBorder(null);
        jButtonBerriaGehitu.setBorderPainted(false);

        jLabelBerriaGehitu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelBerriaGehitu.setText("Berria gehitu");

        jLabelLangGehitu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLangGehitu.setText("LANGILEAREN DATUAK:");

        javax.swing.GroupLayout jPanelGoiburuaLayout = new javax.swing.GroupLayout(jPanelGoiburua);
        jPanelGoiburua.setLayout(jPanelGoiburuaLayout);
        jPanelGoiburuaLayout.setHorizontalGroup(
            jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGoiburuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLangGehitu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelBerriaGehitu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBerriaGehitu)
                .addContainerGap())
        );
        jPanelGoiburuaLayout.setVerticalGroup(
            jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGoiburuaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLangGehitu)
                    .addComponent(jButtonBerriaGehitu)
                    .addComponent(jLabelBerriaGehitu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonIrten.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonIrten.setText("Irten");
        jButtonIrten.setBorderPainted(false);

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

        jTextFieldIzena.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldAbizena2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldNan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        emakumeGizonbuttonGroup1.add(jRadioButtonEmak);
        jRadioButtonEmak.setText("Emakumea");

        emakumeGizonbuttonGroup1.add(jRadioButtonGiz);
        jRadioButtonGiz.setText("Gizona");

        jLabelAbizena1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelAbizena1.setText("Lehenengo abizena:");

        jTextFieldAbizena1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButtonGorde.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonGorde.setText("Gorde");

        jButtonReset.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonReset.setText("Reset");

        jLabelHerria.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelHerria.setText("Herria:");

        jTextFieldHerria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelTlf.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelTlf.setText("Telefonoa:");

        jTextFieldTlf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelSoldata.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelSoldata.setText("Soldata:");

        jTextFieldSoldata.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelEremua.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelEremua.setText("Eremua:");

        jComboBoxEremua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jDateChooserJaioData.setDateFormatString("yyyy/MM/dd");
        jDateChooserJaioData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanelLangDatuakLayout = new javax.swing.GroupLayout(jPanelLangDatuak);
        jPanelLangDatuak.setLayout(jPanelLangDatuakLayout);
        jPanelLangDatuakLayout.setHorizontalGroup(
            jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelIzena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldIzena, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelAbizena2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAbizena2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelNan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldNan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLangDatuakLayout.createSequentialGroup()
                        .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelJaioData)
                            .addComponent(jLabelSexua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserJaioData, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                                .addComponent(jRadioButtonEmak)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonGiz))))
                    .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelAbizena1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAbizena1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jButtonReset)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGorde)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelHerria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldHerria, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelTlf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelSoldata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldSoldata, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLangDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelEremua)
                        .addGap(107, 107, 107)
                        .addComponent(jComboBoxEremua, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanelLangDatuakLayout.setVerticalGroup(
            jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLangDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIzena)
                    .addComponent(jTextFieldIzena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAbizena1)
                    .addComponent(jTextFieldAbizena1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAbizena2)
                    .addComponent(jTextFieldAbizena2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNan)
                    .addComponent(jTextFieldNan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelJaioData)
                    .addComponent(jDateChooserJaioData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSexua)
                    .addComponent(jRadioButtonGiz)
                    .addComponent(jRadioButtonEmak))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHerria)
                    .addComponent(jTextFieldHerria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTlf)
                    .addComponent(jTextFieldTlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSoldata)
                    .addComponent(jTextFieldSoldata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEremua)
                    .addComponent(jComboBoxEremua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanelLangDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGorde)
                    .addComponent(jButtonReset)))
        );

        javax.swing.GroupLayout jPanelOsoaLayout = new javax.swing.GroupLayout(jPanelOsoa);
        jPanelOsoa.setLayout(jPanelOsoaLayout);
        jPanelOsoaLayout.setHorizontalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
            .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanelGoiburua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelOsoaLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jPanelLangDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonIrten)))
                    .addContainerGap()))
        );
        jPanelOsoaLayout.setVerticalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
            .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanelLangDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonIrten))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOsoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOsoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(LangileaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LangileaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LangileaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LangileaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LangileaGehitu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup emakumeGizonbuttonGroup1;
    public javax.swing.JButton jButtonBerriaGehitu;
    public javax.swing.JButton jButtonGorde;
    public javax.swing.JButton jButtonIrten;
    public javax.swing.JButton jButtonReset;
    public javax.swing.JComboBox<String> jComboBoxEremua;
    public com.toedter.calendar.JDateChooser jDateChooserJaioData;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabelAbizena1;
    private javax.swing.JLabel jLabelAbizena2;
    private javax.swing.JLabel jLabelBerriaGehitu;
    private javax.swing.JLabel jLabelEremua;
    private javax.swing.JLabel jLabelHerria;
    private javax.swing.JLabel jLabelIzena;
    private javax.swing.JLabel jLabelJaioData;
    private javax.swing.JLabel jLabelLangGehitu;
    private javax.swing.JLabel jLabelNan;
    private javax.swing.JLabel jLabelSexua;
    private javax.swing.JLabel jLabelSoldata;
    private javax.swing.JLabel jLabelTlf;
    public javax.swing.JPanel jPanelGoiburua;
    public javax.swing.JPanel jPanelLangDatuak;
    public javax.swing.JPanel jPanelOsoa;
    public javax.swing.JRadioButton jRadioButtonEmak;
    public javax.swing.JRadioButton jRadioButtonGiz;
    public javax.swing.JTextField jTextFieldAbizena1;
    public javax.swing.JTextField jTextFieldAbizena2;
    public javax.swing.JTextField jTextFieldHerria;
    public javax.swing.JTextField jTextFieldIzena;
    public javax.swing.JTextField jTextFieldNan;
    public javax.swing.JTextField jTextFieldSoldata;
    public javax.swing.JTextField jTextFieldTlf;
    // End of variables declaration//GEN-END:variables
}
