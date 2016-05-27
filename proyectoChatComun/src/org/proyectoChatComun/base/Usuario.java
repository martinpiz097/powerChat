/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatComun.base;

/**
 *
 * @author martin
 */
public class Usuario implements java.io.Serializable{

    private int id;
    private String nombre;
    private String nick;
    private String clave;
    private int tipo;
    private int habilitado;
    
    public Usuario(int id, String nombre, String nick, String clave, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.nick = nick;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Usuario(String nombre, String nick, String clave, int tipo) {
        this.nombre = nombre;
        this.nick = nick;
        this.clave = clave;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public boolean isHabilitado(){
        return habilitado == 1;
    }

    public void setHabilitado(Object paramHabilitado) {

        if (paramHabilitado instanceof Integer) habilitado = (int) paramHabilitado;
        
        else if (paramHabilitado instanceof Boolean) {

            boolean boolHabilitado = (boolean) paramHabilitado;
            
            if (boolHabilitado) habilitado = 1;
            
            else habilitado = 0;
        }
    }
    
    @Override
    public String toString() {

        return nick;
    }
}
