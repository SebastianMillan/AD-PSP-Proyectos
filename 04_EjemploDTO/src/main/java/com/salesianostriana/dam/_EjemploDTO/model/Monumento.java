package com.salesianostriana.dam._EjemploDTO.model;

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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, codPais, direccion, localidad, localizacion;
    //@ElementCollection -> Obligaroio en Spring Boot 2
    private List<String> imagenes;

    @ManyToOne
    private Categoria categoria;

}
