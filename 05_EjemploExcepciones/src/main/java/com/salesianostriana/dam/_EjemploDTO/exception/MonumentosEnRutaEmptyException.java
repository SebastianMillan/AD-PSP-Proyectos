package com.salesianostriana.dam._EjemploDTO.exception;

public class MonumentosEnRutaEmptyException extends RuntimeException{

    public MonumentosEnRutaEmptyException(){super("La lista de monumentos de la ruta a crear no puede estar vacia");}

}
