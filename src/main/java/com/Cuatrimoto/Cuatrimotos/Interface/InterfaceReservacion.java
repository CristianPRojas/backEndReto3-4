/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Interface;

import com.Cuatrimoto.Cuatrimotos.Modelo.Reservacion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Familia Parra Zambra
 */
public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer>{
    
}