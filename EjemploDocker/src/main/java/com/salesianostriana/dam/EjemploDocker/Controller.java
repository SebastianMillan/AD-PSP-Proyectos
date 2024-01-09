package com.salesianostriana.dam.EjemploDocker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hola")
    public void saludo(){
        System.out.println("Hola Mundo");
    }
}
