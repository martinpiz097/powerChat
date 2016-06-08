/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.main;

import org.martin.proyectoChatComandos.base.Comando;
import org.martin.proyectoChatComandos.base.Opcion;
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
        return cmd.isValido;
    }
    
    public boolean run() {
        
        switch (cmd.orden) {
            case Orden.ADD:
                if (cmd.getCantOptions() == 4) {
                    
                }
                else return false;
                break;
            case Orden.ENABLE:
                break;
            case Orden.HELP:
                
                break;
            case Orden.SEARCH:
                break;
            case Orden.START:
                if (cmd.getCantOptions() == 3) {
                    if (cmd.hasOptions(Opcion.USER1, Opcion.KEY1, Opcion.PORT1) || 
                            cmd.hasOptions(Opcion.USER1, Opcion.KEY2, Opcion.PORT1) || 
                            cmd.hasOptions(Opcion.USER1)){
                        
                    }
                }
                else return false;
                break;
            case Orden.STOP:
                if (cmd.getCantOptions() == 3) {
                    
                }
                else return false;
                break;
            default:
                System.out.println("Error de sintaxis de comando");
                break;
        }

        return false;
    }
    
}
