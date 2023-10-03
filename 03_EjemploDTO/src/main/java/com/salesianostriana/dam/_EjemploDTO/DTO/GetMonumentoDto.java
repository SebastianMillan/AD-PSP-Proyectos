package com.salesianostriana.dam._EjemploDTO.DTO;

import com.salesianostriana.dam._EjemploDTO.Model.Monumento;
import lombok.Builder;
import lombok.Value;

//@Value -> anota el hashCode / equals pero el record ya lo trae
@Builder
public record GetMonumentoDto (Long id, String nombre, String localizacion, String urlFoto, String nombreCategoria){

    public static GetMonumentoDto of(Monumento monumento){
        return GetMonumentoDto.builder()
                .id(monumento.getId())
                .nombre(monumento.getNombre())
                .localizacion(monumento.getLoc())
                .urlFoto(monumento.getUrlImagen())
                .nombreCategoria(monumento.getCategoria()!=null?monumento.getCategoria().getNombre():"Sin Categoría")
                .build();
    }
}
