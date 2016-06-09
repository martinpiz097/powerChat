
package org.proyectoServer.net;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import org.proyectoChatComun.base.Code;
import org.proyectoChatComun.base.PaqueteInicial;
import org.proyectoChatComun.base.Usuario;
import org.proyectoServer.db.Database;
import tiempo.Calendario;
/**
 *
 * @author martin
 */
public class HiloConector implements Runnable{

    private Conector conector;
    private List<HCliente> conexiones;
    private JTextArea console;
    
    public HiloConector(int puerto, JTextArea console) throws IOException {
        this.conector = new Conector(puerto);
        conexiones = new LinkedList<>();
        this.console = console;
    }
    
    private void updateConsole(String text){
        
        console.setText(console.getText() + getHoraActual()+ text + "\n");
    }
    
    private String getHoraActual(){

        return "[" + new Calendario().getReloj() + "] ";
    }
    
    @Override
    public void run() {

        Socket sockCliente;
        Cliente nuevo;
        String login = null;
        Object peticionCliente = null;
        boolean loginValido;
        boolean registroValido = false;
        boolean userAlreadyConnected = false;
        Usuario newUser;
        HCliente hc;
        
        while (true) {            
            try {
                Thread.sleep(500);
                sockCliente = conector.getServer().accept();
                System.out.println("Llego una peticion");
                nuevo = new Cliente(sockCliente);
                peticionCliente = nuevo.getReceivedObject();
                
                while (peticionCliente == null)
                    peticionCliente = nuevo.getReceivedObject();
                
                System.out.println("Se ha recibido un objeto");
                if (peticionCliente instanceof String) {
                    login = String.valueOf(peticionCliente);
                    System.out.println("Objeto casteado");
                    loginValido = Database.isLoginValido(login);
                    System.out.println("Usuario Validado");
                    nuevo.sendObject(loginValido);
                    System.out.println("Se envio la respuesta!");

                    if (loginValido) {

                        newUser = Database.getUser(login.split(",")[0]);
                        
                        Cliente value;
                        for (Iterator<Cliente> it = conector.getClientes().iterator(); it.hasNext();) {
                            value = it.next();
                            
                            if (value.getUser().getId() == newUser.getId()) 
                                userAlreadyConnected = true;
                            
                            if(userAlreadyConnected) break;
                        }
                        
                        if (!userAlreadyConnected) {
                            nuevo.setUser(newUser);
                            conector.addCliente(nuevo);
                            System.out.println("Cliente agregado a la lista");
                            System.out.println("Usuarios conectados actualmente: " + conector.getUsuarios().size());
                            nuevo.sendObject(new PaqueteInicial(newUser, conector.getUsuarios()));
                            hc = new HCliente(nuevo, conector);
                            hc.start();
                            conexiones.add(hc);
                            updateConsole("Cliente " + nuevo.getUser().getNick());
                        }
                        
                        else nuevo.sendObject(Code.IS_CONNECTED);
                        
                    }
                    
                    // else nuevo.sendObject(loginValido);
                }
                
                else if (peticionCliente instanceof Usuario) {
                
                    newUser = (Usuario) peticionCliente;
                    registroValido = Database.isRegistroValido(newUser.getNick());
                    nuevo.sendObject(registroValido);
                    if (registroValido) {
                        
                        Database.addUser(newUser);
                        updateConsole("Nuevo Usuario agregado");
                    }
                    
                    nuevo.sendObject(registroValido);
                        
                }

                // Si fue creado un objeto peticionCliente
                // este vuelve a null porque ya ha sido ocupado
                // y asi no se repite en la validacion anterior
                
                // if (peticionCliente != null) peticionCliente = null;
                
            } catch (InterruptedException | IOException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(HiloConector.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
