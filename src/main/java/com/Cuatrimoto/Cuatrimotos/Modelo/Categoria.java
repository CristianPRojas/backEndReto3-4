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
 *Modelo de categoria donde se definen los atributos y relaciones con las tablas de la base.
 * @author Familia Parra Zambra
 */

@Entity
@Table(name = "category")
public class Categoria implements Serializable{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties({"category","message"})
    private List<Cuatrimoto> quadbikes;

    /**
     * Metodo que retorna el id de la clase.
     * @return el id de la clase Category
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo para modificar el id de la clase Category
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Metodo que retorna el name de la clase.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo para modificar el name de la clase Category
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que retorna la description de la clase.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Metodo para modificar la description de la clase Category
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo que retornael objeto quadbikes.
     * @return quadbikes
     */
    public List<Cuatrimoto> getQuadbikes() {
        return quadbikes;
    }
    
    /**
     *  Metodo para modificar el objeto quadbikes
     * @param quadbikes 
     */
    public void setQuadbike(List<Cuatrimoto> quadbikes) {
        this.quadbikes = quadbikes;
    }
    
    
}