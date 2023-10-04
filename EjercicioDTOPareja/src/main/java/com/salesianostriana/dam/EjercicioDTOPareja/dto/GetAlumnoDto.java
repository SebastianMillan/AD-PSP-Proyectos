package com.salesianostriana.dam.EjercicioDTOPareja.dto;

import com.salesianostriana.dam.EjercicioDTOPareja.model.Alumno;
import com.salesianostriana.dam.EjercicioDTOPareja.model.Curso;
import com.salesianostriana.dam.EjercicioDTOPareja.model.Direccion;
import lombok.Builder;

@Builder
public record GetAlumnoDto(String nombre, String apellidos, String email, Curso curso, Direccion direccion) {

    public static GetAlumnoDto of(Alumno alumno){
        return GetAlumnoDto.builder()
                .nombre(alumno.getNombre())
                .apellidos(alumno.getApellido1()+" "+ alumno.getApellido2())
                .email(alumno.getEmail())
                .curso(alumno.getCurso())
                .direccion(alumno.getDireccion())
                .build();
    }
}
