/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Servicios;

import com.Cuatrimoto.Cuatrimotos.Modelo.Cuatrimoto;
import com.Cuatrimoto.Cuatrimotos.Repositorio.CuatrimotoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios CRUD de la clase Cuatrimoto
 * @author Familia Parra Zambra
 */

@Service
public class ServiciosCuatrimoto {
    @Autowired
    private CuatrimotoRepositorio metodosCrud;
    
    /**
     * Metodo para mostrar los objetos Cuatrimoto.
     * @return los objetos de metodosCrud
     */    
    public List<Cuatrimoto> getAll(){
        return metodosCrud.getAll();
    }
    
    /**
     * Metodo opcional para busque de objetos
     * @param idCuatrimoto
     * @return objeto metodosCrud
     */
    public Optional<Cuatrimoto> getCuatrimoto(int idCuatrimoto){
        return metodosCrud.getCuatrimoto(idCuatrimoto);
    }
    
    /**
     * Metodo para guardar el objeto cuatrimoto
     * @param cuatrimoto
     * @return objeto cuatrimoto
     */
    public Cuatrimoto save(Cuatrimoto cuatrimoto){
        if(cuatrimoto.getId()==null){
            return metodosCrud.save(cuatrimoto);
        }else{
            Optional<Cuatrimoto> evt=metodosCrud.getCuatrimoto(cuatrimoto.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(cuatrimoto);
            }else{
                return cuatrimoto;
            }
        }
    }
    

    /**
     * Metodo para actualizar el objeto cuatrimoto
     * @param cuatrimoto
     * @return objeto cuatrimoto actualizado
     */
    public Cuatrimoto update(Cuatrimoto cuatrimoto){
        if(cuatrimoto.getId()!=null){
            Optional<Cuatrimoto> e=metodosCrud.getCuatrimoto(cuatrimoto.getId());
            if(!e.isEmpty()){
                if(cuatrimoto.getBrand()!=null){
                    e.get().setBrand(cuatrimoto.getBrand());
                }
                if(cuatrimoto.getYear()!=null){
                    e.get().setYear(cuatrimoto.getYear());
                }
                if(cuatrimoto.getName()!=null){
                    e.get().setName(cuatrimoto.getName());
                }
                if(cuatrimoto.getDescription()!=null){
                    e.get().setDescription(cuatrimoto.getDescription());
                }
                if(cuatrimoto.getCategory()!=null){
                    e.get().setCategory(cuatrimoto.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cuatrimoto;
            }
        }else{
            return cuatrimoto;
        }
    }
    
    /**
     * Metodo para borrado de objeto cuatrimoto.
     * @param cuatrimotoId
     * @return true.
     */
    public boolean deleteCuatrimoto(int cuatrimotoId) {
        Boolean aBoolean = getCuatrimoto(cuatrimotoId).map(cuatrimoto -> {
            metodosCrud.delete(cuatrimoto);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
