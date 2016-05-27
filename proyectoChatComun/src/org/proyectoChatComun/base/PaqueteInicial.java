/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatComun.base;

import java.util.TreeMap;

/**
 *
 * @author martin
 */
public class PaqueteInicial implements java.io.Serializable{
    
    private Usuario user;
    private volatile TreeMap<Integer, Usuario> usuarios;

    public PaqueteInicial(Usuario user, TreeMap<Integer, Usuario> usuarios) {
        this.user = user;
        this.usuarios = usuarios;
    }

    public Usuario getUser() {
        return user;
    }

    public TreeMap<Integer, Usuario> getUsuarios() {
        return usuarios;
    }
    
    
}
