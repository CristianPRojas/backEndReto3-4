/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Servicios;


import com.Cuatrimoto.Cuatrimotos.Modelo.Cliente;
import com.Cuatrimoto.Cuatrimotos.Repositorio.ClienteRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios CRUD de la clase Cliente
 * @author Familia Parra Zambra
 */

@Service
public class ServiciosCliente {
    @Autowired
    private ClienteRepositorio metodosCrud;
    
    /**
     * Metodo para mostrar los objetos cliente.
     * @return los objetos de metodosCrud
     */
    public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
    
    /**
     * Metodo opcional para busque de objetos
     * @param clientId
     * @return objeto metodosCrud
     */
    public Optional<Cliente> getCliente(int clientId){
        return metodosCrud.getCliente(clientId);
    }
    
    /**
     * Metodo para guardar el objeto cliente
     * @param cliente
     * @return objeto cliente
     */
    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> evt=metodosCrud.getCliente(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    
    /**
     * Metodo para actualizar el objeto cliente
     * @param cliente
     * @return objeto cliente actualizado
     */
     public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    /**
     * Metodo para borrado de objeto Cliente.
     * @param clientId
     * @return true.
     */
     public boolean deleteClient(int clientId) {
        Boolean aBoolean = getCliente(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
