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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *Modelo de cuarimotos donde se definen los atributos y relaciones con las tablas de la base.
 * @author Familia Parra Zambra
 */

@Entity
@Table(name = "quadbike")
public class Cuatrimoto implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
   private String brand;
   private Integer year;
   private String description;
   
   @ManyToOne
   @JoinColumn(name="categoryid")
   @JsonIgnoreProperties("quadbikes")
   private Categoria category;
   
   @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike","client"})
    private List<Mensajes> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike","message"})
    public List<Reservacion> reservations;

    /**
     * Metodo que retorna el id de la clase.
     * @return el id de la clase quuadbike
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo para modificar el id de la clase quadbike
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo que retorna la brand de la clase quadbike
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Metodo para modificar la brand de la clase quadbike
     * @param brand 
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Metodo que retorna el year de la clase quadbike
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Metodo para modificar el year de la clase quadbike
     * @param year 
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     *  Metodo que retorna el name de la clase quadbike
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo para modificar el name de la clase quadbike
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que retorna la description de la clase quadbike
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo para modificar la description de la clase quadbike
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo que retorna el objeto categoria
     * @return category
     */
    public Categoria getCategory() {
        return category;
    }

    /**
     * Metodo para modificar el objeto categoria
     * @param category 
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     * Metodo que retorna el objeto messages
     * @return messages
     */
    public List<Mensajes> getMessages() {
        return messages;
    }

    /**
     * Metodo para modificar el objeto messages
     * @param messages 
     */
    public void setMessages(List<Mensajes> messages) {
        this.messages = messages;
    }

    /**
     * Metodo que retorna el objeto reservations
     * @return reservations
     */
    public List<Reservacion> getReservations() {
        return reservations;
    }

    /**
     * Metodo para modificar el objeto reservations
     * @param reservations 
     */
    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }   
}
