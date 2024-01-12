package com.salesianostriana.dam._UnitTest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private double precio;
    private boolean disponible;

}