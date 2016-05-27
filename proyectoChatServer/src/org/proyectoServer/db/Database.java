/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.db;

import bd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import org.proyectoChatComun.base.Mensaje;
import org.proyectoChatComun.base.Usuario;
import org.proyectoServer.model.TipoFiltro;

/**
 *
 * @author martin
 */
public class Database {

    public static Conexion connectionDB;
    public static ConexionRespaldo respaldo;
    public static String query;
    
    public static void connect() throws SQLException{
        
        connectionDB = new Conexion("localhost", "dbChat", "root", "admin");
        respaldo = new ConexionRespaldo();
        Query.conexion = connectionDB;
    }
    
    public static void addMensaje(Mensaje nuevo){
        
        query = "insert into mensaje values (null,"
                + "'" + nuevo.getTexto() + "',"
                + "'" + nuevo.getEmisor() + "',"
                + "'" + nuevo.getReceptor() + "',"
                + "'" + nuevo.getFecha() + "',"
                + "'" + nuevo.getHora() + "')";
        System.out.println(query);
        Query.insert(query);
    }
    
    public static TreeMap getMensajes() throws SQLException{
        
        String condicion = "u.id = m.emisor && u.id = m.receptor && u.habilitado = 1";
        ResultSet res = Query.select("mensaje m, usuario u", condicion, "m.id", 
                "m.texto", "m.emisor", "m.receptor", "m.fecha", "m.hora");

        Mensaje nuevo;
        TreeMap<Integer, Mensaje> mensajes = new TreeMap<>();
        
        while (res.next()) {            
            nuevo = new Mensaje(res.getInt(1), res.getString(2), res.getInt(3), 
                    res.getInt(4), res.getString(5), res.getString(6));
        
            mensajes.put(mensajes.size(), nuevo);
        }
        res.close();
        return mensajes;
    }

    public static ArrayList<Mensaje> getListMensajes() throws SQLException{
        
        String condicion = "u1.id = m.emisor and u2.id = m.receptor and u1.habilitado = 1 and "
                + "u2.habilitado = 1";
        ResultSet res = Query.select("mensaje m, usuario u1, usuario u2", condicion, "m.id", 
                "m.texto", "m.emisor", "m.receptor", "m.fecha", "m.hora");

        Mensaje nuevo;
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        while (res.next()) {            
            nuevo = new Mensaje(res.getInt(1), res.getString(2), res.getInt(3), 
                    res.getInt(4), res.getString(5), res.getString(6));
        
            mensajes.add(nuevo);
        }
        res.close();
        return mensajes;
    }
    
    public static ArrayList<Mensaje> getMensajes(int emisor, int receptor) throws SQLException{
        
        List<Mensaje> mensajes = new ArrayList<>();
        ResultSet res = Query.select("mensaje", 
                "emisor = " + emisor + " and receptor = " + receptor, 
                "id, texto, fecha, hora");
        Mensaje m;
        
        while (res.next()) {            
            m = new Mensaje(res.getInt(1), res.getString(2), emisor, receptor, res.getString(3), res.getString(4));
            mensajes.add(m);
        }
        
        return (ArrayList<Mensaje>) mensajes;
    }
    
    public static ArrayList<Mensaje> getMensajes(int emisor, int receptor, String filtro) throws SQLException{
        
        List<Mensaje> mensajes = new ArrayList<>();
        ResultSet res = Query.select("mensaje", 
                "emisor = " + emisor + " and receptor = " + receptor + " and texto like '%" + filtro + "%'", 
                "id, texto, fecha, hora");
        Mensaje m;
        
        while (res.next()) {            
            m = new Mensaje(res.getInt(1), res.getString(2), emisor, receptor, res.getString(3), res.getString(4));
            mensajes.add(m);
        }
        
        return (ArrayList<Mensaje>) mensajes;
    }

    public static boolean isRegistroValido(String nickNuevo) throws SQLException{
        
        boolean nickDisponible = false;
        
        if (getUser(nickNuevo) == null) return !nickDisponible;
        
        return nickDisponible;
    }
    
    public static void addUser(Usuario u){
        
        query = "insert into usuario values(null,"
                + "'" + u.getNombre() + "',"
                + "'" + u.getNick() + "',"
                + "'" + u.getClave() + "',"
                + "'" + u.getTipo() + "',"
                + "1)";
        System.out.println(query);
        Query.insert(query);
    }

    public static void setStatusUser(String nick, boolean status){

        Query.update("usuario", "nick = '" + nick + "'", "habilitado = " + status);
    }
    
    public static TreeMap getUsers() throws SQLException{
     
        TreeMap<Integer, Usuario> usuarios;
        try (ResultSet res = Query.select("usuario", "habilitado = 1", "*")) {
            usuarios = new TreeMap<>();
            Usuario nuevo;
            while (res.next()) {
                nuevo = new Usuario(res.getInt(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getInt(5));
                
                usuarios.put(nuevo.getId(), nuevo);
            }
        }
        return usuarios;
    }

    public static LinkedList<Usuario> getListUsers(int tipoFiltro) throws SQLException{
        
        LinkedList<Usuario> users = new LinkedList<>();
        ResultSet res;
        
        if (tipoFiltro == TipoFiltro.SHOW_ALL) {
            res = Query.select("usuario", null, "*");
        
        
        }
        
        else {
            res = Query.select("usuario", "habilitado = 1", "*");
        }
        
        Usuario u;
        
        while (res.next()) {            
            u = new Usuario(res.getInt(1), res.getString(2), res.getString(3), 
                    res.getString(4), res.getInt(5));
            users.add(u);
        }
        
        return users;
    }
    
    
    
    public static Usuario getUser(String nick) throws SQLException{
        
        ResultSet res = Query.select("usuario", "nick = '" + nick + "'", "*");
        Usuario user = null;
        
        if (res.next())
            user = new Usuario(res.getInt(1), res.getString(2), res.getString(3),
                                        res.getString(4), res.getInt(5));
        
        return user;
    }
    
     public static Usuario getUser(String nick, int tipoBusqueda) throws SQLException{
         
        ResultSet res;
         
        if (tipoBusqueda == Busqueda.USUARIO_HABILITADO)
            res = Query.select("usuario", "nick = '" + nick + "' and habilitado = 1", "*");
        
        else res = Query.select("usuario", "nick = '" + nick + "'", "*");
         
        Usuario user = null;
        
        if (res.next())
            user = new Usuario(res.getInt(1), res.getString(2), res.getString(3),
                                        res.getString(4), res.getInt(5));
        
        return user;
    }
    
    public static Usuario getUser(int id) throws SQLException{
        
        ResultSet res = Query.select("usuario", "id = '" + id + "'", "*");
        Usuario user = null;
        
        if (res.next())
            user = new Usuario(res.getInt(1), res.getString(2), res.getString(3),
                                        res.getString(4), res.getInt(5));
        
        return user;
    }
    
     public static Usuario getUser(int id, int tipoBusqueda) throws SQLException{
        
        ResultSet res;
        
         if (tipoBusqueda == Busqueda.USUARIO_HABILITADO) res = Query.select("usuario", "id = '" + id + "' and habilitado = 1", "*");
         
         else res = Query.select("usuario", "id = '" + id + "'", "*");
        
        Usuario user = null;
        
        if (res.next())
            user = new Usuario(res.getInt(1), res.getString(2), res.getString(3),
                                        res.getString(4), res.getInt(5));
        
        return user;
    }
    
    public static int getID(String nick) throws SQLException{
        
        query = "select id from user where nick = " + nick;
        return Query.select(nick).getInt(1);
    }
    
    public static boolean isLoginValido(String[] login) throws SQLException{

        String userPosible = login[0];
        String passwPosible = login[1];
        Usuario valido = getUser(userPosible);
        
        if (valido == null) return false;
        
        return valido.getClave().equalsIgnoreCase(passwPosible);
        
    }
    
    public static boolean isLoginValido(String login) throws SQLException{
        
        String[] loginSplit = login.split(",");
        String userPosible = loginSplit[0];
        String passwPosible = loginSplit[1];
        Usuario valido = getUser(userPosible);
        
        if (valido == null) return false;
            
        return valido.getClave().equalsIgnoreCase(passwPosible);
    }
}
