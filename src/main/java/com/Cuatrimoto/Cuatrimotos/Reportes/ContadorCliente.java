/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Reportes;

import com.Cuatrimoto.Cuatrimotos.Modelo.Cliente;

/**
 *
 * @author Familia Parra Zambra
 */
public class ContadorCliente {
    private Long total;
    private Cliente client;
    
    /**
     * Contructor de los objetos
     * @param total
     * @param client 
     */
    public ContadorCliente(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
    
    /**
     * Metodo para obtener el total.
     * @return total
     */
    public Long getTotal() {
        return total;
    }
    
    /**
     * Metodo para modificar el total.
     * @param total 
     */
    public void setTotal(Long total) {
        this.total = total;
    }
    
    /**
     * Metodo para obtener el objeto cliente.
     * @return client
     */
    public Cliente getClient() {
        return client;
    }
    
    /**
     * Metodo para modificar el cliente. 
     * @param client 
     */
    public void setClient(Cliente client) {
        this.client = client;
    }    
}
