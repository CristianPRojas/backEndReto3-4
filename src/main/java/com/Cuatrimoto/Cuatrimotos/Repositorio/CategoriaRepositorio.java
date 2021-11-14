/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Repositorio;

import com.Cuatrimoto.Cuatrimotos.Interface.InterfaceCategoria;
import com.Cuatrimoto.Cuatrimotos.Modelo.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio con los metodos CRUD.
 * @author Familia Parra Zambra
 */
@Repository
public class CategoriaRepositorio {
    @Autowired
    private InterfaceCategoria crud2;
    
    /**
     * Metodo que retorna la la lista de categorias
     * @return la lista de categorias
     */
    public List<Categoria> getAll(){
        return (List<Categoria>) crud2.findAll();
    }
    
    /**
     * Metodo opcional que retorna un objeto categoria
     * recibe de parametro el id
     * @param id
     * @return el id del obejto crud 
     */
    public Optional<Categoria> getCategoria(int id){
        return crud2.findById(id);
    }
    
    /**
     * Metodo opcional que retorna un objeto categoria
     * recibe de parametro el id
     * @param categoria
     * @return Guarda el objeto cateforia.
     */
    public Categoria save(Categoria categoria){
        return crud2.save(categoria);
    }
    
    /**
     * Metodo para el borrado de categorias.
     * @param categoria 
     */
    public void delete(Categoria categoria){
        crud2.delete(categoria);
    }
}