/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Repositorio;

import com.Cuatrimoto.Cuatrimotos.Interface.InterfaceCuatrimoto;
import com.Cuatrimoto.Cuatrimotos.Modelo.Cuatrimoto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Metodos CRUD para la clase Cuatrimoto
 * @author Familia Parra Zambra
 */

@Repository
public class CuatrimotoRepositorio {
    @Autowired
    private InterfaceCuatrimoto crud;
    
    /**
     * Retorna el id del objeto crud
     * @return Retorna el id del objeto crud
     */
    public List<Cuatrimoto> getAll(){
        return (List<Cuatrimoto>) crud.findAll();
    }
    
    /**
     * metodo opcional para busqueda por id de la clase cuatrimotos.
     * @param id
     * @return Retorna el id del objeto crud
     */
    public Optional<Cuatrimoto> getCuatrimoto(int id){
        return crud.findById(id);
    }
    
    /**
     * Metodo Guarda el onjeto cuatrimoto
     * @param cuatrimoto
     * @return guardado del objeto cuatrimoto
     */
    public Cuatrimoto save(Cuatrimoto cuatrimoto){
        return crud.save(cuatrimoto);
    }
    
    /**
     * Metodo para el borrado de objeto cuatrimoto
     * @param cuatrimoto 
     */
    public void delete(Cuatrimoto cuatrimoto){
        crud.delete(cuatrimoto);
    }
    
}
