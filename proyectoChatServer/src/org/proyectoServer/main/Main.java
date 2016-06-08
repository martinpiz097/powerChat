///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.proyectoServer.main;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.UnsupportedLookAndFeelException;
//import org.proyectoServer.gui.Servidor;
//
///**
// *
// * @author martin
// */
//public class Main {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//
//        if (args.length == 3) {
//            
//            if (args[0].equals("-start") &&
//                    args[1].equals("martin") && 
//                    args[2].equals("admin")) {
//                
//                try {
//                    javax.swing.UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
//                } catch (UnsupportedLookAndFeelException ex) {
//                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                /* Create and display the form */
//                java.awt.EventQueue.invokeLater(() -> {
//                    Servidor s = new Servidor();
//                    s.setVisible(false);
//                    s.getBtnStartServer().doClick();
//                });
//
//            }
//            
//            else if (args[0].equals("-start") && 
//                    args[1].equals("martin") && 
//                    !args[2].equals("admin")) {
//                
//                System.err.println("¡Contraseña incorrecta! No tiene permisos para entrar");
//                System.exit(0);
//            }
//            else if (args[0].equals("-start") && 
//                    !args[1].equals("martin") && 
//                    !args[2].equals("admin")) {
//                System.err.println("¡Usuario incorrecto! No tiene permisos para entrar");
//                System.exit(0);
//            }
//            
//            else{
//                System.err.println("¡Comandos incorrectos!");
//                System.exit(0);
//            }
//        }
//        
//        else{
//            System.err.println("¡Comandos incorrectos!");
//            System.exit(0);
//        }
//    }
//    
//}
