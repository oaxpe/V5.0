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
public class JertseaGehitu extends javax.swing.JFrame {

    /**
     * Creates new form BezeroaGehitu
     */
    public JertseaGehitu() {
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
        jLabelJertsGehitu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonGorde = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelKodJerts = new javax.swing.JLabel();
        jTextFieldKodeJerts = new javax.swing.JTextField();
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
        jButtonIrten = new javax.swing.JButton();

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
        setTitle("Bezero berri bat gehitu");

        jLabelJertsGehitu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelJertsGehitu.setText("JERTSE BERRIAREN DATUAK:");

        jButtonGorde.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonGorde.setText("Gorde");

        jButtonReset.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonReset.setText("Reset");

        jLabelKodJerts.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelKodJerts.setText("Kodea:");

        jLabelMarka.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelMarka.setText("Marka:");

        jLabelPrezioa.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelPrezioa.setText("Prezioa:");

        jLabelKolorea.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelKolorea.setText("Kolorea:");

        jLabelSexua.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelSexua.setText("Sexua:");

        jLabelJaioData.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelJaioData.setText("Stock-ean:");

        jLabelTaila.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelTaila.setText("Taila:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonReset)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGorde)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelMarka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldMarka, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelKolorea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldKolorea, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPrezioa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPrezioa, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelKodJerts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldKodeJerts, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelJaioData)
                            .addComponent(jLabelTaila)
                            .addComponent(jLabelSexua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldStock)
                            .addComponent(jComboBoxTaila, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxSexua, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKodJerts)
                    .addComponent(jTextFieldKodeJerts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMarka)
                    .addComponent(jTextFieldMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrezioa)
                    .addComponent(jTextFieldPrezioa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKolorea)
                    .addComponent(jTextFieldKolorea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSexua)
                    .addComponent(jComboBoxSexua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJaioData)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTaila)
                    .addComponent(jComboBoxTaila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGorde)
                    .addComponent(jButtonReset)))
        );

        jButtonIrten.setBackground(new java.awt.Color(51, 0, 0));
        jButtonIrten.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonIrten.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIrten.setText("Irten");
        jButtonIrten.setBorderPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIrten)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelJertsGehitu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelJertsGehitu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonIrten)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(JertseaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JertseaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JertseaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JertseaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JertseaGehitu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup emakumeGizonbuttonGroup1;
    public javax.swing.JButton jButtonGorde;
    public javax.swing.JButton jButtonIrten;
    public javax.swing.JButton jButtonReset;
    public javax.swing.JComboBox<String> jComboBoxSexua;
    public javax.swing.JComboBox<String> jComboBoxTaila;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabelJaioData;
    private javax.swing.JLabel jLabelJertsGehitu;
    private javax.swing.JLabel jLabelKodJerts;
    private javax.swing.JLabel jLabelKolorea;
    private javax.swing.JLabel jLabelMarka;
    private javax.swing.JLabel jLabelPrezioa;
    private javax.swing.JLabel jLabelSexua;
    private javax.swing.JLabel jLabelTaila;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldKodeJerts;
    public javax.swing.JTextField jTextFieldKolorea;
    public javax.swing.JTextField jTextFieldMarka;
    public javax.swing.JTextField jTextFieldPrezioa;
    public javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables
}