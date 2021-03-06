package forms;

import forms.dialogs.EmailSendDialog;
import forms.dialogs.CurrencyDialog;
import forms.dialogs.DepositeDialog;
import client.Stream;
import data.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import mail.Sender;
import patterns.TableModelFactory;
import tableModels.MyTableModels;
import tableModels.TypeOfModel;

public class MainAdminForm extends javax.swing.JFrame implements TableModelListener {

    private MyTableModels modelCurrency;
    private MyTableModels modelUser;
    private MyTableModels modelDeposite;
    private TableModelFactory factory = new TableModelFactory();
    private Image image;

    public MainAdminForm() {
        try {
            setCurrencyModel("SELECT * FROM Валюта");
            setDepositeModel("SELECT * FROM Депозит");
            setUserModel("SELECT * FROM Пользователь");
            image = ImageIO.read(new File("src\\img\\ico.png"));
        } catch (IOException ex) {
            Logger.getLogger(MainUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            TableModel model = (TableModel) e.getSource();

            boolean banned = (boolean) model.getValueAt(row, column);
            String login = (String) model.getValueAt(row, 0);
            String executeStr = "UPDATE Пользователь SET Заблокирован=" + banned + " WHERE Логин='" + login + "'";
            Stream server = new Stream();
            server.sendInt(11);
            server.sendString(executeStr);
        }
    }

    public void setCurrencyModel(String executeStr) throws IOException {
        ArrayList<Object> currency = new ArrayList<>();
        Stream server = new Stream();
        server.sendInt(9);
        server.sendString(executeStr);
        int count = Integer.parseInt(server.getString());
        for (int i = 0; i < count; i++) {
            String[] data = server.getString().split(":");
            currency.add(new Currency(data[0], data[1], Double.parseDouble(data[2])));
        }
        modelCurrency = factory.createModel(TypeOfModel.CURRENCY_TABLE, currency);
    }

    public void setDepositeModel(String executeStr) throws IOException {
        ArrayList<Object> deposites = new ArrayList<>();
        Stream server = new Stream();
        server.sendInt(7);
        server.sendString(executeStr);
        int count = server.getInt();
        for (int i = 0; i < count; i++) {
            String[] data = server.getString().split(":");
            deposites.add(new Deposite(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), data[4], data[5]));
        }
        modelDeposite = factory.createModel(TypeOfModel.DEPOSITE_TABLE, deposites);
    }

    public void setUserModel(String executeStr) throws IOException {
        ArrayList<Object> users = new ArrayList<>();
        Stream server = new Stream();
        server.sendInt(16);
        server.sendString(executeStr);
        int count = server.getInt();
        for (int i = 0; i < count; i++) {
            String[] data = server.getString().split(":");
            users.add(new User(data[0], data[1], data[2], Boolean.parseBoolean(data[3]), data[4]));
        }
        modelUser = factory.createModel(TypeOfModel.USER_TABLE, users);
        modelUser.addTableModelListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCurrency = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDeposite = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ButtonAddCurrency = new javax.swing.JButton();
        ButtonEditCurrency = new javax.swing.JButton();
        ButtonDeleteCurrency = new javax.swing.JButton();
        ButtonAddDeposite = new javax.swing.JButton();
        ButtonEditDeposite = new javax.swing.JButton();
        ButtonDeleteDeposite = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableUser = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        ButtonConnections = new javax.swing.JButton();
        SendToEmailButton = new javax.swing.JButton();
        ButtonAllUsers = new javax.swing.JButton();
        ButtonBannedUsers = new javax.swing.JButton();
        ButtonNotBannedUsers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Учет депозитов");
        setIconImage(image);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 156, 190));
        jPanel1.setForeground(new java.awt.Color(30, 30, 30));
        jPanel1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        TableCurrency.setBackground(new java.awt.Color(240, 240, 240));
        TableCurrency.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        TableCurrency.setForeground(new java.awt.Color(30, 30, 30));
        TableCurrency.setModel(modelCurrency);
        TableCurrency.setGridColor(new java.awt.Color(207, 207, 207));
        TableCurrency.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableCurrency.setRowHeight(30);
        TableCurrency.setSelectionBackground(new java.awt.Color(0, 156, 190));
        TableCurrency.setSelectionForeground(new java.awt.Color(254, 254, 254));
        TableCurrency.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableCurrency.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableCurrency.setShowVerticalLines(false);
        TableCurrency.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCurrencyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCurrency);

        TableDeposite.setBackground(new java.awt.Color(240, 240, 240));
        TableDeposite.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        TableDeposite.setForeground(new java.awt.Color(30, 30, 30));
        TableDeposite.setModel(modelDeposite);
        TableDeposite.setGridColor(new java.awt.Color(207, 207, 207));
        TableDeposite.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableDeposite.setRowHeight(30);
        TableDeposite.setSelectionBackground(new java.awt.Color(0, 156, 190));
        TableDeposite.setSelectionForeground(new java.awt.Color(254, 254, 254));
        TableDeposite.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableDeposite.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableDeposite.setShowVerticalLines(false);
        TableDeposite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDepositeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableDeposite);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Курсы валют");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Депозиты");

        ButtonAddCurrency.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAdd.png"))); // NOI18N
        ButtonAddCurrency.setActionCommand("Добавить");
        ButtonAddCurrency.setBorder(null);
        ButtonAddCurrency.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonAddCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddCurrencyActionPerformed(evt);
            }
        });

        ButtonEditCurrency.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonEdit.png"))); // NOI18N
        ButtonEditCurrency.setActionCommand("Редактировать");
        ButtonEditCurrency.setBorder(null);
        ButtonEditCurrency.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonEditCurrency.setEnabled(false);
        ButtonEditCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditCurrencyActionPerformed(evt);
            }
        });

        ButtonDeleteCurrency.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDelete.png"))); // NOI18N
        ButtonDeleteCurrency.setActionCommand("Удалить");
        ButtonDeleteCurrency.setBorder(null);
        ButtonDeleteCurrency.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonDeleteCurrency.setEnabled(false);
        ButtonDeleteCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteCurrencyActionPerformed(evt);
            }
        });

        ButtonAddDeposite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonAdd.png"))); // NOI18N
        ButtonAddDeposite.setActionCommand("Добавить");
        ButtonAddDeposite.setBorder(null);
        ButtonAddDeposite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonAddDeposite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddDepositeActionPerformed(evt);
            }
        });

        ButtonEditDeposite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonEdit.png"))); // NOI18N
        ButtonEditDeposite.setActionCommand("Редактировать");
        ButtonEditDeposite.setBorder(null);
        ButtonEditDeposite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonEditDeposite.setEnabled(false);
        ButtonEditDeposite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditDepositeActionPerformed(evt);
            }
        });

        ButtonDeleteDeposite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonDelete.png"))); // NOI18N
        ButtonDeleteDeposite.setActionCommand("Удалить");
        ButtonDeleteDeposite.setBorder(null);
        ButtonDeleteDeposite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonDeleteDeposite.setEnabled(false);
        ButtonDeleteDeposite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteDepositeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonAddCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonEditCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonDeleteCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonAddDeposite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonEditDeposite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonDeleteDeposite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonDeleteCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(ButtonAddCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonEditCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ButtonDeleteDeposite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonEditDeposite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAddDeposite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ExitButton.setBackground(new java.awt.Color(0, 156, 190));
        ExitButton.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(255, 255, 255));
        ExitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(15, 212, 255), new java.awt.Color(0, 175, 214), new java.awt.Color(0, 58, 71), new java.awt.Color(0, 112, 137)));
        ExitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitButton.setLabel("Завершить работу");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        TableUser.setBackground(new java.awt.Color(240, 240, 240));
        TableUser.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        TableUser.setForeground(new java.awt.Color(30, 30, 30));
        TableUser.setModel(modelUser);
        TableUser.setGridColor(new java.awt.Color(207, 207, 207));
        TableUser.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableUser.setRowHeight(30);
        TableUser.setSelectionBackground(new java.awt.Color(0, 156, 190));
        TableUser.setSelectionForeground(new java.awt.Color(254, 254, 254));
        TableUser.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableUser.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableUser.setShowVerticalLines(false);
        jScrollPane3.setViewportView(TableUser);

        jLabel3.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Учетные записи");

        ButtonConnections.setBackground(new java.awt.Color(230, 230, 230));
        ButtonConnections.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        ButtonConnections.setForeground(new java.awt.Color(30, 30, 30));
        ButtonConnections.setText("Подключения");
        ButtonConnections.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(230, 230, 230), new java.awt.Color(86, 86, 86), new java.awt.Color(147, 147, 147)));
        ButtonConnections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConnectionsActionPerformed(evt);
            }
        });

        SendToEmailButton.setBackground(new java.awt.Color(230, 230, 230));
        SendToEmailButton.setFont(new java.awt.Font("Arial", 2, 16)); // NOI18N
        SendToEmailButton.setForeground(new java.awt.Color(30, 30, 30));
        SendToEmailButton.setText("Рассылка");
        SendToEmailButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(230, 230, 230), new java.awt.Color(86, 86, 86), new java.awt.Color(147, 147, 147)));
        SendToEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendToEmailButtonActionPerformed(evt);
            }
        });

        ButtonAllUsers.setBackground(new java.awt.Color(230, 230, 230));
        ButtonAllUsers.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        ButtonAllUsers.setForeground(new java.awt.Color(30, 30, 30));
        ButtonAllUsers.setText("Все");
        ButtonAllUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAllUsersActionPerformed(evt);
            }
        });

        ButtonBannedUsers.setBackground(new java.awt.Color(230, 230, 230));
        ButtonBannedUsers.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        ButtonBannedUsers.setForeground(new java.awt.Color(30, 30, 30));
        ButtonBannedUsers.setText("Блокированные");
        ButtonBannedUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBannedUsersActionPerformed(evt);
            }
        });

        ButtonNotBannedUsers.setBackground(new java.awt.Color(230, 230, 230));
        ButtonNotBannedUsers.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        ButtonNotBannedUsers.setForeground(new java.awt.Color(30, 30, 30));
        ButtonNotBannedUsers.setText("Неблокированные");
        ButtonNotBannedUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNotBannedUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonConnections, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SendToEmailButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonAllUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonBannedUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonNotBannedUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(ButtonConnections, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAllUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBannedUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonNotBannedUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendToEmailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableCurrencyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCurrencyMouseClicked
        if (TableCurrency.getSelectedRowCount() > 0) {
            ButtonEditCurrency.setEnabled(true);
            ButtonDeleteCurrency.setEnabled(true);
        } else {
            ButtonEditCurrency.setEnabled(false);
            ButtonDeleteCurrency.setEnabled(false);
        }
    }//GEN-LAST:event_TableCurrencyMouseClicked

    private void TableDepositeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDepositeMouseClicked
        if (TableDeposite.getSelectedRowCount() > 0) {
            ButtonEditDeposite.setEnabled(true);
            ButtonDeleteDeposite.setEnabled(true);
        } else {
            ButtonEditDeposite.setEnabled(false);
            ButtonDeleteDeposite.setEnabled(false);
        }
    }//GEN-LAST:event_TableDepositeMouseClicked

    private void ButtonEditCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditCurrencyActionPerformed
        CurrencyDialog edit = new CurrencyDialog(this, true);
        edit.setCode((String) TableCurrency.getValueAt(TableCurrency.getSelectedRow(), 0));
        edit.setTitle((String) TableCurrency.getValueAt(TableCurrency.getSelectedRow(), 1));
        edit.setCourse(Double.toString((double) TableCurrency.getValueAt(TableCurrency.getSelectedRow(), 2)));
        edit.setLocationRelativeTo(null);
        edit.setVisible(true);

        Stream server = new Stream();
        String updateStr = "UPDATE Валюта SET Мнемокод='" + edit.getCode() + "', Наименование='" + edit.getTitle()
                + "', Курс=" + edit.getCourse() + " WHERE Мнемокод='" + (String) TableCurrency.getValueAt(TableCurrency.getSelectedRow(), 0) + "'";
        server.sendInt(11);
        server.sendString(updateStr);

        try {
            setCurrencyModel("SELECT * FROM Валюта");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainAdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEditCurrencyActionPerformed

    private void ButtonEditDepositeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditDepositeActionPerformed
        DepositeDialog edit = new DepositeDialog(this, true);
        edit.setCode((int) TableDeposite.getValueAt(TableDeposite.getSelectedRow(), 0));
        edit.setTitle((String) TableDeposite.getValueAt(TableDeposite.getSelectedRow(), 1));
        edit.setPercent(Double.toString((double) TableDeposite.getValueAt(TableDeposite.getSelectedRow(), 2)));
        edit.setMinSum(Double.toString((double) TableDeposite.getValueAt(TableDeposite.getSelectedRow(), 3)));
        edit.setPartial((String) TableDeposite.getValueAt(TableDeposite.getSelectedRow(), 4));
        edit.setCurrency((String) TableDeposite.getValueAt(TableDeposite.getSelectedRow(), 5));
        edit.setLocationRelativeTo(null);
        edit.setVisible(true);

        Stream server = new Stream();
        String updateStr = "UPDATE Депозит SET Наименование='" + edit.getTitle() + "', ПроцентнаяСтавка=" + edit.getPercent() + ", МинимальнаяСумма=" + edit.getMinSum()
                + ", ЧастичноеСнятие='" + edit.getPartial() + "', ВалютаВклада='" + edit.getCurrency() + "' WHERE Код=" + (int) TableDeposite.getValueAt(TableDeposite.getSelectedRow(), 0);
        server.sendInt(11);
        server.sendString(updateStr);

        try {
            setDepositeModel("SELECT * FROM Депозит");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainAdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEditDepositeActionPerformed

    private void ButtonDeleteCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteCurrencyActionPerformed
        String code = (String) TableCurrency.getValueAt(TableCurrency.getSelectedRow(), 0);
        Stream server = new Stream();
        String executeStr = "DELETE FROM Валюта WHERE `Мнемокод`='" + code + "';";
        server.sendInt(10);
        server.sendString(executeStr);

        JOptionPane.showMessageDialog(null, "Данные удалены.",
                "Удаление", JOptionPane.INFORMATION_MESSAGE);
        try {
            setCurrencyModel("SELECT * FROM Валюта");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainAdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonDeleteCurrencyActionPerformed

    private void ButtonDeleteDepositeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteDepositeActionPerformed
        int code = (int) TableDeposite.getValueAt(TableDeposite.getSelectedRow(), 0);
        Stream server = new Stream();
        String executeStr = "DELETE FROM Депозит WHERE `Код`=" + code;
        server.sendInt(10);
        server.sendString(executeStr);

        JOptionPane.showMessageDialog(null, "Данные удалены.",
                "Удаление", JOptionPane.INFORMATION_MESSAGE);
        try {
            setDepositeModel("SELECT * FROM Депозит");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainAdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonDeleteDepositeActionPerformed

    private void ButtonAddCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddCurrencyActionPerformed
        CurrencyDialog edit = new CurrencyDialog(this, true);
        edit.setLocationRelativeTo(null);
        edit.setDialogTitle("Добавить новые данные");
        edit.setVisible(true);

        Stream server = new Stream();
        String executeStr = "INSERT INTO Валюта VALUES('" + edit.getCode() + "', '" + edit.getTitle() + "', " + edit.getCourse() + ");";
        server.sendInt(12);
        server.sendString(executeStr);

        JOptionPane.showMessageDialog(null, "Данные добавлены.",
                "Добавление", JOptionPane.INFORMATION_MESSAGE);
        try {
            setCurrencyModel("SELECT * FROM Валюта");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainAdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonAddCurrencyActionPerformed

    private void ButtonAddDepositeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddDepositeActionPerformed
        DepositeDialog edit = new DepositeDialog(this, true);
        edit.setLocationRelativeTo(null);
        edit.setDialogTitle("Добавить новые данные");
        edit.setVisible(true);

        Stream server = new Stream();
        String executeStr = "INSERT INTO Депозит(`Наименование`, `ВалютаВклада`, `ПроцентнаяСтавка`, `МинимальнаяСумма`, `ЧастичноеСнятие`) VALUES('"
                + edit.getTitle() + "', '" + edit.getCurrency() + "', " + edit.getPercent() + ", " + edit.getMinSum() + ", '" + edit.getPartial() + "');";
        server.sendInt(12);
        server.sendString(executeStr);

        JOptionPane.showMessageDialog(null, "Данные добавлены.",
                "Добавление", JOptionPane.INFORMATION_MESSAGE);
        try {
            setDepositeModel("SELECT * FROM Депозит");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainAdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonAddDepositeActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        this.setVisible(false);
        SignInForm SigningIn = new SignInForm();
        SigningIn.setVisible(true);
        SigningIn.setLocationRelativeTo(null);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Stream server = new Stream();
        server.sendString("END");
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void ButtonConnectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConnectionsActionPerformed
        StatisticsForm Statistics = new StatisticsForm();
        Statistics.setVisible(true);
        Statistics.setLocationRelativeTo(null);
    }//GEN-LAST:event_ButtonConnectionsActionPerformed

    private void SendToEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendToEmailButtonActionPerformed
        EmailSendDialog dlg = new EmailSendDialog(this, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);

        Sender tlsSender = new Sender("snopok.lika081@gmail.com", "Vjhb_Jufq17.02");
        tlsSender.send(dlg.getSubject(), dlg.getText(), "snopok.lika081@gmail.com", dlg.getRecipients());
    }//GEN-LAST:event_SendToEmailButtonActionPerformed

    private void ButtonAllUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAllUsersActionPerformed
        try {
            setUserModel("SELECT * FROM Пользователь");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonAllUsersActionPerformed

    private void ButtonBannedUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBannedUsersActionPerformed
        try {
            setUserModel("SELECT * FROM Пользователь WHERE Заблокирован=true");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonBannedUsersActionPerformed

    private void ButtonNotBannedUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNotBannedUsersActionPerformed
        try {
            setUserModel("SELECT * FROM Пользователь WHERE Заблокирован=false");
            ChangeTable();
        } catch (IOException ex) {
            Logger.getLogger(MainUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonNotBannedUsersActionPerformed

    public void ChangeTable() {
        getContentPane().removeAll();
        initComponents();
        this.setLocationRelativeTo(null);
    }

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
            java.util.logging.Logger.getLogger(MainAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAddCurrency;
    private javax.swing.JButton ButtonAddDeposite;
    private javax.swing.JButton ButtonAllUsers;
    private javax.swing.JButton ButtonBannedUsers;
    private javax.swing.JButton ButtonConnections;
    private javax.swing.JButton ButtonDeleteCurrency;
    private javax.swing.JButton ButtonDeleteDeposite;
    private javax.swing.JButton ButtonEditCurrency;
    private javax.swing.JButton ButtonEditDeposite;
    private javax.swing.JButton ButtonNotBannedUsers;
    private javax.swing.JButton ExitButton;
    private javax.swing.ButtonGroup RadioGroup;
    private javax.swing.JButton SendToEmailButton;
    private javax.swing.JTable TableCurrency;
    private javax.swing.JTable TableDeposite;
    private javax.swing.JTable TableUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
