/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Repositorio;

import com.Cuatrimoto.Cuatrimotos.Interface.InterfaceReservacion;
import com.Cuatrimoto.Cuatrimotos.Modelo.Cliente;
import com.Cuatrimoto.Cuatrimotos.Modelo.Mensajes;
import com.Cuatrimoto.Cuatrimotos.Modelo.Reservacion;
import com.Cuatrimoto.Cuatrimotos.Reportes.ContadorCliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de consultar CRUD de la clase Reservación.
 * @author Familia Parra Zambra
 */

@Repository
public class ReservacionRepositorio {
    @Autowired
    private InterfaceReservacion crud4;
    
    /**
     * Retorna el id del objeto crud4
     * @return Retorna el id del objeto crud4
     */
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }
    
    /**
     * metodo opcional para busqueda por id de la clase Reservation.
     * @param id
     * @return Retorna el id del objeto crud3
     */
    public Optional<Reservacion> getReservation(int id){
        return crud4.findById(id);
    }
    
    /**
     * Metodo Guarda el onjeto reservacion
     * @param reservacion.
     * @return guardado del objeto reservacion
     */
    public Reservacion save(Reservacion reservacion){
        return crud4.save(reservacion);
    }
    
    /**
     * Metodo para el borrado de objeto reservacion
     * @param reservacion 
     */
    public void delete(Reservacion reservacion){
        crud4.delete(reservacion);
    }
    
    public List<Reservacion> ReservacionStatusRepositorio (String status){
         return crud4.findAllByStatus(status);
     }
    
    public List<Reservacion> ReservacionTiempoRepositorio (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
    
    public List<ContadorCliente> getClientesRepositorio(){
         List<ContadorCliente> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorCliente((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
         }
         return res;
     }
}
