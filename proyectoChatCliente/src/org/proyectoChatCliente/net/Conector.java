/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatCliente.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author martin
 */
public class Conector implements java.io.Serializable {

    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    public Conector(int puerto) throws IOException {
   
        // String ip = new PublicHostGenerator(TipoSW.CLIENT).getHost();
        socket = new Socket("localhost", puerto);
        salida = new ObjectOutputStream(socket.getOutputStream());
        entrada = new ObjectInputStream(socket.getInputStream());
    }
    
    public void close() throws IOException{
        socket.close();
    }

    public Socket getSocket() {
        return socket;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }
    
    public void sendObject(Object obj) throws IOException{
        
        salida.writeObject(obj);
    }
    
    public Object getReceivedObject() throws IOException, ClassNotFoundException{
        
        return entrada.readObject();
    }
    
}
