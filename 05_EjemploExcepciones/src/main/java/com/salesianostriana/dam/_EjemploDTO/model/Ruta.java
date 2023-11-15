package com.salesianostriana.dam._EjemploDTO.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ruta {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

    @ManyToMany
    private List<Monumento> lista;
    private int tiempo; // En minutos
}
