/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Repositorio;

import com.Cuatrimoto.Cuatrimotos.Interface.InterfaceReservacion;
import com.Cuatrimoto.Cuatrimotos.Modelo.Mensajes;
import com.Cuatrimoto.Cuatrimotos.Modelo.Reservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Familia Parra Zambra
 */

@Repository
public class ReservacionRepositorio {
    @Autowired
    private InterfaceReservacion crud4;
    
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }
    
    public Optional<Reservacion> getReservation(int id){
        return crud4.findById(id);
    }
    
    public Reservacion save(Reservacion reservacion){
        return crud4.save(reservacion);
    }
    
    public void delete(Reservacion reservacion){
        crud4.delete(reservacion);
    }
}
