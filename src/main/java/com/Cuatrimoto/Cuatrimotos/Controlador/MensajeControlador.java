/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Controlador;

import com.Cuatrimoto.Cuatrimotos.Modelo.Mensajes;
import com.Cuatrimoto.Cuatrimotos.Servicios.ServiciosMensaje;
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
 * Controlador que consume los servisio CRUD de la clase mensajes
 * @author Familia Parra Zambra
 */

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MensajeControlador {
    @Autowired
    private ServiciosMensaje servico;
    
    /**
     * metodo que permite visualizar los objetos mensajes
     * @return clase mensajes
     */
    @GetMapping("/all")
    public List<Mensajes> getMessages(){
        return servico.getAll();
    }

    /**
     * Metodo opcional para buscar mensajes por id 
     * @param messageId
     * @return objeto mensajes.
     */
    @GetMapping("/{id}")
    public Optional<Mensajes> getMessage(@PathVariable("id") int messageId) {
        return servico.getMessage(messageId);
    }

    /**
     * Metodo de guardado de objeto mensajes
     * @param mensajes
     * @return objeto mensajes
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes save(@RequestBody Mensajes message) {
        return servico.save(message);
    }
    
    /**
     * Metodo para actualizar el objeto message
     * @param message
     * @return nuevo objeto message
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes update(@RequestBody Mensajes mensaje) {
        return servico.update(mensaje);
    }

    /**
     * Metodo de borrado de objeto mensaje
     * @param messageId
     * @return true
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return servico.deleteMessage(messageId);
    }
}
