/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Interface;

import com.Cuatrimoto.Cuatrimotos.Modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface que hereda el CrudRepository de springboot
 * @author Familia Parra Zambra
 */
public interface InterfaceCategoria extends CrudRepository<Categoria,Integer>{
    
}
