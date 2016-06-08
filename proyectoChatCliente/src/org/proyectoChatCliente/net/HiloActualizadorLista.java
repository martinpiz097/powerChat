///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.proyectoChatCliente.net;
//
//import java.io.IOException;
//import java.util.TreeMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JList;
//import org.proyectoChatCliente.model.LMForo;
//import org.proyectoChatComun.base.Usuario;
//
///**
// *
// * @author martin
// */
//public class HiloActualizadorLista implements Runnable{
//
//    private Conector c;
//    private JList<Usuario> listaUsers;
//
//    public HiloActualizadorLista(Conector c, JList<Usuario> listaUsers) {
//        this.c = c;
//        this.listaUsers = listaUsers;
//    }
//    
//    @Override
//    public void run() {
//
//        TreeMap<Integer, Usuario> usuarios;
//        
//        while (true) {            
//            
//            try {
//                Thread.sleep(1000);
//                
//                if (c.getReceivedObject() != null) {
//                    
//                    if (c.getReceivedObject() instanceof TreeMap) {
//                        
//                        usuarios = (TreeMap<Integer, Usuario>) c.getReceivedObject();
//                        listaUsers.setModel(new LMForo(usuarios));
//                    }
//                }
//                
//            } catch (IOException | ClassNotFoundException | InterruptedException ex) {
//                Logger.getLogger(HiloActualizadorLista.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//    
//}
