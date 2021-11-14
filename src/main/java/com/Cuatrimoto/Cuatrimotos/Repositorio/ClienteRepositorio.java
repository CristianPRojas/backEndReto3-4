/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Repositorio;

import com.Cuatrimoto.Cuatrimotos.Interface.InterfaceCliente;
import com.Cuatrimoto.Cuatrimotos.Modelo.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio con los metodos CRUD.
 * @author Familia Parra Zambra
 */
@Repository
public class ClienteRepositorio {
    @Autowired
    private InterfaceCliente crud1;
    

    /**
     * retorna la lista clientes
     * @return id del objeto crud1.
     */
    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();       
    }
    
    /**
     * Busqueda de opcional de clientes por id
     * @param id
     * @return objeto crud1.
     */
    public Optional <Cliente> getCliente(int id){
        return crud1.findById(id);
    }
    
    /**
     * Recibe el metodo de guardado del objeto cliente.
     * @param cliente
     * @return objeto crud1 guardado
     */
    public Cliente save(Cliente cliente){
        return crud1.save(cliente);
    }
    
    /**
     * Metodo para borrar el objeto cliente.
     * @param cliente 
     */
    public void delete(Cliente cliente){
        crud1.delete(cliente);
    }

}
