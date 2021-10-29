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

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.Cuatrimoto.Cuatrimotos.Modelo"})
public class CuatrimotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuatrimotosApplication.class, args);
	}

}
