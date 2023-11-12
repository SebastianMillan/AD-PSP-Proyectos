package com.salesianostriana.dam.EjemploPage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Alumno {

    @Id
    private Long id;

    private String nombre, apellidos;
    private Double notaMedia;

    @ManyToOne
    private Instituto instituto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(id, alumno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
