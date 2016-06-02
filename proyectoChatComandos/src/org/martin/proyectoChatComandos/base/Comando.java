/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.proyectoChatComandos.base;

/**
 *
 * @author martin
 */
public class Comando {

    public String orden;
    public String[] opciones;

    public Comando(String cmd) {

        String[] args;
        
        if (!cmd.startsWith(" ") && cmd.trim().contains(" ") && cmd.trim().contains("  ")) 
            args = cmd.split(" ");
        
    }
    
    public boolean isEmpty(){
        
        return orden == null && opciones == null;
    }
    
    public String getOption(int index){
        
        try{
            return opciones[index];
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Indice fuera del limite del array");
            return null;
        }
    }

}
