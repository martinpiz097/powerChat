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
    public boolean isValido;
    
    public Comando(String cmd) {

        String[] args;
        
        if (!cmd.isEmpty() || cmd != null) {
            if (!cmd.startsWith(" ") && !cmd.contains("  ")) {
                isValido = true;
                if (!cmd.contains(" ")) {
                
                }
                else {
                
                }
            }
            else isValido = false;
            
        }
        else isValido = false;
        
        
    }

    public int getCantOptions(){

        int cantOpciones = 0;
        for (String opcion : opciones) 
            if (opcion.startsWith("-") || opcion.startsWith("--"))
                cantOpciones++;
        
        return cantOpciones;
        
    }
    
    public String getOrden(){
     
        return orden;
    }
    
    public String getCommand(){
        
        String cmd = "";
        for (String opcion : opciones) cmd += (opcion + " ");
        return orden + " " + cmd;
    }
    
    public boolean hasOption(String op){
        
        boolean hasOption = false;
        
        for (String opcion : opciones) 
            if (opcion.equals(op)) 
                return !hasOption;
        
        return hasOption;
    }
 
    public boolean hasOptions(String... options){
        
        boolean hasOptions = false;
        
        for (int i = 0; i < opciones.length; i++) 
            if (i < options.length) 
                hasOptions = opciones[i].equals(options[i]);
            else break;
        
        return hasOptions;
    }
    
    public boolean isEmpty(){
        
        return orden == null && opciones == null;
    }
    
    public boolean isWithoutOptions(){
        
        return opciones == null;
    }

    public int getIndexOption(String op){
        
        for (int i = 0; i < opciones.length; i++) 
            if (opciones[i].equals(op)) return i;
        
        return -1;
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
