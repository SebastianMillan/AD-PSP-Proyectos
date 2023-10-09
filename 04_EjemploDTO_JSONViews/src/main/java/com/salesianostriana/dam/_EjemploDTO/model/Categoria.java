package com.salesianostriana.dam._EjemploDTO.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam._EjemploDTO.views.CategoriaView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Categoria {

    @Id
    @GeneratedValue
    @JsonView(CategoriaView.class)
    private Long id;

    @JsonView(CategoriaView.class)
    private String nombre;

}
