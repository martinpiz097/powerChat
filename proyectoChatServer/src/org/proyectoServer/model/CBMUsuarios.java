/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.model;

import java.util.LinkedList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class CBMUsuarios implements ComboBoxModel<Usuario>{
    
    private LinkedList<Usuario> listaUsuarios;
    
    public CBMUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public void setSelectedItem(Object anItem) {
    
    }

    @Override
    public Object getSelectedItem() {
        return null;
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
