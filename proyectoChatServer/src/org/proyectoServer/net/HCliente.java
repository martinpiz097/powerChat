/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.net;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.proyectoChatComun.base.Mensaje;
import org.proyectoServer.db.Database;

/**
 *
 * @author martin
 */
public class HCliente extends Thread{

    private Cliente cliente;
    private volatile Conector c;
    
    public HCliente(Cliente cliente, Conector c) {
        this.cliente = cliente;
        this.c = c;
    }
    
    @Override
    public void run() {
        
        Mensaje msg;
        Object objRecibido;
        int cont = 0;
        while (true) {            
            try {
                Thread.sleep(300);

                if (cliente.getSocket().isConnected()) {

                    if (cont % 10 == 0) cliente.sendObject(c.getUsuarios());

                    objRecibido = cliente.getReceivedObject();
                    System.out.println("Objeto ha sido recibido");
                    System.out.println("Clientes conectados: " + c.getClientes().size());
                    if (objRecibido != null) {

                        System.out.println("Objeto distinto de null");
                        if (objRecibido instanceof Mensaje) {
                            msg = (Mensaje) objRecibido;
                            msg.setStrEmisor(Database.getUser(msg.getEmisor()).getNick());
                            System.out.println("Objeto casteado a Mensaje");
                            System.out.println(msg);
                            if (msg.getReceptor() == 2) {

                                System.out.println("Receptor = 2");
                                Cliente cl;
                                System.out.println("Clientes conetados: " + c.getClientes().size());
                                for (Iterator<Cliente> it = c.getClientes().values().iterator(); 
                                        it.hasNext();) {
                                    
                                    System.out.println("Entro al for");
                                    cl = it.next();
                                    if (cl.getUser().getId() != cliente.getUser().getId()) {
                                        cl.sendObject(msg);
                                        System.out.println("Mensaje de foro reenviado!");
                                    }
                                }
                                System.out.println("Paso el for");
                            } else 
                                c.getClientes().get(msg.getReceptor()).sendObject(msg);

                            Database.addMensaje(msg);
                        }

                    }
                    cont++;

                } else {
                    c.removeCliente(cliente.getUser().getId());
                    cliente = null;
                    break;
                }
            } catch (InterruptedException | IOException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(HCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
