/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Interface;

import com.Cuatrimoto.Cuatrimotos.Modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Familia Parra Zambra
 */
public interface InterfaceCategoria extends CrudRepository<Categoria,Integer>{
    
}