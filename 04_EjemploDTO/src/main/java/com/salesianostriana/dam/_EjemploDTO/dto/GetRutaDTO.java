package com.salesianostriana.dam._EjemploDTO.dto;

import com.salesianostriana.dam._EjemploDTO.model.Ruta;

import java.util.List;

public record GetRutaDTO(Long id, String nombre, String dificultad, String tiempo, List<GetMonumentoDTO> monumentos) {
    public static GetRutaDTO of(Ruta ruta){
        return new GetRutaDTO(
                ruta.getId(),
                ruta.getNombre(),
                ruta.getDificultad().name(),
                //Se puede usar TimeUnit para transformar String de minutos a int
                Integer.toString(ruta.getTiempo()),
                ruta.getLista().stream()
                        .map(GetMonumentoDTO::of)
                        .toList()
        );
    }
}
