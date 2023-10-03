package com.salesianostriana.dam._EjemploDTO.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Monumento {

    @Id @GeneratedValue
    private Long id;

    private String codigoPais, pais, ciudad, loc, nombre, descripcion, urlImagen;

    @ManyToOne
    private Categoria categoria;
}
