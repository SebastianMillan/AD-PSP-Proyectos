package com.salesianostriana.dam.EjercicioDTOPareja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue
    Long id;

    private String nombre, descripcion;

    private double pvp;

    private List<String> imagenes;

    @ManyToOne
    private Categoria categoria;
}
