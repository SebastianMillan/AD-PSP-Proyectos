package com.salesianostriana.dam._EjemploDTO.dto;

import java.util.List;

public record EditRutaDto(String nombre, int duracion, String dificultad, List<Long> monumentos) {
}
