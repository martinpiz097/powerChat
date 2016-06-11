/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatCliente.net;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import org.proyectoChatCliente.gui.PanelChat;
import org.proyectoChatCliente.model.LMForo;
import org.proyectoChatComun.base.Mensaje;
import org.proyectoChatComun.base.PaqueteInicial;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class HiloReceptor implements Runnable{

    private PaqueteInicial paqIni;
    private Conector con;
    private JTextPane foro;
    private JTabbedPane tabbed;
    private Map<Integer, PanelChat> ventanasChat;
    private JList listUsuarios;
  
    /*
    public HiloReceptor(Conector con, JTextPane foro, JList listUsuarios) {
        this.con = con;
        this.foro = foro;
        ventanasChat = new HashMap<>();
        this.listUsuarios = listUsuarios;   
    }
    */
    public HiloReceptor(PaqueteInicial paqIni, Conector con, JTextPane foro, JTabbedPane tabbed, JList listUsuarios) {
        this.paqIni = paqIni;
        this.con = con;
        this.foro = foro;
        this.tabbed = tabbed;
        this.ventanasChat = new HashMap<>();
        this.listUsuarios = listUsuarios;
    }
    
    /*
    public HiloReceptor(Conector con, JTextPane foro, JTabbedPane tabbed) {
        this.con = con;
        this.foro = foro;
        this.tabbed = tabbed;
        ventanasChat = new HashMap<>();
        
    }
    */
    
    /*
    Entrega un boolean si el emisor del mensaje esta en uno de los chats
    activos
    */
    
    public boolean isChatExistente(Mensaje msg){

        // Metodo anyMatch valida si uno de los elementos cumple con una condicion dada
        // return ventanasChat.stream().anyMatch((pc) -> (pc.usuarioReceptor == msg.getEmisor()));
        return ventanasChat.values().stream().anyMatch((pc) -> pc.usuarioReceptor == msg.getEmisor());
    }
    
    public Map<Integer, PanelChat> getVentanasChat() {
        return ventanasChat;
    }
    
    public void displayMessage(Mensaje msg){

        ventanasChat.get(msg.getEmisor()).addMsg(msg);
    }
    
    public void addWin(PanelChat panel, Mensaje msg){
        
        ventanasChat.put(msg.getEmisor(), panel);
        tabbed.addTab(msg.getStrEmisor(), panel);
        tabbed.updateUI();
        
        if (msg != null) displayMessage(msg);
        
    }
    
    public void addWin(PanelChat panel, Usuario user){
        
        ventanasChat.put(user.getId(), panel);
        tabbed.addTab(user.getNick(), panel);
        tabbed.updateUI();
        panel.requestFocus();
    }
    
    @Override
    public void run() {

        Mensaje recibido;
        Object objRecibido;
        boolean usuarioExistente = false;
        String textoForo;
        
        while (true) {            
            
            try {
                Thread.sleep(100);
                objRecibido = con.getReceivedObject();
                
                if (objRecibido != null) {
                    
                    if (objRecibido instanceof Mensaje) {
                        recibido = (Mensaje) objRecibido;
                        
                        if (recibido.getReceptor() == 2){
                            
                            textoForo = foro.getText();
                            if (!textoForo.endsWith("\n")) foro.setText(textoForo + "\n");
                            
                            foro.setText(textoForo + "[" + recibido.getHora() + "] " + 
                                    recibido.getStrEmisor() + ": " + 
                                    recibido.getTexto() + "\n");
                        }
                        
                        else{
                            usuarioExistente = isChatExistente(recibido);
                            
                            if (usuarioExistente){ 
                                usuarioExistente = !usuarioExistente;
                                displayMessage(recibido);
                            }
                            else addWin(new PanelChat(recibido.getEmisor()), recibido);
                            
                        }
                    }
                    
                    else if (objRecibido instanceof LinkedList) {
                        listUsuarios.setModel(new LMForo((LinkedList<Usuario>)objRecibido));
                        System.out.println("Lista Actualizada");
                    }
                }
                
            } catch (InterruptedException | IOException | ClassNotFoundException ex) {
                Logger.getLogger(HiloReceptor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void deleteUserFromList(LinkedList listaRecibida) {

        Usuario u;
        for (int i = 0; i < listaRecibida.size(); i++) {
            u = (Usuario) listaRecibida.get(i);
            if (u.getId() == paqIni.getUser().getId()) listaRecibida.remove(i);
        }
    }
    
}
