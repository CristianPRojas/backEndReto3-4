//1. Modelo
//2. Interface
//3. Repositorio
//4. Servicios
//5. Controlador o Web

package com.Cuatrimoto.Cuatrimotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Aplicación firts code mediante la cual se gestiona el back en en de la aplicación de cuatrimotos propuesto en el reto 3 de misión tic
 * @author Familia Parra Zambra
 */
@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.Cuatrimoto.Cuatrimotos.Modelo"})

/**
 * Inicio del proyecto en springboot.
 * Cargo de los modelos y los servicios.
 */
public class CuatrimotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuatrimotosApplication.class, args);
	}

}
