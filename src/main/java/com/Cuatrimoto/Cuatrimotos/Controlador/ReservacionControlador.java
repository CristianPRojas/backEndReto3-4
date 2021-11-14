/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Controlador;

import com.Cuatrimoto.Cuatrimotos.Modelo.Reservacion;
import com.Cuatrimoto.Cuatrimotos.Reportes.ContadorCliente;
import com.Cuatrimoto.Cuatrimotos.Reportes.StatusReservas;
import com.Cuatrimoto.Cuatrimotos.Servicios.ServiciosReservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que consume los servisio CRUD de la clase reservación
 * @author Familia Parra Zambra
 */

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservacionControlador {
    @Autowired
    private ServiciosReservacion servicio;
    
    /**
     * metodo que permite visualizar los objetos reservación
     * @return clase reservación
     */
    @GetMapping("/all")
    public List<Reservacion> getReservations(){
        return servicio.getAll();
    }

    /**
     * Metodo opcional para buscar reservación por id 
     * @param reservationId
     * @return objeto reservación.
     */
    @GetMapping("/{id}")
    public Optional<Reservacion> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }
    
    /**
     * Metodo de guardado de objeto reservación
     * @param reservación
     * @return objeto reservación
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reservation) {
        return servicio.save(reservation);
    }
    
    /**
     * Metodo para actualizar el objeto reservation
     * @param reservation
     * @return nuevo objeto reservation
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion update(@RequestBody Reservacion reservacion) {
        return servicio.update(reservacion);
    }
    
    /**
     * Metodo de borrado de objeto reservacion
     * @param reservationId
     * @return true
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }
    
    /**
     * Permite visualizar el reporte de estados.
     * @return Reporte de estatus de servicio.
     */
    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return servicio.reporteStatusServicio();
    }
    
    /**
     * Metodo para el estado de las reservaciones en un intervalo de tiempo.
     * @param dateOne
     * @param dateTwo
     * @return 
     */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
     public List<Reservacion> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
         return servicio.reporteTiempoServicio(dateOne, dateTwo);
     }
     
     /**
      * Metodo para visualizar los clientes y sus reservas de mayor a menor.
      * @return 
      */
     @GetMapping("/report-clients")
     public List<ContadorCliente> getClientes(){
         return servicio.reporteClientesServicio();
     }
}
