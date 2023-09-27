package com.salesianostriana.dam._EjercicioAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, codPais, nombrePais, nombreCiudad, descripcion, imgURL;
    private int latitud, longitud;

}
