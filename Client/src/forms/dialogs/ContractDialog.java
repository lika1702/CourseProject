package forms.dialogs;

import client.Stream;
import filters.CodeContractFilter;
import filters.DigitFilter;
import filters.FloatNumberFilter;
import forms.MainUserForm;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.PlainDocument;

public class ContractDialog extends javax.swing.JDialog {

    ComboBoxModel passportModel;
    ComboBoxModel depositeModel;

    public ContractDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            setDepositeModel("SELECT Код, Наименование FROM Депозит");
            setPassportModel("SELECT НомерПаспорта, Фамилия, Имя, Отчество FROM Клиент");
        } catch (IOException ex) {
            Logger.getLogger(MainUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
         PlainDocument doc = (PlainDocument) YearField.getDocument();
        doc.setDocumentFilter(new DigitFilter());
         doc = (PlainDocument) DepositeTermField.getDocument();
        doc.setDocumentFilter(new FloatNumberFilter());
        doc = (PlainDocument) DepositeStartSumField.getDocument();
        doc.setDocumentFilter(new FloatNumberFilter());
        doc = (PlainDocument) ContractCodeField.getDocument();
        doc.setDocumentFilter(new CodeContractFilter());
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
        DialogTitle = new javax.swing.JLabel();
        EditOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ContractCodeField = new javax.swing.JTextField();
        PassportCombo = new javax.swing.JComboBox<>();
        DepositeCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TermYearsRadio = new javax.swing.JRadioButton();
        TermMonthRadio = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        YearField = new javax.swing.JTextField();
        DepositeStartSumField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DepositeTermField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Договор");

        DialogTitle.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        DialogTitle.setForeground(new java.awt.Color(0, 156, 190));
        DialogTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DialogTitle.setText("Редактировать");

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

        jLabel1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("Паспорт клиента");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Номер договора");

        ContractCodeField.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        ContractCodeField.setForeground(new java.awt.Color(30, 30, 30));
        ContractCodeField.setDisabledTextColor(new java.awt.Color(50, 50, 50));
        ContractCodeField.setEnabled(false);
        ContractCodeField.setSelectionColor(new java.awt.Color(0, 156, 190));

        PassportCombo.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        PassportCombo.setForeground(new java.awt.Color(30, 30, 30));
        PassportCombo.setModel(passportModel);
        PassportCombo.setEnabled(false);

        DepositeCombo.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        DepositeCombo.setForeground(new java.awt.Color(30, 30, 30));
        DepositeCombo.setModel(depositeModel);

        jLabel3.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Депозит");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Срок действия");

        buttonGroup1.add(TermYearsRadio);
        TermYearsRadio.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        TermYearsRadio.setForeground(new java.awt.Color(30, 30, 30));
        TermYearsRadio.setSelected(true);
        TermYearsRadio.setText("лет");

        buttonGroup1.add(TermMonthRadio);
        TermMonthRadio.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        TermMonthRadio.setForeground(new java.awt.Color(30, 30, 30));
        TermMonthRadio.setText("месяцев");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Год заключения");

        YearField.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        YearField.setForeground(new java.awt.Color(30, 30, 30));
        YearField.setDisabledTextColor(new java.awt.Color(50, 50, 50));
        YearField.setEnabled(false);
        YearField.setSelectionColor(new java.awt.Color(0, 156, 190));

        DepositeStartSumField.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        DepositeStartSumField.setForeground(new java.awt.Color(30, 30, 30));
        DepositeStartSumField.setDisabledTextColor(new java.awt.Color(50, 50, 50));
        DepositeStartSumField.setEnabled(false);
        DepositeStartSumField.setSelectionColor(new java.awt.Color(0, 156, 190));

        jLabel6.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Стартовая сумма");

        DepositeTermField.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        DepositeTermField.setForeground(new java.awt.Color(30, 30, 30));
        DepositeTermField.setDisabledTextColor(new java.awt.Color(50, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DialogTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(EditOK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(YearField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TermYearsRadio)
                                .addGap(18, 18, 18)
                                .addComponent(TermMonthRadio)
                                .addGap(0, 196, Short.MAX_VALUE))
                            .addComponent(PassportCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ContractCodeField)
                            .addComponent(DepositeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DepositeStartSumField)
                            .addComponent(DepositeTermField))
                        .addGap(42, 42, 42)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(DialogTitle)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ContractCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PassportCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepositeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepositeStartSumField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DepositeTermField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TermMonthRadio)
                    .addComponent(TermYearsRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YearField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addComponent(EditOK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setDepositeModel(String executeStr) throws IOException {
        Vector deposites = new Vector();
        Stream server = new Stream();
        server.sendInt(3);
        server.sendString(executeStr);
        int count = server.getInt();
        for (int i = 0; i < count; i++) {
            String[] data = server.getString().split(":");
            deposites.add(data[0] + ":" + data[1] + " " + data[2]);
        }
        depositeModel = new DefaultComboBoxModel(deposites);
    }
    
    public void setPassportModel(String executeStr) throws IOException {
        Vector passports = new Vector();
        Stream server = new Stream();
        server.sendInt(4);
        server.sendString(executeStr);
        int count = server.getInt();
        for (int i = 0; i < count; i++) {
            String[] data = server.getString().split(":");
            passports.add(data[0] + ":" + data[1] + " " +data[2] + " "+ data[3]);
        }
        passportModel = new DefaultComboBoxModel(passports);
    }

    public void setDialogTitle(String title) {
        DialogTitle.setText(title);
    }

    public void setPassport(String passport) {
        for (int i = 0; i < PassportCombo.getItemCount(); i++) {
            String[] mas =PassportCombo.getModel().getElementAt(i).split(":");
            if (mas[0].equals(passport)) {
                PassportCombo.setSelectedIndex(i);
            }
        }
    }

    public void setContractCode(String code) {
        ContractCodeField.setText(code);
    }
    
    public void setYear(int year) {
        YearField.setText(Integer.toString(year));
    }

    public void setDeposite(String deposite) {
        for (int i = 0; i < DepositeCombo.getItemCount(); i++) {
            String[] mas = DepositeCombo.getModel().getElementAt(i).split(":");
            if (mas[1].equals(deposite)) {
                DepositeCombo.setSelectedIndex(i);
            }
        }
    }

    public void setTermD(String term) {
        DepositeTermField.setText(term);
      
    }
    
    public void setStartSumD(String sum) {
        DepositeStartSumField.setText(sum);
    }

    public void setTermMeasurement(String measurement) {
        if (measurement.equals("г.")) {
            TermYearsRadio.setSelected(true);
        }
        if (measurement.equals("мес.")) {
            TermMonthRadio.setSelected(true);
        }
    }

    public String getPassport() {
        String[] mas  = ((String) PassportCombo.getSelectedItem()).split(":");
        return mas[0];
    }

    public String getContractCode() {
        return ContractCodeField.getText();
    }

    public String getDeposite() {
        String[] mas  = ((String)DepositeCombo.getSelectedItem()).split(":");
        return mas[0];
    }

    public String getTerm() {
        return DepositeTermField.getText();
    }
    
    public String getStartSum() {
        return DepositeStartSumField.getText();
    }
    
    public String getYear() {
        return YearField.getText();
    }

    public String getTermMeasurement() {
        while (true) {
            if (TermYearsRadio.isSelected()) {
                return "г.";
            }
            if (TermMonthRadio.isSelected()) {
                return "мес.";
            } else {
                JOptionPane.showMessageDialog(null, "Не выбрано значение",
                        "Предупреждение", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void SetEnabled() {
        PassportCombo.setEnabled(true);
        ContractCodeField.setEnabled(true);
        DepositeStartSumField.setEnabled(true);
    }

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
            java.util.logging.Logger.getLogger(ContractDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContractDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContractDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContractDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContractDialog dialog = new ContractDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField ContractCodeField;
    private javax.swing.JComboBox<String> DepositeCombo;
    private javax.swing.JTextField DepositeStartSumField;
    private javax.swing.JTextField DepositeTermField;
    private javax.swing.JLabel DialogTitle;
    private javax.swing.JButton EditOK;
    private javax.swing.JComboBox<String> PassportCombo;
    private javax.swing.JRadioButton TermMonthRadio;
    private javax.swing.JRadioButton TermYearsRadio;
    private javax.swing.JTextField YearField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
