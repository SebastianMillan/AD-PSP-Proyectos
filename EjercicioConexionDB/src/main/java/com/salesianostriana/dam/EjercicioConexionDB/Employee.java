package com.salesianostriana.dam.EjercicioConexionDB;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, apellidos;
    private int edad;
}
