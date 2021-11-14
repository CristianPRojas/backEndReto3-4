/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Interface;

import com.Cuatrimoto.Cuatrimotos.Modelo.Reservacion;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface que hereda el CrudRepository de springboot
 * @author Familia Parra Zambra
 */
public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer>{
    public List<Reservacion> findAllByStatus (String status);
    
    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    //SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    
    @Query ("SELECT c.client, COUNT(c.client) FROM Reservacion as c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
