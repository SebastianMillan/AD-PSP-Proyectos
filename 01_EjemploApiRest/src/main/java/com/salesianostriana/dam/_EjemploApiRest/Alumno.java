package com.salesianostriana.dam._EjemploApiRest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    private int id;
    private String nombre, apellidos, email;
    private int edad;
}
