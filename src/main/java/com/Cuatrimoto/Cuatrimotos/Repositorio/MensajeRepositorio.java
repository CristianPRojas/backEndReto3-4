/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Repositorio;

import com.Cuatrimoto.Cuatrimotos.Interface.InterfaceMensaje;
import com.Cuatrimoto.Cuatrimotos.Modelo.Mensajes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de consultar CRUD de la clase Mensaje.
 * @author Familia Parra Zambra
 */

@Repository
public class MensajeRepositorio {
    @Autowired
    private InterfaceMensaje crud3;
    
    /**
     * Retorna el id del objeto crud3
     * @return Retorna el id del objeto crud
     */
    public List<Mensajes> getAll(){
        return (List<Mensajes>) crud3.findAll();
    }
    
    /**
     * metodo opcional para busqueda por id de la clase Message.
     * @param id
     * @return Retorna el id del objeto crud3
     */
    public Optional<Mensajes> getMessage(int id){
        return crud3.findById(id);
    }
    
    /**
     * Metodo Guarda el onjeto mensajes
     * @param mensajes.
     * @return guardado del objeto mensajes
     */
    public Mensajes save(Mensajes mensajes){
        return crud3.save(mensajes);
    }
    
    /**
     * Metodo para el borrado de objeto mensajes
     * @param mensajes 
     */
    public void delete(Mensajes mensajes){
        crud3.delete(mensajes);
    }
}
