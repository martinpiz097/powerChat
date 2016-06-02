/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.gui;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.UnsupportedLookAndFeelException;
import org.proyectoChatComun.base.Mensaje;
import org.proyectoChatComun.base.Usuario;
import org.proyectoServer.db.Database;
import org.proyectoServer.model.TMMensaje;
import org.proyectoServer.model.TMUser;
import org.proyectoServer.model.TipoFiltro;
import org.proyectoServer.net.HiloConector;

/**
 *
 * @author martin
 */
public class Servidor extends javax.swing.JFrame {

    Thread hiloConector;
    
    public Servidor() {

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public JButton getBtnStartServer() {
        return btnStartServer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        winDB = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboEmisor = new javax.swing.JComboBox<>();
        cboReceptor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        opYes = new javax.swing.JRadioButton();
        opNo = new javax.swing.JRadioButton();
        btnBuscarMsg = new javax.swing.JButton();
        btnShowAllMsg = new javax.swing.JButton();
        txtFiltroMsg = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnBuscarUser = new javax.swing.JButton();
        btnShowAllUser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboUsers = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMensajes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        groupFiltroMsg = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnStartServer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        itemRevDB = new javax.swing.JMenuItem();

        winDB.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                winDBWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Busquedas de mensajes"));

        jLabel1.setText("Emisor:");

        jLabel2.setText("Receptor:");

        jLabel3.setText("¿Algun filtro?");

        groupFiltroMsg.add(opYes);
        opYes.setSelected(true);
        opYes.setText("Si");
        opYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opYesActionPerformed(evt);
            }
        });

        groupFiltroMsg.add(opNo);
        opNo.setText("No");
        opNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opNoActionPerformed(evt);
            }
        });

        btnBuscarMsg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscarMsg.setText("Buscar");
        btnBuscarMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMsgActionPerformed(evt);
            }
        });

        btnShowAllMsg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnShowAllMsg.setText("Ver todo");
        btnShowAllMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllMsgActionPerformed(evt);
            }
        });

        txtFiltroMsg.setEnabled(false);
        txtFiltroMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroMsgKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboEmisor, 0, 194, Short.MAX_VALUE)
                            .addComponent(cboReceptor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarMsg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opYes)
                                .addGap(18, 18, 18)
                                .addComponent(opNo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFiltroMsg)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnShowAllMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(opYes)
                    .addComponent(opNo)
                    .addComponent(txtFiltroMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarMsg)
                    .addComponent(btnShowAllMsg)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Busquedas de usuarios"));

        btnBuscarUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscarUser.setText("Buscar");
        btnBuscarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUserActionPerformed(evt);
            }
        });

        btnShowAllUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnShowAllUser.setText("Ver todo");
        btnShowAllUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllUserActionPerformed(evt);
            }
        });

        jLabel4.setText("Usuario:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboUsers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBuscarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnShowAllUser, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowAllUser)
                    .addComponent(btnBuscarUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblMensajes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblMensajes);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseReleased(evt);
            }
        });
        tblUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblUsuariosKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblUsuarios);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout winDBLayout = new javax.swing.GroupLayout(winDB.getContentPane());
        winDB.getContentPane().setLayout(winDBLayout);
        winDBLayout.setHorizontalGroup(
            winDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winDBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(winDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(winDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(winDBLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, winDBLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        winDBLayout.setVerticalGroup(
            winDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winDBLayout.createSequentialGroup()
                .addGroup(winDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(winDBLayout.createSequentialGroup()
                        .addGroup(winDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(winDBLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(winDBLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(winDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Iniciar Servidor"));

        btnStartServer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnStartServer.setText("Iniciar Servidor");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        console.setEditable(false);
        console.setBackground(java.awt.Color.black);
        console.setColumns(20);
        console.setFont(new java.awt.Font("Bitstream Vera Serif", 1, 12)); // NOI18N
        console.setForeground(java.awt.Color.green);
        console.setRows(5);
        console.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(console);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnStartServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        itemRevDB.setText("Review Database");
        itemRevDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRevDBActionPerformed(evt);
            }
        });
        jMenu2.add(itemRevDB);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opYesActionPerformed

        txtFiltroMsg.setEnabled(opYes.isSelected());
    }//GEN-LAST:event_opYesActionPerformed

    private void opNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opNoActionPerformed
        
        txtFiltroMsg.setEnabled(opYes.isSelected());
    }//GEN-LAST:event_opNoActionPerformed

    private void btnBuscarMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMsgActionPerformed

        try {
            Usuario emisor = Database.getUser(cboEmisor.getSelectedItem().toString());
            Usuario receptor = Database.getUser(cboReceptor.getSelectedItem().toString());
            List<Mensaje> mensajes;
            
            if (opYes.isSelected()) {
            
                String filtro = txtFiltroMsg.getText();
                if (filtro.isEmpty())
                    mensajes = Database.getMensajes(emisor.getId(), receptor.getId());
                
                else
                    mensajes = Database.getMensajes(emisor.getId(), receptor.getId(), filtro);
            }
            
            else
                mensajes = Database.getMensajes(emisor.getId(), receptor.getId());
            
            tblMensajes.setModel(new TMMensaje(mensajes));
            
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnBuscarMsgActionPerformed

    private void btnBuscarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUserActionPerformed
        
        try {
            Usuario u = Database.getUser(cboUsers.getSelectedItem().toString());
            tblUsuarios.setModel(new TMUser(u));
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnBuscarUserActionPerformed

    private void btnShowAllMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllMsgActionPerformed

        try {
            tblMensajes.setModel(new TMMensaje(Database.getListMensajes()));
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnShowAllMsgActionPerformed

    private void winDBWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_winDBWindowOpened

        txtFiltroMsg.setEnabled(true);
        updateCombobox();
    }//GEN-LAST:event_winDBWindowOpened

    private void itemRevDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRevDBActionPerformed

        winDB.setSize(winDB.getPreferredSize());
        winDB.setLocationRelativeTo(null);
        winDB.setVisible(true);
    }//GEN-LAST:event_itemRevDBActionPerformed

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed

        try {
            updateConsole("Iniciando Servidor....");
            hiloConector = new Thread(new HiloConector(1234, console)::run);
            hiloConector.start();
            updateConsole("Servidor iniciado!");
            btnStartServer.setEnabled(false);
            updateConsole("Esperando clientes......");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStartServerActionPerformed

    private void btnShowAllUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllUserActionPerformed

        try {
            tblUsuarios.setModel(new TMUser(Database.getListUsers(TipoFiltro.SHOW_ALL)));
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnShowAllUserActionPerformed

    private void txtFiltroMsgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroMsgKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) btnBuscarMsg.doClick();
        
    }//GEN-LAST:event_txtFiltroMsgKeyReleased

    private void tblUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUsuariosKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            
        }
    }//GEN-LAST:event_tblUsuariosKeyReleased

    private void tblUsuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseReleased

        if (evt.getClickCount() == 2) {
            
            if (tblUsuarios.getModel().getColumnCount() > 4) {
                
                int rowSelected = tblUsuarios.getSelectedRow();
                Usuario selected = (Usuario) tblUsuarios.getModel().getValueAt(rowSelected, 2);
            
                // new CuadroOptions(winDB, true, selected);
            }
        }
    }//GEN-LAST:event_tblUsuariosMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            javax.swing.UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Servidor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMsg;
    private javax.swing.JButton btnBuscarUser;
    private javax.swing.JButton btnShowAllMsg;
    private javax.swing.JButton btnShowAllUser;
    private javax.swing.JButton btnStartServer;
    private javax.swing.JComboBox<String> cboEmisor;
    private javax.swing.JComboBox<String> cboReceptor;
    private javax.swing.JComboBox<String> cboUsers;
    private javax.swing.JTextArea console;
    private javax.swing.ButtonGroup groupFiltroMsg;
    private javax.swing.JMenuItem itemRevDB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton opNo;
    private javax.swing.JRadioButton opYes;
    private javax.swing.JTable tblMensajes;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtFiltroMsg;
    private javax.swing.JFrame winDB;
    // End of variables declaration//GEN-END:variables

    private void updateCombobox() {

        try {
            TreeMap<Integer, Usuario> usuarios = Database.getUsers();
            
            usuarios.values().stream().map((user) -> {
                cboEmisor.addItem(user.toString());
                return user;
            }).map((user) -> {
                cboReceptor.addItem(user.toString());
                return user;
            }).forEach((user) -> {
                cboUsers.addItem(user.toString());
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateConsole(String text){
        
        console.setText(console.getText() + text + "\n");
    }
}
