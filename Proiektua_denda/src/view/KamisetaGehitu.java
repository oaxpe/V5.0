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
public class KamisetaGehitu extends javax.swing.JFrame {

    /**
     * Creates new form BezeroaGehitu
     */
    public KamisetaGehitu() {
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
        jPanelKamiDatuak = new javax.swing.JPanel();
        jButtonGorde = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelKodKami = new javax.swing.JLabel();
        jTextFieldKodeKami = new javax.swing.JTextField();
        jLabelMarka = new javax.swing.JLabel();
        jTextFieldMarka = new javax.swing.JTextField();
        jLabelPrezioa = new javax.swing.JLabel();
        jTextFieldPrezioa = new javax.swing.JTextField();
        jLabelKolorea = new javax.swing.JLabel();
        jTextFieldKolorea = new javax.swing.JTextField();
        jLabelSexua = new javax.swing.JLabel();
        jComboBoxSexua = new javax.swing.JComboBox<>();
        jLabelJaioData = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jLabelTaila = new javax.swing.JLabel();
        jComboBoxTaila = new javax.swing.JComboBox<>();
        jLabelSasoia = new javax.swing.JLabel();
        jComboBoxSasoia = new javax.swing.JComboBox<>();
        jButtonIrten = new javax.swing.JButton();
        jPanelGoiburua = new javax.swing.JPanel();
        jButtonBerriaGehitu = new javax.swing.JButton();
        jLabelBerriaGehitu = new javax.swing.JLabel();
        jLabelKamiGehitu = new javax.swing.JLabel();

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

        jButtonGorde.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonGorde.setText("Gorde");

        jButtonReset.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonReset.setText("Reset");

        jLabelKodKami.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelKodKami.setText("Kodea:");

        jTextFieldKodeKami.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelMarka.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelMarka.setText("Marka:");

        jTextFieldMarka.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelPrezioa.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelPrezioa.setText("Prezioa:");

        jTextFieldPrezioa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelKolorea.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelKolorea.setText("Kolorea:");

        jTextFieldKolorea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelSexua.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelSexua.setText("Sexua:");

        jComboBoxSexua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelJaioData.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelJaioData.setText("Stock-ean:");

        jTextFieldStock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelTaila.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelTaila.setText("Taila:");

        jComboBoxTaila.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelSasoia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelSasoia.setText("Sasoia:");

        jComboBoxSasoia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanelKamiDatuakLayout = new javax.swing.GroupLayout(jPanelKamiDatuak);
        jPanelKamiDatuak.setLayout(jPanelKamiDatuakLayout);
        jPanelKamiDatuakLayout.setHorizontalGroup(
            jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKamiDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKamiDatuakLayout.createSequentialGroup()
                        .addComponent(jButtonReset)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGorde)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelKamiDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelMarka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldMarka, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelKamiDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelKolorea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jTextFieldKolorea, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelKamiDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelPrezioa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPrezioa, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelKamiDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelKodKami)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldKodeKami, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKamiDatuakLayout.createSequentialGroup()
                        .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelJaioData)
                            .addComponent(jLabelTaila)
                            .addComponent(jLabelSexua)
                            .addComponent(jLabelSasoia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxSasoia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldStock)
                            .addComponent(jComboBoxTaila, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxSexua, 0, 164, Short.MAX_VALUE)))))
        );
        jPanelKamiDatuakLayout.setVerticalGroup(
            jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKamiDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKodKami)
                    .addComponent(jTextFieldKodeKami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMarka)
                    .addComponent(jTextFieldMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrezioa)
                    .addComponent(jTextFieldPrezioa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKolorea)
                    .addComponent(jTextFieldKolorea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSexua)
                    .addComponent(jComboBoxSexua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJaioData)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTaila)
                    .addComponent(jComboBoxTaila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSasoia)
                    .addComponent(jComboBoxSasoia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanelKamiDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGorde)
                    .addComponent(jButtonReset)))
        );

        jButtonIrten.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonIrten.setText("Irten");
        jButtonIrten.setBorderPainted(false);

        jButtonBerriaGehitu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/argazkiak/berriaGehitu.png"))); // NOI18N
        jButtonBerriaGehitu.setBorder(null);
        jButtonBerriaGehitu.setBorderPainted(false);
        jButtonBerriaGehitu.setOpaque(false);

        jLabelBerriaGehitu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelBerriaGehitu.setText("Berria gehitu");

        jLabelKamiGehitu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelKamiGehitu.setText("KAMISETA BERRIAREN DATUAK:");

        javax.swing.GroupLayout jPanelGoiburuaLayout = new javax.swing.GroupLayout(jPanelGoiburua);
        jPanelGoiburua.setLayout(jPanelGoiburuaLayout);
        jPanelGoiburuaLayout.setHorizontalGroup(
            jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGoiburuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelKamiGehitu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
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
                    .addComponent(jLabelKamiGehitu)
                    .addComponent(jButtonBerriaGehitu)
                    .addComponent(jLabelBerriaGehitu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelOsoaLayout = new javax.swing.GroupLayout(jPanelOsoa);
        jPanelOsoa.setLayout(jPanelOsoaLayout);
        jPanelOsoaLayout.setHorizontalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOsoaLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanelKamiDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButtonIrten)
                .addContainerGap())
            .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        jPanelOsoaLayout.setVerticalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOsoaLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonIrten)
                    .addComponent(jPanelKamiDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(380, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelOsoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelOsoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
            java.util.logging.Logger.getLogger(KamisetaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KamisetaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KamisetaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KamisetaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KamisetaGehitu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup emakumeGizonbuttonGroup1;
    public javax.swing.JButton jButtonBerriaGehitu;
    public javax.swing.JButton jButtonGorde;
    public javax.swing.JButton jButtonIrten;
    public javax.swing.JButton jButtonReset;
    public javax.swing.JComboBox<String> jComboBoxSasoia;
    public javax.swing.JComboBox<String> jComboBoxSexua;
    public javax.swing.JComboBox<String> jComboBoxTaila;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabelBerriaGehitu;
    private javax.swing.JLabel jLabelJaioData;
    private javax.swing.JLabel jLabelKamiGehitu;
    private javax.swing.JLabel jLabelKodKami;
    private javax.swing.JLabel jLabelKolorea;
    private javax.swing.JLabel jLabelMarka;
    private javax.swing.JLabel jLabelPrezioa;
    private javax.swing.JLabel jLabelSasoia;
    private javax.swing.JLabel jLabelSexua;
    private javax.swing.JLabel jLabelTaila;
    public javax.swing.JPanel jPanelGoiburua;
    public javax.swing.JPanel jPanelKamiDatuak;
    public javax.swing.JPanel jPanelOsoa;
    public javax.swing.JTextField jTextFieldKodeKami;
    public javax.swing.JTextField jTextFieldKolorea;
    public javax.swing.JTextField jTextFieldMarka;
    public javax.swing.JTextField jTextFieldPrezioa;
    public javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables
}
