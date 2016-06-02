/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatCliente.model;

import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class LMForo implements ListModel<Usuario>{

    private TreeMap<Integer, Usuario> mapaUsuarios;
    private ArrayList<Usuario> listaUsuarios;
    
    public LMForo(TreeMap<Integer, Usuario> usuarios) {
        super();
        this.mapaUsuarios = usuarios;
    }

    public LMForo(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        System.out.println("Cantidad de usuarios conectados: " + listaUsuarios.size());
    }

    @Override
    public int getSize() {

        if (mapaUsuarios != null) return mapaUsuarios.size();
        
        else return listaUsuarios.size();
    }

    @Override
    public Usuario getElementAt(int index) {

        if (mapaUsuarios != null) return mapaUsuarios.get(index);
        
        else return listaUsuarios.get(index);
        
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    
}
