/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatCliente.gui;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import org.proyectoChatCliente.model.LMForo;
import org.proyectoChatCliente.net.Conector;
import org.proyectoChatCliente.net.HiloReceptor;
import static org.proyectoChatComun.net.Tester.isConnectedToNasa;
import org.proyectoChatComun.base.Code;
import org.proyectoChatComun.base.Mensaje;
import org.proyectoChatComun.base.PaqueteInicial;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class Chat extends javax.swing.JFrame {

    public static final short PUERTO_DEFAULT = 1234;
    private PaqueteInicial paqueteUser;
    private Thread hReceptor;
    private HiloReceptor hiloRec;
    private Conector cliente;
    private CuadroMsg cuadroStart;
    
    public Chat() {
        initComponents();
        if (isConnectedToNasa())  
            System.out.println("Conectado a la nasa! :)");
        
        else 
            System.out.println("No nos hemos podido conectar a la nasa :/ es una pena");
        
        setResizable(false);
        setLocationRelativeTo(null);
        winChat.setSize(542, 357);
        winChat.setLocationRelativeTo(null);
        txtForo.setEditable(false);
        winRegistrar.setResizable(false);
        winRegistrar.setSize(winRegistrar.getPreferredSize());
        winRegistrar.setLocationRelativeTo(null);
        cuadroStart = new CuadroMsg(this, true);
    }
    
    private void send(Object obj) throws IOException{
        cliente.sendObject(obj);
    }
    
    /**
     * 
     * @param obj Objeto a validar
     * @return true si el objeto entregado no es nulo, false en caso contrario
     */
    
    private boolean hasObject(Object obj){
        
        return obj != null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        winChat = new javax.swing.JFrame();
        tabbedChat = new javax.swing.JTabbedPane();
        panelForo1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaConectados = new javax.swing.JList<Usuario>();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMsgForo = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtForo = new javax.swing.JTextPane();
        winRegistrar = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNewNick = new javax.swing.JTextField();
        txtNewNombre = new javax.swing.JTextField();
        txtNewPass1 = new javax.swing.JPasswordField();
        txtNewPass2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lblIconReg = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtNick = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblIconoIniciarSesion = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        winChat.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        winChat.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                winChatComponentResized(evt);
            }
        });
        winChat.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                winChatformWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                winChatWindowClosing(evt);
            }
        });

        tabbedChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabbedChatMouseReleased(evt);
            }
        });

        panelForo1.setBackground(java.awt.Color.white);
        panelForo1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.red, null));

        listaConectados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaConectados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listaConectadosMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(listaConectados);

        txtMsgForo.setColumns(20);
        txtMsgForo.setRows(3);
        txtMsgForo.setTabSize(4);
        txtMsgForo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMsgForoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMsgForoKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(txtMsgForo);

        txtForo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtForoKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(txtForo);

        javax.swing.GroupLayout panelForo1Layout = new javax.swing.GroupLayout(panelForo1);
        panelForo1.setLayout(panelForo1Layout);
        panelForo1Layout.setHorizontalGroup(
            panelForo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForo1Layout.createSequentialGroup()
                .addGroup(panelForo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelForo1Layout.setVerticalGroup(
            panelForo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(panelForo1Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelForo1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedChat.addTab("Foro", panelForo1);

        winChat.getContentPane().add(tabbedChat, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Usuario"));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nick:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Contraseña:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Repita Contraseña:");

        txtNewPass1.setText("jPasswordField1");

        txtNewPass2.setText("jPasswordField2");

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Registrarse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblIconReg.setText("icono");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lblIconReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNewPass1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(txtNewNombre)
                    .addComponent(txtNewNick)
                    .addComponent(txtNewPass2))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNewNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNewNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNewPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNewPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblIconReg, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        winRegistrar.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(null);
        jPanel3.setOpaque(false);

        txtNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNickKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Nick:");

        txtPassword.setText("jPasswordField1");
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        lblIconoIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconoIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/proyectoChatCliente/resources/msn-icon.png"))); // NOI18N
        lblIconoIniciarSesion.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 255, 153), null));

        btnRegistrarse.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        btnIniciarSesion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNick)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblIconoIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconoIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion)
                    .addComponent(btnRegistrarse))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        
    }//GEN-LAST:event_formWindowOpened

    private void winChatformWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_winChatformWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_winChatformWindowOpened

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed

        String user = txtNick.getText();
        String password = txtPassword.getText();
        
        if (!user.equalsIgnoreCase("") && !password.equalsIgnoreCase("")) {

            try {
                String login = user + "," + password;
                
                if(cliente != null) cliente.close();
                
                cliente = new Conector(1234);
                cliente.sendObject(login);
                
                boolean permitido = false;
                Object objRecibido = null;
                
                while (!hasObject(objRecibido)) objRecibido = cliente.getReceivedObject();
                
                String msgFrame;
                String title;
                int typeMessage;
                
                permitido = (boolean) objRecibido;

                if (permitido) {

                    objRecibido = null;

                    while (!hasObject(objRecibido)) objRecibido = cliente.getReceivedObject();

                    if (objRecibido instanceof Code) {
                        typeMessage = JOptionPane.WARNING_MESSAGE;
                        title = "Error de inicio de sesion";
                        msgFrame = "El usuario que acaba de ingresar\nya se encuentra conectado";
                    } 
                    
                    else {
                        paqueteUser = (PaqueteInicial) objRecibido;
                        msgFrame = "Bienvenido";
                        typeMessage = JOptionPane.INFORMATION_MESSAGE;
                        title = "Sesion iniciada";

                        setVisible(false);
                        winChat.setVisible(true);
                        updateListUsers(paqueteUser.getUsuarios());
                        System.out.println(paqueteUser.getUser());
                        hiloRec = new HiloReceptor
                            (paqueteUser, cliente, txtForo, tabbedChat, listaConectados);
                        hReceptor = new Thread(() -> hiloRec.run());
                        hReceptor.start();
                        
                        /*
                        Instanciar objetos con estilo
                        Thread t;
                        (t) -> Thread::new;*/
                    }

                } else {
                    cuadroStart.hide();
                    msgFrame = "Usuario y/o contraseña invalidos";
                    typeMessage = JOptionPane.WARNING_MESSAGE;
                    title = "Error de inicio de sesion";
                    txtNick.requestFocus();
                    txtNick.selectAll();
                }

                JOptionPane.showMessageDialog(this, msgFrame, title, typeMessage);
            } catch (IOException | ClassNotFoundException ex) {
                
                JOptionPane.showMessageDialog(
                        this, 
                        "No hay conexion con el servidor", 
                        "Error", 
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        
        else{
            JOptionPane.showMessageDialog(this, 
                    "Uno o mas campos de texto vacios", 
                    "Advertencia", 
                    JOptionPane.INFORMATION_MESSAGE);
            txtNick.requestFocus();
            txtNick.selectAll();
        }
        
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtNickKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNickKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword.requestFocus();
            txtPassword.selectAll();
        }
    }//GEN-LAST:event_txtNickKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
            btnIniciarSesion.doClick();
        
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void winChatComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_winChatComponentResized

        System.out.println(winChat.getWidth() + " - " + winChat.getHeight());
    }//GEN-LAST:event_winChatComponentResized

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed

        winRegistrar.setVisible(true);
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String nick = txtNewNick.getText();
        String nombre = txtNewNombre.getText();
        String pass1 = txtNewPass1.getText();
        String pass2 = txtNewPass2.getText();

        if (nick.equalsIgnoreCase("") || nombre.equalsIgnoreCase("") ||
            pass1.equalsIgnoreCase("") || pass2.equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(winRegistrar,
                "Hay uno o mas campos de textos vacios",
                "Advertencia",
                JOptionPane.ERROR_MESSAGE);
        }

        else if (!pass1.equalsIgnoreCase(pass2)) {
            JOptionPane.showMessageDialog(winRegistrar,
                "Las contraseñas no coinciden",
                "Advertencia",
                JOptionPane.ERROR_MESSAGE);
        }
        else{
            Usuario nuevo = new Usuario(nombre, nick, pass1, 2);
            try {
                
                cliente = new Conector(1234);
                cliente.sendObject(nuevo);
                Object objRecibido = cliente.getReceivedObject();
                boolean isRegistrado = false;

                while (objRecibido == null) {
                    objRecibido = cliente.getReceivedObject();
                }

                isRegistrado = (boolean) objRecibido;

                if (isRegistrado) {

                    JOptionPane.showMessageDialog(winRegistrar,
                        "Usuario registrado exitosamente",
                        "Mensaje",
                        JOptionPane.ERROR_MESSAGE);
                    winChat.setVisible(false);
                    limpiarWinReg();
                }

                else {
                    JOptionPane.showMessageDialog(winRegistrar,
                        "Usuario ya existente",
                        "Advertencia",
                        JOptionPane.ERROR_MESSAGE);
                    txtNewNick.requestFocus();
                    txtNewNick.selectAll();
                }
                cliente.close();
                
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabbedChatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedChatMouseReleased
//
//        // Crear opciones para cerrar panel
//        int opcionSI = JOptionPane.YES_OPTION;
//
//        if (JOptionPane.showConfirmDialog(winChat, "¿Desea borrar el componente?") == opcionSI) {
//            tabbedChat.remove(tabbedChat.getComponentAt(evt.getPoint()));
//            tabbedChat.updateUI();
//        }
    }//GEN-LAST:event_tabbedChatMouseReleased

    private void txtForoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtForoKeyPressed

    }//GEN-LAST:event_txtForoKeyPressed

    private void txtMsgForoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsgForoKeyReleased

    }//GEN-LAST:event_txtMsgForoKeyReleased

    private void txtMsgForoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsgForoKeyPressed

        if (evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMsgForo.setText(txtMsgForo.getText() + "\n");
        }

        else if (!evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {

                if (!txtMsgForo.getText().trim().isEmpty()) {
                    Mensaje msg = new Mensaje(txtMsgForo.getText().trim(),
                        paqueteUser.getUser().getId(), 2);  

                    System.out.println(msg.getTexto());
                    send(msg);
                    txtForo.setText(txtForo.getText() + "[" + msg.getHora() + "] " +
                        paqueteUser.getUser().getNick() + ": " + msg.getTexto() + "\n");

                    txtMsgForo.setText(null);
                }

            } catch (IOException ex) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_txtMsgForoKeyPressed

    private void listaConectadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaConectadosMouseReleased

        if (evt.getClickCount() == 2) {
            Usuario user = listaConectados.getSelectedValue();
            hiloRec.addWin(new PanelChat(user.getId(), paqueteUser, cliente), user);
        }
    }//GEN-LAST:event_listaConectadosMouseReleased

    private void winChatWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_winChatWindowClosing

        try {
            cliente.sendObject(Code.DISCONNECT);
        } catch (IOException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_winChatWindowClosing

//    private void updateListUsers(HashMap<Integer, Usuario> usuarios){
//        listaConectados.setModel(new LMForo(usuarios));
//    }
    
    private void updateListUsers(LinkedList<Usuario> usuarios){
        listaConectados.setModel(new LMForo(usuarios));
    }

    private void deleteUserFromList(LinkedList listaRecibida) {

        Usuario u;
        for (int i = 0; i < listaRecibida.size(); i++) {
            u = (Usuario) listaRecibida.get(i);
            if (u.getId() == paqueteUser.getUser().getId()) listaRecibida.remove(i);
        }
    }
    
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new Chat().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblIconReg;
    private javax.swing.JLabel lblIconoIniciarSesion;
    private javax.swing.JList<Usuario> listaConectados;
    private javax.swing.JPanel panelForo1;
    private javax.swing.JTabbedPane tabbedChat;
    private javax.swing.JTextPane txtForo;
    private javax.swing.JTextArea txtMsgForo;
    private javax.swing.JTextField txtNewNick;
    private javax.swing.JTextField txtNewNombre;
    private javax.swing.JPasswordField txtNewPass1;
    private javax.swing.JPasswordField txtNewPass2;
    private javax.swing.JTextField txtNick;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JFrame winChat;
    private javax.swing.JFrame winRegistrar;
    // End of variables declaration//GEN-END:variables

    private void limpiarWinReg() {

        txtNewNick.setText(null);
        txtNewNombre.setText(null);
        txtNewPass1.setText(null);
        txtNewPass2.setText(null);
        txtNewNick.requestFocus();
    }

}
