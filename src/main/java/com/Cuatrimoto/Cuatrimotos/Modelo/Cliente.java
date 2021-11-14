/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Familia Parra Zambra
 */

@Entity
@Table(name = "client")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Mensajes>messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Reservacion>reservations;

    /**
     * Metodo que retorna el idClient de la clase
     * @return idClient
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * Metodo para modificar el idClient de la clase Cliente
     * @param idClient 
     */
    public void setIdCliente(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * Metodo que retorna el name de la clase
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo para modificar el name de la clase Cliente
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que retorna el email de la clase Cliente
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo para modificar el email de la clase Cliente
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo que retorna el password de la clase Cliente
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo para modificar el password de la clase Cliente
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo que retorna la age de la clase Cliente
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Metodo para modificar la Age de la clase Cliente
     * @param Age 
     */
    public void setAge(Integer Age) {
        this.age = Age;
    }

    /**
     * Metodo que retorna el objeto mensaje de la clase Cliente
     * @return messages
     */
    public List<Mensajes> getMessages() {
        return messages;
    }

    /**
     * Metodo que modifica el objeto messages.
     * @param messages 
     */
    public void setMessages(List<Mensajes> messages) {
        this.messages = messages;
    }

    /**
     * Metodo que retorna el objeto el objeto reservations
     * @return reservations
     */
    public List<Reservacion> getReservations() {
        return reservations;
    }

    /**
     * Metodo que modifica el objeto reservations.
     * @param reservations 
     */
    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }

          
    
}
