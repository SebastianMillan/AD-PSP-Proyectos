package com.salesianostriana.dam._EjemploApiRest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Alumno {

    private int id;
    private String nombre, apellidos, email;
    private int edad;
}
