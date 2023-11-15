package com.salesianostriana.dam._EjemploDTO.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record EditRutaDto(
        @NotEmpty(message = "{rutaDto.nombre.notempty}")
        String nombre,
        int duracion,
        String dificultad,
        @NotEmpty(message="{rutaDto.monumentos.notempty}")
        List<Long> monumentos) {
}
