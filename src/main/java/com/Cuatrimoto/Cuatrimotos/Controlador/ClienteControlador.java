/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Controlador;

import com.Cuatrimoto.Cuatrimotos.Modelo.Cliente;
import com.Cuatrimoto.Cuatrimotos.Servicios.ServiciosCliente;
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
 * Controlador que consume los servisio CRUD de la clase Cliente
 * @author Familia Parra Zambra
 */

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClienteControlador {
    @Autowired
    private ServiciosCliente servicios;
    
    /**
     * metodo que permite visualizar los objetos Cliente
     * @return clase Cliente
     */
    @GetMapping("/all")
    public List <Cliente> getCliente(){
        return servicios.getAll();
    }
    
    /**
     * Metodo opcional para buscar cliente por id 
     * @param clientid
     * @return objeto cliente.
     */
    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") int clientid) {
        return servicios.getCliente(clientid);
    }

    /**
     * Metodo de guardado de objeto cliente
     * @param cliente
     * @return objeto cliente
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        return servicios.save(cliente);
    }
    
    /**
     * Metodo para actualizar el objeto cliente
     * @param cliente
     * @return nuevo objeto cliente
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente) {
        return servicios.update(cliente);
    }

    /**
     * Metodo de borrado de objeto cliente
     * @param clienteId
     * @return true
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clienteId) {
        return servicios.deleteClient(clienteId);
    }
}
