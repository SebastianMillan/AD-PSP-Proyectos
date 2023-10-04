package com.salesianostriana.dam.EjercicioDTOPareja.dto;

import com.salesianostriana.dam.EjercicioDTOPareja.model.Producto;
import lombok.Builder;

@Builder
public record GetProductoDto(String nombre, Double pvp, String imagen, String categoria) {

    public static GetProductoDto of(Producto producto){
        return GetProductoDto.builder()
                .nombre(producto.getNombre())
                .pvp(producto.getPvp())
                .imagen(producto.getImagenes().get(0))
                .categoria(producto.getCategoria().getNombre())
                .build();
    }
}
