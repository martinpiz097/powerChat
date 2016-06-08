/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoServer.db;

import bd.Conexion;

/**
 *
 * @author martin
 */
public class ConexionRespaldo extends Conexion{

    public ConexionRespaldo() {
        super("dbRespaldo");
    }
    
}
