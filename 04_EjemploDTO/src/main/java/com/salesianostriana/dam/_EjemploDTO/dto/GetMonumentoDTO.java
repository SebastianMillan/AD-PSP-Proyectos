package com.salesianostriana.dam._EjemploDTO.dto;

import com.salesianostriana.dam._EjemploDTO.model.Monumento;

public record GetMonumentoDTO(Long id, String nombre, String localizacion, String localidad, String imagen, String nombreCategoria) {

    public static GetMonumentoDTO of(Monumento monumento){
        return new GetMonumentoDTO(
                monumento.getId(),
                monumento.getNombre(),
                monumento.getLocalizacion(),
                monumento.getLocalidad(),
                monumento.getImagenes().isEmpty()?"https://place-hold.it/300":monumento.getImagenes().get(0),
                monumento.getCategoria()!=null? monumento.getCategoria().getNombre():"Sin Categoría"
        );
    }

}
