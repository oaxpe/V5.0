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
public class HornitzaileaGehitu extends javax.swing.JFrame {

    /**
     * Creates new form BezeroaGehitu
     */
    public HornitzaileaGehitu() {
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
        jPanelHornDatuak = new javax.swing.JPanel();
        izenaLabel = new javax.swing.JLabel();
        tlfLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jTextFieldIzena = new javax.swing.JTextField();
        jTextFieldTlf = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        herriaLabel = new javax.swing.JLabel();
        jTextFieldHerria = new javax.swing.JTextField();
        jButtonGorde = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonIrten = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonBerriaGehitu = new javax.swing.JButton();
        jLabelBerriaGehitu = new javax.swing.JLabel();
        jLabelHornGehitu = new javax.swing.JLabel();

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

        izenaLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        izenaLabel.setText("Izena:");

        tlfLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tlfLabel.setText("Telefonoa:");

        emailLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        emailLabel.setText("Email:");

        herriaLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        herriaLabel.setText("Herria:");

        jButtonGorde.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonGorde.setText("Gorde");

        jButtonReset.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonReset.setText("Reset");

        javax.swing.GroupLayout jPanelHornDatuakLayout = new javax.swing.GroupLayout(jPanelHornDatuak);
        jPanelHornDatuak.setLayout(jPanelHornDatuakLayout);
        jPanelHornDatuakLayout.setHorizontalGroup(
            jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHornDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHornDatuakLayout.createSequentialGroup()
                        .addComponent(jButtonReset)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGorde)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelHornDatuakLayout.createSequentialGroup()
                        .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tlfLabel)
                            .addComponent(emailLabel))
                        .addGap(37, 37, 37)
                        .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldTlf)))
                    .addGroup(jPanelHornDatuakLayout.createSequentialGroup()
                        .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(herriaLabel)
                            .addComponent(izenaLabel))
                        .addGap(64, 64, 64)
                        .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldHerria)
                            .addComponent(jTextFieldIzena)))))
        );
        jPanelHornDatuakLayout.setVerticalGroup(
            jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHornDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izenaLabel)
                    .addComponent(jTextFieldIzena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(herriaLabel)
                    .addComponent(jTextFieldHerria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tlfLabel)
                    .addComponent(jTextFieldTlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGorde)
                    .addComponent(jButtonReset)))
        );

        jButtonIrten.setBackground(new java.awt.Color(51, 0, 0));
        jButtonIrten.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonIrten.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIrten.setText("Irten");
        jButtonIrten.setBorderPainted(false);

        jButtonBerriaGehitu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/argazkiak/berriaGehitu.png"))); // NOI18N
        jButtonBerriaGehitu.setBorder(null);
        jButtonBerriaGehitu.setBorderPainted(false);

        jLabelBerriaGehitu.setText("Berria gehitu");

        jLabelHornGehitu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelHornGehitu.setText("HORNITZAILEAREN DATUAK:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHornGehitu, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabelBerriaGehitu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBerriaGehitu)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHornGehitu)
                    .addComponent(jButtonBerriaGehitu)
                    .addComponent(jLabelBerriaGehitu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanelHornDatuak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonIrten)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonIrten)
                    .addComponent(jPanelHornDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(HornitzaileaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HornitzaileaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HornitzaileaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HornitzaileaGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new HornitzaileaGehitu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailLabel;
    private javax.swing.ButtonGroup emakumeGizonbuttonGroup1;
    private javax.swing.JLabel herriaLabel;
    private javax.swing.JLabel izenaLabel;
    public javax.swing.JButton jButtonBerriaGehitu;
    public javax.swing.JButton jButtonGorde;
    public javax.swing.JButton jButtonIrten;
    public javax.swing.JButton jButtonReset;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabelBerriaGehitu;
    private javax.swing.JLabel jLabelHornGehitu;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanelHornDatuak;
    public javax.swing.JTextField jTextFieldEmail;
    public javax.swing.JTextField jTextFieldHerria;
    public javax.swing.JTextField jTextFieldIzena;
    public javax.swing.JTextField jTextFieldTlf;
    private javax.swing.JLabel tlfLabel;
    // End of variables declaration//GEN-END:variables
}
