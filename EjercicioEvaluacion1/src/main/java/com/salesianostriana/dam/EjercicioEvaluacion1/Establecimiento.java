package com.salesianostriana.dam.EjercicioEvaluacion1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Establecimiento {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, calle, ciudad, latitud, longitud, descripcion, urlImg;
    private ArrayList<String> tag;
}
