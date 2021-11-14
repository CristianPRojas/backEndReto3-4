/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Reportes;

/**
 *
 * @author Familia Parra Zambra
 */
public class StatusReservas {
    private int completed;
    private int cancelled;
    
    /**
     * Constructor de los objetos completados y cancelados.
     * @param completed
     * @param cancelled 
     */
    public StatusReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
    
    /**
     * Metodo que retorna el objeto completado.
     * @return 
     */
    public int getCompleted() {
        return completed;
    }
    
    /**
     * Metodo para modificar el objeto completado.
     * @param completed 
     */
    public void setCompleted(int completed) {
        this.completed = completed;
    }
    
    /**
     * Metodo que retorna el objeto cancelado.
     * @return cancelled
     */
    public int getCancelled() {
        return cancelled;
    }
    
    /**
     * Metodo para modificar el objeto cancelado.
     * @param cancelled 
     */
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
