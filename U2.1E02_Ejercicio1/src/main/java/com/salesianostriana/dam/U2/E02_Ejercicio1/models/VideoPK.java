package com.salesianostriana.dam.U2.E02_Ejercicio1.models;

import com.salesianostriana.dam.U2.E02_Ejercicio1.models.CursoOnline;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class VideoPK implements Serializable {

    private CursoOnline cursoOnline;
    private Long id;

    private VideoPK(){}
}
