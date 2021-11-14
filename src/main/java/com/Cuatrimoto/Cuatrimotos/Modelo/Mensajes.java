/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Familia Parra Zambra
 */

@Entity
@Table(name = "message")
public class Mensajes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cuatrimoto quadbike;
    
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cliente client;

    /**
     * Metodo que retorna el idMessage
     * @return idMessage
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     * Metodo que modifica el idMessage de la clase mensaje.
     * @param idMessage 
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * Metodo que retorna el messageText
     * @return messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * Metodo que modifica el messageText de la clase mensaje.
     * @param messageText 
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * Metodo que retorna el objeto quadbike.
     * @return quadbike
     */
    public Cuatrimoto getQuadbike() {
        return quadbike;
    }

    /**
     * Metodo que modifica el objeto quadbike.
     * @param quadbike 
     */
    public void setQuadbike(Cuatrimoto quadbike) {
        this.quadbike = quadbike;
    }

    /**
     * Metodo que retorna el objeto client.
     * @return client
     */
    public Cliente getClient() {
        return client;
    }

    /**
     * Metodo que modifica el objeto client.
     * @param client 
     */
    public void setClient(Cliente client) {
        this.client = client;
    }
    
    
}
