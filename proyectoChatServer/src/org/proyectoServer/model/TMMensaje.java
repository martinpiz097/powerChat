/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.model;

import java.sql.SQLException;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.proyectoChatComun.base.Mensaje;
import org.proyectoServer.db.Database;

/**
 *
 * @author martin
 */
public class TMMensaje implements TableModel{

    private List<Mensaje> listMsg;
    private TreeMap<Integer, Mensaje> mapMsg;
    
    public TMMensaje(List<Mensaje> listMsg) {
        this.listMsg = listMsg;
    }

    public TMMensaje(TreeMap<Integer, Mensaje> mapMsg) {
        this.mapMsg = mapMsg;
    }
    
    @Override
    public int getRowCount() {

        if(listMsg != null) return listMsg.size();
        
        else return mapMsg.size();
    }

    @Override
    public int getColumnCount() {
        
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch(columnIndex){
            
            case 0: return "ID";
            case 1: return "Texto";
            case 2: return "Emisor";
            case 3: return "Receptor";
            case 4: return "Fecha";
            default: return "Hora";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class ;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Mensaje msg = null;
        String emisor = null;
        String receptor = null;
        
        try {
            
            if(listMsg != null) msg = listMsg.get(rowIndex);
            
            else msg = mapMsg.get(rowIndex);
            
            emisor = Database.getUser(msg.getEmisor()).getNick();
            receptor = Database.getUser(msg.getReceptor()).getNick();
        } catch (SQLException ex) {
            Logger.getLogger(TMMensaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        switch(columnIndex){
            
            case 0: return msg.getId();
            case 1: return msg.getTexto();
            case 2: return emisor;
            case 3: return receptor;
            case 4: return msg.getFecha();
            case 5: return msg.getHora();
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
