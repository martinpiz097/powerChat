/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatCliente.model;

import java.util.LinkedList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class LMForo implements ListModel<Usuario>{

    private LinkedList<Usuario> listaUsuarios;
    
    public LMForo(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        System.out.println("Cantidad de usuarios conectados: " + listaUsuarios.size());
    }

    @Override
    public int getSize() {
        return listaUsuarios.size();
    }

    @Override
    public Usuario getElementAt(int index) {
        return listaUsuarios.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
    
}
