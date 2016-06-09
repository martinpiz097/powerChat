/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatComun.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author martin
 */
public class PublicHostGenerator {
    
    private URL urlIP;
    private File fileHost;
    private BufferedReader lector;
    private BufferedWriter editor;
    private String host;
    
    public PublicHostGenerator(int tipoSW) throws MalformedURLException, IOException {
   
        if (tipoSW == TipoSW.SERVER) {
            
            urlIP = new URL("http://icanhazip.com");
            lector = new BufferedReader(new InputStreamReader(urlIP.openStream()));
            lector.lines().forEach(this::addLine);
            lector.reset();
            urlIP = new URL("ftp://a1760801:blanko097@powerx.comli.com/public_html/host.txt");
            editor = new BufferedWriter(new OutputStreamWriter(urlIP.openConnection().getOutputStream()));
            editor.write(host);
            editor.close();
        }
        
        else{
            urlIP = new URL("ftp://a1760801:blanko097@powerx.comli.com/public_html/host.txt");
            lector = new BufferedReader(new InputStreamReader(urlIP.openStream()));
            lector.lines().forEach(this::addLine);
            lector.close();
        }
    }

    private void addLine(String line){
        
        if (host == null) host = "";
        host += (line);
    }

    public String getHost() {
        return host;
    }
    
}
