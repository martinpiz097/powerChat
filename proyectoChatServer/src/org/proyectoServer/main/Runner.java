/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.main;

import org.martin.proyectoChatComandos.base.Comando;
import org.martin.proyectoChatComandos.base.Orden;

/**
 *
 * @author martin
 */
public class Runner {
    
    private Comando cmd;

    public Runner(Comando cmd) {
        this.cmd = cmd;
    }
    
    public boolean isEjecutable(){
        
        boolean isRunnable = false;
        
        if (!cmd.orden.equals(Orden.HELP) && cmd.opciones == null) 
            return isRunnable;
        
        
        
        return isRunnable;
    }
    
    public void run() {
        
        /*
        if (cmd.orden.equals(Orden.ADD)) {
            
        }
        else if (cmd.orden.equals(Orden.ENABLE)) {
            
        }
        else if (cmd.orden.equals(Orden.HELP)) {
            
        }
        else if (cmd.orden.equals(Orden.SEARCH)) {
            
        }
        else if (cmd.orden.equals(Orden.START)) {
            
        }
        else if (cmd.orden.equals(Orden.STOP)) {
            
        }
        else{
            System.out.println("Error de sintaxis de comando");
        }
        */
    }
    
}
