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
 *
 * @author Familia Parra Zambra
 */

@Repository
public class MensajeRepositorio {
    @Autowired
    private InterfaceMensaje crud3;
    
    public List<Mensajes> getAll(){
        return (List<Mensajes>) crud3.findAll();
    }
    
    public Optional<Mensajes> getMessage(int id){
        return crud3.findById(id);
    }
    
    public Mensajes save(Mensajes mensajes){
        return crud3.save(mensajes);
    }
    
    public void delete(Mensajes mensajes){
        crud3.delete(mensajes);
    }
}
