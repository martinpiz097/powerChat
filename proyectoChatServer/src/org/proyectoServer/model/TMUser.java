/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.model;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.proyectoChatComun.base.TipoUsuario;
import org.proyectoChatComun.base.Usuario;

/**
 *
 * @author martin
 */
public class TMUser implements TableModel{

    private List<Usuario> listUsers;
    private Usuario user;
    
    public TMUser(List<Usuario> listUsers) {
        this.listUsers = listUsers;
    }

    public TMUser(Usuario user) {
        this.user = user;
    }
    
    @Override
    public int getRowCount() {

        if(listUsers != null) return listUsers.size();
        
        else return 1;
    }

    @Override
    public int getColumnCount() {

        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch(columnIndex){
            
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Nick";
            case 3: return "Clave";
            default: return "Tipo";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        return Object.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Usuario u = null;

        if(getRowCount() == 1) u = user;
        
        else u = listUsers.get(rowIndex);
        
        switch(columnIndex){
            
            case 0: return u.getId();
            case 1: return u.getNombre();
            case 2: return u;
            case 3: return u.getClave();
            case 4:{
                if (u.getTipo() == TipoUsuario.ADMINISTRADOR) return "Administrador";
                
                else return "Comun";
            }
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    
}
