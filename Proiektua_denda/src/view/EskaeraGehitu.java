/*
 * To change this license header, choose     @Override
    public int getWidth(ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHeight(ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageProducer getSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Graphics getGraphics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getProperty(String name, ImageObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Oihane Axpe
 * @version 5.0
 */
public class EskaeraGehitu extends javax.swing.JFrame {

    /**
     * Creates new form BezeroaGehitu
     */
    public EskaeraGehitu() {
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

        buttonGroupProd = new javax.swing.ButtonGroup();
        jPanelOsoa = new javax.swing.JPanel();
        jPanelEskDatuak = new javax.swing.JPanel();
        jLabelHornitzailea = new javax.swing.JLabel();
        jComboBoxHornitzailea = new javax.swing.JComboBox();
        jLabelKopurua = new javax.swing.JLabel();
        jTextFieldKopurua = new javax.swing.JTextField();
        jButtonReset = new javax.swing.JButton();
        jButtonGorde = new javax.swing.JButton();
        jLabelProdTaila = new javax.swing.JLabel();
        jComboBoxProdTaila = new javax.swing.JComboBox();
        jLabelProdKode = new javax.swing.JLabel();
        jTextFieldProdKode = new javax.swing.JTextField();
        jLabelProduktua = new javax.swing.JLabel();
        jRadioButtonKami = new javax.swing.JRadioButton();
        jRadioButtonJerts = new javax.swing.JRadioButton();
        jRadioButtonPrak = new javax.swing.JRadioButton();
        jButtonIrten = new javax.swing.JButton();
        jPanelGoiburua = new javax.swing.JPanel();
        jButtonBerriaGehitu = new javax.swing.JButton();
        jLabelBerriaGehitu = new javax.swing.JLabel();
        jLabelEskGehitu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eskaera berria");

        jLabelHornitzailea.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelHornitzailea.setText("Hornitzailea:");

        jComboBoxHornitzailea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelKopurua.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelKopurua.setText("Kopurua:");

        jTextFieldKopurua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButtonReset.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonReset.setText("Reset");

        jButtonGorde.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonGorde.setText("Gorde");

        jLabelProdTaila.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelProdTaila.setText("Prod. taila:");

        jComboBoxProdTaila.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelProdKode.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelProdKode.setText("Prod. kodea:");

        jTextFieldProdKode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelProduktua.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelProduktua.setText("PRODUKTUA:");

        buttonGroupProd.add(jRadioButtonKami);
        jRadioButtonKami.setText("Kamiseta");

        buttonGroupProd.add(jRadioButtonJerts);
        jRadioButtonJerts.setText("Jertsea");

        buttonGroupProd.add(jRadioButtonPrak);
        jRadioButtonPrak.setText("Praka");

        javax.swing.GroupLayout jPanelEskDatuakLayout = new javax.swing.GroupLayout(jPanelEskDatuak);
        jPanelEskDatuak.setLayout(jPanelEskDatuakLayout);
        jPanelEskDatuakLayout.setHorizontalGroup(
            jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEskDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEskDatuakLayout.createSequentialGroup()
                        .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHornitzailea)
                            .addComponent(jLabelKopurua)
                            .addComponent(jLabelProdTaila)
                            .addComponent(jLabelProdKode))
                        .addGap(25, 25, 25)
                        .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldProdKode)
                            .addComponent(jComboBoxProdTaila, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldKopurua)
                            .addComponent(jComboBoxHornitzailea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelEskDatuakLayout.createSequentialGroup()
                        .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEskDatuakLayout.createSequentialGroup()
                                .addComponent(jButtonReset)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGorde))
                            .addGroup(jPanelEskDatuakLayout.createSequentialGroup()
                                .addComponent(jLabelProduktua, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonKami)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonJerts)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonPrak)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelEskDatuakLayout.setVerticalGroup(
            jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEskDatuakLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonKami)
                    .addComponent(jRadioButtonJerts)
                    .addComponent(jRadioButtonPrak)
                    .addComponent(jLabelProduktua, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHornitzailea)
                    .addComponent(jComboBoxHornitzailea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProdKode)
                    .addComponent(jTextFieldProdKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProdTaila)
                    .addComponent(jComboBoxProdTaila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKopurua)
                    .addComponent(jTextFieldKopurua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEskDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonGorde)))
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

        jLabelEskGehitu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEskGehitu.setText("ESKAERAREN DATUAK:");

        javax.swing.GroupLayout jPanelGoiburuaLayout = new javax.swing.GroupLayout(jPanelGoiburua);
        jPanelGoiburua.setLayout(jPanelGoiburuaLayout);
        jPanelGoiburuaLayout.setHorizontalGroup(
            jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGoiburuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEskGehitu, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
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
                    .addComponent(jLabelEskGehitu, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBerriaGehitu)
                    .addComponent(jLabelBerriaGehitu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelOsoaLayout = new javax.swing.GroupLayout(jPanelOsoa);
        jPanelOsoa.setLayout(jPanelOsoaLayout);
        jPanelOsoaLayout.setHorizontalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOsoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelOsoaLayout.createSequentialGroup()
                        .addComponent(jPanelEskDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonIrten)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelOsoaLayout.setVerticalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOsoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonIrten)
                    .addComponent(jPanelEskDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOsoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelOsoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(EskaeraGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EskaeraGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EskaeraGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EskaeraGehitu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new EskaeraGehitu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupProd;
    public javax.swing.JButton jButtonBerriaGehitu;
    public javax.swing.JButton jButtonGorde;
    public javax.swing.JButton jButtonIrten;
    public javax.swing.JButton jButtonReset;
    public javax.swing.JComboBox jComboBoxHornitzailea;
    public javax.swing.JComboBox jComboBoxProdTaila;
    private javax.swing.JLabel jLabelBerriaGehitu;
    private javax.swing.JLabel jLabelEskGehitu;
    private javax.swing.JLabel jLabelHornitzailea;
    private javax.swing.JLabel jLabelKopurua;
    private javax.swing.JLabel jLabelProdKode;
    private javax.swing.JLabel jLabelProdTaila;
    private javax.swing.JLabel jLabelProduktua;
    public javax.swing.JPanel jPanelEskDatuak;
    public javax.swing.JPanel jPanelGoiburua;
    public javax.swing.JPanel jPanelOsoa;
    public javax.swing.JRadioButton jRadioButtonJerts;
    public javax.swing.JRadioButton jRadioButtonKami;
    public javax.swing.JRadioButton jRadioButtonPrak;
    public javax.swing.JTextField jTextFieldKopurua;
    public javax.swing.JTextField jTextFieldProdKode;
    // End of variables declaration//GEN-END:variables
}

