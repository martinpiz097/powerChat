/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class Cliente {

    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private Usuario user;
    
    public Cliente(Socket socket) throws IOException {
   
        this.socket = socket;
        salida = new ObjectOutputStream(socket.getOutputStream());
        entrada = new ObjectInputStream(socket.getInputStream());
    }

    public Cliente(Socket socket, ObjectOutputStream salida, ObjectInputStream entrada) {
        this.socket = socket;
        this.salida = salida;
        this.entrada = entrada;
    }

    public void close() throws IOException{
        socket.close();
    }
    
    public boolean hasBytes() throws IOException{
        return entrada.available() > 0;
    }
    
    public Socket getSocket() {
        return socket;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public boolean hasUser(){
        return user != null;
    }
    
//    public void login(String nick, HashMap<Integer, Usuario> usuarios) throws SQLException{
//        
//        user = Database.getUser(nick);
//        usuarios.put(user.getId(), user);
//    }
    
    public void sendObject(Object obj) throws IOException{
        
        salida.writeObject(obj);
    }
    
    public Object getReceivedObject() throws IOException, ClassNotFoundException{
        
        return entrada.readObject();
    
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

}
