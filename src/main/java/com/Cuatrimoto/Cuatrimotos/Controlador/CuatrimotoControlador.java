/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuatrimoto.Cuatrimotos.Controlador;

import com.Cuatrimoto.Cuatrimotos.Modelo.Cuatrimoto;
import com.Cuatrimoto.Cuatrimotos.Servicios.ServiciosCuatrimoto;
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
 *
 * @author Familia Parra Zambra
 */

@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CuatrimotoControlador {
     @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo Tutoria";
    }

    @Autowired
    private ServiciosCuatrimoto servicio;
    @GetMapping("all")
    public List <Cuatrimoto> getCuatrimoto(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cuatrimoto> getOrthesis(@PathVariable("id") int idCuatrimoto) {
        return servicio.getCuatrimoto(idCuatrimoto);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cuatrimoto save(@RequestBody Cuatrimoto cuatrimoto) {
        return servicio.save(cuatrimoto);
    }
    
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cuatrimoto update(@RequestBody Cuatrimoto cuatrimoto) {
        return servicio.update(cuatrimoto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cuatrimotoId) {
        return servicio.deleteCuatrimoto(cuatrimotoId);
    }
 }
