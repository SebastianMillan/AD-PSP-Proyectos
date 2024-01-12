package com.salesianostriana.dam._UnitTest;

public record GetProductoDto(Long id, String nombre) {
    public static GetProductoDto of (Producto p){
        return new GetProductoDto(p.getId(), p.getNombre());
    }
}
