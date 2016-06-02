/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatComun.base;

/**
 *
 * @author martin
 * @param <E>
 */
public interface Ejecutable <E> {
 
    public void run(E cmd);
}
