/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatComun.net;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author martin
 */
public final class Tester {

    public static final boolean isConnected(){
        
        try {
            return new Socket("www.google.cl", 80).isConnected();
        } catch (IOException ex) {
            return false;
        }
    }
}
