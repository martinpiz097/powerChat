/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.model;

import java.util.TreeMap;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class CBMUsuarios implements ComboBoxModel<Usuario>{
    
    private TreeMap<Integer, Usuario> usuarios;

    public CBMUsuarios(TreeMap<Integer, Usuario> usuarios) {
        this.usuarios = usuarios;
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

        return usuarios.size();
    }

    @Override
    public Usuario getElementAt(int index) {

        return usuarios.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
    
    
}
