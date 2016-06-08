/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatCliente.net;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import org.proyectoChatCliente.gui.PanelChat;
import org.proyectoChatCliente.model.LMForo;
import org.proyectoChatComun.base.Mensaje;
import org.proyectoChatComun.base.PaqueteInicial;

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
  
    public HiloReceptor(Conector con, JTextPane foro, JList listUsuarios) {
        this.con = con;
        this.foro = foro;
        ventanasChat = new HashMap<>();
        this.listUsuarios = listUsuarios;   
    }

    public HiloReceptor(PaqueteInicial paqIni, Conector con, JTextPane foro, JTabbedPane tabbed, JList listUsuarios) {
        this.paqIni = paqIni;
        this.con = con;
        this.foro = foro;
        this.tabbed = tabbed;
        this.ventanasChat = new HashMap<>();
        this.listUsuarios = listUsuarios;
    }

    public HiloReceptor(Conector con, JTextPane foro, JTabbedPane tabbed) {
        this.con = con;
        this.foro = foro;
        this.tabbed = tabbed;
        ventanasChat = new HashMap<>();
        
    }

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
        displayMessage(msg);
    }
    
    @Override
    public void run() {

        Mensaje recibido;
        TreeMap listaRecibida;
        Object objRecibido;
        boolean usuarioExistente = false;
        int cont = 0;
        String textoForo;
        
        while (true) {            
            
            cont++;
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
                    
                    if (cont % 10 == 0) 
                    
                        if (objRecibido instanceof TreeMap) {
                            listaRecibida = (TreeMap) objRecibido;
                            listUsuarios.setModel(new LMForo(listaRecibida));
                        
                        }
                    
                    
                }
                
            } catch (InterruptedException | IOException | ClassNotFoundException ex) {
                Logger.getLogger(HiloReceptor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
