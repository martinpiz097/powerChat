/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.net;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
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
    private volatile Conector c;
    private LinkedList<Usuario> listaCache;
    
    public HCliente(Cliente cliente, Conector c) {
        this.cliente = cliente;
        this.c = c;
        listaCache = c.getUsuarios();
    }
    
    public Cliente getCliente(){
        return cliente;
    }

    public boolean hasClient(){
        return cliente != null;
    }
    
    private void removeThisUserFromList(){
        
    }
    
    private LinkedList<Usuario> filterList(LinkedList<Usuario> lista){
        LinkedList<Usuario> listaFiltrada = new LinkedList<>();
        lista.stream().filter(
                (u) -> u.getId() != cliente.getUser().getId()).forEach(listaFiltrada::add);
        
        return listaFiltrada;
    }
    
    @Override
    public void run() {
        
        Mensaje msg;
        Object objRecibido;
        
        int cont = 0;
        while (true) {            
            try {
                Thread.sleep(300);

                if (cliente.getSocket().isConnected() || !cliente.getSocket().isClosed()) {

                    if (c.getUsuarios().size() != listaCache.size()) {
                        listaCache = c.getUsuarios();
                        cliente.sendObject(filterList(listaCache));
                    }

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
                                for (Iterator<Cliente> it = c.getClientes().iterator(); 
                                        it.hasNext();) {
                                    
                                    System.out.println("Entro al for");
                                    cl = it.next();
                                    if (cl.getUser().getId() != cliente.getUser().getId()) {
                                        cl.sendObject(msg);
                                        System.out.println("Mensaje de foro reenviado!");
                                    }
                                }
                                System.out.println("Paso el for");
                            } else {
                                Cliente res;
                                int cont2 = 0;
                                
                                // Por cada cliente obtenido por el contador
                                // que contenga un ID de usuario distinto
                                // al id del receptor del mensaje
                                // sumo 1 al contador, de lo contrario
                                // se termina el for y obtengo el indice mediante el contador
                                // del cliente que estoy buscando
                                
                                for(res = c.getClientes().get(cont2); 
                                        res.getUser().getId() != msg.getReceptor();)
                                    cont2++;

                                c.getClientes().get(cont2).sendObject(msg);
                            }

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
                // Logger.getLogger(HCliente.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        
        }
        
        cliente = null;
        c.removeCliente(this.cliente);
    }
    
}
