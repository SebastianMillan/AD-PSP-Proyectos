package com.salesianostriana.dam._EjemploDTO.dto;

import com.salesianostriana.dam._EjemploDTO.model.Monumento;

import java.util.List;

public record GetMonumentoDetailsDto(Long id, String nombre, String localizacion, String localidad, String codigoPais,
                                     String pais, String descripcion, List<String> imagenes, GetCategoriaDto categoria) {

    public static GetMonumentoDetailsDto of(Monumento monumento){
        return new GetMonumentoDetailsDto(
                monumento.getId(),
                monumento.getNombre(),
                monumento.getLocalizacion(),
                monumento.getCiudad(),
                monumento.getCodPais(),
                monumento.getPais(),
                monumento.getDescripcion(),
                monumento.getImagenes(),
                monumento.getCategoria()!=null?GetCategoriaDto.of(monumento.getCategoria()):null

        );
    }
}
