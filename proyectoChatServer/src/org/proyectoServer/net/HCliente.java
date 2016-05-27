/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.net;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.proyectoChatComun.base.Mensaje;
import org.proyectoChatComun.base.Usuario;
import org.proyectoServer.db.Database;

/**
 *
 * @author martin
 */
public class HCliente extends Thread{

    private Cliente cliente;
    private volatile TreeMap<Integer, Cliente> clientesConectados;
    private volatile TreeMap<Integer, Usuario> usuariosConectados;
    private volatile Conector c;
    
    public HCliente(Cliente cliente, Conector c) {
        this.cliente = cliente;
        this.c = c;
        this.clientesConectados = c.getClientes();
        this.usuariosConectados = c.getUsuarios();
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

                    if (cont % 10 == 0) {

                        if (!usuariosConectados.isEmpty()) usuariosConectados.clear();
                        
                        usuariosConectados = c.getUsuarios();
                        cliente.sendObject(usuariosConectados);
                    }

                    objRecibido = cliente.getReceivedObject();
                    System.out.println("Objeto ha sido recibido");
                    System.out.println("CLientes conectados: " + clientesConectados.size());
                    if (objRecibido != null) {

                        System.out.println("Objeto distinto de null");
                        if (objRecibido instanceof Mensaje) {
                            msg = (Mensaje) objRecibido;
                            System.out.println("Objeto casteado a Mensaje");
                            System.out.println(msg);
                            if (msg.getReceptor() == 2) {

                                System.out.println("Receptor = 2");
                                Cliente c;
                                System.out.println("Clientes conetados: " + clientesConectados.size());
                                for (Iterator<Cliente> it = clientesConectados.values().iterator(); it.hasNext();) {
                                    System.out.println("Entro al for");
                                    c = it.next();
                                    if (c.getUser().getId() != cliente.getUser().getId()) {
                                        c.sendObject(msg);
                                        System.out.println("Mensaje de foro reenviado!");
                                    }
                                }
                                System.out.println("Paso el for");
                            } else 
                                clientesConectados.get(msg.getReceptor()).sendObject(msg);

                            Database.addMensaje(msg);
                        }

                    }
                    cont++;

                } else {
                    clientesConectados.remove(cliente.getUser().getId());
                    break;
                }
            } catch (InterruptedException | IOException | ClassNotFoundException ex) {
                Logger.getLogger(HCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
