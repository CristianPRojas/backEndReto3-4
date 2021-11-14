/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "reservation")
public class Reservacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Cuatrimoto quadbike;
    
    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnoreProperties({"reservations","messages"})
    private Cliente client;
    
    private String score;

    /**
     * Metodo que retorna el idReservation
     * @return idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * Metodo para modificar el idReservation de la clase reservación
     * @param idReservation 
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     * Metodo que retorna la fecha incial de la clase reservación.
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Metodo para modificar la fecha incial de la clase reservación
     * @param startDate 
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Metodo que retorna la fecha de devolución de la clase reservación.
     * @return devolutionDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * Metodo para modificar la fecha de devolución de la clase reservación
     * @param devolutionDate 
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * Metodo que retorna el estatus de la clase reservación.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Metodo para modificar el estatus de la clase reservación
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Metodo que retorna el objeto quadbike de la clase reservación
     * @return quadbike
     */
    public Cuatrimoto getQuadbike() {
        return quadbike;
    }

    /**
     * Metodo que modifica el objeto quadbike de la clase reservación
     * @param quadbike 
     */
    public void setQuadbike(Cuatrimoto quadbike) {
        this.quadbike = quadbike;
    }

   /**
    * Metodo que retorna el objeto client de la clase reservación
    * @return client
    */
    public Cliente getClient() {
        return client;
    }

    /**
     * Metodo que modifica el objeto client de la clase reservación
     * @param client 
     */
    public void setClient(Cliente client) {
        this.client = client;
    }

    /**
     * Metodo que retorna el score de la clase reservación.
     * @return 
     */
    public String getScore() {
        return score;
    }

    /**
     *  Metodo para modificar el score de la clase reservación.
     * @param score 
     */
    public void setScore(String score) {
        this.score = score;
    }
    
    
    
}
