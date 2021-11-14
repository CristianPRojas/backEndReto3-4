/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Servicios;

import com.Cuatrimoto.Cuatrimotos.Modelo.Reservacion;
import com.Cuatrimoto.Cuatrimotos.Reportes.ContadorCliente;
import com.Cuatrimoto.Cuatrimotos.Reportes.StatusReservas;
import com.Cuatrimoto.Cuatrimotos.Repositorio.ReservacionRepositorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios CRUD de la clase Reservación
 * @author Familia Parra Zambra
 */

@Service
public class ServiciosReservacion {
    @Autowired
    private ReservacionRepositorio metodosCrud;
    
    /**
     * Metodo para mostrar los objetos Reservación.
     * @return los objetos de metodosCrud
     */ 
    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }

    /**
     * Metodo opcional para busque de objetos
     * @param reservationId
     * @return objeto metodosCrud
     */
    public Optional<Reservacion> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    /**
     * Metodo para guardar el objeto reservation
     * @param reservation
     * @return objeto reservation
     */
    public Reservacion save(Reservacion reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservacion> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    /**
     * Metodo para actualizar el objeto reservacion
     * @param reservacion
     * @return objeto reservacion actualizado
     */
    public Reservacion update(Reservacion reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservacion> e= metodosCrud.getReservation(reservacion.getIdReservation());
            if(!e.isEmpty()){

                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());
                }
                if(reservacion.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if(reservacion.getStatus()!=null){
                    e.get().setStatus(reservacion.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservacion;
            }
        }else{
            return reservacion;
        }
    }

    /**
     * Metodo para borrado de objeto reservacion.
     * @param reservationId
     * @return true.
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    /**
     * Metodo que retorna el estado de las reservas
     * @return Reporte de reserva.
     */
    public StatusReservas reporteStatusServicio(){
        
        List<Reservacion> completed = metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservacion>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(),cancelled.size());
    }
    
    /**
     * Metodo que muestra las reservas en un determinado plazo de tiempo.
     * @param datoA
     * @param datoB
     * @return Reservas en un plazo de tiempo
     */
    public List<Reservacion> reporteTiempoServicio(String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }
    
    /**
     * Metod que retorna el listado de clientes con mas cantidad de reservas.
     * @return reporte de clientes con mayot cantidad de resevas.
     */
    public List<ContadorCliente> reporteClientesServicio(){
        return metodosCrud.getClientesRepositorio();
    }
}
