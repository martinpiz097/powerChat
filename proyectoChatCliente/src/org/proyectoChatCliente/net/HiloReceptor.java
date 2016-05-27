/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatCliente.net;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import org.proyectoChatCliente.gui.PanelChat;
import org.proyectoChatCliente.model.LMForo;
import org.proyectoChatComun.base.Mensaje;

/**
 *
 * @author martin
 */
public class HiloReceptor implements Runnable{

    private Conector con;
    private JTextPane foro;
    private JTabbedPane tabbed;
    private List<PanelChat> ventanasChat;
    private JList listUsuarios;
  
    public HiloReceptor(Conector con, JTextPane foro, JList listUsuarios) {
        this.con = con;
        this.foro = foro;
        ventanasChat = new LinkedList<>();
        this.listUsuarios = listUsuarios;   
    }

    public HiloReceptor(Conector con, JTextPane foro, JTabbedPane tabbed) {
        this.con = con;
        this.foro = foro;
        this.tabbed = tabbed;
        ventanasChat = new LinkedList<>();
    }

    public List<PanelChat> getVentanasChat() {
        return ventanasChat;
    }
    
    public void addWin(PanelChat panel){
        
        ventanasChat.add(panel);
    }
    
    @Override
    public void run() {

        Mensaje recibido;
        TreeMap listaRecibida;
        Object objRecibido;
        boolean usuarioExistente = false;
        
        while (true) {            
            
            try {
                Thread.sleep(100);
                objRecibido = con.getReceivedObject();
                
                if (objRecibido != null) {
                    
                    if (objRecibido instanceof Mensaje) {
                        recibido = (Mensaje) objRecibido;
                        
                        if (recibido.getReceptor() == 2)
                            foro.setText("[" + recibido.getHora() + "] " + foro.getText() + recibido.getTexto() + "\n");
                        
                        else{

                            for(PanelChat pc : ventanasChat){
                                
                                if (pc.usuarioReceptor == recibido.getEmisor()) {
                                    pc.addMsg(recibido);
                                    usuarioExistente = !usuarioExistente;
                                }
                            }
                            
                            if (usuarioExistente) 
                                usuarioExistente = !usuarioExistente;
                            
                            else{
                                addWin(new PanelChat(recibido.getEmisor()));
                                ventanasChat.get(ventanasChat.size()-1).addMsg(recibido);
                            }
                        }
                    }
                    
                    else if (objRecibido instanceof TreeMap) {
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
