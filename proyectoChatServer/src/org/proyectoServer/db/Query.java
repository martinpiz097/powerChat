/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.db;

import bd.Conexion;
import cSharp.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */
public class Query {

    /*
        Recordar el borrar los sout cuando termine un proyecto
    */
    
    private static String strConsulta;
    private static String consultaTemp;
    public static Conexion conexion;
    public static final Integer SHOW = 0;
    public static final Integer DESCRIBE = 1;

    public static ResultSet select(String nombreTabla, String where, String... nombreColumna) {
        
        Conexion c = conexion;
        try {
            consultaTemp = "select ";
            
            for (String columna : nombreColumna) {
                
                consultaTemp += (columna + ", ");
            }
            
            if (where == null) {
                strConsulta = consultaTemp.substring(0, consultaTemp.length() - 2) + " from " + nombreTabla;
            } else {
                strConsulta = consultaTemp.substring(0, consultaTemp.length() - 2) + " from " + nombreTabla + " where " + where;
                
            }
            
            System.out.println(strConsulta);
            c.sen = c.con.createStatement();
            c.res = c.sen.executeQuery(strConsulta);
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c.res;
    }

    public static ResultSet select(String consulta) {

        try {
            strConsulta = consulta;
            conexion.sen = conexion.con.createStatement();
            conexion.res = conexion.sen.executeQuery(strConsulta);
            System.out.println(strConsulta);
            return conexion.res;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void insert(String nombreTabla, String... atributos) {
        try {
            consultaTemp = "insert into " + nombreTabla + " values (";
            int contador = 0;
            Conexion c = conexion;
            
            for (String atributo : atributos) {
                
                contador++;
                
                if (atributo == null) {
                    
                    consultaTemp += "null,";
                } else {
                    
                    consultaTemp += ("'" + atributo + "',");
                }
            }
            
            strConsulta = (consultaTemp.substring(0, consultaTemp.length() - 2)) + "')";
            System.out.println(strConsulta);
            c.sen = c.con.createStatement();
            c.sen.execute(strConsulta);
            c.sen.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(String consulta){

        try {
            strConsulta = consulta;
            conexion.sen = conexion.con.createStatement();
            conexion.sen.execute(strConsulta);
            conexion.sen.close();
        } catch (SQLException ex) {

            System.out.println("Exist an error in the method insert");
            System.exit(1);
        }
    }

    public static void delete(String nombreTabla, String where, String... nombreColumna) throws SQLException {
        consultaTemp = "delete ";
        
        if (nombreColumna[0] == null) {

            for (String columna : nombreColumna) {
                
                consultaTemp += (columna + ", ");
            }

            if (where == null) {
                strConsulta = consultaTemp.substring(0, consultaTemp.length() - 2) + " from " + nombreTabla;
            } else {
                strConsulta = consultaTemp.substring(0, consultaTemp.length() - 2) + " from " + nombreTabla + " where " + where;
            }
        } 
        
        else {
            
            strConsulta.concat("from " + nombreTabla);
            
            if (where != null) 
                strConsulta.concat(" where " + where);
        }

        System.out.println(strConsulta);
        conexion.sen = conexion.con.createStatement();
        conexion.sen.execute(strConsulta);
        conexion.sen.close();

    }

    public static void delete(String query){
        
        try {
            conexion.sen = conexion.con.createStatement();
            conexion.sen.execute(query);
            conexion.sen.close();
        } catch (SQLException ex) {

            System.out.println("Error de tipo SQL en delete2");
        }
    }
    
    public static void update(String nombreTabla, String where, String... modificacion) {

        try {
            consultaTemp = "update " + nombreTabla + " set ";
            Conexion c = conexion;
            
            for (String mod : modificacion) {
                
                consultaTemp += (mod + ", ");
            }
            
            if (where == null) {
                strConsulta = consultaTemp.substring(0, consultaTemp.length() - 2);
            } else {
                strConsulta = consultaTemp.substring(0, consultaTemp.length() - 2) + " where " + where;
            }
            
            c.sen = c.con.createStatement();
            c.sen.executeUpdate(strConsulta);
            c.sen.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(String query){
        
        if (!query.contains("update")) query = "update " + query.trim();
        
        execute(query);
    }
    
    public static void create(String consulta) {

        try {
            conexion.sen = conexion.con.createStatement();
            conexion.sen.executeUpdate(consulta);
            conexion.sen.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void create(String tabla, String primaryKey, String... atributos){
     
        consultaTemp = "create table " + tabla + "(";
        
        for (String atributo : atributos) 
            consultaTemp += (atributo + ", ");
        
        
        if (primaryKey == null) 
            consultaTemp = consultaTemp.substring(0, consultaTemp.length()-2);
        
        else
            consultaTemp += ("primary key (" + primaryKey + "))");   
        
        strConsulta = consultaTemp;
        System.out.println(strConsulta);
        create(strConsulta);
    }
    
    public static void execute(String query) {

        try {
            System.out.println("Query: " + query);
            conexion.sen = conexion.con.createStatement();
            conexion.sen.executeUpdate(query);
            conexion.sen.close();
        } catch (SQLException ex) {

            System.out.println("Exist an error in the method execute");
            System.out.println(ex.getLocalizedMessage());
            System.exit(1);
        }
    }

    public static ResultSet show(String query){
    
        try {
            strConsulta = query.trim();
            conexion.sen = conexion.con.createStatement();
            
            if (strConsulta.contains("show")) {
                
                conexion.res = conexion.sen.executeQuery(strConsulta);
                return conexion.res;
            }
            
            else{
                
                strConsulta = "show " + strConsulta;
                conexion.res = conexion.sen.executeQuery(strConsulta);
                return conexion.res;
            }
        } catch (SQLException ex) {
            
            Console.WriteLine("Exist an error in the method show from the class Query");
            return null;
        }
        
    }
    
    public static ResultSet describe(String query){
        
        try {
            strConsulta = query.trim();
            conexion.sen = conexion.con.createStatement();
            
            if (strConsulta.contains("desc") || strConsulta.contains("describe")) {
                
                conexion.res = conexion.sen.executeQuery(strConsulta);
                return conexion.res;
            }
            
            else{
                
                strConsulta = "desc " + strConsulta;
                conexion.res = conexion.sen.executeQuery(strConsulta);
                return conexion.res;
            }
        } catch (SQLException ex) {
            
            Console.WriteLine("Exist an error in the method describe from "
                                + "the class Query");
            System.exit(1);
        }
        
        return null;
    }

    public static ResultSet execute(String query, int type){
        
        if (type == Query.SHOW)
            return show(query);
        
        else if (type == Query.DESCRIBE) 
            return describe(query);
        
        else
            return null;
        
    }
}
