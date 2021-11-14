/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Servicios;

import com.Cuatrimoto.Cuatrimotos.Modelo.Mensajes;
import com.Cuatrimoto.Cuatrimotos.Repositorio.MensajeRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios CRUD de la clase mensaje
 * @author Familia Parra Zambra
 */

@Service
public class ServiciosMensaje {
    @Autowired
    private MensajeRepositorio metodosCrud;
    
    /**
     * Metodo para mostrar los objetos Mensajes.
     * @return los objetos de metodosCrud
     */ 
    public List<Mensajes> getAll(){
        return metodosCrud.getAll();
    }

    /**
     * Metodo opcional para busque de objetos
     * @param messageId
     * @return objeto metodosCrud
     */
    public Optional<Mensajes> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }
    
    /**
     * Metodo para guardar el objeto message
     * @param message
     * @return objeto message
     */
    public Mensajes save(Mensajes message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensajes> evt= metodosCrud.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
    
     /**
     * Metodo para actualizar el objeto message
     * @param message
     * @return objeto message actualizado
     */
    public Mensajes update(Mensajes message){
        if(message.getIdMessage()!=null){
            Optional<Mensajes> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    /**
     * Metodo para borrado de objeto message.
     * @param messageId
     * @return true.
     */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
