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
public class HornitzaileaInfo extends javax.swing.JFrame {
    
    /**
     * Creates new form BezeroaInformazioa
     */
    public HornitzaileaInfo() {
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
        jPanelOina = new javax.swing.JPanel();
        jButtonIrten = new javax.swing.JButton();
        jButtonGehitu = new javax.swing.JButton();
        jButtonAldatu = new javax.swing.JButton();
        jButtonEzabatu = new javax.swing.JButton();
        jPanelGoiburua = new javax.swing.JPanel();
        jTextFieldBilatu = new javax.swing.JTextField();
        jLabelHorKud = new javax.swing.JLabel();
        bilatuLabel2 = new javax.swing.JLabel();
        jPanelHornDatuak = new javax.swing.JPanel();
        jLabelIzena = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelHerria = new javax.swing.JLabel();
        jLabelTlf = new javax.swing.JLabel();
        jLabelKodHor = new javax.swing.JLabel();
        jPanelHornTextField = new javax.swing.JPanel();
        jTextFieldKodeHor = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldIzena = new javax.swing.JTextField();
        jTextFieldTlf = new javax.swing.JTextField();
        jTextFieldHerria = new javax.swing.JTextField();
        jPanelHornInfoTaula = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableHornitzaileaInfo = new javax.swing.JTable();

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

        jButtonIrten.setBackground(new java.awt.Color(51, 0, 0));
        jButtonIrten.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonIrten.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGap(23, 23, 23))
        );
        jPanelOinaLayout.setVerticalGroup(
            jPanelOinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOinaLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanelOinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEzabatu)
                    .addComponent(jButtonAldatu)
                    .addComponent(jButtonGehitu)
                    .addComponent(jButtonIrten))
                .addContainerGap())
        );

        jLabelHorKud.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelHorKud.setText("HORNITZAILEAK KUDEATU");

        bilatuLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/argazkiak/bilaketaLupa.png"))); // NOI18N

        javax.swing.GroupLayout jPanelGoiburuaLayout = new javax.swing.GroupLayout(jPanelGoiburua);
        jPanelGoiburua.setLayout(jPanelGoiburuaLayout);
        jPanelGoiburuaLayout.setHorizontalGroup(
            jPanelGoiburuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGoiburuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHorKud, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 582, Short.MAX_VALUE)
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
                        .addComponent(jLabelHorKud)
                        .addContainerGap())))
        );

        jLabelIzena.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelIzena.setText("Izena:");

        jLabelEmail.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelEmail.setText("Emaila:");

        jLabelHerria.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelHerria.setText("Herria:");

        jLabelTlf.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelTlf.setText("Telefonoa:");

        jLabelKodHor.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabelKodHor.setText("Kodea:");

        jTextFieldKodeHor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldKodeHor.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldIzena.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldIzena.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldTlf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldTlf.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTextFieldHerria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldHerria.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelHornTextFieldLayout = new javax.swing.GroupLayout(jPanelHornTextField);
        jPanelHornTextField.setLayout(jPanelHornTextFieldLayout);
        jPanelHornTextFieldLayout.setHorizontalGroup(
            jPanelHornTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHornTextFieldLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelHornTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldIzena, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHerria, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKodeHor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanelHornTextFieldLayout.setVerticalGroup(
            jPanelHornTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHornTextFieldLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextFieldKodeHor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldIzena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldHerria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldTlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelHornDatuakLayout = new javax.swing.GroupLayout(jPanelHornDatuak);
        jPanelHornDatuak.setLayout(jPanelHornDatuakLayout);
        jPanelHornDatuakLayout.setHorizontalGroup(
            jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHornDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKodHor)
                    .addComponent(jLabelTlf)
                    .addComponent(jLabelHerria)
                    .addComponent(jLabelIzena)
                    .addComponent(jLabelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelHornTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHornDatuakLayout.setVerticalGroup(
            jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHornDatuakLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHornDatuakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelHornTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelHornDatuakLayout.createSequentialGroup()
                        .addComponent(jLabelKodHor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIzena)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelHerria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTlf)
                        .addGap(11, 11, 11)
                        .addComponent(jLabelEmail)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableHornitzaileaInfo.setAutoCreateRowSorter(true);
        jTableHornitzaileaInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableHornitzaileaInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableHornitzaileaInfo.setToolTipText("");
        jTableHornitzaileaInfo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableHornitzaileaInfo.setAutoscrolls(false);
        jScrollPane3.setViewportView(jTableHornitzaileaInfo);

        javax.swing.GroupLayout jPanelHornInfoTaulaLayout = new javax.swing.GroupLayout(jPanelHornInfoTaula);
        jPanelHornInfoTaula.setLayout(jPanelHornInfoTaulaLayout);
        jPanelHornInfoTaulaLayout.setHorizontalGroup(
            jPanelHornInfoTaulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHornInfoTaulaLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHornInfoTaulaLayout.setVerticalGroup(
            jPanelHornInfoTaulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHornInfoTaulaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelOsoaLayout = new javax.swing.GroupLayout(jPanelOsoa);
        jPanelOsoa.setLayout(jPanelOsoaLayout);
        jPanelOsoaLayout.setHorizontalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1093, Short.MAX_VALUE)
            .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelOina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOsoaLayout.createSequentialGroup()
                            .addComponent(jPanelHornDatuak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                            .addComponent(jPanelHornInfoTaula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)))
                    .addContainerGap())
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
        jPanelOsoaLayout.setVerticalGroup(
            jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
            .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOsoaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelGoiburua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelOsoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelHornDatuak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelHornInfoTaula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanelOina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOsoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
            java.util.logging.Logger.getLogger(HornitzaileaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HornitzaileaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HornitzaileaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HornitzaileaInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            public void run() {
                new HornitzaileaInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bilatuLabel2;
    private javax.swing.ButtonGroup buttonGroupEmGiz;
    public javax.swing.JButton jButtonAldatu;
    public javax.swing.JButton jButtonEzabatu;
    public javax.swing.JButton jButtonGehitu;
    public javax.swing.JButton jButtonIrten;
    public javax.swing.JDialog jDialogEzabatuKonfirm;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelHerria;
    private javax.swing.JLabel jLabelHorKud;
    private javax.swing.JLabel jLabelIzena;
    private javax.swing.JLabel jLabelKodHor;
    private javax.swing.JLabel jLabelTlf;
    public javax.swing.JPanel jPanelGoiburua;
    public javax.swing.JPanel jPanelHornDatuak;
    public javax.swing.JPanel jPanelHornInfoTaula;
    public javax.swing.JPanel jPanelHornTextField;
    public javax.swing.JPanel jPanelOina;
    public javax.swing.JPanel jPanelOsoa;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTableHornitzaileaInfo;
    private javax.swing.JTextField jTextFieldBilatu;
    public javax.swing.JTextField jTextFieldEmail;
    public javax.swing.JTextField jTextFieldHerria;
    public javax.swing.JTextField jTextFieldIzena;
    public javax.swing.JTextField jTextFieldKodeHor;
    public javax.swing.JTextField jTextFieldTlf;
    // End of variables declaration//GEN-END:variables
}
