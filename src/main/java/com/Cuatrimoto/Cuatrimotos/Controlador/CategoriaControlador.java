/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Controlador;

import com.Cuatrimoto.Cuatrimotos.Modelo.Categoria;
import com.Cuatrimoto.Cuatrimotos.Servicios.ServiciosCategoria;
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
 * Controlador que consume los servisio CRUD de la clase categoria
 * @author Familia Parra Zambra
 */

@RestController
@RequestMapping("api/Category")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoriaControlador {
    @Autowired
    private ServiciosCategoria servicios;
    /**
     * metodo que permite visualizar los objetos categoria
     * @return clase categoria
     */
    @GetMapping("/all")
    public List<Categoria> getCategoria(){
        return servicios.getAll();
    }
    
    /**
     * Metodo opcional para buscar categorias por id 
     * @param idCategoria
     * @return objeto categoria.
     */
    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") int idCategoria) {
        return servicios.getCategoria(idCategoria);
    }
    
    /**
     * Metodo de guardado de objeto categorias
     * @param categoria
     * @return objeto categoria
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria) {
        return servicios.save(categoria);
    }
    
    /**
     * Metodo para actualizar el objeto categoria
     * @param categoria
     * @return nuevo objeto categoria
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria) {
        return servicios.update(categoria);
    }
    
    /**
     * Metodo de borrado de objeto categoria
     * @param categoriaId
     * @return true
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return servicios.deleteCategoria(categoriaId);
    }
}
