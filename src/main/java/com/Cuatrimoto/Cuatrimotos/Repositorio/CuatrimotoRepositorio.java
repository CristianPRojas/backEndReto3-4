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
 *
 * @author Familia Parra Zambra
 */

@Repository
public class CuatrimotoRepositorio {
    @Autowired
    private InterfaceCuatrimoto crud;
    
    public List<Cuatrimoto> getAll(){
        return (List<Cuatrimoto>) crud.findAll();
    }
    
    public Optional<Cuatrimoto> getCuatrimoto(int id){
        return crud.findById(id);
    }
    
    public Cuatrimoto save(Cuatrimoto cuatrimoto){
        return crud.save(cuatrimoto);
    }
    
    public void delete(Cuatrimoto cuatrimoto){
        crud.delete(cuatrimoto);
    }
    
}
