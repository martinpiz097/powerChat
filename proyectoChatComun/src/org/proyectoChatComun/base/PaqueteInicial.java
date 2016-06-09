/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatComun.base;

import java.util.LinkedList;

/**
 *
 * @author martin
 */
public class PaqueteInicial implements java.io.Serializable{
    
    private Usuario user;
    private volatile LinkedList<Usuario> usuarios;

    public PaqueteInicial(Usuario user, LinkedList<Usuario> listUsers) {
        this.user = user;
        this.usuarios = listUsers;
    }
    
    public Usuario getUser() {
        return user;
    }

    public LinkedList getUsuarios() {
        return usuarios;
    }
    
}
