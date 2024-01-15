package com.salesianostriana.dam._UnitTest;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private double precio;
    private boolean disponible;

}