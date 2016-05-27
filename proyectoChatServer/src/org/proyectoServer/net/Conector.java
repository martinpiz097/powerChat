/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.TreeMap;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class Conector {
    
    private final ServerSocket server;
    private volatile TreeMap<Integer, Cliente> clientes;
    private volatile TreeMap<Integer, Usuario> usuarios;
    
    public Conector(int puerto) throws IOException {
   
        server = new ServerSocket(puerto);
        clientes = new TreeMap<>();
        usuarios = new TreeMap<>();
    }

    public void addCliente(int key, Cliente value){
        clientes.put(key, value);
    }

    public void addUser(int key, Usuario value){
        usuarios.put(key, value);
    }
    
    public TreeMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public TreeMap<Integer, Usuario> getUsuarios() {
        return usuarios;
    }

    public ServerSocket getServer() {
        return server;
    }
    
}
