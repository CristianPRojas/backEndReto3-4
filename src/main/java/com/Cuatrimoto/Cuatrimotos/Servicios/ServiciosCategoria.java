/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Servicios;

import com.Cuatrimoto.Cuatrimotos.Modelo.Categoria;
import com.Cuatrimoto.Cuatrimotos.Repositorio.CategoriaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios CRUD de la clase categoria
 * @author Familia Parra Zambra
 */

@Service
public class ServiciosCategoria {
    @Autowired
    private CategoriaRepositorio metodosCrud;
    
    /**
     * Metodo para mostrar los objetos categoria.
     * @return los objetos de metodosCrud
     */
    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }
    
    /**
     * Metodo opcional para busque de objetos
     * @param idCategoria
     * @return objeto metodosCrud
     */
    public Optional<Categoria> getCategoria(int idCategoria){
        return metodosCrud.getCategoria(idCategoria);
    }
    
    /**
     * Metodo para guardar el objeto categoria
     * @param categoria
     * @return objeto categoria
     */
    public Categoria save(Categoria categoria){
        if(categoria.getId() == null){
            return metodosCrud.save(categoria);
        }else{
            Optional<Categoria> evt = metodosCrud.getCategoria(categoria.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(categoria);
            }else{
                return categoria;
            }
        }
    }
    
    
    /**
     * Metodo para actualizar el objeto categoria
     * @param categoria
     * @return objeto categoria actualizado
     */
    public Categoria update (Categoria categoria){
        if (categoria.getId() != null){
            Optional<Categoria>g = metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription() != null){
                    g.get().setDescription(categoria.getDescription());                  
                }if(categoria.getName() != null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    
    /**
     * Metodo para borrado de objeto categoria.
     * @param categoriaId
     * @return true.
     */
    public boolean deleteCategoria(int categoriaId){
        Boolean d = getCategoria(categoriaId).map(categoria ->{
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;    
    }
}
