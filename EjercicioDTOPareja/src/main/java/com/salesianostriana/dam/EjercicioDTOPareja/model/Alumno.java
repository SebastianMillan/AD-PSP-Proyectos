package com.salesianostriana.dam.EjercicioDTOPareja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alumno {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, apellido1, apellido2, telefono, email;

    @ManyToOne
    private Direccion direccion;

    @ManyToOne
    private Curso curso;
}
