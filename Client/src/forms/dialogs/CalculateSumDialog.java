package forms.dialogs;

import filters.DigitFilter;
import javax.swing.text.PlainDocument;

public class CalculateSumDialog extends javax.swing.JDialog {

    public CalculateSumDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         PlainDocument doc = (PlainDocument) PeriodField.getDocument();
        doc.setDocumentFilter(new DigitFilter());
    }

    public void setPeriod(String period) {
        PeriodField.setText(period);
    }

    public double getPeriod() {
        return Double.parseDouble(PeriodField.getText());
    }

    public String getFormula() {
        if (FormulaCIRadio.isSelected()) {
            return FormulaCIRadio.getText();
        }
        if (FormulaSIRadio.isSelected()) {
            return FormulaSIRadio.getText();
        }
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        EditOK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PeriodField = new javax.swing.JTextField();
        FormulaCIRadio = new javax.swing.JRadioButton();
        FormulaSIRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Параметры расчета");

        jLabel1.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 156, 190));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Параметры расчета");

        EditOK.setBackground(new java.awt.Color(0, 156, 190));
        EditOK.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        EditOK.setForeground(new java.awt.Color(255, 255, 255));
        EditOK.setText("ОК");
        EditOK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(15, 212, 255), new java.awt.Color(0, 175, 214), new java.awt.Color(0, 58, 71), new java.awt.Color(0, 112, 137)));
        EditOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditOKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Период начисления процентов (в годах)");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Способ расчета");

        PeriodField.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        PeriodField.setForeground(new java.awt.Color(30, 30, 30));
        PeriodField.setSelectionColor(new java.awt.Color(0, 156, 190));

        buttonGroup1.add(FormulaCIRadio);
        FormulaCIRadio.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        FormulaCIRadio.setForeground(new java.awt.Color(30, 30, 30));
        FormulaCIRadio.setText("Формула сложных процентов");
        FormulaCIRadio.setToolTipText("");

        buttonGroup1.add(FormulaSIRadio);
        FormulaSIRadio.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        FormulaSIRadio.setForeground(new java.awt.Color(30, 30, 30));
        FormulaSIRadio.setSelected(true);
        FormulaSIRadio.setText("Формула простых процентов");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(EditOK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(PeriodField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FormulaCIRadio)
                                    .addComponent(FormulaSIRadio))))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PeriodField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FormulaCIRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FormulaSIRadio)
                .addGap(28, 28, 28)
                .addComponent(EditOK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditOKActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_EditOKActionPerformed

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
            java.util.logging.Logger.getLogger(CalculateSumDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculateSumDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculateSumDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculateSumDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculateSumDialog dialog = new CalculateSumDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditOK;
    private javax.swing.JRadioButton FormulaCIRadio;
    private javax.swing.JRadioButton FormulaSIRadio;
    private javax.swing.JTextField PeriodField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}