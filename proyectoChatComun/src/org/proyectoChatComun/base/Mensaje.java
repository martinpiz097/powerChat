/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoChatComun.base;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author martin
 */
public class Mensaje implements java.io.Serializable{

    private int id;
    private String texto;
    private int emisor;
    private String strEmisor;
    private int receptor;
    private String fecha;
    private String hora;
    private Calendar c;
    
    public Mensaje(int id, String texto, int emisor, int receptor) {
        this.id = id;
        this.texto = texto;
        this.emisor = emisor;
        this.receptor = receptor;
        generateFecha();
        generateHora();
    }

    public Mensaje(String texto, int emisor, int receptor) {
        this.texto = texto;
        this.emisor = emisor;
        this.receptor = receptor;
        generateFecha();
        generateHora();
    }

    public Mensaje(int id, String texto, int emisor, int receptor, String fecha, String hora) {
        this.id = id;
        this.texto = texto;
        this.emisor = emisor;
        this.receptor = receptor;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    private void generateHora(){
        c = new GregorianCalendar();
        String hours = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String minutes = String.valueOf(c.get(Calendar.MINUTE));
        String seconds = String.valueOf(c.get(Calendar.SECOND));
        
        if(Integer.parseInt(hours) < 10) hours = "0" + hours;
        
        if(Integer.parseInt(minutes) < 10) minutes = "0" + minutes;
        
        if(Integer.parseInt(seconds) < 10) seconds = "0" + seconds;
        
        this.hora = hours + ":" + minutes + ":" + seconds;
    }
    
    private void generateFecha(){
        
        c = new GregorianCalendar();
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf(c.get(Calendar.MONTH)+1);
        String year = String.valueOf(c.get(Calendar.YEAR));
        
        if(Integer.parseInt(day) < 10) day = "0" + day;
        
        if(Integer.parseInt(month) < 10) month = "0" + month;
        
        this.fecha = day + "/" + month + "/" + year;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getEmisor() {
        return emisor;
    }

    public void setEmisor(int emisor) {
        this.emisor = emisor;
    }

    public String getStrEmisor() {
        return strEmisor;
    }

    public void setStrEmisor(String strEmisor) {
        this.strEmisor = strEmisor;
    }

    public Calendar getC() {
        return c;
    }

    public void setC(Calendar c) {
        this.c = c;
    }
    
    

    public int getReceptor() {
        return receptor;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "[" + hora + "] " + texto;
    }
    
}
