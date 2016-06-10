/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class Conector {
    
    private final ServerSocket server;
    private volatile LinkedList<Cliente> clientes;
    private volatile LinkedList<Usuario> usuarios;
    
    public Conector(int puerto) throws IOException {
   
        server = new ServerSocket(puerto);
        clientes = new LinkedList<>();
        usuarios = new LinkedList<>();
    }

    public void addCliente(Cliente value){
        clientes.add(value);
        usuarios.add(value.getUser());
    }

    public void addUser(Usuario value){
        usuarios.add(value);
    }

    public void removeCliente(int index){
        
        clientes.remove(index);
        removeUser(index);
    }
    
    public void removeCliente(Cliente cliente){
        
        clientes.remove(cliente);
        if (cliente.hasUser()) 
            removeUser(cliente.getUser());
        
    }
    
    public void removeUser(int index){
        usuarios.remove(index);
    }
    
    public void removeUser(Usuario user){
        usuarios.remove(user);
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ServerSocket getServer() {
        return server;
    }
    
}
